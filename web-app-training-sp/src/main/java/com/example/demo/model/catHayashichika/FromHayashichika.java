package com.example.demo.model.catHayashichika;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 *Fromテーブルと対応するEntityクラス
 *@author future 
 */
@Data
@Entity
public class FromHayashichika {

	/**原産国ID*/
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**原産国*/
	@Column(name = "from")
	private String from;

	/**削除フラグ*/
	@Column(name = "del_flag")
	private String delFlag;

	/**登録日時*/
	@Column(name = "create_date")
	private String createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private String updateDate;

	/**外部キー設定:原産国ID*/
	@OneToMany(targetEntity = CatMainHayashichika.class, mappedBy = "fromHayashichika")
	private List<CatMainHayashichika> catMainList;

}
