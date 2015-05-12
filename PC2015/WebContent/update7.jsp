<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<h3>新しく映画を登録します</h3>
	<p class="err"><s:property value="errormsg" /></p>
<s:form cssClass="form-horizontal">

	<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-danger" />
				<a href="main7.action">Back</a>
			</div>

			<label class="col-sm-2 control-label"> タイトル:</label>
			<div class="col-md-5">
				<s:textfield name="title" cssClass="form-control" rows="10" maxlength="17" />
			</div>
		<br/><br/><br/>
		<hr/>
			<label class="col-sm-2 control-label"> ジャンル:</label>
			<div class="col-md-3">
			    <s:select name="genreId" list="values" listKey="id" listValue="genre"  cssClass="form-control"/>
				
				</div>
		<br/>
		<hr/>
			<label class="col-sm-2 control-label"> 公開年:</label>
			<div class="col-md-2">
				<s:textfield name="exhibition_year" cssClass="form-control" rows="10" maxlength="4"/>
			</div>
		<br />
		<hr />
			<label class="col-sm-2 control-label"> コメント:</label>
			<div class="col-md-10">
				<s:textarea name="comment" cssClass="form-control" rows="10" maxlength="100" />
			</div>
		<br/>
		<hr/>

	</div>


	</s:form>
</s:if>
<s:if test="%{delete_id!=null}">
	<h3>さっきクリックした映画のデータを削除します</h3>
	<td class="data">削除するレコード ID:<s:property value="delete_id" /></td>
	<s:form cssClass="form-horizontal">
			<s:submit method="delete" value="削除" cssClass="btn btn-primary"/>
			<a href="main7.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />