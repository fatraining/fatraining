package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.booknakano.AuthorNakano;
import com.example.demo.model.booknakano.BookMainNakano;
import com.example.demo.model.booknakano.CharacterOrthographyNakano;
import com.example.demo.model.booknakano.ClassificationNakano;
import com.example.demo.model.form.booknakano.BookNakanoInputForm;
import com.example.demo.model.form.booknakano.BookNakanoSearchForm;

/**
 * BookNakanoのサービスインターフェース
 *
 * @author future
 */
public interface BookNakanoService {

	/**
	 * 著者エンティティのリストを取得する
	 *
	 * @return AuthorEntityのリスト
	 */
	List<AuthorNakano> getListAuthor();

	/**
	 * 分類エンティティのリストを取得する
	 *
	 * @return ClassificationEntityのリスト
	 */
	List<ClassificationNakano> getListClassification();

	/**
	 * 文字遣い種別エンティティのリストを取得する
	 *
	 * @return CharacterOrthographyEntityのリスト
	 */
	List<CharacterOrthographyNakano> getListCharacterOrthography();

	/**
	 * 検索条件を元にBookMainのレコードのリストを取得する(Paging)
	 *
	 * @param BookNakanoSearchForm form
	 * @param Pageable pageable
	 * @return BookMainのリスト
	 */
	Page<BookMainNakano> getPageBook(final BookNakanoSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にBookMainのレコードのリストを取得する
	 *
	 * @param BookNakanoSearchForm form
	 * @return BookMainのリスト
	 */
	List<BookMainNakano> getListBook(final BookNakanoSearchForm form);

	/**
	 * IDをキーにBookMainのレコードを取得する
	 *
	 * @param long id
	 * @return BookMainのレコード
	 */
	BookMainNakano getBook(final long id);

	/**
	 * BookMainにレコードを新規登録する
	 *
	 * @param BookNakanoInputForm form
	 * @return BookMain
	 */
	BookMainNakano insertBook(final BookNakanoInputForm form);

	/**
	 * BookMainのレコードを更新する
	 *
	 * @param BookNakanoInputForm form
	 * @return BookMain
	 */
	BookMainNakano updateBook(final BookNakanoInputForm form);

	/**
	 * BookMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteBookById(final long id);

	/**
	 * BookMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteBookComp(final ArrayList<Long> ids);
}
