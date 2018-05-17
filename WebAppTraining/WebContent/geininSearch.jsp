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
			<jsp:include page="logo.jsp" />
		</div>




		<p class="text-right">
			<a href="menu.action">Back</a>
		</p>
		<br>
<div>
						<center>

						<br>
							<br>
							<br>






						<div>

<!-- お嫁さん探しのタイトル画像 -->
  <img src="assets/images/mainrogo.png" width="350">
</div>

						</center>




		</div>





		<div class="text-right">

			<s:property value="userId" />
			様
			<!--geininSearchAction.javaで生成したuserIdを画面に表示する -->

		</div>



<!--検索する枠-->
<!--最初にformを指定する。テキストスタイル的な。-->
		<s:form cssClass="form-horizontal">

<!--綺麗にまとめる。-->
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 名前: </label>
				<div class="col-md-8">
					<s:textfield name="name"  cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="number" class="col-sm-2 control-label"> 人数: </label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="number" value="number" list="numberMap"></s:select>
				</div>
			</div>
			<div class="form-group">
				<label for="sex" class="col-sm-2 control-label">性別：</label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="sex" value="sex"
						list="sexMap"></s:select>
				</div>
			</div>
			<div class="form-group">
				<label for="jimusho" class="col-sm-2 control-label">事務所：</label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="jimusho" value="jimusho"
						list="jimushoMap"></s:select>
				</div>
			</div>
			<div class="form-group">
				<label for="year" class="col-sm-2 control-label"> 結成年: </label>
				<div class="col-md-8">
					<s:textfield name="year"  cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="jenre" class="col-sm-2 control-label">ジャンル：</label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="jenre" value="jenre"
						list="jenreMap"></s:select>
				</div>
			</div>
			<br>

<!--検索とかのボタン-->
<center>
			<div class="form-group">
				<div class="col-md-offset-2 col-md-8">
					<s:submit type ="image" src="assets/images/temp/search.gif" method="search" value="検索"
						 />		<br>		<br>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-2 col-md-4">
					<s:submit type ="image" src="assets/images/temp/reset.gif" method="reset" value="リセット"
						 />
				</div>		<br>		<br>
				<div class="col-md-4">
					<s:submit type ="image" src="assets/images/temp/add.gif" method="update" value="追加"
					 />
				</div>
			</div>
			</center>
			<br>		<br>

			<div>
				<div class="message">
					<s:actionerror />
					<s:property value="message" />
				</div>
				<br>
				<s:if test="%{geininTable.size > 0}">
					<table class="table table-striped table-bordered">
						<thead>
							<!-- テーブルヘッダー -->
							<tr>
								<th>写真</th>
								<th>名前</th>
								<th>人数</th>
								<th>性別</th>
								<th>所属事務所</th>
								<th>結成年</th>
								<th>ジャンル</th>
								<th>ネタ動画</th>
								<th>代表作</th>
								<th>更新</th>
								<th>削除</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="geininTable">
								<tr>
									<td class="data" width="120">
										<img src="assets/images/geinin/<s:property value="image"/>" alt="NO IMAGE!" width="110" height="110"></td>
									<td class="data" width="60"><s:property value="name" /></td>
									<td class="data" width="75"><s:property value="number" /></td>
									<td class="data" width="60"><s:property value="sex" /></td>
									<td class="data" width="75"><s:property value="jimusho" /></td>
									<td class="data" width="169"><s:property value="year" /></td>
									<td class="data" width="169"><s:property value="jenre" /></td>
									<td class="data" width="75"><s:property value="work" /></td>
									<td class="data" width="169"><s:property value="movieUrl" /></td>


									<td><input type="button" name="updateBtn" id="update"
										value="更新" class="btn btn-warning"
										forUpdate="<s:property value ="id"/>" /></td>
									<td class="data" width="50"><input type="checkbox"
										name="delete" value=<s:property value="id"/>></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</s:if>
				<s:if test="%{geininTable.size > 0}">
					<div class="text-right">
						<div class="shake shake-chunk">
							<s:submit method="delete" value="さようなら▽" cssClass="btn btn-info" />
						</div>
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