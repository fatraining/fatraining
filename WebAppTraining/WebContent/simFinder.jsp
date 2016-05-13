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
			<h1 class=heading02>�����ʘbSim����</h1>

			<div class="text-right">
				<s:property value="UserID" />
				����
			</div>

			<a href="http://kjshintani.com/?p=6285">
				<div align="center">�Q�l�T�C�g:�i���X�}�z��MNP����BMVNO�����ʘbSIM�̔�r�܂Ƃ߁B</div>
			</a>


			<div class="form-group">
				<label class="col-sm-2 control-label">Sim�T�[�r�X���F</label>
				<div class="col-sm-10">
					<s:textfield class="form-control" name="simService"
						placeholder="Sim�T�[�r�X��" />
				</div>
			</div>

			<div class="form-group">
				<label for="simOpeName" class="col-sm-2 control-label"> ��Ж�:</label>
				<div class="col-sm-10">
					<s:select cssClass="form-control" name="simOpeID" list="simOpeMap" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="charge">�����F</label>
				<div class="col-sm-10">
					<s:textfield class="form-control" name="charge" placeholder="����" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="GB">GB�F</label>
				<div class="col-sm-10">
					<s:textfield class="form-control" name="GB" placeholder="GB" />
				</div>
			</div>

			<div class="search">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 ">
						<s:submit method="search" value="����"
							cssClass="btn btn-primary btn-block" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<div style="margin-top: 20px">
						<s:submit method="reset" value="���Z�b�g"
							cssClass="btn btn-default btn-block" />
					</div>
				</div>

				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<div style="margin-top: 20px">
						<s:submit method="update" value="�ǉ�"
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
							<th>Sim�T�[�r�X��</th>
							<th>��Ж�</th>
							<th>����</th>
							<th>GB(�ʐM���j</th>
							<th>�R�����g</th>
							<th>�폜</th>
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
				<s:submit method="delete" id="deleteBtn" value="�폜"
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
		// �폜�{�^���p
		//			$('#deleteBtn').click(function (e) {
		//				// delete ���\�b�h�����s���邽�߂̗v�f�𐶐�
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