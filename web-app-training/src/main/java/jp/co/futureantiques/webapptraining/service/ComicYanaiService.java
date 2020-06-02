package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.comicYanai.ComicMainYanai;
import jp.co.futureantiques.webapptraining.model.comicYanai.GenreYanai;
import jp.co.futureantiques.webapptraining.model.comicYanai.PubcoYanai;
import jp.co.futureantiques.webapptraining.model.form.comicYanai.ComicYanaiInputForm;
import jp.co.futureantiques.webapptraining.model.form.comicYanai.ComicYanaiSearchForm;

//comicYanaiserviceのインターフェイス
public interface ComicYanaiService {

	//ジャンルのリストを取得
	List<GenreYanai> getListGenre();

	//出版社のリストを取得
	List<PubcoYanai> getListPubco();


	/**
	 * 検索条件を元にComicMainYanaiのレコードのリストを取得する(Paging)
	 *
	 */
	Page<ComicMainYanai> getPageComic(final ComicYanaiSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にComicMainYaniのレコードのリストを取得する
	 */
	List<ComicMainYanai> getListComic(final ComicYanaiSearchForm form);

	/**
	 * IDをキーにComicMainYanaiのレコードを取得する
	 *
	 * @param long id
	 * @return ComicMainYanaiのレコード
	 */
	ComicMainYanai getComic(final long id);

	/**
	 * ComicMainYanaiにレコードを新規登録する
	 *
	 * @param ComicYanaiInputForm form
	 * @return ComicMainYanai
	 */
	ComicMainYanai insertComic(final ComicYanaiInputForm form);

	/**
	 * ComicMainYanaiのレコードを更新する
	 *
	 * @param ComicYanaiInputForm form
	 * @return ComicMainYanai
	 */
	ComicMainYanai updateComic(final ComicYanaiInputForm form);

	/**
	 * ComicMainYanaiのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteComicById(final long id);

	/**
	 * ComicMainYanaiのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteComicComp(final ArrayList<Long> ids);

}
