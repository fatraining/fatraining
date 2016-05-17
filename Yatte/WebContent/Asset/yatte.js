//開いたらサーバー接続させる
//サーバーサイドでセッションとってくれる
var uri = "ws://" + location.host + "/Yatte/yo";
ws = new WebSocket(uri);

// 使用するとき
// var msg = new yatteMessage("yatte", new yatteList);
var yatteMessage = function (messageType, contentsList) {
	this.messageType = messageType;
	this.contentsList = new Array();
	this.contentsList.push(contentsList);
};

/* 送信用スクリプト */
// 格納させるやーつ JSONってやつ
var yatteList = {
	name : null,
	toDo : "toDo",
	who : "who",
	num : "num",
	time : "time",
	ex : "",
	flg : 1,
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
	var d = $('#toDo option:selected').text()
	var w = $('#who option:selected').text()
	var n = $('#num option:selected').val()
	var t = $('#time option:selected').val()
	var e = $('#ex').val() + "@" + m

	console.log(m)
	if (e != "") {
	var yatteList = {
		name : m,
		toDo : d,
		who : w,
		num : n,
		time : t,
		ex : e,
		flg : 0,
		}
	var msg = new yatteMessage("yatte",yatteList);
	ws.send(JSON.stringify(msg));
	console.log("送る方 : " + JSON.stringify(msg))

	$('#toDo').val(0);
	$('#who').val(0);
	$('#num').val(0);
	$('#time').val(0);
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
	console.log("やったる！" + no );
	var yatteList = {
			no : no,
	};
	var msg = new yatteMessage("yattal",yatteList);
	ws.send(JSON.stringify(msg));
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
	if (json.contentsList.length == 0) {
		$('#columns').hide();
	} else {
	json.contentsList.reverse()

	/* カラム作成(の前にデストローイ) */
	$('#columns').columns('destroy');


	$('#columns').columns({
		data : json.contentsList,
		schema: [
		         {"header":"No", "key":"no"},
		         {"header":"やること！", "key":"toDo"},
		         {"header":"やるひと！", "key":"who"},
		         {"header":"にんずう！", "key":"num"},
		         {"header":"いつまで！", "key":"limitText"},
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

    if (json.messageType == "yatte") {
    // 通知インスタンス生成
    data : json.contentsList.reverse()
    var instance = new Notification(
        "【" + json.contentsList[json.contentsList.length-1]['toDo']
        + "】 " + "yatte!", // 通知タイトル
        {body : "やるひと : " + json.contentsList[json.contentsList.length-1]['who']
        		+ " \n募集人員 : " + json.contentsList[json.contentsList.length-1]['num'] + "人"
        		+ "\nきげん : " + json.contentsList[json.contentsList.length-1]['limit']['dayOfMonth']+ "日" + json.contentsList[json.contentsList.length-1]['limit']['hour'] + "時" + json.contentsList[json.contentsList.length-1]['limit']['minute'] + "分まで！\n"
        		+ "[" + json.contentsList[json.contentsList.length-1]['ex'] + "]",// 通知内容
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
	} else if (json.messageType == "akan") {
		var Notification = window.Notification || window.mozNotification || window.webkitNotification;

	    // Notificationの権限チェック
	    Notification.requestPermission(function (permission) {
	        // console.log(permission);
	    });

	    // 通知インスタンス生成
	    var instance = new Notification(
	        "【あかんかった】 ", // 通知タイトル
	        {body : "やってもうた",
	        	icon : 'images/yatte.jpg'
	        }
	    );
	};
	}
};