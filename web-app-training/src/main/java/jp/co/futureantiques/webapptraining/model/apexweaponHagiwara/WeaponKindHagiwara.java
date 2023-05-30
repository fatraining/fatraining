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
public class WeaponKindHagiwara {

	/** 武器種ID */
	@Id
	@GeneratedValue
	@Column(name = "kind_id")
	private long id;

	/** 武器種 */
	@Column(name = "kind")
	@Size(max = 255)
	private String kind;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：武器種ID */
	@Transient
	@OneToMany(targetEntity = ApexMainHagiwara.class, mappedBy = "weaponKindHagiwara")
	@JoinColumn(name = "kind_id", referencedColumnName = "kind_id")
	private List<ApexMainHagiwara> apexMainList;
}
