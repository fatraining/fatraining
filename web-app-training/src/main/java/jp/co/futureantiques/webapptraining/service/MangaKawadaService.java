package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.mangaKawada.MangaKawadaInputForm;
import jp.co.futureantiques.webapptraining.model.form.mangaKawada.MangaKawadaSearchForm;
import jp.co.futureantiques.webapptraining.model.mangaKawada.AnimeKawada;
import jp.co.futureantiques.webapptraining.model.mangaKawada.GenreKawada;
import jp.co.futureantiques.webapptraining.model.mangaKawada.MangaMainKawada;
import jp.co.futureantiques.webapptraining.model.mangaKawada.SituationKawada;

/**
 * MangaKawadaのサービスインターフェース
 *
 * @author Kawada
 */
public interface MangaKawadaService {
	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	List<GenreKawada> getListGenreKawada();

	/**
	 * アニメ化エンティティのリストを取得する
	 *
	 * @return AnimeEntityのリスト
	 */
	List<AnimeKawada> getListAnimeKawada();

	/**
	 * 連載状況エンティティのリストを取得する
	 *
	 * @return SituationEntityのリスト
	 */
	List<SituationKawada> getListSituationKawada();

	/**
	 * 検索条件を元にMangaMainKawadaのレコードのリストを取得する(Paging)
	 *
	 * @param MangaKawadaSearchForm form
	 * @param Pageable pageable
	 * @return MangaMainKawadaのリスト
	 */
	Page<MangaMainKawada> getPageManga(final MangaKawadaSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にMangaMainKawadaのレコードのリストを取得する
	 *
	 * @param MangaKawadaSearchForm form
	 * @return MangaMainKawadaのリスト
	 */
	List<MangaMainKawada> getListMangaMainKawada(final MangaKawadaSearchForm form);

	/**
	 * IDをキーにMangaMainKawadaのレコードを取得する
	 *
	 * @param long id
	 * @return MangaMainKawadaのレコード
	 */
	MangaMainKawada getManga(final long id);

	/**
	 * MangaMainKawdaにレコードを新規登録する
	 *
	 * @param MangaKawadaInputForm form
	 * @return MangaMainKawada
	 */
	MangaMainKawada insertManga(final MangaKawadaInputForm form);

	/**
	 * MangaMainKawadaのレコードを更新する
	 *
	 * @param MangaKawadaInputForm form
	 * @return MangaMainKawada
	 */
	MangaMainKawada updateManga(final MangaKawadaInputForm form);

	/**
	 * MangaMainKawadaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteMangaKawadaById(final long id);

	/**
	 * MangaMainKawadaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteMangaKawadaComp(final ArrayList<Long> ids);

}
