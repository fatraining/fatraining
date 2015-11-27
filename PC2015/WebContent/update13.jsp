<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<p class="text-right"><a href="main13.action">Back</a></p>
	<h1 class="h3 text-center">データ新規登録</h1>
	<p class="err">
		<s:property value="errormsg" />
	</p>

	<s:form cssClass="form-horizontal">
				<div class="text-right">
		<s:property value="UserID" />
		さん
	</div>

			<div class="form-group">
				<label for="updata13_Name" class="col-sm-2 control-label"> タイトル:</label>
					<s:textfield name="Name" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="updata13_CompanyID" class="col-sm-2 control-label"> 会社:</label>
					<s:select cssClass="form-control" name="CompanyID" list="Companies"/>
			</div>
			<div class="form-group">
				<label for="updata13_Genre" class="col-sm-2 control-label"> ジャンル:</label>
					<s:select cssClass="form-control" name="Genre" list="Genres"/>
			</div>
			<div class="form-group">
				<label for="updata13_Hardware" class="col-sm-2 control-label"> 機種:</label>
					<s:select cssClass="form-control" name="Hardware" list="Hardwares"/>
			</div>
			<div class="form-group">
				<label for="updata13_Comment" class="col-sm-2 control-label"> コメント:</label>
					<s:textarea name="Comment" cssClass="form-control" rows="5" />
			</div>
			<s:submit method="insert" value="追加" cssClass="btn btn-success btn-block" />
	</s:form>
</s:if>

<s:if test="%{delete_id!=null}">
	<h3>さっきのデータを削除します</h3>
	<td class="data">削除するデータ:<s:property value="delete_id"/></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary " />
		<a href="main13.action">Back</a>
		</s:form>
</s:if>

<jsp:include page="footer.jsp" />