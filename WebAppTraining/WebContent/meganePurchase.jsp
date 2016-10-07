<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- strutsのタグを使えるようにするやつ-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />



<head>




<meta charset="utf-8">
<title>カウントアップ</title>
<script>
window.onload = function(){
// それぞれのボタンを取得
var targetBtn = document.getElementById("cde");
var resetBtn = document.getElementById("reset")
// targetBtnの値を取得
var num = targetBtn.value;
var name = targetBtn.name;

num=10;
// targetBtnをクリックしたとき
targetBtn.onclick = function(){
num--;
targetBtn.value = name + num;
}

// resetBtnをクリックしたとき
resetBtn.onclick = function(){
num = 10;
targetBtn.value = name + num;
}

// 初期設定
targetBtn.value = name+num;
}
</script>
</head>




<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/megane.css"/>" />
<!-- ふるえるcss -->
<link rel="stylesheet" type="text/css"
	href="http://csshake.surge.sh/csshake.min.css">
<body>
	<div align="center">
		<s:form class="form-horizontal">
		<font color="#FFFFFF">
			<div class="container">
				<div class="text-center">
					<jsp:include page="logo.jsp" />
				</div>
				<div class="text-left">
					<h2>
						<font size=6>本当にこのメガネでいいですか？</font>
					</h2>
					<p class="text-right">
						<s:property value="userId" />
						さん <a href="meganeSearch.action">戻りたい戻りたい！</a>
					</p>
					<br>
				</div>
			</div>





			<tbody>
				<s:if test="%{meganeTable.size!=0}">
					<table id="searchResult">

						<!-- 繰り返し -->
						<!-- ここでカート画面の画像やらなんやらを表示 -->
						<s:iterator value="meganeTable">
							<div class="tableContentWrapper">

								<a
									href="<s:url value="/assets/images/"/><s:property value="gazou" />" />
								<img class="imageWrapper"
									src="<s:url value="/assets/images/"/><s:property value="gazou" />" />

								</a>
							</div>
							<br> 画像クリックで拡大したりしなかったり <br>

							<div class="inline-block">

								<p>
								<h3>
									<br>ブランド名：
									<s:property value="name" />
									<br> 金額：￥
									<s:property value="kingaku" />
									<br> 詳細：
									<s:property value="syousai" />
								</h3>
								</p>
							</div>


							<br>

						</s:iterator>

					</table>
				</s:if>
			</tbody>





			<sbody> <font size=7>合計金額は自分で計算して</font> <font
				color="#FFFFFF"> <s:iterator value="meganeTable">
					<div class="kingaku">
<font size=5>買ったメガネの金額は</font>
						<h3>
							￥
							<s:property value="kingaku" />
						</h3>
						<br>
<h3>買いますよーボタンの前に在庫ボタンをクリック</h3>
					</div>

				</s:iterator>

			</font> </sbody>





<font color="#000000">
<input type="button" name="カートに追加ボタン在庫数残り" value="0" id="cde" />
<input type="button" value="reset" id="reset" />
</font>





			<!-- ふるえるやつ -->


			<br>
			<br>
			<a class="button" name="buy" onClick="kakunin(1)">買いますよー</a>
			<font color="#FFFFFF">👓👓👓</font>
			<p class="shake shake-crazy shake-constant" />
			<form name="test">
				<a class="button" name="modoru" onClick="kakunin(2)">考えますー</a>
			</form>
			</font>
		</s:form>

		<br> <br>
		<p class="pageTop">
			<a href="JavaScript:scrollTo(0,0)" onclick="scrollup();return false;"><font
				size="1" color="#FFFFFF"> ここ押すと1番上に戻る</font></a>
		</p>
		<br> <br> <br> <br>

		<!-- javascript -->
		<script type="text/javascript"
			src="<s:url value="/assets/js/nakagawa.js" />"></script>
	</div>
</body>
</html>