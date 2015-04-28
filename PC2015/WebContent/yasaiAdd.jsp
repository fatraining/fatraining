<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{update_id==null}">
	<h3>新しく【野菜】と【調理方】と【料理名】を登録します</h3>
	<p class="err">
		<s:property value="errormsg" />
	</p>
	<s:form cssClass="form-horizontal">

		<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-success" />
				<a href="yasaiSearch.action">Back</a>
			</div>
			</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">野菜:<br />
		</label>
		<div class="col-md-8">
			<s:textfield name="yasai" cssClass="form-control" rows="1" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">調理方:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="tyouri" cssClass="form-control" rows="1" />
		</div>

		<label class="col-sm-2 control-label">料理名:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="ryouri" cssClass="form-control" rows="1" />
		</div>
	</div>
					
			
			</div>
			<br /> <br /> <br />
			<hr />

		</div>
	</s:form>
</s:if>
<s:if test="%{update_id!=null}">
	<h3>さっきクリックしたデータを削除済ます</h3>
	<td class="data">削除するレコード ID:<s:property value="update_id" /></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary" />
		<a href="yasaiSearch.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />