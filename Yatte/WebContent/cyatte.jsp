<%@ page session="true"%>
<%@page import="endpoint.yatteName"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link id="stylesheet" href="/Yatte/Asset/clean.css" rel="stylesheet" media="screen">
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<link rel="shortcut icon" href='/Yatte/images/cyatteFavicon.ico' >
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="/Yatte/Asset/jquery.columns.js"></script>
<script type="text/javascript" src="/Yatte/Asset/mustache.min.js"></script>

<title>Cyatte!</title>
<style>
#heading {
	position: relative;
	padding: 5px 20px;
	font: bold 28px/1.6 Arial, Helvetica, sans-serif;
	color: #333;
	background: #fff;
	text-shadow: 1px 1px 0 #fff, 2px 2px 0 #999;
	border-top: #333 solid 3px;
	border-bottom: #333 solid 3px;
	background-image: -webkit-gradient(linear, left top, right bottom, from(rgba(255, 255, 255
		, 0.0)), color-stop(0.4, rgba(255, 255, 255, 0.0)),
		color-stop(0.4, rgba(0, 0, 0, 0.1)),
		color-stop(0.6, rgba(0, 0, 0, 0.1)),
		color-stop(0.6, rgba(255, 255, 255, 0.0)), to(rgba(255, 255, 255, 0.0)));
	background-image: -webkit-linear-gradient(top -45deg, transparent 40%, rgba(0, 0, 0, 0.1)
		40%, rgba(0, 0, 0, 0.1) 60%, transparent 60%);
	background-image: -moz-linear-gradient(top -45deg, transparent 40%, rgba(0, 0, 0, 0.1)
		40%, rgba(0, 0, 0, 0.1) 60%, transparent 60%);
	background-image: -o-linear-gradient(top -45deg, transparent 40%, rgba(0, 0, 0, 0.1)
		40%, rgba(0, 0, 0, 0.1) 60%, transparent 60%);
	background-image: linear-gradient(to bottom -45deg, transparent 40%, rgba(0, 0, 0, 0.1)
		40%, rgba(0, 0, 0, 0.1) 60%, transparent 60%);
	background-size: 4px 4px;
}

#heading:before {
	content: " ";
	position: absolute;
	top: 100%;
	left: 24px;
	width: 0;
	height: 0;
	border-width: 12px;
	border-style: solid;
	border-color: transparent;
	border-top-color: #333;
}

#heading:after {
	content: " ";
	position: absolute;
	top: 100%;
	left: 28px;
	width: 0;
	height: 0;
	border-width: 8px;
	border-style: solid;
	border-color: transparent;
	border-top-color: #f0f0f0;
	z-index: 1;
}

.popbox {
	text-align: center;
}

form-group {
	text-align: center;
}

.button {
	text-align: center;
}

#box {
	height: 200px;
	overflow: auto;
	max-width: 800px;
	margin-left: 10%;
	border: 5px solid black;
	border-radius: 50px 50px 50px 50px;
	-webkit-box-ordinal-group: 1;
	-moz-box-ordinal-group: 1;
	word-wrap: break-word;
}
</style>
<style>
div.header {
	max-width: 200px;
	margin-left: 5%;
}

p.err {
	color: red;
}
</style>
</head>
<body>
<div class="header">
	<div class="page-header">
		<h1 class="h3 text-left" id="heading">Cyatte!</h1>
	</div>
</div>

	<div>
	<p style="color:#009933 ; padding :0 10%" ID="name" value="<%out.print(session.getAttribute("name").toString());%>"><%out.print(session.getAttribute("name").toString());
	%></p>
	<p style="color: red ; text-align : center " ID="error"/>
    </p></div>

	<!-- ↓ ここのdivにクラス追加してマージン追加して、フォームを上下で離してあげる -->
	<div>
		<div class="form-horizontal">
			<label class="col-sm-offset-2 col-sm-4 control-label">やるひと！</label>
			<div class="col-sm-2">
				<select name="who" id="who" class="form-control">
				<option ID="みんな">みんな</option>
					<%
						ArrayList<yatteName> yList = (ArrayList<yatteName>) request.getAttribute("nameList");
						for (int i = 0; i < yList.size(); i++) {
							out.print("<option ID='" + yList.get(i).getName() + "'>");
							out.print(yList.get(i).getName());
							out.print("</option>");
						}
					%>
				</select>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>

	<div>
		<div class="form-horizontal">
			<label class="col-sm-offset-2 col-sm-4 control-label">こめんと！</label>
			<div class="col-sm-2">
				<input autofocus ID="ex" class="form-control" maxlength='50' required>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>



	<div>
		<div class="form-horizontal">
			<div class="col-sm-offset-4 col-sm-4" id="button">
				<button class="btn btn-primary btn-lg pull-right" id="yatte">yatte!</button>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>


	<div>
		<div class="col-sm-offset-1 col-xs-10" style="text-center">
			<div id="columns"></div>
		</div>
	</div>

	<script type="text/javascript" src="/Yatte/Asset/cyatte.js"></script>

</body>
</html>