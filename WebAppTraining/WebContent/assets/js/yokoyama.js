/**
* My name is yokoyama...
*/

/*selectはDBの内容を引っ張ってきている*/
$(".select").change(function () {
	if($(this).val() == "") $(this).addClass("place");
	else $(this).removeClass("place")
});
$(".select").change();

/**
 * モーダルへコメント受け渡す
*/
$('#profileModal').on('show.bs.modal', function (event) {
	var button = $(event.relatedTarget);
	var recipient = button.data('recipient');
	var modal = $(this);
	if (recipient == '' || recipient == null) {
		modal.find('div.commentPane').text('コメント:なし');
	} else {
		modal.find('div.commentPane').html(recipient);
	}
});



/**
 * モーダルへ画像パス受け渡す
*/

$('#profileModal').on('show.bs.modal', function (event) {

	var button = $(event.relatedTarget);
	var recipient = button.data('whatever');
	var modal = $(this);
	if (recipient == '' || recipient == null) {
		modal.find('div.imagePane').html('<img src="/WebAppTraining/assets/images/nophoto.jpg" class="img-responsive img-rounded">');
	} else {
		modal.find('div.imagePane').html('<img src="/WebAppTraining/assets/images/temp/' + recipient + '" class="img-responsive img-rounded">');
	}
});


$('input[id=fileInput]').change(function(){
	   $("#photo-dummy").val($(this).val());
	});


$(function() {
	/**
	 * ajaxでテーブルを出す！
	 *
	 */
	$('#search').click(function() {

		var country = $('#country').val();
		var shipName = $('#name').val();
		var shipClass= $('#shipClass').val();
		var thead =  '<thead><font color="white"><tr><th>国名 </th><th>艦名 </th><th>クラス</th><th>竣工年</th><th>プロフィール</th><th>解体</th></tr></font></thad>';

		$.getJSON('shipFinder!search.action',
				{countryID:country, shipName:shipName, shipClass:shipClass},
				function(jsonResponse){
					 $("table.tbl").css('display', "");
					 $("table.tbl").html(""); 		// テーブル初期化
					 $("span.msg").html("");		// メッセージ初期化
					 $("#delete").html("");			// ボタン初期化

					 if (jsonResponse.length > 0) {
					$(thead).appendTo('table.tbl');
//					$('<input type="submit" name="delete" value="解体" class="btn btn-danger" />').appendTo('#delete');
					$('<input type="submit" name="method:delete" value="解体"' +
							'class="btn btn-danger" />').appendTo('#delete');
					for (var index in jsonResponse) {
						$( '<tr>'+
						          '<td>' + jsonResponse[index][0].countryName + '</td>'+
						         '<td>' + jsonResponse[index][1].shipName + '</td>' +
						          '<td>' + jsonResponse[index][1].shipClass + '</td>' +
						          '<td>' + jsonResponse[index][1].year + '</td>' +
						          '<td><input type="button" name="profileBtn" value="profile"' +
									 	'class="btn btn-info" data-toggle="modal" data-target="#profileModal"' +
						          'data-recipient="' + jsonResponse[index][1].comment +
						          '"data-whatever="' + jsonResponse[index][1].imagePath + '" /></td>' +
						          '<td><input type="checkbox" class="delete" name="delete"value="' + jsonResponse[index][1].shipID +
						          ':' + jsonResponse[index][1].shipName + '"/></td>' +
						     '</tr>').appendTo('table.tbl');
						}
					$('div.result').hide().slideDown(200);
					 }
				}
			);
		});
	// リセット
	$('#reset').click(function() {
		$('div.result').slideUp(200);
		$('#country,#name,#shipClass').val("");
		$(".select").change();
	})



//	// 解体
//	$('#delete').click(function() {
////		var deleteID = $('.delete:checked').map(function() {
////			  return $(this).val();
////		}).get();
//		var deleteID = $('.delete:checked').val();
//		$.get('shipFinder!delete.action',
//				{"delete":deleteID},
//				function(htmlResponse) {
////					document.write(html);
//				}
//			);
//		});

	// Enterでsubmitしない
		$(document).on("keypress", "input:not(.allow_submit)", function(event) {
			return event.which !== 13;
		});
});


