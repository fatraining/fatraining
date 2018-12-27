package jp.co.futureantiques.webapptraining.model.form.attractioniwase;

import jp.co.futureantiques.webapptraining.model.attractioniwase.AttractionMainIwase;
import lombok.Data;

/**
 * アトラクション検索画面のFormクラス
 *
 * @author iwase
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
	 * @param attractionMainIwase
	 */
	public void setValues(AttractionMainIwase attractionMainIwase) {
		this.setId((int) attractionMainIwase.getId());
		this.setAttractionName(attractionMainIwase.getAttractionName());
		this.setThemeparkId(attractionMainIwase.getThemeparkId());
	}
}
