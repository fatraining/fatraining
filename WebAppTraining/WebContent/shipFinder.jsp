<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<jsp:include page="header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/bootstrap.min.css"/>" />

<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/ship.css"/>" />

<!-- 背景に動画を流す、videoIdはyoutubeから引っ張ってきている -->
<script>
	$(function() {
		$('document').ready(function() {
			var options = {
				videoId : 'UFbzKcAe7oM'
			};
			$('#wrapper').tubular(options);
		});
	});
</script>

<body>
	<div id="wrapper">
		<div class="container">
			<jsp:include page="logo.jsp" />
			<p class="text-right">
				<a href="menu.action">Back</a>
			</p>
			<h1 class="h2 text-center">
				<font face="HG行書体" size="7" color="#ff0000">艦艇検索</font>
			</h1>

			<s:form cssClass="form-horizontal"> <!-- 最初のformの際に記述 -->
				<div class="text-right">
					<s:property value="userId" />
					さん
				</div>

				<div class="form-group ">
					<label for="name" class="control-label col-sm-2"><font
						face="HG行書体" color="#ff0000" size="5">国名:</font></label>
					<div class="col-sm-10">
						<s:select id="country" cssClass="form-control select"
							name="countryID" list="countryMap" />
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="control-label col-sm-2"><font
						face="HG行書体" color="#ff0000" size="5">艦名:</font></label>
					<div class="col-sm-10">
						<s:textfield id="name" name="shipName" cssClass="form-control"
							placeholder="艦名を入力" />
					</div>
				</div>
				<div class="form-group">
					<label for="name" class="control-label col-sm-2"><font
						face="HG行書体" color="#ff0000" size="5">艦種:</font></label>
					<div class="col-sm-10">
						<s:select id="shipClass" name="shipClass" list="shipClassMap"
							cssClass="form-control select" />
					</div>
				</div>
				<hr />

				<div class=" form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="button" id="search" value="抜錨"
							class="btn btn-primary form-control" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2  col-sm-4">
						<input type="button" id="reset" value="解体"
							class="btn btn-danger form-control" />
					</div>
					<div class="col-sm-offset-2 col-sm-4">
						<s:submit method="update" value="竣工"
							cssClass="btn btn-success form-control" />
					</div>
				</div>
				<div class="result">
					<span class="msg" style="color: red"> <s:actionerror /> <s:property
							value="msg" />
					</span>
					<div class="table-responsive  col-sm-offset-2">
						<table class="tbl table-hover" style="display: none">
							<tbody>
								<tr>
									<th></th>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div id="delete" align=right></div>
				</div>
				<!--
				<s:if test="%{resultTable.size() > 0}">
					<div class="table-responsive  col-sm-offset-2">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>国名</th>
										<th>艦名</th>
										<th>艦種</th>
										<th>竣工年</th>
										<th>プロフィール</th>
										<th>解体</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="resultTable">
										<tr>
											<td class="data"><s:property value="countryName" /></td>
											<td class="data"><s:property value="shipName" /></td>
											<td class="data"><s:property value="shipClass" /></td>
											<td class="data"><s:property value="year" /></td>
											<td class="data"><input type="button" name="profileBtn" value="profile"
												class="btn btn-info" data-toggle="modal" data-target="#profileModal"
												data-recipient="<s:property value="comment" />"
												data-whatever="<s:property value="imagePath" />" />
											<td class="data"><input type="checkbox" name="delete"
												value="<s:property value="playerID" />:<s:property value="playerName" />" /></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
					</div>
					<div align=right>
						<s:submit method="delete" name="delete" value="解体"
							cssClass="btn btn-danger" />
					</div>
					</s:if>
				-->

				<!-- モーダルを使う -->
				<div class="modal fade" id="profileModal" tabindex="-1">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span>×</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="bodyPane">
									<div class="imagePane">画像</div>
									<div class="commentPane">コメント</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">閉じる</button>

							</div>
						</div>
					</div>
				</div>
			</s:form>
		</div>
	</div>

	<script type="text/javascript"
		src="<s:url value="/assets/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript"
		src="<s:url value="/assets/js/jquery.tubular.1.0.js"/>"></script>
	<script type="text/javascript"
		src="<s:url value="/assets/js/yokoyama.js"/>"></script>
</body>
</html>