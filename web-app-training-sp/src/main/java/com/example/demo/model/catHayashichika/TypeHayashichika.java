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
 * TypeHayashichikaテーブルと対応するEntityクラス
 * @author future
 */
@Data
@Entity
public class TypeHayashichika {
	
	/**毛種ID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**毛種*/
	@Column(name = "type")
	@Size(max = 255)
	private String type;

	/**削除フラグ*/
	@Column(name = "del_flag")
	private String delFlag;

	/**登録日時*/
	@Column(name = "create_date")
	private String createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定:毛種ID*/
	@OneToMany(targetEntity = CatMainHayashichika.class, mappedBy = "typeHayashichika")
	//@JoinColumn(name = "id", referencedColumnName = "type_id")
	private List<CatMainHayashichika> catMainList;

}
