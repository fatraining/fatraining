<%@ page language="java" contentType="text/html; charset=UtF-8"
    pageEncoding="UtF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UtF-8">
		<title>ログイン画面</title>

		<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

		<style>
		<!--
			.button {
				background-color:#d3d3d3;
				border-color:#d3d3d3;
				font-size:18px;
			}
			p.err{
				color: red;
				font-size: 16px;
				margin-top: 10px;
			}
			body{
				margin: 0;
				padding: 100px 50px 50px 50px;
			}
			* html body{
				overflow: hidden;
			}
			div#headerArea {
				position: fixed !important;
				position: absolute;
				top: 0;
				left: 0;
				width: 100%;
				height: 95px;
				background-color: #4E9ABE;
				color: #fff;
			}
			* html div#contentsArea {
				height: 100%;
				overflow: auto;
			}
			div#footerArea {
				position: fixed !important;
				position: absolute;
				bottom: 0;
				left: 0;
				width: 100%;
				height: 60px;
				background-color: #4E9ABE;
				color: #fff;
			}
		-->
		</style>
	</head>

	<%
	String errMessage = (String)request.getAttribute("errMessage");
	if (errMessage == null || errMessage.isEmpty() || errMessage.indexOf("会員ID") >= 0) {
	%>
	<body style="background-color:#f0e68c" onLoad="document.tmLogin.userId.focus()">
	<%
	} else {
	%>
	<body style="background-color:#f0e68c" onLoad="document.tmLogin.password.focus()">
	<%
	}
	%>
		<div id="headerArea">
			<h2 align="center" >×××ショップ</h2>
		</div>

		<p class="err" align="center"><s:property value="errMessage" /></p>
		<s:form cssClass="form-horizontal">
			<div class="form-group" style="margin-top:10px" align="center">
				<div style="margin-left:28px">
					会員ID ： <font size="4"><s:textfield name="userId" size="30"/></font>
				</div>
			</div>

			<div class="form-group" style="margin-top:10px" align="center">
				<div>
					パスワード ： <font size="4"><s:textfield name="password" type="password" size="30"/></font>
				</div>
	 			<div class="form-group" align="center">
					<s:submit cssClass="button" method="login" value="ログイン" style="margin-top:10px;" />
					<s:submit cssClass="button" method="back" value="戻る" style="margin-top:10px;" />
				</div>
			</div>

			<%
			String buttonId = (String)request.getAttribute("buttonId");
			if (buttonId != null && buttonId.equals("buy")) {
			%>
			<div class="form-group" style="margin-top:10px" align="center">
				<div>
					<nobr><label><font color="ff0000" size="3">ログインしない場合はこちら</font></label></nobr>
				</div>
	 			<div class="form-group" align="center" style="margin-top:7px">
					<s:submit cssClass="button" method="notLogin" value="ログインせずにお買い物"/>
	 			</div>
			</div>
			<%
			}
			%>
		</s:form>
	</body>
</html>