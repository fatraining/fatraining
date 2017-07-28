<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />
<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/galgame.css"/>" />

<body class="container">
	<!-- 研修Webアプリverβ -->
	<div class="text-center">
		<jsp:include page="logo.jsp"></jsp:include>
	</div>

	<!-- タイトル -->
	<div class="text-center">
		<h1>エ〇ゲー批評空間</h1>
	</div>

	<!-- 登録ユーザーID Back-->
	<div class="text-right">
		<s:property value="userId" />
		さん <a href="galgameSearch.action">Back</a>
	</div>
	<br />

	<div class="text-center">
		<h2>
			<s:property value="title" />
		</h2>
	</div>

	<!-- 追加項目画面 -->


	<s:form cssClass="form-horizontal">

		<!-- 全て入力されていないor半角数字でない値があればエラー表示 -->
		<s:if test="%{hasActionErrors}">
			<div class="alert alert-danger" style="list-style: none">
				<s:actionerror />
			</div>
		</s:if>

		<s:hidden name="id"></s:hidden>
		<div class="form-group">
			<label class="col-sm-3 control-label"> メーカー </label>
			<div class="col-sm-7">
				<s:select cssClass="form-control" name="makerId" list="makerMap"></s:select>
			</div>
		</div>
		<br />

		<div class="form-group">
			<label class="col-sm-3 control-label"> ゲーム名 </label>
			<div class="col-sm-7">
				<s:textfield cssClass="form-control" name="name"></s:textfield>
			</div>
		</div>
		<br />

		<div class="form-group">
			<label class="col-sm-3 control-label"> 発売年 </label>
			<div class="col-sm-7">
				<s:textfield cssClass="form-control" name="year"></s:textfield>
				<p class="help-block">※半角数字で入力してください</p>
			</div>
		</div>
		<br />

		<div class="form-group">
			<label class="col-sm-3 control-label"> 評価点 </label>
			<div class="col-sm-7">
				<s:textfield cssClass="form-control" name="score"></s:textfield>
				<p class="help-block">※半角数字で入力してください</p>
			</div>
		</div>
		<br />

		<div class="form-group">
			<label class="col-sm-3 control-label"> コメント </label>
			<div class="col-sm-7">
				<s:textarea rows="3" cssClass="form-control" name="comment"></s:textarea>
			</div>
		</div>
		<br />

		<div class="form-group">
			<div class="text-center">
				<div class="btn-group">
					<s:submit method="update" value="%{Btn}"
						cssClass="btn btn-danger btn-lg" />
				</div>

			</div>
		</div>
	</s:form>
</body>
</html>