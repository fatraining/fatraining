<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- strutsのタグを使えるようにするやつ-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- CSS -->
<link rel="stylesheet" type="text/css"
	href="<s:url value ="assets/css/megane.css"/>" />
<!-- ふるえるcss -->
<link rel="stylesheet" type="text/css"
	href="http://csshake.surge.sh/csshake.min.css">
<body>
	<s:form class="form-horizontal">
		<div class="container">
			<div class="text-center">
				<jsp:include page="logo.jsp" />
			</div>
	<font color="white">
			<div class="text-left">
				<h2>本当に削除しますか？後悔は？</h2></font>
				<p class="text-right">
					<s:property value="userId" />
					さん <a href="meganeSearch.action">戻りたい戻りたい！</a>
				</p>
				<br>
			</div>
		</div>


		<s:if test="%{meganeTable.size!=0}">
			<div>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>形</th>
							<th>ブランド名</th>
							<th>カラー</th>
							<th>金額</th>

						</tr>
					</thead>
					<tbody>
						<s:iterator value="meganeTable">
							<tr>
								<td class="data" width="75"><s:property value="area" /></td>
								<td class="data" width="190"><s:property value="name" /></td>
								<td class="data" width="60"><s:property value="color" /></td>
								<td class="data" width="150"><s:property value="kingaku" /></td>

							</tr>
						</s:iterator>
					</tbody>
				</table>


				<!-- ポップアップ1,2,3ボタン -->

				<a class="button" onclick="alert('本当に消すの考えてる？');"> まず押してみて？</a> <a
					class="button" onclick="alert('そんな人じゃないと思ってた...');">次はここ</a> <a
					class="button" onclick="alert('ちょっとがっかり');">その次はここ</a>





				<!-- ↓こんなことをしてる時もあったなぁ、、、 -->


				<!-- 	<form name="test2">
					<div class="shake shake-vertical-slow shake-constant">
						<a class="button" method="delete" onClick="kakunin2(1)">それでも削除します
						</a>
					</div>
				 -->



				<!-- ポップアップ4,5の動作 -->

				<form name="test2">
					<div class="shake shake-vertical-slow shake-constant">
						<s:submit method="delete" class="button" value="それでも削除します"
							onClick="kakunin2(1)">
						</s:submit>
					</div>


					<a class="button" name="modoru" onClick="kakunin2(2)">
						やっぱりやめようかな </a>
				</form>

			</div>
		</s:if>
	</s:form>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/nakagawa.js" />"></script>
</body>
</html>