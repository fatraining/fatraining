/**
 * shibata
 */


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



//メッセージの表示の仕方 ふわっと出てふわっと消える
$(function() {
	$('.message').fadeIn(1000).delay(2000).fadeOut(2000);
});

//メッセージの表示の仕方 ふわっとでる
$(function() {
	$('.errorMessage').fadeIn(1000);
});

//魚が浮いてる
$(function (){ var i=0; //即時関数で囲んでグローバル変数を消すため、この行はこのままで
//★画像指定。画像を順番に"●",と区切って、いくつでも並べる。最後の]の前には,(カンマ)無し
var ha=["assets/images/temp/fugu.png","assets/images/temp/manbo.png","assets/images/temp/kumanomi.png"];
var myurl="";        //★画像パス。文書とは別のフォルダーなどに入っている時は指定。全画像共通部分

var haw=[18,30,10];  //★画像横幅(１番目画像,２番目画像,３番目画像～)と続ける
var hah=[18,30,10];  //★画像高さ(１番目画像,２番目画像,３番目画像～)と続ける
var Zx=-1;           //★文章の上に画像が流れるか？上に流れる：1 下に隠れる：-1
var num=45;      //★流れる画像の数
var time=50;         //★画像の流れる間隔1000=1秒。数値が小さいほど速い

//指定ここまで---------------------------------------------------------
var imgArray = new Array(num);
var w=window.innerWidth+haw[0];
var h=window.innerHeight+hah[0];
var lt=window.pageXOffset-haw[0];
var tp=window.pageYOffset-hah[0];
var imglen=imgArray.length;
var len=ha.length;

for(i=0; i<imglen; i++) {
	var img=document.createElement("IMG");
	img.src=myurl+ha[i%len];
	img.width=haw[i%len];
	img.height=hah[i%len];
	var ob=img.style;
	ob.position="fixed";/*■absoluteをfixedに変更*/
	ob.left =lt+Math.floor(Math.random()*w)+"px";
	ob.top =tp+Math.floor(Math.random()*h)+"px";
	ob.zIndex=Zx;/*■追加*/
	document.body.appendChild(img);
	imgArray[i]=img;
}

function fallLeaves(){
	for(i=0; i<imglen; i++){
		var img=imgArray[i];
		var x=parseInt(img.style.left);
		var y=parseInt(img.style.top);
		y-=2+Math.floor(Math.random()*2);/*■原本y +=～*/
		/*■下記原本1行変更*/
		if(y<-hah[0]){y=tp+h; x=lt+Math.floor(Math.random()*w);}
		else{ x +=Math.floor(Math.sin(y/40)*2); if(x<lt){x=lt;}else if(x>lt+w){x=lt+w;}}
		img.style.left=x+"px"; img.style.top=y+"px";
	}
	setTimeout(fallLeaves,time);
}
fallLeaves();
}());//即時関数終了
