package com.example.demo.model.pokemon;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * pokemon_main_satoyoshiテーブルと対応するEntity
 *
 * @author satoyoshi
 */
@Data
@Entity
public class PokemonMainSatoyoshi {

	/** ポケモンID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pokemonId;

	/** ポケモン名 */
	@Column(name = "pokemon_name")
	private String pokemonName;

	/** タイプ1ID */
	@Column(name = "type1_id")
	private Integer type1Id;

	/** タイプ2ID */
	@Column(name = "type2_id")
	private Integer type2Id;

	/** 図鑑No. */
	@Column(name = "encyclopedia_id")
	private Integer encyclopediaId;

	/** 初登場シリーズID */
	@Column(name = "appearance_id")
	private Integer appearanceId;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 255)
	private String comment;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：タイプ1 */
	@ManyToOne(targetEntity = Type1Satoyoshi.class)
	@JoinColumn(name = "type1_id", insertable=false, updatable=false)
	private Type1Satoyoshi type1;

	/** 外部キー設定：タイプ2 */
	@ManyToOne(targetEntity = Type2Satoyoshi.class)
	@JoinColumn(name = "type2_id", insertable=false, updatable=false)
	private Type2Satoyoshi type2;
	
	/** 外部キー設定：初登場シリーズ */
	@ManyToOne(targetEntity = AppearanceSatoyoshi.class)
	//@JoinColumn(name = "series_id", referencedColumnName = "appearance_id", insertable = false, updatable = false)
	@JoinColumn(name = "appearance_id", insertable=false, updatable=false)
	private AppearanceSatoyoshi appearance;
}