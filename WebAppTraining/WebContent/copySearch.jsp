
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<jsp:include page="/headercopy.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/bootswatch-paper.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/libs/raty/jquery.raty.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/copy.css"/>" />
<body>
	<jsp:include page="/logo.jsp" />
	<div class="sub-header">
			<Marquee behavior="alternate">
		<s:property value="TitleName" />
		</Marquee>
			<p class="text-right">
				<s:property value="userId" />
				さん <a href="menu.action">Back</a>
		</p>
		<img src="./assets/images/temp/copy_title.jpg">
	</div>

	<div class="container">
		<p class="err text-right">
			<s:actionerror class="err" />
		</p>
		<div class="search-menu col-xs-12 col-sm-12 col-md-3 col-lg-3">
			<s:form cssClass="form-horizontal" id="searchCondition">
				<div class="form-group">
					<label for="name" class="control-label">コピー能力名:</label>
					<s:textfield name="name" cssClass="form-control"
						placeholder="例）ファイア" />
				</div>
				<div class="form-group">
					<label for="title" class="control-label">初登場作品:</label>
					<s:select name="title" value="title" list="titleMap"
						cssClass="form-control select" />
				</div>
				<div>
					<s:submit method="search" value="検索" cssClass="btn btn-warning btnspace" />
					<s:submit method="reset" value="リセット" cssClass="btn btn-danger btnspace" />
					<s:submit method="update" value="おぼえる" cssClass="btn btn-primary btnspace" />
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
					<table id="resultTable"
						class="table table-borderd table-striped table-hover">
						<thead>
							<tr>
								<th class="per-12 center">コピー名</th>
								<th class="per-12 center">初登場タイトル</th>
								<th class="per-12 center">初登場日</th>
								<th class="per-16 center">画像</th>
								<th class="per-7 center">登場回数</th>
								<th class="per-7 center">更新</th>
								<th class="per-7 center">削除</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="resultList">
								<tr>
									<td class="data center"><s:property value="name" /></td>
									<td class="data center"><s:property value="title.name" /></td>
									<td class="data center"><s:property value="title.releasedate" /></td>
									<td class="data center">
									<a href="./assets/images/temp/<s:property value="img_path" />">
									<img
										src="./assets/images/temp/<s:property value="img_path" />"class = "tablewidth"></a></td>
									<td class="data center"><s:property value="appearance" /></td>
									<td class="data center"><input type="button"
										name="updateBtn" value="更新" class="btn btn-primary btn-block"
										forUpdate="<s:property value="id"/>" /></td>
									<td class="data center"><input type="checkbox"
										name="deleteId" value=<s:property value="id" /> /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<div align=right>
						<s:submit id="deleteBtn" method="delete" value="わすれる"
							cssClass="btn btn-danger btn-block" />
					</div>
					<s:hidden name="isSearched"></s:hidden>
				</s:form>
			</s:if>
		</div>
	</div>
	<!--イースターエッグ的な  -->
	<p>
	<a href="http://killmebaby.tv/	">n</a>
	</p>
	<div id="bogoCount" class="panel-clear"></div>
	<script type="text/javascript"
		src="<s:url value="/assets/libs/raty/jquery.raty.js"/>"></script>
	<script type="text/javascript"
		src="<s:url value="/assets/libs/shuffle/jquery.shuffle.js"/>"></script>
	<script type="text/javascript"
		src="<s:url value="/assets/js/copy.js"/>"></script>
</body>
</html>