<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
	<jsp:include page="header.jsp" />
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/bootstrap.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/yamamoto.css"/>"/>
	<body>
		<div class="container">
			<jsp:include page="logo.jsp" />
				<p class="text-right"><a href="playerFinder.action">Back</a></p>
					<s:if test="%{delete==null}">
					<div style="margin:30px">
						<h1 class="h2 text-center">選手登録</h1>
					</div>
					<p class="err">
						<s:property value="errorMsg" />
					</p>

						<s:form cssClass="form-horizontal" enctype="multipart/form-data" method="post">
							<div class="form-group">
								<label class="control-label col-sm-2">選手名:※</label>
								<div class="col-sm-10">
									<s:textfield name="playerName" cssClass="form-control" placeholder="名前を入力" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">チーム名:※</label>
								<div class="col-sm-10">
									<s:select cssClass="form-control select" name="teamID" list="teamMap" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">ポジション:※</label>
								<div class="col-sm-10">
									<s:select  cssClass="form-control select" name="position" list="positionMap" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">年齢:※</label>
								<div class="col-sm-10">
									<s:textfield name="age" cssClass="form-control" placeholder="年齢を入力" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">コメント:</label>
								<div class="col-sm-10">
									<s:textarea name="comment" cssClass="form-control" placeholder="コメントを入力" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-6">
									<input class="input-file" id="fileInput" type="file" name="img" style="display:none;">
									<div class="input-append">
										<input class="span2" id="photo-dummy" type="text">
										<button class="btn btn-success" onclick="$('input[id=fileInput]').click();" type="button">写真を選択する</button>
									</div>
								</div>
							</div>
							<div style="padding:20px">
								<div class="col-sm-offset-2">
									<s:submit method="insert" value="登録"
										cssClass="btn btn-success form-control" />
								</div>
							</div>
						</s:form>
					</s:if>
					<s:if test="%{delete!=null}">
						<h3>チェックした選手データを削除します</h3>
						<td class="data">削除するデータ:<s:property value="delete"/></td>
						<s:form cssClass="form-horizontal">
							<s:submit method="delete" value="削除" cssClass="btn btn-danger " />
							<a href="playerFinder.action">Back</a>
						</s:form>
					</s:if>
			</div>
			<script type="text/javascript" src="<s:url value="/assets/js/yamamoto.js"/>"></script>
	</body>
</html>