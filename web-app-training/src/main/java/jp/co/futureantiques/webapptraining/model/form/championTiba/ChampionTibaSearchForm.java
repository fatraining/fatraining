package jp.co.futureantiques.webapptraining.model.form.championTiba;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import lombok.Data;

/** Champion検索画面のFormクラス */


 @Data
public class ChampionTibaSearchForm{

	/** ID */
	private Integer id;

	/** チャンピオン名 */
	private String championName;

	/** 階級ID */
	private Integer classId;

	/** 国名ID */
	private Integer countryId;

	/** 削除フラグON用 */
	private int isDelete;
	/**
	 * 各フィールドに値を設定する
	 *
	 * @param championMainTiba
	 */

	public void setValues(ChampionMainTiba championMainTiba) {
		this.setId((int)championMainTiba.getId());
		this.setChampionName(championMainTiba.getChampionName());
		this.setClassId(championMainTiba.getClassId());
		this.setCountryId(championMainTiba.getCountryId());

	}
}