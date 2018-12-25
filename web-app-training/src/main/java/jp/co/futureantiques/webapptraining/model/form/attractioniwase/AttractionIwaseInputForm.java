package jp.co.futureantiques.webapptraining.model.form.attractioniwase;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.attractioniwase.AttractionMainIwase;
import lombok.Data;

/**
 * アトラクション登録・更新画面用のFormクラス
 *
 * @author future
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
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String openDateStr;

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
	public void initWithAttractionMain(AttractionMainIwase attractionMain) {
		this.setId((int) attractionMain.getId());
		this.setAttractionName(attractionMain.getAttractionNameIwase());
		this.setThemeparkId(attractionMain.getThemeparkId());
		this.setOpenDateStr(String.valueOf(attractionMain.getOpenDate()));
		this.setComment(attractionMain.getComment());
		this.setUpdateDate(String.valueOf(attractionMain.getUpdateDate()));
	}

	/**
	 * AttractionMainエンティティに登録値を入れる
	 *
	 * @return AttractionMain
	 */
	public AttractionMainIwase convertToAttractionMainForInsert() {
		AttractionMainIwase attractionMain = new AttractionMainIwase();
		attractionMain = convertToAttractionMain(attractionMain);
		attractionMain.setCreateDate(new Timestamp(new Date().getTime()));
		attractionMain.setUpdateDate(attractionMain.getCreateDate());
		return attractionMain;
	}

	/**
	 * AttractionMainエンティティに更新値を入れる
	 *
	 * @param AttractionMainIwase attractionMain
	 * @return AttractionMain
	 */
	public AttractionMainIwase convertToAttractionMainForUpdate(AttractionMainIwase attractionMain) {
		attractionMain = convertToAttractionMain(attractionMain);
		attractionMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return attractionMain;
	}

	/**
	 * AttractionMainエンティティに入力値を入れる
	 *
	 * @param AttractionMainIwase attractionMain
	 * @return AttractionMain
	 */
	private AttractionMainIwase convertToAttractionMain(AttractionMainIwase attractionMain) {
		attractionMain.setAttractionNameIwase(this.attractionName);
		attractionMain.setThemeparkId(this.themeparkId);
		attractionMain.setOpenDate(Integer.parseInt(this.openDateStr));
		attractionMain.setComment(this.comment);
		attractionMain.setDelFlg("0");
		return attractionMain;
	}
}