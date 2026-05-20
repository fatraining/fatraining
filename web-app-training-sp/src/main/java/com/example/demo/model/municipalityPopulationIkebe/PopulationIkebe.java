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
 * PopulationIkebeテーブルと対応するEntityクラス
 * 
 * 人口テーブル
 *  */

@Data
@Entity
public class PopulationIkebe {

	/** 総人口ID */
	@Id
	@GeneratedValue
	@Column(name = "population_id")
	private int population_id;

	/** 総人口カテゴリー */
	@Column(name = "population_category")
	@Size(max = 20)
	private String populationCategory;

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
	@OneToMany(targetEntity = MunicipalityPopulationIkebeMain.class, mappedBy = "population")
	//@JoinColumn(name = "id", referencedColumnName = "population_id")
	//@JoinColumn(name = "id")
	private List<MunicipalityPopulationIkebeMain> MunicipalityPopulationIkebeMainList;

}
