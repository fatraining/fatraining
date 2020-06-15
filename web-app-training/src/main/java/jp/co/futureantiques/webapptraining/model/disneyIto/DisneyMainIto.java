package jp.co.futureantiques.webapptraining.model.disneyIto;



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
 * SQL disney_main_itoテーブルと対応しているエンティティ
 * @author Ayaka Ito
 */
@Data
@Entity
public class DisneyMainIto {

	/** アトラクションID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** アトラクション名 */
	@Column(name = "attraction_name")
	private String attractionName;

	/** パークID */
	@Column(name = "park_id")
	private Integer parkId;

	/** エリアID */
	@Column(name = "area_id")
	private Integer areaId;

	/** 乗車時間 */
	@Column(name = "time")
	private Integer time;

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

	/** 外部キー設定：パーク */
	@ManyToOne(targetEntity = DisneyParkIto.class)
	@JoinColumn(name = "park_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DisneyParkIto park;

	/** 外部キー設定：エリア */
	@ManyToOne(targetEntity = DisneyAreaIto.class)
	@JoinColumn(name = "area_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DisneyAreaIto area;

}
