<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<link href="assets/css/event.css" rel="stylesheet" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
    $('textarea').bind('keydown keyup keypress change',function(){
        var thisValueLength = $(this).val().length;
        $('.count').html(thisValueLength);
    });
});
</script>
</head>
<body>
<DIV id="Header_area" >
	<div class="container">
		<h2><a href="login.action" title="ログイン画面に戻る">研修Webアプリ</a><small>ver β
		<a href="eventStageSearch.action" title="検索画面に戻る">＜リリイベ会場検索＞</a></small></h2>
	</div>
</DIV>
<div class="container">

	<s:if test="%{delete==null}">
		<br><br>
		<div class=text-center>
			<h4 class="split"><strong>新しいデータを入力してください。</strong></h4>
		</div>
		<br>
		<div style="color: red">
			<s:actionerror class="error" />
		</div>
		<p class="error">
			<s:property value="errorMessage" />
		</p>

		<s:form cssClass="form-horizontal">
		<s:hidden name="ID"></s:hidden>
				<div class="form-group">
					<label for="name" class="col-sm-2 control-label">会場名称：</label>
					<div class="col-md-8">
					<s:textfield name="name" cssClass="form-control" placeholder="20文字以下で入力してください"/>
					</div>
				</div>
				<div class="form-group">
					<label for="station" class="col-sm-2 control-label">最寄駅名：</label>
					<div class="col-md-8">
					<s:textfield name="station" cssClass="form-control" placeholder="「駅」は不要です"/>
					</div>
				</div>
				<div class="form-group">
					<label  class="col-sm-2 control-label">エリア：</label>
					<div class="col-md-8">
						<s:select cssClass="form-control" name="areaID"
						 list="eventAreaMap"/>
					</div>
				</div>
				<div class="form-group">
					<label for="record" class="col-sm-2 control-label">レコード店：</label>
					<div class="col-md-8">
						<s:select cssClass="form-control" name="record"
							list="recordMap" />
					</div>
				</div>
				<div class="form-group">
					<label for="comment" class="col-sm-2 control-label">コメント：</label>
					<div class="col-md-8">
						<s:textfield name="comment" cssClass="form-control"
									placeholder="40文字以下で入力してください（枠幅が約35文字分）"/>
					</div>
				</div>

				<div class="form-group">
				<div class="col-md-offset-2 col-md-8">
				<s:submit method="update" value="%{updateBtnTitle}"
					cssClass="form-control btn btn-info" />
				</div>
			</div>

		</s:form>
	</s:if>
</div>
</body>
</html>