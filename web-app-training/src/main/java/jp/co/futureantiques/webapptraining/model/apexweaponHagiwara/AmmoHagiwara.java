package jp.co.futureantiques.webapptraining.model.apexweaponHagiwara;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * WeaponKindHagiwaraテーブルと対応するEntity
 *
 * @author Hagiwara
 */
@Data
@Entity
public class AmmoHagiwara {

	/** 使用アモID */
	@Id
	@GeneratedValue
	@Column(name = "ammo_id")
	private long id;

	/** 使用アモ */
	@Column(name = "ammo")
	@Size(max = 255)
	private String ammo;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：使用アモID */
	@Transient
	@OneToMany(targetEntity = ApexMainHagiwara.class, mappedBy = "ammoHagiwara")
	@JoinColumn(name = "ammo_id", referencedColumnName = "ammo_id")
	private List<ApexMainHagiwara> apexMainList;
}
