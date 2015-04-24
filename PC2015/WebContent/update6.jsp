<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{update_id==null}">
	<h3>新しくデータを登録します</h3>
	<p class="err">
		<s:property value="errormsg" />
	</p>
	<s:form cssClass="form-horizontal">

		<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<a href="main6.action">Back</a>
			</div>

			<label class="col-sm-2 control-label"> ID:</label>
			<div class="col-md-3">
				<s:textfield name="id" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> タイトル:</label>
			<div class="col-md-3">
				<s:textfield name="title" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br />
			<hr />
			<label class="col-sm-2 control-label"> シリーズID:</label>
			<div class="col-md-3">
				<s:textfield name="series" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br /> 
			<label class="col-sm-2 control-label"> シリーズ名:</label>
			<div class="col-md-3">
				<s:textfield name="se" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br /> 
			<label class="col-sm-2 control-label">登録日:</label>
			<div class="col-md-3">

				<s:textfield name="u" cssClass="form-control" rows="10"
					maxlength="50" />

			</div>
			<label class="col-sm-2 control-label"> 更新日:</label>
			<div class="col-md-3">
				<s:textfield name="upDay" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br />
			<hr />
			<label class="col-sm-2 control-label"> 登録USERID:</label>
			<div class="col-md-2">
				<s:textfield name="userId" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> 更新USERID:</label>
			<div class="col-md-3">
				<s:textfield name="upUser" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> 
			<label class="col-sm-2 control-label">他:</label>
			<div class="col-md-2">
				<s:textfield name="nonStyle" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<label class="col-sm-2 control-label">排:</label>
			<div class="col-md-2">
				<s:textfield name="del" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br /> <br /> <br />
			<hr />
		</div>


	</s:form>
</s:if>
<s:if test="%{update_id!=nulld}">
	<h3>さっきクリックした情報のデータを削除済ます</h3>
	<td class="data">削除する ID:<s:property value="update_id" /></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary" />
		<a href="main6.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />