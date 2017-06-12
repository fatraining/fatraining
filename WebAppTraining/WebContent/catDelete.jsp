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

	<s:form class="form-horizontal">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<div class="sub-header">
				<h2>削除</h2>
				<p class="text-right">
					<a href="catSearch.action">戻る</a> <br>
					<s:property value="userId" />
					さん
				</p>
				<br>
			</div>

			<s:if test="%{resultTable.size!=0}">
				<div>
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>名前</th>
								<th>原産国</th>
								<th>特徴</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="resultTable">
								<tr>
									<td class="data" width="200"><s:property value="name" /></td>
									<td class="data" width="100"><s:property value="country" /></td>
									<td class="data" width="300"><s:property value="comment" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div class="text-right">
						<s:submit method="delete" value="削除" class="btn btn-danger" />
					</div>
				</div>
			</s:if>
		</div>
	</s:form>

</body>