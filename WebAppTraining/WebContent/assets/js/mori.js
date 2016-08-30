/**
 * mori
 */


// 更新ボタン用
$('[name=updateBtn]').click(function (e) {
	// パラメータ用エレメントを作成
	param = document.createElement('input');
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



//メッセージの表示 ふわっと出てふわっと消える
$(function() {
	$('.message').fadeIn(1000).delay(2000).fadeOut(2000);
});

//エラーメッセージの表示 ふわっとでる
$(function() {
	$('.errorMessage').fadeIn(1000);
});




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

//fallLeaves();}());//即時関数終了




