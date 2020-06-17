package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.comicMiyoshi.ComicMainMiyoshi;
import jp.co.futureantiques.webapptraining.model.comicMiyoshi.MagazineMiyoshi;
import jp.co.futureantiques.webapptraining.model.form.comicMiyoshi.ComicMiyoshiInputForm;
import jp.co.futureantiques.webapptraining.model.form.comicMiyoshi.ComicMiyoshiSearchForm;

/**
 * ComicMiyoshiのサービスインターフェース
 * @author Miyoshi
 *
 */
public interface ComicMiyoshiService {

	/**
	 * 連載雑誌エンティティのリストを取得する
	 * @return Magazineエンティティのリスト
	 */
	List<MagazineMiyoshi> getListMagazineMiyoshi();

	/**
	 * 検索条件を元にComicMainMiyoshiのレコードリストを取得する(Paging)
	 * @param ComicMiyoshiSearchForm form
	 * @param Pageable pageable
	 * @return ComicMainMiyoshiのリスト
	 */
	Page<ComicMainMiyoshi> getPageComic(final ComicMiyoshiSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にComicMainMiyoshiのレコードのリストを取得する
	 * @param ComicMiyoshiSearchForm form
	 * @return ComicMainMiyoshiのリスト
	 */
	List<ComicMainMiyoshi> getListComic(final ComicMiyoshiSearchForm form);

	/**
	 * IDをキーにComicMainMiyoshiのレコードを取得する
	 * @param long id
	 * @return ComicMainMiyoshiのレコード
	 */
	ComicMainMiyoshi getComic(final long id);

	/**
	 * ComicMainMiyoshiにレコードを新規登録する
	 * @param ComicMiyoshiInputForm form
	 * @return ComicMainMiyoshi
	 */
	ComicMainMiyoshi insertComic(final ComicMiyoshiInputForm form);

	/**
	 * ComicMainMiyoshiのレコードを更新する
	 * @param ComicMiyoshiInputForm form
	 * @return ComicMainMiyoshi
	 */
	ComicMainMiyoshi updateComic(final ComicMiyoshiInputForm form);

	/**
	 * ComicMainMiyoshiのレコードを論理削除する
	 * @param long id
	 */
	void deleteComicById(final long id);

	/**
	 * ComicMainMiyoshiのレコードを物理削除する
	 * @param ArrayList<Long> ids
	 */
	void deleteComicComp(final ArrayList<Long> ids);

}


