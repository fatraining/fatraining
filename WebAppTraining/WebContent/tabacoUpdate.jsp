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
	href="<s:url value ="assets/css/tabaco.css"/>" />

</head>
<body>
	<div class="container">
		<div class="text-center">
			<jsp:include page="logo.jsp" />
		</div>
		<div class="text-left">
			<h1>
				<font color="white"> <s:property value="title" />
				</font>
			</h1>
		</div>
		<br>
		<div class="text-right">
			<font color="white"> <s:property value="userId" />様
			</font>
		</div>
		<br>

		<p class="text-right">
			<a href="tabacoSearch.action">Back</a>
		</p>
		<br>

		<div class="errorMessage">
			<s:actionerror />
			<s:property value="errorMessage" />
		</div>
		<br>

		<s:form class="form-horizontal" enctype="multipart/form-data">
			 <s:hidden name="id"></s:hidden>

			<div class="form-group">
				<label class=" control-label col-sm-2"><font color="yellow"
					face="HG行書体" size="4">※銘柄名:</font></label>
				<div class="col-md-6">
					<s:select cssClass="form-control" name="tabacoAreaId"
						list="tabacoAreaMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"><font color="yellow"
					face="HG行書体" size="4">※商品名:</font></label>
				<div class="col-md-6">
					<s:textfield name="name" class="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"><font color="yellow"
					face="HG行書体" size="4">※タール:</font></label>
				<div class="col-md-6">
					<s:textfield name="tar" class="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2"><font color="yellow"
					face="HG行書体" size="4">ニコチン:</font></label>
				<div class="col-md-6">
					<s:textfield name="nicotine" class="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"><font color="yellow"
					face="HG行書体" size="4">価格:</font></label>
				<div class="col-md-6">
					<s:textfield name="price" class="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-sm-2"><font color="yellow"
					face="HG行書体" size="4">コメント:</font></label>
				<div class="col-md-6">
					<s:textfield name="comment" class="form-control" placeholder="" />
				</div>
			</div>

			<div class="upImage">
				<p class="sub_title">
					<font color="yellow" face="HG行書体" size="5"> 画像アップロード:</font><br>
				</p>
				<%-- <s:file id="customUpload" name="image" label="参照" class="file-upload"/> --%>
				<font color = "yellow">
				<input type="file" name="image" value="参照" class="file-upload" />
				</font>
			</div>
			<br>
			<br>
			<div class="form-group text-right">
				<s:submit method="update" value="%{updateBtnTitle}"
					cssClass="btn btn-primary btn-lg" />
			</div>
		</s:form>
	</div>
	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/otawara.js" />"></script>
</body>
</html>