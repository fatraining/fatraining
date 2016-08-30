<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/yokai1.css" />" />
</head>
<body>
	<div class="back">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<p class="text-right">
				<a href="yokaiSearch.action">Back</a>
			</p>
			<h2>
			<div class="text-center">
			<marquee behavior="alternate" direction="up" height="100"><marquee direction="right">
				<font face="HG行書体" size="10" color=#FF0000>&nbsp;&nbsp;妖怪を増やす&nbsp;&nbsp;</font></marquee></marquee>
			</div>
			</h2>
			<br>
			<div class="text-right">
				<s:property value="userId" />
				さん
			</div>
			<br>

				<div style="color: red; padding-left: 5%">
				<s:actionerror />
				<s:property value="errorMessage" />
			</div>


			<s:form class="form-horizontal" name="from1">
				<font face="HG行書体">

				<s:hidden name="id"></s:hidden>
				<div class="form-group">

					<label class=" control-label col-sm-2"><font size="5" color=#800080>生息地：</font></label>
					<div class="col-md-5">
						<s:select cssClass="form-control" name="yokaifromId"
							list="yokaifromMap"></s:select>
					</div>
				</div>
				<div class="form-group">
					<label class=" control-label col-sm-2"> <font size="5" color=#000080>妖怪の名前：</font></label>
					<div class="col-md-5">
						<p class="help-block">
						<p>

						</p>

						<s:textfield name="name" cssClass="form-control limited1"
							maxlength="20" placeholder="妖怪の名前を入力" />
							<p class="help-block">※日本語で入力してください。</p>

					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"><font size="5" color=#008000>特徴：</font> </label>
					<div class="col-md-5">
						<s:select class="form-control" name="type" list="typeMap"></s:select>
					</div>
				</div>

				<div class="form-group">
					<label class=" control-label col-sm-2"> <font size="5" color=#FF00FF>コメント：</font></label>
					<div class="col-md-5">
					<p class="help-block">


						<s:textarea name="comment" cssClass="form-control limited2" rows="4"
							placeholder="コメントを入力" />

					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"><font size="5" color=#0000CD>紹介画像URL：</font> </label>
					<div class="col-md-5">
						<s:textfield name="link" cssClass="form-control" maxlength="5000"
							placeholder="URLを入力" />
					</div>
				</div>
				<div class="form-group text-right">
					<s:submit method="update" value="%{updateBtnTitle}"
						cssClass="btn btn-info btn-lg" />
				</div>
				</font>
			</s:form>
		</div>
		<script type="text/javascript"
			src="<s:url value="/assets/js/jquery.js" />"></script>
		<script type="text/javascript"
			src="<s:url value="/assets/js/jquery.maxlength.js" />"></script>
		<script type="text/javascript"
			src="<s:url value="/assets/js/yokai.js" />"></script>

	</div>
</body>
</html>