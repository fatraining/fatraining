<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>商品一覧</title>
		<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

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
				<%
				String userId = (String)request.getAttribute("userId");
				if (userId == null || userId.equals("ゲスト")) {
				%>
				<div align="right" style="margin-right:30px">
					<s:submit cssClass="button" method="login" value="ログイン" />
				</div>
				<%
				} else {
				%>
				<div align="right" style="margin-right:30px">
					<s:submit cssClass="button" method="buyHistory" value="購入履歴" />
				</div>
				<div align="right" style="margin-right:30px; margin-top:5px">
					<s:submit cssClass="button" method="logout" value="ログアウト" />
				</div>
				<%
				}
				%>
			</div>
			<s:set name="decimalFormat" value="%{new java.text.DecimalFormat('#,###')}" />
			<div align="center">
				<h4>購入したい商品を選択してください！</h4>
			</div>
			<p class="err" align="center"><s:property value="errMessage" /></p>
			<%-- 商品一覧を表示する --%>
			<table border="1" align="center" style="font-size:16px;">
				<tr style="background-color:#adff2f">
					<th style="padding:0 5px 0 5px; text-align:center">No</th>
					<th style="padding:0 5px 0 5px; text-align:center">購入</th>
					<th style="padding:0 5px 0 5px; text-align:center">商品コード</th>
					<th style="padding:0 5px 0 5px; text-align:center">商品名</th>
					<th style="padding:0 5px 0 5px; text-align:center">価格（税込み）</th>
					<th style="padding:0 5px 0 5px; text-align:center">個数</th>
				</tr>
				<s:iterator value="goods" status="rowstatus">
					<tr style="background-color:#ffe4c4">
						<td align="center" style="padding:5px 5px 5px 5px"><s:property value="#rowstatus.count" /></td>
						<td align="center" style="padding:5px 5px 5px 5px"><s:checkbox name="goods[%{#rowstatus.index}].isBuy" value="%{isBuy}" /></td>
						<td align="left" style="padding:5px 5px 5px 5px"><s:property value="code" /></td>
						<td align="left" style="padding:5px 5px 5px 5px"><s:property value="name" /></td>
						<td align="right" style="padding:5px 5px 5px 5px"><s:property value="%{#decimalFormat.format(price)}" /> 円</td>
						<td align="right" style="padding:5px 5px 5px 5px"><s:select name="goods[%{#rowstatus.index}].quantity" 
																				list="{'0','1','2','3','4','5','6','7','8','9','10'}"
																				emptyOption="false" 
																				value="%{quantity}" />個</td>

						<%-- submit時、セッターを起動させるために表示のみの項目をhiddenで保持 --%>
						<s:hidden name="goods[%{#rowstatus.index}].code" value="%{code}" />
						<s:hidden name="goods[%{#rowstatus.index}].name" value="%{name}" />
						<s:hidden name="goods[%{#rowstatus.index}].price" value="%{price}" />
					</tr>
				</s:iterator>
			</table>
			<div class="form-group">
				<div id="footerArea" align="center">
					<s:submit method="goodsBuy" value="購入"
								style="background-color:#d3d3d3; border-color:#d3d3d3; 
									   width:50%; font-size:30px; margin-top:5px" />
				</div>
			</div>
		</s:form>
	</body>
</html>
