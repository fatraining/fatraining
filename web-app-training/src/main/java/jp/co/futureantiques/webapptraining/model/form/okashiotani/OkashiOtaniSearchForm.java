package jp.co.futureantiques.webapptraining.model.form.okashiotani;

import jp.co.futureantiques.webapptraining.model.okashiotani.OkashiMainOtani;
import lombok.Data;

/**
 * お菓子検索画面のFormクラス
 *
 * @author future
 */
@Data
public class OkashiOtaniSearchForm {


	/** ID */
	private Integer id;

	/** お菓子名 */
	private String okashiName;

	/** 種類ID */
	private Integer typeId;

	/** メーカーID */
	private Integer makerId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param okashiMainOtani
	 */
	public void setValues(OkashiMainOtani okashiMain) {
		this.setId((int) okashiMain.getId());
		this.setOkashiName(okashiMain.getOkashiName());
		this.setTypeId(okashiMain.getTypeId());
		this.setMakerId(okashiMain.getMakerId());
	}

}
