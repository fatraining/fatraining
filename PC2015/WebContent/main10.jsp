<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<h3>条件に一致する食事について検索します。</h3>
<s:form cssClass="form-horizontal">

	<div align=right>
		<s:property value="userId" />
		さん
	</div>

	<div class="form-group">
		<label class="col-sm-1 control-label">年:<br />
		</label>
		<div class="col-md-2">
			<s:select name="eat_year" list="{'',2015,2014,2013,2012,2011}"
				 cssClass="form-control" />
		</div>
		<label class="col-sm-1 control-label">月:<br />
		</label>
		<div class="col-md-2">
			<s:select name="eat_month" list="{'',1,2,3,4,5,6,7,8,9,10,11,12}"
				 cssClass="form-control" />
		</div>
		<label class="col-sm-1 control-label">日:<br />
		</label>
		<div class="col-md-2">
			<s:select name="eat_day" list="{'',1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31}"
				cssClass="form-control" />
		</div>

		<label class="col-sm-1 control-label">AM/PM:<br />
		</label>
		<div class="col-md-2">
			<s:select name="eat_hour" list="{'','AM','PM'}"
				 cssClass="form-control" />
		</div>
	</div>


	<div class="col-sm-offset-2 col-sm-10">
		<s:submit method="search" value="検索" cssClass="btn btn-primary" />
		<s:submit method="reset" value="リセット" cssClass="btn btn-primary" />
		<s:submit method="update" value="追加" cssClass="btn btn-primary" />
		<br />
		<br /> <a href="menu.action">Back</a>

		<!--<s:submit method="searchall" value="全件リスト" cssClass="btn btn-primary" />-->
	</div>
</s:form>


<s:if test="%{do_search=='true'}">
	<h3>結果↓</h3>
	<s:form>
		<table class="brwsr2">
			<tbody>
				<tr>
					<th>年</th>
					<th>月</th>
					<th>日</th>
					<th>AM/PM</th>
					<th>食べ物</th>
					<th>カロリー</th>
					<th>削除</th>

				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						<td class="data"><s:property value="eat_year" /></td>
						<td class="data"><s:property value="eat_month" /></td>
						<td class="data"><s:property value="eat_day" /></td>
						<td class="data"><s:property value="eat_hour" /></td>
						<td class="data"><s:property value="eatFood" /></td>
						<td class="data"><s:property value="eatCalory" /></td>
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