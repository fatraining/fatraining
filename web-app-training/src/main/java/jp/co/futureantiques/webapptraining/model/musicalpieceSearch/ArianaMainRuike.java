package jp.co.futureantiques.webapptraining.model.musicalpieceSearch;

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
* arianaMainRuikeテーブルと対応するEntity
*
* @author skataoka
*/
@Data
@Entity
public class ArianaMainRuike {
	//シングルID
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private Integer singleId;

	//シングル名
	@Column(name = "single_title")
	private String singleTitle;

	//アルバムID
	@Column(name = "album_id")
	private Integer albumId;

	//コラボアーティストID
	@Column(name = "colabo_id")
	private Integer colaboId;

	//再生時間
	@Column(name = "play_time")
	private Integer playTime;

	//発売年
	@Column(name = "release_year")
	private Integer releaseYear;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 発売年 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定： アルバム  album_ruike*/
	@ManyToOne(targetEntity = AlbumRuike.class)
	@JoinColumn(name = "album_id", referencedColumnName = "id", insertable = false, updatable = false)
	private AlbumRuike albumRuike;

	/** 外部キー設定： コラボアーティスト colabo_ruike */
	@ManyToOne(targetEntity = ColaboRuike.class)
	@JoinColumn(name = "colabo_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ColaboRuike colaboRuike;

}
