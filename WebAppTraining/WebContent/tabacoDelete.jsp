<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/tabacoDelete.css"/>" />


<body>
	<s:form class="form-horizontal">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<div class="sub-header">
				<font color="red">
					<h1>データを削除する？</h1>
				</font>

				<div class="text-right">
					<font color="white"> <s:property value="userId" />様
					</font>
				</div>
				<br>

				<p class="text-right">
					<a href="tabacoSearch.action">Back</a>
				</p>
				<br>
			</div>

			<s:if test="{tabacoTable.size!=0}">
				<div>
					<table class="table table-striped table-bordered">
						<thead>
							<tr bgcolor="#FFFFFF">
								<th>銘柄名</th>
								<th>商品画像</th>
								<th>商品名</th>
								<th>タール</th>
								<th>ニコチン</th>
								<th>価格</th>
								<th>コメント</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="tabacoTable">
								<tr bgcolor="#FFFFFF">
									<td class="data" width="130"><s:property value="area" /></td>
									<td><a
										href="<s:url value="/assets/images/temp/"/><s:property value = "namePhoto" />"
										rel="lightbox"> <img class="imageWrapper"
											src="<s:url value="/assets/images/temp/"/><s:property value="namePhoto" />"
											width="60" height="80" />
									</a></td>
									<td class="data" width="170"><s:property value="name" /></td>
									<td class="data" width="90"><s:property value="tar" /></td>
									<td class="data" width="90"><s:property value="nicotine" /></td>
									<td class="data" width="80"><s:property value="price" /></td>
									<td class="data" width="200"><s:property value="comment" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div 
						class="text-right shake shake-vertical-slow shake-constant shake-constant--hover">
						<s:submit method="delete" value="灰皿に捨てちゃうよ？"
							class="btn btn-danger" />
						<br>
						<br>
					</div>
				</div>
			</s:if>
		</div>
	</s:form>

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/otawara.js" />"></script>
</body>
</html>