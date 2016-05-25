<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/bootstrap.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/vegas.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/yamamoto.css"/>" />
<body>
	<div id="wrapper">
		<div class="container">
			<jsp:include page="logo.jsp" />
			<p class="text-right">
				<a href="menu.action">Back</a>
			</p>
			<h1 class="h2 text-center">J3選手検索</h1>

			<s:form cssClass="form-horizontal">
				<div class="text-right">
					<s:property value="userId" />
					さん
				</div>

				<div class="form-group row">
					<label for="name" class="control-label col-sm-2">チーム名:</label>
					<div class="col-sm-10">
						<s:select id="team" cssClass="form-control select" name="teamID"
							list="teamMap" />
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="control-label col-sm-2">選手名:</label>
					<div class="col-sm-10">
						<s:textfield id="name" name="playerName" cssClass="form-control"
							placeholder="名前を入力" />
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="control-label col-sm-2">ポジション:</label>
					<div class="col-sm-10">
						<s:select id="position" name="position" list="positionMap"
							cssClass="form-control select" />
					</div>
				</div>
				<hr />

				<div class=" form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="button" id="search" value="検索"
							class="btn btn-default form-control" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2  col-sm-4">
						<input type="button" id="reset" value="リセット"
							class="btn btn-primary form-control" />
					</div>
					<div class="col-sm-offset-2 col-sm-4">
						<s:submit method="update" value="登録"
							cssClass="btn btn-success form-control" />
					</div>
				</div>
				<div class="result">
					<span class="msg" style="color: red"> <s:actionerror />
					 <s:property value="msg" />
					</span>
					<div class="table-responsive  col-sm-offset-2">
						<table class="tbl table-hover" style="display:none">
							<tbody>
								<tr>
									<th></th>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div id="delete" align=right></div>
				</div>
				<!--
				<s:if test="%{resultTable.size() > 0}">
					<div class="table-responsive  col-sm-offset-2">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>チーム名</th>
										<th>選手名</th>
										<th>ポジション</th>
										<th>年齢</th>
										<th>プロフィール</th>
										<th>削除</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="resultTable">
										<tr>
											<td class="data"><s:property value="teamName" /></td>
											<td class="data"><s:property value="playerName" /></td>
											<td class="data"><s:property value="position" /></td>
											<td class="data"><s:property value="age" /></td>
											<td class="data"><input type="button" name="profileBtn" value="profile"
												class="btn btn-info" data-toggle="modal" data-target="#profileModal"
												data-recipient="<s:property value="comment" />"
												data-whatever="<s:property value="imagePath" />" />
											<td class="data"><input type="checkbox" name="delete"
												value="<s:property value="playerID" />:<s:property value="playerName" />" /></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
					</div>
					<div align=right>
						<s:submit method="delete" name="delete" value="削除"
							cssClass="btn btn-danger" />
					</div>
					</s:if>
				-->
				<!-- モーダル・ダイアログ -->
				<div class="modal fade" id="profileModal" tabindex="-1">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span>×</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="bodyPane">
									<div class="imagePane">画像</div>
									<div class="commentPane">コメント</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">閉じる</button>
								<input type="button" value="更新" name="updateBtn"
									class="btn btn-primary" />
							</div>
						</div>
					</div>
				</div>
			</s:form>
		</div>
	</div>
	<script type="text/javascript"
		src="<s:url value="/assets/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript"
		src="<s:url value="/assets/js/vegas.min.js"/>"></script>
	<script type="text/javascript"
		src="<s:url value="/assets/js/yamavegas.js"/>"></script>
	<script type="text/javascript"
		src="<s:url value="/assets/js/yamamoto.js"/>"></script>
</body>
</html>