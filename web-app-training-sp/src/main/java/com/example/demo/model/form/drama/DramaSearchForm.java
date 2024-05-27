package com.example.demo.model.form.drama;

import com.example.demo.model.drama.DramaMainNakaniwa;

import lombok.Data;

/** ドラマ検索画面のFormクラス
 * 
 */
@Data
public class DramaSearchForm {

	/** ID */
	private Integer id;

	/** ドラマ名 */
	private String dramaTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 製作国ID */
	private Integer countryId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 */
	public void setValues(DramaMainNakaniwa dramaMainNakaniwa) {
		this.setId((int) dramaMainNakaniwa.getId());
		this.setDramaTitle(dramaMainNakaniwa.getDramaTitle());
		this.setGenreId(dramaMainNakaniwa.getGenreId());
		this.setCountryId(dramaMainNakaniwa.getCountryId());
	}
}
