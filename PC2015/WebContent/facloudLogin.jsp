
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<jsp:include page="facloudHeader.jsp" />
	<s:if test="errMsg != null">
		<p class="err_msg"><s:property value="errMsg" /></p>
	</s:if>
	<s:form>
	<div>
		<label>メールアドレスやで。</label><br/>
		<s:textfield name="email" placeholder="E-mailを入力してや。" value="m.miyamoto@futureantiques.co.jp"/>
	</div>
	<div>
		<label>パスワードやで。</label><br/>
		<s:textfield name="password" type="password" placeholder="Passwordを入力してや。" value="pass"/>
	</div>
	<div>
		<s:submit method="login" value="ログインするで" />
		<s:submit method="passwordReset" value="パスワードやけどな、忘れてしもたんや" />
	</div>
	</s:form>
	<jsp:include page="facloudFooter.jsp" />
				