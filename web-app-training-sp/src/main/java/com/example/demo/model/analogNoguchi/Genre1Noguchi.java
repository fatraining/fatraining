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
 * Genre1Noguchiテーブルに対応するEntity
 * 
 * @author future
 */
@Data
@Entity
@Table(name = "genre1_noguchi")
public class Genre1Noguchi {

	/** ジャンル1 ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** ジャンル名 */
	@Column(name = "genre")
	@Size(max = 256)
	private String genre;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：ジャンル1 ID */
	@OneToMany(targetEntity = AnalogMainNoguchi.class, mappedBy = "genre1")
	//@JoinColumn(name = "id", referencedColumnName = "genre1_id")
	private List<AnalogMainNoguchi> analogMainNoguchiList;
}
