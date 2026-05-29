package com.example.demo.model.zeldaikeda;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

import lombok.Data;

/**
 * CompatibleModelIkedaテーブルと対応するEntityクラス
 */
@Data
@Entity
public class CompatibleModelIkeda {
	
	/** 対応機種ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** ハード名 */
	@Column(name = "compatible_model")
	@Size(max = 255)
	private String compatibleModel;

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
	@OneToMany(targetEntity = ZeldaMainIkeda.class, mappedBy = "compatibleModel")
	//@JoinColumn(name = "id", referencedColumnName = "genre_id")
	//@JoinColumn(name = "id")
	private List<ZeldaMainIkeda> zeldaMainIkedaList;
}
