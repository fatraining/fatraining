<%@ page session="true"%>
<%@page import="endpoint.yatteName"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<style>
div.header {
	max-width: 1000px;
	margin-left: 30%;
}

p.err {
	text-align: center;
	color: red;
}
</style>
<body>
	<form action="/Yatte/yatte" method="POST">
		<p class="err"></p>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-2">
				<label>わいねーむ :</label>
			</div>
			<div class="col-sm-2">
				<select name="name" id="name" class="form-control">
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
		</div>
		<div class="col-sm-2">
			<input type="submit" value="LOGIN" class="btn btn-warning" />
		</div>
	</form>
</body>
</html>

