<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/chocolate.css" />" />

</head>
<body>
<div class="container">
		<div class="text-center">
			<jsp:include page="logo.jsp" />
		</div>

		<br>
		<div class="text-right">
			<s:property value="userId" />
			さん <a href="chocolateSearch.action">Back</a>
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
				<label class=" control-label col-sm-2">Image：</label>
				<div class="col-md-6">
					<s:textfield name="Image" cssClass="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> Area: </label>
				<div class="col-md-6">
				<s:select cssClass="form-control" name="countryid"
						list="ChocolateCountryMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> Shop name: </label>
				<div class="col-md-6">
					<s:textfield name="shopName" class=" form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> Chef: </label>
				<div class="col-md-6">
					<s:textfield name="chef" class="form-control" placeholder="" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Comment：</label>
				<div class="col-md-6">
					<s:textfield name="comment" class="form-control" placeholder="" />
				</div>

			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Price：</label>
				<div class="col-md-6">
					<s:textfield name="price" class="form-control" placeholder="" />
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
		src="<s:url value="/assets/js/muto.js" />"></script>

</body>
</html>