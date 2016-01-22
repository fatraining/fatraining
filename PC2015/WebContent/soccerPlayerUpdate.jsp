<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<p class="text-right"><a href="soccerPlayerSearch.action">Back</a></p>
	<h1 class="h3 text-center">データ新規登録</h1>
	<p class="err">
		<s:property value="errormsg" />
	</p>

	<s:form cssClass="form-horizontal">
				<div class="text-right">
		<s:property value="userId" />
		さん
	</div>

			<div class="form-group">
				<label for="soccerPlayerUpdate_number" class="col-sm-2 control-label"> 背番号:</label>
					<s:textfield name="number" cssClass="form-control" />
			</div>
			<div class="form-group">
				<label for="soccerPlayerUpdate_name" class="col-sm-2 control-label"> 選手名:</label>
					<s:textfield name="name" cssClass="form-control"/>
			</div>
			<div class="form-group">
				<label for="soccerPlayerUpdate_natonalTeamId" class="col-sm-2 control-label"> 代表国名:</label>
					<s:select cssClass="form-control" name="nationalTeamId" list="nationalTeams"/>
			</div>
			<div class="form-group">
				<label for="soccerPlayerUpdate_position" class="col-sm-2 control-label"> ポジション:</label>
					<s:textfield name="position" cssClass="form-control"/>
			</div>

			<s:submit method="insert" value="追加" cssClass="btn btn-success btn-block" />
	</s:form>
</s:if>

<s:if test="%{delete_id!=null}">
	<h3>さっきのデータを削除します</h3>
	<td class="data">削除するデータ:<s:property value="delete_id"/></td>
	<s:form cssClass="form-horizontal">
		<s:submit method="delete" value="削除" cssClass="btn btn-primary " />
		<a href="soccerPlayerSearch.action">Back</a>
		</s:form>
</s:if>

<jsp:include page="footer.jsp" />