<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="Windows-31J"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="header.jsp"/>

<head>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/tablesorter-blue/style.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<s:url value="/assets/css/riderSearch.css"/>"/>
	<script type="text/javascript" src="<s:url value="/assets/js/jquery.tubular.1.0.js"/>"></script>
	<script type="text/javascript" src="<s:url value="/assets/js/riderSearch.js"/>"></script>
</head>
<style>
	#wrapper{
	position: relative;
	width: 100%;
	height: 100%;
	background: url(assets/images/07.png);
	}
</style>
<body>
	<!-- form�őS�̂��͂ނ��ƂŁA�l�̎󂯓n�����s����悤�ɂȂ� -->
	<s:form>
	<div id="wrapper">
		<div class="container">
			<jsp:include page="logo.jsp"/>
			<p class="text-right">
				<a href="menu.action" >Back</a>
			</p>
			<br>
			<h1 class="h3 text left" id="header">
			<a href="riderSearch.action">MotoGP Rider Search<br/>-2016-</a></h1>

			<div class="text-right" style="color:white">
				<s:property value="UserID"/>����
			</div>
			<!-- ���v -->
			<div id="clock-02" class="text-center"></div>

			<div class="form-group">
				<!-- row�̓R���e���c���܂Ƃ߂���� -->
				<div class="row">

					<!-- ���b�Z�[�W�̕\�� -->
					<div class="err"style="color:red">
						<s:actionerror />
						<s:property value="msg"/>
					</div>

					<!-- col-md-4��Bootstrap�̋@�\
					     col=�J�����ŁA12�������Ă���J�����̂����̉����g�������w��ł���B
					     md�͑傫���ŁAsm�Alg������B -->
					<div class="col-md-4">
						<div class="numText">
							<label for="Number"style="color:white">Number:</label>
								<s:textfield name="number" cssClass="form-control" placeholder="�[�b�P���i���o�[" />
						</div>
					</div>

					<div class="teamName">
						<div class="col-md-8">
							<label for="teamName" style="color:white">�`�[���F</label>
								<s:textfield name="teamName" cssClass="form-control" placeholder="���ނ��Ă�l��Retirement"/>
						</div>
					</div>

					<div class="riderName">
						<div class="col-md-12">
							<label for="riderName" style="color:white">���C�_�[���F</label>
								<s:textfield name="riderName" cssClass="form-control" placeholder="�A���t�@�x�b�g�œ���"/>
						</div>
					</div>
				</div>
			</div>


			<div class="search">
				<div class="row">
					<div class="col-md-12">

						<!-- �{�^���̐F��btn btn-�̂��Ƃ̕����ɂ���ĕς�� -->
						<s:submit method="search" value="����" cssClass="btn btn-primary btn-block" />
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<s:submit method="reset" value="���Z�b�g" cssClass="btn btn-success btn-block"/>
					</div>
				</div>

				<div class="row">
					<div class="col-md-12">
						<s:submit method="update" value="�ǉ�" cssClass="btn btn-danger btn-block"/>
					</div>
				</div>
			</div>

				<!-- if���B�e�[�u����\������B�������ʂ������Ȃ��Ƃ��ȊO�͂Ƃ肠�����ł�B -->
				<s:if test="%{outputTable.size() > 0}">
					<table class="tablesorter" id=rider>
						<thead>
							<!-- tr�͗����� -->
							<tr><!-- th�͗�̌��o�� -->
								<th>Number</th>
								<th>�`�[��</th>
								<th>���O</th>
								<th>����</th>
								<th>�N��</th>
								<th>�a����</th>
								<th>�R�����g</th>
								<th>�폜</th>
							</tr>
						</thead>
						<tbody>
							<!-- �l�̎擾�ƕ\���Biterator��Jsp���ł̌J��Ԃ������̂���
							     outputTable���擾���A���镪�����l������U���ĕ\��������B
							     ���镪������邩��J��Ԃ��Ȃ��ƃ_���B -->
							<s:iterator value="outputTable">
								<tr>
									<td class="data"><s:property value="Number"/></td>
									<td class="data"><s:property value="TeamName"/></td>
									<td class="data"><s:property value="RiderName"/></td>
									<td class="data"><s:property value="Country"/></td>
									<td class="data"><s:property value="Age"/></td>
									<td class="data"><s:property value="BirthDay"/></td>
									<td class="data"><s:property value="Comment"/></td>
									<!--���`�F�b�N�{�b�N�X�Ɋ��蓖�Ă��Ă���l -->
									<td class="data"><input type="checkbox" name="delete"
										value="<s:property value="ID"/>
										:<s:property value="TeamName"/>
										:<s:property value="RiderName"/>"/>
									</td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</s:if>
				<!-- �폜�{�^���̐ݒ� -->
				<s:if test="%{outputTable.size>0}">
					<!-- �E���ɏo�� -->
					<div align=right>
						<s:submit method="delete"
						id="deleteBtn"
							value="�폜"
							cssClass="btn btn-danger"
						/>
					</div>
				</s:if>
		</div>
		</div>
	</s:form>



</body>
</html>