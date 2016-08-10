/**
 * fujikawa
 */

// 更新ボタン用
$('[name=updateBtn]').click(function(e) {
	// パラメータ用エレメントを作成
	param = document.createElement('input');
	param.setAttribute('type', 'hidden');
	param.setAttribute('name', 'updateId');
	param.setAttribute('id', 'updateId');
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

//字数制限
$(function () {
    $('.limited1').maxlength({
        'feedback' : '.charsLeft1' //残り数を表示する場所
    });
    $('.limited2').maxlength({
        'feedback' : '.charsLeft2' //残り数を表示する場所
    });
});


