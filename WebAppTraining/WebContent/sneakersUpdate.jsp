<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />

<%-- css --%>
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/sneakers.css" />" />
</head>


<body>
 <div class="container">
  <div class="text-left">
   <jsp:include page="logo.jsp" />
  </div>

  <div class="text-right">
    <a href="sneakersSearch.action">もどる</a><br>
  </div>

  <div class="text-center">
   <h2>
    <s:property value="title" />
   </h2>
  </div><br>

  <div class="text-right">
   <s:property value="userId" />さん<br>
  </div>



<%--未入力時のメッセージ表示 --%>
  <div class="errorMessage">
   <s:actionerror />
   <s:property value="errorMessage" />
  </div><br>


  <%--入力フォーム①メーカー maker --%>
  <s:form class="form-horizontal">
   <s:hidden name="id"></s:hidden>
   <div class="form-group">
    <label class=" control-label col-sm-3">メーカー：</label>
    <div class="col-md-6">
     <s:select cssClass="form-control" name="sneakersMakerId"
      list="sneakersMakerMap"></s:select>
    </div>
   </div>

   <%--入力フォーム②製品名 name --%>
   <div class="form-group">
    <label class=" control-label col-sm-3"> 製品名: </label>
    <div class="col-md-6">
     <s:textfield name="name" class="form-control" maxlength="254" placeholder=""
     onkeyup="document.getElementById('xxxx').value=this.value.length" />
    </div>
    <input type="text" size="3" id="xxxx">/254 文字
   </div>

   <%--入力フォーム③シリーズ series --%>
   <div class="form-group">
    <label class=" control-label col-sm-3"> シリーズ: </label>
    <div class="col-md-6">
     <s:textfield name="series" cssClass="form-control" maxlength="254" placeholder=""
     onkeyup="document.getElementById('yyyy').value=this.value.length" />
    </div>
     <input type="text" size="3" id="yyyy">/254 文字
   </div>

   <%--入力フォーム④発売年 year --%>
   <div class="form-group">
    <label for="year" class="col-sm-3 control-label"> 発売年: </label>
    <div class="col-md-6">
     <s:select class="form-control" name="year" list="sneakersYearMap"></s:select>
    </div>
   </div>

    <%--入力フォーム⑤コメント comment --%>
   <div class="form-group">
    <label class=" control-label col-sm-3"> コメント: </label>
    <div class="col-md-6">
     <s:textarea name="comment" cssClass="form-control" maxlength="254" rows="3"
      placeholder="" onkeyup="document.getElementById('zzzz').value=this.value.length" />
    </div>
     <input type="text" size="3" id="zzzz">/254 文字
   </div>

   <%--入力フォーム⑥イメージ image --%>
   <div class="form-group">
    <label class=" control-label col-sm-3"> 画像ファイル相対パス名: </label>
    <div class="col-md-6">
     <s:textarea name="image" cssClass="form-control" maxlength="254" placeholder=""
     onkeyup="document.getElementById('wwww').value=this.value.length" />
    </div>
    <input type="text" size="3" id="wwww">/254 文字
   </div>


   <%--更新ボタン --%>
   <div class="form-group text-right">
    <s:submit method="update" value="%{updateBtnTitle}"
     cssClass="btn btn-lg btn-warning" />
   </div>
  </s:form>
 </div>

 <%-- javascript --%>
 <script type="text/javascript"
  src="<s:url value="/assets/js/sekiguchi.js" />"></script>

</body>
</html>