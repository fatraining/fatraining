<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
	<jsp:include page="header.jsp" />
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/yokoyama.css"/>"/>	<!-- 背景を画像に -->
	<body>
		<div class="container">
			<jsp:include page="logo.jsp" />
				<p class="text-right"><a href="shipFinder.action">Back</a></p>
					<s:if test="%{delete==null}">
					<div style="margin:30px">
						<h1 class="h2 text-center"><font face="HG行書体" size="7" color="#ff0000">艦艇登録</font></h1>
					</div>
					<p class="err">
						<s:property value="errorMsg" />
					</p>

						<s:form cssClass="form-horizontal" enctype="multipart/form-data" method="post">
							<div class="form-group">
								<label class="control-label col-sm-2">艦名:※</label>
								<div class="col-sm-10">
									<s:textfield name="shipName" cssClass="form-control" placeholder="艦名を入力" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">国名:※</label>
								<div class="col-sm-10">
									<s:select cssClass="form-control select" name="countryID" list="countryMap" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">艦種:※</label>
								<div class="col-sm-10">
									<s:select  cssClass="form-control select" name="shipClass" list="shipClassMap" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">竣工年:※</label>
								<div class="col-sm-10">
									<s:textfield name="year" cssClass="form-control" placeholder="竣工年を入力" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">プロフィール:</label>
								<div class="col-sm-10">
									<s:textarea name="comment" cssClass="form-control" placeholder="プロフィールを入力" />
								</div>
							</div>
							<div class="input-group customUpload col-sm-offset-2">
									<input class="input-file form-control" id="fileInput" type="file" name="image" style="display:none;">
									<div class="input-append">
										<input class="span2" id="photo-dummy" type="text">
										<button class="btn btn-success" onclick="$('input[id=fileInput]').click();" type="button">写真を選択する</button>
									</div>
							</div>
							<div style="padding:20px">
								<div class="col-sm-offset-2">
									<s:submit method="insert" value="竣工"
										cssClass="btn btn-primary form-control" />
								</div>
							</div>
						</s:form>
					</s:if>
					<s:if test="%{delete!=null}">
						<h3>チェックした艦艇データを解体します</h3>
						<td class="data">解体するデータ:<s:property value="delete"/></td>
						<s:form cssClass="form-horizontal">
							<s:submit method="delete" value="解体" cssClass="btn btn-danger " />
							<a href="shipFinder.action">Back</a>
						</s:form>
					</s:if>
			</div>
			<script type="text/javascript" src="<s:url value="/assets/js/yokoyama.js"/>"></script>
	</body>
</html>