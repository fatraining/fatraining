<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/header.jsp" />
<head>
<!-- ↓cssスタイルシートとjQueryの読み込み。別に書かなくてもBootstrapがheader.jspで既に読み込まれているから平気 -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/beerbrandsSearch.css"/>" />
<!-- ↓動画を再生させるためのやつ -->
<script type="text/javascript"
	src="<s:url value="/assets/js/jquery.tubular.1.0.js"/>"></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/beerbrandsSearch.js"/>"></script>


<style>
#wrapper {
	position: relative;
	width: 100%;
	height: 100%;
	background: url(assets/images/02.png);
}

#delete {
	font-size: 25px;
}

.h3 {
	font-size: 50px;
}

.row {

}
</style>

</head>
<body>

	<div style="color: white">
		<div id="wrapper">
			<div class="container">
				<div id="top">
					<jsp:include page="/logo.jsp" />
					<s:if test="%{delete==null}">
						<h2 class="row split">新しいデータを登録します。</h2>

						<div style="color: red">
							<s:actionerror class="error" />
						</div>

						<p class="error">
							<s:property value="errorMessage" />
						</p>

						<s:form cssClass="form-horizontal">

							<div class="row form-group" align=right>
								<a href="beerbrandsSearch.action">Back</a>
							</div>



							<div class="row form-group">
								<div class="col-md-2" id="text">
									<label for="countryID" style="color: white"
										class="control-rabel">国：</label>
								</div>
								<div class="col-md-4">
									<s:select name="countryID" cssClass="form-control "
										value="countryID" list="countryMap" />
								</div>
							</div>
							<hr />

							<div class="form-group">
								<div class="row">
									<div class="col-md-2" id="text">
										<label class="control-rabel" style="color: white">銘柄：</label>
									</div>
									<div class="col-md-4">
										<s:textfield name="beerbrands" cssClass="form-control" />
									</div>
								</div>
								<hr />

								<div class="form-group">
									<div class="row">
										<div class="col-md-2" id="text">
											<label class="control-rabel" style="color: white">分類：</label>
										</div>
										<div class="col-md-4">
											<s:textfield name="categories" cssClass="form-control" />
										</div>
									</div>
									<hr />

									<div class="form-group">
										<div class="row">
											<div class="col-md-2" id="text">
												<label class="control-rabel" style="color: white">コメント：</label>
											</div>
											<div class="col-md-4">
												<s:textfield name="comment" cssClass="form-control" />
											</div>
										</div>
									</div>
								</div>
							</div>


							<div id="submitBtn">
								<s:submit method="insert" value="追加"
									cssClass="btn btn-lg btn-success" />
							</div>
						</s:form>
					</s:if>
				</div>
			</div>

			<s:if test="%{delete!=null}">

				<div class="col-md-offset-3">
					<h2 class="row split">選択したデータを削除します。</h2>
					<s:form cssClass="form-horizontal">


						<div id="deleteBtn">
							<s:submit method="delete" value="削除"
								cssClass="btn btn-lg btn-danger" />
						</div>
						<br>
						<div class="back" align="center">
							<a href="beerbrandsSearch.action">Back</a>
						</div>
					</s:form>
				</div>
			</s:if>
		</div>
	</div>
</body>

</html>