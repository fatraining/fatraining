package com.example.demo.model.form.pokemon;

import com.example.demo.model.pokemon.PokemonMainSatoyoshi;

import lombok.Data;

/**
 * ポケモン検索画面のFormクラス
 *
 * @author satoyoshi
 */
@Data
public class PokemonSearchForm {

	/** ポケモンID */
	private Integer pokemonId;

	/** ポケモン名 */
	private String pokemonName;

	/** タイプ1ID */
	private Integer type1Id;

	/** タイプ2D */
	private Integer type2Id;

	/** 初登場シリーズID */
	private Integer appearanceId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param pokemonMain
	 */
	public void setValues(PokemonMainSatoyoshi pokemonMain) {
		this.setPokemonId((int) pokemonMain.getPokemonId());
		this.setPokemonName(pokemonMain.getPokemonName());
		this.setType1Id(pokemonMain.getType1Id());
		this.setType2Id(pokemonMain.getType2Id());
		this.setAppearanceId(pokemonMain.getAppearanceId());
	}

}
