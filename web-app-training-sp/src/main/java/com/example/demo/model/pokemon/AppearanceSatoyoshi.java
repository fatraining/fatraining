package com.example.demo.model.pokemon;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *  appearance_satoyoshi テーブルと対応するEntity
 *
 * @author satoyoshi
 */
@Data
@Entity
public class AppearanceSatoyoshi {

	/** シリーズID */
	@Id
	@GeneratedValue
	@Column(name = "series_id")
	private int seriesId;

	/** シリーズ */
	@Column(name = "series_variation")
	@Size(max = 256)
	private String seriesVariation;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：初登場シリーズID */
	@OneToMany(targetEntity = PokemonMainSatoyoshi.class, mappedBy = "appearance")
	//@JoinColumn(name = "series_id", referencedColumnName = "appearance_id")
	private List<PokemonMainSatoyoshi> PokemonMainList;

}
