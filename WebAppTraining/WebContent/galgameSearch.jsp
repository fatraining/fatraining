<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<!-- cssの設定 -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/galgame.css"/>" />

<body class="container">
	<!-- 研修Webアプリ -->
	<div class="text-center">
		<jsp:include page="logo.jsp"/>
	</div>

	<!-- タイトル -->
	<div class="text-center">
		<h2>〇□ゲー批評空間</h2>
	</div>

	<!-- 登録ユーザーID Back-->
	<div class="text-right">
		<s:property value="userId" />
		さん <a href="menu.action">Back</a>
	</div>
	<br />

	<!-- 削除・更新・追加完了メッセージの表示 -->

	<s:if test="%{hasCompleteMessage}">
		<div class="alert alert-success alert-dismissible">
			<button class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<s:property value="completeMessage" />
		</div>
	</s:if>

	<!-- 検索画面 -->
	<s:form cssClass="form-horizontal">
		<div class="form-group">
			<label class="col-sm-3 control-label"> メーカー </label>
			<div class="col-sm-7">
				<s:select cssClass="form-control" name="makerName" list="makerMap"></s:select>
			</div>
		</div>
		<br />

		<div class="form-group">
			<label class="col-sm-3 control-label"> 作品名 </label>
			<div class="col-sm-7">
				<s:textfield cssClass="form-control" name="name"
					placeholder="例：月姫"></s:textfield>
				<!-- placeholder=""で初期値を設定 -->
			</div>
		</div>
		<br />

		<br />
		<div class="form-group">
			<div class="btn-group col-sm-offset-2 col-sm-3">
				<s:submit type ="image" method="search" src="assets/images/temp/search.gif" alt = "検索" value="検索" />
			</div>

			<div class="btn-group col-sm-3">
				<s:submit type = "image" method="reset" src="assets/images/temp/reset.gif" alt = "リセット" value="リセット" />
			</div>

			<div class="btn-group col-sm-3">
				<s:submit type = "image" method="update" src="assets/images/temp/add.gif" alt = "追加" value="追加" />
			</div>
		</div>
		<br />

		<!-- エラーメッセージの表示 -->

		<s:if test="%{hasActionErrors}">
			<div class="alert alert-danger" style="list-style: none">
				<s:actionerror />
			</div>
		</s:if>


		<!-- 検索結果テーブル -->
		<div class="show">
			<s:if test="%{galgameTable.size!= 0}">
				<table class="sample_02">
					<!-- テーブルヘッダー -->
					<thead>
						<tr>
							<th>メーカ名</th>
							<th>作品名</th>
							<th>発売年</th>
							<th>評価点</th>
							<th>コメント</th>
							<th>更新</th>
							<th>削除</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="galgameTable">
							<tr>
								<td class="data"><s:property value="makerName" /></td>
								<td class="data"><s:property value="name" /></td>
								<td class="data"><s:property value="year" /></td>
								<td class="data"><s:property value="score" /></td>
								<td class="data"><s:property value="comment" /></td>
								<td class="data"><input type="button" id="update"
									name="updateBtn" value="更新" class="btn btn-info"
									forUpdate="<s:property value ="id"/>" /></td>
								<td class="data" width="5"><input type="checkbox"
									name="delete" value=<s:property value="id"/>></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
			<s:if test="%{galgameTable.size!= 0}">
				<div class="text-right">
					<p>削除する場合削除を押してください</p>
					<s:submit method="delete" value="削除" cssClass="btn btn-danger"></s:submit>
				</div>
			</s:if>
		</div>
	</s:form>
	<script type="text/javascript"
		src="<s:url value="/assets/js/galgame.js"/>"></script>
</body>
</html>