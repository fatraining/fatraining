package jp.co.futureantiques.webapptraining.model.bandIto;

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
 * BandMainItoテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class BandMainIto {
	/** バンドID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** バンド名 */
	@Column(name = "band_name")
	private String bandName;

	/** ボーカル性別ID */
	@Column(name = "sex_id")
	private Integer sexId;

	/** 出身地ID */
	@Column(name = "area_id")
	private Integer areaId;

	/** 結成年 */
	@Column(name = "form_year")
	private int formYear;

	/** コメント、推し曲 */
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
	@ManyToOne(targetEntity = SexIto.class)
	@JoinColumn(name = "sex_id", referencedColumnName = "id", insertable = false, updatable = false)
	private SexIto sexIto;

	/** 外部キー設定：俳優 */
	@ManyToOne(targetEntity = AreaIto.class)
	@JoinColumn(name = "area_id", referencedColumnName = "id", insertable = false, updatable = false)
	private AreaIto areaIto;

}
