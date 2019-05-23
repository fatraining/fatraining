package jp.co.futureantiques.webapptraining.model.form.RuinsKurihara;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.RuinsKurihara.RuinsMainKurihara;
import lombok.Data;

/**
 * 廃墟登録・更新画面用のFormクラス
 * @author m.kurihara
 */
@Data
public class RuinsKuriharaInputForm {

	/** ID */
	private int id;

	/** 廃墟名 */

	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String ruinsName;

	/** 種別ID */
	private Integer genreId;

	/** 地域ID */
	private Integer areaId;

	/** 年代 */
	@Size(max = 255)
	private String since;

	/** 概要 */
	@Size(max = 255)
	private String backStory;

	/** コメント */
	@Size(max = 255)
	private String rem;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param ruinsMainKurihara
	 */
	public void initWithRuinsMain(RuinsMainKurihara ruinsMain) {
		this.setId((int) ruinsMain.getId());
		this.setRuinsName(ruinsMain.getRuinsName());
		this.setGenreId(ruinsMain.getGenreId());
		this.setAreaId(ruinsMain.getAreaId());
		this.setSince(String.valueOf(ruinsMain.getSince()));
		this.setBackStory(ruinsMain.getBackStory());
		this.setRem(ruinsMain.getRem());
		this.setUpdateDate(String.valueOf(ruinsMain.getUpdateDate()));
	}

	/**
	 * RuinsMainKuriharaエンティティに登録値を入れる
	 *
	 * @return RuinsMainKurihara
	 */
	public RuinsMainKurihara convertToRuinsMainForInsert() {
		RuinsMainKurihara ruinsMain = new RuinsMainKurihara();
		ruinsMain = convertToRuinsMain(ruinsMain);
		ruinsMain.setCreateDate(new Timestamp(new Date().getTime()));
		ruinsMain.setUpdateDate(ruinsMain.getCreateDate());
		return ruinsMain;
	}

	/**
	 * RuinsMainKuriharaエンティティに更新値を入れる
	 *
	 * @param AreaKurihara ruinsMain
	 * @return RuinsMainKurihara
	 */
	public RuinsMainKurihara convertToRuinsMainForUpdate(RuinsMainKurihara ruinsMain) {
		ruinsMain = convertToRuinsMain(ruinsMain);
		ruinsMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return ruinsMain;
	}

	/**
	 * RuinsMainKuriharaエンティティに入力値を入れる
	 *
	 * @param AreaKurihara ruinsMain
	 * @return RuinsMainKurihara
	 */
	private RuinsMainKurihara convertToRuinsMain(RuinsMainKurihara ruinsMain) {
		ruinsMain.setRuinsName(this.ruinsName);
		ruinsMain.setGenreId(this.genreId);
		ruinsMain.setAreaId(this.areaId);
		ruinsMain.setSince(this.since);
		ruinsMain.setBackStory(this.backStory);
		ruinsMain.setRem(this.rem);
		ruinsMain.setDelFlg("0");
		return ruinsMain;
	}
}