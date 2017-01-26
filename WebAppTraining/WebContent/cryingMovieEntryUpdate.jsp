<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<title>Insert title here</title>
</head>
<body>

	<div class="text-right">
		<a href="cryingMovieSearch.action">Back</a>
	</div>
	<br>
 	<div class="text-right">
 		<s:property value="userId" />さん<br>
	</div>
	<br>

	<%--未入力時のメッセージ表示 --%>
	<div class="errorMessage">
		<s:actionerror />
   		<s:property value="errorMessage" />
  	</div><br>
			<br>

			<div class="form-group">
				<div>国内外：</div>
				<div class="col-md-6">
					<input type="radio" name = "country" value = 1 checked>日本
					<input type="radio" name = "country" value = 2>海外
				</div>
			</div>

<!-- 			<br> -->
<!-- 				<div>ジャンル：</div> -->
<!-- 				<div class="col-md-6"> -->
<!-- 					<input type="radio" name = "genre" value = 1 checked>恋愛 -->
<!-- 					<input type="radio" name = "genre" value = 2>家族 -->
<!-- 					<input type="radio" name = "genre" value = 3>ヒューマンドラマ -->
<!-- 				</div> -->

<!-- 			<div class="form-group"> -->
<!-- 				<label class=" control-label col-sm-2"> 作品名：</label> -->
<!-- 				<div class="col-md-5"> -->
<!-- 					<p class="help-block"> -->
<!-- 					<p> -->

<!-- 					</p> -->

<%-- 					<s:textfield name="name"/> --%>
<!-- 						<p class="help-block">※日本語で入力してください。</p> -->
<!-- 				</div> -->
<!-- 			</div> -->


</body>
</html>