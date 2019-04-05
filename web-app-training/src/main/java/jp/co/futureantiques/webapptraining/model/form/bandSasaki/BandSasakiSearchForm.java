package jp.co.futureantiques.webapptraining.model.form.bandSasaki;

import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMainSasaki;
import lombok.Data;

@Data

public class BandSasakiSearchForm{
	private Integer id;
	private String bandName;
	private Integer memberId;
	private Integer birthplaceId;
	private int isDelete;


	public void setValues(BandMainSasaki bandMainSasaki) {
		this.setId((int)bandMainSasaki.getId());
		this.setBandName(bandMainSasaki.getBandName());
		this.setMemberId(bandMainSasaki.getMemberId());
		this.setBirthplaceId(bandMainSasaki.getBirthplaceId());

	}
}