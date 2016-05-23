<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<jsp:include page="header.jsp" />
<head>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/tablesorter-baseball/baseballSearch.css"/>" />
</head>
<body>
	<div class="container">
		<jsp:include page="logo.jsp" />
		<p class="text-right">
			<a href="baseballSearch.action">Back</a>
		</p>
		<s:if test="%{delete==null}">
			<div style="margin: 30px">
				<h1 class="h2 text-center">語録登録</h1>
			</div>
			<p class="err">
				<s:actionerror class="error" />
			</p>

			<s:form cssClass="form-horizontal" enctype="multipart/form-data"
				method="post">
				<div class="form-group">
					<label class="control-label col-sm-2">球団：</label>
					<div class="col-sm-9">
						<s:select cssClass="form-control select" name="teamID"
							list="teamMap" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">名前：</label>
					<div class="col-sm-9">
						<s:textfield name="baseballPlayer" cssClass="form-control"
							placeholder="名前を入力" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">対象（任意）：</label>
					<div class="col-sm-9">
						<s:textfield name="target" cssClass="form-control"
							placeholder="対象を入力" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">日付（任意）：</label>
					<div class="col-sm-9">
						<s:textfield name="date" cssClass="form-control"
							placeholder="日付を入力" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-sm-2">語録：</label>
					<div class="col-sm-9">
						<s:textarea name="comment" cssClass="form-control"
							placeholder="語録を入力" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2">備考（任意）：</label>
					<div class="col-sm-9">
						<s:textarea name="note" cssClass="form-control"
							placeholder="ソース、状況等を入力" />
					</div>
				</div>

				<div style="padding: 20px">
					<div class="col-sm-offset-2">
						<s:submit method="insert" value="登録"
							cssClass="btn btn-success form-control" />
					</div>
				</div>
			</s:form>
		</s:if>
		<s:if test="%{delete!=null}">
			<h3>チェックしたデータを削除します</h3>
			<td class="data">削除するデータ:<s:property value="delete" /></td>
			<s:form cssClass="form-horizontal">
				<s:submit method="delete" value="削除" cssClass="btn btn-danger " />
				<a href="baseballSearch.action">Back</a>
			</s:form>
		</s:if>
	</div>
	<script type="text/javascript" src="<s:url value="/assets/js/baseballSearch.js"/>"></script>
</body>
</html>