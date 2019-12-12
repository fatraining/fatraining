package jp.co.futureantiques.webapptraining.model.liveMainKawada;

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
 * LiveMainKawadaテーブルと対応するエンティティ
 *
 *@author future
 */
@Data
@Entity
public class LiveMainKawada {

	//曲ID
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	//収録アルバム
	@Column(name = "album_id")
	private Integer albumId;

	//曲名
	@Column(name = "song_title")
	private String songTitle;

	//演奏率
	@Column(name = "percent")
	private Integer percent;

	//ライブスタイル
	@Column(name = "style_id")
	private Integer styleId;

	//コメント
	@Column(name = "comment")
	@Size(max = 256)
	private String comment;

	//削除フラグ
	@Column(name = "del_flg")
	private String delFlg;

	//登録日時
	@Column(name = "create_date")
	private Timestamp createDate;

	//更新日時
	@Column(name = "update_date")
	private Timestamp updateDate;

	//外部キー設定：アルバム
	@ManyToOne(targetEntity = AlbumKawada.class)
	@JoinColumn(name = "album_id", referencedColumnName = "album_id", insertable = false, updatable = false)
	private AlbumKawada album;

	//外部キー設定：スタイル
	@ManyToOne(targetEntity = StyleKawada.class)
	@JoinColumn(name = "style_id", referencedColumnName = "style_id", insertable = false, updatable = false)
	private StyleKawada style;

}
