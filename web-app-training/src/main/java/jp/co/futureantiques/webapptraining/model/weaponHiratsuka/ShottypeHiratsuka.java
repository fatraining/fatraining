package jp.co.futureantiques.webapptraining.model.weaponHiratsuka;

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
 * Shottypeテーブルと対応するEntityクラス
 *
 * @author future
 */
@Data
@Entity

public class ShottypeHiratsuka {
	/** 射撃方式ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 射撃方式 */
	@Column(name = "shottype")
	@Size(max = 255)
	private String shottype;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：ジャンルID */
	@Transient
	@OneToMany(targetEntity = WeaponMainHiratsuka.class, mappedBy = "shottype")
	@JoinColumn(name = "id", referencedColumnName = "shottype_id")
	private List<WeaponMainHiratsuka> weaponMainList;
}
