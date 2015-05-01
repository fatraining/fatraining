<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>条件に一致する作品を検索します。</h3>
<s:form cssClass="form-horizontal">
	<div class="form-group">
		<label class="col-sm-2 control-label">タイトル:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="title" cssClass="form-control" rows="1" />
		</div>

		<label class="col-sm-2 control-label">シリーズ:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="series" cssClass="form-control" rows="1" />
		</div>
	</div>


	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-primary" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-primary" />
		<s:submit method="delete" value="追加" cssClass="btn btn-primary" />

		<!--<s:submit method="printall" value="全件リスト" cssClass="btn btn-primary" />-->
	</div>
</s:form>


<s:if test="%{do_search=='true'}">
	<h3>結果↓</h3>
	<s:form>
		<table class="brwsr2">
			<tbody>
				<tr>
					<th>ID</th>
					<th>タイトル</th>
					<th>シリーズ</th>
					<th>登録日</th>
					<th>更新日</th>
					<th>登録USERID</th>
					<th>更新USERID</th>
					<th>切り札</th>
					<th>起源</th>
					<th>削除</th>
				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						<td><s:property value="id" /></td>
						<td class="data"><s:property value="title" /></td>
						<td class="data"><s:property value="se" /></td>
						<td class="data"><s:property value="u" /></td>
						<td class="data"><s:property value="upDay" /></td>
						<td class="data"><s:property value="userId" /></td>
						<td class="data"><s:property value="upUser" /></td>
						<td class="data"><s:property value="nonStyle" /></td>
						<td class="data"><s:property value="del" /></td>
						<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="delete" name="delete_id" value="削除"
					cssClass="btn btn-primary" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />