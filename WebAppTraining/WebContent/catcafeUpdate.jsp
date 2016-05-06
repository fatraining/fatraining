<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="/header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/yamazaki.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/yamazakiUpdate.css"/>" />
<style>

</style>

 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/yamazaki.js"/>"></script>
<script type="text/javascript">
$(function () {
  $('span').hover(function() {
    $(this).next('p').show();
  }, function(){
    $(this).next('p').hide();
  });
});
</script>
<body>

	<div class="container">
		<jsp:include page="/logo.jsp" />
		<s:if test="%{delete==null}">
			<h2 class="split">新しいデータを登録します。</h2>

			<div style="color: red">
				<s:actionerror class="error" />
			</div>

			<p class="error">
				<s:property value="errorMessage" />
			</p>

			<s:form cssClass="form-horizontal">

				<div class="form-group" align=right>
					<a href="catcafeSearch.action">Back</a>
				</div>

				<div class="row form-group">
					<div class="col-md-2"id="text">
						<label for="prefecture" class="control-rabel">都道府県：</label>
					</div>
					<div class="col-md-4">
						<s:select name="prefectureID" cssClass="form-control "
							value="prefectureID" list="prefectureMap" />
					</div>
				</div>
				<hr />

				<div class="form-group">
					<div class="col-md-2" id="text">
						<label class="control-rabel">最寄駅：</label>
					</div>
					<div class="col-md-4">
						<s:textfield name="station" cssClass="form-control" />
					</div>
				</div>
				<hr />

				<div class="form-group">
					<div class="col-md-2" id="text">
						<label class="control-rabel">店名：</label>
					</div>
					<div class="col-md-4">
						<s:textfield name="catcafeName" cssClass="form-control" />
					</div>
				</div>
				<hr />

				<div class="form-group">
					<div class="col-md-2" id="text">
						<label class="control-rabel">営業時間：</label>
					</div>
					<div class="col-md-4">
						<s:textfield name="hours" cssClass="form-control" />
					</div>
				</div>
				<hr />

				<div class="form-group">
					<div class="col-md-2" id="text">
						<label class="control-rabel">定休日：</label>
					</div>
					<div class="col-md-4">
						<s:textfield name="closed" cssClass="form-control" />
					</div>
				</div>
				<hr />

				<div class="form-group">
					<div class="col-md-2" id="text">
						<label class="control-rabel">コメント：</label>
					</div>
					<div class="col-md-4">
						<s:textfield name="comment" cssClass="form-control" />
					</div>
				</div>

				<div id="pop1">
					<span><img src="assets/images/catSmell.png" alt="catSmell" /></span>
					<p class="arrow_box">登録するよー</p>
				</div>

				<div id="submitBtn">
					<s:submit method="insert" value="追加"
						cssClass="btn btn-lg btn-success" />
				</div>

			</s:form>
		</s:if>

	</div>

	<s:if test="%{delete!=null}">

		<div class="col-md-offset-3">
			<h2 class="split">選択したデータを削除します。</h2>
			<s:form cssClass="form-horizontal">
				<div class="showData">
					削除するデータ：
					<s:property value="delete" />
				</div>


					<div id="pop2">
						<span><img src="assets/images/catStretch.png" alt="catStretch" /></span>
						<p class="arrow_box">消しちゃうの？</p>
					</div>
					<div id="deleteBtn">
						<s:submit method="delete" value="削除" cssClass="btn btn-lg btn-danger" />
					</div><br>
				<div class="back" align="center">
				<a href="catcafeSearch.action">Back</a>
				</div>
			</s:form>
		</div>
	</s:if>
</body>

</html>