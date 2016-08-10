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
	href="<s:url value="/assets/css/drama.css" />" />

<script>

</script>
</head>
<body>
	<div class="snow">●</div>
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
			さん <a href="dramaSearch.action">Back</a>
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
				<label class=" control-label col-sm-2">ジャンル：</label>
				<div class="col-md-6">
					<s:select cssClass="form-control" name="dramaGenreId"
						list="dramaGenreMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> 作品名: </label>
				<div class="col-md-6">
					<s:textfield name="name" cssClass="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label for="cast" class="col-sm-2 control-label"> キャスト: </label>
				<div class="col-md-6">
					<s:select class="form-control" name="cast" list="castMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> 放送局: </label>
				<div class="col-md-6">
					<s:textfield name="tvStation" class="form-control" placeholder="" />
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
		src="<s:url value="/assets/js/sugawara.js" />"></script>

</body>
</html>