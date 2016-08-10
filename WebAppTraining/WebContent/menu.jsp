<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp" />
<body>
	<div class="container">
		<jsp:include page="logo.jsp" />
		<s:form cssClass="form-horizontal">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoPhoneSearch" value="携帯検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoHarasan" value="harasan"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoPlayerSearch" value="選手検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoHpiventSearch" value="H!Pイベント検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoCatcafeSearch" value="猫カフェ検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoSakeSearch" value="酒検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoBaseballSearch" value="語録検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoRiderSearch" value="MotoGP ライダー検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoSimSearch" value="SIM検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoNailSearch" value="ネイル検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="guitarSearch" value="ギター検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="aquariumSearch" value="水族館検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="gotoBeerbrandsSearch" value="ビール銘柄検索"
						cssClass="btn btn-warning" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="sneakersSearch" value="スニーカー検索"
						cssClass="btn btn-warning" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit method="dramaSearch" value="韓国ドラマ検索"
						cssClass="btn btn-warning" />
				</div>
			</div>


		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<s:submit method="thsSearch" value="講師検索" cssClass="btn btn-warning" />
			</div>
		</div>
		</s:form>
	</div>
</body>
</html>