package jp.co.futureantiques.webapptraining.model.riderSaito;

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
 * RiderMainSaitoテーブルに対応するEntity
 *
 *@author future
 * */

@Data
@Entity
public class RiderMainSaito {

	/** 仮面ライダーID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long riderId;

	/** 仮面ライダー名 */
	@Column(name = "rider_name")
	@Size(max = 256)
	private String riderName;

	/** 年代ID */
	@Column(name = "age_id")
	private Integer ageId;

	/** 俳優 */
	@Column(name = "actor")
	@Size(max = 256)
	private String actor;

	/** セリフ */
	@Column(name = "serif")
	@Size(max = 256)
	private String serif;

	@Column(name = "img")
	private String img;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定 :年代 */
	@ManyToOne(targetEntity = AgeSaito.class)
	@JoinColumn(name = "age_id", referencedColumnName = "age_id", insertable = false, updatable = false)
	private AgeSaito ageSaito;

}
