<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"/>
<head>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/tablesorter-blue/style.css"/>"/>
	<!-- ↓cssスタイルシートとjQueryの読み込み。別に書かなくてもBootstrapがheader.jspで既に読み込まれているから平気 -->
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/riderSearch.css"/>"/>
	<!-- ↓動画を再生させるためのやつ -->
	<script type="text/javascript" src="<s:url value="/assets/js/jquery.tubular.1.0.js"/>"></script>
	<script type="text/javascript" src="<s:url value="/assets/js/updateRider.js"/>"></script>

	<style>
	#wrapper{
	position: relative;
	width: 100%;
	height: 100%;
	background: url(assets/images/07.png);
	}

	#delete{
	font-size: 25px;
	}
	.h3{
	font-size: 40px;
	}
	.row{

	}

	</style>

</head>
<body>
	<div id="wrapper">
	<s:form>
		<div class="container">
			<div id="top">
				<jsp:include page="/logo.jsp"/>
				<p class="text-right">
					<a href="riderSearch.action">Back</a>
				</p>
				<br>
				<h1 class="h3 text left" id="header">
				<a href="riderSearch.action">MotoGPライダー検索<br/>-2016年版-</a></h1>
			</div>

			<!-- チェックボックスに印がない場合 -->
			<div id="submit">
				<s:if test="%{delete==null}">
					<h3 class="h3 text left" id="header">新しくライダーを追加します</h3>
					<div style="color:red">
						<s:actionerror class="err"/>
					</div>

					<div class="form-group">
						<div class="row">
							<div class="col-md-4">
								<label for="Number" style="color:white">Number:</label>
									<s:textfield name="number" cssClass="form-control" placeholder="ゼッケンナンバー"/>
							</div>
							<div class="col-md-8">
								<label for="teamName" style="color:white">チーム名:</label>
									<s:select cssClass="form-control" name="teamId" list="teamName" />
							</div>
							<div class="col-md-12">
								<label for="RiderName" style="color:white">ライダー名:</label>
									<s:textfield name="riderName" cssClass="form-control" placeholder="ライダー名"/>
							</div>
							<div class="col-md-3">
								<label for="Country" style="color:white">国籍:</label>
									<s:textfield name="country" cssClass="form-control" placeholder="国コード3文字"/>
							</div>
							<div class="col-md-3">
								<label for="Age" style="color:white">年齢:</label>
									<s:textfield name="age" cssClass="form-control" placeholder="年齢"/>
							</div>
							<div class="col-md-5">
								<label for="BirthDay" style="color:white">誕生日:</label>
									<s:textfield name="birthDay" cssClass="form-control" placeholder="誕生日"/>
							</div>
							<div class="col-lg-12">
								<label for="Comment" style="color:white">コメント:</label>
									<s:textfield name="comment" cssClass="form-control" placeholder="コメント(なければなし)"/>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div align=right>
							<s:submit method="insert" value="追加する" cssClass="btn btn-primary"/>
						</div>
					</div>
				</s:if>
			</div>

			<div id="delete">
				<s:if test="%{delete!=null}">
					<h3 class="h3 text left" id="header">削除しますか？(´･ω･｀)</h3>
					<div class="form-horizontal">
						<div class="showData" style="color:white">
							削除する人:
							<s:property value="delete" />
						</div>
						<div id="deleteBtn">
							<s:submit method="delete" value="削除" cssClass="btn btn-danger" onclick="alert('削除します。よろしいですか？')"/>
						</div>
					</div>
				</s:if>
			</div>
		</div>
	</s:form>
	</div>
</body>
</html>