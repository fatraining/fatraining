<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" name="format-detection" content="text/html; charset=UTF-8">
		<title>登録完了画面</title>
		<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

		<style>
		<!--
			.button {
				background-color:#d3d3d3;
				border-color:#d3d3d3;
				font-size:18px;
			}
			td.rowheader {
				background-color: #cbffd3;
				padding: 5px 10px 5px 10px;
			}
			td.input {
				background-color: #ccff66;
				padding: 5px 10px 5px 10px;
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
		-->
		</style>
	</head>

	<body style="background-color:#f0e68c">
		<div id="headerArea" style="margin-right:40%">
			<h2 align="center">
				<Marquee direction="right" width="50%" behavior="slide" scrollamount="80">∠●_●；ショップ　☆彡</Marquee>
			</h2>
		</div>

		<s:form cssClass="form-horizontal">
			<div>
				<h1 align="center"><font color="#ff0000">お客様の情報を登録しました。</font></h1>
			</div>
			<div align="center" style="margin-top:15px">
				<s:submit cssClass="button" method="backToTop" value="商品一覧へ" />
			</div>
		</s:form>
	</body>
</html>