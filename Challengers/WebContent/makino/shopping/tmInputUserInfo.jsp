<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>お客様情報表示・入力画面</title>
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
			p.err{
				color: red;
				font-size: 110%;
				font-weight: bold;
			}
			div.result dd{
				margin-bottom: 32px;
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

		<script language="JavaScript">
			// 数値のみ入力可能
			function numOnly() {
				keyCode = event.keyCode;
				if(keyCode == 8		// バックスペース
				|| keyCode == 9		// タブキー
				|| keyCode == 46	// deleteキー
				|| (keyCode >= 37 && 40 >= keyCode)		// 矢印キー
				|| (keyCode >= 48 && 57 >= keyCode)		// テンキーじゃない数字
				|| (keyCode >= 96 && 105 >= keyCode)) {	// テンキーの数字
					return true;
				} else {
					return false;
				}
			}
		</script>
	</head>

	<body style="background-color:#f0e68c" onLoad="document.tmInputUserInfo.tmInputUserInfo_userInfo_lastName.focus()">
		<div id="headerArea" style="margin-right:40%">
			<h2 align="center">×××ショップ</h2>
		</div>

		<s:form cssClass="form-horizontal">
			<div class="col-sm-offset-1" align="center">
				<h4>お客様の情報を入力してください！</h4>
			</div>
			<p class="err" align="center"><s:property value="errMessage" /></p>
			<table border="1" cellpadding="3" align="center" style="font-size:16px;">
				<tr>
					<td class="rowheader">氏名<font class="required"> ※必須</font></td>
					<td class="input" align="center"> 姓　：<s:textfield name="userInfo.lastName" /></td>
					<td class="input" align="center"> 名　：<s:textfield name="userInfo.firstName" /></td>
				</tr>
				<tr>
					<td class="rowheader">フリガナ<font class="required"> ※必須</font><br>（カタカナで入力）</td>
					<td class="input" align="center"> セイ：<s:textfield name="userInfo.lastNameKana" /></td>
					<td class="input" align="center"> メイ：<s:textfield name="userInfo.firstNameKana" /></td>
				</tr>
				<tr>
					<td class="rowheader">性別<font class="required"> ※必須</font></td>
					<td class="input" colspan="2"><s:radio name="userInfo.sex" list="#{0:'男性', 1:'女性'}" /></td>
				</tr>
				<tr>
					<td class="rowheader">生年月日<font class="required"> ※必須</font></td>
					<td class="input" colspan="2">西暦　<s:textfield name="userInfo.bornYear" maxlength="4" size="1" style="text-align:right" onkeyDown="return numOnly()" />年
													   <s:textfield name="userInfo.bornMonth" maxlength="2" size="1" style="text-align:right" onkeyDown="return numOnly()" />月
													   <s:textfield name="userInfo.bornDay" maxlength="2" size="1" style="text-align:right" onkeyDown="return numOnly()" />日</td>
				</tr>
				<tr>
					<td class="rowheader">年齢<font class="required"> ※必須</font></td>
					<td class="input" colspan="2"><s:textfield name="userInfo.age" maxlength="3" size="1" style="text-align:right" onkeyDown="return numOnly()" />歳</td>
				</tr>
				<tr>
					<td class="rowheader">郵便番号<font class="required"> ※必須</font></td>
					<td  class="input"colspan="2"> 〒　<s:textfield name="userInfo.postalCode1" maxlength="3" size="2" onkeyDown="return numOnly()" />
												   ― <s:textfield name="userInfo.postalCode2" maxlength="4" size="3" onkeyDown="return numOnly()" /></td>
				</tr>
				<tr>
					<td rowspan="2" class="rowheader">お届け先<font class="required"> ※必須</font></td>
					<td  class="input" rowspan="2" colspan="2">
						<s:textfield name="userInfo.address" size="50" /><br>
						建物名：<s:textfield name="userInfo.building" size="41" /></td>					
				</tr>
				<tr></tr>
				<tr>
					<td class="rowheader">電話番号<font class="required"> ※必須</font></td>
					<td class="input"><s:radio name="userInfo.telKind" list="#{0:'自宅', 1:'携帯', 2:'その他'}" /></td>
					<td class="input"><s:textfield name="userInfo.telNumber1" maxlength="4" size="2" onkeyDown="return numOnly()" />－
									  <s:textfield name="userInfo.telNumber2" maxlength="4" size="2" onkeyDown="return numOnly()" />－
									  <s:textfield name="userInfo.telNumber3" maxlength="4" size="2" onkeyDown="return numOnly()" /></td>
				</tr>
				<tr>
					<td class="rowheader" rowspan="9" valign="top">備考</td>
					<td class="input" rowspan="9" colspan="2">ご要望などをご記入ください。<br><s:textarea name="userInfo.remarks" cols="60" rows="8" maxlingth="500" /></td>
				</tr>
			</table>
			<div align="center" style="margin-top:15px">
				<s:submit cssClass="button" method="nextPage" value="次へ" />
				<s:submit cssClass="button" method="back" value="戻る" />
			</div>
		</s:form>
	</body>
</html>