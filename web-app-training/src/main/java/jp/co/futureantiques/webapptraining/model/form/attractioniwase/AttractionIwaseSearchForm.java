package jp.co.futureantiques.webapptraining.model.form.attractioniwase;

import jp.co.futureantiques.webapptraining.model.attractioniwase.AttractionMain;
import lombok.Data;

/**
 * アトラクション検索画面のFormクラス
 *
 * @author future
 */
@Data
public class AttractionIwaseSearchForm {

	/** ID */
	private Integer id;

	/**アトラクション名 */
	private String attractionName;

	/** テーマパークID */
	private Integer themeparkId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param attractionMain
	 */
	public void setValues(AttractionMain attractionMain) {
		this.setId((int) attractionMain.getId());
		this.setAttractionName(attractionMain.getAttractionName());
		this.setThemeparkId(attractionMain.getThemeparkId());
	}
}
