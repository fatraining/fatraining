<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>お客様情報表示・入力画面</title>
		<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

		<SCRIPT src="asset/tmInputCheck.js"></SCRIPT>
		<script type="text/javascript">
		/**
		 * 生年月日から年齢の計算
		 */
		function calcAge() {

			var year = document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornYear.value;
			var month = document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornMonth.value;
			var day = document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornDay.value;

			// 入力チェック
			if(year = "" || month == "" || day == "") {
				// 年月日で入力されていない項目がある場合は何もしない
				return true;
			}
			// 月チェック
			if((month != "" && (month < 1 || 12 < month))) {
				// あり得ない月が入力されている場合はメッセージ表示
				alert("月は1～12の範囲で入力してください。");
				document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornMonth.value = "";
				document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornMonth.focus();
				return false;
			}

			// 日チェック
			if(1 > day || day > 31) {
				// あり得ない日が入力されている場合はメッセージ表示
				alert("存在しない日付が入力されています。");
				document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornDay.value = "";
				document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornDay.focus();
				return false;
			}
			if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
				// あり得ない日が入力されている場合はメッセージ表示
				alert("存在しない日付が入力されています。");
				document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornDay.value = "";
				document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornDay.focus();
				return false;
			}
			if (chkUru(year)) {
				// 西暦がうるう年の場合
				if(month == 2 && day > 29) {
					// あり得ない日が入力されている場合はメッセージ表示
					alert("存在しない日付が入力されています。");
					document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornDay.value = "";
					document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornDay.focus();
					return false;
				}
			} else {
				// 西暦がうるう年以外の場合
				if(month == 2 && day > 28) {
					// あり得ない日が入力されている場合はメッセージ表示
					alert("存在しない日付が入力されています。");
					document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornDay.value = "";
					document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornDay.focus();
					return false;
				}
			}
			// 現在から誕生日を引き、基準日に足す
			now = new Date();
			birth = new Date(1970, 0, day);
			birth.setTime(now.getTime() - birth.getTime());

			//求めた年月日から基準日を引く
			myYear = birth.getUTCFullYear() - document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornYear.value;
			myMonth = birth.getUTCMonth() - (document.tmInputUserInfo.tmInputUserInfo_memberInfo_bornMonth.value - 1);
			if(myMonth < 0){
				//月がマイナスなので年から繰り下げ
				myYear --;
				myMonth += 12;
			 }

			myDate = birth.getUTCDate();
			document.tmInputUserInfo.tmInputUserInfo_memberInfo_age.value = myYear;
			return true;
		}
		</script>
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
	</head>

	<body style="background-color:#f0e68c" onLoad="document.tmInputmemberInfo.tmInputUserInfo_memberInfo_lastName.focus()">
		<div id="headerArea" style="margin-right:40%">
				<h2 align="center">
					<Marquee width="50%" scrollamount="70">∠●_●；ショップ　☆彡</Marquee>
				</h2>
		</div>

		<s:form cssClass="form-horizontal">
			<%
			String buttonId = (String)request.getAttribute("buttonId");
			if ("buy".equals(buttonId)) {
			%>
			<div class="col-sm-offset-1" align="center">
				<h4>お客様の情報を入力してください！</h4>
			</div>
			<%
			} else {
			%>
			<div class="col-sm-offset-1" align="center">
				<h4>変更したい情報を入力してください！</h4>
			</div>
			<%
			}
			%>
			<p class="err" align="center"><s:property value="errMessage" /></p>
			<table border="1" cellpadding="3" align="center" style="font-size:16px;">
				<tr>
					<td class="rowheader">氏名<font class="required"> ※必須</font></td>
					<td class="input" align="center"> 姓　：<s:textfield name="memberInfo.lastName" /></td>
					<td class="input" align="center"> 名　：<s:textfield name="memberInfo.firstName" /></td>
				</tr>
				<tr>
					<td class="rowheader">フリガナ<font class="required"> ※必須</font><br>（カタカナで入力）</td>
					<td class="input" align="center"> セイ：<s:textfield name="memberInfo.lastNameKana" /></td>
					<td class="input" align="center"> メイ：<s:textfield name="memberInfo.firstNameKana" /></td>
				</tr>
				<tr>
					<td class="rowheader">性別<font class="required"> ※必須</font></td>
					<td class="input" colspan="2"><s:radio name="memberInfo.sex" list="#{0:'男性', 1:'女性'}" /></td>
				</tr>
				<tr>
					<td class="rowheader">生年月日<font class="required"> ※必須</font></td>
					<td class="input" colspan="2">西暦　<s:textfield name="memberInfo.bornYear" maxlength="4" size="1" cssStyle="text-align:right; ime-mode:disabled;" onkeyDown="return numOnly()" onBlur="return calcAge()" />年
													   <s:textfield name="memberInfo.bornMonth" maxlength="2" size="1" cssStyle="text-align:right; ime-mode:disabled;" onkeyDown="return numOnly()" onBlur="return calcAge()" />月
													   <s:textfield name="memberInfo.bornDay" maxlength="2" size="1" cssStyle="text-align:right; ime-mode:disabled;" onkeyDown="return numOnly()" onBlur="return calcAge()" />日</td>
				</tr>
				<tr>
					<td class="rowheader">年齢<font class="required"> ※必須</font></td>
					<td class="input" colspan="2"><s:textfield name="memberInfo.age" maxlength="3" size="1" cssStyle="text-align:right; ime-mode:disabled;" onkeyDown="return numOnly()" />歳</td>
				</tr>
				<tr>
					<td class="rowheader">郵便番号<font class="required"> ※必須</font></td>
					<td  class="input"colspan="2"> 〒　<s:textfield name="memberInfo.postalCode1" maxlength="3" size="2" onkeyDown="return numOnly()" cssStyle="ime-mode:disabled" />
												   ― <s:textfield name="memberInfo.postalCode2" maxlength="4" size="3" onkeyDown="return numOnly()" cssStyle="ime-mode:disabled" /></td>
				</tr>
				<tr>
					<td rowspan="2" class="rowheader">お届け先<font class="required"> ※必須</font></td>
					<td  class="input" rowspan="2" colspan="2">
						<s:textfield name="memberInfo.address" size="50" /><br>
						建物名：<s:textfield name="memberInfo.building" size="41" /></td>
				</tr>
				<tr></tr>
				<tr>
					<td class="rowheader">電話番号<font class="required"> ※必須</font></td>
					<td class="input"><s:radio name="memberInfo.telKind" list="#{0:'自宅', 1:'携帯', 2:'その他'}" /></td>
					<td class="input"><s:textfield name="memberInfo.telNumber1" maxlength="4" size="2" onkeyDown="return numOnly()" cssStyle="ime-mode:disabled" />－
									  <s:textfield name="memberInfo.telNumber2" maxlength="4" size="2" onkeyDown="return numOnly()" cssStyle="ime-mode:disabled" />－
									  <s:textfield name="memberInfo.telNumber3" maxlength="4" size="2" onkeyDown="return numOnly()" cssStyle="ime-mode:disabled" /></td>
				</tr>
				<%
				if ("buy".equals(buttonId)) {
				%>
				<tr>
					<td class="rowheader" rowspan="9" valign="top">備考</td>
					<td class="input" rowspan="9" colspan="2">ご要望などをご記入ください。<br><s:textarea name="memberInfo.remarks" cols="60" rows="8" maxlingth="500" /></td>
				</tr>
				<%
				}
				%>
			</table>
			<div align="center" style="margin-top:15px">
				<s:submit cssClass="button" method="nextPage" value="次へ" />
				<s:submit cssClass="button" method="back" value="戻る" />
			</div>
		</s:form>
	</body>
</html>