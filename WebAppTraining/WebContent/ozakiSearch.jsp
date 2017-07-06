<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<!-- ヘッダー -->
<head>
<jsp:include page="header.jsp" />
</head>
<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/ozaki.css"/>" />

<body class="container">
	<!-- 研修アプリverβ -->
	<div class="text-center">
		<jsp:include page="logo.jsp"></jsp:include>
	</div>

	<!-- タイトル -->

	<div class="text-center">
		<h1>尾崎豊 曲検索</h1>
	</div>


	<div id="ozaki" class="carousel slide center-block"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#ozaki" data-slide-to="0" class="active"></li>
			<li data-target="#ozaki" data-slide-to="1"></li>
			<li data-target="#ozaki" data-slide-to="2"></li>
			<li data-target="#ozaki" data-slide-to="3"></li>
			<li data-target="#ozaki" data-slide-to="4"></li>
			<li data-target="#ozaki" data-slide-to="5"></li>
			<li data-target="#ozaki" data-slide-to="6"></li>
		</ol>

		<div class="carousel-inner" align="center">
			<div class="item active">
				<img src="assets/images/ozaki/ozaki_0.jpg" width="500px"
					height="500px">
			</div>
			<div class="item">
				<img src="assets/images/ozaki/ozaki_1.jpg" width="500px"
					height="500px">
			</div>
			<div class="item">
				<img src="assets/images/ozaki/ozaki_2.jpg" width="500px"
					height="500px">
			</div>
			<div class="item">
				<img src="assets/images/ozaki/ozaki_3.jpg" width="500px"
					height="500px">
			</div>
			<div class="item">
				<img src="assets/images/ozaki/ozaki_4.jpg" width="500px"
					height="500px">
			</div>
			<div class="item">
				<img src="assets/images/ozaki/ozaki_5.jpg" width="500px"
					height="500px">
			</div>
			<div class="item">
				<img src="assets/images/ozaki/ozaki_6.jpg" width="500px"
					height="500px">
			</div>
		</div>

		<a class="carousel-control left" href="#ozaki" data-slide="prev">
			<span class="glyphicon glyphicon-chevron-left"></span>
		</a> <a class="carousel-control right" href="#ozaki" data-slide="next">
			<span class="glyphicon glyphicon-chevron-right"></span>
		</a>
	</div>


	<!-- 登録ユーザーID 戻る-->
	<div class="text-right">
		<s:property value="userId" />
		さん <a href="menu.action">戻る</a>
	</div>
	<br />

	<!-- 削除・更新・追加メッセージの表示 -->
	<s:if test="%{hasCompleteMessage}">
		<div class="alert alert-success alert-dismissible">
			<button class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<s:property value="completeMessage" />
		</div>
	</s:if>

	<!-- 検索画面 -->
	<s:form cssClass="form-horizontal">
		<div class="form-group">
			<label class="col-sm-3 control-label"> アルバム </label>
			<div class="col-sm-6">
				<s:select cssClass="form-control" name="albumName" list="albumMap"></s:select>
			</div>
		</div>
		<br />

		<div class="form-group">
			<label class="col-sm-3 control-label"> 曲名 </label>
			<div class="col-sm-6">
				<s:textfield cssClass="form-control" name="songName"
					placeholder="部分一致検索（ 例：I LOVE YOU ）"></s:textfield>
			</div>
		</div>
		<br />

		<div class="form-group">
			<div class="col-md-offset-3 col-sm-2">
				<s:submit method="search" value="検索"
					cssClass="btn btn-primary btn-block" />
			</div>

			<div class="col-sm-2">
				<s:submit method="reset" value="リセット"
					cssClass="btn btn-primary btn-block" />
			</div>

			<div class="col-sm-2">
				<s:submit method="update" value="追加"
					cssClass="btn btn-primary btn-block" />
			</div>
		</div>
		<br />

		<!-- エラーメッセージの表示 -->
		<s:if test="%{hasActionErrors}">
			<div class="alert alert-danger" style="list-style: none">
				<s:actionerror />
			</div>
		</s:if>

		<!-- 検索結果テーブル -->
		<div class="show">
			<s:if test="%{ozakiTable.size!= 0}">
				<table class="table table-striped table-bordered table-hover">
					<!-- テーブルヘッダー -->
					<thead>
						<tr>
							<th>アルバム名</th>
							<th>曲名</th>
							<th>作詞・作曲</th>
							<th>年代</th>
							<th>歌詞</th>
							<th>更新</th>
							<th>削除</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="ozakiTable">
							<tr>
								<td class="data" width="90"><s:property value="albumName" /></td>
								<td class="data" width="120"><s:property value="songName" /></td>
								<td class="data" width="100"><s:property
										value="songWriting" /></td>
								<td class="data" width="80"><s:property value="age" /></td>
								<td class="data" width="140"><s:property value="lyrics" /></td>
								<td class="data" width="10"><input type="button"
									name="updateBtn" id="updateId" value="更新" class="btn btn-info"
									forUpdate="<s:property value ="id"/>" /></td>
								<td class="data" width="5"><input type="checkbox"
									name="delete" value=<s:property value="id"/>></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
			<s:if test="%{ozakiTable.size!= 0}">
				<div class="text-right">
					<p>削除する場合削除ボタンを押してください</p>
					<s:submit method="delete" value="削除" cssClass="btn btn-danger"></s:submit>
				</div>
			</s:if>

		</div>
	</s:form>
	<script type="text/javascript"
		src="<s:url value="/assets/js/ozaki.js"/>"></script>
</body>
</html>