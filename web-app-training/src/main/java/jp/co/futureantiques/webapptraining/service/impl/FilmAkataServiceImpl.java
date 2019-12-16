package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.filmAkata.FilmActorAkata;
import jp.co.futureantiques.webapptraining.model.filmAkata.FilmGenreAkata;
import jp.co.futureantiques.webapptraining.model.filmAkata.FilmMainAkata;
import jp.co.futureantiques.webapptraining.model.form.filmAkata.FilmAkataInputForm;
import jp.co.futureantiques.webapptraining.model.form.filmAkata.FilmAkataSearchForm;
import jp.co.futureantiques.webapptraining.repository.filmAkata.FilmActorAkataRepository;
import jp.co.futureantiques.webapptraining.repository.filmAkata.FilmGenreAkataRepository;
import jp.co.futureantiques.webapptraining.repository.filmAkata.FilmMainAkataRepository;
import jp.co.futureantiques.webapptraining.repository.specification.FilmAkataSpecification;
import jp.co.futureantiques.webapptraining.service.FilmAkataService;

/**
 * FilmAkataのサービス実装クラス
 *
 * @author future
 */
@Service
public class FilmAkataServiceImpl implements FilmAkataService {

	/** FilmMainAkataリポジトリ */
	private final FilmMainAkataRepository filmMainAkataRepository;

	/** FilmGenreAkataリポジトリ */
	private final FilmGenreAkataRepository filmGenreAkataRepository;

	/** FilmActorAkataリポジトリ */
	private final FilmActorAkataRepository filmActorAkataRepository;

	/**
	 * コンストラクタ
	 *
	 * @param FilmMainAkataRepository filmMainAkataRepository
	 * @param FilmGenreAkataRepository filmGenreAkataRepository
	 * @param FilmActorAkataRepository filmActorRepository
	 */
	@Autowired
	public FilmAkataServiceImpl(FilmMainAkataRepository filmMainAkataRepository, FilmGenreAkataRepository filmGenreAkataRepository,
			FilmActorAkataRepository filmActorAkataRepository) {
		this.filmMainAkataRepository = filmMainAkataRepository;
		this.filmGenreAkataRepository = filmGenreAkataRepository;
		this.filmActorAkataRepository = filmActorAkataRepository;
	}
	@Override
	public List<FilmGenreAkata> getListFilmGenreAkata() {

		//FilmGenreAkataテーブルのレコードをID順に取得する
		return filmGenreAkataRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}
	@Override
	public List<FilmActorAkata> getListFilmActorAkata() {

		//FilmActorAkataテーブルのレコードをID側に取得する
		return filmActorAkataRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public Page<FilmMainAkata> getPageFilm(final FilmAkataSearchForm form, final Pageable pageable) {

		//検索条件を生成しFilmMainAkataテーブルのレコードを取得する
		return filmMainAkataRepository.findAll(FilmAkataSpecification.generateFilmSpecification(form), pageable);
	}

	@Override
	public List<FilmMainAkata> getListFilm(final FilmAkataSearchForm form) {

		//検索条件を生成しFilmMainAkataテーブルのレコードを取得する
		return filmMainAkataRepository.findAll(FilmAkataSpecification.generateFilmSpecification(form));
	}

	@Override
	public FilmMainAkata getFilm(final long id) {

		//FilmMainAkataテーブルを主キー検索する
		return filmMainAkataRepository.findOne(id);
	}

	@Override
	public FilmMainAkata insertFilm(final FilmAkataInputForm form) {

		//FilmMainAkataテーブルに新規でデータを登録する
		final FilmMainAkata filmMainAkata = form.convertToFilmMainAkataForInsert();
		return filmMainAkataRepository.save(filmMainAkata);
	}

	@Override
	public FilmMainAkata updateFilm(final FilmAkataInputForm form) {

		//更新対象のレコードを取得する
		FilmMainAkata filmMainAkata = filmMainAkataRepository.findOne((long) form.getId());
		if (filmMainAkata != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(filmMainAkata.getUpdateDate()))) {

				//チェックOKの場合、更新
				filmMainAkata = form.convertToFilmMainAkataForUpdate(filmMainAkata);
				return filmMainAkataRepository.saveAndFlush(filmMainAkata);
			}
		}
		return null;
	}

	@Override
	public void deleteFilmById(final long id) {

		//更新対象のレコードを取得する
		FilmMainAkata filmMainAkata = filmMainAkataRepository.findOne(id);
		if (filmMainAkata != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			filmMainAkataRepository.delete(id);
		}
	}
	@Override
	public void deleteFilmComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		filmMainAkataRepository.deleteComp(ids);
	}
}
