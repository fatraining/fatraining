
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<jsp:include page="/header.jsp" />
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/bootswatch-paper.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/libs/raty/jquery.raty.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/harasan.css"/>"/>
	<body>
		<div class="container">
			<jsp:include page="/logo.jsp" />
			<p class="text-right"><a href="menu.action">Back</a></p>
			<h1 class="h3 text-center"><s:property value="title" /></h1>

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
				<label for="stars" class="control-label"> 評価(クリックで確定):</label>
				<div class="stars" value="<s:property value="stars"/>"></div>
			</div>
			<div class="form-group">
				<label for="area" class="control-label">エリア:</label>
				<s:select name="area" value="area" list="areaMap" cssClass="form-control"/>
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
						<th class="per-12 center">店舗名</th>
						<th class="per-12 center">エリア名</th>
						<th class="per-16 center">評価</th>
						<th class="per-46 center">コメント</th>
						<th class="per-7 center">更新</th>
						<th class="per-7 center">削除</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="resultList">
					<tr>
						<td class="data center"><s:property value="name" /></td>
						<td class="data center"><s:property value="area.name" /></td>
						<td class="data"><div class="stars-readOnly" value="<s:property value="stars"/>"></div></td>
						<td class="data"><s:property value="comment" /></td>
						<td class="data"><input type="button" name="updateBtn" value="更新"
							class="btn btn-primary" forUpdate="<s:property value="id"/>" />
						</td>
						<td class="data center"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> />
						</td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
			<div align=right>
				<s:submit id="deleteBtn" method="delete" value="削除" cssClass="btn btn-danger" />
			</div>
			</s:form>
			</s:if>
		</div>
		<script type="text/javascript" src="<s:url value="/assets/libs/raty/jquery.raty.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/assets/js/harasan.js"/>"></script>
	</body>
</html>