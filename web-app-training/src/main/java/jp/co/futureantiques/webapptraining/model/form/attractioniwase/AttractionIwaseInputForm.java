package jp.co.futureantiques.webapptraining.model.form.attractioniwase;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.attractioniwase.AttractionMainIwase;
import lombok.Data;

/**
 * アトラクション登録・更新画面用のFormクラス
 *
 * @author iwase
 */
@Data
public class AttractionIwaseInputForm {

	/** ID */
	private int id;

	/** アトラクション名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String attractionName;

	/** テーマパークID */
	private Integer themeparkId;

	/** 開設年月 */
	private Integer openDateInt;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param AttractionMainIwase
	 */
	public void initWithAttractionMain(AttractionMainIwase attractionMainIwase) {
		this.setId((int) attractionMainIwase.getId());
		this.setAttractionName(attractionMainIwase.getAttractionName());
		this.setThemeparkId(attractionMainIwase.getThemeparkId());
		this.setOpenDateInt(attractionMainIwase.getOpenDate());
		this.setComment(attractionMainIwase.getComment());
		this.setUpdateDate(String.valueOf(attractionMainIwase.getUpdateDate()));
	}

	/**
	 * AttractionMainIwaseエンティティに登録値を入れる
	 *
	 * @return AttractionMain
	 */
	public AttractionMainIwase convertToAttractionMainForInsert() {
		AttractionMainIwase attractionMainIwase = new AttractionMainIwase();
		attractionMainIwase = convertToAttractionMain(attractionMainIwase);
		attractionMainIwase.setCreateDate(new Timestamp(new Date().getTime()));
		attractionMainIwase.setUpdateDate(attractionMainIwase.getCreateDate());
		return attractionMainIwase;
	}

	/**
	 * AttractionMainIwaseエンティティに更新値を入れる
	 *
	 * @param AttractionMainIwase attractionMainIwase
	 * @return AttractionMainIwase
	 */
	public AttractionMainIwase convertToAttractionMainForUpdate(AttractionMainIwase attractionMainIwase) {
		attractionMainIwase = convertToAttractionMain(attractionMainIwase);
		attractionMainIwase.setUpdateDate(new Timestamp(new Date().getTime()));
		return attractionMainIwase;
	}

	/**
	 * AttractionMainIwaseエンティティに入力値を入れる
	 *
	 * @param AttractionMainIwase attractionMainIwase
	 * @return AttractionMainIwase
	 */
	private AttractionMainIwase convertToAttractionMain(AttractionMainIwase attractionMainIwase) {
		attractionMainIwase.setAttractionName(this.attractionName);
		attractionMainIwase.setThemeparkId(this.themeparkId);
		attractionMainIwase.setOpenDate(this.openDateInt);
		attractionMainIwase.setComment(this.comment);
		attractionMainIwase.setDelFlg("0");
		return attractionMainIwase;
	}
}