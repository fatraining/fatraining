<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集画面</title>
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<style>
div.container {
	width: 400px;
	margin-right: auto;
	margin-right: auto;
	padding: 10px 5px;
}
</style>
</head>
<body>
	<div class="container">
		<s:form>
			<div>
				<label class="col-md-4 control-label">日付: </label>
				<s:textfield name="date" cssClass="col-md-8 form-control" />
			</div>

			<div>
				<label class="col-md-4 control-label">金額: </label>
				<s:textfield type="text" name="money" class="form-control" />
			</div>

			<div>
				<label> <input type="radio" name="flg" value="income"
					id="income" /> 収入
				</label> <label> <input type="radio" name="flg" value="spending"
					id="spending" /> 支出 <br />
				</label>
			</div>

			<div>
				<label class="col-md-4 control-label">項目: </label>
				<s:textfield name="item" class="form-control" />
			</div>

			<div>
				<label class="col-md-4 control-label">備考: </label>
				<s:textfield name="memo" class="form-control"/>
			</div>

			<div class="col-md-offset-2 col-sm-10">
				<s:submit method="submit" value="完了" cssClass="btn btn-success" />
			</div>
		</s:form>
	</div>
</body>
</html>