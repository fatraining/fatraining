package com.example.demo.model.moviesample;

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
 * MovieMainテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class MovieMain {

	/** 映画ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/** 映画名 */
	@Column(name = "movie_title")
	private String movieTitle;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 俳優ID */
	@Column(name = "actor_id")
	private Integer actorId;

	/** 公開年 */
	@Column(name = "release_year")
	private int releaseYear;

	/** 上映時間 */
	@Column(name = "run_time")
	private Integer runTime;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 255)
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
	@ManyToOne(targetEntity = Genre.class)
	@JoinColumn(name = "genre_id", insertable=false, updatable=false)
	private Genre genre;

	/** 外部キー設定：俳優 */
	@ManyToOne(targetEntity = MovieActor.class)
	//@JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false)
	@JoinColumn(name = "actor_id", insertable=false, updatable=false)
	private MovieActor movieActor;
}