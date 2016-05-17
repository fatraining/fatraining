<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<jsp:include page="header.jsp"/>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="sortable_ja.js"></script>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/hpivent.css"/>"/>

	<body>

	<div class="bgslideshow">
	<img src="http://localhost:8080/WebAppTraining/assets/images/hpivent/harocon1.jpg" width="730px" height="440px" alt="" />
	<img src="http://localhost:8080/WebAppTraining/assets/images/hpivent/harocon2.jpg" width="1260px" height="670px" alt="" />
	<img src="http://localhost:8080/WebAppTraining/assets/images/hpivent/musumegradation.jpg" width="600px" height="315px" alt="" />
	</div>


		<div class="container">
			<jsp:include page="logo.jsp" />
			<p class="text-right"> <a href="menu.action">Back</a></p>
			<h2 class="h3 text-center"><FONT color="#fff">H!Pイベント検索</FONT></h2>

		<s:form cssClass="form-horizontal" id="searchCondition">
		<div class="text-right">
			<s:property value="userId" />
			さん
		</div>


		<div class="form-group">
			<div class="col-md-6">
				<label for="グループ名" class="control-label">グループ名:</label><br>
				<s:textfield name="groupName" cssClass="form-control"  />
			</div>
			<div class="col-md-6">
				<label for="分類" class="control-label" >分類:</label><br>
				<s:select class="select" name="category" value="category"
				list="#{'':'選択なし','コンサート':'コンサート　　　　　　　　　　　　　　　　　　　','即売系':'即売系','個別系':'個別系','その他':'その他'}"/>
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-6">
				<label for="名称" class="control-label">名称:</label><br>
				<s:textfield name="iventName" cssClass="form-control"  />
			</div>
			<div class="col-md-6">
				<label for="場所" class="control-label">場所:</label><br>
				<s:textfield name="place" cssClass="form-control"  />
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-6">
				<label for="日時1" class="control-label">日時:</label><br>
				<s:textfield name="day1" cssClass="form-control" placeholder="yyyyMMddHHmm～" />
			</div>
			<div class="col-md-6">
				<label for="日時2" class="control-label">　</label><br>
			<s:textfield name="day2" cssClass="form-control" placeholder="yyyyMMddHHmm" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-md-12">
			<label for="備考" class="control-label">備考:</label><br>
			<s:textfield name="comment" cssClass="form-control"  />
			</div>
		</div>

		<div class="form-group">
		<div class="search">
			<div class="row" style="margin-left:20%; margin-right:20%;">
				<div class="col-md-3" style="width:100%;">
					<s:submit method ="search" value="検索"
						cssClass="btn btn-default btn-block"/>
				</div>
			</div>
		</div>

		<div class="form-group">
			<div class="row"style="margin-left:19%; margin-right:19%; padding:2%">
				<div class="col-md-3" style="width:50%;">
					<s:submit method ="reset" value="リセット"
						cssClass="btn btn-primary btn-block"/>
				</div>
				<div class="row" style="margin-left:51%; margin-right:0%;">
					<div class="col-md-3" style="width:100%;">
						<s:submit method="update" value="追加"
							cssClass="btn btn-danger btn-block" />
					</div>
				</div>
			</div>
		</div>
		</div>

		<div class="bug">
			<div style="color:red;">
				<s:actionerror />
				<s:property value="msg"/>
			</div>


			<s:if test="%{outputTable.size > 0}">

			<div class ="table">
			<table class = "sortable" id = "iventcontents" >
<%-- 				<thead> --%>
					<tr>
						<th>ID</th>
						<th>グループ名</th>
						<th>分類</th>
						<th>名称</th>
						<th>場所</th>
						<th>日時</th>
						<th>備考</th>
						<th>削除</th>
					</tr>
<%--			</thead>--%>
<%--			<tbody>--%>
					<s:iterator value="outputTable">
					<tr>
						<td width="2%"><s:property value="ID"/></td>
						<td width="13%"><s:property value="groupName"/></td>
						<td width="6%"><s:property value="category"/></td>
						<td width="30%"><s:property value="iventName"/></td>
						<td width="20%"><s:property value="place"/></td>
						<td width="10%"><s:property value="day"/></td>
						<td width="30%"><s:property value="comment"/></td>
						<td width="5%"><input type="checkbox" name="delete"
							value="<s:property value="ID"/>:<s:property value= "groupName"/>:<s:property value="iventName" />:<s:property value="place" />:<s:property value="day" />" />
						</td>
					</tr>
					</s:iterator>
<%--			</tbody>--%>
			</table>
			</div>
			<s:if test="%{outputTable.size>0}">
				<div align=right>
					<s:submit method="delete" id="deleteBtn" value="削除"
						cssClass="btn btn-danger"/>
				</div>
			</s:if>
			</s:if>
		</div>
			</s:form>
		</div>


	<script type="text/javascript">
function slideSwitch() {
   var $active = $('#slideshow p.active');

   if ( $active.length == 0 ) $active = $('#slideshow p:last');

   var $next =  $active.next().length ? $active.next()
      : $('#slideshow p:first');

   $active.addClass('last-active');

   $next.css({opacity: 0.0})
      .addClass('active')
      .animate({opacity: 1.0}, 1000, function() {
         $active.removeClass('active last-active');
      });
}

$(function() {
   setInterval( "slideSwitch()", 3000 );
});

</script>

<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('.bgslideshow img:gt(0)').hide();
	setInterval(function(){
		$('.bgslideshow :first-child').fadeOut(3000)
		.next('img').fadeIn(3000)
		.end().appendTo('.bgslideshow');
	}, 5000);
	});
</script>



</body>
</html>