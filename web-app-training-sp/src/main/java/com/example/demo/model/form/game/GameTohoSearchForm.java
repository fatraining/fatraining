package com.example.demo.model.form.game;

import com.example.demo.model.game.GameMainToho;

import lombok.Data;

/**
 * ゲーム検索画面のFormクラス
 *
 * @author future
 */

@Data
public class GameTohoSearchForm {

	/** id */
	private Integer id;

	/** ゲーム名*/
	private String gameTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 評価ID */
	private Integer evaluationId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 * @param GameMainToho
	 */
	public void setValues(GameMainToho gameMainToho) {
		this.setId((int) gameMainToho.getId());
		this.setGameTitle(gameMainToho.getGameTitle());
		this.setGenreId(gameMainToho.getGenreId());
		this.setEvaluationId(gameMainToho.getEvaluationId());
	}
}
