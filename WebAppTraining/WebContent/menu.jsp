<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<body>
	<div class="container">
		<jsp:include page="logo.jsp" />
		<s:form cssClass="form-horizontal">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoPhoneSearch" value="携帯検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoHarasan" value="harasan"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoPlayerSearch" value="選手検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoCatcafeSearch" value="猫カフェ検索" cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoSimSearch" value="SIM検索" cssClass="btn btn-warning" />
				</div>
			</div>
			</s:form>
		</div>
</body>
</html>