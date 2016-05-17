
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<jsp:include page="/header.jsp" />
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/bootswatch-paper.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/libs/raty/jquery.raty.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/harasan.css"/>"/>
	<body>
		<div class="container">
			<jsp:include page="/logo.jsp" />
			<div class="sub-header">
				<s:property value="title" />
				<p class="text-right">
					<s:property value="userId" /> さん
					<a href="<s:url action="restaurantDelete" method="back" />">Back</a>
				</p>
			</div>

			<s:if test="%{resultList.size!=0}">
			<s:form>
			<div class="resultArea col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2 ">
				<table id="resultTable" class="table table-borderd table-striped table-hover">
					<thead>
						<tr>
							<th class="per-12 center">店舗名</th>
							<th class="per-12 center">エリア名</th>
							<th class="per-16 center">評価</th>
							<th class="per-46 center">コメント</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="resultList">
						<tr>
							<td class="data center"><s:property value="name" /></td>
							<td class="data center"><s:property value="area.name" /></td>
							<td class="data"><div class="stars-readOnly" value="<s:property value="stars"/>"></div></td>
							<td class="data"><s:property value="comment" /></td>
						</tr>
						</s:iterator>
					</tbody>
				</table>
				<div align=right>
					<s:submit id="deleteBtn" method="delete" value="削除したデータは二度と復元出来ないことを覚悟して削除" cssClass="btn btn-danger" />
				</div>
			</div>
			</s:form>
			</s:if>
			<s:else>
			<p class="err text-right">
				<s:actionerror class="err"/>
			</p>
			</s:else>
		</div>
		<script type="text/javascript" src="<s:url value="/assets/libs/raty/jquery.raty.js"/>"></script>
		<script type="text/javascript" src="<s:url value="/assets/js/harasan.js"/>"></script>
	</body>
</html>