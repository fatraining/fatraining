<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/megane.css"/>" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購入されました画面</title>

<body>
	<!-- 水平にするフォーム -->
	<s:form class="form-horizontal">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<div class="text-center">
			<font color="#FFFFFF">
				<h2>...消しました</h2>
				<br>
				<br>
				<h3>後悔してない？</h3>
				<br>
				<br>
				<h4>大丈夫？</h4>
				<br>
				<br>
				<h5>心配だよ</h5>
				<br>
				<br>
				<h6>消したのが悪いよ...</h6>
				</font>
				<p class="text-right">
					<s:property value="userId" />
					さん<a href="meganeSearch.action">戻りたいならここ押したらいいじゃない？</a>
				</p>
				<br>
			</div>
		</div>
	</s:form>


	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/nakagawa.js" />"></script>

</body>
</html>