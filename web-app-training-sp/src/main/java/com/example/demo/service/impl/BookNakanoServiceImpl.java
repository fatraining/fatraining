package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.booknakano.AuthorNakano;
import com.example.demo.model.booknakano.BookMainNakano;
import com.example.demo.model.booknakano.CharacterOrthographyNakano;
import com.example.demo.model.booknakano.ClassificationNakano;
import com.example.demo.model.form.booknakano.BookNakanoInputForm;
import com.example.demo.model.form.booknakano.BookNakanoSearchForm;
import com.example.demo.repository.booknakano.AuthorNakanoRepository;
import com.example.demo.repository.booknakano.BookMainNakanoRepository;
import com.example.demo.repository.booknakano.CharacterOrthographyNakanoRepository;
import com.example.demo.repository.booknakano.ClassificationNakanoRepository;
import com.example.demo.repository.specification.BookNakanoSpecification;
import com.example.demo.service.BookNakanoService;

/**
 * BookNakanoのサービス実装クラス
 *
 * @author future
 */
@Service
public class BookNakanoServiceImpl implements BookNakanoService {

	/** BookMainリポジトリ */
	private final BookMainNakanoRepository bookMainRepository;

	/** Authorリポジトリ */
	private final AuthorNakanoRepository authorRepository;

	/** Classificationリポジトリ */
	private final ClassificationNakanoRepository classificationRepository;

	/** CharacterOrthographyリポジトリ */
	private final CharacterOrthographyNakanoRepository characterOrthographyRepository;

	/**
	 * コンストラクタ
	 *
	 * @param BookMainNakanoRepository bookMainRepository
	 * @param AuthorNakanoRepository authorRepository
	 * @param ClassificationNakanoRepository classificationRepository
	 * @param CharacterOrthographyNakanoRepository characterOrthographyRepository
	 */
	public BookNakanoServiceImpl(BookMainNakanoRepository bookMainRepository,
			AuthorNakanoRepository authorRepository,
			ClassificationNakanoRepository classificationRepository,
			CharacterOrthographyNakanoRepository characterOrthographyRepository) {
		this.bookMainRepository = bookMainRepository;
		this.authorRepository = authorRepository;
		this.classificationRepository = classificationRepository;
		this.characterOrthographyRepository = characterOrthographyRepository;
	}

	@Override
	public List<AuthorNakano> getListAuthor() {

		// AuthorテーブルのレコードをID順に取得する TO:DO
		return authorRepository.findAll();
	}

	@Override
	public List<ClassificationNakano> getListClassification() {

		// ClassificationテーブルのレコードをID順に取得する TO:DO
		return classificationRepository.findAll();
	}

	@Override
	public List<CharacterOrthographyNakano> getListCharacterOrthography() {

		// CharacterOrthographyテーブルのレコードをID順に取得する TO:DO
		return characterOrthographyRepository.findAll();
	}

	@Override
	public Page<BookMainNakano> getPageBook(final BookNakanoSearchForm form, final Pageable pageable) {

		// 検索条件を生成しBookMainテーブルのレコードを取得する
		return bookMainRepository.findAll(BookNakanoSpecification.generateBookSpecification(form), pageable);
	}

	@Override
	public List<BookMainNakano> getListBook(final BookNakanoSearchForm form) {

		// 検索条件を生成しBookMainテーブルのレコードを取得する
		return bookMainRepository.findAll(BookNakanoSpecification.generateBookSpecification(form));
	}

	@Override
	public BookMainNakano getBook(final long id) {

		// BookMainテーブルを主キー検索する
		BookMainNakano bookMain = bookMainRepository.findById(id).get();
		return bookMain;
	}

	@Override
	public BookMainNakano insertBook(final BookNakanoInputForm form) {

		// BookMainテーブルに新規でデータを登録する
		final BookMainNakano bookMain = form.convertToBookMainForInsert();
		return bookMainRepository.saveAndFlush(bookMain);
	}

	@Override
	public BookMainNakano updateBook(final BookNakanoInputForm form) {

		// 更新対象のレコードを取得する
		Optional<BookMainNakano> bookMainOp = bookMainRepository.findById((long) form.getId());

		BookMainNakano bookMain = bookMainOp.get();
		if (bookMain != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(bookMain.getUpdateDate()))) {

				// チェックOKの場合、更新
				bookMain = form.convertToBookMainForUpdate(bookMain);
				return bookMainRepository.saveAndFlush(bookMain);
			}
		}
		return null;
	}

	@Override
	public void deleteBookById(final long id) {

		// 更新対象のレコードを取得する
		Optional<BookMainNakano> bookMainOp = bookMainRepository.findById(id);
		BookMainNakano bookMain = bookMainOp.get();
		if (bookMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			bookMainRepository.delete(id);
		}
	}

	@Override
	public void deleteBookComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		bookMainRepository.deleteComp(ids);
	}
}
