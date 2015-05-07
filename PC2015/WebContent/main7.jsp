

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<h3>条件に一致する映画を検索します。</h3>
<s:form cssClass="form-horizontal">
	<div align=right>
		<s:property value="userId" />
		さん
	</div>


	<div class="form-group">
		<label class="col-sm-2 control-label">ジャンル:<br />

		</label>
		<div class="col-md-3">
			<s:select name="genreId" list="#{'','1':'アクション', '2':'アニメ','3':'SF・ファンタジー','4':'コメディ','5':'サスペンス','6':'ホラー','7':'恋愛','8':'その他'}"
				 cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">公開年:<br />

		</label>
		<div class="col-md-2">
			<s:textfield name="exhibition_year" cssClass="form-control" rows="10" />
		</div>

	</div>


	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="print" value="検索" cssClass="btn btn-success" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-inverse" />
		<s:submit method="update" value="追加" cssClass="btn btn-danger" />
			<br/><br/><br/>
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
				<th>公開年</th>
				<th>コメント</th>
					<th>削除</th>

			</tr>
			<td class="bar" colspan="5"></td>
			<s:iterator value="outputTableMovie">
				<tr>
					<td class="data"><s:property value="title" /></td>
					<td class="data"><s:property value="genre" /></td>
					<td class="data"><s:property value="exhibition_year" /></td>
					<td class="data"><s:property value="comment" /></td>
						<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> /></td>

				</tr>
			</s:iterator>
		</tbody>
	</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="delete" name="delete_id" value="削除"
					cssClass="btn btn-primary" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />