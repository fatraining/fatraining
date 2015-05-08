<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{delete_id==null}">
	<h3>新しく食事について登録します</h3>
	<p class="err"><s:property value="errormsg" /></p>
<s:form cssClass="form-horizontal">

	<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<a href="main10.action">Back</a>
			</div>

			<label class="col-sm-2 control-label"> 年:</label>
			<div class="col-md-2">
				<s:select name="eat_year"
						list="#{'2015':'2015', '2014':'2014','2013':'2013', '2012':'2012','2011':'2011'}"
						cssClass="form-control" />
			</div>
			<label class="col-sm-2 control-label"> 月:</label>
			<div class="col-md-2">
				<s:select name="eat_month"
						list="#{'1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10','11':'11','12':'12'}"
						cssClass="form-control" />
			</div>
			<br /> <br /> <br /> 
			<label class="col-sm-2 control-label"> 日:</label>
			<div class="col-md-2">
				<s:select name="eat_day"
						list="#{'1':'1', '2':'2','3':'3','4':'4','5':'5','6':'6', '7':'7','8':'8','9':'9','10':'10','11':'11','12':'12','13':'13','14':'14','15':'15','16':'16','17':'17','18':'18','19':'19','20':'20','21':'21','22':'22','23':'23','24':'24','25':'25','26':'26','27':'27','28':'28','29':'29','30':'30','31':'31'}"
						cssClass="form-control" />
			</div>
			<label class="col-sm-2 control-label">AM/PM:</label>
			<div class="col-md-2">
				<s:select name="eat_hour"
						list="#{'AM':'AM', 'PM':'PM'}"
						cssClass="form-control" />
			</div>
			<br /> <br /> <br /> <hr /> <br />
			<label class="col-sm-2 control-label"> 食べ物:</label>
			<div class="col-md-2">
				<s:textfield name="eatFood" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> カロリー:</label>
			<div class="col-md-2">
				<s:textfield name="eatCalory" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<br /><br /> <br />
			<hr />

	</div>


	</s:form>
</s:if>
<s:if test="%{delete_id!=null}">
	<h3>さっきクリックした食事のデータを削除済ます</h3>
	<td class="data">削除するレコード ID:<s:property value="delete_id" /></td>
	<s:form cssClass="form-horizontal">
			<s:submit method="delete" value="削除" cssClass="btn btn-primary"/>
			<a href="main10.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />