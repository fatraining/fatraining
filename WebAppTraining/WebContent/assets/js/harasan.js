/**
 * harasan...
 */

/**
 * 星を表示する。
 * これの前に必ずjquery.js、jquery.raty.jsの二つを読み込んでおくこと
 */
$(function(){
	// 検索条件、編集画面時の星表示用
	$('div.stars').each(function() {
		var starsDiv = $(this);
		starsDiv.raty({
			number    : 5,
			score     : starsDiv.attr('value'),
			path      : 'assets/libs/raty/images/',
			scoreName : 'stars'
		});
		// ダブルクリックで星を未設定にする
		starsDiv.dblclick(function (e) {
			$(this).score = '';
			$('div.stars > [name=stars]')[0].value = '';
		});
	});
	// 検索結果の星表示用
	$('div.stars-readOnly').each(function() {
		var starsDiv = $(this);
		starsDiv.raty({
			number   : 5,
			score    : starsDiv.attr('value'),
			readOnly : true,
			path     : 'assets/libs/raty/images/'
		});
	});
	// ファイルアップロード用
	$('#customUpload').change(function() {
		$('#cu-imagePath').val($(this).val());
	});
	// 擬似ファイルアップロードコントロール用
	$('#cu-button, #cu-imagePath').click(function() {
		$('#customUpload').click();
	});
	// 非同期アップロード
//	$('#cu-upButton').click(function() {
//		var fd = new FormData();
//		if ($('#customUpload').val() !== '') {
//			fd.append("image", $('#customUpload').prop("files")[0] );
//		}
//		fd.append("imageFileName",$('#cu-imagePath').val());
//		$.ajax({
//			url : 'WebApp/imageUpload.action',
//			type : 'POST',
//			data : fd,
//			processData : false,
//			contentType : false,
//			success : function(data) {
//				alert("success");
//			},
//			failure : function(data) {
//				alert("failure");
//			}
//		});
//	});

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
	$('#sampleButton').click( function () {
		$('#sampleModal').modal();
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
