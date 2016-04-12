<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="Shift_JIS"%>

<!DOCTYPE html>
<html>
<head>
<title>Hello Struts2</title>
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<style>
div.container {
	max-width: 1200px;
}

div.top-div {
	height: 50px;
}

div.first-div {
	padding: 10px 5px;
	border: 2px solid silver;
}

div.second-div {
	padding: 10px 5px;
	border: 1px solid silver;
}

div.second-div div {
	padding: 5px;
}

div.cent {
	text-align: center;
}

div.light {

}

div.green {
	background-color: green;
}

h3:first-letter {
	font-weight: bold;
	font-size: 120px;
	color: red;
}

.left {
	color: green;
	font-size: 40px;
	text-align: left;
}

div a {
	display: block;
}

a.adult {
	width: 50px;
}

/* --- 見出しエリア --- */
div.heading {
	width: 598px; /* 見出しエリアの幅 */
	margin-bottom: 1em;
	background: #f9f9f9 url(heading_back1.gif) repeat-x; /* 見出しエリアの背景 */
	border: #c0c0c0 solid; /* 見出しエリアの境界線（色、スタイル） */
	border-width: 1px 1px 2px; /* 見出しエリアの境界線（太さ 上、左右、下） */
}

/* --- 見出し --- */
div.heading h4 {
	margin: 0;
	padding: 7px 7px 4px; /* 見出しのパディング（上、左右、下） */
	border-bottom: 2px #4169e1 solid; /* 見出しの下境界線 */
	font-size: 100%; /* 見出しの文字サイズ */
	line-height: 100%;
}

div.photo {
	padding: 10px; /* パディング */
	background-color: #ffffff; /* 背景色 */
	border: 1px solid; /* 境界線 */
	border-color: #c0c0c0 #808080 #808080 #c0c0c0; /* 境界線色（上右下左） */
}

div.nyan {
	float: right;
}
</style>
</head>
<div class="heading">
	<h2>YamazonJapan公式ホームページ</h2>
</div>
<body>
	<div class="cent">
		<form>
			<script type="text/javascript">

			</script>
		</form>
	</div>
	<FORM>
		<H5>今日の気分は？</H5>
		<SELECT name="kibun">
			<OPTION value="saikou">めちゃいい！！</OPTION>
			<OPTION value="botiboti">まあまあいい！</OPTION>
			<OPTION value="hutuu">普通</OPTION>
			<OPTION value="saiaku">最悪・・</OPTION>
		</SELECT>
	</FORM>
	<div class="container">
		<div class="nyan">
			<p>
				<img src="./imgs/photo.jpg" alt="Photo" width="300" height="225"
					class="photo">
			</p>
		</div>
		<div class="cent">
			<div class="text-left">
				<div class="left">
					<marquee scrolldelay="30" truespeed scrollamount="50"
						style="width: 400px; height: 20; background: url(http://plaza.rakuten.co.jp/img/user/99/06/4429906/39.gif); background-attachment: fixed; border-style: inset; padding: 10px;"
						loop="0">
						<b>Yamazon&hearts;047-***-****</b>
					</marquee>
				</div>
			</div>
			<div class="green">
				<div class="text-right">
					<h3 class="first-Letter">Yamazon Japan</h3>
					<a class="adult" onclick="location.href='secret.jsp'">大人用</a>
				</div>
				<p></p>
				<script type="text/javascript">
				<!--
					var now = new Date();

					// 表示開始
					document.write(now.toLocaleString());
					// 表示終了
				// -->
				</script>

				<div class="col-md-12 top-div">
					<div class="cent">
						<!--ボタンを押すタグ　プルダウンを選んでボタンを押すと結果をsendをAction側のsendメソッドまで運ぶ  -->
						<form name="myForm">
							<s:select name="year" value="year"
								list="#{'2014':'2014','2015':'2015','2016':'2016'}" />
							<s:select name="month" value="month" list="monthArray" />
							<s:submit method="send" value="go" cssClass="btn btn-primary" />
						</form>
					</div>
				</div>
				<!-- iteratorはiteratorで囲んでいるものを繰り返す。配列などはこれを使う。 -->
				<div class="col-md-12 first-div">
					<s:iterator value="historyOfMonth" status="st">
						<div class="col-md-12">
							<label class="col-md-12 form-control"><s:property /></label>
						</div>
					</s:iterator>
					<script type="text/javascript">
					<!--
						function myGo() {
							mySelect = document.myForm.myMenu.selectedIndex;
							location.href = document.myForm.myMenu.options[mySelect].value;
						}
					// -->
					</script>
				</div>
			</div>
		</div>
		<div class="text-right">
			<div class="back">
				<a href="login">Go Sign Out</a>
			</div>
		</div>
		<div class="text-left">
			<div class="back">
				<a href="mailform">ご意見ご要望はこちら</a>
			</div>
		</div>
	</div>
</body>
</html>