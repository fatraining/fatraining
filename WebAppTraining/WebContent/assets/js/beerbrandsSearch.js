/**動画のjQuery*/
$(function(){
		$('document').ready(function() {
			var options ={
			videoId: 'a78_BxLgG_0',//iPBp4riEDYA,a78_BxLgG_0,QDNtDIF7vZs,Ql7rXJtQM3o :200
			mute:false,//ミュート
			repeat:true,//リピートする
			start:0.00, //スタート位置秒数指定
};
     	   $('#wrapper').tubular(options);
   	 });
	});
