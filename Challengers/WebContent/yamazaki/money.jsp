<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>おこづかい帳</title>
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<style>
div.container {
	max-width: 1200px;
}

div.first-div {
	padding: 10px 5px;
}
div.first-div div {
	padding: 5px;
}

div.second-div {
	padding: 10px 5px;
}
div.second-div div {
	padding: 5px;
	text-align : right;
}
th {
	text-align : center;
}

</style>
</head>
<body>

	<div class="container">

		<div class="col-md-4 first-div">
			<s:form name="form1">
				<div>
					<label class="col-md-4 control-label">日付: </label>
					<input type="date" name="date"
						class="col-md-8 form-control" rows="10" />
				</div>

				<div>
					<label class="col-md-4 control-label">金額: </label>
					<input type="number" name="money" value="0" class="form-control" />
				</div>

				<div>
					<label> <input type="radio" name="flg" value="income"
						id="income" /> 収入
					</label>
					<label> <input type="radio" name="flg" value="spending"
						id="spending" /> 支出 <br/>
					</label>
				</div>

				<div>
					<label class="col-md-4 control-label">項目: </label>
					<s:textfield type="text" name="item" placeholder="項目を入力"
						class="form-control" />
				</div>

				<div>
					<label class="col-md-4 control-label">備考: </label>
					<s:textfield type="text" name="memo" class="form-control"
						rows="10" />
				</div>

				<div class="col-md-offset-2 col-sm-10">
					<s:submit method="submit" value="登録" style="cursor: pointer;" cssClass="btn btn-success" />
				</div>
			</s:form>
		</div>

		<div class="col-md-8 second-div">
			<div>
				<label class="col-md-2 control-label">残高: </label>
				<div class="col-md-2"><s:property value="balance"/> 円</div>
			</div>

			<div class="form-group　container">
				<table class="table table-bordered" name="table">
					<tr>
						<th> </th>
						<th>日付</th>
						<th>項目</th>
						<th>収入 (円)</th>
						<th>支出 (円)</th>
						<th>備考</th>
					</tr>

					<s:form>
					<s:iterator value="dtoList" status="st">
						<tr>
							<td><input type="checkbox" name="check" value=<s:property value="#st.index"/> /></td>
							<td align="center"><s:property value="date" /></td>
							<td align="left"><s:property value="item" /></td>
							<s:if test="%{flg=='income'}">
								<td align="right"><s:property value="money" /></td>
								<td align="right"></td>
							</s:if>
							<s:else>
								<td align="right"></td>
								<td align="right"><s:property value="money" /></td>
							</s:else>
							<td align="left"><s:property value="memo" /></td>
						</tr>
					</s:iterator>
					<s:submit method="delete" value="削除" />
					<s:submit method="gotoEdit" value="編集" />
					</s:form>
				</table>
			</div>

            <div>
			<label class="col-md-10 control-label">収入の合計: <br/>
			</label>
			<div><s:property value="sum1"/> 円</div>
			</div>

			<div>
			<label class="col-md-10 control-label">支出の合計: <br/>
			</label>
			<div><s:property value="sum2"/> 円</div>
			</div>

		</div>
	</div>

</body>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">