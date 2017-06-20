<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" ></script>
<script src="assets/js/jquery.bxslider.min.js" ></script>
<script type="text/javascript">
        $(document).ready(function(){
            $('.bxslider').bxSlider({
                auto: true,
            });
        });
</script>
<link href="assets/css/event.css" rel="stylesheet" />
</head>
<body>
<DIV id="Header_area" >
	<div class="container">
		<h2><a href="login.action" title="ログイン画面に戻る">研修Webアプリ</a><small>ver β
		<a href="menu.action" title="メニューに戻る">＜リリイベ会場検索＞</a>
		<small>～イベントスペースが検索できます～</small></small></h2>
	</div>
</DIV>


		<div class="text-center">
		<ul class="bxslider">
		  <li><a href="http://yokohama.lalaport.jp/">
		 		 <img title="ららぽーと横浜　セントラルガーデン" alt="" src="assets/images/event/011.png" width="100%" height="auto" /></a></li>
		  <li><a href="http://www.lazona-kawasaki.com/">
		  		<img title="ラゾーナ川崎　ルーファ広場" alt="" src="assets/images/event/02.png" width="100%" height="auto" /></a></li>
		  <li><a href="http://www.lalaport-tachikawatachihi.com/">
		  		<img title="ららぽーと立川立飛　イベント広場" alt="" src="assets/images/event/03.png" width="100%" height="auto" /></a></li>
		  <li><a href="http://www.sunshinecity.co.jp/">
		  		<img title="池袋サンシャインシティ　噴水広場" alt="" src="assets/images/event/04.png" width="100%" height="auto" /></a></li>
		  <li><a href="http://toyosu.lalaport.jp/">
		  		<img title="ららぽーと豊洲　シーサイドデッキ" alt="" src="assets/images/event/05.png" width="100%" height="auto" ></a></li>
		  <li><a href="http://www.lalaport-shinmisato.com/">
		  		<img title="ららぽーと新三郷　ガーデンステージ" alt="" src="assets/images/event/06.png" width="100%" height="auto" ></a></li>
		  <li><a href="http://www.divercity-tokyo.com/">
		  		<img title="ダイバーシティ東京　フェスティバル広場" alt="" src="assets/images/event/07.jpg" width="100%" height="auto" ></a></li>
		  <li><a href="https://www.venusfort.co.jp/">
		  		<img title="ヴィーナスフォート　教会広場" alt="" src="assets/images/event/08.jpg" width="100%" height="auto" ></a></li>
		   <li><a href="http://www.ikspiari.com/index.html">
		  		<img title="イクスピアリ　セレブレーション・プラザ" alt="" src="assets/images/event/11.jpg" width="100%" height="auto" ></a></li>
		</ul>
		</div>




<s:form cssClass="form-horizontal">
<div class="container">

<%-- メッセージ--------------------------- --%>
		<div class="form-group">
			<label for="ID" class="col-sm-1 control-label"></label>
			<div class="col-md-8">
			<div class="message" style="color: red"><s:actionerror /><s:property value="message" /></div>
			</div>
		</div>
<%-- -------------------------------------------- --%>

<%-- ID表示--------------------------------------
		<div class="form-group">
			<label for="ID" class="col-sm-2 control-label"></label>
			<div class="col-md-8" style="text-align:right">
				<b><s:property value="userId" /><small>さん</small></b>
			</div>
		</div>
<%-- -------------------------------------------- --%>


		<div class="form-group">
			<label for="area" class="col-sm-2 control-label">エリア：</label>
			<div class="col-md-8">
				<s:select cssClass="form-control" name="area" value="area"	 list="eventAreaMap"  title="エリアを選択して下さい"/>
			</div>
		</div>

		<div class="form-group">
			<label for="record" class="col-sm-2 control-label">レコード店：</label>
			<div class="col-md-8">
				<s:select cssClass="form-control" name="record" value="record"	list="recordMap"  title="レコード店を選択して下さい"/>
			</div>
		</div>

		<div class="form-group">
			<label for="name" class="col-sm-2 control-label">会場名称：</label>
			<div class="col-md-8">
				<s:textfield name="name" cssClass="form-control"  placeholder="部分一致検索ができます"/>
			</div>
		</div>

	<div class="form-group">
		<div class="col-md-offset-2 col-md-4">
		<s:submit title="検索します" method="search" value="検索"
			cssClass="form-control btn btn-info" />
		</div>
		<div class=" col-md-2">
		<s:submit title="リセットします" method="reset" value="リセット"
				cssClass="form-control btn btn-warning" />
		</div>
		<div class="col-md-2">
		<s:submit title="データを追加します" method="update" value="追加"
			cssClass="form-control btn btn-success" />
		</div>
	</div>



	<s:if test="%{eventStageTable.size!=0}">
	<br>
	<br>
<div align="right">
	<b>ＨＭＶ：</b><img  src="assets/images/event/hmv.gif" width="auto" height="30px" />
	<b>ＴＷ：</b><img  src="assets/images/event/tw.gif" width="auto" height="30px" />
	<b>ＳＮ：</b><img  src="assets/images/event/sn.png" width="auto" height="30px" />
</div>
		<table id="eventStage" class="table">
			<thead>
				<tr style="background-color:#CAE9FF">
					<th>エリア</th>
					<th>会場名称</th>
					<th>最寄駅</th>
					<th>店舗</th>
					<th>コメント</th>
					<th><div class="text-center">更新</div></th>
					<th>削除</th>

			</thead>
			<tbody>



				<s:iterator value="eventStageTable">
					<tr >
						<td class="data" width="65"><div class="text-center"><s:property value="area" /></div></td>
						<td class="data" width="165"><strong><s:property value="name" /></strong></td>
						<td class="data" width="75"><s:property value="station" /></td>
						<td class="data" width="60"><div class="text-center"><s:property value="record" /></div></td>
						<td class="data"><s:property value="comment" /></td>

						<td><input title="データを更新します" type="button" name="updateBtn" id = "update" value="更新"
							class="btn btn-default btn-sm" forUpdate="<s:property value ="ID"/>"  title="情報を更新します"/></td>

						<td class="data" width="45"><div class="text-center"><input type="checkbox" name="delete"
							value=<s:property value="ID"/>></div></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:if test="%{eventStageTable.size != 0}">
			<div align=right style="padding-bottom: 80px;">
				<s:submit title="チェックのついたデータを削除します" method="delete"  value="削除" cssClass="btn btn-danger" />
			</div>
		</s:if>
	</s:if>
</div> <!--** contaner ** -->
</s:form>


	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/event.js" />"></script>

</body>
</html>