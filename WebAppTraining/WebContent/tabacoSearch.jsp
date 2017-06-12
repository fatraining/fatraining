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
	href="<s:url value="/assets/css/tabaco.css"/>" />

</head>

<body>
	<div class="container">
		<!-- 大きな枠組的な？ -->

		<div class="text-center">
			<!-- 小さい枠？ -->
			<jsp:include page="logo.jsp" />
			<!-- 指定したファイルの処理を実行 -->
		</div>

		<!-- struts2さんのところ -->
		<div class="text-right">
			<div class="text-right">
				<font color="white"> <s:property value="userId" />様
				</font>
			</div>
			<!--TabacoSearchAction.javaで生成したuserIdを画面に表示する -->
		</div>

		<p class="text-right">
			<a href="menu.action">Back</a>
		</p>
		<br>
		<!--Backの文字を右側に表示  -->

		<!-- <div align="位置"> -->
		<!-- タイトルの表示 -->
		<div class="type-pers-parent">
			<div class="type-pers-child">

				<font face="HG行書体" color="yellow">
					<p>たばこ調べに来たの？</p>
					<p>いいことないよ。。</p>
					<p>お金もかかる。。</p>
					<p>健康にも悪い。。</p>
					<p>でも吸いたいたばこがあるんだろ？</p>
					<p>マナーは守ろうね</p>
					<p>喫煙者の誇りとして</p>
					<p></p>
					<p>よきたばこライフを</p>
				</font>

			</div>
		</div>
		<br> <br> <br> <br>

		<p>
			<font face="明朝体" size="6" color="white">
				【銘柄名】または【タール数】からたばこを検索！！
				 <br> 
				 【商品名】がわかってるならいれてみて！
			</font>
		</p>
		<br> <br>
		
		<div class="message">
					<s:actionerror />
					<s:property value="message" />
				</div>
		<br>
		<br>
		<s:form cssClass="form-horizontal">
		 <s:hidden name="id"></s:hidden>
			<div class="form-group">
				<label for="area" class="col-sm-2 control-label"><font
					face="HG行書体" size="5" color="yellow">銘柄名：</font></label>
				<div class="col-md-8">
					<s:select cssClass="form-control" name="area" value="area"
						list="tabacoAreaMap"></s:select>
					<!-- list==でゲットしてる -->
				</div>
			</div>

			<div class="form-group">
				<label for="tar" class="col-sm-2 control-label"> <font
					face="HG行書体" size="5" color="yellow">タール：</font></label>
				<div class="col-md-8">
					<s:textfield name="tar" cssClass="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label"> <font
					face="HG行書体" size="5" color="yellow">商品名：</font></label>
				<div class="col-md-8">
					<s:textfield name="name" cssClass="form-control" />
				</div>
			</div>
			<br>

			<div class="form-group">
				<div class="col-md-offset-2 col-md-8">
					<font face="HG行書体"> <s:submit method="search" value="検索"
							cssClass="btn btn-primary btn-block" />
					</font>
				</div>
			</div>
			<div class="col-md-offset-2 col-md-4">
				<font face="HG行書体"> <s:submit method="reset" value="リセット"
						cssClass="btn btn-primary btn-block" />
				</font>
			</div>
			<div class="col-md-4">
				<font face="HG行書体"> <s:submit method="update" value="追加"
						cssClass="btn btn-primary btn-block " />
				</font>
			</div>
			<br>
			<br>
			<br>
				
			<!-- テーブルの中身があれば以下のテーブルを表示する -->

			<s:if test="%{tabacoTable.size > 0}">
				<div align="center">
					<table class="table table-hover table-bordered">
						<thead>
							<!-- テーブルヘッダー -->
							<tr bgcolor="#FFFFFF">

								<th>銘柄名</th>
								<th>商品画像</th>
								<th>商品名</th>
								<th>タール数</th>
								<th>ニコチン</th>
								<th>価格</th>
								<th>コメント</th>
								<th>更新</th>
								<th>削除</th>

							</tr>
						</thead>
						<tbody>

							<!-- s:iterator == ループ処理に使うタグ -->
							<!-- DBからの呼び出し -->
							<s:iterator value="tabacoTable">
								<tr bgcolor="#FFFFFF">
									<td class="data" width="130"><s:property value="area" /></td>

									<td><a
										href="<s:url value="/assets/images/temp/"/><s:property value = "namePhoto" />"
										rel="lightbox"> <img class="imageWrapper"
											src="<s:url value="/assets/images/temp/"/><s:property value="namePhoto" />"
											alt="No image!!" width="60" height="80" />
									</a></td>

									<td class="data" width="170"><s:property value="name" /></td>
									<td class="data" width="90"><s:property value="tar" /></td>
									<td class="data" width="90"><s:property value="nicotine" /></td>
									<td class="data" width="80"><s:property value="price" /></td>
									<td class="data" width="200"><s:property value="comment" /></td>

									<td width="70"><input type="button" name="updateBtn"
										id="update" value="更新" class="btn btn-primary"
										forUpdate=<s:property value ="id"/> /></td>

									<td class="date" width="70"><input type="checkbox"
										name="delete" value=<s:property value = "id"/>></td>

								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</s:if>
			<s:if test="%{tabacoTable.size > 0}">
				<div class="text-right">
					<div class="shake shake-chunk">
						<font face="HG行書体"> <s:submit method="delete" value="灰となれ。"
								cssClass="btn btn-danger" />
						</font>
					</div>
				</div>
			</s:if>
		</s:form>
	</div>
	<!-- javascript -->
	<script type="text/javascript"
		src="<s:url value="/assets/js/otawara.js" />"></script>
</body>
</html>