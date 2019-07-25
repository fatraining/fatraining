package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.pokemonJsuzuki.PokemonJsuzukiInputForm;
import jp.co.futureantiques.webapptraining.model.form.pokemonJsuzuki.PokemonJsuzukiSearchForm;
import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.AreaIdJsuzuki;
import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.PokemonMainJsuzuki;
import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.TypeIdJsuzuki;



public interface PokemonJsuzukiService {
	/**
	 *タイプエンティティのリストを取得する
	 *
	 *@return TypeIdエンティティのリスト
	 */
	List<TypeIdJsuzuki> getListTypeId();

	/**
	 *登場地方エンティティのリストを取得する
	 *
	 *@return AreaIdエンティティのリスト
	 */
	List<AreaIdJsuzuki>getListAreaId();

	/**
	 *検索結果を元にPokemonMainJsuzukiのレコードリストを取得する(paging)
	 *
	 *@param pokemonMainJsuzukiSearchForm form
	 *@param Pageable pageable
	 *@return PokemonMainJsuzukiのリスト
	 */
	Page<PokemonMainJsuzuki> getPagePokemon(final PokemonJsuzukiSearchForm form,final Pageable pageable);

	/**
	 *検索結果を元にpokemonMainJsuzukiのレコードリストを取得する
	 *
	 *@param pokemonJsuzukiSearchForm form
	 *@return PokemonMainJsuzukiのリスト
	 *
	 */
	List<PokemonMainJsuzuki> getListPokemon(final PokemonJsuzukiSearchForm form);

	/**
	 *IDをキーにPokemonMainJsuzukiのレコードを取得する
	 *
	 *@param long  id
	 *@return PokemonMainJsuzukiのレコード
	 */
	PokemonMainJsuzuki getPokemon(final long id);

	/**
	 *PokemonMainJsuzukiにレコードを新規登録する
	 *
	 *@param PokemonJsuzukiInputForm form
	 * @return PokemonJsuzuki
	 */
	PokemonMainJsuzuki insertPokemon(final PokemonJsuzukiInputForm form);

	/**
	 *PokemonMainJsuzukiのレコードを更新する
	 *
	 * @param  PokemonJsuzukiInputForm form
	 * @rerurn PokemonMainJsuzuki
	 */
	PokemonMainJsuzuki updatePokemon(final PokemonJsuzukiInputForm form);

	/**
	 * PokemonMainJsuzukiのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deletePokemonById(final long id);

	/**
	 *PokemonMainJsuzukiのレコードを物理削除する
	 *
	 * @param ArrayList<Long>ids
	 */
	void deletePokemonComp(final ArrayList<Long> ids);


}
