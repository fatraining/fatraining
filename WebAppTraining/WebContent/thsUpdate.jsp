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
	href="<s:url value="/assets/css/ths.css" />" />
</head>
<body>
	<div class="back">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<p class="text-right">
				<a href="thsSearch.action">Back</a>
			</p>
			<div class="text-center">
				<h2>
					<s:property value="title" />
				</h2>
			</div>
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
				<s:hidden name="id"></s:hidden>
				<div class="form-group">
					<label class=" control-label col-sm-2">科目：</label>
					<div class="col-md-5">
						<s:select cssClass="form-control" name="thsSubjectId"
							list="thsSubjectMap"></s:select>
					</div>
				</div>
				<div class="form-group">
					<label class=" control-label col-sm-2"> 講師名：</label>
					<div class="col-md-5">
						<p class="help-block">
						<p>
							(残り: <span class="charsLeft1"></span>文字)
						</p>

						<s:textfield name="name" cssClass="form-control limited1"
							maxlength="20" placeholder="講師名を入力" />
						<p class="help-block">※漢字（20字以内）で入力してください。</p>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"> レベル：</label>
					<div class="col-md-5">
						<s:select class="form-control" name="level" list="levelMap"></s:select>
					</div>
				</div>

				<div class="form-group">
					<label class=" control-label col-sm-2"> コメント：</label>
					<div class="col-md-5">
					<p class="help-block">
						<p>
							(残り: <span class="charsLeft2"></span>文字)
						</p>
						</p>
						<s:textarea name="comment" cssClass="form-control limited2" maxlength="200" rows="4"
							placeholder="コメントを入力" />
							<p class="help-block">※200字以内で入力してください。</p>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">紹介動画：</label>
					<div class="col-md-5">
						<s:textfield name="link" cssClass="form-control" maxlength="5000"
							placeholder="URLを入力" />
					</div>
				</div>
				<div class="form-group text-right">
					<s:submit method="update" value="%{updateBtnTitle}"
						cssClass="btn btn-info btn-lg" />
				</div>
			</s:form>
		</div>
		<script type="text/javascript"
			src="<s:url value="/assets/js/jquery.js" />"></script>
		<script type="text/javascript"
			src="<s:url value="/assets/js/jquery.maxlength.js" />"></script>
		<script type="text/javascript"
			src="<s:url value="/assets/js/fujikawa.js" />"></script>

	</div>
</body>
</html>