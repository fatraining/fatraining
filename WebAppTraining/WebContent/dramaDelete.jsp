<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/drama.css"/>" />

<body>
<div class="snow">●</div>
	<s:form class="form-horizontal">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<div class="sub-header">
				<h2>選択した作品を削除します</h2>
				<p class="text-right">
					<s:property value="userId" />
					さん <a href="dramaSearch.action">Back</a>
				</p>
				<br>
			</div>

			<s:if test="%{dramaTable.size!=0}">
				<div>
					<table>
						<thead>
							<tr>
								<th>ジャンル</th>
								<th>作品名</th>
								<th>キャスト</th>
								<th>放送局</th>
								<th>コメント</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="dramaTable">
								<tr>
									<td class="data" width="200"height="50"><s:property value="genre" /></td>
									<td class="data" width="300"height="50"><s:property value="name" /></td>
									<td class="data" width="200"height="50"><s:property value="cast" /></td>
									<td class="data" width="100"height="50"><s:property value="tvStation" /></td>
									<td class="data" width="450"height="50"><s:property value="comment" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>

					<div>
						<s:submit method="delete" value="削除するニダ"
							class="btn btn-primary" />
					</div>
				</div>
			</s:if>
		</div>
	</s:form>

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/sugawara.js" />"></script>

</body>
</html>