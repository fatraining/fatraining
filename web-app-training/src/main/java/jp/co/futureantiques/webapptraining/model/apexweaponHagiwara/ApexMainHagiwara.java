package jp.co.futureantiques.webapptraining.model.apexweaponHagiwara;

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
 * ApexMainHagiwaraテーブルと対応するEntity
 *
 * @author Hagiwara
 */
@Data
@Entity

public class ApexMainHagiwara {

	/**武器ID*/
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 武器名 */
	@Column(name = "name")
	@Size(max = 255)
	private String name;

	/** 武器種ID */
	@Column(name = "kind_id")
	private Integer kindId;

	/** 使用アモID */
	@Column(name = "ammo_id")
	private Integer ammoId;

	/** 胴ダメージ */
	@Column(name = "damage")
	private Integer damage;

	/** DPS */
	@Column(name = "dps")
	private Integer dps;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private Integer delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定:武器種 */
	@ManyToOne(targetEntity = WeaponKindHagiwara.class)
	@JoinColumn(name = "kind_id", referencedColumnName = "kind_id", insertable = false, updatable = false)
	private WeaponKindHagiwara weaponKindHagiwara;

	/** 外部キー設定:使用アモ */
	@ManyToOne(targetEntity = AmmoHagiwara.class)
	@JoinColumn(name = "ammo_id", referencedColumnName = "ammo_id", insertable = false, updatable = false)
	private AmmoHagiwara ammoHagiwara;
}
