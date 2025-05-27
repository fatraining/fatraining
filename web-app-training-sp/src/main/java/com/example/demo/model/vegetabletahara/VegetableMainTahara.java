package com.example.demo.model.vegetabletahara;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Vegetableテーブルに対応するフィールドを持つEntity
 * 
 * @author future
 * */
@Data
@Entity
public class VegetableMainTahara {
	/**野菜ID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/**野菜の名前*/
	@Column(name = "vegetable_name")
	@Size(max = 20)
	private String vegetableName;
	
	/**カテゴリーID*/
	@Column(name ="category_id")
	private Integer categoryId;
	
	/**原産地*/
	@Column(name ="origin_place")
	@Size(max = 20)
	private String originPlace;
	
	/**国内生産量(R2)*/
	@Column(name ="production_volume")
	private Integer productionVolume;
	
	/**国内最大生産地ID*/
	@Column(name ="area_id")
	private Integer areaId;
	
	/**おすすめの食べ方*/
	@Column(name ="recommend")
	@Size(max = 100)
	private String recommend;
	
	/**削除フラグ*/
	@Column(name ="del_flg")
	private int delFlg;
	
	/**入力日時*/
	@Column(name ="create_date")
	private String createDate;
	
	/**更新日時*/
	@Column(name ="update_date")
	private String updateDate;
	
	
	/**外部キー設定：カテゴリー*/
	@ManyToOne(targetEntity = CategoryTahara.class)
	@JoinColumn(name = "category_id", insertable=false, updatable=false)
	private CategoryTahara category;
	
	/**外部キー設定：国内最大生産地*/
	@ManyToOne(targetEntity = AreaTahara.class)
	@JoinColumn(name = "area_id", insertable=false, updatable=false)
	private AreaTahara area;

}
