<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/skyLine.css" />" />
<link rel="stylesheet" type="text/css"
	href="/WebAppTraining/assets/css/training2016.css">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<s:form class="form-horizontal">
		<div class="tableAll">
			<s:if test="%{skyLineTable.size > 0}">
				<table id="skyLine" class="table">
					<thead>
						<tr>
							<th>販売日</th>
							<th>型番</th>
							<th>ニックネーム</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="skyLineTable">
							<tr>
								<td class="data"><s:property value="date" /></td>
								<td class="data"><s:property value="model" /></td>
								<td class="data"><s:property value="nickname" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<div class="text-right">
					<div class="de">
						<input type="image" alt="削除"
							src="assets/images/cross.png"
							id="skyLineSearch__delete" name="method:delete" value="削除"
							class="icon4">
					</div>
				</div>
			</s:if>
		</div>
	</s:form>
</body>
</html>