<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/aquarium.css"/>" />
<!-- ふるえるcss -->
<link rel="stylesheet" type="text/css"
	href="http://csshake.surge.sh/csshake.min.css">
<body>
	<s:form class="form-horizontal">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<div class="sub-header">
				<h2>さっきのデータを削除するよ</h2>
				<p class="text-right">
					<s:property value="userId" />
					さん <a href="aquariumSearch.action">Back</a>
				</p>
				<br>
			</div>

			<s:if test="%{aquariumTable.size!=0}">
				<div>
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>エリア</th>
								<th>水族館名</th>
								<th>入場料</th>
								<th>営業時間</th>
								<th>コメント</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="aquariumTable">
								<tr>
									<td class="data" width="75"><s:property value="area" /></td>
									<td class="data" width="190"><s:property value="name" /></td>
									<td class="data" width="60"><s:property value="price" /></td>
									<td class="data" width="180"><s:property value="hours" /></td>
									<td class="data"><s:property value="comment" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<!-- マウスポインタがのったら落ち着く -->
					<div
						class="shake shake-vertical-slow shake-constant shake-constant--hover">
						<s:submit method="delete" value="ほんとに消しちゃうからね"
							class="btn btn-primary" />
					</div>
				</div>
			</s:if>
		</div>
	</s:form>

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/shibata.js" />"></script>

</body>
</html>