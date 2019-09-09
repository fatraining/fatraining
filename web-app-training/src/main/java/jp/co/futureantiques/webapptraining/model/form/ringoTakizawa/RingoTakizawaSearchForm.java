package jp.co.futureantiques.webapptraining.model.form.ringoTakizawa;

import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoMainTakizawa;
import lombok.Data;

/**
 *椎名林檎の曲（プレイリスト）検索画面のFormクラス
 *htmlで入力した値を格納
 * @author Mai Takizawa
 *
 */
@Data
public class RingoTakizawaSearchForm {

	/** ID */
	private Integer id;

	/** 曲名 */
	private String songTitle;

	/** CD名ID nullがOKの時、Integer*/
	private Integer cdTitleId;

	/** 聞きたい気分ID */
	private Integer songImageId;

	/** 削除フラグON用 nullがNGの時、int*/
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param ringoMainTakizawa
	 */
	public void setValues(RingoMainTakizawa ringoMainTakizawa) {
		this.setId((int)ringoMainTakizawa.getId());
		this.setSongTitle(ringoMainTakizawa.getSongTitle());
		this.setCdTitleId(ringoMainTakizawa.getCdTitleId());
		this.setSongImageId(ringoMainTakizawa.getSongImageId());
	}

}
