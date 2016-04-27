/**
* My name is yamamoto...
*/
$.backstretch(["assets/libs/backstretch/images/001.jpg",
		               "assets/libs/backstretch/images/002.jpg",
		               "assets/libs/backstretch/images/003.jpg"], {
fade: 1000,
duration: 6000
});
$("#club").change(function () {
	if($(this).val() == "") $(this).addClass("place");
	else $(this).removeClass("place")
});
$("#club").change();
$("#position").change(function () {
	if($(this).val() == "") $(this).addClass("place");
	else $(this).removeClass("place")
});
$("#position").change();

