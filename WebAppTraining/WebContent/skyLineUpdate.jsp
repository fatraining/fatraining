<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/skyLine.css" />" />
<link rel="stylesheet" type="text/css"
	href="/WebAppTraining/assets/css/training2016.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<body>

	<div class="text-center">
		<jsp:include page="logo.jsp" />
	</div>
	<div class="col-xs-12" style="background: #4072B3; height: 60px;">
		<div class="sub-header">
			<p class="text-right"
				style="color: #DCDCDC; position: relative; bottom: -5px;">
				<s:property value="userId" />
				さん <a href="skyLineSearch.action"><img
					src="assets/images/uturn.png" border="0" class="return"></a>
			</p>
		</div>
	</div>
	<div class="error">
		<s:actionerror />
		<s:property value="errorMessage" />
	</div>
	<div class="f">
		<s:form cssClass="form-horizontal">
			<s:hidden name="id"></s:hidden>
			<div class="form-group">
				<label>カテゴリー:</label>
				<s:select name="ageId" value="ageId" list="skyLineAgeMap"
					class="form2" />
				<img class="icon5" src="assets/images/arrow.png">
			</div>
			<br>
			<div class="form-group">
				<label>販売開始:</label>
				<p />
				<s:textfield name="date" placeholder="" class="form1" />
				<div class="line"></div>
			</div>
			<br>
			<div class="form-group">
				<label>型番:</label>
				<p />
				<s:textfield name="model" placeholder="" class="form1" />
				<div class="line"></div>
			</div>
			<br>
			<div class="form-group">
				<label>キャッチコピー:</label>
				<p />
				<s:textfield name="nickname" placeholder="" class="form1" />
				<div class="line"></div>
				<br>
			</div>
			<div class="add">
				<s:submit type="image" src="assets/images/add2.png" method="update"
					value="%{updateBtnTitle}" class="icon33" />
			</div>
		</s:form>
	</div>
</body>
</html>