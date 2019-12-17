package jp.co.futureantiques.webapptraining.model.form.boowyWaki;

import jp.co.futureantiques.webapptraining.model.boowyWaki.BoowyMainWaki;
import lombok.Data;

/**
 * BOØWYの曲検索画面のFormクラス
 *
 */
@Data
public class BoowyWakiSearchForm {
	/** ID*/
	private Integer id;

	/** 曲名*/
	private String name;

	/** ジャンルID*/
	private Integer genreId;

	/** 作詞者ID*/
	private Integer songwriterId;

	/** 削除フラグON用*/
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param BoowyMainWaki
	 */
	public void setValues(BoowyMainWaki boowyMainWaki) {
		this.setId((int) boowyMainWaki.getId());
		this.setName(boowyMainWaki.getName());
		this.setGenreId(boowyMainWaki.getGenreId());
		this.setSongwriterId(boowyMainWaki.getSongwriterId());
	}
}
