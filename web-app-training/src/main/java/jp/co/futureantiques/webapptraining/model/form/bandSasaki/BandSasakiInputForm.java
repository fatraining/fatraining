package jp.co.futureantiques.webapptraining.model.form.bandSasaki;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMain;
import lombok.Data;

@Data
public class BandSasakiInputForm {
	private int id;

	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String bandName;
	private Integer memberId;
	private Integer birthplaceId;

	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String formationYearStr;

	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|{+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseNumStr;

	@Size(max = 255)
	private String comment;
	private String updateDate;

	public void initWithBandMain(BandMain bandMain) {
		this.setId((int) bandMain.getId());
		this.setMemberId(bandMain.getMemberId());
		this.setBirthplaceId(bandMain.getBirthplaceId());
		this.setFormationYearStr(String.valueOf(bandMain.getFormationYear()));
		if (bandMain.getReleaseNum() != null) {
			this.setReleaseNumStr(String.valueOf(bandMain.getReleaseNum()));
		}
		this.setComment(bandMain.getComment());
		this.setUpdateDate(String.valueOf(bandMain.getUpdateDate()));
	}

	public BandMain convertToBandMainForInsert() {
		BandMain bandMain = new BandMain();
		bandMain = convertToBandMain(bandMain);
		bandMain.setCreateDate(new Timestamp(new Date().getTime()));
		bandMain.setUpdateDate(bandMain.getCreateDate());
		return bandMain;
	}

	private BandMain convertToBandMain(BandMain bandMain) {
		bandMain.setBandName(this.bandName);
		bandMain.setMemberId(this.memberId);
		bandMain.setBirthplaceId(this.birthplaceId);
		bandMain.setFormationYear(Integer.parseInt(this.formationYearStr));
		if (!this.releaseNumStr.isEmpty()) {
			bandMain.setReleaseNum(Integer.parseInt(this.releaseNumStr));
		} else {
			bandMain.setReleaseNum(null);
		}
		bandMain.setComment(this.comment);
		bandMain.setDelFlg("0");
		return bandMain;
	}

}
