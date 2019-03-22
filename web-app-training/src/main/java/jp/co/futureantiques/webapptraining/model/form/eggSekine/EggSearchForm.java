package jp.co.futureantiques.webapptraining.model.form.eggSekine;

import jp.co.futureantiques.webapptraining.model.eggsample.eggMain;
import lombok.Data;

/**
 * 映画検索画面のFormクラス
 *
 * @author future
 */
@Data
public class EggSearchForm {

	/** ID */
	private Integer id;

	/** 映画名 */
	private String eggTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 俳優ID */
	private Integer actorId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param eggMain
	 */
	public void setValues(eggMain eggMain) {
		this.setId((int) eggMain.getId());
		this.seteggTitle(eggMain.geteggTitle());
		this.setGenreId(eggMain.getGenreId());
		this.setActorId(eggMain.getActorId());
	}
}
