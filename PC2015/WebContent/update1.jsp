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
				<s:submit method="insert" value="追加" cssClass="btn btn-warning" />
				<a href="main1.action">Back</a>
			</div>

			<label class="col-sm-2 control-label"> 名前:</label>
			<div class="col-md-3">
				<s:textfield name="name" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> 性格:</label>
			<div class="col-md-3">
				<s:textfield name="personality" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br />
			<br />
			<br />
			<hr />
			<label class="col-sm-2 control-label"> 出身地:</label>
			<div class="col-md-3">
				<s:textfield name="home" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br /> <label class="col-sm-2 control-label">
				誕生月:</label>
			<div class="col-md-3">

				<s:select name="birthday" list="{1,2,3,4,5,6,7,8,9,10,11,12}"
					cssClass="form-control" />

			</div>
			<label class="col-sm-2 control-label"> 趣味:</label>
			<div class="col-md-3">
				<s:textfield name="hobby" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br />
			<br />
			<br />
			<hr />
		</div>


	</s:form>
</s:if>
<s:if test="%{delete_id!=null}">
	<h3>さっきクリックしたデータを削除済ます</h3>
	<td class="data">削除する ID:<s:property value="delete_id" /></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-info" />
		<a href="main1.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />