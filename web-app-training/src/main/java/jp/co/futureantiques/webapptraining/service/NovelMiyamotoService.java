package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.novelmiyamoto.NovelInputForm;
import jp.co.futureantiques.webapptraining.model.form.novelmiyamoto.NovelSearchForm;
import jp.co.futureantiques.webapptraining.model.novelmiyamoto.AuthorMiyamoto;
import jp.co.futureantiques.webapptraining.model.novelmiyamoto.BookMainMiyamoto;
import jp.co.futureantiques.webapptraining.model.novelmiyamoto.GenreMiyamoto;

/**
 * Novelのサービスインターフェース
 */
public interface NovelMiyamotoService {

	/**
	 * ジャンルエンティティのリストを取得する
	 */
	List<GenreMiyamoto> getListGenreMiyamoto();

	/**
	 * 作者エンティティのリストを取得する
	 */
	List<AuthorMiyamoto> getListNovelAuthor();

	/**
	 * 検索条件を元にbookMainMiyamotoのレコードのリストを取得する(Paging)
	 */
	Page<BookMainMiyamoto> getPageNovel(final NovelSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にbookMainMiyamotoのレコードのリストを取得する
	 */
	List<BookMainMiyamoto> getListNovel(final NovelSearchForm form);

	/**
	 * IDをキーにbookMainMiyamotoのレコードを取得する
	 */
	BookMainMiyamoto getNovel(final long id);

	/**
	 * bookMainMiyamotoにレコードを新規登録する
	 */
	BookMainMiyamoto insertNovel(final NovelInputForm form);

	/**
	 * bookMainMiyamotoのレコードを更新する
	 */
	BookMainMiyamoto updateNovel(final NovelInputForm form);

	/**
	 * bookMainMiyamotoのレコードを論理削除する
	 */
	void deleteNovelById(final long id);

	/**
	 * bookMainMiyamotoのレコードを物理削除する
	 */
	void deleteNovelComp(final ArrayList<Long> ids);
}