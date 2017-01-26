<!-- ページ設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- カプセル化 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />
</head>

<body>

	<%-- javascript --%>
	<script type="text/javascript" src="<s:url value="/assets/js/cryingMovie.js" />"></script>

	<!-- メニューに移行 -->
	<div class="back">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<p class="text-right">
				<a href="menu.action">Back</a>
			</p>
			<br>
			<%--SearchActionクラスで生成したuserIdを表示する --%>
<!--   			<div class="text-right"> -->
<%--  			<s:property value="userId" />さん --%>
<!--  			</div><br> -->
        </div>

		<div Align="center">
			<div class="form-group">
				<p>ジャンルを指定してください<br>
					<input type="radio" name = "country" value = 1>日本
					<input type="radio" name = "country" value = 2>海外
					<input type="radio" name = "country" value = 0 checked>指定しない
				<br>
					<input type="radio" name = "genre" value = 1>恋愛
					<input type="radio" name = "genre" value = 2>家族
					<input type="radio" name = "genre" value = 3>ヒューマンドラマ
					<input type="radio" name = "genre" value = 0 checked>指定しない
				</p>
			</div>

			<div class= "form-group" >
					<s:submit method="search" value="検索" />

					<s:submit method="reset" value="リセット" />

					<s:submit method="update" value="登録" />
			</div>

		</div><br>

		<!-- エラーメッセージの表示 -->
		<div style="color: red; padding-left: 5%">
			<s:actionerror />
			<s:property value="message" />
		</div>

	</div>



	<%-- javascript --%>
	<script type="text/javascript"
	src="<s:url value="/assets/js/cryingMovie.js" />"></script>

</body>
</html>