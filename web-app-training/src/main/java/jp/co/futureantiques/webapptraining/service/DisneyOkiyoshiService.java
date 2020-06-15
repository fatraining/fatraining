package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.DisneyMainOkiyoshi;
import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.EreaOkiyoshi;
import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.GenreOkiyoshi;
import jp.co.futureantiques.webapptraining.model.form.disneyOkiyoshi.DisneyOkiyoshiInputForm;
import jp.co.futureantiques.webapptraining.model.form.disneyOkiyoshi.DisneyOkiyoshiSearchForm;

/**
 * Disneyのサービスインターフェース
 *
 * @author future
 */
public interface DisneyOkiyoshiService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	public List<GenreOkiyoshi> getListGenreOkiyoshi();

	/**
	 * 映画俳優エンティティのリストを取得する
	 *
	 * @return MovieActorEntityのリスト
	 */
	public List<EreaOkiyoshi> getListEreaOkiyoshi();

	/**
	 * 検索条件を元にDisneyMainのレコードのリストを取得する(Paging)
	 *
	 * @param DisneyOkiyoshiSearchForm form
	 * @param Pageable pageable
	 * @return DisneyMainのリスト
	 */
	public Page<DisneyMainOkiyoshi> getPageDisneyOkiyoshi(final DisneyOkiyoshiSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にDisneyMainのレコードのリストを取得する
	 *
	 * @param DisneyOkiyoshiSearchForm form
	 * @return DisneyMainのリスト
	 */
	public List<DisneyMainOkiyoshi> getListDisneyOkiyoshi(final DisneyOkiyoshiSearchForm form);

	/**
	 * IDをキーにDisneyMainのレコードを取得する
	 *
	 * @param long id
	 * @return DisneyMainのレコード
	 */
	public DisneyMainOkiyoshi getDisneyOkiyoshi(final long id);

	/**
	 * DisneyMainにレコードを新規登録する
	 *
	 * @param DisneyOkiyoshiInputForm form
	 * @return DisneyMain
	 */
	public DisneyMainOkiyoshi insertDisneyOkiyoshi(final DisneyOkiyoshiInputForm form);

	/**
	 * DisneyMainのレコードを更新する
	 *
	 * @param DisneyOkiyoshiInputForm form
	 * @return DisneyMain
	 */
	public DisneyMainOkiyoshi updateDisneyOkiyoshi(final DisneyOkiyoshiInputForm form);

	/**
	 * DisneyMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	public void deleteDisneyOkiyoshiById(final long id);

	/**
	 * DisneyMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	public void deleteDisneyOkiyoshiComp(final ArrayList<Long> ids);
}
