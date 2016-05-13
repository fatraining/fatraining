<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />

<link rel="stylesheet" type="text/css"
	href="<s:url value="/assets/css/tablesorter-blue/style.css"/>" />
<script type="text/javascript"
	src="<s:url value="/assets/js/jquery.tablesorter.min.js"/>"></script>



<body>
	<s:form cssClass="form-horizontal">
		<div class="container">
			<jsp:include page="logo.jsp" />
			<p class="text-right">
				<a href="menu.action">Back</a>
			</p>
			<br>
			<h1 class=heading02>音声通話Sim検索</h1>

			<div class="text-right">
				<s:property value="UserID" />
				さん
			</div>

			<a href="http://kjshintani.com/?p=6285">
				<div align="center">参考サイト:格安スマホにMNPする。MVNO音声通話SIMの比較まとめ。</div>
			</a>


			<div class="form-group">
				<label class="col-sm-2 control-label">Simサービス名：</label>
				<div class="col-sm-10">
					<s:textfield class="form-control" name="simService"
						placeholder="Simサービス名" />
				</div>
			</div>

			<div class="form-group">
				<label for="simOpeName" class="col-sm-2 control-label"> 会社名:</label>
				<div class="col-sm-10">
					<s:select cssClass="form-control" name="simOpeID" list="simOpeMap" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="charge">料金：</label>
				<div class="col-sm-10">
					<s:textfield class="form-control" name="charge" placeholder="料金" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="GB">GB：</label>
				<div class="col-sm-10">
					<s:textfield class="form-control" name="GB" placeholder="GB" />
				</div>
			</div>

			<div class="search">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ">
						<s:submit method="search" value="検索"
							cssClass="btn btn-primary btn-block" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<div style="margin-top: 20px">
						<s:submit method="reset" value="リセット"
							cssClass="btn btn-default btn-block" />
					</div>
				</div>

				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<div style="margin-top: 20px">
						<s:submit method="update" value="追加"
							cssClass="btn btn-info  btn-block" />
					</div>
				</div>

			</div>
		</div>

		<div class="bug">
			<div style="color: red; padding-left: 5%">
				<s:actionerror />
				<s:property value="msg" />
			</div>
			<s:if test="%{outputTable.size() > 0}">
				<table class="tablesorter" id="sim">
					<thead>
						<tr>
							<th>ID</th>
							<th>Simサービス名</th>
							<th>会社名</th>
							<th>料金</th>
							<th>GB(通信料）</th>
							<th>コメント</th>
							<th>削除</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="outputTable">
							<tr>
								<td class="data"><s:property value="ID" /></td>
								<td class="data"><s:property value="simService" /></td>
								<td class="data"><s:property value="simOpeName" /></td>
								<td class="data"><s:property value="charge" /></td>
								<td class="data"><s:property value="GB" /></td>
								<td class="data"><s:property value="comment" /></td>
								<td class="data"><input type="checkbox" name="delete"
									value="<s:property value="ID" />:<s:property value="simOpeName" />:<s:property value="simService" />" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
		</div>
		<s:if test="%{outputTable.size>0}">
			<div align=right>
				<s:submit method="delete" id="deleteBtn" value="削除"
					cssClass="btn btn-danger" />
			</div>
		</s:if>
	</s:form>
	<script>
		$(document).ready((function($) {
			$('#sim').tablesorter({
				widgets : [ 'zebra' ],
				headers : {
					7 : {
						sorter : false
					}
				}
			});
		}));
		// 削除ボタン用
		//			$('#deleteBtn').click(function (e) {
		//				// delete メソッドを実行するための要素を生成
		//				var btn = document.createElement('input');
		//				btn.setAttribute('type', 'hidden');
		//				btn.setAttribute('name', 'method:delete');
		//				btn.setAttribute('value', "1");
		//
		//				var form = document.forms[0];
		//				form.appendChild(btn);
		//				form.submit();
		//			});
	</script>
</body>
</html>