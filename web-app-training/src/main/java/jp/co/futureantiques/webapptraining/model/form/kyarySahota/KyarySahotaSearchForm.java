package jp.co.futureantiques.webapptraining.model.form.kyarySahota;

import jp.co.futureantiques.webapptraining.model.kyarySahota.KyaryMainSahota;
import lombok.Data;

/**
 * 曲名検索画面のFormクラス
 *
 * @author futureantiques
 *
 */
@Data
public class KyarySahotaSearchForm {

	/** 曲ID */
	private Integer id;

	/** 曲名 */
	private String songTitle;

	/** CDID */
	private Integer nameId;

	/** CD形態ID */
	private Integer typeId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param kyaryMain
	 */
	public void setValues(KyaryMainSahota kyaryMainSahota) {
		this.setId((int) kyaryMainSahota.getId());
		this.setSongTitle(kyaryMainSahota.getSongTitle());
		this.setNameId(kyaryMainSahota.getNameId());
		this.setTypeId(kyaryMainSahota.getTypeId());
	}
}
