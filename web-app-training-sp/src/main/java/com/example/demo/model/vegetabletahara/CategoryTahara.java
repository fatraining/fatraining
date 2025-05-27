package com.example.demo.model.vegetabletahara;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Categoryテーブルに対応するフィールドを持つEntity
 * 
 * @author future
 * */
@Data
@Entity
public class CategoryTahara {
	
	/**カテゴリーID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	/**カテゴリー*/
	@Column(name = "category")
	@Size(max = 20)
	private String category;
	
	/**削除フラグ*/
	@Column(name ="del_flg")
	private int delFlg;
	
	/**入力日時*/
	@Column(name ="create_date")
	private String createDate;
	
	/**更新日時*/
	@Column(name ="update_date")
	private String updateDate;
	
	/**外部キー設定：カテゴリーID*/
	@OneToMany(targetEntity = VegetableMainTahara.class, mappedBy = "category")
	private List<VegetableMainTahara> vegetableMainTaharaList;
}
