<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<jsp:include page="/header.jsp" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/bootstrap.min.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/vegas.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/sake.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/sakeUpdate.css"/>" />


<body>
	<div class="container">
		<jsp:include page="logo.jsp" />
		<p class="text-right">
			<a href="sakeSearch.action">戻る</a>
		</p>
		<s:if test="%{delete==null}">
			<h2 class="text-left">おいしい日本酒の店を登録してネ。</h2>
			<p class="err">
				<s:property value="errorMsg" />
			</p>
			<div class="img">
				<ul>
					<li><img id="img" src="assets/images/sake_02.jpg"
						alt="メインイメージ" class="sake"></li>
				</ul>
			</div>
			<s:form cssClass="form-horizontal" enctype="multipart/form-data"
				method="post">
				<div class="form-group">
					<label for="area" class="control-label col-sm-2" id="items">エリア：</label>
					<div class="col-sm-5">
						<s:select id="map" name="areaId"
							cssClass="form-control select" value="area" list="areaMap" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" id="items">店名：</label>
					<div class="col-md-3">
						<s:textfield id="col-md-3" name="shopName" cssClass="form-control"
							placeholder="店名を入力" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" id="items">営業時間：</label>
					<div class="col-md-3">
						<s:textfield id="col-md-3" name="hours" cssClass="form-control"
							placeholder="00:00-00:00" />
					</div>
				</div>
 				<div class="form-group">
					<label class="control-label col-sm-2"id="items">予算：</label>
					<div class="col-sm-3">
						<s:select id="map" cssClass="form-control select" name="price"
							list="priceMap" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" id="items">おススメ：</label>
					<div class="col-md-3">
						<s:textfield id="col-md-3" name="recommend"
							cssClass="form-control" placeholder="おススメを入力" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" id="items">コメント：</label>
					<div class="col-md-3">
						<s:textarea id="col-md-3" name="comment" cssClass="form-control"
							placeholder="コメントを入力" />
					</div>
				</div>
				<div class="col-sm-offset-2">
					<s:submit id="registar" method="insert" value="登録"
						cssClass="btn btn-primary" />
				</div>
			</s:form>
		</s:if>

		<s:if test="%{delete!=null}">
			<h2>選んだ日本酒店を削除します</h2>
			<s:form cssClass="form-horizontal">
				<s:submit id="delete" method="delete" value="削除"
					cssClass="btn btn-primary " />
			</s:form>
		</s:if>
	</div>
</body>
</html>