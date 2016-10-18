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
	href="<s:url value="/assets/css/norris.css" />" />


</head>
<body>
	<div class="container">
		<div class="text-center">
			<jsp:include page="logo.jsp" />
		</div>
		<div class="text-left">
			<h2>
				<font color="red"><s:property value="title" /></font>
			</h2>
		</div>
		<br>
		<div class="text-right">
			<s:property value="userId" />
			さん <a href="norrisSearch.action">Back</a>
		</div>
		<br>

		<div class="errorMessage">
			<font color="red"><s:actionerror />
			<s:property value="errorMessage" /></font>
		</div>
		<br>

		<s:form class="form-horizontal">
			<s:hidden name="id"></s:hidden>

			<div class="form-group">
				<label class=" control-label col-sm-2">シリーズ：</label>
				<div class="col-md-6">
					<s:select cssClass="form-control" name="seriesId"
						list="norrisSeriesMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> 作品名: </label>
				<div class="col-md-6">
					<s:textfield name="name" cssClass="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> 公開年: </label>
				<div class="col-md-6">
					<s:textfield name="year" class=" form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> コメント: </label>
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

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/sakai.js" />"></script>

</body>
</html>