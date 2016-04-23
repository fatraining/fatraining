/**
 * harasan...
 */

/**
 * 星を表示する。
 * これの前に必ずjquery.js、jquery.raty.jsの二つを読み込んでおくこと
 */
$(function(){
	$('div.stars').each(function() {
		var starsDiv = $(this);
		starsDiv.raty({
			number    : 5,
			score     : starsDiv.attr('value'),
			path      : 'assets/libs/raty/images/',
			scoreName : 'stars'
		});
	});
	$('div.stars-readOnly').each(function() {
		var starsDiv = $(this);
		starsDiv.raty({
			number   : 5,
			score    : starsDiv.attr('value'),
			readOnly : true,
			path     : 'assets/libs/raty/images/'
		});
	});
	// 更新ボタン用
	$('[name=updateBtn]').click(function (e) {
		// パラメータ用エレメントを作成
		var param = document.createElement('input');
		param.setAttribute('type', 'hidden');
		param.setAttribute('name', 'updateId');
		param.setAttribute('value', $(this).attr('forUpdate'));

		// update メソッドを実行するための要素を生成
		var btn = document.createElement('input');
		btn.setAttribute('type', 'hidden');
		btn.setAttribute('name', 'method:update');
		btn.setAttribute('value', "1");

		var form = document.forms[0];
		form.appendChild(param);
		form.appendChild(btn);
		form.submit();
	});

	// 削除ボタン用
//	$('#deleteBtn').click(function (e) {
//		var check = $('[name=delete]:checked').map(function () {
//			return $(this).val();
//		}).get();
//
//		// パラメータ用エレメントを作成
//		var param = document.createElement('input');
//		param.setAttribute('type', 'hidden');
//		param.setAttribute('name', 'delete');
//		param.setAttribute('value', check.toString());
//
//		// delete メソッドを実行するための要素を生成
//		var btn = document.createElement('input');
//		btn.setAttribute('type', 'hidden');
//		btn.setAttribute('name', 'method:delete');
//		btn.setAttribute('value', "1");
//
//		var form = document.forms[0];
//		form.appendChild(param);
//		form.appendChild(btn);
//		form.submit();
//	});
});
