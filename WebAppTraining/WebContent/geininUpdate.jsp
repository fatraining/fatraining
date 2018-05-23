<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--単一タグ。機能のカプセル化タグ名がｓで属性名がuri。-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/geinin.css"/>" />

</head>

<body>


	<div class="container">
		<div class="text-center">
		<!-- 研修アプリVer.β -->
			<jsp:include page="logo.jsp" />
		</div>




		<p class="text-right">
			<a href="geininSearch.action">Back</a>
		</p>
		<br>
<!--追加する項目書く枠-->
				<div class="text-center">


				<!-- test -->
				<br>
				<br>


		<s:form class="form-horizontal">
			<s:hidden name="id"></s:hidden>
			<div class="form-group">
				<label for="name" class=" control-label col-sm-2">名前：</label>
				<div class="col-md-6">
					<s:textfield name="name" cssClass="form-control" />
				</div>
			</div>
						<div class="form-group">
				<label for="image" class=" control-label col-sm-2"> 写真: </label>
				<div class="col-md-6">
					<s:textfield name="image" cssClass="form-control" />
					<p class="help-block" align="left">※00.jpg の形式で入力</p>
				</div>
			</div>

			<div class="form-group">
				<label for="work" class=" control-label col-sm-2"> 代表ネタ: </label>
				<div class="col-md-6">
					<s:textfield name="work" cssClass="form-control" />
					<p class="help-block" align="left">※「コンビニ」など</p>
				</div>
			</div>
			<br>

		<div class="form-group">
			<div class="text-center">
				<div class="btn-group">
					<s:submit method="update" value="%{Btn}"
						cssClass="btn btn-warning btn-lg" />
				</div>

			</div>
		</div>
		</s:form>
	</div>
<br><br><br><br><br>
	<!-- javascript -->
<!-- 	<script type="text/javascript"
		src="<s:url value="/assets/js/ariyoshi.js" />"></script>
-->
</body>
</html>