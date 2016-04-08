<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PC2015</title>
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<style>
div.container {
	max-width: 800px;
}

p.err {
	color: red;
}

div.result dd {
	margin-bottom: 32px;
}
</style>
<style>
table.brwsr2 {
	border-spacing: 0;
	border: solid #33f 2px;
	border-radius: 5px;
	margin-left: auto;
	margin-right: auto;
}

table.brwsr2 th {
	border-right: solid #33f 1px;
	padding: 10px;
	background: linear-gradient(#39f, #aaa);
	box-shadow: 2px 2px 4px #FE9 inset;
	color: #FFF;
	text-shadow: 1px 1px 1px #33f;
}

table.brwsr2 td.data {
	border-top: solid #33f 1px;
	border-right: solid #33f 1px;
	padding: 7px
}

table.brwsr2 td.bar {
	border-radius: 0 0 0 3px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>
				<a href="/PC2015/login.action">PC2015</a><small>ver β</small>
			</h1>
		</div>
		<!--
<style>
table.brwsr2 {
    margin: 0 auto;
    width: ;
    border: none;
    border-top: solid 1px #666;
    border-bottom: solid 1px #666;
    border-collapse: separate;
    border-spacing: 0 10px;
    background: #f5f5f5;
}
table.brwsr2 th {
    vertical-align: middle;
    height: 10px;

    border-right: solid 1px #999;
    border-left: solid 1px #999;
    margin: 0;
    text-align: center;
    color: #666;
    font-size: 20px;
    font-weight: bold;
}
table.brwsr2 td.data {
    padding: 0;
    margin: 0;
    height: 10px;
    width: 10px;
    border-right: solid 1px #999;
    border-left: solid 1px #999;
    color: #999;
    font-size: 11px;
    line-height: 16px;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap;
    overflow: hidden;
}
table.brwsr2 td.bar {
    height: 1px;
    width: 100%;
    border-top: solid 1px #34495e;
}
</style>
</head>
<body>
    <div class="container">
        <div class="page-header">
            <h1><a href="/PCManagement/login.action">Hello Struts2</a> <small>ver 2.3.16</small></h1>
        </div>
-->