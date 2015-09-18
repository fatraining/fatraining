<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>製作者</h3>
<s:form cssClass="form-horizontal">



	<div class="form-group">
		<label class="col-sm-2 control-label">社名:<br />
		</label>
		<div class="col-md-8">
			<s:textfield name="syamei" cssClass="form-control" rows="1" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">名前:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="name" cssClass="form-control" rows="1" />
		</div>

		<label class="col-sm-2 control-label">部署:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="busyo" cssClass="form-control" rows="1" />
		</div>
	</div>


	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-warning" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-danger" />
		<s:submit method="update" value="追加" cssClass="btn btn-success" />
		
		<a href="menu.action">Back</a>

		<!--<s:submit method="printall" value="全件リスト" cssClass="btn btn-primary" />-->
		
		<s:if test="%{errormsg=='true'}">
			<span style="color: red">
				<h5>＊削除する項目を選択してください</h5>
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
					<th>社名</th>
					<th>名前</th>
					<th>入社日</th>
					<th>部署</th>
					<th>コメント</th>
						<th>削除</th>

				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						<td class="data"><s:property value="syamei" /></td>
						<td class="data"><s:property value="name" /></td>
						<td class="data"><s:property value="nyusyabi" /></td>
						<td class="data"><s:property value="busyo" /></td>
						<td class="data"><s:property value="comment" /></td>
						<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> /></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="delete_id" name="delete_id" value="削除"
					cssClass="btn btn-info" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />