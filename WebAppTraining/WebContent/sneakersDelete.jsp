<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="header.jsp" />

<%-- CSS --%>
<link rel="stylesheet" type="text/css"
 href="<s:url value ="assets/css/sneakers.css"/>" />

 <%-- JQuery --%>
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<s:url value="/assets/js/jquery.sekiguchi.js"/>"></script>




</head>


<body>


 <s:form class="form-horizontal">
  <div class="container">
   <div class="text-left">
    <jsp:include page="logo.jsp" />
   </div>

    <div class="text-right">
     <a href="sneakersSearch.action">もどる</a>
    </div><br>

   <div class="text-center">
    <h2>スニーカー削除</h2>
   </div>

   <div class="text-right">
     <s:property value="userId" />さん<br><br>
   </div>

 <%--削除ボタン --%>
     <div class="">
      <h3><s:submit method="delete" value="リアルに削除"
      id="btn" class="btn btn-danger"/>
        </h3>
        </div>


<%--削除対象のテーブル表示 --%>
   <s:if test="%{sneakersTable.size!=0}">
    <div>
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
       </tr>
      </thead>
      <tbody>
       <s:iterator value="sneakersTable">
        <tr bgcolor="#FFFFFF">
        <%--テーブルの中身 --%>
         <td class="data" width="120"><img
          src="<s:property value="image"/>" alt="NO IMAGE!" width="110"
          height="110"></td>
         <td class="data" width="70"><s:property value="maker" /></td>
         <td class="data" width="140"><s:property value="name" /></td>
         <td class="data" width="80"><s:property value="series" /></td>
         <td class="data" width="80"><s:property value="year" /></td>
         <td class="data" width="220"><s:property value="comment" /></td>
        </tr>
       </s:iterator>
      </tbody>
     </table>
    </div>
   </s:if>
  </div>
 </s:form>

 <%-- javascript --%>
 <script type="text/javascript"
  src="<s:url value="/assets/js/sekiguchi.js" />"></script>

<br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>

</html>