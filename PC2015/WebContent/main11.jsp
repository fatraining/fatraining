<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>条件に一致する社員を検索します</h3>
<s:form cssClass="form-horizontal">

	<div class="form-group">
		<label class="col-sm-2 control-label">名前: </label>
		<div class="col-md-3">
			<s:textfield name="sName" cssClass="form-control" />
		</div>

		<label class="col-sm-2 control-label">都道府県(住所):</label>
		<div class="col-md-3">
			<s:select name="prefecture"
				list="#{'','1':'東京都','2':'神奈川県','3':'埼玉県','4':'千葉県','5':'静岡県'}"
				cssClass="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">所属会社名: </label>
		<div class="col-md-8">
			<s:textfield name="cName" cssClass="form-control" />
		</div>
	</div>


	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-info" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-success" />
		<s:submit method="update" value="追加" cssClass="btn btn-warning" />

		<p align="right">
			<a href="menu.action">back</a>
		</p>
		<s:if test="%{errormsg=='true'}">
			<span style="color: red">
				<h5>削除する項目を選択してください。</h5>
			</span>
		</s:if>
	</div>
</s:form>
<jsp:include page="footer.jsp" />