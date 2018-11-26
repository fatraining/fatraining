package jp.co.futureantiques.webapptraining.model.musicalcomposition.takei;

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
 * MusicalCompositionSearchMainテーブルと対応するEntity
 *
 * @author takei
 */

@Data
@Entity
public class MusicalCompositionMainTakei {

	/** 楽曲ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 曲名 */
	@Column(name = "title")
	private String title;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** アルバムID */
	@Column(name = "album_id")
	private Integer albumId;

	/** 時間 */
	@Column(name = "the_number_of_econds")
	private String theNumberOfEconds;

	/** 発売日 */
	@Size(max = 30)
	@Column(name = "release_day")
	private String releaseDay;

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
	@ManyToOne(targetEntity = GenreTakei.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "genre_id", insertable = false, updatable = false)
	private GenreTakei genreTakei;

	/** 外部キー設定：アルバム */
	@ManyToOne(targetEntity = AlbumTakei.class)
	@JoinColumn(name = "album_id", referencedColumnName = "album_id", insertable = false, updatable = false)
	private AlbumTakei albumTakei;
}
