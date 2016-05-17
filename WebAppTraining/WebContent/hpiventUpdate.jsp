<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="/header.jsp"/>

<style>
p.err {
color:red;
}
</style>

	<body>
		<s:if test= "%{delete != null}">

		<h3>選んだデータを削除します。</h3>
		<td class="data">削除するデータ:<s:property value="delete"/></td>
		<s:form cssClass="form-horizontal">
			<s:submit method="delete" value="削除" cssClass="btn btn-primary" />
			<a href="hpiventSearch.action">Back</a>
		</s:form>
	</s:if>



	<s:if test="%{delete == null}">
		<div class="container">
		<jsp:include page="/logo.jsp" />
		<h3>新しくデータを登録します。</h3>
		<div style="color:red">
		<s:actionerror class="err"/>
		</div>

		<s:form cssClass="form-horizontal">
		<div class="form-group">
			<div align=right>
			<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
			<a href="hpiventSearch.action">Back</a>
			</div>
			<div class="form-group">
				<label for="groupName" class="col-sm-2 control-label" >グループ名:</label>
			<div class="col-md-3">
					<s:select cssClass="form-control" name="groupID" list="groupName" />
			</div>
			<br />
			<hr />
				<label class="col-sm-2 control-label">分類:</label>
			<div class="col-md-3">
				<s:select cssClass="form-control" name="category"
				list="#{'コンサート':'コンサート','即売系':'即売系','個別系':'個別系','その他':'その他'}"/>
			</div>
			<br />
			<hr />
				<label class="col-sm-2 control-label">名称:</label>
			<div class="col-md-3">
				<s:textfield name="iventName" cssClass="form-control" rows="51" maxlength="100" />
			</div>
			<br />
			<hr />
				<label class="col-sm-2 control-label">場所:</label>
			<div class="col-md-3">
				<s:textfield name="place" cssClass="form-control" rows="51" maxlength="100" />
			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label">日時:</label>
			<div class="col-md-3">
				<s:textfield name="day" cssClass="form-control" rows="51"
					maxlength="16" placeholder="yyyy/MM/dd HH:mm" />
			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label">備考:</label>
			<div class="col-md-3">
				<s:textfield name="comment" cssClass="form-control" rows="51" maxlength="100" />
			</div>
			<br />
			<hr />
		</div>
		</div>
		</s:form>
		</div>
	</s:if>

		</body>



</html>