<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="/headercopy.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/bootswatch-paper.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/libs/raty/jquery.raty.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/copy.css"/>" />

<div class="container">
	<jsp:include page="/logo.jsp" />
	<div
		class="resultArea col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2 ">
		<div class="sub-header-update">
			<Marquee behavior="alternate">
		<s:property value="TitleName" />
		</Marquee>
			<p class="text-right">
				<s:property value="userId" />
				さん <a href="<s:url action="copyUpdate" method="back" />">Back</a>
			</p>
			<img src="./assets/images/temp/copy_update.jpg" class="inserttitle">
		</div>

		<p class="err">
			<s:actionerror class="err" />
		</p>
		<s:form method="post" enctype="multipart/form-data"
			cssClass="form-horizontal insert">
			<s:hidden name="id"></s:hidden>
			<div class="form-group">
				<label for="name" class="control-label"> コピー名:</label>
				<s:textfield cssClass="form-control" name="name" placeholder="コピー名" />
			</div>
			<div class="form-group">
				<label for="title" class="control-label"> 初登場作品:</label>
				<s:select cssClass="form-control" name="title" list="titleMap" />
			</div>
			<div class="form-group">
				<label for="appearance" class="control-label"> 登場回数:</label><br/> <input
					type="number" name="appearance" value="<s:property value="appearance"/>">

			</div>
			<div class="input-group customUpload upform">
				<s:file id="customUpload" name="image" label="参照"
					cssClass="file-upload" />
				<input type="text" id="cu-imagePath" class="form-control"
					placeholder="画像(入力しないと画像なし)"> <span class="input-group-btn">
					<button id="cu-button" type="button" class="btn btn-default">参照</button>
				</span>
			</div>
			<div class="updatebtn">
			<s:submit method="update" value="%{updateBtnTitle}"
				cssClass="btn btn-success btn-block" />
				</div>
		</s:form>
	</div>
</div>
<script type="text/javascript"
	src="<s:url value="/assets/libs/raty/jquery.raty.js"/>"></script>
<script type="text/javascript" src="<s:url value="/assets/js/copy.js"/>"></script>
</body>
</html>