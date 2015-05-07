<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<h3>新しく趣味を登録します</h3>
	<p class="err">
		<s:property value="errormsg" />
	</p>
	<s:form cssClass="form-horizontal">

		<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<a href="main5.action">Back</a>
			</div>

			<label class="col-sm-2 control-label"> 名前:</label>
			<div class="col-md-3">
				<s:textfield name="name" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br />
			<hr />
			
			<label class="col-sm-2 control-label"> 性格:</label>
			<div class="col-md-3">
				<s:textfield name="personality" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br />
			<hr />
			
			<label class="col-sm-2 control-label"> 趣味:</label>
			<div class="col-md-3">
				<s:textfield name="interest" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br />
			<hr />
			
			<label class="col-sm-2 control-label"> 郵便番号:</label>
			<div class="col-md-3">
				<s:textfield name="zipcode" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br />
			<hr />

			<label class="col-sm-2 control-label"> 住所:</label>
			<div class="col-md-3">
				<s:textfield name="dwelling" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br />
			<hr />
			
			<label class="col-sm-2 control-label"> 電話番号:</label>
			<div class="col-md-3">
				<s:textfield name="phonenumber" cssClass="form-control" rows="10"
					maxlength="50" />
			</div>
			<br /> <br /> <br />
			<hr />

		</div>
	</s:form>
</s:if>
<s:if test="%{delete_id!=null}">
	<h3>さっきクリックしたパソコンのデータを削除済ます</h3>
	<td class="data">削除するレコード ID:<s:property value="delete_id" /></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary" />
		<a href="main5.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />