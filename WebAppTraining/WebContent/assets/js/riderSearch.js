

/**動画のjQuery*/
$(function(){
		$('document').ready(function() {
			var options ={
			videoId: 'hRyX_Q88ap4' ,
			mute:true,//ミュート
			repeat:true,//リピートする
			start: 52.8//スタート位置秒数指定
};
     	   $('#wrapper').tubular(options);
   	 });
	});

/**時計*/
function clock() {
//曜日の指定。日本語でも可
var myDay = new Array("Sun","Mon","Tue","Wed","Thu","Fri","Sat");
var now  = new Date();
var year = now.getFullYear(); // 年
var month = now.getMonth()+1; // 月
var date = now.getDate(); // 日
var day = now.getDay();
var hour = now.getHours(); // 時
var min  = now.getMinutes(); // 分
var sec  = now.getSeconds(); // 秒

// 数値が1桁の場合、頭に0を付けて2桁で表示する指定
if(hour < 10) { hour = "0" + hour; }
if(min < 10) { min = "0" + min; }
if(sec < 10) { sec = "0" + sec; }

//clock2へ全ての要素を代入
var clock2 = year + '/' + month + '/' + date  + '（' + myDay[day] + '）'  + hour + ':' + min + ':' + sec ;
//innerHTMLでHTMLのclock-02の中身にclock2を代入している。toLocalStringで文字列を変換する。
document . getElementById( 'clock-02' ) . innerHTML= clock2 . toLocaleString(); // div id="clock-02"

// 1000ミリ秒ごとに処理を実効
window . setTimeout( "clock()", 1000);
}
window . onload = clock;
