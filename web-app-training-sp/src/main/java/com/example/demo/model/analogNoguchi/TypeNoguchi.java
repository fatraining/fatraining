package com.example.demo.model.analogNoguchi;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * TypeNoguchiテーブルと対応するEntity
 * 
 * @author future
 */

@Data
@Entity
@Table(name = "type_noguchi")
public class TypeNoguchi {

	/** 種類ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 種類名 */
	@Column(name = "type")
	@Size(max = 256)
	private String type;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：種類ID */

	@OneToMany(targetEntity = AnalogMainNoguchi.class, mappedBy = "type")
	//@JoinColumn(name = "id", referencedColumnName = "type_id")
	private List<AnalogMainNoguchi> analogMainNoguchiList;

}
