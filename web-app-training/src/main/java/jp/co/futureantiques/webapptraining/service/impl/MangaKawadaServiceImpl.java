package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.mangaKawada.MangaKawadaInputForm;
//import jp.co.futureantiques.webapptraining.model.form.mangaKawada.MangaKawadaInputForm;
import jp.co.futureantiques.webapptraining.model.form.mangaKawada.MangaKawadaSearchForm;
import jp.co.futureantiques.webapptraining.model.mangaKawada.AnimeKawada;
import jp.co.futureantiques.webapptraining.model.mangaKawada.GenreKawada;
import jp.co.futureantiques.webapptraining.model.mangaKawada.MangaMainKawada;
import jp.co.futureantiques.webapptraining.model.mangaKawada.SituationKawada;
import jp.co.futureantiques.webapptraining.repository.mangaKawada.AnimeKawadaRepository;
import jp.co.futureantiques.webapptraining.repository.mangaKawada.GenreKawadaRepository;
import jp.co.futureantiques.webapptraining.repository.mangaKawada.MangaMainKawadaRepository;
import jp.co.futureantiques.webapptraining.repository.mangaKawada.SituationKawadaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.MangaKawadaSpecification;
import jp.co.futureantiques.webapptraining.service.MangaKawadaService;

/**
 * MangaKawadaのサービス実装クラス
 *
 * @author Kawada
 */
@Service
public class MangaKawadaServiceImpl implements MangaKawadaService {

	/** MangaMainKawadaリポジトリ */
	private final MangaMainKawadaRepository mangaMainKawadaRepository;

	/** GenreKawadaリポジトリ */
	private final GenreKawadaRepository genreKawadaRepository;

	/** AnimeKawadaリポジトリ */
	private final AnimeKawadaRepository animeKawadaRepository;

	/** SituationKawadaリポジトリ */
	private final SituationKawadaRepository situationKawadaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param MangaMainKawadaRepository mangaMainKawadaRepository
	 * @param GenreKawadaRepository genreKawadaRepository
	 * @param AnimeKawadaRepository animeKawadaRepository
	 * @param SituationKawadaRepository situationKawadaRepository
	 */
	@Autowired
	public MangaKawadaServiceImpl(MangaMainKawadaRepository mangaMainKawadaRepository,
			GenreKawadaRepository genreKawadaRepository,
			AnimeKawadaRepository animeKawadaRepository, SituationKawadaRepository situationKawadaRepository) {
		this.mangaMainKawadaRepository = mangaMainKawadaRepository;
		this.genreKawadaRepository = genreKawadaRepository;
		this.animeKawadaRepository = animeKawadaRepository;
		this.situationKawadaRepository = situationKawadaRepository;
	}

	@Override
	public List<GenreKawada> getListGenreKawada() {

		// GenreKawadaテーブルのレコードをID順に取得する
		return genreKawadaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<AnimeKawada> getListAnimeKawada() {

		// AnimeKawadaテーブルのレコードをID順に取得する
		return animeKawadaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<SituationKawada> getListSituationKawada() {

		// SituationKawadaテーブルのレコードをID順に取得する
		return situationKawadaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<MangaMainKawada> getPageManga(final MangaKawadaSearchForm form, final Pageable pageable) {

		// 検索条件を生成しMangaMainKawadaテーブルのレコードを取得する
		return mangaMainKawadaRepository.findAll(MangaKawadaSpecification.generateMangaKawadaSpecification(form),
				pageable);
	}

	@Override
	public List<MangaMainKawada> getListMangaMainKawada(final MangaKawadaSearchForm form) {

		// 検索条件を生成しMangaMainKawadaテーブルのレコードを取得する
		return mangaMainKawadaRepository.findAll(MangaKawadaSpecification.generateMangaKawadaSpecification(form));
	}

	@Override
	public MangaMainKawada getManga(final long id) {

		// MangaMainKawadaテーブルを主キー検索する
		return mangaMainKawadaRepository.findOne(id);
	}

	@Override
	public MangaMainKawada insertManga(final MangaKawadaInputForm form) {

		//MangaMainKawadaテーブルに新規でデータを登録する
		final MangaMainKawada mangaMainKawada = form.convertToMangaMainKawadaForInsert();
		return mangaMainKawadaRepository.save(mangaMainKawada);
	}

	@Override
	public MangaMainKawada updateManga(final MangaKawadaInputForm form) {

		//更新対象のレコードを取得する
		MangaMainKawada mangaMainKawada = mangaMainKawadaRepository.findOne((long) form.getId());
		if (mangaMainKawada != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(mangaMainKawada.getUpdateDate()))) {

				// チェックOKの場合、更新
				mangaMainKawada = form.convertToMangaMainKawadaForUpdate(mangaMainKawada);
				return mangaMainKawadaRepository.saveAndFlush(mangaMainKawada);
			}
		}
		return null;
	}

	@Override
	public void deleteMangaKawadaById(final long id) {

		//更新対象のレコードを取得する
		MangaMainKawada mangaMainKawada = mangaMainKawadaRepository.findOne(id);
		if (mangaMainKawada != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			mangaMainKawadaRepository.delete(id);
		}
	}

	@Override
	public void deleteMangaKawadaComp(final ArrayList<Long> ids) {
		// 対象のレコードを削除する
		mangaMainKawadaRepository.deleteComp(ids);
	}
}