/**
 * sekiguchi
 */


// 更新ボタン用
$('[name=updateBtn]').click(function (e) {
	// パラメータ用エレメントを作成
	param = document.createElement('input');
	param.setAttribute('type', 'hidden');
	param.setAttribute('name', 'updateId');
	param.setAttribute('id',   'updateId');
	param.setAttribute('value', $(this).attr('forUpdate'));

	// update メソッドを実行するための要素を生成
	var btn = document.createElement('input');
	btn.setAttribute('type', 'hidden');
	btn.setAttribute('name', 'method:update');
	btn.setAttribute('value', "1");

	var form = document.forms[0];
	// 前に作ったパラメータ用エレメントあったら消す（戻るボタン対策）
	var oldParam = document.getElementById('updateId');
	if (oldParam != undefined && oldParam != null) {
		form.removeChild(oldParam);
	}
	form.appendChild(param);
	form.appendChild(btn);
	form.submit();
});



//メッセージの表示 ふわっと出てふわっと消える
$(function() {
	$('.message').fadeIn(1000).delay(2000).fadeOut(2000);
});

//エラーメッセージの表示 ふわっとでる
$(function() {
	$('.errorMessage').fadeIn(1000);
});


//* 削除ボタンが逃げる*/

/**
 * jDTRunAway
 *
 * @version      $Rev$
 * @author       nori (http://twitter.com/5509)
 * @copyright    (c) 2010 誰が使うの？何の役にも立たないjQueryプラグイン
 * @license      The MIT License
 * @link         http://jdtplugins.googlecode.com/svn/trunk/jdtlightbox/index.html
 *
 * $Date$
 */
(function($) {

  var mouseX, mouseY, dE = document.documentElement;

  $.fn.jdtRunAway = function(options) {

    var c = $.extend({
      rate: 60,
      instance: 4000
    }, options);

    $(document)
      .mousemove(function(e) {
        mouseY = e.pageY ? e.pageY : event.clientY + dE.scrollTop;
        mouseX = e.pageX ? e.pageX : event.clientX + dE.scrollLeft;
      })
      .keydown(function(e) {
        if ( e.keyCode == 9 ) {
          alert('Tabキーは使えません！');
          return false;
        }
      });

    $(this).each(function() {
      mover(this, c.instance, c.rate);
    });
  }

  function mover(selector, instance, rate) {
    var firstPointX = [],
      firstPointY = [];

    // offsetの保存
    $(selector).each(function(index) {
      var offset = $(this).offset();
      firstPointX[index] = offset.left;
      firstPointY[index] = offset.top;

      $(this).after($('<span/>')
        .css({
          display: 'inline-block',
          width: $(this).width()
        })
      );
    });

    var $this = $(selector);

    (function(){
      $this.each(function(index) {
        var elem = $(this),
          offset = elem.offset(),
          theta = Math.atan2(offset.top - mouseY, offset.left - mouseX),
          d = instance / Math.sqrt(Math.pow(mouseX - offset.left, 2) + Math.pow(mouseY - offset.top, 2)),
          left = parseInt(offset.left) + d * Math.cos(theta) + (firstPointX[index] - offset.left) * 0.1,
          top = parseInt(offset.top) + d * Math.sin(theta) + (firstPointY[index] - offset.top) * 0.1;

        if ( !isNaN(top) && !isNaN(left) ) {
          elem.css({
            left: left,
            top: top
          });
        } else {
          elem.css('position', 'absolute');
        }
      });
      setTimeout(arguments.callee, rate);
    })();
  }
})(jQuery)

jQuery(function($) {
  $('h3').jdtRunAway();
});




