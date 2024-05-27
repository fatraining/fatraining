package com.example.demo.model.booknakano;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Classificationテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class ClassificationNakano {

	/** 分類ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 分類名 */
	@Column(name = "name")
	@Size(max = 255)
	private String name;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：分類ID */
	@OneToMany(targetEntity = BookMainNakano.class, mappedBy = "classification")
	private List<BookMainNakano> bookMainList;
}
