package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.ClassTiba;
import jp.co.futureantiques.webapptraining.model.championTiba.CountryTiba;
import jp.co.futureantiques.webapptraining.model.form.championTiba.ChampionTibaSearchForm;

/** ChampionTibaのサービスインターフェース */

public interface ChampionTibaService {

	/**
	 * 階級エンティティのリストを取得する
	 *
	 * @return ClassEntityのリスト
	 */
	List<ClassTiba> getListClass();

	/**
	 * 国名エンティティのリストを取得する
	 *
	 * @return CountryEntityのリスト
	 */
	List<CountryTiba> getListCountry();

	/**
	 * 検索条件を元にChampionMainTibaのレコードのリストを取得する(Paging)
	 *
	 * @param ChampionTibaSearchForm form
	 * @param Pageable pageable
	 * @return ChampionMainTibaのリスト
	 */
	Page<ChampionMainTiba> getPageChampion(final ChampionTibaSearchForm form, Pageable pageable);

	/**
	 * 検索条件を元にChampionMainTibaのレコードのリストを取得する
	 *
	 * @param ChampiontibaSearchForm form
	 * @return ChampionMainTibaのリスト
	 */
	List<ChampionMainTiba> getListChampion(final ChampionTibaSearchForm form);

	/**
	 * IDをキーにChampionMainTibaのレコードを取得する
	 *
	 * @param long id
	 * @return ChampionMainTibaのレコード
	 */
	ChampionMainTiba getChampion(final long id);

	//論理削除
		/**
		 * ChampionMainのレコードを論理削除する
		 *
		 * @param long id
		 */
	void deleteChampionById(final long id);

	//未作成↓
		/**
		 * ChampionMainのレコードを物理削除する
		 *
		 * @param ArrayList<Long> ids
		 *
		void deleteChampionComp(final ArrayList<Long> ids);

		*/
}
