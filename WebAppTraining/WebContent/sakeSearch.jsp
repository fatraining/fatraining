<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/header.jsp" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/bootstrap.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/vegas.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/sake.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/sakeSearch.css"/>" />

<body>
	</iframe>
	<div class="container">
		<jsp:include page="/logo.jsp" />

		<s:property value="userID" />
		<s:form>
			<div class="form-horizontal">
				<div class="text-right">のんべえ</div>

				<p class="text-right">
					<a href="menu.action">戻る</a>
				</p>

				<h2 class="serachTitle">渋谷で美味しい日本酒のお店検索</h2>

				<div class="mainImg">
					<div class="background">
						<div class="img">
							<ul>
								<li><iframe id="iframe" width="800" height="400"
										src="https://www.youtube.com/embed/e6g93TII1c8?rel=0&autoplay=1&start=6&end=14&amp;controls=0&amp;showinfo=0"
										frameborder="0"></iframe></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label for="area" class="control-label col-sm-2" id="items">エリア：</label>
					<div class="col-sm-5" id="area">
						<s:select id="map" name="area" cssClass="form-control select"
							value="area" list="areaMap" />
					</div>
				</div>
 				<div class="form-group">
					<label class="control-label col-sm-2"id="items">予算：</label>
					<div class="col-sm-5">
						<s:select id="map" cssClass="form-control select" name="price"
							list="priceMap" />
					</div>
				</div>
				<div class="submit">
					<div class="form-group" id="block01">
						<div class="col-md-5">
							<s:submit id="button" method="search" value="検索"
								cssClass="btn btn-danger" />
						</div>
					</div>
					<div class="form-group" id="block02">
						<div class="col-md-5">
							<s:submit id="button" method="reset" value="リセット"
								cssClass="btn btn-danger" />
						</div>
					</div>
					<div class="form-group" id="block03">
						<div class="col-md-5">
							<s:submit id="button" method="update" value="登録"
								cssClass="btn btn-danger" />
						</div>
					</div>
				</div>
			</div>
	</div>

	<div class="show">
		<div class="message">
			<s:actionerror />
			<s:property value="message" />
		</div>

		<s:if test="%{resultTable.size > 0}">
			<table id="sakeinfo" class="table">
				<thead>
					<tr>
						<th>エリア</th>
						<th>店名</th>
						<th>営業時間</th>
						<th>予算</th>
						<th>おススメ銘柄</th>
						<th>コメント</th>
						<th>削除</th>
				</thead>
				<tbody>
					<s:iterator value="resultTable">
						<tr>
							<td class="data"><s:property value="area" /></td>
							<td class="data"><s:property value="shopName" /></td>
							<td class="data"><s:property value="hours" /></td>
							<td class="data"><s:property value="price" /></td>
							<td class="data"><s:property value="recommend" /></td>
							<td class="data"><s:property value="comment" /></td>
							<td class="check-box" id="check-box"><input type="checkbox"
								name="delete" value=<s:property value="id"/>></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<div class="delete">
				<s:submit id="delete" method="delete" name="delete" value="削除"
					cssClass="btn btn-danger" />
			</div>
		</s:if>
	</div>
	</s:form>


</body>
</html>