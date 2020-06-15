package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.DisneyMainOkiyoshi;
import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.EreaOkiyoshi;
import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.GenreOkiyoshi;
import jp.co.futureantiques.webapptraining.model.form.disneyOkiyoshi.DisneyOkiyoshiInputForm;
import jp.co.futureantiques.webapptraining.model.form.disneyOkiyoshi.DisneyOkiyoshiSearchForm;
import jp.co.futureantiques.webapptraining.repository.disneyOkiyoshi.DisneyMainOkiyoshiRepository;
import jp.co.futureantiques.webapptraining.repository.disneyOkiyoshi.EreaOkiyoshiRepository;
import jp.co.futureantiques.webapptraining.repository.disneyOkiyoshi.GenreOkiyoshiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.DisneyOkiyoshiSpecification;
import jp.co.futureantiques.webapptraining.service.DisneyOkiyoshiService;


/**
 * MovieSampleのサービス実装クラス
 *
 * @author future
 */
@Service
public class DisneyOkiyoshiServiceImpl implements DisneyOkiyoshiService {

	/** MovieMainリポジトリ */
	private final DisneyMainOkiyoshiRepository disneyMainOkiyoshiRepository;

	/** Genreリポジトリ */
	private final GenreOkiyoshiRepository genreOkiyoshiRepository;

	/** MovieActorリポジトリ */
	private final EreaOkiyoshiRepository ereaOkiyoshiRepository;

	/**
	 * コンストラクタ
	 *
	 * @param MovieMainRepository movieMainRepository
	 * @param GenreOkiyoshiRepository genreRepository
	 * @param MovieActorRepository movieActorRepository
	 */
	@Autowired
	public DisneyOkiyoshiServiceImpl(DisneyMainOkiyoshiRepository disneyMainOkiyoshiRepository,
			GenreOkiyoshiRepository genreOkiyoshiRepository,
			EreaOkiyoshiRepository ereaOkiyoshiRepository) {
		this.disneyMainOkiyoshiRepository = disneyMainOkiyoshiRepository;
		this.genreOkiyoshiRepository = genreOkiyoshiRepository;
		this.ereaOkiyoshiRepository = ereaOkiyoshiRepository;
	}

	@Override
	public List<GenreOkiyoshi> getListGenreOkiyoshi() {

		// GenreテーブルのレコードをID順に取得する
		return genreOkiyoshiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<EreaOkiyoshi> getListEreaOkiyoshi() {

		// MovieActorテーブルのレコードをID順に取得する
		return ereaOkiyoshiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<DisneyMainOkiyoshi> getPageDisneyOkiyoshi(final DisneyOkiyoshiSearchForm form, final Pageable pageable) {

		// 検索条件を生成しMovieMainテーブルのレコードを取得する
		return disneyMainOkiyoshiRepository.findAll(DisneyOkiyoshiSpecification.generateDisneySpecification(form), pageable);
	}

	@Override
	public List<DisneyMainOkiyoshi> getListDisneyOkiyoshi(final DisneyOkiyoshiSearchForm form) {

		// 検索条件を生成しMovieMainテーブルのレコードを取得する
		return disneyMainOkiyoshiRepository.findAll(DisneyOkiyoshiSpecification.generateDisneySpecification(form));
	}

	@Override
	public DisneyMainOkiyoshi getDisneyOkiyoshi(final long id) {

		// MovieMainテーブルを主キー検索する
		return disneyMainOkiyoshiRepository.findOne(id);
	}

	@Override
	public DisneyMainOkiyoshi insertDisneyOkiyoshi(final DisneyOkiyoshiInputForm form) {

		// MovieMainテーブルに新規でデータを登録する
		final DisneyMainOkiyoshi disneyMainOkiyoshi = form.convertToDisneyMainForInsert();
		return disneyMainOkiyoshiRepository.save(disneyMainOkiyoshi);
	}

	@Override
	public DisneyMainOkiyoshi updateDisneyOkiyoshi(final DisneyOkiyoshiInputForm form) {

		// 更新対象のレコードを取得する
		DisneyMainOkiyoshi disneyMainOkiyoshi = disneyMainOkiyoshiRepository.findOne((long) form.getId());
		if (disneyMainOkiyoshi != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(disneyMainOkiyoshi.getUpdateDate()))) {

				// チェックOKの場合、更新
				disneyMainOkiyoshi = form.convertToDisneyMainForUpdate(disneyMainOkiyoshi);
				return disneyMainOkiyoshiRepository.saveAndFlush(disneyMainOkiyoshi);
			}
		}
		return null;
	}

	@Override
	public void deleteDisneyOkiyoshiById(final long id) {

		// 更新対象のレコードを取得する
		DisneyMainOkiyoshi disneyMainOkiyoshi = disneyMainOkiyoshiRepository.findOne(id);
		if (disneyMainOkiyoshi != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			disneyMainOkiyoshiRepository.delete(id);
		}
	}

	@Override
	public void deleteDisneyOkiyoshiComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		disneyMainOkiyoshiRepository.deleteComp(ids);
	}
}