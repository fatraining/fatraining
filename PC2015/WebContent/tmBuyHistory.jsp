<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>購入履歴</title>
		<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

		<SCRIPT src="asset/tmInputCheck.js"></SCRIPT>
		<style>
		<!--
			p.err{
				color: red;
				font-size:16px;
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
				height: 165px;
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
				font-size:14px;
			}
		-->
		</style>
	</head>
	<body style="background-color:#f0e68c">
		<s:form cssClass="form-horizontal">
			<div id="headerArea" style="margin-right:40%">
				<h2 align="center">
					<Marquee direction="right" width="50%" scrollamount="70">∠●_●；ショップ　☆彡</Marquee>
				</h2>
				<h5 align="right" style="margin-right:30px">ようこそ!<br/><s:property value="memberId" />さん</h5>
				<div align="right" style="margin-right:30px">
					<s:submit cssClass="button" method="back" value="戻る" />
				</div>
				<div align="center" >
					検索条件：　注文日　 <s:textfield name="year" maxlength="4" size="1" cssStyle="text-align:right; ime-mode:disabled;" onkeyDown="return numOnly()"/> 年
									 <s:textfield name="month" maxlength="2" size="1" cssStyle="text-align:right; ime-mode:disabled;" onkeyDown="return numOnly()"/> 月
									 <s:textfield name="day" maxlength="2" size="1" cssStyle="text-align:right; ime-mode:disabled;" onkeyDown="return numOnly()"/> 日
							　　カテゴリ　<s:select name="categorySelect" list="%{categoryList}" emptyOption="true" />
					<s:submit cssClass="button" method="search" value="検索" cssStyle="position: relative; bottom: 2px" />
				</div>
			</div>

			<s:if test="%{orderInfo.size()==0}">
				<div align="center" style="margin-top:75px;">
					<h4>これまでに購入した商品はありません</h4>
				</div>
			</s:if>
			<s:else>
				<div align="center" style="margin-top:75px;">
					<p class="err" align="center"><s:property value="warningMessage" /></p>
					<h4>過去のご購入履歴です</h4>
				</div>
				<table border="1" align="center" style="font-size:16px;">
					<tr style="background-color:#adff2f">
						<th style="padding:0 5px 0 5px; text-align:center">購入日</th>
						<th style="padding:0 5px 0 5px; text-align:center">注文番号</th>
						<th style="padding:0 5px 0 5px; text-align:center">商品コード</th>
						<th style="padding:0 5px 0 5px; text-align:center">カテゴリ</th>
						<th style="padding:0 5px 0 5px; text-align:center">商品名</th>
						<th style="padding:0 5px 0 5px; text-align:center">価格</th>
						<th style="padding:0 5px 0 5px; text-align:center">個数</th>
					</tr>
					<%
					String orderDate = "";
					String orderNo = "";
					%>
					<s:iterator value="orderInfo" status="rowstatus">
						<tr style="background-color:#ffe4c4">
							<%
							if (orderDate.equals((String)request.getAttribute("orderDate"))) {
							%>
							<td style="border-top-style:none; border-bottom-style:none;"></td>
							<%
							} else {
							%>
							<td align="center" style="padding:5px 5px 5px 5px; border-bottom-style:none;"><s:property value="orderDate" /></td>
							<%
								orderDate = (String)request.getAttribute("orderDate");
							}

							if (orderNo.equals((String)request.getAttribute("orderNo"))) {
							%>
							<td style="border-top-style:none; border-bottom-style:none;"></td>
							<%
							} else {
							%>
							<td align="center" style="padding:5px 5px 5px 5px; border-bottom-style:none;"><s:property value="orderNo" /></td>
							<%
								orderNo = (String)request.getAttribute("orderNo");
							}
							%>
							<td align="left" style="padding:5px 5px 5px 5px"><s:property value="goodsCode" /></td>
							<td align="left" style="padding:5px 5px 5px 5px"><s:property value="category" /></td>
							<td align="left" style="padding:5px 5px 5px 5px"><s:property value="goodsName" /></td>
							<%
							int orderPrice = (int)request.getAttribute("orderPrice");
							DecimalFormat decimalFormat = new DecimalFormat("#,###");
							String orderPriceKanma = decimalFormat.format(orderPrice);
							%>
							<td align="right" style="padding:5px 5px 5px 5px"><%= orderPriceKanma %> 円</td>
							<td align="right" style="padding:5px 5px 5px 5px"><s:property value="orderQuantity"/> 個</td>
						</tr>
					</s:iterator>
				</table>
			</s:else>
		</s:form>
	</body>
</html>