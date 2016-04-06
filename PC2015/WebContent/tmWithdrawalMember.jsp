<%@ page language="java" contentType="text/html; charset=UtF-8"
    pageEncoding="UtF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UtF-8">
		<title>退会手続き画面</title>

		<link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>

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

		<script language="JavaScript">
			// 半角英数字のみ入力可能
			function hanAlpha() {
				keyCode = event.keyCode;
				if(keyCode == 8		// バックスペース
				|| keyCode == 9		// タブキー
				|| keyCode == 46	// deleteキー
				|| (keyCode >= 37 && 40 >= keyCode)		// 矢印キー
				|| (keyCode >= 48 && 57 >= keyCode)		// テンキーじゃない数字
				|| (keyCode >= 96 && 105 >= keyCode)	// テンキーの数字
				|| (keyCode >= 65 && 90 >= keyCode)		// a-z
				|| (keyCode >= 97 && 122 >= keyCode)) {	// A-Z
					return true;
				} else {
					return false;
				}
			}
		</script>
	</head>

	<body style="background-color:#f0e68c" onLoad="document.tmChangePassword.oldPassword.focus()">
		<div id="headerArea">
			<h2 align="center">
				<Marquee behavior="alternate" direction="right" width="25%" scrollamount="50" scrolldelay="10">∠●_●；ショップ　☆彡</Marquee>
			</h2>
			<h5 align="right" style="margin-right:30px">ようこそ!<br/><s:property value="memberId" />さん</h5>
		</div>

		<s:form cssClass="form-horizontal">
			<div align="center">
				<h4>本当に退会しますか？退会する場合はパスワードを入力しください！</h4>
			</div>
			<p class="err" align="center"><s:property value="errMessage" /></p>
			<table border="1" cellpadding="3" align="center" style="font-size:16px;">
				<tr>
					<td class="rowheader">パスワード</td>
					<td class="input" align="center" ><s:textfield name="password" type="password" onkeyDown="return hanAlpha()" cssStyle="ime-mode:disabled" maxlength="12"/></td>
				</tr>
				<tr>
					<td class="rowheader">パスワード確認用</td>
					<td class="input" align="center" colspan="2"><small>確認のため、もう一度同じパスワードを入力してください</small><br>
							<s:textfield name="password2" type="password" onkeyDown="return hanAlpha()" cssStyle="ime-mode:disabled" maxlength="12"/></td>
				</tr>
			</table>
			<div align="center" style="margin-top:15px">
				<s:submit cssClass="button" method="quit" value="退会します" />
				<s:submit cssClass="button" method="back" value="戻る" />
			</div>
		</s:form>
	</body>
</html>