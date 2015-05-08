<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>条件に一致する人を検索します。</h3>
<s:form cssClass="form-horizontal">

	<div class="form-group">
		<label class="col-sm-2 control-label">名前: </label>
		<div class="col-md-8">
			<s:textfield name="name" cssClass="form-control" rows="10" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">食べ物: </label>
		<div class="col-md-3">
			<s:textfield name="food" cssClass="form-control" rows="10" />
		</div>

		<label class="col-sm-2 control-label">飲み物: </label>
		<div class="col-md-3">
			<s:textfield name="drink" cssClass="form-control" rows="10" />
		</div>
	</div>


	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-info" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-default" />
		<s:submit method="update" value="追加" cssClass="btn btn-success" />

		<a href="menu.action">Back</a>

		<!--<s:submit method="searchall" value="全件リスト" cssClass="btn btn-primary" />-->
	</div>
</s:form>


<s:if test="%{do_search=='true'}">
	<h3>結果↓</h3>
	<s:form>
		<table class="brwsr2">
			<tbody>
				<tr>
					<th>名前</th>
					<th>食べ物</th>
					<th>飲み物</th>
					<th>色</th>
					<th>削除</th>

				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						<td class="data"><s:property value="name" /></td>
						<td class="data"><s:property value="food" /></td>
						<td class="data"><s:property value="drink" /></td>
						<td class="data"><s:property value="colorNm" /></td>
						<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> /></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="delete_id" name="delete_id" value="削除"
					cssClass="btn btn-danger" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />