<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />
</head>

<body>

<BODY
	background="http://www.wallpaper-box.com/cat/1366768/images/cat72.jpg"
	bgproperties="fixed">

	<div class="container">
		<div class="text-center">
			<jsp:include page="logo.jsp" />
		</div>
		<div class="text-left">
			<h2>
				<s:property value="title" />
			</h2>
		</div>
		<br>
		<div class="text-right">
			<a href="catSearch.action">戻る</a> <br>
			<s:property value="userId" />
			さん
		</div>
		<br>

		<div class="errorMessage">
			<s:actionerror />
			<s:property value="errorMsg" />
		</div>
		<br>

		<s:form class="form-horizontal" name="from1">
			<s:hidden name="id"></s:hidden>
			<div class="form-group">
				<label class=" control-label col-sm-2">原産国</label>
				<div class="col-md-5">
					<s:select class="form-control" name="fromId" list="countryMap"></s:select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">名前</label>
				<div class="col-md-5">
					<s:textfield name="name" class="form-control" placeholder="" />
				</div>
			</div>
			<div class="form-group">
				<label class=" control-label col-sm-2">特徴</label>
				<div class="col-md-6">
					<s:textfield name="comment" class="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group text-right">
				<%-- <s:submit method="insert" value="追加" class="btn btn-info btn-lg" /> --%>
				<s:submit method="update" value="%{updateBtnTitle}"
					cssClass="btn btn-info btn-lg" />
			</div>
		</s:form>
	</div>

</body>
</html>