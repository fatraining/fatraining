package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.cdKanayama.CdMainKanayama;
import jp.co.futureantiques.webapptraining.model.cdKanayama.GenreKanayama;
import jp.co.futureantiques.webapptraining.model.form.cdKanayama.CdKanayamaInputForm;
import jp.co.futureantiques.webapptraining.model.form.cdKanayama.CdKanayamaSearchForm;

/**
 * CdKanayamaのサービスインターフェース
 *
 * @author future
 */

public interface CdKanayamaService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreKanayamaEntityのリスト
	 */
	List<GenreKanayama> getListGenreKanayama();

	/**
	 * 検索条件を元にCdMainのレコードのリストを取得する(Paging)
	 *
	 * @param CdKanayamaSearchForm form
	 * @param Pageable pageable
	 * @return CdMainKanayamaのリスト
	 */
	Page<CdMainKanayama> getPageCd(final CdKanayamaSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にCdMainのレコードのリストを取得する
	 *
	 * @param CdKanayaaSearchForm form
	 * @return CdMainKanayamaのリスト
	 */
	List<CdMainKanayama> getListCd(final CdKanayamaSearchForm form);

	/**
	 * IDをキーにCdMainのレコードを取得する
	 *
	 * @param long id
	 * @return CdeMainKanayamaのレコード
	 */
	CdMainKanayama getCd(final long id);

	/**
	 * CdMainにレコードを新規登録する
	 *
	 * @param CdKanayamaInputForm form
	 * @return CdMainKanayama
	 */
	CdMainKanayama insertCd(final CdKanayamaInputForm form);

	/**
	 * CdMainのレコードを更新する
	 *
	 * @param CdKanayamaInputForm form
	 * @return CdMainKanayama
	 */
	CdMainKanayama updateCd(final CdKanayamaInputForm form);

	/**
	 * CdMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteCdById(final long id);

	/**
	 * CdMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteCdComp(final ArrayList<Long> ids);
}
