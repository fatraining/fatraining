package com.example.demo.model.municipalityPopulationIkebe;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * municipalityIkebeテーブルと対応するEntity
 */

@Data
@Entity
public class MunicipalityIkebe {

	/** 市区町村ID */
	@Id
	@GeneratedValue
	@Column(name = "municipality_id")
	private int municipalityId;

	/** 市区町村カテゴリー */
	@Column(name = "municipality_category")
	@Size(max = 1)
	private String municipalityCategory;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	//** 外部キー設定 : 市区町村ID */
	@OneToMany(targetEntity = MunicipalityPopulationIkebeMain.class, mappedBy = "municipality")
	//@JoinColumn(name = "municipality_id", referencedColumnName = "municipality_id")
	private List<MunicipalityPopulationIkebeMain> MunicipalityPopulationIkebeMainList;

}
