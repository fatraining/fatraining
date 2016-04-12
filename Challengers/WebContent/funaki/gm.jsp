<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FFGMパラメータ計算機</title>
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />

<style>
* {
	font-family: helvetica, arial, 'hiragino kaku gothic pro', meiryo, 'ms pgothic', sans-serif;
}

.container {
	width: 95%;
	max-width: 1400px;
	margin: 20px;
}

.menu {
	margin: 30px 10px 0 10px;
	border: 1px solid black;
	padding: 0.1em;
}

.menu * {
	margin: 0.5em;
}

.menu h2 {
	font-family: "メイリオ";
	font-size: 12pt;
	color: white;
	background: rgba(10, 15, 222, 0.8);
	border: 3px solid rgba(255, 255, 255, 0.8);
	border-radius: 5px;
	box-shadow: 2px 2px 2px 2px rgba(133, 133, 133, 0.4);
	margin: -30px 0 0 0;
	padding: 4px;
}

.main {
	margin: 0 1em 0 1em;
}
.msg-window h2 {
	font-family: "Monotype Corsiva";
}

.error {
	font-family: "メイリオ";
	color: red;
	font-weight: bold;
}

.formProfile select {
	color: red;
	background: rgba(210, 245, 210, 1);
	border-radius: 4px;
	padding: 5px;
	width: 100px;
}

.formWeapons  select {
	background: rgba(240, 205, 205, 1);
	border-radius: 4px;
	padding: 5px;
	width: 50%;
}

.formArmors  select {
	background: rgba(205, 240, 205, 1);
	border-radius: 4px;
	padding: 5px;
	width: 50%;
}

.formArmors input, div.formWeapons input {
	border-radius: 4px;
	padding: 3px;
	width: 50px;
	vertical-align:middle;
	box-shadow:0 0 0 0 rgba(0,0,0,0);
}

#calc-btn {
	font-size: 1.3em;
	font-weight: bold;
	border-radius: 8px;
	padding: 3px;
	width: 50px;
	vertical-align:middle;
	box-shadow:0 0 0 0 rgba(0,0,0,0);
	width: 85%;
}

#err-window {
	position: absolute;
	top: 30px;
	font-family: "メイリオ";
	font-size: 12pt;
	font-weight: bold;
	color: white;
	background: rgba(222, 15, 10, 0.8);
	border: 3px solid rgba(255, 255, 0, 0.9);
	border-radius: 5px;
	box-shadow: 2px 2px 2px 2px rgba(133, 133, 133, 0.4);
	margin: -15px 0px 0 0;
	padding: 12px;
}

.main table {
	border-collapse:separate;
	border-right: 3px solid rgba(235, 245, 235, 1);
	border-bottom: 3px solid rgba(235, 245, 235, 1);
	border-left: 3px solid rgba(235, 245, 235, 1);
	border-radius: 0px 0px 10px 10px;
	background-color: #bde9ba;
	width: 100%;
	box-shadow: 0px -5px 2px 2px rgba(133, 133, 133, 0.4) inset;
}

.result td {
	flaot: center;
	padding: 5px 0px 5px;
	text-align: center;
	width: 170px;
	}

.result th {
	font-size: large;
}
.result p {
	font-size: x-large;
	color: white;
	background: rgba(47,56,88,1);
	margin: 0 10px;
	padding: 0 20px 0 0;
/* 	border: 4px solid red; */
	border-radius: 18px;
	text-align: right;
}

#center {
	text-align: center;
	line-height: 1.5;
}

#left {
	float: left;
	padding: 0px 0px 0px 10px;
	}

#small 	{
	font-size: 80%;
}
.main h1 {
	display: block;
	border-left: 20px solid rgba(235, 245, 235, 1);
	border-top: 3px solid rgba(235, 245, 235, 1);
	border-right: 3px solid rgba(235, 245, 235, 1);
	background: rgba(100,150,220,1);
	margin: 10px 0px 0px 0px;
	padding: 3px;
	border-radius: 10px 10px 0 0;
}

</style>
</head>

