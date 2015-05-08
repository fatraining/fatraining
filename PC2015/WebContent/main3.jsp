
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>条件に一致する小説を検索します。</h3>
<s:form cssClass="form-horizontal">
	<div align=right>
		<s:property value="user_name" />
		さん
	</div>


	<div class="form-group">
		<label class="col-sm-2 control-label">タイトル:<br />
		</label>
		<div class="col-md-8">
			<s:textfield name="title" cssClass="form-control" rows="1" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">ジャンル:<br />

		</label>
		<div class="col-md-3">
			<s:textfield name="genre" cssClass="form-control" rows="1" />
		</div>

		
	</div>


	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-primary" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-primary" />
		<s:submit method="add" value="追加" cssClass="btn btn-primary" />
		<a href="menu.action">Back</a>
    	<!--<s:submit method="printall" value="全件リスト" cssClass="btn btn-primary" />-->
	</div>
</s:form>


<s:if test="%{do_print=='true'}">
	<h3>結果↓</h3>
	<s:form>
	<table class="brwsr2">
		<tbody>
			<tr>
				<th>タイトル</th>
				<th>ジャンル</th>
				<th>削除</th>

			</tr>
			<td class="bar" colspan="16"></td>
			<s:iterator value="outputTable">
				<tr>
					<td class="data"><s:property value="title" /></td>
					<td class="data"><s:property value="genre" /></td>
				　　　	
					<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> /></td>	
				
				</tr>
			</s:iterator>
		</tbody>
	</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="delete" name="update_id" value="削除"
					cssClass="btn btn-primary" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />