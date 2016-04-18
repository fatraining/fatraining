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
		<p class="text-right"><a href="restaurantSearch.action">Back</a></p>
		<h1 class="h3 text-center">飲み屋新規登録</h1>
		<p class="err">
			<s:property value="errorMsg" />
		</p>
		<s:form cssClass="form-horizontal">
			<div class="text-right">
				<s:property value="userId" />
				さん
			</div>
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
			<s:submit method="insert" value="追加" cssClass="btn btn-success btn-block" />
		</s:form>
	</div>
	<script type="text/javascript" src="<s:url value="/assets/libs/raty/jquery.raty.js"/>"></script>
	<script type="text/javascript" src="<s:url value="/assets/js/harasan.js"/>"></script>
	</body>
</html>