package com.example.demo.model.pokemon;

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
 * type2_satoyoshiテーブルと対応するEntityクラス
 * コミットテスト1.7
 * コミットテスト1.7(競合)
 * @author satoyoshi
 */
@Data
@Entity
@Table(name = "type2_satoyoshi")
public class Type2Satoyoshi {

	/** タイプ2ID */
	@Id
	@GeneratedValue
	@Column(name = "type2_id")
	private int type2Id;

	/** タイプ */
	@Column(name = "type2_variation")
	@Size(max = 256)
	private String type2Variation;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：タイプ2ID */
	@OneToMany(targetEntity = PokemonMainSatoyoshi.class, mappedBy = "type2")
	//@JoinColumn(name = "type2_id", referencedColumnName = "type2_id")
	//@JoinColumn(name = "type2_id")
	private List<PokemonMainSatoyoshi> PokemonMainList;
}