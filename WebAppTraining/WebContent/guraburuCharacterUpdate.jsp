<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />
<title>グラブルキャラクター追加画面</title>

<!-- css設定 -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/guraburu.css"/>" />


</head>
<body>
<div class="container">
		<div class="text-center">
			<!-- 研修WebアプリVerβ（上部）表示 -->
			<jsp:include page="logo.jsp" />
		</div>
		<p class="text-right">
			<a href="guraburuCharacterSearch.action">Back</a>
		</p>
		<br>
		<div id="imgContainer">
			<!--  グランブルーファンタジー画像出力（直リンク）画像大きさ設定はcssに -->
			<img src="https://gamewith.akamaized.net/assets/images/games/covers/09bb19364297d5d7ca193e32683b5f08.png">
		</div>
		<div class="text-center">
			<h2 class="split"><s:property value="title" /></h2>
		</div>

		<div class="text-right">
			<s:property value="userId" />
			<!--userIdの表示 -->
			さん
		</div>

		<!-- ここから追加画面 -->
		<s:form cssClass="form-horizontal">
			<!-- 名前が未入力の場合のエラー表示 -->
			<s:if test="%{hasActionErrors}">
				<div class="alert alert-danger" style="list-style: none">
					<s:actionerror/>
				</div>
			</s:if>
			<s:hidden name="id"></s:hidden>
			<div class="form-group">
				<label class="col-sm-2 control-label"> 名前： </label>
				<div class="col-sm-8">
					<s:textfield cssClass="form-control" name="name" />
				</div>
			</div>
			<br />
			<div class="form-group">
				<label class="col-sm-2 control-label"> 性別： </label>
				<div class="col-sm-8">
					<label> <input type="radio" name="sex" value = "男性" <s:if test="%{sex == '男性'}">checked</s:if>> 男性 </label>
					<label> <input type="radio" name="sex" value = "女性" <s:if test="%{sex == '女性'}">checked</s:if>> 女性 </label>
					<input type="radio" name="sex"value="未入力" <s:if test="%{sex == null}">checked</s:if> style="display:none;" />
				</div>
			</div>
			<br />
			<div class="form-group">
				<label class="col-sm-2 control-label"> 属性：<s:property value = "attribute"/></label>
				<div class="col-sm-8">
					<label data-icon="a1"><input type="radio" name="attribute" value="火"
												<s:if test="%{attribute == '火'.toString()}">checked</s:if>><img></label>
					<label data-icon="a2"><input type="radio" name="attribute" value="水"
												<s:if test="%{attribute == '水'.toString()}">checked</s:if>><img></label>
					<label data-icon="a3"><input type="radio" name="attribute" value="土"
												<s:if test="%{attribute == '土'.toString()}">checked</s:if>><img></label>
					<label data-icon="a4"><input type="radio" name="attribute" value="風"
												<s:if test="%{attribute == '風'.toString()}">checked</s:if>><img></label>
					<label data-icon="a5"><input type="radio" name="attribute" value="光"
												<s:if test="%{attribute == '光'.toString()}">checked</s:if>><img></label>
					<label data-icon="a6"><input type="radio" name="attribute" value="闇"
												<s:if test="%{attribute == '闇'.toString()}">checked</s:if>><img></label>
					<input type="radio" name="attribute" value="無"
		                 		<s:if test="%{attribute == null}">checked</s:if> style="display:none;" />
				</div>
			</div>
			<br />
			<div class="form-group">
				<label class="col-sm-2 control-label"> 種族： </label>
				<div class="col-sm-8">
					<s:select cssClass="form-control" name="raceId" list="raceMap"/>
				</div>
			</div>
			<br />
			<div class="form-group">
				<label class="col-sm-2 control-label"> 画像参照（URL)： </label>
				<div class="col-sm-8">
					<s:textfield cssClass="form-control" name="dataUrl" />
				</div>
			</div>
			<br />
			<div class="form-group">
				<label class="col-sm-2 control-label"> コメント： </label>
				<div class="col-sm-8">
					<s:textarea rows="3" cssClass="form-control" name="comment" />
				</div>
			</div>

			<div class="form-group">
			<div class="col-md-offset-2 col-md-8">
					<s:submit method="update" value="%{Btn}"
						cssClass="btn btn-danger btn-block" />
			</div>
		</div>
		</s:form>
	</div>
</body>
</html>