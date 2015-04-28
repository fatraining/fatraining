

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>条件に一致するプロフィールを検索します。</h3>
<s:form cssClass="form-horizontal">
	<div align=right>
		<s:property value="user_name" />
		さん
	</div>


	<div class="form-group">
		<label class="col-sm-2 control-label">住所:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="dwelling" cssClass="form-control" rows="1" />
		</div>

		<label class="col-sm-2 control-label">名前:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="name" cssClass="form-control" rows="1" />
		</div>

	</div>


	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-info" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-info" />
		<s:submit method="update" value="追加" cssClass="btn btn-info" />

		<!--<s:submit method="printall" value="全件リスト" cssClass="btn btn-primary" />-->
	</div>
</s:form>


<s:if test="%{do_search=='true'}">
	<h3>結果↓</h3>
	<s:form>
		<table class="brwsr2">
			<tbody>
				<tr>
					<th>Id</th>
					<th>電話番号</th>

					<th>郵便番号</th>

					<th>住所</th>

					<th>名前</th>

					<th>性格</th>

					<th>登録日時</th>

					<th>更新日時</th>

					<th>登録USERID</th>

					<th>更新USERID</th>

					<th>削除</th>

				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						<td class="data"><s:property value="id" /></td>
						<td class="data"><s:property value="phonenumber" /></td>
						<td class="data"><s:property value="zipcode" /></td>
						<td class="data"><s:property value="dwelling" /></td>
						<td class="data"><s:property value="name" /></td>
						<td class="data"><s:property value="personality" /></td>
						<td class="data"><s:property value="day" /></td>
						<td class="data"><s:property value="newday" /></td>
						<td class="data"><s:property value="userid" /></td>
						<td class="data"><s:property value="newuserid" /></td>
						<td class="data"><input type="checkbox" name="update_id"
							value=<s:property value="id" /> /></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="update5" name="update_id" value="削除"
					cssClass="btn btn-info" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />




