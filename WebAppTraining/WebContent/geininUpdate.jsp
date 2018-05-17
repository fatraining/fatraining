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
	href="<s:url value="/assets/css/maiwaifu.css" />" />

<script>

</script>
</head>
<body>
	<div class="container">
		<div class="text-center">
			<jsp:include page="logo.jsp" />
		</div>
		<div class="text-left">
	<br>	<br>
		<center>
					<img src="assets/images/temp/addheart.jpg" border="0" width="150"
			 onmouseover="width=150; this.src='assets/images/temp/addheart_over.jpg'"
			 onmouseout="width=150; this.src='assets/images/temp/addheart.jpg'">
</center>


			<!-- <h2>
				<s:property value="title" />
			</h2> -->
		</div>
		<br>
		<div class="text-right">
			<s:property value="userId" />
			様 <a href="maiwaifuSearch.action">Back</a>
		</div>
		<br>

		<div class="errorMessage">
			<s:actionerror />
			<s:property value="errorMessage" />
		</div>
		<br>
<!--追加する項目書く枠-->
				<div class="text-center">

		<s:form class="form-horizontal">
			<s:hidden name="id"></s:hidden>
			<div class="form-group">
				<label class=" control-label col-sm-2">生息地：</label>
				<div class="col-md-6">
					<s:select cssClass="form-control" name="maiwaifuAreaId"
						list="maiwaifuAreaMap"></s:select>
				</div>
			</div>
						<div class="form-group">
				<label class=" control-label col-sm-2"> 写真: </label>
				<div class="col-md-6">
					<s:textfield name="image" cssClass="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> 名前: </label>
				<div class="col-md-6">
					<s:textfield name="name" cssClass="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label for="price" class="col-sm-2 control-label"> ジャンル: </label>
				<div class="col-md-6">
					<s:select class="form-control" name="genre" list="genreMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> 年齢: </label>
				<div class="col-md-6">
					<s:textfield name="age" class="form-control" placeholder="" />
				</div>
			</div>

			<div class="form-group">
				<label class=" control-label col-sm-2"> コメント: </label>
				<div class="col-md-6">
					<s:textarea name="comment" cssClass="form-control" rows="3"
						placeholder="" />

				</div>
			</div>
					<br>

			<div >
			<br>
<center>
				<%-- <s:submit method="insert" value="追加" class="btn btn-info btn-lg" /> --%>
				<s:submit type ="image"  src="assets/images/temp/s_fbotan.jpg"



				method="update" value="追加" />
				</center>
			</div></div>
		</s:form>
	</div>
<br><br><br><br><br>
	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/mori.js" />"></script>

</body>
</html>