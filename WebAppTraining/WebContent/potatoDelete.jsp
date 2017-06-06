<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />
<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/potato.css"/>" />

<body class="container">
	<!-- 研修Webアプリverβ -->
	<div class="text-center">
		<jsp:include page="logo.jsp"></jsp:include>
	</div>

	<!-- タイトル -->
	<div class="text-center">
		<h1>ポテトチップス検索</h1>
	</div>

	<!-- 登録ユーザーID Back-->
	<div class="text-right">
		<s:property value="userId" />
		さん <a href="menu.action">Back</a>
	</div>
	<br />

	<div class="text-center">
		<h2>
			<s:property value="message" />
		</h2>
	</div>

	<!-- 削除する検索結果を表示 -->
	<s:form cssClass="form-horizontal">
		<!-- 検索結果テーブル -->
		<div class="show">
			<s:if test="%{potatoTable.size!= 0}">
				<table class="table table-striped table-bordered">
					<!-- テーブルヘッダー -->
					<thead>
						<tr>
							<th>メーカ名</th>
							<th>商品名</th>
							<th>商品タイプ</th>
							<th>内容量(g)</th>
							<th>価格</th>
							<th>コメント</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="potatoTable">
							<tr>
								<td class="data" width="100"><s:property value="makerName" /></td>
								<td class="data" width="180"><s:property value="name" /></td>
								<td class="data" width="90"><s:property value="type" /></td>
								<td class="data" width="80"><s:property value="volume" /></td>
								<td class="data" width="50"><s:property value="price" /></td>
								<td class="data" width="100"><s:property value="comment" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
			<s:if test="%{potatoTable.size!= 0}">
				<div class="text-center">
					<s:submit method="delete" value="食べきる"
						cssClass="btn btn-danger btn-lg"></s:submit>
				</div>
			</s:if>
		</div>
	</s:form>
</body>
</html>