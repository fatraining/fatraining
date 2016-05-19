//開いたらサーバー接続させる
//サーバーサイドでセッションとってくれる
var uri = "ws://" + location.host + "/Yatte/cyo";
ws = new WebSocket(uri);

// 使用するとき
// var msg = new yatteMessage("yatte", new yatteList);
var yatteMessage = function (messageType, contentsList) {
	this.contentsList = new Array();
	this.contentsList.push(contentsList);
};

/* 送信用スクリプト */
// 格納させるやーつ JSONってやつ
var yatteList = {
	name : null,
	who : "who",
	num : "num",
	time : "time",
	ex : "",
	yattal : null,
}


// カラム隠しておく！！つくっておく！
// Columnsっていうライブラリ
$('.popbox').hide();
$('#columns').hide();
$(document).ready(function() {
	$('#columns').columns({
		data : ["",""]
	});
});


/*******************************************************************************
 * yatte押された時の処理 ついでに選択肢の初期化 サーバーで処理させる場合、$('# option:selected').val()で指定
 ******************************************************************************/
$( '#ex' ).keypress( function ( e ) {
	if ( e.which == 13 ) {
		$("#yatte").click();
		return true;
	}
} );

$("#yatte").click(function() {
	var m = $('#name').text()
	var w = $('#who option:selected').text()
	var t = null
	var e = $('#ex').val()

	console.log(m)
	if (e != "" ) {
	var yatteList = {
		name : m,
		who : w,
		time : t,
		ex : e + "@" + m,
		}
	ws.send(JSON.stringify(yatteList));
	console.log("送る方 : " + JSON.stringify(yatteList))

	$('#who').val(0);
	$('#num').val(0);
	$('#ex').val("");
	target = document.getElementById("error")
	target.innerHTML  = "";
	} else {
		target = document.getElementById("error")
		target.innerHTML  = "なにをすればいいのやら";
	}
});

/*
 * yattalの処理
 */
function yattal(no) {
//	console.log("やったる！" + no );
//	var yatteList = {
//			no : no,
//	};
//
//	ws.send(JSON.stringify(yatteList));
}

/* 受信用スクリプト */
ws.onmessage = function(message) {
	/* 表示制御 */

	$('.popbox').show();
	$('#columns').show();
	var focus = document.getElementById('#ex');
/* console.log("受け取った方 : " + message.data); */

	/* message.dataをJSON形式にparse */
	var json = JSON.parse(message.data);
	console.log(JSON.stringify(json))
	if (json.length == 0) {
		$('#columns').hide();
	} else {
	json.reverse()

	/* カラム作成(の前にデストローイ) */
	$('#columns').columns('destroy');


	$('#columns').columns({
		data : json,
		schema: [
		         {"header":"No", "key":"no"},
		         {"header":"やるひと！", "key":"who"},
		         {"header":"じかん！", "key":"time"},
		         {"header":"こめんと！", "key":"ex"},
		         {"header":"yattal !", "key":"yattal",
		        	 },
// {"header":"yattal !", "key":"time",
// "template":'<font color="FF0000"><strong>あかんかった</strong></font>',
// "condition":function(time) {return (time != 0);},},
		         ]
	});

	$('#receive').text(json);





/* デスクトップ通知 */
/*
 * Notifications API で処理 Firefox,Chrome,Opera,Vivaldiとかいける(IEぶっころ)
 * 意外と簡単に通知が実装できるやーつ 通知のbodyには\n使えるよ！！
 */
    // Notificationを取得

    var Notification = window.Notification || window.mozNotification || window.webkitNotification;

    // Notificationの権限チェック
    Notification.requestPermission(function (permission) {
        // console.log(permission);
    });

    // 通知インスタンス生成
    data : json.reverse()
    var instance = new Notification(
        "【 from : " + json[json.length-1]['name']
        + "】 ", // 通知タイトル
        {body : "to : " + json[json.length-1]['who']
        		+ "\n[" + json[json.length-1]['ex'] + "]",// 通知内容
        	icon : 'images/yatte.jpg'
        }
    );

    setTimeout(instance.close.bind(instance),5000); // 1000[ミリ秒後]に通知を閉じる

    instance.onclick = function () {
    	window.focus(); // ←なんかしらんけど使える(Chrome)
    	window.opener.focus(); // ←なんかしらんけど使えない(多分Firefox用)
        console.log("onclick");
    };
    instance.onerror = function () {
        console.log("onerror");
    };
    instance.onshow = function () {
    	window.focus(); // ←なんかしらんけど使えない
        console.log("onshow");
    };
    instance.onclose = function () {
        console.log("onclose");
    };
	}
};