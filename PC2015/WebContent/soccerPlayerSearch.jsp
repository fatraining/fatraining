<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />
<p class="text-right"><a href="menu.action">Back</a></p>
<h1 class="h3 text-center">【サッカーの各国代表】から【選手】を検索します</h1>
<s:form cssClass="form-horizontal">
	<div class="text-right">
		<s:property value="userId" />
		さん
	</div>

	<div class="form-group">
		<label for="SoccerPlayerSearch_name" class="col-sm-2 control-label">国代表名:</label>
		<div class="col-xs-6"><s:textfield name="name" cssClass="form-control"/></div>
	</div>
	<div class="form-group">
		<label for="SoccerPlayerSearch_number" class="col-sm-2 control-label">背番号:</label>
		<div class="col-xs-6"><s:textfield name="number" cssClass="form-control"/></div>
	</div>

	<div class="row" style="padding:10px 0;">
		<div class="col-xs-2"><s:submit method="search" value="検索" cssClass="btn btn-info btn-block" /></div>
		<div class="col-xs-2"><s:submit method="reset" value="リセット" cssClass="btn btn-danger btn-block" /></div>
		<div class="col-xs-2"><s:submit method="update" value="追加" cssClass="btn btn-primary btn-block" /></div>
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
					<th>背番号</th>
					<th>名前</th>
					<th>代表国</th>
					<th>ポジション</th>
					<th>削除</th>
				</tr>
				<td class="bar" colspan="16"></td>
				<s:iterator value="outputTable">
					<tr>
						<td class="data"><s:property value="number" /></td>
						<td class="data"><s:property value="name" /></td>
						<td class="data"><s:property value="teamName" /></td>
						<td class="data"><s:property value="position" /></td>
						<td class="data"><input type="checkbox" name="delete_id"
							value=<s:property value="id" /> />
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