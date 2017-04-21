
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<jsp:include page="/headercopy.jsp" />
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/bootswatch-paper.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/libs/raty/jquery.raty.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/copy.css"/>"/>
	<body>
		<div class="container">
			<jsp:include page="/logo.jsp" />
			<div class="sub-header">
			<Marquee behavior="alternate">
		<s:property value="TitleName" />
		</Marquee>
			<p class="text-right">
				<s:property value="userId" />
				さん
					<a href="<s:url action="copyDelete" method="back" />">Back</a>
				</p>
				<img src="./assets/images/temp/copy_delete.jpg">
			</div>

			<s:if test="%{resultList.size!=0}">
			<s:form>
			<div class="resultArea col-xs-12 col-sm-12 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2 delete ">
				<table id="resultTable" class="table table-borderd table-striped table-hover">
					<thead>
						<tr>
							<th class="per-12 center">コピー名</th>
							<th class="per-12 center">初登場作品</th>
							<th class="per-12 center">初登場日</th>
							<th class="per-7 center">登場回数</th>
							<th class="per-12 center">画像</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="resultList">
						<tr>
							<td class="data center"><s:property value="name" /></td>
							<td class="data center"><s:property value="title.name" /></td>
							<td class="data center"><s:property value="title.releasedate" /></td>
							<td class="data center"><s:property value="appearance" /></td>
							<td class="data center"><a href="./assets/images/temp/<s:property value="img_path" />">
									<img
										src="./assets/images/temp/<s:property value="img_path" />"class = "tablewidth"></a></td>
						</tr>
						</s:iterator>
					</tbody>
				</table>
				<div align=right>
					<s:submit id="deleteBtn" method="delete" value="わすれる？" cssClass="btn btn-danger" />
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
		<script type="text/javascript" src="<s:url value="/assets/js/copy.js"/>"></script>
	</body>
</html>