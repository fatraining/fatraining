<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Webアプリ研修 | データ新規登録 | ネイル検索<s:property value="title" /></title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/css/nailCss.css">
</head>
<body>
	<div id="global_header">
		<jsp:include page="/logo.jsp" />
		<a href="login.action" class="menu">メニューへ</a>
		<hr>
		<a href="nailSearch.action" class="back">Back</a>
	</div>
	<div id="contents-wrapper">
		<h2>データ新規登録</h2>
		<div style="color:red;">
		<s:actionerror class="err" />
		</div>
		<h3><s:property value="userId" />さん</h3>
	<div class="contents">
		<s:if test="%{delete==null}">
			<s:form method="post" enctype="multipart/form-data">

			<%--ここにsタグについての宣言をすべてまとめる--%>
				<div class="day_input">
					<p class="sub_title" >施術日時:<br></p>
					<s:textfield name="date" class="form-control" rows="51"
					maxlength="50" placeholder="yyyy/mm/dd" />
				</div>


				<div class="season_choose">
					<label for="seasonChoose" class="sub_title">季節：<br></label>
					<s:select class="pulldownUp" name="KisetuID" value="KisetuID" list="Kisetu"></s:select>
				</div>

				<div class="color_choose">
					<p class="sub_title" >メインカラー:<br></p>
					<s:checkbox lavel="colorCheckbox" name="maincolor" fieldValue="%{'ピンク'}">ピンク</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="maincolor" fieldValue="%{'レッド'}">レッド</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="maincolor" fieldValue="%{'ブルー'}">ブルー</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="maincolor" fieldValue="%{'グレー'}">グレー</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="maincolor" fieldValue="%{'グリーン'}">グリーン</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="maincolor" fieldValue="%{'ホワイト'}">ホワイト</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="maincolor" fieldValue="%{'オレンジ'}">オレンジ</s:checkbox>

				</div>
				<div class="model_input">
					<p class="sub_title" >ハンドモデル:<br></p>
					<s:textfield class="handmodel" name="handmodel" maxlength="50"></s:textfield>
				</div>
				<%-- <div class="upload">
					<p class="sub_title" >画像アップロード:<br></p>
						<input type="file" name="myfile" />
				</div>
						--%>

				<div class="upImage">
				<p class="sub_title" >画像アップロード:<br></p>
				<s:file id="customUpload" name="image" label="参照" class="file-upload"/>

				</div>


				<div class="comment_Field">
					<p class="sub_title" >コメント:<br></p>
					<s:textarea class="commentField" name="comment" maxlength="300"></s:textarea>
				</div>
				<div class="bottom2">
					<s:submit class="insert_btn" method="insert" value="追加" />
				</div>
			</s:form>
		</s:if>

		<s:if test="%{delete!=null}">
			<h3>選んだデータを削除します</h3>
			<td class="data">削除データ：<s:property value="delete" /></td>
			<s:form>
				<s:submit method="delete" value="削除" />
				<a href="nailSearch.action">Back</a>
			</s:form>
		</s:if>


		</div>
	</div>
</body>
</html>