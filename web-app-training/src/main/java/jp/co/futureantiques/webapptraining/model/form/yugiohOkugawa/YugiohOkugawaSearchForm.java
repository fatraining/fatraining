package jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa;

import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.YugiohMainOkugawa;
import lombok.Data;

/**
 * キャラクター検索画面のFormクラス
 *@author Okugawa
 */
@Data
public class YugiohOkugawaSearchForm {

	/** ID */
	private Integer id;

	/** キャラクター名 */
	private String name;

	/** 作品ID */
	private Integer seriesId;

	/** デッキID */
	private Integer deckId;

	/** 削除フラグON用 */
	private int isDelete;

	/** 各フィールドに値を設定する */
	public void setValues(YugiohMainOkugawa yugiohMainOkugawa) {
		this.setId((int)yugiohMainOkugawa.getId());
		this.setName(yugiohMainOkugawa.getName());
		this.setSeriesId(yugiohMainOkugawa.getSeriesId());
		this.setDeckId(yugiohMainOkugawa.getDeckId());
	}

}
