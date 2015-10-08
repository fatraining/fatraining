<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<h3>情報登録</h3>
	<p class="err">
		<s:property value="errormsg" />
	</p>
	<s:form cssClass="form-horizontal">

		<div class="form-group">

			<label class="col-sm-2 control-label"> 名前:</label>
			<div class="col-md-3">
				<s:textfield name="sName" cssClass="form-control" />
			</div>
			<br /> <br /> <br />
			<label class="col-sm-2 control-label"> 都道府県(住所):</label>
			<div class="col-md-3">
				<s:select name="sPrefecture"
					list="#{'','東京都':'東京都','神奈川県':'神奈川県','埼玉県':'埼玉県','千葉県':'千葉県','静岡県':'静岡県'}"
					cssClass="form-control" />
			</div>
			 <label class="col-sm-2 control-label">	電話番号:</label>
			<div class="col-md-3">
				<s:textfield name="sPhonenumber" cssClass="form-control" />
			</div>
			<br /> <br /> <br />
			<hr />
			<label class="col-sm-2 control-label"> 所属会社名:</label>
			<div class="col-md-8">
				<s:textfield name="cName" cssClass="form-control" />

			</div>
			<br /> <br /> <br />
			<label class="col-sm-2 control-label"> 所属会社都道府県（住所）:</label>
			<div class="col-md-3">
				<s:select name="cPrefecture" 
					list="#{'','東京都':'東京都','神奈川県':'神奈川県','埼玉県':'埼玉県','千葉県':'千葉県','静岡県':'静岡県'}"
					cssClass="form-control" />
			</div>
			
			 <label class="col-sm-2 control-label">	所属会社電話番号:</label>
			<div class="col-md-3">
				<s:textfield name="cPhonenumber" cssClass="form-control" />
			</div>
			<br />
			<br />
			<br />
			<hr />
			
				<s:submit method="insert" value="追加" cssClass="btn btn-warning" />
			<div align=right>
				<a href="main11.action">back</a>
			</div>
		</div>
	</s:form>
</s:if>	
			
<s:if test="%{delete_id!=null}">
	<h3>本当に削除してもよろしいですか</h3>
	<td class="data">削除する ID:<s:property value="delete_id" /></td>
	<br />
	<br />
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-danger" />
		<p align="right"><a href="main11.action">back</a></p>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />