<%@ page language="java" contentType="text/html; charset=UtF-8"
    pageEncoding="UtF-8"%>
<%@ page import="model.ResultMemberInfo" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" name="format-detection" content="text/html; charset=UtF-8; telephone=no">
		<title>会員登録確認画面</title>

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
		<div id="headerArea">
			<h2 align="center">
				<Marquee width="50%" behavior="slide" scrollamount="80">∠●_●；ショップ　☆彡</Marquee>
			</h2>
		</div>

		<s:form cssClass="form-horizontal">
			<div align="center">
				<h4>以下の内容で登録します！　宜しいですか？</h4>
			</div>
			<table border="1" cellpadding="3" align="center" style="font-size:16px;">
				<tr>
					<td class="rowheader">会員ID</td>
					<td class="input" colspan="2"><s:property value="memberInfo.memberId" /></td>
				</tr>
				<tr>
					<td class="rowheader">パスワード</td>
					<td class="input" colspan="2"><s:textfield name="memberInfo.password" type="password" readonly="true" cssStyle="background-color:#ccff66" /></td>
				</tr>
			</table>

			<div align="center" style="margin-top:50px">
				<h4>お客様の情報を確認してください！</h4>
			</div>
			<table border="1" cellpadding="3" align="center" style="font-size:16px;">
				<tr>
					<td class="rowheader">氏名<font class="required"> ※必須</font></td>
					<td class="input" > 姓　：<s:property value="memberInfo.lastName" /></td>
					<td class="input" > 名　：<s:property value="memberInfo.firstName" /></td>
				</tr>
				<tr>
					<td class="rowheader">フリガナ<font class="required"> ※必須</font><br>（カタカナで入力）</td>
					<td class="input" > セイ：<s:property value="memberInfo.lastNameKana" /></td>
					<td class="input" > メイ：<s:property value="memberInfo.firstNameKana" /></td>
				</tr>
				<tr>
					<td class="rowheader">性別<font class="required"> ※必須</font></td>
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
					<td class="rowheader">生年月日<font class="required"> ※必須</font></td>
					<td class="input" colspan="2">西暦<s:property value="memberInfo.bornYear" />年
													  <s:property value="memberInfo.bornMonth" />月
													  <s:property value="memberInfo.bornDay" />日</td>
				</tr>
				<tr>
					<td class="rowheader">年齢<font class="required"> ※必須</font></td>
					<td class="input" colspan="2"><s:property value="memberInfo.age" />歳</td>
				</tr>
				<tr>
					<td class="rowheader">郵便番号<font class="required"> ※必須</font></td>
					<td  class="input"colspan="2"> 〒<s:property value="memberInfo.postalCode1" />
												   ― <s:property value="memberInfo.postalCode2" /></td>
				</tr>
				<tr>
					<td rowspan="2" class="rowheader">住所<font class="required"> ※必須</font></td>
					<td  class="input" rowspan="2" colspan="2">
						<s:property value="memberInfo.address" /><br>
						<s:property value="memberInfo.building" /></td>
				</tr>
				<tr></tr>
				<tr>
					<td class="rowheader">電話番号<font class="required"> ※必須</font></td>
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
					<td class="input" colspan="2"><%= telKind %>　
						<s:property value="memberInfo.telNumber1" />－
						<s:property value="memberInfo.telNumber2" />－
						<s:property value="memberInfo.telNumber3" />
					</td>
				</tr>
			</table>
			<div align="center" style="margin-top:15px">
				<s:submit cssClass="button" method="nextPage" value="上記の内容で登録する" />
				<s:submit cssClass="button" method="back" value="戻る" />
			</div>
		</s:form>
	</body>
</html>