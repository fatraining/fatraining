package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.bookUchiyama.BookMainUchiyama;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.GenreUchiyama;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.WriterUchiyama;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaInputForm;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaSearchForm;

/**
 * BookUchiyamaのサービスインターフェイス
 * @author FutureAntiques
 */
public interface BookUchiyamaService {

	/**
	 * ジャンルテーブルのレコードを取得
	 * @return GenreUchiyamaリスト
	 */
	List<GenreUchiyama> getListGenre();

	/**
	 * 作家テーブルのレコードを取得
	 * @return WriterUchiyamaリスト
	 */
	List<WriterUchiyama> getListWriter();

	/**
	 * Page型で検索結果に基づいたレコードを取得
	 * @param BookUchiyamaSearchForm form
	 * @param Pageable pageable
	 * @return Page型検索結果
	 */
	Page<BookMainUchiyama> getPageBook(final BookUchiyamaSearchForm form, final Pageable pageable);

	/**
	 * 検索結果のリストを取得
	 * @param BookUchiyamaSearchForm form
	 * @return BookMainUchiyamaリスト型検索結果
	 */
	List<BookMainUchiyama> getListBook(final BookUchiyamaSearchForm form);

	/**
	 * @param long id
	 * @return BookMainUchiyama型検索結果
	 */
	BookMainUchiyama getBook(final long id);

	/**
	 * フォームの内容を登録
	 * @param BookUchiyamaInputForm form
	 * @return 登録したエンティティ
	 */
	BookMainUchiyama insertBook(final BookUchiyamaInputForm form);

	/**
	 * フォームの内容で更新
	 * @param BookUchiyamaInputForm form
	 * @return 登録したエンティティ
	 */
	BookMainUchiyama updateBook(final BookUchiyamaInputForm form);

	/**
	 * 本IDで検索して削除
	 * @param long id
	 */
	void deleteBookById(final long id);

	/**
	 * 削除リストに含まれる本IDで検索して削除
	 * @param ids
	 */
	void deleteBookComp(final ArrayList<Long> ids);
}
