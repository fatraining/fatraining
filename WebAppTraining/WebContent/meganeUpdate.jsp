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
	href="<s:url value="/assets/css/megane.css" />" />


</head>
<body>
	<font color="#FFFFFF">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<div class="text-left">
				<h2>
					<font size="6" color="#FF0000">👓</font>
					<s:property value="title" />
					<!-- タイトル -->
					<font size="6" color="#FF0000">👓</font>
				</h2>
			</div>
			<br>
			<div class="text-right">
				<s:property value="userId" />
				さん <a href="meganeSearch.action">Back</a>
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
					<label class=" control-label col-sm-2">形：</label>
					<div class="col-md-6">
						<s:select cssClass="form-control" name="meganeAreaId"
							list="MeganeForm"></s:select>
					</div>
				</div>

				<div class="form-group">
					<label class=" control-label col-sm-2"> ブランド名: </label>
					<div class="col-md-6">
						<s:textfield name="name" cssClass="form-control" placeholder="" />
					</div>
				</div>


				<div class="form-group">
					<label class=" control-label col-sm-2"> カラー: </label>
					<div class="col-md-6">
						<s:textfield name="color" class=" form-control" placeholder="" />
					</div>
				</div>


				<div class="form-group">
					<label class=" control-label col-sm-2">
						金額:(半角数字だけいれてくださいお願いします) </label>
					<div class="col-md-6">
						<s:textfield name="kingaku" class="form-control" placeholder="" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-sm-2">リンク：</label>
					<div class="col-md-6">
						<s:textfield name="link" class="form-control" placeholder="" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-sm-2">詳細：</label>
					<div class="col-md-6">
						<s:textfield name="syousai" class="form-control" placeholder="" />
					</div>
				</div>


				<div class="form-group">
					<p class="sub_title">
						画像アップロード:<br>
					</p>
					<s:file id="id" name="gazou" label="参照"
						 />
				</div>



				<div class="form-group text-right">


					<%-- <s:submit method="insert" value="追加" class="btn btn-info btn-lg" /> --%>


					<s:submit method="update" value="%{updateBtnTitle}"
						cssClass="btn btn-info btn-lg" />
				</div>
			</s:form>
		</div> <!-- javascript --> <script type="text/javascript"
			src="<s:url value="/assets/js/nakagawa.js" />"></script>
	</font>
</body>
</html>