<%@ page language="java" contentType="text/html; charset=UtF-8"
    pageEncoding="UtF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UtF-8">
		<title>会員登録画面</title>
		<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

		<SCRIPT src="asset/tmInputCheck.js"></SCRIPT>
		<script type="text/javascript">
			/**
			 * 生年月日から年齢の計算
			 */
			function calcAge() {
				var year = document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornYear.value;
				var month = document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornMonth.value;
				var day = document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornDay.value;

				// 入力チェック
				if(year = "" || month == "" || day == "") {
					// 年月日で入力されていない項目がある場合は何もしない
					return true;
				}
				// 月チェック
				if((month != "" && (month < 1 || 12 < month))) {
					// あり得ない月が入力されている場合はメッセージ表示
					alert("月は1～12の範囲で入力してください。");
					document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornMonth.value = "";
					document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornMonth.focus();
					return false;
				}

				// 日チェック
				if(1 > day || day > 31) {
					// あり得ない日が入力されている場合はメッセージ表示
					alert("存在しない日付が入力されています。");
					document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornDay.value = "";
					document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornDay.focus();
					return false;
				}
				if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
					// あり得ない日が入力されている場合はメッセージ表示
					alert("存在しない日付が入力されています。");
					document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornDay.value = "";
					document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornDay.focus();
					return false;
				}
				if (chkUru(year)) {
					// 西暦がうるう年の場合
					if(month == 2 && day > 29) {
						// あり得ない日が入力されている場合はメッセージ表示
						alert("存在しない日付が入力されています。");
						document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornDay.value = "";
						document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornDay.focus();
						return false;
					}
				} else {
					// 西暦がうるう年以外の場合
					if(month == 2 && day > 28) {
						// あり得ない日が入力されている場合はメッセージ表示
						alert("存在しない日付が入力されています。");
						document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornDay.value = "";
						document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornDay.focus();
						return false;
					}
				}
				// 現在から誕生日を引き、基準日に足す
				now = new Date();
				birth = new Date(1970, 0, day);
				birth.setTime(now.getTime() - birth.getTime());

				//求めた年月日から基準日を引く
				myYear = birth.getUTCFullYear() - document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornYear.value;
				myMonth = birth.getUTCMonth() - (document.tmRegistrationMember.tmRegistrationMember_memberInfo_bornMonth.value - 1);
				if(myMonth < 0){
					//月がマイナスなので年から繰り下げ
					myYear --;
					myMonth += 12;
				 }

				myDate = birth.getUTCDate();
				document.tmRegistrationMember.tmRegistrationMember_memberInfo_age.value = myYear;
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
			p.err{
				color: red;
				font-size: 16px;
				margin-top: 10px;
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

	<body style="background-color:#f0e68c" onLoad="document.tmRegistrationMember.memberId.focus()">
		<div id="headerArea">
			<h2 align="center">
				<Marquee width="25%" scrollamount="100" scrolldelay="1">∠●_●；ショップ　☆彡</Marquee>
			</h2>
		</div>

		<s:form cssClass="form-horizontal">
			<div align="center">
				<h4>会員ID と パスワードを設定してください！</h4>
			</div>
			<p class="err" align="center"><s:property value="errMessage" /></p>
			<table border="1" cellpadding="3" align="center" style="font-size:16px;">
				<tr>
					<td class="rowheader">会員ID</td>
					<td class="input" align="center" colspan="2"><small>全角10文字以内または半角20文字以内で入力してください</small><br>
							<s:textfield name="memberInfo.memberId" maxlength="20"/></td>
				</tr>
				<tr>
					<td class="rowheader">パスワード</td>
					<td class="input" align="center" colspan="2"><small>半角英数字4文字以上12文字以内で入力してください</small><br>
							<s:textfield name="memberInfo.password" type="password" onkeyDown="return hanAlpha()" cssStyle="ime-mode:disabled" maxlength="12"/></td>
				</tr>
				<tr>
					<td class="rowheader">パスワード確認用</td>
					<td class="input" align="center" colspan="2"><small>確認のため、もう一度同じパスワードを入力してください</small><br>
							<s:textfield name="memberInfo.password2" type="password" onkeyDown="return hanAlpha()" cssStyle="ime-mode:disabled" maxlength="12"/></td>
				</tr>
			</table>

			<div align="center" style="margin-top:50px">
				<h4>お客様の情報を入力してください！</h4>
			</div>
			<p class="err" align="center"><s:property value="errMessageInfo" /></p>
			<table border="1" cellpadding="3" align="center" style="font-size:16px;">
				<tr>
					<td class="rowheader">氏名<font class="required"> ※必須</font></td>
					<td class="input" align="center"> 姓　：<s:textfield name="memberInfo.lastName" maxlength="10"/></td>
					<td class="input" align="center"> 名　：<s:textfield name="memberInfo.firstName" maxlength="10"/></td>
				</tr>
				<tr>
					<td class="rowheader">フリガナ<font class="required"> ※必須</font><br>（カタカナで入力）</td>
					<td class="input" align="center"> セイ：<s:textfield name="memberInfo.lastNameKana" maxlength="20"/></td>
					<td class="input" align="center"> メイ：<s:textfield name="memberInfo.firstNameKana" maxlength="20"/></td>
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
					<td rowspan="2" class="rowheader">住所<font class="required"> ※必須</font></td>
					<td  class="input" rowspan="2" colspan="2">
						<s:textfield name="memberInfo.address" size="50" maxlength="50"/><br>
						建物名：<s:textfield name="memberInfo.building" size="41" maxlength="40"/></td>
				</tr>
				<tr></tr>
				<tr>
					<td class="rowheader">電話番号<font class="required"> ※必須</font></td>
					<td class="input"><s:radio name="memberInfo.telKind" list="#{0:'自宅', 1:'携帯', 2:'その他'}" /></td>
					<td class="input"><s:textfield name="memberInfo.telNumber1" maxlength="4" size="2" onkeyDown="return numOnly()" cssStyle="ime-mode:disabled" />－
									  <s:textfield name="memberInfo.telNumber2" maxlength="4" size="2" onkeyDown="return numOnly()" cssStyle="ime-mode:disabled" />－
									  <s:textfield name="memberInfo.telNumber3" maxlength="4" size="2" onkeyDown="return numOnly()" cssStyle="ime-mode:disabled" /></td>
				</tr>
			</table>
			<div align="center" style="margin-top:15px">
				<s:submit cssClass="button" method="nextPage" value="次へ" />
				<s:submit cssClass="button" method="back" value="戻る" />
			</div>
		</s:form>
	</body>
</html>