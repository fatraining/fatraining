<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<h3>新しくバンドを登録します</h3>
	<p class="err">
		<s:property value="errormsg" />
	</p>
	<s:form cssClass="form-horizontal">

		<div class="form-group">
			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<a href="bandSearch.action">Back</a>
			</div>

			<label class="col-sm-2 control-label">バンド名:</label>
			<div class="col-md-3">
				<s:textfield name="band_name" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<label class="col-sm-2 control-label">名前:</label>
			<div class="col-md-3">
				<s:textfield name="name" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br />
			<br />
			<br />
			<hr />
			<label class="col-sm-2 control-label">性別:</label>
			<div class="col-md-3">
				<s:textfield name="sex" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<label class="col-sm-2 control-label">年齢:</label>
			<div class="col-md-3">
				<s:textfield name="age" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br />
			<br />
			<br />
			<hr />
			<label class="col-sm-2 control-label">出身校:</label>
			<div class="col-md-3">
				<s:textfield name="school" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<label class="col-sm-2 control-label">好きな曲:</label>
			<div class="col-md-3">
				<s:textfield name="favorite_song" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br />
			<br />
			<br />
			<hr />
			<label class="col-sm-2 control-label">演奏楽器:</label>
			<div class="col-md-3">
				<s:textfield name="part" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>

			<s:if test="%{errorMsg=='true'}">
				<span style="color: red"><h5>＊全ての項目を入力してください</h5></span>
			</s:if>

			<br />
			<hr />
		</div>

	</s:form>
</s:if>
<s:if test="%{delete_id!=null}">
	<h3>さっきクリックしたバンドのデータを削除</h3>
	<td class="data">削除するレコード ID:<s:property value="delete_id" /></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary" />
		<a href="bandSearch.action">Back</a>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />