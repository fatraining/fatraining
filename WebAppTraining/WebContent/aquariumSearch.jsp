<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/aquariumSearch.css"/>" />
<link rel="stylesheet" type="text/css" href="http://csshake.surge.sh/csshake.min.css"> <!-- ふるえるcss -->


<body>

	<div class="container">
		<div class="text-center">
			<jsp:include page="logo.jsp" />
		</div>
		<p class="text-right">
			<a href="menu.action">Back</a>
		</p>
		<br>
		<div class="text-center">
			<h1 class="shake-slow shake-constant shake-constant--hover">水族館検索</h1>
		</div>
		<br>
		<div class="text-right">
			<s:property value="userId" />
			<%--AquariumSearchAction.javaで生成したuserIdを画面に表示する --%>
			さん
		</div>
		<br>

		<%--
 			<div class="form-group">
				<label for="area" class="col-sm-2 control-label"> エリア: </label>
				<div class="col-md-8">
					<select name="area" class="form-control">
						<option>横浜</option>
						<option>豊島区</option>
						<option>鴨川市</option>
					</select>
				</div>
			</div>

--%>
		<s:form cssClass="form-horizontal">
			<div class="form-group">
				<label for="area" class="col-sm-2 control-label">エリア：</label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="area" value="area"
						list="aquariumAreaMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 水族館名: </label>
				<div class="col-md-8">
					<s:textfield name="name" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="price" class="col-sm-2 control-label"> 入場料: </label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="price" list="priceMap"></s:select>
				</div>
			</div>
			<br>

			<div class="form-group">
				<div class="col-md-offset-2 col-md-8">
					<s:submit method="search" value="検索"
						cssClass="btn btn-warning btn-block" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-2 col-md-4">
					<s:submit method="reset" value="リセット"
						cssClass="btn btn-danger btn-block" />
				</div>
				<div class="col-md-4">
					<s:submit method="update" value="追加"
						cssClass="btn btn-info btn-block " />
				</div>
			</div>

			<div>
				<div style="color: red; padding-left: 5%">
					<s:actionerror />
					<s:property value="message" />
				</div>
				<s:if test="%{aquariumTable.size> 0}">
					<table class="table table-striped table-bordered">
						<thead>
							<%-- テーブルヘッダー --%>
							<tr>
								<th class="per-12 center">エリア</th>
								<th>水族館名</th>
								<th>入場料</th>
								<th>営業時間</th>
								<th>コメント</th>
								<th>更新</th>
								<th>削除</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="aquariumTable">
								<tr>
									<td class="data" width="75"><s:property value="area" /></td>
									<td class="data" width="190"><s:property value="name" /></td>
									<td class="data" width="60"><s:property value="price" /></td>
									<td class="data" width="150"><s:property value="hours" /></td>
									<td class="data"><s:property value="comment" /></td>
									<td><input type="button" name="updateBtn" value="更新"
										class="btn btn-primary" forUpdate="<s:property value ="id"/>" />
									</td>
									<td class="data" width="50"><input type="checkbox"
										name="delete" value=<s:property value="id"/>></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</s:if>
				<s:if test="%{aquariumTable.size>0}">
					<div class="text-right">
					<div class ="shake shake-chunk">
						<s:submit method="delete" value="削除" cssClass="btn btn-danger" />
					</div>
					</div>
					<br>
				</s:if>
			</div>
		</s:form>
	</div>
	<script type="text/javascript"
		src="<s:url value="/assets/js/shibata.js" />"></script>
</body>
</html>