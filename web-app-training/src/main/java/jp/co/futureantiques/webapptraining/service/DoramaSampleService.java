package jp.co.futureantiques.webapptraining.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.doramasample.DoramaGenre;
import jp.co.futureantiques.webapptraining.model.doramasample.DoramaMain;
import jp.co.futureantiques.webapptraining.model.doramasample.TvStation;
import jp.co.futureantiques.webapptraining.model.form.doramasample.DoramaSampleInputForm;
import jp.co.futureantiques.webapptraining.model.form.doramasample.DoramaSampleSearchForm;

/**
 * DoramaSampleのサービスインターフェース
 *
 * @author hiraoka
 */
public interface DoramaSampleService {

	/**
	 * ドラマジャンルエンティティのリストを取得する
	 *
	 * @return DoramaGenreEntityのリスト
	 */
	List<DoramaGenre> getListDoramaGenre();

	/**
	 * 放送局エンティティのリストを取得する
	 *
	 * @return TvStationEntityのリスト
	 */
	List<TvStation> getListTvStation();

	/**
	 * 検索条件を元にDoramaMainのレコードのリストを取得する(Paging)
	 *
	 * @param DoramaSampleSearchForm form
	 * @param Pageable pageable
	 * @return DoramaMainのリスト
	 */
	Page<DoramaMain> getPageDorama(final DoramaSampleSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にDoramaMainのレコードのリストを取得する
	 *
	 * @param DoramaSampleSearchForm form
	 * @return MovieMainのリスト
	 */
	List<DoramaMain> getListDorama(final DoramaSampleSearchForm form);

	/**
	 * IDをキーにDoramaMainのレコードを取得する
	 *
	 * @param long id
	 * @return DoramaMainのレコード
	 */
	DoramaMain getDorama(final long id);

	/**
	 * DoramaMainにレコードを新規登録する
	 *
	 * @param DoramaSampleInputForm form
	 * @return DoramaMain
	 */
	DoramaMain insertDorama(final DoramaSampleInputForm form);

	/**
	 * DoramaMainのレコードを更新する
	 *
	 * @param DoramaSampleInputForm form
	 * @return DoramaMain
	 */
	DoramaMain updateDorama(final DoramaSampleInputForm form);

	/**
	 * DoramaMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteDoramaById(final long id);

	/**
	 * DoramaMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteDoramaComp(final ArrayList<Long> ids);
}