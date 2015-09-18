<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<h3>情報登録</h3>
	<p class="err">
		<s:property value="errormsg" />
	</p>
	<s:form cssClass="form-horizontal">

		<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-success" />
				<a href="kaisyaSearch.action">Back</a>
			</div>

			<label class="col-sm-2 control-label"> 社名:</label>
			<div class="col-md-5">
				<s:textfield name="syamei" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br />
			<br />
			<br />
			<hr />
			<label class="col-sm-2 control-label"> 名前:</label>
			<div class="col-md-3">
				<s:textfield name="name" cssClass="form-control" rows="10"
					maxlength="50" />

			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label"> 入社日:</label>
			<div class="col-md-3">
				<s:textfield name="nyusyabi" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label"> 部署:</label>
			<div class="col-md-2">
				<s:textfield name="busyo" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label"> コメント:</label>
			<div class="col-md-10">
				<s:textarea name="comment" cssClass="form-control" rows="10"
					maxlength="5000" />
			</div>
			<br />
			<hr />

		</div>


	</s:form>
</s:if>
<s:if test="%{delete_id!=null}">
	<h3>さっきクリックしたデータを削除します</h3>
	<td class="data">削除するレコード ID:<s:property value="delete_id" /></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-info" />
		<a href="kaisyaSearch.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />