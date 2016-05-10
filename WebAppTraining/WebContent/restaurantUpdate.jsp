<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<jsp:include page="/header.jsp" />
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/bootswatch-paper.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/libs/raty/jquery.raty.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/harasan.css"/>"/>

	<div class="container">
		<jsp:include page="/logo.jsp" />
		<div class="resultArea col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2 ">
		<div class="sub-header">
			<s:property value="title" />
			<p class="text-right">
				<s:property value="userId" /> さん
				<a href="menu.action">Back</a>
			</p>
		</div>

		<p class="err">
			<s:actionerror class="err"/>
		</p>
		<s:form method="post" enctype="multipart/form-data" cssClass="form-horizontal">
			<s:hidden name="id"></s:hidden>
			<div class="form-group">
				<label for="name" class="control-label"> 店舗名:</label>
				<s:textfield cssClass="form-control" name="name" placeholder="店舗名" />
			</div>
			<div class="form-group">
				<label for="area" class="control-label"> エリア:</label>
				<s:select cssClass="form-control" name="area" list="areaMap" />
			</div>
			<div class="form-group">
				<label for="stars" class="control-label"> 評価:</label>
				<div class="stars" value="<s:property value="stars"/>"></div>
			</div>
			<div class="form-group">
				<label for="comment" class="control-label"> コメント:</label>
				<s:textarea cssClass="form-control" name="comment" rows="5" placeholder="コメント" />
			</div>
			<div class="input-group customUpload">
				<s:file id="customUpload" name="image" label="参照" cssClass="file-upload"/>
				<input type="text" id="cu-imagePath" class="form-control" placeholder="画像を選んでもいいのよ">
				<span class="input-group-btn">
					<button id="cu-button" type="button" class="btn btn-default" >参照</button>
				</span>
			</div>
			<s:submit method="update" value="%{updateBtnTitle}" cssClass="btn btn-success btn-block" />
		</s:form>
		</div>
	<%--
		<s:form action="imageUpload" method="post" enctype="multipart/form-data" cssClass="customUpload">
			<s:file id="customUpload" name="upload" label="参照" cssClass="file-upload"/>
			<s:submit id="customUploadButton" cssClass="file-upload"></s:submit>
			<div class="input-group">
				<input type="text" id="cu-imagePath" class="form-control" placeholder="画像を選んでもいいのよ">
				<span class="input-group-btn">
					<button id="cu-button" type="button" class="btn btn-default" >参照</button>
					<button id="cu-upButton" type="button" class="btn btn-primary" >送信</button>
				</span>
			</div>
		</s:form>
		--%>
	</div>
	<script type="text/javascript" src="<s:url value="/assets/libs/raty/jquery.raty.js"/>"></script>
	<script type="text/javascript" src="<s:url value="/assets/js/harasan.js"/>"></script>
	</body>
</html>