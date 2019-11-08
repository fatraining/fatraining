package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.novelOkudaira.NovelOkudairaInputForm;
import jp.co.futureantiques.webapptraining.model.form.novelOkudaira.NovelOkudairaSearchForm;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.GenreOkudaira;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.NovelMainOkudaira;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.WriterOkudaira;
import jp.co.futureantiques.webapptraining.repository.novelOkudaira.GenreOkudairaRepository;
import jp.co.futureantiques.webapptraining.repository.novelOkudaira.NovelMainOkudairaRepository;
import jp.co.futureantiques.webapptraining.repository.novelOkudaira.WriterOkudairaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.NovelOkudairaSpecification;
import jp.co.futureantiques.webapptraining.service.NovelOkudairaService;

/**
 * Novelのサービス実装クラス
 *
 * @author future
 */
@Service
public class NovelOkudairaServiceImpl implements NovelOkudairaService {

	/** NovelMainOkudairaリポジトリ */
	private final NovelMainOkudairaRepository novelMainOkudairaRepository;

	/** GenreOkudairaリポジトリ */
	private final GenreOkudairaRepository genreOkudairaRepository;

	/** WriterOkudairaリポジトリ */
	private final WriterOkudairaRepository writerOkudairaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param NovelMainOkudairaRepository novelMainOkudairaRepository
	 * @param GenreOkudairaRepository genreOkudairaRepository
	 * @param WriterOkudairaRepository writerOkudairaRepository
	 */
	@Autowired
	public NovelOkudairaServiceImpl(NovelMainOkudairaRepository novelMainOkudairaRepository, GenreOkudairaRepository genreOkudairaRepository,
			WriterOkudairaRepository writerOkudairaRepository) {
		this.novelMainOkudairaRepository = novelMainOkudairaRepository;
		this.genreOkudairaRepository = genreOkudairaRepository;
		this.writerOkudairaRepository = writerOkudairaRepository;
	}

	@Override
	public List<GenreOkudaira> getListGenreOkudaira() {

		// GenreOkudairaテーブルのレコードをID順に取得する
		return genreOkudairaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<WriterOkudaira> getListWriterOkudaira() {

		// WriterOkudairaテーブルのレコードをID順に取得する
		return writerOkudairaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<NovelMainOkudaira> getPageNovel(final NovelOkudairaSearchForm form, final Pageable pageable) {

		// 検索条件を生成しNovelMainOkudairaテーブルのレコードを取得する
		return novelMainOkudairaRepository.findAll(NovelOkudairaSpecification.generateNovelSpecification(form), pageable);
	}

	@Override
	public List<NovelMainOkudaira> getListNovel(final NovelOkudairaSearchForm form) {

		// 検索条件を生成しNovelMainOkudairaテーブルのレコードを取得する
		return novelMainOkudairaRepository.findAll(NovelOkudairaSpecification.generateNovelSpecification(form));
	}

	@Override
	public NovelMainOkudaira getNovel(final long id) {

		// NovelMainOkudairaテーブルを主キー検索する
		return novelMainOkudairaRepository.findOne(id);
	}

	@Override
	public NovelMainOkudaira insertNovel(final NovelOkudairaInputForm form) {

		// NovelMainOkudairaテーブルに新規でデータを登録する
		final NovelMainOkudaira novelMainOkudaira = form.convertToNovelMainOkudairaForInsert();
		return novelMainOkudairaRepository.save(novelMainOkudaira);
	}

	@Override
	public NovelMainOkudaira updateNovel(final NovelOkudairaInputForm form) {

		// 更新対象のレコードを取得する
		NovelMainOkudaira novelMainOkudaira = novelMainOkudairaRepository.findOne((long) form.getId());
		if (novelMainOkudaira != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(novelMainOkudaira.getUpdateDate()))) {

				// チェックOKの場合、更新
				novelMainOkudaira = form.convertToNovelMainOkudairaForUpdate(novelMainOkudaira);
				return novelMainOkudairaRepository.saveAndFlush(novelMainOkudaira);
			}
		}
		return null;
	}

	@Override
	public void deleteNovelById(final long id) {

		// 更新対象のレコードを取得する
		NovelMainOkudaira novelMainOkudaira = novelMainOkudairaRepository.findOne(id);
		if (novelMainOkudaira != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			novelMainOkudairaRepository.delete(id);
		}
	}

	@Override
	public void deleteNovelComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		novelMainOkudairaRepository.deleteComp(ids);
	}
}