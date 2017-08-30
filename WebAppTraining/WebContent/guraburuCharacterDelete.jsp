<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<title>グラブルキャラクター削除画面</title>

<!-- css設定 -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/guraburu.css"/>" />
	<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/guraburutable.css"/>" />

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

		<div class="text-center">
			<h3>
				<!-- デリートメッセージの表示 -->
				<s:property value="deleteMessage" />
			</h3>
		</div>

		<!-- ここから削除画面 -->
		<s:form cssClass="form-horizontal">
			<!-- 検索結果テーブル作成 -->
			<div class="show">
				<s:if test="%{guraburuCharacterTable.size!= 0}">
					<table class="table_design">
						<!--  テーブルヘッダー -->
						<thead>
							<tr>
								<th>名前</th>
								<th>画像</th>
								<th>性別</th>
								<th>種族</th>
								<th>属性</th>
								<th>コメント</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="guraburuCharacterTable">
								<tr>
									<td class="data1" ><s:property value="name" /></td>
									<td class="data2" >
										<!-- onClick(js)でUrlの判断 -->
										<input type="button"  value="画像ページへ" onClick="clickUrl('<s:property value ="dataUrl"/>')"
											class ="btn btn-primary" />
									</td>
									<td class="data3" ><s:property value="sex" /></td>
									<td class="data4" ><s:property value="raceName" /></td>
									<td class="data5" ><s:property value="attribute" /></td>
									<td class="data6" ><s:property value="comment" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
					<br />
				</s:if>
				<s:if test="%{guraburuCharacterTable.size!= 0}">
					<div class="text-right">
						<s:submit method="delete" value="削除"
							cssClass="btn btn-danger btn-lg"></s:submit>
					</div>
					<br />
				</s:if>
			</div>
		</s:form>
	</div>
	<!-- jQuery -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/guraburu.js"/>"></script>

</body>
</html>