package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

/**  MunicipalityPopulationIkebeMainと対応するEntity
 * 
 *  */
@Data
@Entity
public class MunicipalityPopulationIkebeMain {

	/** 市区町村別人口ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/** 市区町村名 */
	@Column(name = "municipality")
	private String municipality;

	/** 都道府県名 */
	@Column(name = "prefecture_name")
	private Integer prefectureName;

	/** 市区町村ID */
	@Column(name = "municipality_id")
	private Integer municipalityId;

	/** 総人口ID */
	@Column(name = "population_id")
	private Integer populationId;

	/** 総人口 */
	@Column(name = "population")
	private Integer population;

	/** 老年人口 */
	@Column(name = "eldely_population")
	private Integer elderlyPopulation;

	/** 高齢化率 */
	@Column(name = "aginglate")
	private Integer aginglate;

	/** 人口密度 */
	@Column(name = "population_density")
	private Integer populationDensity;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：市区町村ID */
	@ManyToOne(targetEntity = MunicipalityIkebe.class)
	@JoinColumn(name ="municipality_id", insertable = false, updatable = false)
	private MunicipalityIkebe municipalityikebe;

	/** 外部キー設定：人口 */
	@ManyToOne(targetEntity = PopulationIkebe.class)
	//@JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false)
	@JoinColumn(name = "population_id", insertable = false, updatable = false)
	private PopulationIkebe populationikebe;

}
