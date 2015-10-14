<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>条件に一致するスポーツ競技登録者を検索します。</h3>
<s:form cssClass="form-horizontal">
	<div align=right>
		<s:property value="user_name" />
		さん
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">競技番号:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="competition_number"
				cssClass="form-control" rows="1" maxlength="50" />
		</div>

		<label class="col-sm-2 control-label">登録番号:<br />
		</label>
		<div class="col-md-3">
			<s:textfield name="registration_number"
				cssClass="form-control" rows="1" maxlength="50" />
		</div>
	</div>
	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-info" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-danger" />
		<s:submit method="update" value="追加" cssClass="btn btn-primary" />
		<a href="menu.action">Back</a>

		<s:if test="%{errormsg=='true'}">
			<span style="color: red">
				<h5>削除する項目を選択してください。</h5>
			</span>
		</s:if>
	</div>
</s:form>
<s:if test="%{do_search=='true'}">
	<h3>結果↓</h3>
	<s:form>
		<table class="brwsr2">
			<tbody>
				<tr>
					<th>競技番号</th>
					<th>種目</th>
					<th>登録番号</th>
					<th>名前</th>
					<th>削除</th>
				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						
						<td class="data"><s:property value="competition_number" /></td>
						<td class="data"><s:property value="sport" /></td>
						<td class="data"><s:property value="registration_number" /></td>
						<td class="data"><s:property value="name" /></td>
						
						<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> />
						</td>
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