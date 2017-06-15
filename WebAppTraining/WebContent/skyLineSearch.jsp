<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/skyLine.css"/>" />
<jsp:include page="/skyLineHeader.jsp" />
<body>
	<div class="text-center">
		<jsp:include page="logo.jsp" />
	</div>
	<div class="col-xs-12" style="background: #4072B3; height: 60px;">
		<div class="sub-header">
			<p class="text-right"
				style="color: #DCDCDC; position: relative; bottom: -5px;">
				<s:property value="userId" />
				さん <a href="menu.action"><img src="assets/images/uturn.png"
					border="0" class="return"></a>
			</p>
		</div>
		<s:form cssClass="form-horizontal">
			<div class="form-group">
				<div class="co3">
					<div class="col-xs-1">
						<s:submit type="image" src="assets/images/home.png" method="reset"
							value="リセット" class="icon2" />
						<div>
							<label class="home">home</label>
						</div>
					</div>
				</div>
				<div class="col2">
					<div class="col-xs-1">
						<div class="select-wrap select-inverse">
							<s:select name="age" value="age" list="skyLineAgeMap" />
						</div>
					</div>
				</div>
				<div class="col">
					<div class="col-xs-1">
						<s:submit type="image" src="assets/images/search.png"
							method="search" value="search" class="icon1" />
					</div>
				</div>
				<div class="co4">
					<div class="col-xs-1">
						<s:submit type="image" src="assets/images/add.png" method="update"
							value="追加" class="icon3" />
						<div>
							<label class="add2">追加</label>
						</div>
					</div>
				</div>
				<div class="skyline">
					<a href="http://www2.nissan.co.jp/SKYLINE/"> SKYLINE <img
						src="assets/images/car.png">
					</a>
				</div>
			</div>
		</s:form>
	</div>
	<s:form cssClass="form-horizontal">
		<div class="message">
			<s:actionerror />
		</div>
		<div class="action">
			<s:property value="message" />
		</div>
		<br>
		<div class="tableAll">
			<s:if test="%{skyLineTable.size > 0}">
				<table id="skyLine" class="table">
					<thead>
						<tr>
							<th>販売開始</th>
							<th>型番</th>
							<th>キャッチコピー</th>
							<th>更新</th>
							<th>削除</th>
					</thead>
					<tbody>
						<s:iterator value="skyLineTable">
							<tr>
								<td class="data"><s:property value="date" /></td>
								<td class="data"><s:property value="model" /></td>
								<td class="data"><s:property value="nickname" /></td>
								<td><input type="button" name="updateBtn" value=""
									id="update" forUpdate="<s:property value ="id"/>" /></td>
								<td class="data"><input type="checkbox" name="delete"
									value=<s:property value="id"/>></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<s:if test="%{skyLineTable.size > 0}">
					<div class="de">
						<s:submit type="image" method="delete"
							src="assets/images/cross.png" value="削除" class="icon4" />
					</div>
		</div>
		</s:if>
		</s:if>
	</s:form>

	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
	<script type="text/javascript"
		src="<s:url value="/assets/js/skyLine.js" />"></script>

</body>
</html>