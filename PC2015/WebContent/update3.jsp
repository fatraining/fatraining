<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{update_id==null}">
	<h3>新しく小説を登録します</h3>
	<p class="err"><s:property value="errormsg" /></p>
<s:form cssClass="form-horizontal">

	<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<a href="main.action">Back</a>
			</div>

			<label class="col-sm-2 control-label"> タイトル名:</label>
			<div class="col-md-3">
				<s:textfield name="title" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> ジャンル:</label>
			<div class="col-md-3">
				<s:textfield name="genre" cssClass="form-control" rows="10" maxlength="50" />
			</div>
		<br/><br/><br/>
	

	</div>


	</s:form>
</s:if>
<s:if test="%{update_id!=null}">
	<h3>さっきクリックしたパソコンのデータを削除済ます</h3>
	<td class="data">削除するレコード ID:<s:property value="update_id" /></td>
	<s:form cssClass="form-horizontal">
			<s:submit method="delete" value="削除" cssClass="btn btn-primary"/>
			<a href="main3.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />