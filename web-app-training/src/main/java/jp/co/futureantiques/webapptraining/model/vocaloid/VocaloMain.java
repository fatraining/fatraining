package jp.co.futureantiques.webapptraining.model.vocaloid;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import jp.co.futureantiques.webapptraining.model.moviesample.Genre;
import jp.co.futureantiques.webapptraining.model.moviesample.MovieActor;
import lombok.Data;

/**
 * MovieMainテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class VocaloMain {

	/** 曲ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 曲名 */
	@Column(name = "vocalo_title")
	private String vocaloTitle;

	/** PID	 */
	@Column(name = "p_id")
	private Integer pId;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** おすすめ歌い手ID */
	@Column(name = "utaite_id")
	private Integer utaiteId;

	/** 投稿日 */
	@Column(name = "up_year")
	private int upYear;

	/** ミリオン達成日 */
	@Column(name = "million_time")
	private Integer millionTime;

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
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreTsuru genreTsuru;

	/** 外部キー設定：P名 */
	@ManyToOne(targetEntity = MovieActor.class)
	@JoinColumn(name = "p_id", referencedColumnName = "id", insertable = false, updatable = false)
	private PTsuru pTsuru;

	/** 外部キー設定：おすすめ歌い手 */
	@ManyToOne(targetEntity = Genre.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private UtaiteTsuru utaiteTsuru;
}

