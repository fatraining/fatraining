package jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.YugiohMainOkugawa;
import lombok.Data;

/**
 * キャラクター登録・更新画面用のFormクラス
 *
 *@author user Okugawa
 */
@Data
public class YugiohOkugawaInputForm {

	/** ID */
	private int id;

	/** キャラクター名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String name;

	/** 作品ID */
	@NotNull(message = "common.text.error.require")
	@Min(value=1, message = "common.text.error.require")
	private Integer seriesId;

	/** デッキID */
	private Integer deckId;

	/** 召喚法 */
	private String summons;

	/** コメント */
	@Size(max= 255)
	private String comment;

	/** 更新日時 */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param yugiohMainOkugawa
	 */
	public void initWithYugiohMainOkugawa(YugiohMainOkugawa yugiohMainOkugawa) {
		this.setId((int)yugiohMainOkugawa.getId());
		this.setName(yugiohMainOkugawa.getName());
		this.setSeriesId(yugiohMainOkugawa.getSeriesId());
		this.setDeckId(yugiohMainOkugawa.getDeckId());
		this.setSummons(yugiohMainOkugawa.getSummons());
		this.setComment(yugiohMainOkugawa.getComment());
		this.setUpdateDate(String.valueOf(yugiohMainOkugawa.getUpdateDate()));
	}

	/**
	 * YugiohMainOkugawa
	 *
	 * @return YugiohMainOkugawa
	 */
	public YugiohMainOkugawa convertToYugiohMainOkugawaForInsert() {
		YugiohMainOkugawa yugiohMainOkugawa = new YugiohMainOkugawa();
		yugiohMainOkugawa = convertToYugiohMainOkugawa(yugiohMainOkugawa);
		yugiohMainOkugawa.setCreateDate(new Timestamp(new Date().getTime()));
		yugiohMainOkugawa.setUpdateDate(yugiohMainOkugawa.getCreateDate());
		return yugiohMainOkugawa;
	}

	/**
	 *YugiohMainOkugawaエンティティに更新値を入れる
	 *
	 * @param YugiohMainOkugawa yugiohMainOkugawa
	 * @return YugiohMainOkugawa
	 */
	public YugiohMainOkugawa convertToYugiohMainOkugawaForUpdate(YugiohMainOkugawa yugiohMainOkugawa) {
		yugiohMainOkugawa = convertToYugiohMainOkugawa(yugiohMainOkugawa);
		yugiohMainOkugawa.setUpdateDate(new Timestamp(new Date().getTime()));
		return yugiohMainOkugawa;
	}

	/**
	 * YugiohMainOkugawaエンティティに更新値を入れる
	 *
	 * @param YugiohMainOkugawa yugiohMainOkugawa
	 * @return YugiohMainOkugawa
	 */
	private YugiohMainOkugawa convertToYugiohMainOkugawa(YugiohMainOkugawa yugiohMainOkugawa) {
		yugiohMainOkugawa.setName(this.name);
		yugiohMainOkugawa.setSeriesId(this.seriesId);
		if(this.deckId != 0) {
			yugiohMainOkugawa.setDeckId(this.deckId);
		}else {
			yugiohMainOkugawa.setDeckId(null);
		}
		if(!this.summons.isEmpty()) {
			yugiohMainOkugawa.setSummons(this.summons);
		}else {
			yugiohMainOkugawa.setSummons(null);
		}
		if(!this.comment.isEmpty()) {
			yugiohMainOkugawa.setComment(this.comment);
		}else {
			yugiohMainOkugawa.setComment(null);
		}
		yugiohMainOkugawa.setDelFlg("0");
		return yugiohMainOkugawa;
	}
}
