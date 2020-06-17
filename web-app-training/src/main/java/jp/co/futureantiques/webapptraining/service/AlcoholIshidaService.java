package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.alcoholishida.AlcoholMainIshida;
import jp.co.futureantiques.webapptraining.model.alcoholishida.IngredientIshida;
import jp.co.futureantiques.webapptraining.model.alcoholishida.LiqueurIshida;
import jp.co.futureantiques.webapptraining.model.form.alcoholishida.AlcoholIshidaInputForm;
import jp.co.futureantiques.webapptraining.model.form.alcoholishida.AlcoholIshidaSearchForm;

/**
 * AlcoholIshidaのサービスインターフェース
 *
 * @author t.ishida
 */
public interface AlcoholIshidaService {

	/**
	 *材料エンティティのリストを取得する
	 *
	 *@return Ingredientエンティティのリスト
	 */
	List<IngredientIshida> getListIngredient();

	/**
	 *リキュールエンティティのリストを取得する
	 *
	 *@return Liqueurエンティティのリスト
	 */
	List<LiqueurIshida> getListLiqueur();

	/**
	 *検索結果を元にAlcoholMainIshidaのレコードリストを取得する(paging)
	 *
	 *@param alcoholIshidaSearchForm form
	 *@param Pageable pageable
	 *@return AlcoholMainIshidaのリスト
	 */
	Page<AlcoholMainIshida> getPageAlcohol(final AlcoholIshidaSearchForm form, final Pageable pageable);

	/**
	 *検索結果を元にalcoholMainIshidaのレコードリストを取得する
	 *
	 *@param alcoholIshidaSearchForm form
	 *@return AlcoholMainIshidaのリスト
	 *
	 */
	List<AlcoholMainIshida> getListAlcohol(final AlcoholIshidaSearchForm form);

	/**
	 *IDをキーにalcoholMainIshidaのレコードを取得する
	 *
	 *@param long  id
	 *@return AlcoholMainIshidaのレコード
	 */
	AlcoholMainIshida getAlcohol(final long id);

	/**
	 *AlcoholMainIshidaにレコードを新規登録する
	 *
	 *@param AlcoholIshidaInputForm form
	 * @return AlcoholIshida
	 */
	AlcoholMainIshida insertAlcohol(final AlcoholIshidaInputForm form);

	/**
	 *AlcoholMainIshidaのレコードを更新する
	 *
	 * @param  AlcoholIshidaInputForm form
	 * @rerurn AlcoholMainIshida
	 */
	AlcoholMainIshida updateAlcohol(final AlcoholIshidaInputForm form);

	/**
	 * AlcoholMainIshidaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteAlcoholById(final long id);

	/**
	 *AlcoholMainIshidaのレコードを物理削除する
	 *
	 * @param ArrayList<Long>ids
	 */
	void deleteAlcoholComp(final ArrayList<Long> ids);
}
