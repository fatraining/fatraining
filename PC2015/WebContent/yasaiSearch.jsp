
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>【野菜】から【料理】を検索します。</h3>
<s:form cssClass="form-horizontal">
	<div align=right>
		<s:property value="userId" />
		さん
	</div>


	<div class="form-group">
		<label class="col-sm-2 control-label">野菜:<br />
		</label>
		<div class="col-md-8">
			<s:textfield name="yasai" cssClass="form-control" rows="1" />
		</div>
	</div>
	




		<div class="col-sm-offset-2 col-sm-10">
			<s:submit method="search" value="検索" cssClass="btn btn-primary" />
			<s:submit method="reset" value="リセット" cssClass="btn btn-warning" />
			<s:submit method="update" value="追加" cssClass="btn btn-success" />

			<!--<s:submit method="printall" value="全件リスト" cssClass="btn btn-primary" />-->
		</div>
</s:form>
<s:if test="%{do_print=='true'}">
	<h3>結果↓</h3>
	<s:form>
		<table class="brwsr2">
			<tbody>
				<tr>
					<th>野菜</th>
					<th>調理方</th>
					<th>料理名</th>
					<th>登録ユーザー</th>
					<th>削除</th>

				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						<td class="data"><s:property value="yasai" /></td>
						<td class="data"><s:property value="tyouri" /></td>
						<td class="data"><s:property value="ryouri" /></td>
						<td class="data"><s:property value="userId" /></td>
						<td class="data"><input type="checkbox" name="update_id"
							value=<s:property value="id" /> /></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="update" name="update_id" value="削除"
					cssClass="btn btn-danger" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />