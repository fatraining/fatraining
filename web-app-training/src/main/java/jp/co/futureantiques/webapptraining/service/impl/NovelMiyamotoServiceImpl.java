package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.novelmiyamoto.NovelInputForm;
import jp.co.futureantiques.webapptraining.model.form.novelmiyamoto.NovelSearchForm;
import jp.co.futureantiques.webapptraining.model.novelmiyamoto.AuthorMiyamoto;
import jp.co.futureantiques.webapptraining.model.novelmiyamoto.BookMainMiyamoto;
import jp.co.futureantiques.webapptraining.model.novelmiyamoto.GenreMiyamoto;
import jp.co.futureantiques.webapptraining.repository.novelmiyamoto.BookMainMiyamotoRepository;
import jp.co.futureantiques.webapptraining.repository.novelmiyamoto.GenreMiyamotoRepository;
import jp.co.futureantiques.webapptraining.repository.novelmiyamoto.NovelAuthorRepository;
import jp.co.futureantiques.webapptraining.repository.specification.NovelMiyamotoSpecification;
import jp.co.futureantiques.webapptraining.service.NovelMiyamotoService;

/**
 * Novelのサービス実装クラス
 */
@Service
public class NovelMiyamotoServiceImpl implements NovelMiyamotoService {
	/** BookMainMiyamotoリポジトリ */
	private final BookMainMiyamotoRepository bookMainMiyamotoRepository;
	/** Genreリポジトリ */
	private final GenreMiyamotoRepository genreMiyamotoRepository;
	/** Authorリポジトリ */
	private final NovelAuthorRepository novelAuthorRepository;
	/**
	 * コンストラクタ
	 */
	@Autowired
	public NovelMiyamotoServiceImpl(BookMainMiyamotoRepository bookMainMiyamotoRepository, GenreMiyamotoRepository genreMiyamotoRepository,
			NovelAuthorRepository novelAuthorRepository) {
		this.bookMainMiyamotoRepository = bookMainMiyamotoRepository;
		this.genreMiyamotoRepository = genreMiyamotoRepository;
		this.novelAuthorRepository = novelAuthorRepository;
	}
	@Override
	public List<GenreMiyamoto> getListGenreMiyamoto() {
		// GenreテーブルのレコードをID順に取得する
		return genreMiyamotoRepository.findAll(new Sort(Sort.Direction.ASC, "genreId"));
	}
	@Override
	public List<AuthorMiyamoto> getListNovelAuthor() {
		// NovelAuthorテーブルのレコードをID順に取得する
		return novelAuthorRepository.findAll(new Sort(Sort.Direction.ASC, "AuthorId"));
	}
	@Override
	public Page<BookMainMiyamoto> getPageNovel(final NovelSearchForm form, final Pageable pageable) {
		// 検索条件を生成しBookMainMiyamotoテーブルのレコードを取得する
		return bookMainMiyamotoRepository.findAll(NovelMiyamotoSpecification.generateNovelSpecification(form), pageable);
	}
	@Override
	public List<BookMainMiyamoto> getListNovel(final NovelSearchForm form) {
		// 検索条件を生成しBookMainMiyamotoテーブルのレコードを取得する
		return bookMainMiyamotoRepository.findAll(NovelMiyamotoSpecification.generateNovelSpecification(form));
	}
	@Override
	public BookMainMiyamoto getNovel(final long id) {
		// BookMainMiyamotoテーブルを主キー検索する
		return bookMainMiyamotoRepository.findOne(id);
	}
	@Override
	public BookMainMiyamoto insertNovel(final NovelInputForm form) {
		// BookMainMiyamotoテーブルに新規でデータを登録する
		final BookMainMiyamoto bookMainMiyamoto = form.convertToBookMainMiyamotoForInsert();
		return bookMainMiyamotoRepository.save(bookMainMiyamoto);
	}
	@Override
	public BookMainMiyamoto updateNovel(final NovelInputForm form) {
		// 更新対象のレコードを取得する
		BookMainMiyamoto bookMainMiyamoto = bookMainMiyamotoRepository.findOne((long) form.getId());
		if (bookMainMiyamoto != null) {
			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(bookMainMiyamoto.getUpdateDate()))) {
				// チェックOKの場合、更新
				bookMainMiyamoto = form.convertToBookMainMiyamotoForUpdate(bookMainMiyamoto);
				return bookMainMiyamotoRepository.saveAndFlush(bookMainMiyamoto);
			}
		}
		return null;
	}
	@Override
	public void deleteNovelById(final long id) {
		// 更新対象のレコードを取得する
		BookMainMiyamoto bookMainMiyamoto = bookMainMiyamotoRepository.findOne(id);
		if (bookMainMiyamoto != null) {
			// 更新対象のレコードが存在する場合、削除フラグを1にする
			bookMainMiyamotoRepository.delete(id);
		}
	}
	@Override
	public void deleteNovelComp(final ArrayList<Long> ids) {
		// 対象のレコードを削除する
		bookMainMiyamotoRepository.deleteComp(ids);
	}
}