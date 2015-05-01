<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<jsp:include page="header.jsp"/>

<h3>条件に一致するバンドグループを検索します。</h3>
<s:form cssClass="form-horizontal">
	<div align=right>
		<s:property value="userId"/>
		さん
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">バンド名:<br/>
		</label>
		<div class="col-md-8">
			<s:textfield name="band_name" cssClass="form-control" rows="1" />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">名前:<br/>
		</label>
		<div class="col-md-4">
			<s:textfield name="name" cssClass="form-control" rows="1" />
		</div>
		<label class="col-sm-2 control-label">演奏楽器:<br/>
		</label>
		<div class="col-md-4">
			<s:textfield name="part" cssClass="form-control" rows="1" />
		</div>
	</div>
	
	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-success" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-inverse" />
		<s:submit method="update" value="追加" cssClass="btn btn-danger" />
		<br/><br/>
			<a href="menu.action">Back</a>
		
		<!-- <s:submit method="printall" value="全件リスト" cssClass="btn btn-primary" />-->
	</div>
</s:form>

<s:if test="%{do_search=='true'}">
	<h3>検索結果 ↓</h3>
	<s:form>
	<table class="brwsr2">
		<tbody>
			<tr>
				<th>バンド名</th>
				<th>名前</th>
				<th>性別</th>
				<th>年齢</th>
				<th>出身校</th>
				<th>好きな曲</th>
				<th>演奏楽器</th>
					<th>削除</th>
			</tr>
			<td class="bar" colspan="16"></td>
			<s:iterator value="outputTable">
				<tr>
					<td class="data"><s:property value="band_name" /></td>
					<td class="data"><s:property value="name" /></td>
					<td class="data"><s:property value="sex" /></td>
					<td class="data"><s:property value="age" /></td>
					<td class="data"><s:property value="school" /></td>
					<td class="data"><s:property value="favorite_song" /></td>
					<td class="data"><s:property value="part" /></td>
						<td class="data"><input type="checkbox" name="delete_id"value=<s:property value="id" />/></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
		<s:if test="%{delete=='true'}">
			<div align=right>
				<s:submit method="delete" name="delete_id" value="削除" cssClass="btn btn-primary" />
			</div>
		</s:if>
	</s:form>
</s:if>
<jsp:include page="footer.jsp" />