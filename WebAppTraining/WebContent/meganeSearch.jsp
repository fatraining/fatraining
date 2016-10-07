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
	href="<s:url value="/assets/css/megane.css"/>" />
<!-- assetsは資産って意味らしい、、、 -->






</head>

<body>





	<div class="container">
		<!-- 大枠 -->

		<div class="text-center">
			<script type="text/javascript">
				function countup2() {
					var tday = new Date();
					var sday = new Date(2016, 9 - 1, 9);
					var past = Math.ceil((tday.getTime() - sday.getTime())
							/ (24 * 60 * 60 * 1000));
					var style1 = '<span style="color:#cfff0f;font-size:31px;font-weight:bold;">';
					var style2 = '</span>';
					var style3 = '<span style="color:#ffffff;font-size:31px;font-weight:bold;">このサイトが設立されてから'
					var style4 = '<span style="color:#ffffff;font-size:31px;font-weight:bold;">日目'
					document.write(style3 + style1 + past + style2 + style4);
				};
				countup2();
			</script>


			<div class="text-center">
				<!-- 小枠 -->
				<jsp:include page="logo.jsp" /><!-- 指定したファイルの処理を実行 -->
			</div>

			<!-- strutsの部分 -->
			<div class="text-right">
				<s:property value="userId" />
				<!-- <s:property value="プロパティ名"/>L -->
				<!--MeganeSearchAction.javaで生成したuserIdを画面に表示する -->

			</div>

			<!-- <p>1つの段落 右側にBackを記述 -->
			<p class="text-right">
				<a href="menu.action">Back</a>
			</p>
			<br>
		</div>
		<!-- <div align="位置"> -->
		<!-- タイトル -->




		<div class="type-pers-parent">
			<div class="type-pers-child">

				<p>Welcome My Page!!</p>
				<p>ひらがなで書くと</p>
				<p>うぇるかむまいぺーじ！</p>
				<p>ここはメガネ屋さん</p>
				<p>みんなここに来る</p>
				<p>何しに来るの？</p>
				<p>メガネ買いに来るんだよ</p>
				<p></p>
				<p>分かるだろ</p>


			</div>
		</div>









		<div align="center">

			<div id="lettersdiv">
				<ul id="letterslist" class="animated">
					<font color="#FFFFFF">
						<li><a class="animated infinite rubberBand" id="one">M</a></li>
						<li class="animated infinite bounce" id="two">E</li>
						<li><a class="animated infinite shake" id="three">G</a></li>
						<li class="animated infinite bounce" id="four">A</li>
						<li><a class="animated infinite shake" id="five">N</a></li>
						<li class="animated infinite bounce" id="six">E</li>
						<li><a class="animated infinite rubberBand" id="seven">!</a></li>
						<li class="animated infinite rubberBand" id="8">!</li>
					</font>
				</ul>
			</div>










			<h2>
				<font size="6" color="#FFFFFF">👓</font><font size="6"
					color="#ffffff">メガネ買いませんか？</font><font size="6" color="#FFFFFF">👓</font>
			</h2>




			<!--
		<div align="center">
			<font size="7" color="#FF0000">👓</font><font size="10"
				color="#FFFFFF">メガネ買いませんか？</font><font size="7" color="#FF0000">👓</font>

		</div> -->

			<br>

			<div align="center">
				<!-- 画像表示 -->
				<div class="slideShow">
					<img src="assets/images/megane2.png" width=440 height=440> <img
						src="assets/images/megane1.png" width=440 height=440> <img
						src="assets/images/megane7.png" width=440 height=440>

				</div>
			</div>








			<!-- エラーメッセージとかを表示する所 -->


			<div class="message">
				<s:actionerror />
				<!-- エラーメッセージが登録されている場合にそのメッセージを表示するのみのタグ -->
				<s:property value="message" />
			</div>
			<br>
			<s:form cssClass="form-horizontal">



				<!-- プルダウン項目の所 -->
				<!-- レスポンシブ水平フォーム -->
				<font color="white">
					<div class="form-group">
						<label for="area" class="col-sm-2 control-label">メガネの形：</label>
						<div class="col-md-8">
							<s:select cssClass="form-control" name="area" value="area"
								list="MeganeForm"></s:select>
						</div>
					</div> <!--  名前を入れて検索するやつ-->
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">
							メガネブランド名:</label>
						<div class="col-md-8">
							<s:textfield name="name" cssClass="form-control" />
						</div>
					</div>
				</font>
				<br>

				<!-- 検索ボタンやらなんやら色々ボタン系クラス デザインとかもここでやるよ -->


				<div class="form-group">
					<!-- 検索ボタン -->

					<s:submit method="search" class="button1" value="search" />
					<!-- リセットボタン -->

					<s:submit method="reset" class="button2" value="reset" />

					<!-- 追加ボタン -->

					<s:submit method="update" class="button3" value="update" />

				</div>




				<div>

					<br>
					<!-- テーブルの中身が0では無かったら以下のテーブルを表示する -->
					<s:if test="%{meganeTable.size> 0}">
						<div align="center">
							<table class="table">


								<thead>
									<!-- テーブルヘッダー -->
									<tr>

										<th>形</th>
										<th>ブランド名</th>
										<th>カラー</th>
										<th>金額</th>
										<th>リンク</th>
										<th>更新</th>
										<th>購入するならここ</th>
										<th>削除するならこっち</th>


										<!-- 初の試み-->


									</tr>

								</thead>
								<tbody>

									<!-- s:iterator=ループ処理に使うタグらしい/ -->
									<!-- DB呼び出し -->
									<s:iterator value="meganeTable">
										<tr>
											<td class="data"><s:property value="area" /></td>
											<td class="data"><s:property value="name" /></td>
											<td class="data"><s:property value="color" /></td>
											<td class="data"><s:property value="kingaku" /></td>
											<td><input type="button" name="link"
												onclick="window.open('<s:property value ="link"/>')"
												value="ブランドのHP" class="btn btn-primary btn-sm" /></td>


											<td><input type="button" name="updateBtn" id="update"
												value="更新" class="btn btn-primary"
												forUpdate=<s:property value ="id"/> /></td>


											<td class="data" width="50"><input type="checkbox"
												name="purchase" value=<s:property value="id"/>></td>
											<td class="data" width="50"><input type="checkbox"
												name="delete" value=<s:property value="id"/>></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</s:if>
					<!-- テーブルの中身が0では無かったら以下のテーブルを表示する -->
					<s:if test="%{meganeTable.size>0}">
						<div class="text-right">
							<div class="shake shake-chunk">
								<s:submit method="purchase" value="購入"
									cssClass="btn btn-success btn-lg btn-block" />
							</div>
						</div>
						<br>
					</s:if>

					<s:if test="%{meganeTable.size>0}">
						<div class="text-right">
							<div class="shake shake-chunk">
								<s:submit method="delete" value="削除"
									cssClass="btn btn-danger btn-lg btn-block" />
							</div>
						</div>
						<br>
					</s:if>
				</div>
				<p class="pageTop">
					<a href="JavaScript:scrollTo(0,0)"
						onclick="scrollup();return false;"><font size="1"
						color="#FFFFFF"> ここ押すと1番上に戻る</font></a>
				</p>
			</s:form>
		</div>
		<!-- javascript -->
		<script type="text/javascript"
			src="<s:url value="/assets/js/nakagawa.js" />"></script>
</body>
</html>