<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
	<jsp:include page="header.jsp" />
	<body>
		<div class="container">
			<jsp:include page="logo.jsp" />
				<p class="text-right"><a href="playerFinder.action">Back</a></p>
					<s:if test="%{delete==null}">
					<div style="margin:30px">
						<h1 class="h2 text-center">選手新規登録</h1>
					</div>
					<p class="err">
						<s:property value="errorMsg" />
					</p>

						<s:form cssClass="form-horizontal">
							<div class="form-group">
								<label class="control-label col-sm-2">選手名:※</label>
								<div class="col-sm-10">
									<s:textfield name="playerName" cssClass="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">チーム名:※</label>
								<div class="col-sm-10">
									<s:select cssClass="form-control" name="teamID" list="teamMap" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">ポジション:※</label>
								<div class="col-sm-10">
									<s:select name="position" list="positionList" cssClass="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">年齢:※</label>
								<div class="col-sm-10">
									<s:textfield name="age" cssClass="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2">コメント:</label>
								<div class="col-sm-10">
									<s:textarea name="comment" cssClass="form-control" />
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
	</body>
</html>