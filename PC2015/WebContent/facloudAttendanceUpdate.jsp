
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<jsp:include page="facloudHeader.jsp" />
		<s:if test="errMsg != null">
			<p class="err_msg"><s:property value="errMsg" /></p>
		</s:if>
			<form id="attendance_update">
				<p id="datetime"><s:property value="date" /></p>
				<fieldset>
					<label><span>出社時刻</span><input type="text" name="inTime" value="<s:property value="inTime" />" placeholder="出社時刻 hh:mm"></label>
					<label><span>退社時刻</span><input type="text" name="outTime" value="<s:property value="outTime" />" placeholder="退社時刻 hh:mm"></label>
					<label class="remarks"><span>備　　考</span><textarea name="comment" placeholder="備考入力（遅刻の理由などを140文字まで)"><s:property value="comment" /></textarea></label>
				</fieldset>
				<s:submit method="update" value="修正するンゴ～"/>
			</form>
				
	
	<jsp:include page="facloudFooter.jsp" />
				