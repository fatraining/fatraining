package jp.co.futureantiques.webapptraining.model.kyarySahota;

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
 * KyaryMainテーブルと対応するEntity
 *
 * @author futureantiques
 *
 */
@Data
@Entity
public class KyaryMainSahota {

	/** 曲ID */
	@Id
	@GenericGenerator(name = "gen",strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 曲名 */
	@Column(name = "song_title")
	private String songTitle;

	/** CDID */
	@Column(name = "name_id")
	private Integer nameId;

	/** CD形態ID */
	@Column(name = "type_id")
	private Integer typeId;

	/** リリース */
	@Column(name = "release_year")
	private Integer releaseYear;

	/** 時間 */
	@Column(name = "song_time")
	private String songTime;

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

	/** 登録日時 */
	@Column(name= "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：CD名 */
	@ManyToOne(targetEntity = CdNameSahota.class)
	@JoinColumn(name = "name_id",referencedColumnName = "name_id",insertable = false,updatable = false)
	private CdNameSahota cdName;

	/** 外部キー設定：CD形態 */
	@ManyToOne(targetEntity = CdTypeSahota.class)
	@JoinColumn(name = "type_id",referencedColumnName = "type_id",insertable = false,updatable = false)
	private CdTypeSahota cdType;
}
