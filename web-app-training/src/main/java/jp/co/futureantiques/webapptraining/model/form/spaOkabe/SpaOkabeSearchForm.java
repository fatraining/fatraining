package jp.co.futureantiques.webapptraining.model.form.spaOkabe;

import jp.co.futureantiques.webapptraining.model.spaOkabe.SpaMainOkabe;
import lombok.Data;

/**
 *温泉地検索画面のFormクラス
 *
 * @author SEIYA OKABE
 *
 */
@Data
public class SpaOkabeSearchForm {

	/** ID */
	private Integer id;

	/** 温泉地名 */
	private String spaName;

	/** 都道府県ID */
	private Integer areaId;

	/** 泉質ID */
	private Integer qualityId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param spaMainOkabe
	 */
	public void setValues(SpaMainOkabe spaMainOkabe) {
		this.setId((int)spaMainOkabe.getId());
		this.setSpaName(spaMainOkabe.getSpaName());
		this.setAreaId(spaMainOkabe.getAreaId());
		this.setQualityId(spaMainOkabe.getQualityId());
	}

}
