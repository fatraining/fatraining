

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
	$('.errorMessage').fadeIn(1000).delay(2000).fadeOut(2000);
});
$(function(){
	$('a img').hover(
		function(){$(this).fadeTo(400, 0);},
		function(){$(this).fadeTo(400, 1.0);}
	);
});