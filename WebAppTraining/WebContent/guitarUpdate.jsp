<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="ja">
<jsp:include page="header.jsp" />
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/bootstrap.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/suzuki.css"/>"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div class="container">
			<jsp:include page="logo.jsp" />
				<p class="text-right"><a href="guitarSearch.action">Back</a></p>
					<s:if test="%{delete==null}">
					<div style="margin:40px">
						<h1 class="h2 text-center">追加画面</h1>
					</div>
					<p class="err">
						<s:property value="errorMsg" />
					</p>

						<s:form cssClass="form-horizontal" >
							<div class="form-group">
								<label class="control-label col-sm-2" style="font-size: 1.3em;">メーカー名:※</label>
								<div class="col-sm-10">
									<s:select name="guitarMakerId"  value = "guitarMakerId" list="nameMap" cssClass="form-control" placeholder="メーカーを選択"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" style="font-size: 1.5em;">型名:※</label>
								<div class="col-sm-10">
									<s:textfield cssClass="form-control" name="typeName" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" style="font-size: 1.5em;">価格:※</label>
								<div class="col-sm-10">
									<s:textfield  cssClass="form-control" name="price"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" style="font-size: 1.5em;">コメント:</label>
								<div class="col-sm-10">
									<s:textarea name="comment" cssClass="form-control" placeholder="コメントを入力" />
								</div>
							</div>
							<div style="padding:20px">
								<div class="col-sm-offset-2">
									<s:submit method="insert" value="登録"
										cssClass="btn btn-success form-control" />
								</div>
							</div>
						</s:form>
					</s:if>
					<s:if test="%{delete!=null}">
						<h3>チェックしたデータを削除します</h3>
						<td class="data">削除するデータ:<s:property value="delete"/></td>
						<s:form cssClass="form-horizontal">
							<s:submit method="delete" value="削除" cssClass="btn btn-danger " />
							<a href="guitarSearch.action">Back</a>
						</s:form>
					</s:if>
			</div>

</body>
</html>