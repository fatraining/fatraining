<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<h3>新しく食事について登録します</h3>
	<p class="err"><s:property value="errormsg" /></p>
<s:form cssClass="form-horizontal">

	<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<a href="main10.action">Back</a>
			</div>

			<label class="col-sm-2 control-label"> 年:</label>
			<div class="col-md-2">
				<s:textfield name="eat_year" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> 月:</label>
			<div class="col-md-2">
				<s:textfield name="eat_month" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<br /> <br /> <br /> 
			<label class="col-sm-2 control-label"> 日:</label>
			<div class="col-md-2">
				<s:textfield name="eat_day" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label">AM/PM:</label>
			<div class="col-md-2">
				<s:textfield name="eat_hour" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<br /> <br /> <br /> <hr /> <br />
			<label class="col-sm-2 control-label"> 食べ物:</label>
			<div class="col-md-2">
				<s:textfield name="eatFood" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> カロリー:</label>
			<div class="col-md-2">
				<s:textfield name="eatCalory" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<br /><br /> <br />
			<hr />

	</div>


	</s:form>
</s:if>
<s:if test="%{delete_id!=null}">
	<h3>さっきクリックした食事のデータを削除済ます</h3>
	<td class="data">削除するレコード ID:<s:property value="delete_id" /></td>
	<s:form cssClass="form-horizontal">
			<s:submit method="delete" value="削除" cssClass="btn btn-primary"/>
			<a href="main10.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />