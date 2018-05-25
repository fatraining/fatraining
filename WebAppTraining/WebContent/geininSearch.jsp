<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--単一タグ。機能のカプセル化タグ名がｓで属性名がuri。-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/geinin.css"/>" />

</head>

<body>


	<div class="container">

		<div class="text-center">
		<!-- 研修アプリVer.β -->
			<jsp:include page="logo.jsp" />
		</div>


		<div class="text-right">
<!-- Back、USERID -->
		<h3><a href="menu.action">Back</a></h3>
	 	<s:property value="userId" />
			様

		</div>

<br>

	<!-- 削除・更新・追加完了メッセージの表示 -->

	<s:if test="%{!message.isEmpty()}">
		<div class="alert alert-success alert-dismissible">
			<s:property value="message" />
		</div>
	</s:if>

<div>

	<h1>若手芸人検索</h1>
	<a href="http://www.mygrffon.com/entry/2017/07/30/090058" target="_blank">
		<img src="assets/images/geinin/top.png" alt="NO IMAGE!" width="300">
	</a>

</div>
<br>
<br>
背景画像：<a href="https://twitter.com/inde_naito" target="_blank">インデペンデンスデイ内藤</a>が描いた
「<a href="http://www.kdashstage.jp/profile/archives/4" target="_blank">ヤーレンズ</a>」の
<a href="https://matome.naver.jp/odai/2149481948995296101" target="_blank">要素アート</a>
<br>
<br>
<br>



<!--検索する枠-->
<!--最初にformを指定する。テキストスタイル的な。-->
<s:form cssClass="form-horizontal">

<!--入力欄-->
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 名前: </label>
				<div class="col-md-8">
					<s:textfield name="name"  cssClass="form-control" />
				</div>
			</div>
			<br>

<!--検索とかのボタン-->
			<div class="search">
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<s:submit method="search" value="検索"
							cssClass="btn btn-default btn-block" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<s:submit method="reset" value="リセット"
							cssClass="btn btn-danger btn-block" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-md-offset-4">
						<s:submit method="update" value="新規データ追加"
							cssClass="btn btn-warning btn-block" />
					</div>
				</div>
			</div>

			<br>
			<br>



			<div>
			<!-- 	<div class="message">
					<s:actionerror />
					<s:property value="message" />
				</div> -->
				<br>
				<s:if test="%{geininList.size > 0}">
					<table class="table table-hover table-bordered">
						<thead>
							<!-- テーブルヘッダー -->
							<tr>
								<th>写真</th>
								<th>名前</th>
								<th>代表ネタ</th>
								<th>更新</th>
								<th>削除</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="geininList">
								<tr>
									<td class="data" width="210">
										<img src="assets/images/geinin/<s:property value="image"/>" alt="NO IMAGE!" width="200"></td>
									<td class="data" width="150"><s:property value="name" /></td>
									<td class="data"><s:property value="work" /></td>

									<td width="100">
									<!--
									<div class="col-md-2">
										<input type="hidden" name="updateId" <s:property value="id"/> >
										<s:submit method="update" value="データ更新"
											cssClass="btn btn-warning" />
									</div>

									<form method="update">
									<input type="hidden" name="updateId" <s:property value="id"/> >
									<input type="button" name="updateBtn" value="更新" class="btn btn-warning">
									</form>

									 <input type="hidden" name="updateId" id="updateId" <s:property value="id" /> >
									 forUpdate="<s:property value ="id"/>"
									 -->

									 <input type="button" name="updateBtn" value="データ更新" class="btn btn-warning"
									 forUpdate="<s:property value ="id"/>" />

									</td>
									<td class="data" width="50"><input type="checkbox"
										name="delete" value=<s:property value="id"/>></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
			 </s:if>
				<s:if test="%{geininList.size > 0}">
					<div class="text-right">
						<s:submit method="delete" value="チェックしたデータを削除する" cssClass="btn btn-info" />
					</div>
					<br>
				</s:if>
			</div>

 	</s:form>
	</div>

	<!-- javascript -->
 	<script type="text/javascript"
		src="<s:url value="/assets/js/ariyoshi.js" />"></script>
</body>
</html>