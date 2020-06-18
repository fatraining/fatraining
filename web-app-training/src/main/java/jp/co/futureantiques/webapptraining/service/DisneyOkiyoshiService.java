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
	 * エリアエンティティのリストを取得する
	 *
	 * @return EreaEntityのリスト
	 */
	public List<EreaOkiyoshi> getListEreaOkiyoshi();

	/**
	 * 検索条件を元にDisneyMainOkiyoshiのレコードのリストを取得する(Paging)
	 *
	 * @param DisneyOkiyoshiSearchForm form
	 * @param Pageable pageable
	 * @return DisneyMainのリスト
	 */
	public Page<DisneyMainOkiyoshi> getPageDisneyOkiyoshi(final DisneyOkiyoshiSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にDisneyMainOkiyoshiのレコードのリストを取得する
	 *
	 * @param DisneyOkiyoshiSearchForm form
	 * @return DisneyMainのリスト
	 */
	public List<DisneyMainOkiyoshi> getListDisneyOkiyoshi(final DisneyOkiyoshiSearchForm form);

	/**
	 * IDをキーにDisneyMainOkiyoshiのレコードを取得する
	 *
	 * @param long id
	 * @return DisneyMainOkiyoshiのレコード
	 */
	public DisneyMainOkiyoshi getDisneyOkiyoshi(final long id);

	/**
	 * DisneyMainOkiyoshiにレコードを新規登録する
	 *
	 * @param DisneyOkiyoshiInputForm form
	 * @return DisneyMainOkiyoshi
	 */
	public DisneyMainOkiyoshi insertDisneyOkiyoshi(final DisneyOkiyoshiInputForm form);

	/**
	 * DisneyMainOkiyoshiのレコードを更新する
	 *
	 * @param DisneyOkiyoshiInputForm form
	 * @return DisneyMainOkiyoshi
	 */
	public DisneyMainOkiyoshi updateDisneyOkiyoshi(final DisneyOkiyoshiInputForm form);

	/**
	 * DisneyMainOkiyoshiのレコードを論理削除する
	 *
	 * @param long id
	 */
	public void deleteDisneyOkiyoshiById(final long id);

	/**
	 * DisneyMainOkiyoshiのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	public void deleteDisneyOkiyoshiComp(final ArrayList<Long> ids);
}
