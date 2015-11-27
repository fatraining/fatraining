<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<p class="text-right"><a href="menu.action">Back</a></p>
<h1 class="h3 text-center">ゲーム検索</h1>
<s:form cssClass="form-horizontal">
	<div class="text-right">
		<s:property value="UserID" />
		さん
	</div>

	<div class="form-group">
		<label for="main13_Name" class="col-sm-2 control-label">タイトル:</label>
		<s:textfield name="Name" cssClass="form-control"/>
	</div>
	<div class="form-group">
		<label for="main13_Genre" class="col-sm-2 control-label">ジャンル:</label>
		<s:textfield name="Genre" cssClass="form-control"/>
	</div>
	<div class="form-group">
		<label for="main13_Hardware" class="col-sm-2 control-label">機種:</label>
		<s:textfield name="Hardware" cssClass="form-control"/>
	</div>
	
	<div>
		<s:submit method="search" value="検索" cssClass="btn btn-info btn-block" />
	</div>
	<div class="row" style="padding:10px 0;">
		<div class="col-xs-6"><s:submit method="reset" value="リセット" cssClass="btn btn-danger btn-block" /></div>
		<div class="col-xs-6"><s:submit method="update" value="追加" cssClass="btn btn-primary btn-block" /></div>
		
		
	</div>

		<s:if test="%{errormsg=='true'}">
			<span style="color: red">
				<h1 class="h5">削除する項目を選択してください。</h1>
			</span>
		</s:if>
	</div>
</s:form>
<s:if test="%{do_search=='true'}">
	<h1>結果↓</h1>
	<s:form>
		<table class="brwsr2">
			<tbody>
				<tr>
					<th>タイトル</th>
					<th>ジャンル</th>
					<th>会社</th>
					<th>機種</th>
					<th>コメント</th>
					<th>削除</th>
				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						
						<td class="data"><s:property value="Name" /></td>
						<td class="data"><s:property value="Genre" /></td>
						<td class="data"><s:property value="Company" /></td>
						<td class="data"><s:property value="Hardware" /></td>
						<td class="data"><s:property value="Comment" /></td>
						<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="ID" /> />
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