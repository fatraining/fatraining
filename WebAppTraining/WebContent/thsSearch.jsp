<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/ths.css" />" />
</head>
<body>
	<div class="back">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<p class="text-right">
				<a href="menu.action">Back</a>
			</p>
			<br>
			<div class="text-center">
				<h2>
					<span style="display: block">Toshin High School </span> 講師検索
				</h2>
			</div>
			<br>
			<div class="text-right">
				<s:property value="userId" />
				<%--ThsSearchAction.javaで生成したuserIdを画面に表示する --%>
				さん
			</div>
			<br>

			<s:form cssClass="form-horizontal">
				<div class="form-group ">
					<label for="subject" class="col-sm-2 control-label">科目：</label>
					<div class="col-md-4">
						<s:select cssClass="form-control" name="subject" value="subject"
							list="thsSubjectMap"></s:select>
					</div>
				</div>

				<div class="form-group">
					<label for="name" class="col-sm-2 control-label"> 講師名：</label>
					<div class="col-md-4">
						<s:textfield name="name" cssClass="form-control"
							placeholder="講師名を入力" />
						<p class="help-block">※漢字で入力してください。</p>
					</div>
				</div>
				<div class="form-group">
					<label for="level" class="col-sm-2 control-label"> レベル：</label>
					<div class="col-md-4">
						<s:select cssClass="form-control" name="level" list="levelMap"></s:select>
					</div>
				</div>
				<div class="submit">
					<div class="form-group">
						<div class="center-block">
							<div class="btn-group">
								<s:submit id="button" method="search" value="検索"
									cssClass="btn btn-primary btn-lg" />
								<s:submit id="button" method="reset" value="リセット"
									cssClass="btn btn-success btn-lg" />
								<s:submit id="button" method="update" value="追加"
									cssClass="btn btn-warning btn-lg" />
							</div>
						</div>
					</div>
				</div>
				<div>
					<div style="color: red; padding-left: 5%">
						<s:actionerror />
						<s:property value="message" />
					</div>
					<s:if test="%{thsTable.size> 0}">
						<table class="table table-bordered">
							<thead>
								<%-- テーブルヘッダー --%>
								<tr>
									<th class="per-12 center">科目</th>
									<th>講師名</th>
									<th>レベル</th>
									<th>コメント</th>
									<th>紹介動画</th>
									<th>更新</th>
									<th>削除</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="thsTable">
									<tr>
										<td class="data" width="60"><s:property value="subject" /></td>
										<td class="data" width="100"><s:property value="name" /></td>
										<td class="data" width="60"><s:property value="level" /></td>
										<td class="data"><s:property value="comment" /></td>
										<td><input type="button" name="movie"
											onclick="window.open('<s:property value ="link"/>')"
											value="紹介動画" class="btn btn-primary btn-sm" /></td>
										<td><input type="button" name="updateBtn" value="更新"
											class="btn btn-info" forUpdate="<s:property value ="id"/>" /></td>
										<td class="data" width="50"><input type="checkbox"
											name="delete" value=<s:property value="id"/>></td>

									</tr>
								</s:iterator>
							</tbody>
						</table>
					</s:if>
					<s:if test="%{thsTable.size>0}">
						<div class="text-right">
							<s:submit method="delete" value="削除"
								cssClass="btn btn-danger btn-lg" />

						</div>
						<br>
					</s:if>
				</div>
			</s:form>
		</div>
		<script type="text/javascript"
			src="<s:url value="/assets/js/fujikawa.js" />"></script>
	</div>
</body>
</html>