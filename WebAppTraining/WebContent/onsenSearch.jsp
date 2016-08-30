<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- ヘッダー -->
<jsp:include page="header.jsp" />

<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/onsen.css"/>" />



</head>

<body>
	<audio src=<s:url value="/assets/images/temp/sakai.mp3"/>
		<s:property value="sakai.mp3" /> autoplay loop></audio>

	<div class="container">
		<div class="text-center">
			<jsp:include page="logo.jsp" />
		</div>
		<p class="text-right">
			<a href="menu.action">Back</a>
		</p>
		<br>


		<div align="center">
			<font size="7" color="#FF0000">♨</font><font size="7">温泉検索</font><font
				size="7" color="#FF0000">♨</font>

		</div>
		<br>
		<div class="text-right">
			<s:property value="userId" />
			<!--OnsenSearchAction.javaで生成したuserIdを画面に表示する -->
			さん
		</div>

		<div class="slideShow">
			<img src="assets/images/onsen_saru1.jpg" width=440 height=440>
			<img src="assets/images/onsen_kapibara1.jpg" width=440 height=440>
			<img src="assets/images/onsen_saru2.jpg" width=440 height=440>

		</div>

		<!--
 			<div class="form-group">
				<label for="area" class="col-sm-2 control-label"> エリア: </label>
				<div class="col-md-8">
					<select name="area" class="form-control">
						<option>横浜</option>
						<option>豊島区</option>
						<option>鴨川市</option>
					</select>
				</div>
			</div>

-->
		<div class="message">
			<s:actionerror />
			<s:property value="message" />
		</div>
		<br>
		<s:form cssClass="form-horizontal">
			<!-- レスポンシブ水平フォーム -->
			<div class="form-group">
				<label for="area" class="col-sm-2 control-label">エリア：</label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="area" value="area"
						list="onsenAreaMap"></s:select>
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> 温泉名: </label>
				<div class="col-md-8">
					<s:textfield name="name" cssClass="form-control" />
				</div>
			</div>

			<br>

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
			<br>

			<div>

				<br>
				<s:if test="%{onsenTable.size> 0}">
					<div align="center">
						<table class="table">


							<thead>
								<!-- テーブルヘッダー -->
								<tr>
									<th>エリア</th>
									<th>温泉名</th>
									<th>効能</th>
									<th>コメント</th>
									<th>リンク</th>
									<th>更新</th>
									<th>削除</th>


								</tr>

							</thead>
							<tbody>

								<s:iterator value="onsenTable">
									<tr>
										<td class="data"><s:property value="area" /></td>
										<td class="data"><s:property value="name" /></td>
										<td class="data"><s:property value="effect" /></td>
										<td class="data"><s:property value="comment" /></td>
										<td><input type="button" name="link"
											onclick="window.open('<s:property value ="link"/>')"
											value="HP" class="btn btn-primary btn-sm" /></td>
										<td><input type="button" name="updateBtn" id="update"
											value="更新" class="btn btn-primary"
											forUpdate=<s:property value ="id"/> /></td>
										<td class="data" width="50"><input type="checkbox"
											name="delete" value=<s:property value="id"/>></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</s:if>
				<s:if test="%{onsenTable.size>0}">
					<div class="text-right">
						<div class="shake shake-chunk">
							<s:submit method="delete" value="削除" cssClass="btn btn-danger" />
						</div>
					</div>
					<br>
				</s:if>
			</div>
		</s:form>
	</div>

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/sakai.js" />"></script>
</body>
</html>