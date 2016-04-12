<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="Shift_JIS"%>

<!DOCTYPE html>
<html>
<head>
<title>Hello Struts2</title>
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" />
<style>
div.container {
	max-width: 1200px;
}

div.top-div {
	height: 50px;
}

div.first-div {
	padding: 10px 5px;
	border: 2px solid silver;
}

div.second-div {
	padding: 10px 5px;
	border: 1px solid silver;
}

div.second-div div {
	padding: 5px;
}

div.cent {
	text-align: center;
}

div.light {

}

div.green {
	background-color: green;
}

h3:first-letter {
	font-weight: bold;
	font-size: 120px;
	color: red;
}

.left {
	color: green;
	font-size: 40px;
	text-align: left;
}

div a {
	display: block;
}

a.adult {
	width: 50px;
}

/* --- ���o���G���A --- */
div.heading {
	width: 598px; /* ���o���G���A�̕� */
	margin-bottom: 1em;
	background: #f9f9f9 url(heading_back1.gif) repeat-x; /* ���o���G���A�̔w�i */
	border: #c0c0c0 solid; /* ���o���G���A�̋��E���i�F�A�X�^�C���j */
	border-width: 1px 1px 2px; /* ���o���G���A�̋��E���i���� ��A���E�A���j */
}

/* --- ���o�� --- */
div.heading h4 {
	margin: 0;
	padding: 7px 7px 4px; /* ���o���̃p�f�B���O�i��A���E�A���j */
	border-bottom: 2px #4169e1 solid; /* ���o���̉����E�� */
	font-size: 100%; /* ���o���̕����T�C�Y */
	line-height: 100%;
}

div.photo {
	padding: 10px; /* �p�f�B���O */
	background-color: #ffffff; /* �w�i�F */
	border: 1px solid; /* ���E�� */
	border-color: #c0c0c0 #808080 #808080 #c0c0c0; /* ���E���F�i��E�����j */
}

div.nyan {
	float: right;
}
</style>
</head>
<div class="heading">
	<h2>YamazonJapan�����z�[���y�[�W</h2>
</div>
<body>
	<div class="cent">
		<form>
			<script type="text/javascript">

			</script>
		</form>
	</div>
	<FORM>
		<H5>�����̋C���́H</H5>
		<SELECT name="kibun">
			<OPTION value="saikou">�߂��Ⴂ���I�I</OPTION>
			<OPTION value="botiboti">�܂��܂������I</OPTION>
			<OPTION value="hutuu">����</OPTION>
			<OPTION value="saiaku">�ň��E�E</OPTION>
		</SELECT>
	</FORM>
	<div class="container">
		<div class="nyan">
			<p>
				<img src="./imgs/photo.jpg" alt="Photo" width="300" height="225"
					class="photo">
			</p>
		</div>
		<div class="cent">
			<div class="text-left">
				<div class="left">
					<marquee scrolldelay="30" truespeed scrollamount="50"
						style="width: 400px; height: 20; background: url(http://plaza.rakuten.co.jp/img/user/99/06/4429906/39.gif); background-attachment: fixed; border-style: inset; padding: 10px;"
						loop="0">
						<b>Yamazon&hearts;047-***-****</b>
					</marquee>
				</div>
			</div>
			<div class="green">
				<div class="text-right">
					<h3 class="first-Letter">Yamazon Japan</h3>
					<a class="adult" onclick="location.href='secret.jsp'">��l�p</a>
				</div>
				<p></p>
				<script type="text/javascript">
				<!--
					var now = new Date();

					// �\���J�n
					document.write(now.toLocaleString());
					// �\���I��
				// -->
				</script>

				<div class="col-md-12 top-div">
					<div class="cent">
						<!--�{�^���������^�O�@�v���_�E����I��Ń{�^���������ƌ��ʂ�send��Action����send���\�b�h�܂ŉ^��  -->
						<form name="myForm">
							<s:select name="year" value="year"
								list="#{'2014':'2014','2015':'2015','2016':'2016'}" />
							<s:select name="month" value="month" list="monthArray" />
							<s:submit method="send" value="go" cssClass="btn btn-primary" />
						</form>
					</div>
				</div>
				<!-- iterator��iterator�ň͂�ł�����̂��J��Ԃ��B�z��Ȃǂ͂�����g���B -->
				<div class="col-md-12 first-div">
					<s:iterator value="historyOfMonth" status="st">
						<div class="col-md-12">
							<label class="col-md-12 form-control"><s:property /></label>
						</div>
					</s:iterator>
					<script type="text/javascript">
					<!--
						function myGo() {
							mySelect = document.myForm.myMenu.selectedIndex;
							location.href = document.myForm.myMenu.options[mySelect].value;
						}
					// -->
					</script>
				</div>
			</div>
		</div>
		<div class="text-right">
			<div class="back">
				<a href="login">Go Sign Out</a>
			</div>
		</div>
		<div class="text-left">
			<div class="back">
				<a href="mailform">���ӌ����v�]�͂�����</a>
			</div>
		</div>
	</div>
</body>
</html>