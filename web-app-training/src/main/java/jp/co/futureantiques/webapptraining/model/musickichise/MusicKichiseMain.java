package jp.co.futureantiques.webapptraining.model.musickichise;

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
 *
 * MusicKichiseMainテーブルと対応するEntity
 * @author future
 *
 */
@Data
@Entity
public class MusicKichiseMain {

	/** 楽曲ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 楽曲名 */
	@Column(name = "music_title")
	private String musicTitle;

	/** アーティストID */
	@Column(name = "artist_id")
	private Integer artistId;

	/** ジャンルID */
	@Column(name = "janru_id")
	private Integer janruId;

	/** 国 */
	@Column(name = "country")
	private String country;

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

	/** 外部キー設定：ジャンル */
	@ManyToOne(targetEntity = Janru.class)
	@JoinColumn(name = "janru_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Janru janru;

	@ManyToOne(targetEntity = Artist.class)
	@JoinColumn(name = "artist_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Artist artist;
}
