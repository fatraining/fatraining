<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/header.jsp" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/tablesorter-white/style.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/beerbrandsSearch.css"/>" />
<script type="text/javascript"
	src="<s:url value="/assets/js/jquery.tubular.1.0.js"/>"></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/beerbrandsSearch.js"/>"></script>
</head>

<style>
#wrapper {
	position: relative;
	width: 100%;
	height: 100%;
	background: url(assets/images/02.png);
}
</style>
<body>
	<!-- formで全体を囲むことで、値の受け渡しを行えるようになる -->
	<s:form>
		<div id="wrapper">
			<div class="container">
				<div style="color: white">
					<jsp:include page="/logo.jsp" />
					<p class="row text-right">
						<a href="menu.action">Back</a>
					</p>
				</div>


				<h2 class="serachTitle">ビール銘柄検索</h2>
				<div id="clock-02" class="text-center"></div>

				<div style="color: white">
					<div class=" row text-right"
						style="padding-bottom: 10px; font-size: 1.2em;">
						<s:property value="userID" />
						さん
					</div>
					<div class="form-group">
						<!-- rowはコンテンツをまとめるもの -->
						<div class="row">
							<div class="form-horizontal">

								<div class="row form-group" style="padding-top: 30px;">
									<label for="country" style="color: white"
										style="font-size: 1.8em">国：</label>
									<s:select name="country" cssClass="form-control"
										value="country" list="countryMap" />
								</div>

								<div class="row form-group">
									<label for="beerbrands" style="color: white"
										style="font-size: 1.8em">銘柄：</label>
									<s:textfield name="beerbrands" cssClass="form-control" />
								</div>

								<div class="row form-group">
									<label for="categories" style="color: white"
										style="font-size: 1.8em">分類：</label>
									<s:textfield name="categories" cssClass="form-control" />
								</div>

							</div>

							<div class="form-group col-md-offset-2 col-md-8"
								style="padding-top: 10px;">
								<s:submit method="search" value="検索"
									cssClass="form-control btn btn-info" />
								<br>
							</div>

							<div class="row col-md-offset-3">
								<div class="form-group col-md-4">
									<s:submit method="reset" value="リセット"
										cssClass="form-control btn btn-warning" />
								</div>
								<div class="form-group col-md-4">
									<s:submit method="update" value="追加"
										cssClass="form-control btn btn-success" />
								</div>
							</div>

						</div>
					</div>
				</div>

				<div class="row show">
					<div style="color: white">

						<div class="message">
							<s:actionerror />
							<s:property value="message" />
						</div>

						<s:if test="%{beerbrandsTable.size > 0}">
							<table id="beerbrands" class="table">
								<thead>
									<tr>
										<th>国</th>
										<th>銘柄</th>
										<th>分類</th>
										<th>コメント</th>
										<th>削除</th>
								</thead>

								<tbody>
									<s:iterator value="beerbrandsTable">
										<tr>
											<td class="data"><s:property value="country" /></td>
											<td class="data"><s:property value="beerbrands" /></td>
											<td class="data"><s:property value="categories" /></td>
											<td class="data"><s:property value="comment" /></td>
											<td class="data"><input type="checkbox" name="delete"
												value=<s:property value="ID"/>></td>
										</tr>
									</s:iterator>
								</tbody>

							</table>
							<s:if test="%{beerbrandsTable.size > 0}">
								<div align=left style="padding-bottom: 80px;">
									<s:submit method="delete" name="delete" value="削除"
										cssClass="btn btn-danger" />
								</div>
							</s:if>
						</s:if>
					</div>
				</div>
			</div>
		</div>
	</s:form>

</body>
</html>