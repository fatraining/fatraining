/**
 * harasan...
 */
// テーブルボゴソート用
var wait = 1;                  // ボゴ待ち時間。ミリ秒。1ミリ秒とか速すぎてらめぇぇぇってなるから1000くらいにしとけ
var answer;                    // 正解配列用
var col_no;                    // クリックされたヘッダのインデックス用
var table_id = "#resultTable"; // テーブルのID
var bogoCount = 0;             // ボゴった回数
// 実際にボゴる関数
var doBogo = function () {
	// 回数カウントアップして表示
	bogoCount++;
	$("#bogoCount").text(bogoCount);

	var isBogo = true;
	// テーブルの並びをシャッフル
	$('tbody').shuffle();
	// シャッフルしたテーブルが正しいことを信じて確認
	var childs = $(table_id + " tbody").children();
	for (var i = 0; i < ($(table_id + " tbody").children().length); i++){
		// i行目の、指定列(col_no)のtdの値を取得する
		if (answer[i] != $(table_id + " tbody tr:eq(" + i + ") td:eq(" + col_no + ")" ).text()) {
			// ボゴォ
			isBogo = false;
			break;
		}
	}
	if (!isBogo) {
		setTimeout("doBogo()", wait);
		return;
	}
	$("#bogoCount").hide();
}
// テーブルヘッダをクリックされた時にボゴる関数
$(table_id + ' th').click(function(e){
	// 回数初期化
	bogoCount = 0;
	$("#bogoCount").text(bogoCount);
	$("#bogoCount").show();

	// 列番号を取得
	col_no = $(table_id + ' th').index(this);

	// 正解を作成する
	// 配列初期化
	answer = new Array();
	// クリック列の値を一旦全部取り出し
	for(var i = 1; i < ($(table_id + ' tbody').children().length + 1); i++){
		// i行目の、指定列(col_no)のtdの値を取得する
		answer.push($(table_id + ' tr:eq(' + i + ') td:eq(' + col_no + ')' ).text());
	}
	// ソートする
	answer.sort(function(a,b){
		if( a < b ) return -1;
		if( a > b ) return 1;
		return 0;
	});
	// 1回目は即時実行
	setTimeout("doBogo()", 0);

});

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
//			url : 'WebAppTraining/imageUploadSample.action',
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
	$('#areaButton').click( function () {
		$('#areaButton').modal();
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

	$('#ajaxJsonTest').click(function() {
		var fd = {"name":"豚野郎"};
		$.getJSON('jsonSample.action',
				fd,
				function(jsonResponse) {
					alert(jsonResponse.greet + " " + jsonResponse.name);
				}
		);
	});
});
