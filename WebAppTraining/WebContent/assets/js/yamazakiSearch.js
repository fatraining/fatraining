/**フラッシュ
 *
 */
$(function(){
	$('.flash ul li').hide();
		$('.flash ul li').each(function(i) {
			$(this).delay(250 * i).fadeIn(500);
		});

});

/**トップに戻る
*
*/
$(function(){
    var showTop = 360;

    $('body').append('<a href="javascript:void(0);" id="fixedTop">TOPへ</a>');
    var fixedTop = $('#fixedTop');
    fixedTop.on('click',function(){
        $('html,body').animate({scrollTop:'0'},500);
    });
    $(window).on('load scroll resize',function(){
        if($(window).scrollTop() >= showTop){
            fixedTop.fadeIn('normal');
        } else if($(window).scrollTop() < showTop){
            fixedTop.fadeOut('normal');
        }
    });
});