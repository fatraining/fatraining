<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<s:if test="%{delete==null}">
	<h3>新しくデータを登録します。</h3>
	<p class="err">
		<s:property value="errormsg" />
	</p>
	<s:form cssClass="form-horizontal">

		<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<a href="phoneFinder.action">Back</a>
			</div>
			<div class="form-group">
				<label for="operatorName" class="col-sm-2 control-label" > 事業者名:</label>
			<div class="col-md-3">
					<s:select cssClass="form-control" name="operatorID"
						list="operatorName" />
				</div>
			</div>
			<hr />
			<label class="col-sm-2 control-label"> 機種名:</label>
			<div class="col-md-3">
				<s:textfield name="phoneName" cssClass="form-control" rows="51"
					maxlength="50" />
			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label"> 価格:</label>
			<div class="col-md-3">
				<s:textfield name="price" cssClass="form-control" rows="51"
					maxlength="50" />
			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label"> 画面サイズ:</label>
			<div class="col-md-3">
				<s:textfield name="size" cssClass="form-control" rows="51"
					maxlength="50" />
			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label"> 発売日:</label>
			<div class="col-md-3">
				<s:textfield name="date" cssClass="form-control" rows="51"
					maxlength="50" placeholder="yyyy/mm/dd" />
			</div>
			<br />
			<hr />
			<label class="col-sm-2 control-label"> 備考:</label>
			<div class="col-md-3">
				<s:textfield name="comment" cssClass="form-control" rows="100"
					maxlength="50" />
			</div>
			<br />
			<hr />
		</div>
	</s:form>
</s:if>

<s:if test="%{delete!=null}">
	<h3>選んだデータを削除します</h3>
	<td class="data">削除するデータ:<br><s:property value="delete"/></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary " />
		<a href="phoneFinder.action">Back</a>
		</s:form>
</s:if>