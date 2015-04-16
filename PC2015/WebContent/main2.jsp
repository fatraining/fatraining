<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />



	<div class="form-group">
		<label class="col-sm-2 control-label">Main2:<br /> <s:submit
				method="execute" value="main2" cssClass="btn btn-success btn-xs" />
				</label>
		<div class="col-sm-10">
			<s:textfield name="str" cssClass="form-control" rows="10" />
		</div>