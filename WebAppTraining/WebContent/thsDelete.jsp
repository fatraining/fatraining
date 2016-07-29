<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/ths.css"/>" />
<body>
	<div class="back">
		<s:form class="form-horizontal">
			<div class="container">
				<div class="text-center">
					<jsp:include page="logo.jsp" />
				</div>
				<p class="text-right">
					<a href="thsSearch.action">Back</a>
				</p>
				<br>
				<div class="sub-header text-center">
					<h2>データを削除します</h2>
				</div>
				<p class="text-right">
					<s:property value="userId" />
					さん
				</p>
				<br>


				<s:if test="%{thsTable.size!=0}">
					<div>
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>科目</th>
									<th>講師名</th>
									<th>レベル</th>
									<th>コメント</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="thsTable">
									<tr>
										<td class="data" width="60"><s:property value="subject" /></td>
										<td class="data" width="100"><s:property value="name" /></td>
										<td class="data" width="60"><s:property value="level" /></td>
										<td class="data"><s:property value="comment" /></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						<div class="text-right">
							<s:submit method="delete" value="削除"
								class="btn btn-danger btn-lg" />
						</div>
					</div>
				</s:if>


			</div>
		</s:form>
	</div>
</body>
</html>