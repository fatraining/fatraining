<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="/header.jsp" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/yamazaki.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/catViewer.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/yamazakiSearch.css"/>" />

<style>
</style>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/yamazaki.js"/>"></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/catViewer.js"/>"></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/yamazakiSearch.js"/>"></script>
</head>

<body>
	<div class="container">
		<jsp:include page="/logo.jsp" />

		<p class="text-right">
			<a href="menu.action">Back</a>
		</p>

		<div class="flashWrap">
			<div class="flash">
				<ul>
					<%
						for (int i = 1; i <= 11; i++) {
					%>
					<li><img src="assets/images/catFootprint2.png"
						alt="catFootprint"></li>
					<%
						}
					%>
					<li><img src="assets/images/catSilhouette.png"
						alt="catSilhouette" class="catSilhouette"></li>
				</ul>
			</div>
		</div>

		<h2 class="split">猫カフェ検索</h2>

		<s:form>

			<div class="text-right"
				style="padding-bottom: 10px; font-size: 1.2em;">
				<s:property value="userID" />
				さん
			</div>
			<div class="slideShow">
				<div class="mainView">
					<ul>
						<li><a href="#1"><img src="assets/images/cat1.jpg"
								alt="cat1"></a></li>
						<li><a href="#2"><img src="assets/images/cat2.jpg"
								alt="cat2"></a></li>
						<li><a href="#3"><img src="assets/images/cat3.jpg"
								alt="cat3"></a></li>
						<li><a href="#4"><img src="assets/images/cat4.jpg"
								alt="cat4"></a></li>
						<li><a href="#5"><img src="assets/images/cat5.jpg"
								alt="cat5"></a></li>
						<li><a href="#6"><img src="assets/images/cat6.jpg"
								alt="cat6"></a></li>
					</ul>
				</div>

				<div class="thumbNail">
					<ul>
						<li><img src="assets/images/cat1.jpg" alt="cat1"></li>
						<li><img src="assets/images/cat2.jpg" alt="cat2"></li>
						<li><img src="assets/images/cat3.jpg" alt="cat3"></li>
						<li><img src="assets/images/cat4.jpg" alt="cat4"></li>
						<li><img src="assets/images/cat5.jpg" alt="cat5"></li>
						<li><img src="assets/images/cat6.jpg" alt="cat6"></li>
					</ul>
				</div>
			</div>
			<div class="form-horizontal">
				<div class="form-group" style="padding-top: 30px;">
					<label for="prefecture" style="font-size: 1.2em;">都道府県：</label>
					<s:select name="prefecture" cssClass="form-control"
						value="prefecture" list="prefectureMap" />
				</div>

				<div class="form-group">
					<label for="station" style="font-size: 1.2em;">最寄駅：</label>
					<s:textfield name="station" cssClass="form-control" />
				</div>

				<div class="form-group">
					<label for="catcafeName" style="font-size: 1.2em;">店名：</label>
					<s:textfield name="catcafeName" cssClass="form-control" />
				</div>
			</div>

			<div class="form-group col-md-offset-2 col-md-8"
				style="padding-top: 10px;">
				<s:submit method="search" value="検索"
					cssClass="form-control btn btn-info" />
				<br>
			</div>
			<div class="row col-md-offset-3">
				<div class="form-group col-md-4">
					<s:submit method="reset" value="リセット"
						cssClass="form-control btn btn-warning" />
				</div>
				<div class="form-group col-md-4">
					<s:submit method="update" value="追加"
						cssClass="form-control btn btn-success" />
				</div>
			</div>
	</div>

	<div class="show">
		<div class="message">
			<s:actionerror />
			<s:property value="message" />
		</div>

		<s:if test="%{catcafeTable.size > 0}">
			<table id="catcafe" class="table">
				<thead>
					<tr>
						<th>都道府県</th>
						<th>最寄駅</th>
						<th>店名</th>
						<th>営業時間</th>
						<th>定休日</th>
						<th>コメント</th>
						<th>削除</th>
				</thead>
				<tbody>
					<s:iterator value="catcafeTable">
						<tr>
							<td class="data"><s:property value="prefecture" /></td>
							<td class="data"><s:property value="station" /></td>
							<td class="data"><s:property value="catcafeName" /></td>
							<td class="data"><s:property value="hours" /></td>
							<td class="data"><s:property value="closed" /></td>
							<td class="data"><s:property value="comment" /></td>
							<td class="data"><input type="checkbox" name="delete"
								value=<s:property value="ID"/>></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<s:if test="%{catcafeTable.size > 0}">
				<div align=right style="padding-bottom: 80px;">
					<s:submit method="delete" name="delete" value="削除"
						cssClass="btn btn-danger" />
				</div>
			</s:if>
		</s:if>
	</div>
	</s:form>

</body>
</html>