<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>購入履歴</title>
		<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

		<style>
		<!--
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
			.button {
				background-color:#d3d3d3;
				border-color:#d3d3d3;
				font-size:18px;
			}
		-->
		</style>
	</head>
	<body style="background-color:#f0e68c">
		<s:form cssClass="form-horizontal">
			<div id="headerArea" style="margin-right:40%">
				<h2 align="center">×××ショップ</h2>
				<h5 align="right" style="margin-right:30px">ようこそ!<br/><s:property value="userId" />さん</h5>
				<div align="right" style="margin-right:30px">
					<s:submit cssClass="button" method="back" value="戻る" />
				</div>
			</div>

			<s:set name="decimalFormat" value="%{new java.text.DecimalFormat('#,###')}" />
			<div align="center">
				<h4>過去のご購入履歴です</h4>
			</div>
			<table border="1" align="center" style="font-size:16px;">
				<tr style="background-color:#adff2f">
					<th style="padding:0 5px 0 5px; text-align:center">購入日</th>
					<th style="padding:0 5px 0 5px; text-align:center">商品コード</th>
					<th style="padding:0 5px 0 5px; text-align:center">商品名</th>
					<th style="padding:0 5px 0 5px; text-align:center">価格</th>
					<th style="padding:0 5px 0 5px; text-align:center">個数</th>
				</tr>
				<%
				String buyDate = "";
				%>
				<s:iterator value="history" status="rowstatus">
					<tr style="background-color:#ffe4c4">
						<%
						if (buyDate.equals((String)request.getAttribute("buyDate"))) {
						%>
						<td style="border-top-style:none;border-bottom-style:none;"></td>
						<%
						} else {
						%>
						<td align="center" style="padding:5px 5px 5px 5px; border-bottom-style:none;"><s:property value="buyDate" /></td>
						<%
							buyDate = (String)request.getAttribute("buyDate");
						}
						%>
						<td align="left" style="padding:5px 5px 5px 5px"><s:property value="code" /></td>
						<td align="left" style="padding:5px 5px 5px 5px"><s:property value="name" /></td>
						<td align="right" style="padding:5px 5px 5px 5px"><s:property value="%{#decimalFormat.format(price)}" /> 円</td>
						<td align="right" style="padding:5px 5px 5px 5px"><s:property value="quantity"/> 個</td>
					</tr>
				</s:iterator>
			</table>
		</s:form>
	</body>
</html>