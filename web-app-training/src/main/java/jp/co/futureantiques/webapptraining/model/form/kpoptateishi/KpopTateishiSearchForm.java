package jp.co.futureantiques.webapptraining.model.form.kpoptateishi;

import jp.co.futureantiques.webapptraining.model.kpoptateishi.KpopMain;
import lombok.Data;

/**
 * 楽曲検索画面のFormクラス
 *
 * @author future
 */
@Data
public class KpopTateishiSearchForm {

	/** ID */
	private Integer id;

	/** 楽曲名 */
	private String musicTitle;

	/** アイドルID */
	private Integer idolId;

	/** 所属事務所ID */
	private Integer officeId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param kpopMain
	 */
	public void setValues(KpopMain kpopMain) {
		this.setId((int) kpopMain.getId());
		this.setMusicTitle(kpopMain.getMusicTitle());
		this.setIdolId(kpopMain.getIdolId());
		this.setOfficeId(kpopMain.getOfficeId());
	}
}
