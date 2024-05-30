package com.example.demo.model.form.game;

import java.sql.Timestamp;
import java.util.Date;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.game.GameMainToho;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *ゲーム登録・更新画面用のFormクラス
 *
 * @author future
 */

@Data
public class GameTohoInputForm {

	/** ID */
	private int id;

	/** ゲーム名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String gameTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 評価ID */
	private Integer evaluationId;

	/** 最大人数 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String subject;

	/** 制作会社 */
	@Size(max = 256)
	private String company;

	/** コメント */
	@Size(max = 256)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param gameMainToho
	 */
	public void initWithGameMainToho(GameMainToho gameMainToho) {
		this.setId((int) gameMainToho.getId());
		this.setGameTitle(gameMainToho.getGameTitle());
		this.setGenreId(gameMainToho.getGenreId());
		this.setEvaluationId(gameMainToho.getEvaluationId());
		this.setSubject(gameMainToho.getSubject());
		if (gameMainToho.getCompany() != null) {
			this.setCompany(String.valueOf(gameMainToho.getCompany()));
		}
		this.setComment(gameMainToho.getComment());
		this.setUpdateDate(String.valueOf(gameMainToho.getUpdateDate()));
	}

	/**
	 * GameMainTohoエンティティに登録値を入れる
	 *
	 * @return GameMainToho
	 */
	public GameMainToho convertToGameMainTohoForInsert() {
		GameMainToho gameMainToho = new GameMainToho();
		gameMainToho = convertToGameMainToho(gameMainToho);
		gameMainToho.setCreateDate(new Timestamp(new Date().getTime()));
		gameMainToho.setUpdateDate(gameMainToho.getCreateDate());
		return gameMainToho;
	}

	/**
	 * GameMainTohoエンティティに更新値を入れる
	 *
	 * @param GameMainToho gameMainToho
	 * @return GameMainToho
	 */
	public GameMainToho convertToGameMainTohoForUpdate(GameMainToho gameMainToho) {
		gameMainToho = convertToGameMainToho(gameMainToho);
		gameMainToho.setUpdateDate(new Timestamp(new Date().getTime()));
		return gameMainToho;
	}

	/**
	 * GameMainTohoエンティティに入力値を入れる
	 *
	 * @param GameMainToho gameMainToho
	 * @return GameMainToho
	 */
	private GameMainToho convertToGameMainToho(GameMainToho gameMainToho) {
		gameMainToho.setGameTitle(this.gameTitle);
		if (this.genreId == CommonConst.NOT_ENTERD) {

			// ジャンルが入力されていなかった場合
			gameMainToho.setGenreId(null);
		} else {

			// ジャンルが入力されていた場合
			gameMainToho.setGenreId(this.genreId);
		}
		if (this.evaluationId == CommonConst.NOT_ENTERD) {

			// 評価が入力されていなかった場合
			gameMainToho.setEvaluationId(null);
		} else {

			// 評価が入力されていた場合
			gameMainToho.setEvaluationId(this.evaluationId);
		}
		gameMainToho.setSubject(this.subject);
		if (this.subject != null) {

			// 制作会社が入力されていた場合
			gameMainToho.setCompany(this.company);
		} else {

			// 制作会社が入力されていなかった場合
			gameMainToho.setCompany(null);
		}
		gameMainToho.setComment(this.comment);
		gameMainToho.setDelFlg("0");
		return gameMainToho;
	}
}
