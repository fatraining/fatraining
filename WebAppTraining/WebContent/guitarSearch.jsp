<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
	<jsp:include page="header.jsp"/>

	<script type="text/javascript" src="<s:url value="/assets/js/vegas.min.js"/>"></script>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/suzuki.css"/>"/>

<body>
<s:form cssClass="form-horizontal">
		<div class="container">
			<jsp:include page="logo.jsp" />
			<p class="text-right">
				<a href="menu.action">Back</a>
			</p>
			<br>
			<h1 class="h3 text-left" id="heading02">国産ハイエンドギター検索</h1>

			<div class="text-right">
				<s:property value="UserID" />
				さん
			</div>
			<div class="form-group" style="padding-top: 30px;">
				<label for="name" style="font-size: 1.5em;">メーカー名：</label>
				<s:select name="name"  value = "name" list="nameMap" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="typeName" style="font-size: 1.5em;">型名：</label>
				<s:textfield name="typeName" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="price" class="col-sm-2 control-label" style="font-size: 1.5em;">
					価格: </label>
				<div class="col-md-3">
					<s:textfield name="PriceLow" cssClass="form-control" rows="1"
						maxlength="50" />
				</div>
				<label class="col-sm-1 control-label" style="font-size: 1.5em;">～<br />
				</label>
				<div class="col-md-3">
					<s:textfield name="PriceHi" cssClass="form-control" rows="1"
						maxlength="50" />
				</div>
				<div>
					<label class="col-sm-1 control-label" style="font-size: 1.5em;">円</label>
				</div>
			</div>
			<div class="search">
				<div class="row">
					<div class="col-sm-offset-4 col-sm-4">
						<s:submit method="search" value="検索"
							cssClass="btn btn-default btn-block" />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-4">
						<s:submit method="reset" value="リセット"
							cssClass="btn btn-primary btn-block" />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-offset-4 col-sm-4">
						<s:submit method="update" value="追加"
							cssClass="btn btn-danger btn-block" />
					</div>
				</div>
			</div>
		</div>

		<div class="bug">
			<span style="color: red">
				<s:actionerror />
				<s:property value="msg" />
			</span>
			</div>
			<s:if test="%{resultTable.size() > 0}">
			<div class="table-responsive  col-sm-offset-3 col-sm-6">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>メーカー名</th>
							<th>型名</th>
							<th>価格(円)</th>
							<th>コメント</th>
							<th>削除</th>
						</tr>
						</thead>
						<tbody>
						<s:iterator value="resultTable">
							<tr>
								<td class="data"><s:property value="name" /></td>
								<td class="data"><s:property value="typeName" /></td>
								<td class="data"><s:property value="price" /></td>
								<td class="data"><s:property value="comment" /></td>
								<td class="data"><input type="checkbox" name="delete"
									value="<s:property value="id" />
									<s:property value="typeName" />" /></td>
							</tr>
						</s:iterator>
					</tbody>

				</table>
				</div>
				<div class="row">
				<div class="col-sm-offset-4 col-sm-4">
					<s:submit method="delete" id="deleteBtn" value="削除"
						cssClass="btn btn-danger btn-block" />
				</div>
				</div>
			</s:if>

		</s:form>
		<script type="text/javascript" src="<s:url value="/assets/js/bootstrap.min.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/assets/js/vegas.min.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/assets/js/suzuki.js"/>"></script>

</body>
</html>