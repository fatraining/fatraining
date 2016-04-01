<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp" />
<p class="text-right">
	<a href="menu.action">Back</a>
</p>
<br>
<h1 class="h3 text-left" id="heading02">携帯検索</h1>

<style>
div.search {
	margin-left: 40%;
}

div.row {
	padding: 20px 0;
}
/* 02.テープ */
#heading02 {
	position: relative;
	margin: 0 -1px;
	font: bold 30px/1.6 Arial, Helvetica, sans-serif;
	text-align: center;
	color: #333;
	background: #f0e800;
	-webkit-transform: rotate(-3deg) skew(-3deg);
	-moz-transform: rotate(-3deg) skew(-3deg);
	-o-transform: rotate(-3deg) skew(-3deg);
	-ms-transform: rotate(-3deg) skew(-3deg);
	transform: rotate(-3deg) skew(-3deg);
	text-shadow: 1px 1px 0 rgba(255, 255, 255, 1);
	box-shadow: 0 1px 2px 0 rgba(0, 0, 0, 0.2), 30px 0 0 0 #f0e800, -30px 0
		0 0 #f0e800;
}

/* テーブル */
h1 {
	margin: 0 auto;
	text-align: center;
}

body.form {
	margin: 0 auto;
	text-align: center;
}

table.type {
	border-collapse: collapse;
	margin: 0 auto;;
	text-align: center;
	line-height: 1.5;
	border: 1px solid #ccc;
}

tr {
	margin: 0 auto;
	text-align: center;
}

table.type thead {
	border-right: 1px solid #ccc;
	border-left: 1px solid #ccc;
	background: #04162e;
}

table.type thead th {
	margin: 0 auto;
	text-align: center padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #fff;
}

table.type tbody th {
	margin: 0 auto;
	text-align: center;
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #efefef;
}

table.type td {
	margin: 0 auto;
	text-align: center;;
	width: 200px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

.err {
	text-align: center;
}

.bug {
	width: 100%;
}
</style>

<s:form cssClass="form-horizontal">
	<div class="text-right">
		<s:property value="UserID" />
		さん
	</div>

	<div class="form-group">
		<label for="Operator" class="col-sm-2 control-label"> 事業者: </label>
		<div class="col-md-3">
			<s:textfield name="operatorName" cssClass="form-control" rows="1"
				maxlength="50" />
		</div>

		<label for="PhoneName" class="col-sm-2 control-label"> 端末名: </label>
		<div class="col-md-3">
			<s:textfield name="PhoneName" cssClass="form-control" rows="1"
				maxlength="50" />
		</div>
	</div>
	<div class="form-group">
		<label for="phoneFinderPrice" class="col-sm-2 control-label">
			価格: </label>
		<div class="col-md-3">
			<s:textfield name="PriceLow" cssClass="form-control" rows="1"
				maxlength="50" />
		</div>
		<label class="col-sm-1 control-label">～<br />
		</label>
		<div class="col-md-4">
			<s:textfield name="PriceHi" cssClass="form-control" rows="1"
				maxlength="50" />
		</div>
		<div>
			<label class="col-sm-1 control-label">円</label>
		</div>
	</div>



	<div class="search">
		<div class="row">
			<div class="col-md-3">
				<s:submit method="search" value="検索"
					cssClass="btn btn-default btn-block" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<s:submit method="reset" value="リセット"
					cssClass="btn btn-primary btn-block" />
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<s:submit method="update" value="追加"
					cssClass="btn btn-danger btn-block" />
			</div>
		</div>
	</div>
	</div>

	<div class="bug">
		<div style="color: red ; padding-left:5%">
			<s:actionerror />
			<s:property value="msg" />
		</div>
		<s:if test="%{outputTable.size() > 0}">
			<table class="type">
				<tbody>
					<tr>
						<th>ID</th>
						<th>事業社名</th>
						<th>機種名</th>
						<th>価格</th>
						<th>画面サイズ</th>
						<th>発売日</th>
						<th>コメント</th>
						<th>削除</th>
					</tr>
					<s:iterator value="outputTable">
						<tr>
							<td class="data"><s:property value="ID" /></td>
							<td class="data"><s:property value="OperatorName" /></td>
							<td class="data"><s:property value="PhoneName" /></td>
							<td class="data"><s:property value="price" /> 円</td>
							<td class="data"><s:property value="Size" /></td>
							<td class="data"><s:property value="Date" /></td>
							<td class="data"><s:property value="Comment" /></td>
							<td class="data"><input type="checkbox" name="delete"
								value="<s:property value="ID" />:<s:property value="OperatorName" />:<s:property value="PhoneName" />" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<s:if test="%{outputTable.size>0}">
				<div align=right>
					<s:submit method="delete" name="delete" value="削除"
						cssClass="btn btn-danger" />
				</div>
			</s:if>
		</s:if>
</s:form>
</div>
<jsp:include page="footer.jsp" />