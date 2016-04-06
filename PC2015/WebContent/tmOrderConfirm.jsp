<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.ResultMemberInfo" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" name="format-detection" content="text/html; charset=UTF-8; telephone=no">
		<title>注文確定</title>
		
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
				<Marquee width="30%" behavior="scroll" scrolldelay="100">∠●_●；ショップ　☆彡</Marquee>
			</h2>
		</div>

		<s:form cssClass="form-horizontal">
			<div>
				<h1 align="center"><font color="#ff0000">ご注文を受け付けました！</font></h1>
			</div>

			<div class="form-group">
				<%-- 商品一覧を表示する --%>
				<table border="1" align="center" style="font-size:16px; margin-top:20px" >
					<tr style="border-top-style:none; background-color:#adff2f">
						<th colspan="5"><font color="#0000ff">ご注文内容</font></th>
					</tr>
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
							<tr>
								<%
								int totalAmount = (int)request.getAttribute("totalAmount");
								String totalKanma = decimalFormat.format(totalAmount);
								%>
								<td colspan="5" align="right" style="padding:5px 5px 5px 5px; background-color:#e0ffff;">合計金額 ：<%= totalKanma %> 円</td>
							</tr>
						</s:if>
					</s:iterator>
				</table>
			</div>

			<table border="1" cellpadding="3" align="center" style="font-size:16px;">
				<tr style="border-top-style:none; background-color:#adff2f">
					<th colspan="5"><font color="#0000ff">お客様情報</font></th>
				</tr>
				<tr>
					<td class="rowheader">氏名</td>
					<td class="input" colspan="2">
						<s:property value="memberInfo.lastName" />　<s:property value="memberInfo.firstName" />
					</td>
				</tr>
				<tr>
					<td class="rowheader">フリガナ</td>
					<td class="input" colspan="2">
						<s:property value="memberInfo.lastNameKana" />　<s:property value="memberInfo.firstNameKana" />
					</td>
				</tr>
				<tr>
					<td class="rowheader">性別</td>
					<%
					String sex;
					ResultMemberInfo memberInfo = (ResultMemberInfo)request.getAttribute("memberInfo");
					if (memberInfo.getSex() == 0) {
						sex = "男性";
					} else {
						sex = "女性";
					}
					%>
					<td class="input" colspan="2"><%= sex %></td>
				</tr>
				<tr>
					<td class="rowheader">生年月日</td>
					<td class="input" colspan="2">西暦<s:property value="memberInfo.bornYear" />年
										 			  <s:property value="memberInfo.bornMonth" />月
										 			  <s:property value="memberInfo.bornDay" />日</td>
				</tr>
				<tr>
					<td class="rowheader">年齢</td>
					<td class="input" colspan="2"><s:property value="memberInfo.age" />歳</td>
				</tr>
				<tr>
					<td class="rowheader">郵便番号</td>
					<td  class="input"colspan="2"> 〒<s:property value="memberInfo.postalCode1" />
									 			   ― <s:property value="memberInfo.postalCode2" /></td>
				</tr>
				<tr>
					<td rowspan="2" class="rowheader">お届け先</td>
					<td class="input" rowspan="2" colspan="2">
						<s:property value="memberInfo.address" /><br>
						<s:property value="memberInfo.building" /></td>
				</tr>
				<tr></tr>
				<tr>
					<td class="rowheader">電話番号</td>
					<%
					String telKind;
					if (memberInfo.getTelKind() == 0) {
						telKind = "自宅";
					} else if (memberInfo.getTelKind() == 1) {
						telKind = "携帯";
					} else {
						telKind = "その他";
					}
					%>
					<td class="input"><%= telKind %></td>
					<td class="input"><s:property value="memberInfo.telNumber1" />－
									  <s:property value="memberInfo.telNumber2" />－
									  <s:property value="memberInfo.telNumber3" /></td>
				</tr>
				<tr>
					<td class="rowheader" rowspan="9" valign="top">備考</td>
					<td class="input" rowspan="9" colspan="2">ご要望などをご記入ください。<br>
					<s:textarea name="memberInfo.remarks" cols="60" rows="8" maxlingth="500" readonly="true" cssStyle="background-color:#ccff66"/></td>
				</tr>
			</table>

			<div align="center" style="margin-top:15px">
				<s:submit cssClass="button" method="backToTop" value="商品一覧へ戻る" />
				<s:submit cssClass="button" value="閉じる" onClick="window.close()" />
			</div>
		</s:form>
	</body>
</html>