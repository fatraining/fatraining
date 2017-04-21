/**
 *
 *//**
 *
 */

/**
 * 星を表示する。
 * これの前に必ずjquery.js、jquery.raty.jsの二つを読み込んでおくこと
 */
$(function(){

	// ファイルアップロード用
	$('#customUpload').change(function() {
		$('#cu-imagePath').val($(this).val());
	});
	// 擬似ファイルアップロードコントロール用
	$('#cu-button, #cu-imagePath').click(function() {
		$('#customUpload').click();
	});

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

	// モーダルダイアログ用
	$('#areaButton').click( function () {
		$('#areaButton').modal();
	});



});
