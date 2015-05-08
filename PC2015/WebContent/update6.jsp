<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<h3>新しくデータを登録します</h3>
	<s:form cssClass="form-horizontal">

		<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<a href="main6.action">Back</a>
			</div>

			
			<label class="col-sm-2 control-label"> タイトル:</label>
			<div class="col-md-3">
				<s:textfield name="title" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			
			<label class="col-sm-2 control-label"> シリーズ名:</label>
			<div class="col-md-3">
				<s:textfield name="series" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br />
			<hr />
		
			<br /> <br /> <br />
			<label class="col-sm-2 control-label">切り札:</label>
			<div class="col-md-2">
				<s:textfield name="trump" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<label class="col-sm-2 control-label">起源:</label>
			<div class="col-md-2">
				<s:textfield name="origin" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br /> <br /> <br />
			<hr />
		</div>


	</s:form>
</s:if>
<s:if test="%{delete_id!=nulld}">
	<h3>さっきクリックした情報のデータを削除済ます</h3>
	<td class="data">削除する ID:<s:property value="delete_id" /></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary" />
		<a href="main6.action">Back</a>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />