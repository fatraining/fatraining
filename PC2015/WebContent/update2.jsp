<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{add_id==null}">
	<h3>新しくお菓子を登録します</h3>
	<p class="err">
		<s:property value="errormsg" />
	</p>
	<s:form cssClass="form-horizontal">

		<div class="form-group">
			<label class="col-md-2 control-label" > 名前:</label>
			<div class="col-md-5">
				<input name="Name" class="form-control valid" type="text" >
			</div>
			<br><br><br>
			<label class="col-md-2 control-label" > ジャンル:</label>
			<div class="col-md-5">
				<input name="Genre" class="form-control valid" type="text" >
			</div>
			<br><br><br>
		</div>
		<br><br><br>
		<div align=right>
			<div class="col-sm-offset-2 col-sm-10">
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<s:submit method="reset" value="リセット" cssClass="btn btn-primary" />
				<a href="main2.action">Back</a>
			</div>
		</div>
	</s:form>
</s:if>
<s:if test="%{delete_id!=true}">
	<h3>本当に削除して宜しいですか？</h3>
	<td class="data">削除する ID:<s:property value="delete_id" /></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary" />
		<a href="main2.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />
