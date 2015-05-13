<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>条件にあったお菓子を検索します。</h3>
<s:form cssClass="form-horizontal">

	<div class="form-group">
		<label class="col-md-2 control-label">お菓子の名前:</label>
		<div class="col-md-5">
			<s:textfield name="name" cssClass="form-control" rows="10" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-md-2 control-label">ジャンル:</label>
		<div class="col-md-5">
			<s:select name="genreNm" list="#{'','焼き菓子':'焼き菓子', '冷菓':'冷菓','チョコレート菓子':'チョコレート菓子'}"
				 cssClass="form-control" />
		</div>
	</div>

	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-danger" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-default" />
		<s:submit method="add" value="追加" cssClass="btn btn-primary" />
		
		<a href="menu.action">Back</a>

		<!--<s:submit method="printall" value="全件リスト" cssClass="btn btn-primary" />-->
		
		
	<s:if test="%{errormsg=='true'}">
	<span style="color: red">
	<h5>項目を１つ以上選択してください</h5>
	</span>
	</s:if>
	
	</div>
</s:form>


<s:if test="%{do_search=='true'}">
	<h3>↓結果↓</h3>
	<s:form>
		<table class="brwsr2">
			<tbody>
				<tr>
					<th>名前</th>
					<th>ジャンル</th>
					<th>削除</th>

				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						<td class="data"><s:property value="name" /></td>
						<td class="data"><s:property value="genreNm" /></td>
						<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> /></td>

					</tr>
				</s:iterator>
			</tbody>
		</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="delete" name="delete_id" value="削除"
					cssClass="btn btn-success" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />