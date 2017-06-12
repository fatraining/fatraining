<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />
</head>

<body>

<BODY
	background="http://www.wallpaper-box.com/cat/1366768/images/cat72.jpg"
	bgproperties="fixed">

	<div class="container">
		<div class="text-center">
			<jsp:include page="logo.jsp" />
		</div>
		<p class="text-right">
			<a href="menu.action">戻る</a>
		</p>
		<br>
		<div class="text-center">
			<h1>世界の猫検索</h1>
		</div>
		<br>
		<div class="text-right">
			<s:property value="userId" />
			さん
		</div>
		<br>

		<s:form class="form-horizontal">
			<div class="form-group">
				<label for="country" class="col-sm-2 control-label">国を選んでください</label>
				<div class="col-md-8">
					<s:select class="form-control" name="country" value="country"
						list="countryMap"></s:select>
				</div>
			</div>
			<br>

			<div class="form-group">
				<div class="col-md-offset-2 col-md-8">
					<s:submit method="search" value="検索"
						class="btn btn-warning btn-block" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-2 col-md-4">
					<s:submit method="reset" value="リセット"
						class="btn btn-danger btn-block" />
				</div>
				<div class="col-md-4">
					<s:submit method="update" value="追加"
						class="btn btn-info btn-block " />
				</div>
			</div>
			<br>

			<div>
				<div class="message">
					<s:actionerror />
					<s:property value="message" />
				</div>
				<br>
				<s:if test="%{resultTable.size > 0}">
					<table class="table table-striped table-bordered">
						<thead>
							<!-- テーブルヘッダー -->
							<tr>
								<th>名前</th>
								<th>原産国</th>
								<th>特徴</th>
								<th>更新</th>
								<th>削除</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="resultTable">
								<tr>
									<td class="data" width="200"><s:property value="name" /></td>
									<td class="data" width="100"><s:property value="country" /></td>
									<td class="data"><s:property value="comment" /></td>
									<td><input type="button" name="updateBtn" id="updateId"
										value="更新" class="btn btn-primary"
										forUpdate="<s:property value ="id"/>" /></td>
									<td class="data" width="50"><input type="checkbox"
										name="deleteId" value=<s:property value="id"/>></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</s:if>
				<s:if test="%{resultTable.size > 0}">
					<div class="text-right">
						<s:submit method="delete" value="削除" class="btn btn-danger" />
					</div>
					<br>
				</s:if>
			</div>
		</s:form>
	</div>

	<!-- javascript（更新時必要） -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/catUpdate.js" />"></script>

</body>
</html>