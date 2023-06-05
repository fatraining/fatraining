package jp.co.futureantiques.webapptraining.model.musicKaji;

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
 * MusicMainテーブルと対応するEntity
 *
 * @author futute
 *
 */
@Data
@Entity
public class MusicMainKaji {

	/** 楽曲ID **/
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 楽曲名 **/
	@Column(name = "music_title")
	private String musicTitle;

	/** ユニットID **/
	@Column(name = "unit_id")
	private Integer unitId;

	/** 作曲者ID **/
	@Column(name = "composer_id")
	private Integer composerId;

	/** 公開年 **/
	@Column(name = "release_year")
	private int releaseYear;

	/** 時間 **/
	@Column(name = "music_time")
	private String musicTime;

	/** コメント **/
	@Column(name = "comment")
	@Size(max = 256)
	private String comment;

	/** 削除フラグ **/
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 **/
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 **/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：ユニット **/
	@ManyToOne(targetEntity = UnitKaji.class)
	@JoinColumn(name = "unit_id", referencedColumnName = "id", insertable = false, updatable = false)
	private UnitKaji unitKaji;

	/** 外部キー設定：作曲者 **/
	@ManyToOne(targetEntity = ComposerKaji.class)
	@JoinColumn(name = "composer_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ComposerKaji composerKaji;
}
