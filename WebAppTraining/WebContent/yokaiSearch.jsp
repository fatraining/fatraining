

<!-- ページ設定 -->


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<!-- カプセル化 -->
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- メインメニューの設定 -->
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/yokai1.css" />" />
</head>

<body>

<!-- メニューに移行 -->
	<div class="back">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
			<p class="text-right">
				<a href="menu.action">Back</a>
			</p>
			<br>
               </div>


                                        <!-- 目玉のおやじが走る -->
                    <Marquee scrollamount="25" truespeed direction="right">
                         <img src="assets/images/temp/oyazi.png" alt="サンプル"></Marquee>

<!--＜ｈ２＞背景の帯 -->
<h2>
                                        <!-- タイトル -->
				<marquee behavior="alternate" direction="up" height="100"><marquee direction="right">
				<font face="HG行書体" size="10" color=#FF0000>&nbsp;&nbsp;妖怪を探せ&nbsp;&nbsp;</font></marquee></marquee>

</h2>
<!--豚野郎の表示 -->
			<br>
			<div class="text-right">
				<s:property value="userId" />
				<%--YokaiSearchAction.javaで生成したuserIdを画面に表示する --%>
				さん
			</div>
			<br>

			<s:form cssClass="form-horizontal"><!-- formにまとめる -->

			<font face="HG行書体"><!-- フォントの設定をHP行書体に設定 -->
				<div class="form-group ">
				<!-- col-sm(small)タブレット用に設定 -->
					<label for="yokaifrom" class="col-sm-2 control-label"><font size="5" color=#800080>生息地：</font></label>
					<div class="col-md-4"><!-- col-md(miduam)デスクトップ用に設定 -->
						<s:select cssClass="form-control" name="yokaifrom" value="yokaifrom"
							list="yokaifromMap"></s:select>
					</div>
				</div>

				<div class="form-group">
					<label for="name" class="col-sm-2 control-label"><font size="5" color=#000080>妖怪の名前：</font> </label>
					<div class="col-md-4">
						<s:textfield name="name" cssClass="form-control"
							placeholder="妖怪の名前を入力" />
								<p class="help-block">※日本語で入力してください。</p>
					</div>
				</div>
				<div class="form-group">
					<label for="type" class="col-sm-2 control-label"> <font size="5" color=#008000>特徴：</font> </label>
					<div class="col-md-4">
						<s:select cssClass="form-control" name="type" list="typeMap"></s:select>
					</div>
				</div>

				<!-- ボタンの設定 -->
				<div class="submit">
					<div class="form-group">
						<div class="text-center">
							<div class="btn-group">
								<s:submit type="image" src="assets/images/temp/yokai2.JPG" method="search" value="探す"
									cssClass="btn btn-primary btn-lg" />                  <!-- サーチアクションのサーチへ -->
								<s:submit type="image" src="assets/images/temp/yokai1.JPG" method="reset" value="リセット"
									cssClass="btn btn-success btn-lg" />                 <!-- サーチアクションのリセットへ -->
								<s:submit type="image" src="assets/images/temp/yokai3.JPG" method="update" value="増やす"
									cssClass="btn btn-danger btn-lg" />                 <!-- アップデートアクションへ -->
							</div>
						</div>
					</div>
				</div>
				<!-- エラーメッセージの表示 -->
					<div style="color: red; padding-left: 5%">
						<s:actionerror />
						<s:property value="message" />
					</div>


				<!-- テーブルの表示 -->
					<s:if test="%{yokaiTable.size> 0}">
						<table class="table table-bordered">
							<thead>
								<%-- テーブルヘッダー --%>
								<tr>
									<th class="per-12 center"><font  color=#800080>生息地</font> </th>
									<th><font  color=#000080>妖怪の名前</font></th>
									<th><font  color=#008000>特徴</font></th>
									<th><font  color=#FF00FF>コメント</font></th>
									<th><font  color=#0000CD>紹介画像URL</font></th>
									<th><font  color=#CD853F>更新</font></th>
									<th><font  color=#FF0000>成仏</font></th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="yokaiTable">
									<tr>
										<td class="data" width="60"><s:property value="yokaifrom" /></td>
										<td class="data" width="100"><s:property value="name" /></td>
										<td class="data" width="60"><s:property value="type" /></td>
										<td class="data"><s:property value="comment" /></td>
										<td><input type="button" name="movie"
											onclick="window.open('<s:property value ="link"/>')"
											value="紹介画像URL" class="btn btn-primary btn-sm" /></td>
										<td><input type="button" name="updateBtn" value="更新"
											class="btn btn-info" forUpdate="<s:property value ="id"/>" /></td>
										<td class="data" width="50"><input type="checkbox"
											name="delete" value=<s:property value="id"/>></td>

								</tr>
								</s:iterator>
							</tbody>
						</table>
					</s:if>
					<s:if test="%{yokaiTable.size>0}">
						<div class="text-right">
							<s:submit method="delete" value="成仏"
								cssClass="btn btn-danger btn-lg" />

						</div>
						<br>
					</s:if>
				</div>
			</s:form>
		</div>
		<div>
		<script type="text/javascript"
			src="<s:url value="/assets/js/yokai.js" />"></script>
	</div>
</body>
</html>
