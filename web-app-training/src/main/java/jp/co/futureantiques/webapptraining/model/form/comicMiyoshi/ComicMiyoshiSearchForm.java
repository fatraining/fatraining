package jp.co.futureantiques.webapptraining.model.form.comicMiyoshi;

import jp.co.futureantiques.webapptraining.model.comicMiyoshi.ComicMainMiyoshi;
import lombok.Data;

/**
 * 漫画検索画面のFormクラス
 * @author Miyoshi
 */
@Data
public class ComicMiyoshiSearchForm {

	/** 漫画ID */
	private Integer id;

	/** 漫画タイトル */
	private String comicTitle;

	/** 原作者名 */
	private String author;

	/** 連載雑誌名 */
	private Integer magazineId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 * @param comicMainMiyoshi
	 */
	public void setValue(ComicMainMiyoshi comicMainMiyoshi) {
		this.setId((int) comicMainMiyoshi.getId());
		this.setComicTitle(comicMainMiyoshi.getComicTitle());
		this.setAuthor(comicMainMiyoshi.getAuthor());
		this.setMagazineId(comicMainMiyoshi.getMagazineId());
	}
}
