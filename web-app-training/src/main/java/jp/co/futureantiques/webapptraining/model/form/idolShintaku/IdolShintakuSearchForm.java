package jp.co.futureantiques.webapptraining.model.form.idolShintaku;

import jp.co.futureantiques.webapptraining.model.idolShintaku.IdolMainShintaku;
import lombok.Data;

/**
 * アイドル検索画面のFormクラス
 *
 * @author shintaku
 *
 */
@Data
public class IdolShintakuSearchForm {

	/** ID */
	private Integer id;

	/** アイドル名 */
	private String name;

	/** 属性ID */
	private Integer typeId;

	/** ユニットID */
	private Integer unitId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param idolMainShintaku
	 */
	public void setValues(IdolMainShintaku idolMainShintaku) {
		this.setId((int) idolMainShintaku.getId());
		this.setName(idolMainShintaku.getName());
		this.setTypeId(idolMainShintaku.getTypeId());
		this.setUnitId(idolMainShintaku.getUnitId());
	}
}