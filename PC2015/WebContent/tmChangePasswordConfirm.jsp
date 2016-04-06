<%@ page language="java" contentType="text/html; charset=UtF-8"
    pageEncoding="UtF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UtF-8">
		<title>パスワード変更完了画面</title>

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
			td.rowheader {
				background-color: #cbffd3;
				padding: 5px 10px 5px 10px;
			}
			td.input {
				background-color: #ccff66;
				padding: 5px 10px 5px 10px;
			}
			font.required {
				color: #ff0000;
				font-size: 80%;
				font-weight: bold;
			}
		-->
		</style>
</head>
	<body style="background-color:#f0e68c">
		<div id="headerArea" style="margin-right:40%">
			<h2 align="center">
				<Marquee behavior="slide" direction="right" width="50%" scrolldelay="50">∠●_●；ショップ　☆彡</Marquee>
			</h2>
			<h5 align="right" style="margin-right:30px">ようこそ!<br/><s:property value="memberId" />さん</h5>
		</div>

		<s:form cssClass="form-horizontal">
			<div>
				<h1 align="center"><font color="#ff0000">パスワードを変更しました！</font></h1>
			</div>
			<div align="center" style="margin-top:15px">
				<s:submit cssClass="button" method="back" value="戻る" />
			</div>
		</s:form>
	</body>
</html>