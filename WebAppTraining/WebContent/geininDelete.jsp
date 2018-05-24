<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html">
<html>
<head>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<%-- CSS --%>
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/geinin.css"/>" />

</head>

<body>

<div class="container">

	<!-- 研修Webアプリverβ -->
	<div class="text-center">
		<jsp:include page="logo.jsp"></jsp:include>
	</div>

		<div class="text-right">
<!-- Back、USERID -->
		<h3><a href="menu.action">Back</a></h3>
	 	<s:property value="userId" />
			様

		</div>

<!-- MESSAGE -->
	<div class="text-center">
		<h3>
			<s:property value="message" />
		</h3>
	</div>

	<!--最初にformを指定する。テキストスタイル的な。-->
<s:form cssClass="form-horizontal">

	<!-- 削除する検索結果を表示 -->
	<s:form cssClass="form-horizontal">
		<!-- 検索結果テーブル -->
		<div class="show">
			<s:if test="%{geininList.size > 0}">
				<table class="table table-hover table-bordered">
					<!-- テーブルヘッダー -->
					<thead>
						<tr>
							<th>画像</th>
							<th>名前</th>
							<th>代表ネタ</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="geininList">
							<tr>
									<td class="data" width="210">
										<img src="assets/images/geinin/<s:property value="image"/>" alt="NO IMAGE!" width="200"></td>
									<td class="data" width="150"><s:property value="name" /></td>
									<td class="data"><s:property value="work" /></td>							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
			<s:if test="%{geininList.size > 0}">
				<div class="text-center">
					<s:submit method="delete" value="削除する"
						cssClass="btn btn-danger btn-lg"></s:submit>
				</div>
			</s:if>
		</div>
	</s:form>

	</s:form>

</div>
</body>
</html>