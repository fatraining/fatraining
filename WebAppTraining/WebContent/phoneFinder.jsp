<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<jsp:include page="header.jsp" />

	<link rel="stylesheet" type="text/css"
		href="/WebApp/assets/css/tablesorter-blue/style.css" />
	<script type="text/javascript"
		src="/WebApp/assets/js/jquery.tablesorter.min.js"></script>
	<style>
		div.search {
			margin-left: 40%;
		}
		div.row {
			padding: 20px 0;
		}
		/* 02.�e�[�v */
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

		.err {
			text-align: center;
		}

		.bug {
			width: 100%;
		}
	</style>

	<body>
		<div class="container">
			<jsp:include page="logo.jsp" />
			<p class="text-right">
				<a href="menu.action">Back</a>
			</p>
			<br>
			<h1 class="h3 text-left" id="heading02">�g�ь���</h1>

			<s:form cssClass="form-horizontal">
			<div class="text-right">
				<s:property value="UserID" />
				����
			</div>

			<div class="form-group">
				<label for="Operator" class="col-sm-2 control-label"> ���Ǝ�: </label>
				<div class="col-md-3">
					<s:textfield name="operatorName" cssClass="form-control" rows="1"
						maxlength="50" />
				</div>

				<label for="PhoneName" class="col-sm-2 control-label"> �[����: </label>
				<div class="col-md-3">
					<s:textfield name="PhoneName" cssClass="form-control" rows="1"
						maxlength="50" />
				</div>
			</div>
			<div class="form-group">
				<label for="phoneFinderPrice" class="col-sm-2 control-label">
					���i: </label>
				<div class="col-md-3">
					<s:textfield name="PriceLow" cssClass="form-control" rows="1"
						maxlength="50" />
				</div>
				<label class="col-sm-1 control-label">�`<br />
				</label>
				<div class="col-md-4">
					<s:textfield name="PriceHi" cssClass="form-control" rows="1"
						maxlength="50" />
				</div>
				<div>
					<label class="col-sm-1 control-label">�~</label>
				</div>
			</div>

			<div class="search">
				<div class="row">
					<div class="col-md-3">
						<s:submit method="search" value="����"
							cssClass="btn btn-default btn-block" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<s:submit method="reset" value="���Z�b�g"
							cssClass="btn btn-primary btn-block" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<s:submit method="update" value="�ǉ�"
							cssClass="btn btn-danger btn-block" />
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
					<table class="tablesorter" id="phones">
						<thead>
							<tr>
								<th>ID</th>
								<th>���ƎЖ�</th>
								<th>�@�햼</th>
								<th>���i(�~)</th>
								<th>��ʃT�C�Y</th>
								<th>������</th>
								<th>�R�����g</th>
								<th>�폜</th>
							</tr>
							</thead>
							<tbody>
							<s:iterator value="outputTable">
								<tr>
									<td class="data"><s:property value="ID" /></td>
									<td class="data"><s:property value="OperatorName" /></td>
									<td class="data"><s:property value="PhoneName" /></td>
									<td class="data"><s:property value="price" /></td>
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
							<s:submit method="delete" name="delete" value="�폜"
								cssClass="btn btn-danger" />
						</div>
					</s:if>
				</s:if>
			</div>
			</s:form>
			<script>
				$(document).ready((function($) {

				$('#phones').tablesorter({
					  widgets: ['zebra'],
					  headers: {

			    			7: {sorter:false}
						  }
				});
				}));
			</script>
	</body>
</html>