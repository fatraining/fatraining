package jp.co.futureantiques.webapptraining.model.form.bookUchiyama;

import jp.co.futureantiques.webapptraining.model.bookUchiyama.BookMainUchiyama;
import lombok.Data;

/**
 * 検索用フォーム
 * @author FutureAntiques
 */
@Data

public class BookUchiyamaSearchForm {

	/** 本ID */
	private Integer id;
	/** 本タイトル */
	private String bookTitle;
	/** ジャンルID */
	private Integer genreId;
	/** 作家ID */
	private Integer writerId;
	/** 削除フラグ */
	private int isDelete;

	/**
	 * 検索フォームに値をセット
	 * @param bookMainUchiyama
	 */
	public void setValues(BookMainUchiyama bookMainUchiyama) {
		this.setId((int) bookMainUchiyama.getId());
		this.setBookTitle(bookMainUchiyama.getBookTitle());
		this.setGenreId(bookMainUchiyama.getGenreId());
		this.setWriterId(bookMainUchiyama.getWriterId());
	}

}