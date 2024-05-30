package com.example.demo.model.game;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * GameMainTohoテーブルと対応するEntity
 *
 * @author future
 */

@Data
@Entity
public class GameMainToho {

	/** ゲームID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/** ゲーム名 */
	@Column(name = "game_title")
	private String gameTitle;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 評価ID */
	@Column(name = "evaluation_id")
	private Integer evaluationId;

	/** 最大人数 */
	@Column(name = "subject")
	private String subject;

	/** 制作会社 */
	@Column(name = "company")
	private String company;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 256)
	private String comment;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：ジャンル */
	@ManyToOne(targetEntity = GenreToho.class)
	@JoinColumn(name = "genre_id", insertable = false, updatable = false)
	private GenreToho genreToho;

	/** 外部キー設定：評価 */
	@ManyToOne(targetEntity = GameEvaluationToho.class)
	//@JoinColumn(name = "evaluation_id", referencedColumnName = "id", insertable = false, updatable = false)
	@JoinColumn(name = "evaluation_id", insertable = false, updatable = false)
	private GameEvaluationToho gameEvaluationToho;
}
