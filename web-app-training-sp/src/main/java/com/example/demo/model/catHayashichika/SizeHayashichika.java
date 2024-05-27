package com.example.demo.model.catHayashichika;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *SizeHayshichikaテーブルと対応するEntityクラス
 *@author future 
 */
@Data
@Entity
public class SizeHayashichika {

	/**体型ID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**体型*/
	@Column(name = "size")
	@Size(max = 255)
	private String size;

	/**削除フラグ*/
	@Column(name = "del_flag")
	private String delFlag;

	/**登録日時*/
	@Column(name = "create_date")
	private String createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定：体型ID*/
	@OneToMany(targetEntity = CatMainHayashichika.class, mappedBy = "sizeHayashichika")
	private List<CatMainHayashichika> catMainList;

}
