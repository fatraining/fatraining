
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<jsp:include page="/header.jsp" />
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/bootswatch-paper.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/libs/raty/jquery.raty.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/harasan.css"/>"/>
	<body>
		<jsp:include page="/logo.jsp" />

		<div class="sub-header">
			<s:property value="title" />
			<p class="text-right">
				<s:property value="userId" /> さん
				<a href="menu.action">Back</a>
			</p>
		</div>

		<div class="container">
			<p class="err text-right">
				<s:actionerror class="err"/>
			</p>
			<div class="search-menu col-xs-12 col-sm-12 col-md-3 col-lg-3">
				<span style="color: red">
					<s:property value="errorMsg"/>
				</span>
				<s:form cssClass="form-horizontal" id="searchCondition">
				<div class="form-group">
					<label for="name" class="control-label">店舗名:</label>
					<s:textfield name="name" cssClass="form-control" placeholder="店舗名がわかってるなら入れればいいじゃない"/>
				</div>
				<div class="form-group">
					<label for="stars" class="control-label"> 評価(クリックで確定、ダブルクリックで取消):</label>
					<div class="stars" value="<s:property value="stars"/>"></div>
				</div>
				<div class="form-group">
					<label for="area" class="control-label">エリア:</label>
					<s:select name="area" value="area" list="areaMap" cssClass="form-control select"/>
				</div>
				<div class="btn-group btn-group-justified">
					<s:submit method="search" value="検索" cssClass="btn btn-default" />
					<s:submit method="reset" value="リセット" cssClass="btn btn-danger" />
					<s:submit method="update" value="追加" cssClass="btn btn-primary" />
				</div>
				<!-- <button type="button" id="areaButton" class="btn btn-primary">
					エリア追加・削除
				</button> -->
				<s:hidden name="isSearched"></s:hidden>
				</s:form>
			</div>
			<div class="resultArea col-xs-12 col-sm-12 col-md-9 col-lg-9">
				<s:if test="%{resultList.size!=0}">
				<s:form>
				<table id="resultTable" class="table table-borderd table-striped table-hover">
					<thead>
						<tr>
							<th class="per-12 center">店舗名</th>
							<th class="per-12 center">エリア名</th>
							<th class="per-16 center">評価</th>
							<th class="per-46 center">コメント</th>
							<th class="per-7 center">更新</th>
							<th class="per-7 center">削除</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="resultList">
						<tr>
							<td class="data center"><s:property value="name" /></td>
							<td class="data center"><s:property value="area.name" /></td>
							<td class="data"><div class="stars-readOnly" value="<s:property value="stars"/>"></div></td>
							<td class="data"><s:property value="comment" /></td>
							<td class="data"><input type="button" name="updateBtn" value="更新"
								class="btn btn-primary" forUpdate="<s:property value="id"/>" />
							</td>
							<td class="data center"><input type="checkbox" name="deleteId"
								value=<s:property value="id" /> />
							</td>
						</tr>
<!--
		<div class="panel panel-default panel-half">
			<div class="panel-body">
			</div>
		</div> -->

						</s:iterator>
					</tbody>
				</table>
				<div align=right>
					<s:submit id="deleteBtn" method="delete" value="削除" cssClass="btn btn-danger" />
				</div>
				<s:hidden name="isSearched"></s:hidden>
				</s:form>
				</s:if>
			</div>

			<!-- モーダル・ダイアログ -->
			<div class="modal fade" id="sampleModal" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"><span>×</span></button>
							<h4 class="modal-title">タイトル</h4>
						</div>
						<div class="modal-body">
							本文
						</div>
						<img src="<s:url value="/assets/images/temp/hoo.jpg"/>">
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">閉じる</button>
							<button type="button" class="btn btn-primary">ボタン</button>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div id="bogoCount" class="panel-clear"></div>
		<script type="text/javascript" src="<s:url value="/assets/libs/raty/jquery.raty.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/assets/libs/shuffle/jquery.shuffle.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/assets/js/harasan.js"/>"></script>
	</body>
</html>