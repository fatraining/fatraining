/**
 *
 */

// 更新ボタン設定用
// 大抵コピペなのであまり参考にできない
$('[name=updateBtn]').click(function(e) {
	// パラメータ用エレメントを作成
	// <input type="hidden" name="updateId" id="updateId" value=持ってきた値>
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
	form.appendChild(param);
	form.appendChild(btn);
	form.submit();
});
