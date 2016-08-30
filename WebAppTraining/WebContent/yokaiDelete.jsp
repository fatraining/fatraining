<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%-- カスタムタグをSとする --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/yokai1.css"/>" />
<body>
	<div class="back">
		<s:form class="form-horizontal">
			<div class="container">
				<div class="text-center">
					<jsp:include page="logo.jsp" />
				</div>
				<p class="text-right">
					<a href="yokaiSearch.action">Back</a>
				</p>
				<br>
				<div class="sub-header text-center">
					<h2><marquee behavior="alternate" direction="up" height="100"><marquee direction="right">
				<font face="HG行書体" size="10" color=#FF0000>&nbsp;&nbsp;妖怪を成仏します&nbsp;&nbsp;</font></marquee></marquee></h2>
				</div>
				<p class="text-right">
					<s:property value="userId" />
					さん
				</p>
				<br>

<%-- 全体の文字設定をHP行書体にする --%>
<font face="HG行書体">
		<s:if test="%{yokaiTable.size> 0}">
						<table class="table table-bordered">

							<thead>
								<%-- テーブルヘッダー --%>
								<tr>
									<th class="per-12 center"><font  color=#800080>生息地</font> </th>
									<th><font  color=#000080>妖怪の名前</font></th>
									<th><font  color=#008000>特徴</font></th>
									<th><font  color=#FF00FF>コメント</font></th>
									<th><font  color=#0000CD>紹介画像URL</font></th>

								</tr>
							</thead>
							<tbody>
								<s:iterator value="yokaiTable">
									<tr>
										<td class="data" width="60"><s:property value="yokaifrom" /></td>
										<td class="data" width="100"><s:property value="name" /></td>
										<td class="data" width="60"><s:property value="type" /></td>
										<td class="data"><s:property value="comment" /></td>
										<td><input type="button" name="movie"
											onclick="window.open('<s:property value ="link"/>')"
											value="紹介画像URL" class="btn btn-primary btn-sm" /></td>


									</tr>
								</s:iterator>
							</tbody>
						</table>
						<div class="text-right">
							<s:submit method="delete" value="成仏"
								class="btn btn-danger btn-lg" />

					</div>

				</s:if>
</font>

			</div>
		</s:form>
	</div>
</body>
</html>