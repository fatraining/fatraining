package jp.co.futureantiques.webapptraining.model.form.championTiba;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import lombok.Data;

@Data
public class ChampionTibaInputForm {

	/** ID */
	private int id;

	/** チャンピオン名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String championName;

	/** 階級 */
	private Integer classId;

	/** 国名 */
	private Integer countryId;

	/** 戦績 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 15, message = "common.text.error.size.max.four")
	private String achievement;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時 */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 */
	public void initWithChampionMainTiba(ChampionMainTiba championMainTiba) {
		this.setId((int) championMainTiba.getId());
		this.setChampionName(championMainTiba.getChampionName());
		this.setClassId(championMainTiba.getClassId());
		this.setCountryId(championMainTiba.getCountryId());
		this.setAchievement(championMainTiba.getAchievement());
		this.setComment(championMainTiba.getComment());
		this.setUpdateDate(String.valueOf(championMainTiba.getUpdateDate()));
	}

	/**
	 * ChampionMainTibaエンティティに登録値を入れる
	 */
	public ChampionMainTiba convertToChampionMainTibaForInsert() {
		ChampionMainTiba championMainTiba = new ChampionMainTiba();
		championMainTiba = convertToChampionMainTiba(championMainTiba);
		championMainTiba.setCreateDate(new Timestamp(new Date().getTime()));
		championMainTiba.setUpdateDate(championMainTiba.getCreateDate());
		return championMainTiba;

	}

	/**
	 * ChampionMainTibaエンティティに更新値を入れる
	 *
	 */
	public ChampionMainTiba convertToChampionMainTibaForUpdate(ChampionMainTiba championMainTiba) {
		championMainTiba = convertToChampionMainTiba(championMainTiba);
		championMainTiba.setUpdateDate(new Timestamp(new Date().getTime()));
		return championMainTiba;
	}

	/**
	 * ChampionMainTibaエンティティに入力値を入れる
	 *
	 */
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
