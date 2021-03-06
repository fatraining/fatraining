<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/aquarium.css" />" />

<script>

</script>
</head>
<body>
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
			<s:property value="userId" />
			さん <a href="aquariumSearch.action">Back</a>
		</div>
		<br>

		<div class="errorMessage">
			<s:actionerror />
			<s:property value="errorMessage" />
		</div>
		<br>

		<s:form class="form-horizontal">
			<s:hidden name="id"></s:hidden>
			<div class="form-group">
				<label class=" control-label col-sm-2">エリア：</label>
				<div class="col-md-6">
					<s:select cssClass="form-control" name="aquariumAreaId"
						list="aquariumAreaMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> 水族館名: </label>
				<div class="col-md-6">
					<s:textfield name="name" cssClass="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label for="price" class="col-sm-2 control-label"> 入場料: </label>
				<div class="col-md-6">
					<s:select class="form-control" name="price" list="priceMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> 営業時間: </label>
				<div class="col-md-6">
					<s:textfield name="hours" class="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> コメント: </label>
				<div class="col-md-6">
					<s:textarea name="comment" cssClass="form-control" rows="3"
						placeholder="" />
				</div>
			</div>

			<div class="form-group text-right">
				<%-- <s:submit method="insert" value="追加" class="btn btn-info btn-lg" /> --%>
				<s:submit method="update" value="%{updateBtnTitle}"
					cssClass="btn btn-info btn-lg" />
			</div>
		</s:form>
	</div>

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/shibata.js" />"></script>

</body>
</html>