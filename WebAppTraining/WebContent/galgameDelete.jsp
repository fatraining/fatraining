<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />
<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/galgame.css"/>" />

<body class="container">
	<!-- 研修Webアプリverβ -->
	<div class="text-center">
		<jsp:include page="logo.jsp"></jsp:include>
	</div>

	<!-- タイトル -->
	<div class="text-center">
		<h1>〇□ゲー批評空間</h1>
	</div>

	<!-- 登録ユーザーID Back-->
	<div class="text-right">
		<s:property value="userId" />
		さん <a href="galgameSearch.action">Back</a>
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
			<s:if test="%{galgameTable.size!= 0}">
				<table class="sample_02">
					<!-- テーブルヘッダー -->
					<thead>
						<tr>
							<th>メーカ名</th>
							<th>商品名</th>
							<th>発売年</th>
							<th>評価点</th>
							<th>コメント</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="galgameTable">
							<tr>
								<td class="data" ><s:property value="makerName" /></td>
								<td class="data" ><s:property value="name" /></td>
								<td class="data" ><s:property value="year" /></td>
								<td class="data" ><s:property value="score" /></td>
								<td class="data" ><s:property value="comment" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
			<s:if test="%{galgameTable.size!= 0}">
				<div class="text-center">
					<s:submit method="delete" value="削除"
						cssClass="btn btn-danger btn-lg"></s:submit>
				</div>1
			</s:if>
		</div>
	</s:form>
</body>
</html>