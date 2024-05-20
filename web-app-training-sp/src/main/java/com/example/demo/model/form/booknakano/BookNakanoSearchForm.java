package com.example.demo.model.form.booknakano;

import com.example.demo.model.booknakano.BookMainNakano;

import lombok.Data;

/**
 * 書籍検索画面のFormクラス
 *
 * @author future
 */
@Data
public class BookNakanoSearchForm {

	/** ID */
	private Integer id;

	/** 書籍名 */
	private String bookTitle;

	/** 著者ID */
	private Integer authorId;

	/** 分類ID */
	private Integer classificationId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param bookMain
	 */
	public void setValues(BookMainNakano bookMain) {
		this.setId((int) bookMain.getId());
		this.setBookTitle(bookMain.getBookTitle());
		this.setAuthorId(bookMain.getAuthorId());
		this.setClassificationId(bookMain.getClassificationId());
	}
}
