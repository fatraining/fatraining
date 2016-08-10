<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/drama.css"/>" />


</head>

<body>
	<audio sourse
		src="<s:url value="/assets/images/temp/sugawara.mp3"/><s:property value="sugawara.mp3" />"
		autoplay loop></audio>
	<div class="snow">●</div>
	<div class="container">
		<div class="text-center">
			<jsp:include page="logo.jsp" />
		</div>
		<p class="text-right">
			<a href="menu.action">Back</a>
		</p>
		<br>
		<div class="text-center">
			<h1 class="shake-slow shake-constant shake-constant--hover">K-Drama★Search</h1>
		</div>
		<br>
		<div class="text-right">
			<s:property value="userId" />
			<!--DramaSearchAction.javaで生成したuserIdを画面に表示する -->
			さん
		</div>
		<br>
		<p class="errorMessage">
			<s:actionerror />
			<s:property value="message" />
		</p>
		<br>
		<center>
			<section id="sample12" class="section">
				<p>
					<a href="#"><img
						src="http://sokuneta.com/wp-content/uploads/2013/12/80-yonsama2.jpg" /></a>
				</p>
			</section>
		</center>
		<br> <br>
		<s:form cssClass="form-horizontal">
			<div class="form-group">
				<label for="genre" class="col-sm-2 control-label">ジャンル：</label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="genre" value="genre"
						list="dramaGenreMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 作品名: </label>
				<div class="col-md-8">
					<s:textfield name="name" cssClass="form-control"></s:textfield>
				</div>
			</div>
			<div class="form-group">
				<label for="cast" class="col-sm-2 control-label"> キャスト: </label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="cast" value="cast"
						list="castMap"></s:select>
				</div>
			</div>

			<br>

			<div class="submit">
				<div class="form-group" id="block01">
					<div class="col-md-5">
						<s:submit id="button" method="search" value="SEARCH"
							cssClass="btn btn-danger" />
					</div>
				</div>
				<div class="form-group" id="block02">
					<div class="col-md-5">
						<s:submit id="button" method="reset" value="RESET"
							cssClass="btn btn-danger" />
					</div>
				</div>
				<div class="form-group" id="block03">
					<div class="col-md-5">
						<s:submit id="button" method="update" value="ADD"
							cssClass="btn btn-danger" />
					</div>
				</div>
			</div>
			<br>

			<div>
				<s:if test="%{dramaTable.size> 0}">
					<table>
						<thead>
							<!-- テーブルヘッダー -->
							<tr>
								<th>ジャンル</th>
								<th>作品名</th>
								<th>キャスト</th>
								<th>放送局</th>
								<th>コメント</th>
								<th>更新</th>
								<th>削除</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="dramaTable">
								<tr>
									<td class="data" width="200" height="50"><s:property
											value="genre" /></td>
									<td class="data" width="300" height="50"><s:property
											value="name" /></td>
									<td class="data" width="200" height="50"><s:property
											value="cast" /></td>
									<td class="data" width="100" height="50"><s:property
											value="tvStation" /></td>
									<td class="data" width="450" height="50"><s:property
											value="comment" /></td>
									<td><input type="button" name="updateBtn" id="update"
										value="更新" class="btn btn-primary"
										forUpdate="<s:property value ="id"/>" /></td>
									<td class="data" width="70" align="center"><input
										type="checkbox" name="delete" value=<s:property value="id"/>></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</s:if>
				<br>
				<s:if test="%{dramaTable.size>0}">
					<div class="text-right">
						<div class="delete">
							<s:submit method="delete" value="削除" cssClass="btn btn-danger" />
						</div>
					</div>
					<br>
				</s:if>
			</div>
		</s:form>
	</div>

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/sugawara.js" />"></script>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

</body>
</html>