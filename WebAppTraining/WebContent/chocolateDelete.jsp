<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/chocolate.css"/>" />
<!-- ふるえるcss -->
<link rel="stylesheet" type="text/css"
	href="http://csshake.surge.sh/csshake.min.css">
<body>
<s:form class="form-horizontal">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<div class="text-left">
				<h2>Date Delete</h2>
				<p class="text-right">
					<s:property value="userId" />
					さん <a href="chocolateSearch.action">Back</a>
					<!-- chocolateSearch.jspとactionが一緒に使われているページ、つまりトップページに戻る -->
				</p>
				<br>
			</div>

			<s:if test="%{chocolateTable.size!=0}">
				<div>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Image</th>
								<th>Area</th>
								<th>Shop name</th>
								<th>Chef</th>
								<th>Comment</th>
								<th>Price</th>

							</tr>
						</thead>
						<tbody>
							<s:iterator value="chocolateTable">
								<tr>
									<td class="data" width="150"><img
										src="<s:property value="image"/>" alt="NO IMAGE!" width="80"
										height="110"></td>
									<td class="data" width="75"><s:property value="country" /></td>
									<td class="data" width="190"><s:property value="shopName" /></td>
									<td class="data" width="60"><s:property value="Chef" /></td>
									<td class="data" width="150"><s:property value="Comment" /></td>
									<td class="data" width="150"><s:property value="Price" /></td>

								</tr>
							</s:iterator>
						</tbody>
					</table>
					<!-- マウスポインタがのったら落ち着く -->
					<div
						class="shake shake-vertical-slow shake-constant shake-constant--hover">
						<s:submit method="delete" value="Delete"
							class="btn btn-primary" />
					</div>
				</div>
			</s:if>
		</div>
	</s:form>

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/muto.js" />"></script>

</body>
</html>