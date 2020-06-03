package jp.co.futureantiques.webapptraining.model.cdKanayama;

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
 * cdeMainテーブルと対応するEntity
 *
 * @author future
 */

@Entity
@Data
public class CdMainKanayama {

	/** CDID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** CDタイトル */
	@Column(name = "cd_title")
	private String cdTitle;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** アーティスト名 */
	@Column(name = "artist_name")
	private String artistName;

	/** 公開年 */
	@Column(name = "release_year")
	private int releaseYear;

	/** 再生時間 */
	@Column(name = "play_time")
	private Integer playTime;

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
	@ManyToOne(targetEntity = GenreKanayama.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreKanayama genre;

}
