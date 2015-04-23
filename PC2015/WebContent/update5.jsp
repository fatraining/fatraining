<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" />

<s:if test="%{update_id==null}">
	<h3>新しく趣味を登録します</h3>
	<p class="err"><s:property value="errormsg" /></p>
<s:form cssClass="form-horizontal">

	<div class="form-group">

			<div align=right>
				<s:submit method="insert" value="追加" cssClass="btn btn-primary" />
				<a href="main5.action">Back</a>
			</div>

			<label class="col-sm-2 control-label"> Id:</label>
			<div class="col-md-3">
				<s:textfield name="seriesName" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> 性格:</label>
			<div class="col-md-3">
				<s:textfield name="pcType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> 趣味:</label>
			<div class="col-md-3">
				<s:textfield name="pcType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> 登録日付:</label>
			<div class="col-md-3">
				<s:textfield name="pcType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> 更新日付:</label>
			<div class="col-md-3">
				<s:textfield name="pcType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> 登録UserId:</label>
			<div class="col-md-3">
				<s:textfield name="pcType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> 更新UserId:</label>
			<div class="col-md-3">
				<s:textfield name="pcType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> 削除:</label>
			<div class="col-md-3">
				<s:textfield name="pcType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label">　排他FLG:</label>
			<div class="col-md-3">
				<s:textfield name="pcType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			
			
			
			
			
		<br/><br/><br/>
		<hr/>
			<label class="col-sm-2 control-label"> CPU種類:</label>
			<div class="col-md-3">
				<s:textfield name="cpuType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<br /> <br /> <br /> <label class="col-sm-2 control-label">
				CPUコア数:</label>
			<div class="col-md-3">

			<s:select name="coreNum" list="{1,2,4,8,16,32,64}" cssClass="form-control" />

			</div>
			<label class="col-sm-2 control-label"> CPU周波数:</label>
			<div class="col-md-3">
				<s:textfield name="cpuFrequency" cssClass="form-control" rows="10" maxlength="50" />
			</div>
		<br/><br/><br/>
		<hr/>
			<label class="col-sm-2 control-label"> メモリ容量:</label>
			<div class="col-md-2">
				<s:textfield name="memory" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> メモリ種類:</label>
			<div class="col-md-3">
				<s:textfield name="memoryType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<br /> <br /> <label class="col-sm-2 control-label">L2キャッシュ:</label>
			<div class="col-md-2">
				<s:textfield name="L2c" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label">L3キャッシュ:</label>
			<div class="col-md-2">
				<s:textfield name="L3c" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<br /> <br /> <label class="col-sm-2 control-label"> 最大メモリ:</label>
			<div class="col-md-2">
				<s:textfield name="memoryMax" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label"> スロット数:</label>
			<div class="col-md-2">
				<s:select name="memorySlots" list="{0,1,2,3,4,5,6,7,8,9,10}" cssClass="form-control" />
			</div>
			<label class="col-sm-2 control-label">空スロット数:</label>
			<div class="col-md-2">
				<s:select name="memory_slot_empty_Num" list="{0,1,2,3,4,5,6,7,8,9,10}" cssClass="form-control" />
			</div>
		<br/><br/><br/>
		<hr/>
			<label class="col-sm-2 control-label">ビデオチップ:</label>
			<div class="col-md-3">
				<s:textfield name="gpuType" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<label class="col-sm-2 control-label">ビデオメモリ:</label>
			<div class="col-md-2">
				<s:textfield name="gpuMemory" cssClass="form-control" rows="10" maxlength="50" />
			</div>
			<br />
			<hr />

	</div>


	</s:form>
</s:if>
<s:if test="%{update_id!=null}">
	<h3>さっきクリックしたパソコンのデータを削除済ます</h3>
	<td class="data">削除するレコード ID:<s:property value="update_id" /></td>
	<s:form cssClass="form-horizontal">
			<s:submit method="delete" value="削除" cssClass="btn btn-primary"/>
			<a href="main5.action">Back</a>
	</s:form>

</s:if>
<jsp:include page="footer.jsp" />