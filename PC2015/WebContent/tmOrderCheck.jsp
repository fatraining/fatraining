<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.text.DecimalFormat" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注文確認画面</title>
		<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

		<style>
		<!--
			.button {
				background-color:#d3d3d3;
				border-color:#d3d3d3;
				font-size:18px;
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
		-->
		</style>
	</head>

	<body style="background-color:#f0e68c">
		<div id="headerArea" style="margin-right:40%">
			<h2 align="center">
				<Marquee direction="right" width="30%" behavior="scroll" scrolldelay="130">∠●_●；ショップ　☆彡</Marquee>
			</h2>
			<h5 align="right" style="margin-right:30px">ようこそ!<br/><s:label name="memberId" />さん</h5>
		</div>

		<div align="center">
			<h4>以下の商品を購入します。</h4>
		</div>
		<s:form cssClass="form-horizontal">
			<div class="form-group">
				<%-- 商品一覧を表示する --%>
				<table border="1" align="center" style="font-size:16px;">
					<tr style="background-color:#adff2f">
						<th style="padding:0 5px 0 5px; text-align:center">No</th>
						<th style="padding:0 5px 0 5px; text-align:center">商品コード</th>
						<th style="padding:0 5px 0 5px; text-align:center">商品名</th>
						<th style="padding:0 5px 0 5px; text-align:center">価格（税込み）</th>
						<th style="padding:0 5px 0 5px; text-align:center">個数</th>
					</tr>
					<s:iterator value="goods" status="rowstatus">
						<tr style="background-color:#ffe4c4">
							<td align="center" style="padding:5px 5px 5px 5px"><s:property value="#rowstatus.count" /></td>
							<td align="left" style="padding:5px 5px 5px 5px"><s:property value="code" /></td>
							<td align="left" style="padding:5px 5px 5px 5px"><s:property value="name" /></td>
							<%
							int price = (int)request.getAttribute("price");
							DecimalFormat decimalFormat = new DecimalFormat("#,###");
							String priceKanma = decimalFormat.format(price);
							%>
							<td align="right" style="padding:5px 5px 5px 5px"><%= priceKanma %> 円</td>
							<td align="right" style="padding:5px 5px 5px 5px"><s:property value="quantity"/> 個</td>
						</tr>
						<s:if test="%{#rowstatus.last}">
							<tr style="background-color:#e0ffff">
								<%
								int totalAmount = (int)request.getAttribute("totalAmount");
								String totalKanma = decimalFormat.format(totalAmount);
								%>
								<td colspan="5" align="right" style="padding:5px 5px 5px 5px">合計金額 ：<%= totalKanma %> 円</td>
							</tr>
						</s:if>
					</s:iterator>
				</table>
			</div>
			<div align="center" style="margin-top:15px">
				<s:submit cssClass="button" method="nextPage" value="次へ" />
				<s:submit cssClass="button" method="back" value="戻る" />
			</div>
		</s:form>
	</body>
</html>