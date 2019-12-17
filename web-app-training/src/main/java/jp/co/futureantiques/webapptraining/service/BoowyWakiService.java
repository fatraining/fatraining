package jp.co.futureantiques.webapptraining.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.boowyWaki.BoowyMainWaki;
import jp.co.futureantiques.webapptraining.model.boowyWaki.GenreWaki;
import jp.co.futureantiques.webapptraining.model.boowyWaki.SongwriterWaki;
import jp.co.futureantiques.webapptraining.model.form.boowyWaki.BoowyWakiInputForm;
import jp.co.futureantiques.webapptraining.model.form.boowyWaki.BoowyWakiSearchForm;

/**
 * Boowyのサービスインターフェース
 *
 * @author WAKI
 */
public interface BoowyWakiService {
	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	List<GenreWaki> getListGenreWaki();

	/**
	 * 作詞者エンティティのリストを取得する
	 *
	 * @return SongwriterEntityのリスト
	 */
	List<SongwriterWaki> getListSongwriterWaki();


	/**
	 * 検索条件を元にBoowyMainWakiのレコードのリストを取得する(Paging)
	 *
	 * @param BoowyWakiSearchForm form
	 * @param Pageable pageable
	 * @param BoowyMainWakiのリスト
	 */
	Page<BoowyMainWaki> getPageBoowyMainWaki(final BoowyWakiSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にBoowyMainWakiのレコードのリストを取得する
	 *
	 * @param BoowyWakiSearchForm form
	 * @return BoowyMainWakiのリスト
	 */
	List<BoowyMainWaki> getListBoowyMainWaki(final BoowyWakiSearchForm form);

	/**
	 * IDをキーにBoowyMainWakiのレコードを取得する
	 *
	 * @param long id
	 * @return BoowyMainWakiのレコード
	 */
	BoowyMainWaki getBoowyMainWaki(final long id);

	/**
	 * BoowyMainWakiにレコードを新規登録する
	 *
	 * @param BoowyWakiInputForm form
	 * @return BoowyMainWaki
	 */
	BoowyMainWaki insertBoowyMainWaki(final BoowyWakiInputForm form);

	/**
	 * BoowyMainWakiのレコードを更新する
	 *
	 * @param BoowyWakiInputForm form
	 * @return BoowyMainWaki
	 */
	BoowyMainWaki updateBoowyMainWaki(final BoowyWakiInputForm form);

	/**
	 * BoowyMainWakiのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteBoowyMainWakiById(final long id);

	/**
	 * BoowyMainWakiのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteBoowyMainWakiComp(final ArrayList<Long> ids);

}