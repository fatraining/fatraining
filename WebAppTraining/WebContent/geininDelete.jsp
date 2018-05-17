<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<%-- CSS --%>
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/maiwaifu.css"/>" />
<%-- JQuery --%>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/jquery.mori.js"/>"></script>

</head>

<body>
	<s:form class="form-horizontal">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<div class="sub-header">
				<h2>お別れする？</h2>
				<p class="text-right">
					<s:property value="userId" />
					様 <a href="maiwaifuSearch.action">Back</a>
				</p>
				<br>
			</div>

			<s:if test="%{maiwaifuTable.size!=0}">
				<div>
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>生息地</th>
								<th>写真</th>
								<th>名前</th>
								<th>ジャンル</th>
								<th>年齢</th>
								<th>コメント</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="maiwaifuTable">
								<tr>
									<td class="data" width="75"><s:property value="area" /></td>
									<td class="data" width="120"><img
										src="<s:property value="image"/>" alt="NO IMAGE!" width="110"
										height="110"></td>
									<td class="data" width="190"><s:property value="name" /></td>
									<td class="data" width="60"><s:property value="genre" /></td>
									<td class="data" width="180"><s:property value="age" /></td>
									<td class="data"><s:property value="comment" /></td>
								</tr>

							</s:iterator>
						</tbody>
					</table>
					<br>
					<br>
					<br>
					<!-- マウスポインタがのったら落ち着く -->
					<center>
						<div
							class="shake shake-vertical-slow shake-constant shake-constant--hover">
							<s:submit type="image" src="assets/images/temp/byebye.png"
								method="delete" value="ほんとに消しちゃうからね" />
						</div>
					</center>
					<div>
						<center>
							<br>
							<br>


							<br> <img src="assets/images/temp/heartcut.gif">
						</center>
						<br>
					</div>
			</s:if>
		</div>
	</s:form>

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/mori.js" />"></script>

</body>
</html>