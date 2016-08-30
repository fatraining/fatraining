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
	href="<s:url value="/assets/css/maiwaifu.css"/>" />
<!-- ふるえるcss -->
<link rel="stylesheet" type="text/css"
	href="http://csshake.surge.sh/csshake.min.css">


</head>

<body>
<!-- 音楽流す -->
	<audio sourse>
		src="<s:url value="/assets/images/temp/towanitomoni.mp3"/><s:property value="towanitomoni.mp3" />"
		autoplay loop></audio>


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
  <img src="assets/images/mainrogo.png" width="350">
</div>

						</center>

				<center>
					<img src="assets/images/flowergirl.gif" border="0" width="300"
			 onmouseover="width=402; this.src='assets/images/temp/flowergirl_a.gif'"
			 onmouseout="width=300; this.src='assets/images/flowergirl.gif'">
</center>



		</div>


			</ul>




		<div class="text-right">

			<s:property value="userId" />
			様
			<!--MaiwaifuSearchAction.javaで生成したuserIdを画面に表示する -->

		</div>



<!--検索する枠-->
<!--最初にformを指定する。テキストスタイル的な。-->
		<s:form cssClass="form-horizontal">

<!--綺麗にまとめる。-->
			<div class="form-group">
				<label for="area" class="col-sm-2 control-label">生息地：</label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="area" value="area"
						list="maiwaifuAreaMap"></s:select>
				</div>
			</div>
			<!--<div class="form-group">
				<label for="image" class="col-sm-2 control-label"> 写真: </label>
				<div class="col-md-8">
					<s:textfield name="image" cssClass="form-control" />
				</div>
			</div>-->
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 名前: </label>
				<div class="col-md-8">
					<s:textfield name="name"  cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="genre" class="col-sm-2 control-label"> ジャンル: </label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="genre" value="genre" list="genreMap"></s:select>
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
				<s:if test="%{maiwaifuTable.size> 0}">
					<table class="table table-striped table-bordered">
						<thead>
							<!-- テーブルヘッダー -->
							<tr>
								<th>生息地</th>
								<th>写真</th>
								<th>名前</th>
								<th>ジャンル</th>
								<th>年齢</th>
								<th>コメント</th>
								<th>更新</th>
								<th>削除</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="maiwaifuTable">
								<tr>
									<td class="data" width="60"><s:property value="area" /></td>
									<td class="data" width="120"><img
										src="<s:property value="image"/>" alt="NO IMAGE!" width="110"
										height="110"></td>

									<td class="data" width="75"><s:property value="name" /></td>
									<td class="data" width="60"><s:property value="genre" /></td>
									<td class="data" width="75"><s:property value="age" /></td>
									<td class="data" width="169"><s:property value="comment" /></td>
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
				<s:if test="%{maiwaifuTable.size>0}">
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
		src="<s:url value="/assets/js/mori.js" />"></script>
</body>