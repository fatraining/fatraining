<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Webアプリ研修 | ネイル検索<s:property value="title" /></title>
	<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/assets/css/nailCss.css">
	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>




</head>
<body>
	<div id="global_header">
		<div class="page-header">
		<h1><a href="login.action">研修Webアプリ</a><small>verβ</small></h1>
		</div>
		<a href="menu.action" class="menu">メニューへ</a>
		<hr>
		<a href="menu.action" class="back">Back</a>
	</div>
	<div id="contents-wrapper">
	<h2>マイネイル検索</h2>
		<p class="err">
			<s:property value="errorMsg" />
		</p>
		<h3><s:property value="userId" />さん</h3>
		<div class="slidShow">
				<div class="flexslider">
				  <ul class="slides">
				    <li>
				      <img src="<s:url value="/assets/images/"/>Nail1.jpg" />
				    </li>
				    <li>
				      <img src="<s:url value="/assets/images/"/>Nail2.jpg" />
				    </li>

				  </ul>
				</div>
			</div>
		<div class="contents">

			<s:form>
				<div class="season_choose">
					<label for="seasonChoose" class="sub_title">季節：</label>
					<s:select class="pulldown" name="kisetuID" value="KisetuID" list="Kisetu"></s:select>
				</div>
				<div class="color_choose">
					<p class="sub_title" >メインカラー:<br></p>
					<s:checkbox lavel="colorCheckbox" name="color" fieldValue="%{'ピンク'}">ピンク</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="color" fieldValue="%{'レッド'}">レッド</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="color" fieldValue="%{'ブルー'}">ブルー</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="color" fieldValue="%{'グレー'}">グレー</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="color" fieldValue="%{'グリーン'}">グリーン</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="color" fieldValue="%{'ホワイト'}">ホワイト</s:checkbox>
					<s:checkbox lavel="colorCheckbox" name="color" fieldValue="%{'オレンジ'}">オレンジ</s:checkbox>

				</div>
				<div class="bottom">
					<s:submit class="search" method="search" value="検索" />
					<s:submit class="reset" method="reset" value="リセット" />
					<s:submit class="in_btn1" method="update" value="追加" />
				</div>

			<div id="SearchWindow">
				<span style="color: red">
					<s:property value="msg"/>
				</span>
				<s:if test="%{outputTable.size() > 0}">
						<table id="searchResult">
							<%--<thead>
								<tr>
									<th>No.</th>
									<th>施術日時</th>
									<th>季節</th>
									<th>メインカラー</th>
									<th>ハンドモデル</th>
									<th>写真</th>
									<th>コメント</th>
									<th>削除</th>
								</tr>
							</thead>--%>
							<tbody>

							<%-- ↓繰り返し --%>
							<s:iterator value="outputTable">
							<div class="tableContentWrapper">
								<p class="id">No.<s:property value="id" /></p>
								<p class="date">DATE：<s:property value="date" /></p>
								<p class="season"><s:property value="KisetuID" />ネイル</p>
								<a href="<s:url value="/assets/images/temp/"/><s:property value="imageFileName" />" rel="lightbox">
									<img class="imageWrapper" src="<s:url value="/assets/images/temp/"/><s:property value="imageFileName" />" />
								</a>
								<p class="model">Model：<s:property value="handmodel" /></p>
								<p class="comment"><s:property value="comment" /></p>
								<p class="delete">
									この情報を削除する
									<input type="checkbox" name="delete" value="<s:property value="id" />" />
								</p>

							</div>
							</s:iterator>
							<%--<s:iterator value="outputTable">
								<tr>
									<td class="data"><s:property value="id" /></td>
									<td class="data"><s:property value="date" /></td>
									<td class="data"><s:property value="KisetuID" /></td>
									<td class="data"><s:property value="maincolor" /></td>
									<td class="data"><s:property value="handmodel" /></td>

									<td class="data image"><img src="<s:url value="/assets/images/temp/"/><s:property value="imageFileName" />" /></td>
									<td class="data"><s:property value="comment" /></td>
									<td class="data">
										<input type="checkbox" name="delete" value="<s:property value="id" />" />
									</td>
								</tr>
							</s:iterator>--%>
							</tbody>
						</table>
				</s:if>
				<s:if test="%{outputTable.size>0}">
					<div class="d-Btn">
						<s:submit method="delete" id="deleteBtn" class="deleteBtn" value="削除" />
					</div>
				</s:if>
			</div>

	</s:form>
		</div>
	</div>

<script language="javascript" type="text/javascript" src="<%= request.getContextPath() %>/assets/js/lightbox.js"></script>
<script language="javascript" type="text/javascript" src="<%= request.getContextPath() %>/assets/js/jquery.flexslider.js"></script>
<script>
$(window).load(function() {
	  $('.flexslider').flexslider({
	    animation: "slide"
	  });
	});
</script>
</body>
</html>