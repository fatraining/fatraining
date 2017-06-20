<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<link href="assets/css/event.css" rel="stylesheet" />
</head>
<body>
<DIV id="Header_area" >
	<div class="container">
		<h2><a href="login.action" title="ログイン画面に戻る">研修Webアプリ</a><small>ver β
		<a href="eventStageSearch.action" title="検索画面に戻る">＜リリイベ会場検索＞</a></small></h2>
	</div>
</DIV>

<s:form class="form-horizontal">
<div class="container">

	<div class=text-center>
		<br>
		<br>
		<h4 class="split" style="color: red">選択されたデータを削除します。</h4>
		<h5 class="split" style="color: red">※この操作はもとに戻せません。</h5>
	</div>
	<br><br>
	<s:if test="%{eventStageTable.size!=0}">
		<div>
			<table id="eventStage" class="table">
			<thead>
				<tr style="background-color:#CAE9FF">
					<th>エリア</th>
					<th>会場名称</th>
					<th>最寄駅</th>
					<th>店舗</th>
					<th>コメント</th>
			</thead>
			<tbody>



				<s:iterator value="eventStageTable">
					<tr >
						<td class="data" width="65"><s:property value="area" /></td>
						<td class="data" width="170"><s:property value="name" /></td>
						<td class="data" width="75"><s:property value="station" /></td>
						<td class="data" width="60"><div class="text-center"><s:property value="record" /></div></td>
						<td class="data"><s:property value="comment" /></td>
					</tr>
				</s:iterator>
			</tbody>
			</table>
				<div class="text-right">
				<s:submit method="delete" value="本当に消しますか？"
					class="btn btn-danger" />
				</div>
		</div>
	</s:if>
</div>
</s:form>
</body>
</html>