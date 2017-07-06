<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />
<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/ozaki.css"/>" />

<body class="container">
	<!-- 研修Webアプリverβ -->
	<div class="text-center">
		<jsp:include page="logo.jsp"></jsp:include>
	</div>

	<!-- タイトル -->
	<div class="text-center">
		<h1>尾崎豊 曲検索</h1>
	</div>

	<!-- 登録ユーザーID 戻る -->
	<div class="text-right">
		<s:property value="userId" />
		さん <a href="ozakiSearch.action">戻る</a>
	</div>
	<br />

	<div class="text-center">
		<h2>
			<s:property value="title" />
		</h2>
	</div>

	<!-- 追加項目画面 -->
	<s:form cssClass="form-horizontal">

		<!-- すべて入力されていない場合はエラーを表示 -->
		<s:if test="%{hasActionErrors}">
			<div class="alert alert-danger" style="list-style: none">
				<s:actionerror />
			</div>
		</s:if>

		<s:hidden name="id"></s:hidden>
		<div class="form-group">
			<label class="col-sm-3 control-label"> アルバム </label>
			<div class="col-sm-7">
				<s:select cssClass="form-control" name="albumId" list="albumMap"></s:select>
			</div>
		</div>
		<br />

		<div class="form-group">
			<label class="col-sm-3 control-label"> 曲名 </label>
			<div class="col-sm-7">
				<s:textfield cssClass="form-control" name="songName"></s:textfield>
			</div>
		</div>
		<br />

		<div class="form-group">
			<label class="col-sm-3 control-label"> 作詞・作曲 </label>
			<div class="col-sm-7">
				<s:textfield cssClass="form-control" name="songWriting"></s:textfield>
			</div>
		</div>
		<br />

		<div class="form-group">
			<label class="col-sm-3 control-label"> 年代 </label>
			<div class="col-sm-7">
				<s:textfield cssClass="form-control" name="age"></s:textfield>
			</div>
		</div>
		<br />

		<div class="form-group">
			<label class="col-sm-3 control-label"> 歌詞 </label>
			<div class="col-sm-7">
				<s:textfield cssClass="form-control" name="lyrics"></s:textfield>
			</div>
		</div>
		<br />

		<div class="form-group">
			<div class="text-center">
				<div class="btn-group">
					<s:submit method="update" value="作曲する"
						cssClass="btn btn-danger btn-lg" />
				</div>
			</div>
		</div>
	</s:form>
</body>
</html>