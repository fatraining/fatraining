<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<head>
	<meta charset="utf-8" />
	<title>facloud</title>
	<link rel="stylesheet" type="text/css" href="./asset/facloud.css"/>
	<script src="./asset/jquery-1.11.3.min.js"></script>
</head>
<div id="wrapper">
	<div id="left_col">
		<h1><a href="./facloud.action">facloudyade</a></h1>
		<nav>
			<ul>
				<li><a href="./facloudLogin.action">ログインやで</a></li>
				<li><a href="./facloudTimecard.action">タイムカードやで</a></li>
				<li><a href="./facloudAttendanceUpdate.action">勤怠修正やで</a></li>
			</ul>
		</nav>
	
	</div>
	<main id="right_col">
		<section>
			<header id="main_header">
				<h1><s:property value="titleTxt" /></h1>
				<s:if test="userName != null">
				<div id="user_menu">
					<a class="user_name">
						<s:if test="sectionName != null">
							<s:property value="sectionName" />：
						</s:if>
						<s:property value="userName" />
					</a>
					<ul>
						<li><a>プロフィールやで</a></li>
						<li><a>設定やで</a></li>
						<li><a>ログアウトやで</a></li>
					</ul>
				</div>
				</s:if>
			</header>
			
			<div>