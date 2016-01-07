
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<jsp:include page="facloudHeader.jsp" />
			<div id="summary">
			
				<div class="select_month">
					<span class="lt">&lt;</span>
					<span class="chosen_month">2015年12月▼</span>
					<span class="gt">&gt;</span>
				</div>
				
				<div class="total_col">
					<p>総労働時間<br />7:45</p>
					<p>残業時間<br />0:00</p>
				</div>
				<div class="total_col">
					<p>遅刻時間<br />8:00</p>
					<p>早退時間<br />0:15</p>
				</div>
				<div class="total_col">
					<p>欠勤回数<br />18</p>
					<p>未集計<br />0</p>
				</div>
				<div class="total_col">
					<p>未集計<br />0</p>
					<p>未集計<br />0</p>
				</div>
			</div>
			
			<s:form data-action="gotoAttendanceUpdate">
				<s:hidden name="id"/>
				<table id="attendance_table">
					<tr>
						<th>日付</th>
						<th>出社</th>
						<th>退社</th>
						<th>労働時間</th>
						<th>備考</th>
						<th>修正</th>
					</tr>
					<tr>
						<td>2015/12/01(火)</td>
						<td>09:00</td>
						<td>18:00</td>
						<td>8:00</td>
						<td>とくにない</td>
						<td><a data-id="1">修正</a></td>
					</tr>
					<tr>
						<td>2015/12/01(火)</td>
						<td>09:00</td>
						<td>18:00</td>
						<td>8:00</td>
						<td>とくにない</td>
						<td><a data-id="2">修正</a></td>
					</tr>
					<tr>
						<td>2015/12/01(火)</td>
						<td>09:00</td>
						<td>18:00</td>
						<td>8:00</td>
						<td>とくにない</td>
						<td><a href="#">修正</a></td>
					</tr>
					<tr>
						<td>2015/12/01(火)</td>
						<td>09:00</td>
						<td>18:00</td>
						<td>8:00</td>
						<td>とくにない</td>
						<td><a href="#">修正</a></td>
					</tr>
					<tr>
						<td>2015/12/01(火)</td>
						<td>09:00</td>
						<td>18:00</td>
						<td>8:00</td>
						<td>とくにない</td>
						<td><a href="#">修正</a></td>
					</tr>
				
				</table>
			</s:form>
	
<script>

$(function(){
	$("#attendance_table a").click(function(){
		// idの取得とセット
		var param = $(this).attr("data-id");
		var form = $("#facloudTimecard");
		form.find("input[type='hidden']").attr("value",param);
	
		// アクションメソッドの指定
		var action = form.attr("id")
					+ "!" + form.attr("data-action");
		document.facloudTimecard.action = action;
		
		// サブミット
		document.facloudTimecard.submit();
		
	});
	
})

</script>
	<jsp:include page="facloudFooter.jsp" />
				