<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<h3>条件に一致する食事についてを検索します。</h3>
<s:form cssClass="form-horizontal">

	<div align=right>
		<s:property value="userId" />
		さん
	</div>

	<div class="form-group">
		<label class="col-sm-1 control-label">年:<br />
		</label>
		<div class="col-md-2">
			<s:textfield name="eat_year" cssClass="form-control" rows="1" />
		</div>
		<label class="col-sm-1 control-label">月:<br />
		</label>
		<div class="col-md-1">
			<s:textfield name="eat_month" cssClass="form-control" rows="1" />
		</div>
		<label class="col-sm-1 control-label">日:<br />
		</label>
		<div class="col-md-1">
			<s:textfield name="eat_day" cssClass="form-control" rows="1" />
		</div>

		<label class="col-sm-1 control-label">AM/PM:<br />
		</label>
		<div class="col-md-2">
			<s:textfield name="eat_hour" cssClass="form-control" rows="1" />
		</div>
	</div>


	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-primary" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-primary" />
		<s:submit method="update" value="追加" cssClass="btn btn-primary" />

		<!--<s:submit method="searchall" value="全件リスト" cssClass="btn btn-primary" />-->
	</div>
</s:form>


<s:if test="%{do_search=='true'}">
	<h3>結果↓</h3>
	<s:form>
	<table class="brwsr2">
		<tbody>
			<tr>
				<th>年</th>
				<th>月</th>
				<th>日</th>
				<th>AM/PM</th>
				<th>食べ物</th>
				<th>カロリー</th>
				<th>登録日付</th>
				<th>更新日付</th>
				<th>登録ユーザー</th>
				<th>更新ユーザー</th>
					<th>削除</th>

			</tr>
			<td class="bar" colspan="16"></td>
			<s:iterator value="outputTable">
				<tr>
					<td class="data"><s:property value="eat_year" /></td>
					<td class="data"><s:property value="eat_month" /></td>
					<td class="data"><s:property value="eat_day" /></td>
					<td class="data"><s:property value="eat_hour" /></td>
					<td class="data"><s:property value="eatFood" /></td>
					<td class="data"><s:property value="eatCalory" /></td>
					<td class="data"><s:property value="entry_day" /></td>
					<td class="data"><s:property value="renew_day" /></td>
					<td class="data"><s:property value="entry_userid" /></td>
					<td class="data"><s:property value="renew_userid" /></td>
					<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> /></td>

				</tr>
			</s:iterator>
		</tbody>
	</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="update" name="delete_id" value="削除"
					cssClass="btn btn-primary" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />