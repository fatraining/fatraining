package jp.co.futureantiques.webapptraining.model.form.novelmiyamoto;

import jp.co.futureantiques.webapptraining.model.novelmiyamoto.BookMainMiyamoto;
import lombok.Data;

/**
 * 本の検索画面のFormクラス
 */
@Data
public class NovelSearchForm {
	/** ID */
	private Integer id;
	/** 本名 */
	private String bookTitle;
	/** ジャンルID */
	private Integer genreId;
	/** 作者ID */
	private Integer authorId;
	/** 削除フラグON用 */
	private int isDelete;
	/**
	 * 各フィールドに値を設定する
	 */
	public void setValues(BookMainMiyamoto bookMainMiyamoto) {
		this.setId((int) bookMainMiyamoto.getId());
		this.setBookTitle(bookMainMiyamoto.getBookTitle());
		this.setGenreId(bookMainMiyamoto.getGenreId());
		this.setAuthorId(bookMainMiyamoto.getAuthorId());
	}
}