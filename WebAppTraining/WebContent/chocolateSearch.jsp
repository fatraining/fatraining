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
	href="<s:url value="/assets/css/chocolate.css"/>" />

<SCRIPT language="JavaScript">
	// 複数テキスト領域の入力文字数を超えたら警告する
	function restChar() {
		n = document.formN.shopName.value.length;
		//document.formN.valueは打ち込まれたテキストのことで、.lengthで長さをとっている
		//n>10なら、警告が出るようにセット
		if (n > 30)
			alert("テキストは30字以内でお願いします");
	}
</SCRIPT>


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



		<center>
			<div>
				<img src="assets/images/temp/chocolatetitle.png" width="550">
			</div>

		</center>


		<br>
		<div class="text-right">
			<s:property value="userId" />
			<!--ChocolateSearchAction.javaで生成したuserIdを画面に表示する -->
			さん
		</div>


		<div class="slideShow">

				<img src="assets/images/temp/chocolate1.jpg" width=640 height=640>
				<img src="assets/images/temp/chocolate2.jpg" width=640 height=640>
				<img src="assets/images/temp/chocolate3.jpg" width=640 height=640>

		</div>




		<div class="message">
			<s:actionerror />
			<s:property value="message" />
		</div>
		<br>
		<s:form cssClass="form-horizontal" name="formN">
			<!-- ここでformの名前をformNにセット-->
			<!-- formは入れ子にできないのでs:textareaでテキストのエリア指定をする-->



			<div class="form-group">
				<label for="country" class="col-sm-2 control-label">Area：</label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="country" value="country"
						list="chocolateCountryMap"></s:select>
				</div>
			</div>

			<!-- <div class="form-group">
              <label for="shopName" class="col-sm-2 control-label"> Shop name: </label>
				<div class="col-md-8">
				<s:textfield name="shopName" cssClass="form-control" />
				</div>-->
			<!--<FORM name="formN">
				<TEXTAREA rows="3" size="45" name="shopName" onChange="restChar()"></TEXTAREA>
			-</FORM>-->Shop name:
			<s:textarea cols="35" rows="1" size="20" name="shopName"
				onChange="restChar()" />
			<!-- restChar()を呼び出して、チェックする-->
	</div>

	<br>



<div class="submit">



					<div class="form-group" id="block01">
						<div class="col-md-5">
							<s:submit id="button" method="search" value="Search"
								cssClass="btn btn-danger" />
						</div>
					</div>

					<div class="form-group" id="block02">
						<div class="col-md-5">
							<s:submit id="button" method="reset" value="Reset"
								cssClass="btn btn-danger" />
						</div>
					</div>
					<div class="form-group" id="block03">
						<div class="col-md-5">
							<s:submit id="button" method="update" value="Add"
								cssClass="btn btn-danger" />
						</div>
					</div>
				</div>



	<!--<div class="form-group">
		<div class="col-md-offset-2 col-md-8">
			<s:submit method="search" value="Search"
				cssClass="btn btn-warning btn-block" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-4">
			<s:submit method="reset" value="Reset"
				cssClass="btn btn-danger btn-block" />
		</div>
		<div class="col-md-4">
			<s:submit method="update" value="Add"
				cssClass="btn btn-info btn-block " />
		</div>

	</div>-->
	<br>

	<div>

		<br>
		<s:if test="%{chocolateTable.size> 0}">
			<div align="center">
				<table class="table">


					<thead>
						<!-- テーブルヘッダー -->
						<tr>
							<th>Area</th>
							<th>Image</th>
							<th>Shop name</th>
							<th>Chef</th>
							<th>Comment</th>
							<th>Price</th>
							<th>Update</th>
							<th>Delete</th>


						</tr>

					</thead>
					<tbody>

						<s:iterator value="chocolateTable">
							<tr>

								<td class="data"><s:property value="Country" /></td>
								<td class="data" width="280"><img
									src="<s:property value="image"/>" alt="NO IMAGE!" width="100"
									height="110"></td>
								<td class="data"><s:property value="shopName" /></td>
								<td class="data"><s:property value="Chef" /></td>
								<td class="data" width="300"><s:property value="Comment" /></td>
								<td class="data" width="180"><s:property value="Price" /></td>
								<td><input type="button" name="updateBtn" id="update"
									value="Update" class="btn btn-primary"
									forUpdate=<s:property value ="id"/> /></td>
								<td class="data" width="30"><input type="checkbox"
									name="delete" value=<s:property value="id"/>></td>
								<!--  id="update"はこのボタンの名前のようなもので、これを指定してJavascriptやcssで加工する -->
								<!-- forUpdateでActionのupdate()を呼び出せるというstruts2の仕様 ここで渡すidが勝手にupdateIdになってくれる -->
								<!-- ここでさすvalue="id"はchocolateTableのID -->
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</s:if>
		<s:if test="%{chocolateTable.size>0}">
			<div class="text-right">
				<div class="shake shake-chunk">
					<s:submit method="delete" value="Delete" cssClass="btn btn-danger" />
					<!-- deleteが押されたらActionのdeleteメソッドへいく -->
				</div>
			</div>
			<br>
		</s:if>
	</div>
	</s:form>
	</div>

	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/muto.js" />"></script>
</body>
</html>