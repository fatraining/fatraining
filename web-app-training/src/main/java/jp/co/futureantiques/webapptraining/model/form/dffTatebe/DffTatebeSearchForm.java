package jp.co.futureantiques.webapptraining.model.form.dffTatebe;

import jp.co.futureantiques.webapptraining.model.dffTatebe.DffMainTatebe;
import lombok.Data;
/**
 * キャラクター検索画面のFormクラス
 *@author Tatebe
 */
@Data
public class DffTatebeSearchForm {

	/** ID */
	private Integer id;

	/** キャラクター名 */
	private String dffName;

	/** 作品ID */
	private Integer titleId;

	/** デッキID */
	private Integer typeId;

	/** 削除フラグON用 */
	private int isDelete;

	/** 各フィールドに値を設定する */
	public void setValues(DffMainTatebe dffMainTatebe) {
		this.setId((int)dffMainTatebe.getId());
		this.setDffName(dffMainTatebe.getDffName());
		this.setTitleId(dffMainTatebe.getTitleId());
		this.setTypeId(dffMainTatebe.getTypeId());
	}

}
