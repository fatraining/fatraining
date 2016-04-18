/**
 * harasan...
 */

/**
 * 星を表示する。
 * これの前に必ずjquery.js、jquery.raty.jsの二つを読み込んでおくこと
 */
$(function(){
	$('.stars').each(function() {
		var starsDiv = $(this);
		starsDiv.raty({
			number: 5,
			score : starsDiv.attr('value')
		});
	});
});
