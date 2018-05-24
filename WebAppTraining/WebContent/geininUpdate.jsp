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



		<div class="text-right">
<!-- Back、USERID -->
		<h3><a href="menu.action">Back</a></h3>
	 	<s:property value="userId" />
			様

		</div>


		<br>

	<!-- 削除・更新・追加完了メッセージの表示 -->

	<s:if test="%{!message.isEmpty()}">
		<div class="alert alert-success alert-dismissible">
			<s:property value="message" />
		</div>
	</s:if>

		<s:if test="%{!errorMessage.isEmpty()}">
		<div class="alert alert-danger alert-dismissible">
			<s:property value="errorMessage" />
		</div>
	</s:if>


		<br>
<!--追加する項目書く枠-->
		<div class="text-center">


		<!-- test -->
		<br>
		<br>


		<s:form class="form-horizontal">

		<!-- 全て入力されていないor半角数字でない値があればエラー表示 -->
			<s:if test="%{hasActionErrors}">
				<div class="alert alert-danger" style="list-style: none">
					<s:actionerror />
				</div>
			</s:if>

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

	</div>
<br><br><br><br><br>
	<!-- javascript -->
<!-- 	<script type="text/javascript"
		src="<s:url value="/assets/js/ariyoshi.js" />"></script>
-->
</body>
</html>