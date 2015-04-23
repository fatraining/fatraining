<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>条件に一致するコンピュータを検索します。</h3>
<s:form cssClass="form-horizontal">


	<div class="form-group">
	<label class="col-md-2 control-label" > お菓子の名前:</label>
			<div class="col-md-5">
				<input name="name" class="form-control valid" type="text" >
			</div>
			<br><br>
			<label class="col-md-2 control-label" > ジャンル:</label>
			<div class="col-md-5">
				<input name="genreNm" class="form-control valid" type="text" >
			</div>
			<br><br>
	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-primary" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-primary" />
		<s:submit method="update" value="追加" cssClass="btn btn-primary" />
		<a href="menu.action">Back</a>

		<!--<s:submit method="printall" value="全件リスト" cssClass="btn btn-primary" />-->
	</div>
	</div>
</s:form>


<s:if test="%{do_search=='true'}">
	<h3>結果↓</h3>
	<s:form>
		<table class="brwsr2">
			<tbody>
				<tr>
					<th>名前</th>
					<th>ジャンル</th>
					<th>登録日付</th>
					<th>更新日付</th>
					<th>登録USERID</th>
					<th>更新USERID</th>
					<th>排他</th>
					<th>削除</th>

				</tr>
				<td class="bar" colspan="16" ></td>
				<s:iterator value="outputTable">
					<tr>
						<td class="data"><s:property value="name" /></td>
						<td class="data"><s:property value="genreNm" /></td>
						<td class="data"><s:property value="record_date" /></td>
						<td class="data"><s:property value="reset_date" /></td>
						<td class="data"><s:property value="entry_userId" /></td>
						<td class="data"><s:property value="record_userId" /></td>
						<td class="data"><s:property value="exclusive_FLG" /></td>
						<td class="data"><s:property value="delet_FLG" /></td>
						<td class="data"><input type="checkbox" name="update_id"
							value=<s:property value="id" /> /></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="update" name="update_id" value="削除"
					cssClass="btn btn-primary" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />