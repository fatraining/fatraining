package jp.co.futureantiques.webapptraining.model.mangaKawada;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * manga_main_kawadaテーブルと対応するEntityクラス
 * @author Kawada
 */
@Data
@Entity
public class MangaMainKawada {
	/** 漫画ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 漫画タイトル */
	@Column(name = "manga_title")
	private String mangaTitle;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** アニメID */
	@Column(name = "anime_id")
	private Integer animeId;

	/** 連載状況ID */
	@Column(name = "situation_id")
	private Integer situationId;

	/** 連載開始年 */
	@Column(name = "serialization_start")
	private int serializationStart;

	/** コメント */
	@Column(name = "comment")
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

	/** 外部キー設定: ジャンルID */
	@ManyToOne(targetEntity = GenreKawada.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreKawada genreKawada;

	/** 外部設定: アニメID*/
	@ManyToOne(targetEntity = AnimeKawada.class)
	@JoinColumn(name = "anime_id", referencedColumnName = "id", insertable = false, updatable = false)
	private AnimeKawada animeKawada;

	/** 外部設定: 連載状況ID*/
	@ManyToOne(targetEntity = SituationKawada.class)
	@JoinColumn(name = "situation_id", referencedColumnName = "id", insertable = false, updatable = false)
	private SituationKawada situationKawada;
}
