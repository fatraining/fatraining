package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.novelOkudaira.NovelOkudairaInputForm;
import jp.co.futureantiques.webapptraining.model.form.novelOkudaira.NovelOkudairaSearchForm;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.GenreOkudaira;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.NovelMainOkudaira;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.WriterOkudaira;

/**
 * Novelのサービスインターフェース
 *
 * @author future
 */
public interface NovelOkudairaService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreOkudairaEntityのリスト
	 */
	List<GenreOkudaira> getListGenreOkudaira();

	/**
	 * 作家エンティティのリストを取得する
	 *
	 * @return WriterOkudairaEntityのリスト
	 */
	List<WriterOkudaira> getListWriterOkudaira();

	/**
	 * 検索条件を元にNovelMainOkudairaのレコードのリストを取得する(Paging)
	 *
	 * @param NovelSearchForm form
	 * @param Pageable pageable
	 * @return NovelMainOkudairaのリスト
	 */
	Page<NovelMainOkudaira> getPageNovel(final NovelOkudairaSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にNovelMainOkudairaのレコードのリストを取得する
	 *
	 * @param NovelSearchForm form
	 * @return NovelMainOkudairaのリスト
	 */
	List<NovelMainOkudaira> getListNovel(final NovelOkudairaSearchForm form);

	/**
	 * IDをキーにNovelMainOkudairaのレコードを取得する
	 *
	 * @param long id
	 * @return NovelMainOkudairaのレコード
	 */
	NovelMainOkudaira getNovel(final long id);

	/**
	 * NovelMainOkudairaにレコードを新規登録する
	 *
	 * @param NovelInputForm form
	 * @return NovelMainOkudaira
	 */
	NovelMainOkudaira insertNovel(final NovelOkudairaInputForm form);

	/**
	 * NovelMainOkudairaのレコードを更新する
	 *
	 * @param NovelInputForm form
	 * @return NovelMainOkudaira
	 */
	NovelMainOkudaira updateNovel(final NovelOkudairaInputForm form);

	/**
	 * NovelMainOkudairaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteNovelById(final long id);

	/**
	 * NovelMainOkudairaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteNovelComp(final ArrayList<Long> ids);
}