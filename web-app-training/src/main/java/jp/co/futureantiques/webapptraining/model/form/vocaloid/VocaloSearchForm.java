package jp.co.futureantiques.webapptraining.model.form.vocaloid;

import jp.co.futureantiques.webapptraining.model.vocaloid.VocaloMain;
import lombok.Data;

/**
 * 映画検索画面のFormクラス
 *
 * @author future
 */
@Data
public class VocaloSearchForm {

	/** ID */
	private Integer id;

	/** 曲名 */
	private String vocaloTitle;

	/** PID */
	private Integer pId;

	/** ジャンルID */
	private Integer genreId;

	/** おすすめ歌い手ID */
	private Integer utaiteId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param vocaloMain
	 */
	public void setValues(VocaloMain vocaloMain) {
		this.setId((int) vocaloMain.getId());
		this.setVocaloTitle(vocaloMain.getVocaloTitle());
		this.setPId(vocaloMain.getPId());
		this.setGenreId(vocaloMain.getGenreId());
		this.setUtaiteId(vocaloMain.getUtaiteId());
	}
}
