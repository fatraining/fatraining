<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="/header.jsp" />

<script type="text/javascript"
	src="<s:url value="/assets/js/baseballSearch.js"/>"></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/jquery.tablesorter.baseball.js"/>"></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/baseball.top.js"/>"></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/baseball.br"/>"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/tablesorter-baseball/baseballSearch.css"/>" />

<style>
</style>

</head>

<body>
	<s:form>
		<div class="container">
			<jsp:include page="/logo.jsp" />

			<p class="text-right">
				<a href="menu.action">Back</a>
			</p>

			<h2 class="text-center">野球選手と愉快な仲間たち</h2>

			<div class="text-right"
				style="padding-bottom: 10px; font-size: 1.2em;">
				<s:property value="userID" />
				さん
			</div>

			<div class="form-horizontal">
				<div class="form-group">
					<label for="team" class="col-sm-2 control-label"> 球団: </label>
					<div class="col-md-3">
						<s:select name="teamID" cssClass="form-control" rows="1"
							maxlength="50" value="team" list="teamMap" />
					</div>

					<label for="baseballPlayer" class="col-sm-2 control-label">
						名前: </label>
					<div class="col-md-3">
						<s:textfield name="baseballPlayer" cssClass="form-control"
							rows="1" maxlength="50" />
					</div>
				</div>

				<div class="form-group">
					<label for="date" class="col-sm-2 control-label"> 日付: </label>
					<div class="col-md-3">
						<s:textfield name="date" cssClass="form-control" rows="1"
							maxlength="50" />
					</div>

					<label for="target" class="col-sm-2 control-label"> 対象: </label>
					<div class="col-md-3">
						<s:textfield name="target" cssClass="form-control" rows="1"
							maxlength="50" />
					</div>
				</div>

				<div class="form-group">
					<label for="comment" class="control-label col-sm-2">キーワード:</label>
					<div class="col-sm-8">
						<s:textfield name="comment" cssClass="form-control"
							placeholder="語録から検索" />
					</div>
				</div>

				<div class="form-group">
					<label for="note" class="control-label col-sm-2">備考:</label>
					<div class="col-sm-8">
						<s:textfield name="note" cssClass="form-control"
							placeholder="ソース、状況、etc." />
					</div>
				</div>
			</div>

			<div class="form-group col-md-offset-2 col-md-8"
				style="padding-top: 10px;">
				<s:submit method="search" value="検索"
					cssClass="form-control btn btn-info" />
				<br>
			</div>
			<div class="row col-md-offset-3">
				<div class="form-group col-md-4">
					<s:submit method="reset" value="リセット"
						cssClass="form-control btn btn-warning" />
				</div>
				<div class="form-group col-md-4">
					<s:submit method="update" value="追加"
						cssClass="form-control btn btn-success" />
				</div>
			</div>

			<div class="message">
				<s:actionerror />
				<s:property value="message" />
			</div>

		</div>
		<div class="show">
			<s:if test="%{baseballPlayerTable.size > 0}">
				<div class="table-responsive">
					<table id="baseballPlayer" class="tablesorter">
						<thead>
							<tr>
								<th>球団</th>
								<th>名前</th>
								<th class="a">語録</th>
								<th>対象</th>
								<th>日付</th>
								<th class="b">備考</th>
								<th>削除</th>
						</thead>
						<tbody>
							<s:iterator value="baseballPlayerTable">
								<tr>
									<td class="data" align="center"><s:property value="team" /></td>
									<td class="data" align="center"><s:property
											value="baseballPlayer" /></td>
									<td class="data"><s:property value="comment" escape="false" /></td>
									<td class="data" align="center"><s:property value="target" /></td>
									<td class="data" align="center"><s:property value="date" /></td>
									<td class="data"><s:property value="note" /></td>
									<td class="data" align="center"><input type="checkbox"
										name="delete" value=<s:property value="ID"/>></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</s:if>
			<s:if test="%{baseballPlayerTable.size > 0}">
				<div align=right style="padding-top: 20px;">
					<s:submit method="delete" name="delete" value="消す"
						cssClass="btn btn-danger" />
				</div>
			</s:if>

		</div>

	</s:form>
	<p id="page-top">
		<a href="#wrap">PAGE TOP</a>
	</p>

	<script>
		$(document).ready((function($) {
			$('#baseballPlayer').tablesorter({
				widgets : [ 'zebra' ],
				headers : {
					7 : {
						sorter : false
					}
				}
			});
		}));
	</script>
</body>
</html>