package jp.co.futureantiques.webapptraining.model.animeNagatake;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * AnimeMainNagatakeテーブルに対応するEntity
 *
 *@author future
 * */

@Data
@Entity
public class AnimeMainNagatake {

	/** アニメID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** アニメタイトル */
	@Column(name = "anime_title")
	@Size(max = 256)
	private String animeTitle;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** スタジオID */
	@Column(name = "studio_id")
	private Integer studioId;

	/** 公開年 */
	@Column(name = "release_year")
	private Integer releaseYear;

	/** 声優ID */
	@Column(name = "voiceactor_id")
	private Integer voiceactorId;

	/** 出典ID */
	@Column(name = "source_id")
	private Integer sourceId;

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

	/** 外部キー設定 :ジャンル */
	@ManyToOne(targetEntity = GenreNagatake.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "genre_id", insertable = false, updatable = false)
	private GenreNagatake genreNagatake;

	/** 外部キー設定 :スタジオ */
	@ManyToOne(targetEntity =StudioNagatake.class)
	@JoinColumn(name = "studio_id", referencedColumnName = "studio_id", insertable = false, updatable = false)
	private StudioNagatake studioNagatake;

	/** 外部キー設定 :声優 */
	@ManyToOne(targetEntity =VoiceactorNagatake.class)
	@JoinColumn(name = "voiceactor_id", referencedColumnName = "voiceactor_id", insertable = false, updatable = false)
	private VoiceactorNagatake voiceactorNagatake;

	/** 外部キー設定 :出典 */
	@ManyToOne(targetEntity =SourceNagatake.class)
	@JoinColumn(name = "source_id", referencedColumnName = "source_id", insertable = false, updatable = false)
	private SourceNagatake sourceNagatake;
}
