<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html>
<html>

<head>
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

  <p class="text-right">
   <a href="menu.action">もどる</a>
  </p><br>

  <div class="text-center">
   <h2 class="">スニーカーサーチ</h2>
  </div><br>

  <%--SearchActionクラスで生成したuserIdを表示する --%>
  <div class="text-right">
   <s:property value="userId" />さん
  </div><br>


<%--入力フォーム① maker --%>
  <s:form cssClass="form-horizontal">
   <div class="form-group">
    <label for="maker" class="col-sm-3 control-label">メーカー：</label>
    <div class="col-md-6">
     <s:select cssClass="form-control" name="maker" value="maker"
      list="sneakersMakerMap"></s:select>
    </div>
   </div><br>

<%--入力フォーム② series --%>
   <div class="form-group">
    <label for="series" class="col-sm-3 control-label"> シリーズ: </label>
    <div class="col-md-6">
     <s:textfield name="series" cssClass="form-control" />
    </div>
   </div><br>

<%--入力フォーム③ year --%>
   <div class="form-group">
    <label for="year" class="col-sm-3 control-label"> 発売年: </label>
    <div class="col-md-6">
     <s:select cssClass="form-control" name="year"
      list="sneakersYearMap"></s:select>
    </div>
   </div><br>

<%-- ①検索ボタン --%>
   <div class="form-group">
    <div class="col-md-offset-3 col-md-6">
     <s:submit method="search" value="サーチ"
      cssClass="btn btn-success btn-lg btn-block" />
    </div>
   </div>

<%-- ②リセットボタン --%>
   <div class="form-group">
    <div class="col-md-offset-2 col-md-4">
     <s:submit method="reset" value="リセット"
      cssClass="btn btn-danger btn-lg btn-block" />
    </div>

    <%-- ③追加登録ボタン --%>
    <div class="col-md-4">
     <s:submit method="update" value="登録"
      cssClass="btn btn-warning btn-lg btn-block " />
    </div>
   </div><br>


<%--登録・更新・削除時のメッセージ表示 message
   <div>
    <div class="message">
     <div class="text-center">
     <s:actionerror />
     <s:property value="message" />
    </div><br>
    </div> --%>


    <%--検索結果テーブル表示 --%>
    <s:if test="%{sneakersTable.size> 0}">
     <table class="table table-hover table-bordered">
      <thead>
       <tr class="success">
       <%--テーブルヘッダー --%>
        <th>イメージ</th>
        <th>メーカー</th>
        <th>製品名</th>
        <th>シリーズ</th>
        <th>発売年</th>
        <th>コメント</th>
        <th>更新</th>
        <th>削除</th>
       </tr>
      </thead>
      <tbody>
       <s:iterator value="sneakersTable">
        <tr bgcolor="#FFFFFF">
        <%--テーブルの中身 --%>
         <td class="data" width="120"><img
          src="<s:property value="image"/>" alt="NO IMAGE!" width="110"
          height="110"></td>
         <td class="data" width="60"><s:property value="maker" /></td>
         <td class="data" width="120"><s:property value="name" /></td>
         <td class="data" width="70"><s:property value="series" /></td>
         <td class="data" width="110"><s:property value="year" /></td>
         <td class="data" width="200"><s:property value="comment" /></td>
         <td><input width="50" type="button" name="updateBtn"
          id="update" value="更新" class="btn btn-primary"
          forUpdate="<s:property value ="id"/>" /></td>
         <td class="data" width="90"><input type="checkbox"
          name="delete" value=<s:property value="id"/>></td>
        </tr>
       </s:iterator>
      </tbody>
     </table>
    </s:if>

    <%--④削除ボタン --%>
    <s:if test="%{sneakersTable.size>0}">
     <div class="text-right">
       <s:submit method="delete" value="削除"
        cssClass="btn btn-lg btn-danger" />
     </div><br>
    </s:if>
   </div>
  </s:form>
 </div>


 <%-- javascript --%>
 <script type="text/javascript"
  src="<s:url value="/assets/js/sekiguchi.js" />">
  </script>


</body>
</html>