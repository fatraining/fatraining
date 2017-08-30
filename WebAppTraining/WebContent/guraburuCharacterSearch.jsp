<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
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
			<a href="menu.action">Back</a>
		</p>
		<br>
		<div id="imgContainer">
			<!--  グランブルーファンタジー画像出力（直リンク）画像大きさ設定はcssに -->
			<img src="https://gamewith.akamaized.net/assets/images/games/covers/09bb19364297d5d7ca193e32683b5f08.png">
		</div>
		<div class="text-center">
			<h2 class="split">グラブルキャラ検索</h2>
		</div>

		<div class="text-right">
			<s:property value="userId" />
			<!--userIdの表示 -->
			さん
		</div>
		<!-- メッセージの表示 -->
		<div class="text-left">
			<div class="message" style="color: red"><s:actionerror /><s:property value="message" /></div>
		</div>

		<!-- 検索設定 -->
		<s:form>
			<div class="form-horizontal">
				<div class="form-group ">
					<label for="name" class="col-sm-2 control-label"> 名前：</label>
					<div class="col-md-8">
						<s:textfield name="name" cssClass="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label for="sex" class="col-sm-2 control-label">性別：</label>
					<div class="col-md-8">
						<label> <input type="radio" name="sex" value = "男性" <s:if test="%{sex == '男性'}">checked</s:if>> 男性 </label>
						<label> <input type="radio" name="sex" value = "女性" <s:if test="%{sex == '女性'}">checked</s:if>> 女性 </label>
						<input type="radio" name="sex"value=""
	                 		<s:if test="%{sex == ''}">checked</s:if> style="display:none;" />
					</div>
				</div>

				<div class="form-group">
					<label for="attribute" class="col-sm-2 control-label"> 属性：</label>
					<div class="col-md-8">
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
					<input type="radio" name="attribute" value=""
		                 		<s:if test="%{attribute == ''}">checked</s:if> style="display:none;" />
					</div>
				</div>

				<div class="form-group">
					<label for="race" class="col-sm-2 control-label"> 種族：</label>
					<div class="col-md-8">
						<s:select cssClass="form-control" name="race" value="race"
							list="raceMap"></s:select>
					</div>
				</div>
			</div>
			<br>

			<!--  ボタン設定 -->
			<div class="form-group">
				<div class="col-md-offset-2 col-md-8">
					<s:submit method="search" value="検索"
						cssClass="btn btn-warning btn-block" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-2 col-md-4">
					<s:submit method="reset" value="リセット"
						cssClass="btn btn-danger btn-block" />
				</div>
				<div class="col-md-4">
					<s:submit method="update" value="追加"
						cssClass="btn btn-info btn-block " />
				</div>
			</div>
			<br />

			<!-- ここから検索結果表示画面 -->
			<s:if test="%{guraburuCharacterTable.size!=0}">
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
							<th>更新</th>
							<th>削除</th>
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
								<td class="data7" ><input type="button"  value="更新" onClick="clickUpdate('<s:property value ="id"/>')"
										class="btn btn-info" /></td>
								<td class="data8" ><input type="checkbox"
									name="delete" value=<s:property value="id"/>></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
			<s:if test="%{guraburuCharacterTable.size!= 0}">
			<div class="text-right">
				<p>削除する場合削除を押してください</p>
				<s:submit method="delete" value="削除" cssClass="btn btn-danger"></s:submit>
			</div>
			</s:if>
		</s:form>
	</div>
<p id="page-top"><a href="#wrap">PAGE TOP</a></p>
<!-- jQuery -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" ></script>
<script type="text/javascript"
	src="<s:url value="/assets/js/guraburu.js"/>"></script>

</body>
</html>