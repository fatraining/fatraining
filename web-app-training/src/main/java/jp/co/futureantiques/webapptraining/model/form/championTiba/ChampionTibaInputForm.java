package jp.co.futureantiques.webapptraining.model.form.championTiba;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import lombok.Data;

@Data
public class ChampionTibaInputForm {
	private int id;

	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String championName;
	private Integer classId;
	private Integer countryId;

	@NotBlank(message = "common.text.error.require")
	@Size(max = 15, message = "common.text.error.size.max.four")
	private String achievement;
	@Size(max = 255)
	private String comment;
	private String updateDate;

	public void initWithChampionMainTiba(ChampionMainTiba championMainTiba) {
		this.setId((int) championMainTiba.getId());
		this.setChampionName(championMainTiba.getChampionName());
		this.setClassId(championMainTiba.getClassId());
		this.setCountryId(championMainTiba.getCountryId());
		this.setAchievement(championMainTiba.getAchievement());
		this.setComment(championMainTiba.getComment());
		this.setUpdateDate(String.valueOf(championMainTiba.getUpdateDate()));
	}

	public ChampionMainTiba convertToChampionMainTibaForInsert() {
		ChampionMainTiba championMainTiba = new ChampionMainTiba();
		championMainTiba = convertToChampionMainTiba(championMainTiba);
		championMainTiba.setCreateDate(new Timestamp(new Date().getTime()));
		championMainTiba.setUpdateDate(championMainTiba.getCreateDate());
		return championMainTiba;

	}

	public ChampionMainTiba convertToChampionMainTibaForUpdate(ChampionMainTiba championMainTiba) {
		championMainTiba = convertToChampionMainTiba(championMainTiba);
		championMainTiba.setUpdateDate(new Timestamp(new Date().getTime()));
		return championMainTiba;
	}

	private ChampionMainTiba convertToChampionMainTiba(ChampionMainTiba  championMainTiba ) {
		championMainTiba .setChampionName(this.championName);
		championMainTiba .setClassId(this.classId);
		championMainTiba .setCountryId(this.countryId);
		championMainTiba .setAchievement(this.achievement);
		championMainTiba .setComment(this.comment);
		championMainTiba .setDelFlg("0");
		return championMainTiba;
	}

}
