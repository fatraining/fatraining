package jp.co.futureantiques.webapptraining.model.mlbUezu;

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

/** Districtテーブルと対応するEntity */

@Data
@Entity
public class DistrictUezu {

	/** 地区ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 地区 */
	@Column(name = "district")
	@Size(max = 256)
	private String district;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：地区ID */
	@Transient
	@OneToMany(targetEntity = MlbMainUezu.class, mappedBy = "district")
	@JoinColumn(name = "id", referencedColumnName = "district_id")
	private List<MlbMainUezu> MLBMainUezu;
}