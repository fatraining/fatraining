<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="/header.jsp" />
<s:if test="%{delete==null}">
	<style>
p.err {
	color: red;
}
</style>
	<body>
		<div class="container">
			<jsp:include page="/logo.jsp" />
			<div style="text-align: center;">
				<h3>新しくデータを登録します。</h3>
				<div style="color: red">
					<s:actionerror class="err" />
				</div>
			</div>
			<s:form cssClass="form-horizontal">

				<div class="form-group">
					<label for="simOpeName" class="col-sm-2 control-label">
						会社名:</label>
					<div class="col-md-8">
						<s:select cssClass="form-control" name="simOpeID" list="simOpeMap" />
					</div>
					<br />
					<hr />

					<label class="col-md-2 control-label"> Simサービス名:</label>
					<div class="col-md-8">
						<s:textfield name="simService" cssClass="form-control" rows="51"
							maxlength="50" placeholder="simフリー名" />
					</div>
					<br />
					<hr />

					<label class="col-sm-2 control-label"> 料金：</label>
					<div class="col-md-8">
						<s:textfield name="charge" cssClass="form-control" rows="51"
							maxlength="50" placeholder="料金" />
					</div>
					<br />
					<hr />

					<label class="col-sm-2 control-label"> GB(通信料）:</label>
					<div class="col-md-8">
						<s:textfield name="GB" cssClass="form-control" rows="51"
							maxlength="50" placeholder="GB" />
					</div>
					<br />
					<hr />

					<label class="col-sm-2 control-label"> コメント:</label>
					<div class="col-md-8">
						<s:textfield name="comment" cssClass="form-control" rows="51"
							maxlength="50" placeholder="コメント" />
					</div>
					<br />
				</div>
				<div class="form-group">
					<div align=center>
						<s:submit method="insert" value="追加" cssClass="btn btn-info "
							STYLE="width: 800px; height: 30px;" />
						<div style="margin-right: 2px">
							<br /> <a href="simFinder.action"> Back </a>
						</div>
					</div>
				</div>
			</s:form>
</s:if>
<div>
	<s:if test="%{delete!=null}">
		<h3>選んだデータを削除します</h3>
		<td class="data">削除するデータ:<br> <s:property value="delete" /></td>
		<s:form cssClass="form-horizontal">
			<s:submit method="delete" value="削除" cssClass="btn btn-primary " />
			<a href="simFinder.action">Back</a>
		</s:form>
	</s:if>
</div>
</body>
</html>