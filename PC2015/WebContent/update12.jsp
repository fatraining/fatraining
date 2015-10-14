<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<h3>新しくデータを登録します。</h3>
	<p class="err">
		<s:property value="errormsg" />
	</p>
	<s:form cssClass="form-horizontal">

		<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<a href="main12.action">Back</a>
			</div>
			<label class="col-sm-2 control-label"> 登録番号:</label>
			<div class="col-md-3">
				<s:textfield name="registration_number" cssClass="form-control" rows="51"
					maxlength="50" />
			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label"> 競技番号:</label>
			<div class="col-md-3">
				<s:textfield name="competition_number" cssClass="form-control" rows="51"
					maxlength="50" />
			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label"> 名前:</label>
			<div class="col-md-3">
				<s:textfield name="name" cssClass="form-control" rows="51"
					maxlength="50" />
			</div>
			<br />
			<hr />
			</div>
	</s:form>
</s:if>
<s:if test="%{delete_id!=null}">
	<h3>さっきのデータを削除します</h3>
	<td class="data">削除するデータ:<s:property value="delete_id"/></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary" />
		<a href="main12.action">Back</a>
		</s:form>
</s:if>


<jsp:include page="footer.jsp" />