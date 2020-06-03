package jp.co.futureantiques.webapptraining.model.form.cdKanayama;

import jp.co.futureantiques.webapptraining.model.cdKanayama.CdMainKanayama;
import lombok.Data;

/**
 * CD検索画面のFormクラス
 *
 * @author future
 */
@Data

public class CdKanayamaSearchForm {

	/** ID */
	private Integer id;

	/** CDタイトル */
	private String cdTitle;

	/** アーティスト名 */
	private String artistName;

	/** リリース年 */
	private Integer releaseYear;



	/** ジャンルID */
	private Integer genreId;


	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param cdMain
	 */

	public void setValues(CdMainKanayama cdMain) {
		this.setId((int) cdMain.getId());
		this.setCdTitle(cdMain.getCdTitle());
		this.setArtistName(cdMain.getArtistName());
		this.setReleaseYear(cdMain.getReleaseYear());
		this.setGenreId(cdMain.getGenreId());
	}

}

