<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>プロフィール</h3>
<s:form cssClass="form-horizontal">



	<div class="form-group">
		<label class="col-sm-2 control-label">名前:<br />
		</label>
		<div class="col-md-8">
			<s:textfield name="name" cssClass="form-control" rows="1" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">出身地:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="home" cssClass="form-control" rows="1" />
		</div>

		<label class="col-sm-2 control-label">趣味:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="hobby" cssClass="form-control" rows="1" />
		</div>
	</div>


	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-primary" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-primary" />
		<s:submit method="delete_id" value="追加" cssClass="btn btn-primary" />
		
		<a href="menu.action">Back</a>

		<!--<s:submit method="printall" value="全件リスト" cssClass="btn btn-primary" />-->
	</div>
</s:form>


<s:if test="%{do_search=='true'}">
	<h3>結果↓</h3>
	<s:form>
		<table class="brwsr2">
			<tbody>
				<tr>
					<th>名前</th>
					<th>性格</th>
					<th>出身地</th>
					<th>誕生日</th>
					<th>趣味</th>
					<th>登録日時</th>
					<th>更新日時</th>
					<th>登録USER</th>
					<th>更新USER</th>
						<th>削除</th>

				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						<td class="data"><s:property value="name" /></td>
						<td class="data"><s:property value="personality" /></td>
						<td class="data"><s:property value="home" /></td>
						<td class="data"><s:property value="birthday" /></td>
						<td class="data"><s:property value="hobby" /></td>
						<td class="data"><s:property value="day" /></td>
						<td class="data"><s:property value="new_day" /></td>
						<td class="data"><s:property value="userid" /></td>
						<td class="data"><s:property value="new_userid" /></td>
						<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> /></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>
		<th>※複数削除はできません。</th>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="delete_id" name="delete_id" value="削除"
					cssClass="btn btn-primary" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />