<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/norris.css"/>" />

<body>
	<jsp:include page="logo.jsp" />

	<div class="container">
		<div class="text-center"></div>
		<p class="text-right">
			<a href="menu.action">Back</a>
		</p>
		<br>

	</div>
	<div class="left">
		<font size="7" color="red"><s:property value="title" /></font> <br>
		<div class="text-right">
			<font color="red"><s:property value="userId" /> <!--OnsenSearchAction.javaで生成したuserIdを画面に表示する -->
				さん</font>
		</div>
		<div class="message">
			<s:actionerror />
			<s:property value="message" />
		</div>
		<br>
		<s:form cssClass="form-horizontal">
			<div class="left">

				<!-- レスポンシブ水平フォーム -->
				<div class="left">
					<div class="form-group">
						<label for="series" class="col-sm-2 control-label"><font
							color="red">シリーズ：</font></label>
						<div class="col-md-8">
							<s:select cssClass="form-control" name="series" value="series"
								list="norrisSeriesMap"></s:select>
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label"><font
							color="red">作品名:</font></label>
						<div class="col-md-8">
							<s:textfield name="name" cssClass="form-control" />
						</div>
					</div>
					<br>

					<div class="form-group">
						<div class="col-md-offset-2 col-md-8">
							<s:submit method="search" value="検索"
								cssClass="btn btn-warning btn-block" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-2 col-md-4">
							<s:submit method="reset" value="リセット"
								cssClass="btn btn-danger btn-block" />
						</div>
						<div class="col-md-4">
							<s:submit method="update" value="追加"
								cssClass="btn btn-info btn-block " />
						</div>
					</div>
				</div>
			</div>
		</s:form>
		<form id="norrisSearch" name="norrisSearch" action="/WebAppTraining/norrisSearch.action" method="post">

			<div class="result">
				<s:if test="%{norrisTable.size> 0}">

					<div align="center">
						<table class="table">


							<thead>
								<!-- テーブルヘッダー -->
								<tr>
									<th>いいね！</th>
									<th>公開年</th>
									<th>タイトル</th>
									<th>シリーズ</th>
									<th>コメント</th>
									<th>いいね！する</th>
									<th>更新</th>
									<th>削除</th>


								</tr>

							</thead>
							<tbody>

								<s:iterator value="norrisTable">
									<tr>
										<td class="data"><s:property value="iine" /></td>
										<td class="data"><s:property value="year" /></td>
										<td class="data"><s:property value="name" /></td>
										<td class="data"><s:property value="series" /></td>
										<td class="data"><s:property value="comment" /></td>
										<td><input type="button" name="iineBtn" id="iine"
											value="いいね！" class="btn btn-primary"
											forIine=<s:property value ="id"/> /></td>
										<td><input type="button" name="updateBtn" id="update"
											value="更新" class="btn btn-primary"
											forUpdate=<s:property value ="id"/> /></td>
										<td class="data" width="50"><input type="checkbox"
											name="delete" value=<s:property value="id"/>></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>

				</s:if>
				<s:if test="%{norrisTable.size>0}">
					<div class="text-right">
						<div class="shake shake-chunk">
							<s:submit method="delete" value="削除" cssClass="btn btn-danger" />
						</div>
					</div>
					<br>
				</s:if>
			</div>
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/kashita.js" />"></script>
</body>
</html>