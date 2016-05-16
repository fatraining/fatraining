/**
* My name is yamamoto...
*/
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
		modal.find('div.imagePane').html('<img src="/WebAppTraining/assets/images/nophoto.jpg" class="img-responsive img-rounded" width=180 height=200">');
	} else {
		modal.find('div.imagePane').html('<img src="/WebAppTraining/assets/images/temp/' + recipient + '" class="img-responsive img-rounded" width=180 height=200>');
	}
});

$('input[id=fileInput]').change(function(){
	   $("#photo-dummy").val($(this).val());
	});