<!-- -----------------以下body---------------------- -->
<body>
	<div class="container">

		<!-- ---------------------メニュー-------------------- -->
		<div class="col-md-4 first-div">
			<div class="menu">
				<s:form>
					<!-- プロフィール入力---------------------------- -->
					<h2 class="msg-window"><s:property value="msg1" /></h2>
					<s:if test="errCheck==true">
					<figure><figcaption>
							<h2 id="err-window"><s:property value="errmsg" /></h2>
					</figcaption></figure>
					</s:if>
					<div class="formProfile">
						<div class="form-inline">
							<s:select name="job" value="job"
								list="#{'未選択':'ジョブ選択','戦士':'戦士','シーフ':'シーフ','ナイト':'ナイト',
	 									'白魔':'白魔','黒魔':'黒魔','モンク':'モンク','赤魔':'赤魔'}" />
							<label>Lv：<s:textfield name="jobLv" style="width:60px;"
								cssClass="form-control" /></label>
							<s:submit method="send" value="決定" style="width:80%;"
								cssClass="btn btn-primary" />
						</div>
					</div>
					<!-- 武器選択-------------------------- -->
					<div class="formWeapons">
						<s:select list="%{weapons}" name="weapon[0]"/> Lv:<s:textfield name="weaponLv[0]"/>
						<s:select list="%{weapons}" name="weapon[1]"/> Lv:<s:textfield name="weaponLv[1]"/>
						<s:select list="%{weapons}" name="weapon[2]"/> Lv:<s:textfield name="weaponLv[2]"/>
						<s:select list="%{weapons}" name="weapon[3]"/> Lv:<s:textfield name="weaponLv[3]"/>
						<s:select list="%{weapons}" name="weapon[4]"/> Lv:<s:textfield name="weaponLv[4]"/>
					</div>
					<!-- ↑武器　------------　↓防具 ------------->
					<div class="formArmors">
						<s:select list="%{head}" name="armor[0]"/> Lv:<s:textfield name="armorLv[0]"/>
						<s:select list="%{body}" name="armor[1]"/> Lv:<s:textfield name="armorLv[1]"/>
						<s:select list="%{arms}" name="armor[2]"/> Lv:<s:textfield name="armorLv[2]"/>
						<s:select list="%{foot}" name="armor[3]"/> Lv:<s:textfield name="armorLv[3]"/>
					</div>
					<s:submit id="calc-btn" method="calc" value="計算" />
				</s:form>
			</div>
		</div>

		<!-- ---------------------メイン部分-------------------- -->
		<div class="col-md-8 second-div">
			<div class="main">
				<h1>ジョブパラメータ</h1>
				<!-- プロフィール結果----------------------- -->
				<!-- ジョブのみの計算結果 -->
				<table class="result">

				<tr>
					<td colspan="3">
						<h2><s:property value="job"/>／レベル<s:property value="jobLv"/></h2>
					</td></tr>
				<tr>
					<td>
						<p id="left">HP</p><p><s:property value="jobResult[0]" /></p></td><td><p id="left">物攻</p><p><s:property value="jobResult[1]" /></p></td><td><p id="left">魔攻</p><p><s:property value="jobResult[2]" /></p>
					</td></tr>
				<tr>
					<td>
						<p id="left">敏捷</p><p><s:property value="jobResult[3]" /></p></td><td><p id="left">物防</p><p><s:property value="jobResult[4]" /></p></td><td><p id="left">魔防</p><p><s:property value="jobResult[5]" /></p>
					</td></tr>
				<tr>
					<td>
						<p id="left">命中</p><p><s:property value="jobResult[6]" /></p></td><td><p id="left">回避</p><p><s:property value="jobResult[7]" /></p></td><td><p id="left">会心</p><p><s:property value="jobResult[8]" /></p>
					</td></tr>
				<tr>
					<td colspan="3">
						<h2 id="center">ジョブのみの総合戦闘力　<s:property value="jobSum"/></h2>
					</td></tr>

				</table>
				<!-- 装備を含めた計算結果 -->
				<br/>
				<h1>装備合算結果</h1>
				<table class="result">
				<tr><td colspan="3">
								<div id="small">武器1：<s:property value="weapon[0]"/>(Lv<s:property value="weaponLv[0]"/>)　武器2：<s:property value="weapon[1]"/>(Lv<s:property value="weaponLv[1]"/>)　武器3：<s:property value="weapon[2]"/>(Lv<s:property value="weaponLv[2]"/>)　武器4：<s:property value="weapon[3]"/>(Lv<s:property value="weaponLv[3]"/>)　武器5：<s:property value="weapon[4]" />(Lv<s:property value="weaponLv[4]"/>)<br/>
				頭：<s:property value="armor[0]" />(Lv<s:property value="armorLv[0]" />)　胴：<s:property value="armor[1]" />(Lv<s:property value="armorLv[1]" />)　手：<s:property value="armor[2]" />(Lv<s:property value="armorLv[2]" />)　足：<s:property value="armor[3]" />(Lv<s:property value="armorLv[3]" />)</div>
				</td></tr>
				<tr>
					<td><p id="left">HP</p><p><s:property value="hp" /></p></td>
						<td><p id="left">物攻</p><p><s:property value="atk" /></p></td>
							<td><p id="left">魔攻</p><p><s:property value="ma" /></p></td>
				</tr>
				<tr>
					<td><p id="left">敏捷</p><p><s:property value="agi" /></p></td>
						<td><p id="left">物防</p><p><s:property value="def" /></p></td>
							<td><p id="left">魔防</p><p><s:property value="md" /></p></td>
				</tr>
				<tr>
					<td><p id="left">命中</p><p><s:property value="dex" /></p></td>
						<td><p id="left">回避</p><p><s:property value="eva" /></p></td>
							<td><p id="left">会心</p><p><s:property value="crt" /></p></td>
				</tr>
				<tr>
					<td colspan="3">
						<h2 id="center">総合戦闘力　<s:property value="allSum"/></h2>
					</td>
				</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>