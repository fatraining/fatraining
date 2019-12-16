package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.filmAkata.FilmActorAkata;
import jp.co.futureantiques.webapptraining.model.filmAkata.FilmGenreAkata;
import jp.co.futureantiques.webapptraining.model.filmAkata.FilmMainAkata;
import jp.co.futureantiques.webapptraining.model.form.filmAkata.FilmAkataInputForm;
import jp.co.futureantiques.webapptraining.model.form.filmAkata.FilmAkataSearchForm;

/**
 * FilmAkataのサービスインターフェース
 *
 * @author future
 */

public interface FilmAkataService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return FilmGenreAkataEntityのリスト
	 */
	List<FilmGenreAkata> getListFilmGenreAkata();

	/**
	 * 映画主演エンティティのリストを取得する
	 *
	 * @return FilmActorAkataEntityのリスト
	 */
	List<FilmActorAkata> getListFilmActorAkata();

	/**
	 * 検索条件を元にFilmMainのレコードのリスト取得する（Paging）
	 *
	 * @param FilmAkataSearchForm form
	 * @param pageable pageable
	 * @return FilmMainAkataのリスト
	 */
	Page<FilmMainAkata> getPageFilm(final FilmAkataSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にFilmMainのレコードリストを取得する
	 *
	 * @param FilmAkataSearcgForm form
	 * @return FilmMainAkataのリスト
	 */
	List<FilmMainAkata> getListFilm(final FilmAkataSearchForm form);

	/**
	 * IDをキーにFilmMainAkataのレコードを取得する
	 *
	 * @param long id
	 * @return FilmMainAkataのレコード
	 */
	FilmMainAkata getFilm(final long id);

	/**
	 * FilmMainにレコードを新規登録する
	 *
	 * @param FilmAkataInputForm form
	 * @return FilmMainAkata
	 */
	FilmMainAkata insertFilm(final FilmAkataInputForm form);

	/**
	 * FilmMainAkataのレコードを更新する
	 *
	 * @param FilmAkataInputForm form
	 * @return FilmMainAkata
	 */
	FilmMainAkata updateFilm(final FilmAkataInputForm form);

	/**
	 * FilmMainAkataのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteFilmById(final long id);

	/**
	 * FilmMainAkataのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteFilmComp(final ArrayList<Long> ids);
}
