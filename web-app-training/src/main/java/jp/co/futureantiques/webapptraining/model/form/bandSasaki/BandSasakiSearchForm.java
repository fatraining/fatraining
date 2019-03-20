package jp.co.futureantiques.webapptraining.model.form.bandSasaki;

import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMain;
import lombok.Data;

@Data

public class BandSasakiSearchForm{
	private Integer id;
	private String bandName;
	private Integer memberId;
	private Integer birthplaceId;
	private int isDelete;


	public void setValues(BandMain bandMain) {
		this.setId((int)bandMain.getId());
		this.setBandName(bandMain.getBandName());
		this.setMemberId(bandMain.getMemberId());
		this.setBirthplaceId(bandMain.getBirthplaceId());

	}
}