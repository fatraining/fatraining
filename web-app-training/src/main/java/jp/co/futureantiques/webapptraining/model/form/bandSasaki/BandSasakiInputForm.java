package jp.co.futureantiques.webapptraining.model.form.bandSasaki;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMainSasaki;
import lombok.Data;

@Data
public class BandSasakiInputForm {
	private int id;

	private MultipartFile photo;

	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String bandName;
	private Integer memberId;
	private Integer birthplaceId;

	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String formationYearStr;

	private Integer releaseNum;

	@Size(max = 255)
	private String comment;
	private String updateDate;

	public void initWithBandMainSasaki(BandMainSasaki bandMainSasaki) {
		this.setId((int) bandMainSasaki.getId());
		this.setBandName(bandMainSasaki.getBandName());
		this.setMemberId(bandMainSasaki.getMemberId());
		this.setBirthplaceId(bandMainSasaki.getBirthplaceId());
		this.setFormationYearStr(String.valueOf(bandMainSasaki.getFormationYear()));
		this.setReleaseNum(bandMainSasaki.getReleaseNum());
		this.setComment(bandMainSasaki.getComment());
		this.setUpdateDate(String.valueOf(bandMainSasaki.getUpdateDate()));
	}

	public BandMainSasaki convertToBandMainSasakiForInsert() {
		BandMainSasaki bandMainSasaki = new BandMainSasaki();
		bandMainSasaki = convertToBandMainSasaki(bandMainSasaki);
		bandMainSasaki.setCreateDate(new Timestamp(new Date().getTime()));
		bandMainSasaki.setUpdateDate(bandMainSasaki.getCreateDate());
		return bandMainSasaki;
	}

	public BandMainSasaki convertToBandMainSasakiForUpdate(BandMainSasaki bandMainSasaki) {
		bandMainSasaki = convertToBandMainSasaki(bandMainSasaki);
		bandMainSasaki.setUpdateDate(new Timestamp(new Date().getTime()));
		return bandMainSasaki;
	}

	private BandMainSasaki convertToBandMainSasaki(BandMainSasaki bandMainSasaki) {
		bandMainSasaki.setBandName(this.bandName);
		bandMainSasaki.setMemberId(this.memberId);
		bandMainSasaki.setBirthplaceId(this.birthplaceId);
		bandMainSasaki.setFormationYear(Integer.parseInt(this.formationYearStr));
		bandMainSasaki.setReleaseNum(this.releaseNum);
		bandMainSasaki.setComment(this.comment);
		bandMainSasaki.setDelFlg("0");
		return bandMainSasaki;
	}

}
