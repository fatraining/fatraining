<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="Windows-31J"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"/>

<head>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/tablesorter-blue/style.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/riderSearch.css"/>"/>
	<script type="text/javascript" src="<s:url value="/assets/js/jquery.tubular.1.0.js"/>"></script>
	<script type="text/javascript" src="<s:url value="/assets/js/riderSearch.js"/>"></script>
</head>
<style>
	#wrapper{
	position: relative;
	width: 100%;
	height: 100%;
	background: url(assets/images/07.png);
	}
</style>
<body>
	<!-- formで全体を囲むことで、値の受け渡しを行えるようになる -->
	<s:form>
	<div id="wrapper">
		<div class="container">
			<jsp:include page="logo.jsp"/>
			<p class="text-right">
				<a href="menu.action" >Back</a>
			</p>
			<br>
			<h1 class="h3 text left" id="header">
			<a href="riderSearch.action">MotoGP Rider Search<br/>-2016-</a></h1>

			<div class="text-right" style="color:white">
				<s:property value="UserID"/>さん
			</div>
			<!-- 時計 -->
			<div id="clock-02" class="text-center"></div>

			<div class="form-group">
				<!-- rowはコンテンツをまとめるもの -->
				<div class="row">

					<!-- メッセージの表示 -->
					<div class="err"style="color:red">
						<s:actionerror />
						<s:property value="msg"/>
					</div>

					<!-- col-md-4はBootstrapの機能
					     col=カラムで、12分割してあるカラムのうちの何個分使うかを指定できる。
					     mdは大きさで、sm、lgもある。 -->
					<div class="col-md-4">
						<div class="numText">
							<label for="Number"style="color:white">Number:</label>
								<s:textfield name="number" cssClass="form-control" placeholder="ゼッケンナンバー" />
						</div>
					</div>

					<div class="teamName">
						<div class="col-md-8">
							<label for="teamName" style="color:white">チーム：</label>
								<s:textfield name="teamName" cssClass="form-control" placeholder="引退してる人はRetirement"/>
						</div>
					</div>

					<div class="riderName">
						<div class="col-md-12">
							<label for="riderName" style="color:white">ライダー名：</label>
								<s:textfield name="riderName" cssClass="form-control" placeholder="アルファベットで入力"/>
						</div>
					</div>
				</div>
			</div>


			<div class="search">
				<div class="row">
					<div class="col-md-12">

						<!-- ボタンの色はbtn btn-のあとの文字によって変わる -->
						<s:submit method="search" value="検索" cssClass="btn btn-primary btn-block" />
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<s:submit method="reset" value="リセット" cssClass="btn btn-success btn-block"/>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<s:submit method="update" value="追加" cssClass="btn btn-danger btn-block"/>
					</div>
				</div>
			</div>

				<!-- if文。テーブルを表示する。検索結果が何もないとき以外はとりあえずでる。 -->
				<s:if test="%{outputTable.size() > 0}">
					<table class="tablesorter" id=rider>
						<thead>
							<!-- trは列を作る -->
							<tr><!-- thは列の見出し -->
								<th>Number</th>
								<th>チーム</th>
								<th>名前</th>
								<th>国籍</th>
								<th>年齢</th>
								<th>誕生日</th>
								<th>コメント</th>
								<th>削除</th>
							</tr>
						</thead>
						<tbody>
							<!-- 値の取得と表示。iteratorはJsp内での繰り返し処理のこと
							     outputTableを取得し、ある分だけ値を割り振って表示させる。
							     ある分だけやるから繰り返さないとダメ。 -->
							<s:iterator value="outputTable">
								<tr>
									<td class="data"><s:property value="Number"/></td>
									<td class="data"><s:property value="TeamName"/></td>
									<td class="data"><s:property value="RiderName"/></td>
									<td class="data"><s:property value="Country"/></td>
									<td class="data"><s:property value="Age"/></td>
									<td class="data"><s:property value="BirthDay"/></td>
									<td class="data"><s:property value="Comment"/></td>
									<!--↓チェックボックスに割り当てられている値 -->
									<td class="data"><input type="checkbox" name="delete"
										value="<s:property value="ID"/>
										:<s:property value="TeamName"/>
										:<s:property value="RiderName"/>"/>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</s:if>
				<!-- 削除ボタンの設定 -->
				<s:if test="%{outputTable.size>0}">
					<!-- 右側に出す -->
					<div align=right>
						<s:submit method="delete"
						id="deleteBtn"
							value="削除"
							cssClass="btn btn-danger"
						/>
					</div>
				</s:if>
		</div>
		</div>
	</s:form>



</body>
</html>