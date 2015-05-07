<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<h3>新しくお菓子を登録します</h3>
	<p class="err">
		<s:property value="errormsg" />
	</p>
	<s:form cssClass="form-horizontal">

		<div class="form-group">
			<label class="col-md-2 control-label">お菓子の名前:</label>
			<div class="col-md-5">
				<s:textfield name="name" cssClass="form-control" rows="10"
					maxlength="50" />
			</div></div>
			<div class="form-group">
				<label class="col-md-2 control-label">ジャンル:</label>
				<div class="col-md-5">
					<s:select name="genreNm"
						list="#{'1':'焼き菓子', '2':'冷菓','3':'チョコレート菓子'}"
						cssClass="form-control" />
				</div></div>
				<br> <br> <br>
				<div align=right>
					<div class="col-sm-offset-2 col-sm-10">
						<s:submit method="insert" value="追加" cssClass="btn btn-success" />
						<a href="main2.action">Back</a>
					</div>
				</div>
	</s:form>
</s:if>
<s:if test="%{delete_id!=null}">
	<h3>本当に削除して宜しいですか？</h3>
	<td class="data">削除する ID:<s:property value="delete_id" /></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary" />
		<a href="main2.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />
