<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/ozaki.css"/>" />

<body class="container">
	<!-- 研修Webアプリverβ -->
	<div class="text-center">
		<jsp:include page="logo.jsp"></jsp:include>
	</div>

	<!-- タイトル -->
	<div class="text-center">
		<h1>尾崎豊 曲検索</h1>
	</div>

	<!-- 登録ユーザーID 戻る -->
	<div class="text-right">
		<s:property value="userId" />
		さん<a href="ozakiSearch.action">戻る</a>
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
			<s:if test="%{ozakiTable.size!= 0}">
				<table class="table table-striped table-bordered">
					<!-- テーブルヘッダー -->
					<thead>
						<tr>
							<th>アルバム名</th>
							<th>曲名</th>
							<th>作詞・作曲</th>
							<th>年代</th>
							<th>歌詞</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="ozakiTable">
							<tr>
								<td class="data" width="90"><s:property value="albumName" /></td>
								<td class="data" width="120"><s:property value="songName" /></td>
								<td class="data" width="100"><s:property value="songWriting" /></td>
								<td class="data" width="80"><s:property value="age" /></td>
								<td class="data" width="140"><s:property value="lyrics" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
			<s:if test="%{ozakiTable.size!= 0}">
				<div class="text-center">
					<s:submit method="delete" value="削除する"
						cssClass="btn btn-danger btn-lg"></s:submit>
				</div>
			</s:if>
		</div>
	</s:form>
</body>
</html>