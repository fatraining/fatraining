<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="apps.makino.entity.UserInfo" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" name="format-detection" content="text/html; charset=UTF-8; telephone=no">
		<title>お客様情報確認画面</title>
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
			font.required {
				color: #ff0000;
				font-size: 80%;
				font-weight: bold;
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
			<h2 align="center">×××ショップ</h2>
		</div>

		<s:form cssClass="form-horizontal">
			<div class="col-sm-offset-1" align="center">
				<h4>お客様の情報に誤りがないか確認してください！</h4>
			</div>
			<table border="1" cellpadding="3" align="center" style="font-size:16px;">
				<tr>
					<td class="rowheader">氏名<font class="required"> ※必須</font></td>
					<td class="input"> 姓　：<s:property value="userInfo.lastName" /></td>
					<td class="input"> 名　：<s:property value="userInfo.firstName" /></td>
				</tr>
				<tr>
					<td class="rowheader">フリガナ<font class="required"> ※必須</font></td>
					<td class="input"> セイ：<s:property value="userInfo.lastNameKana" /></td>
					<td class="input"> メイ：<s:property value="userInfo.firstNameKana" /></td>
				</tr>
				<tr>
					<td class="rowheader">性別<font class="required"> ※必須</font></td>
					<%
					String sex;
					UserInfo userInfo = (UserInfo)request.getAttribute("userInfo");
					if (userInfo.getSex() == 0) {
						sex = "男性";
					} else {
						sex = "女性";
					}
					%>
					<td class="input" colspan="2"><%= sex %></td>
				</tr>
				<tr>
					<td class="rowheader">生年月日<font class="required"> ※必須</font></td>
					<td class="input" colspan="2">西暦<s:property value="userInfo.bornYear" />年
													  <s:property value="userInfo.bornMonth" />月
													  <s:property value="userInfo.bornDay" />日</td>
				</tr>
				<tr>
					<td class="rowheader">年齢<font class="required"> ※必須</font></td>
					<td class="input" colspan="2"><s:property value="userInfo.age" />歳</td>
				</tr>
				<tr>
					<td class="rowheader">郵便番号<font class="required"> ※必須</font></td>
					<td  class="input"colspan="2"> 〒<s:property value="userInfo.postalCode1" />
									 			   ― <s:property value="userInfo.postalCode2" /></td>
				</tr>
				<tr>
					<td rowspan="2" class="rowheader">お届け先<font class="required"> ※必須</font></td>
					<td  class="input" rowspan="2" colspan="2">
						<s:property value="userInfo.address" /><br>
						<s:property value="userInfo.building" /></td>
				</tr>
				<tr></tr>
				<tr>
					<td class="rowheader">電話番号<font class="required"> ※必須</font></td>
					<%
					String telKind;
					if (userInfo.getTelKind() == 0) {
						telKind = "自宅";
					} else if (userInfo.getTelKind() == 1) {
						telKind = "携帯";
					} else {
						telKind = "その他";
					}
					%>
					<td class="input" colspan="2"><%= telKind %>　
						<s:property value="userInfo.telNumber1" />－
						<s:property value="userInfo.telNumber2" />－
						<s:property value="userInfo.telNumber3" />
					</td>
				</tr>
				<tr>
					<td class="rowheader" rowspan="9" valign="top">備考</td>
					<td class="input" rowspan="9" colspan="2">ご要望などをご記入ください。<br><s:textarea name="userInfo.remarks" cols="60" rows="8" maxlingth="500" readonly="true" style="background-color:#ccff66"/></td>
				</tr>
			</table>
			<div align="center" style="margin-top:15px">
				<s:submit cssClass="button" method="nextPage" value="上記の内容で注文する" />
				<s:submit cssClass="button" method="back" value="戻る" />
			</div>
		</s:form>
	</body>
</html>