<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<jsp:include page="/header.jsp" />
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/bootswatch-paper.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/harasan.css"/>"/>
	<body>
		<div class="container">
			<jsp:include page="/logo.jsp" />
			<p class="text-right"><a href="menu.action">Back</a></p>
			<h1 class="h3 text-center">今日はどこで飲む</h1>

			<s:form cssClass="form-horizontal" id="searchCondition">
			<div class="text-right">
				<s:property value="userId" />
				さん
			</div>

			<div class="form-group">
				<label for="name" class="control-label">店舗名:</label>
				<s:textfield name="name" cssClass="form-control" placeholder="店舗名がわかってるなら入れればいいじゃない"/>
			</div>
			<div class="form-group">
				<label for="stars" class="control-label">評価:</label>
				<s:textfield name="stars" cssClass="form-control" placeholder="評価"/>
			</div>
			<div class="form-group">
				<label for="area" class="control-label">エリア:</label>
				<s:textfield name="area" cssClass="form-control"/>
			</div>

			<div class="btn-group btn-group-justified">
				<s:submit method="search" value="検索" cssClass="btn btn-default" />
				<s:submit method="reset" value="リセット" cssClass="btn btn-danger" />
				<s:submit method="update" value="追加" cssClass="btn btn-primary" />
			</div>
			</s:form>
			<span style="color: red">
				<s:property value="errorMsg"/>
			</span>

			<s:if test="%{resultList.size!=0}">
			<s:form>
			<table id="resultTable" class="table table-borderd table-striped table-hover">
				<thead>
					<tr>
						<th>店舗名</th>
						<th>エリア名</th>
						<th>評価</th>
						<th>コメント</th>
						<th>削除</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="resultList">
					<tr>
						<td class="data"><s:property value="name" /></td>
						<td class="data"><s:property value="area.name" /></td>
						<td class="data"><s:property value="stars" /></td>
						<td class="data"><s:property value="comment" /></td>
						<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> />
						</td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
			<div align=right>
				<s:submit method="delete_id" name="delete_id" value="削除"
					cssClass="btn btn-danger" />
			</div>
			</s:form>
			</s:if>
		</div>
	</body>
</html>