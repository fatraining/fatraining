package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
//import java.awt.print.Pageable;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.form.pokemon.PokemonInputForm;
import com.example.demo.model.form.pokemon.PokemonSearchForm;
import com.example.demo.model.pokemon.AppearanceSatoyoshi;
import com.example.demo.model.pokemon.PokemonMainSatoyoshi;
import com.example.demo.model.pokemon.Type1Satoyoshi;
import com.example.demo.model.pokemon.Type2Satoyoshi;

/**
 * Pokemonのサービスインターフェース
 *
 * @author satoyoshi
 */

public interface PokemonService {
	/**
	 * タイプ1エンティティのリストを取得する
	 *
	 * @return Type1Entityのリスト
	 */
	List<Type1Satoyoshi> getListType1();

	/**
	 * タイプ1エンティティのリストを取得する
	 *
	 * @return Type2Entityのリスト
	 */
	List<Type2Satoyoshi> getListType2();

	/**
	 * 初登場シリーズエンティティのリストを取得する
	 *
	 * @return AppearanceEntityのリスト
	 */
	List<AppearanceSatoyoshi> getListAppearance();

	/**
	 * 検索条件を元にPokemonMainのレコードのリストを取得する(Paging)
	 *
	 * @param PokemonSearchForm form
	 * @param Pageable pageable
	 * @return Mainのリスト
	 */
	Page<PokemonMainSatoyoshi> getPagePokemon(final PokemonSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にPokemonMainのレコードのリストを取得する
	 *
	 * @param PokemonSearchForm form
	 * @return PokemonMainのリスト
	 */
	List<PokemonMainSatoyoshi> getListPokemon(final PokemonSearchForm form);

	/**
	 * ポケモンIDをキーにPokemonMainのレコードを取得する
	 *
	 * @param long id
	 * @return 	PokemonMainのレコード
	 */
	PokemonMainSatoyoshi getPokemon(final long pokemonId);

	
	/**
	 * PokemonMainにレコードを新規登録する
	 *
	 * @param PokemonInputForm form
	 * @return PokemonMain
	 */
	PokemonMainSatoyoshi insertPokemon(final PokemonInputForm form);
	
	/**
	 * PokemonMainのレコードを更新する
	 *
	 * @param PokemonInputForm form
	 * @return PokemonMain
	 */
	PokemonMainSatoyoshi updatePokemon(final PokemonInputForm form);
	
	
	/**
	 * PokemonMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deletePokemonBypokemonId(final long pokemonid);

	/**
	 * PokemonMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deletePokemonComp(final ArrayList<Long> ids);
}
