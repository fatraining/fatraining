package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.animeNagatake.AnimeMainNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.GenreNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.SourceNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.StudioNagatake;
import jp.co.futureantiques.webapptraining.model.animeNagatake.VoiceactorNagatake;
import jp.co.futureantiques.webapptraining.model.form.animeNagatake.AnimeNagatakeInputForm;
import jp.co.futureantiques.webapptraining.model.form.animeNagatake.AnimeNagatakeSearchForm;
import jp.co.futureantiques.webapptraining.repository.animeNagatake.AnimeMainNagatakeRepository;
import jp.co.futureantiques.webapptraining.repository.animeNagatake.GenreNagatakeRepository;
import jp.co.futureantiques.webapptraining.repository.animeNagatake.SourceNagatakeRepository;
import jp.co.futureantiques.webapptraining.repository.animeNagatake.StudioNagatakeRepository;
import jp.co.futureantiques.webapptraining.repository.animeNagatake.VoiceactorNagatakeRepository;
import jp.co.futureantiques.webapptraining.repository.specification.AnimeNagatakeSpecification;
import jp.co.futureantiques.webapptraining.service.AnimeNagatakeService;

/**
 * AnimeNagatakeのサービス実装クラス
 *
 * @author future
 * */

@Service
public class AnimeNagatakeServiceImpl implements AnimeNagatakeService {

	/** AnimeMainNagatakeのリポジトリ */
	private final AnimeMainNagatakeRepository animeMainNagatakeRepository;

	/** GenreNagatakeのリポジトリ */
	private final GenreNagatakeRepository genreNagatakeRepository;

	/** StudioNgatakeのリポジトリ */
	private final StudioNagatakeRepository studioNagatakeRepository;

	/** VoiceactorNagatakeのリポジトリ */
	private final VoiceactorNagatakeRepository voiceactorNagatakeRepository;

	/** Sourcenagatakeのリポジトリ */
	private final SourceNagatakeRepository sourceNagatakeRepository;

	/**
	 * コンストラクタ
	 *
	 * @param AnimeMainNagatakeRepository animeMainNagatakeRepository
	 * @param GenreRepository genreRepository
	 * @param StudioRepository studioRepository
	 * @param VoiceactorRepository voiceactorRepository
	 * @param SourceRepository sourceRepository
	 *
	 * */
	@Autowired
	public AnimeNagatakeServiceImpl(
			AnimeMainNagatakeRepository animeMainNagatakeRepository,
			GenreNagatakeRepository genreNagatakeRepository,
			StudioNagatakeRepository studioNagatakeRepository,
			VoiceactorNagatakeRepository voiceactorNagatakeRepository,
			SourceNagatakeRepository sourceNagatakeRepository) {

		this.animeMainNagatakeRepository = animeMainNagatakeRepository;
		this.genreNagatakeRepository = genreNagatakeRepository;
		this.studioNagatakeRepository = studioNagatakeRepository;
		this.voiceactorNagatakeRepository = voiceactorNagatakeRepository;
		this.sourceNagatakeRepository = sourceNagatakeRepository;
	}

	@Override
	public List<GenreNagatake> getListGenre() {

		//GenreテーブルのレコードをID順に取得する
		return genreNagatakeRepository.findAll(new Sort(Sort.Direction.ASC, "genreId"));
	}

	@Override
	public List<StudioNagatake> getListStudio() {

		//StudioテーブルのレコードをID順に取得する
		return studioNagatakeRepository.findAll(new Sort(Sort.Direction.ASC, "studioId"));
	}

	@Override
	public List<VoiceactorNagatake> getListVoiceactor() {

		//VoiceactorテーブルのレコードをID順に取得する
		return voiceactorNagatakeRepository.findAll(new Sort(Sort.Direction.ASC, "voiceactorId"));
	}

	@Override
	public List<SourceNagatake> getListSource() {

		//SourceテーブルのレコードをID順に取得する
		return sourceNagatakeRepository.findAll(new Sort(Sort.Direction.ASC, "sourceId"));
	}

	@Override
	public Page<AnimeMainNagatake> getPageAnime(final AnimeNagatakeSearchForm form, final Pageable pageable) {

		//検索条件を生成しAnimeMainNagatakeテーブルを取得する
		return animeMainNagatakeRepository.findAll(AnimeNagatakeSpecification.generateAnimeSpecification(form), pageable);
	}

	@Override
	public List<AnimeMainNagatake> getListAnime(final AnimeNagatakeSearchForm form) {

		//検索条件を生成しAnimeMainNagatakeテーブルを取得する
		return animeMainNagatakeRepository.findAll(AnimeNagatakeSpecification.generateAnimeSpecification(form));
	}

	@Override
	public AnimeMainNagatake getAnime(final long id) {

		//AnimeMainNagatakeテーブルを主キー検索する
		return animeMainNagatakeRepository.findOne(id);
	}

	@Override
	public AnimeMainNagatake insertAnime(final AnimeNagatakeInputForm form) {

		//AnimeMainNagatakeテーブルに新規でデータを登録する
		final AnimeMainNagatake animeMainNagatake = form.convertToAnimeMainNagatakeForInsert();
		return animeMainNagatakeRepository.save(animeMainNagatake);
	}

	@Override
	public AnimeMainNagatake updateAnime(final AnimeNagatakeInputForm form) {

		//更新対象のレコードを取得する
		AnimeMainNagatake animeMainNagatake = animeMainNagatakeRepository.findOne((long) form.getId());
		if (animeMainNagatake != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(animeMainNagatake.getUpdateDate()))) {

				//チェックOKの場合更新
				animeMainNagatake = form.convertToAnimeMainNagatakeForUpdate(animeMainNagatake);
				return animeMainNagatakeRepository.saveAndFlush(animeMainNagatake);
			}
		}
		return null;
	}

	@Override
	public void deleteAnimeById(final long id) {

		//更新対象のレコードを取得する
		AnimeMainNagatake animeMainNagatake = animeMainNagatakeRepository.findOne(id);
		if (animeMainNagatake != null) {

			//更新対象のレコードが存在する場合削除フラグを1にする
			animeMainNagatakeRepository.delete(id);
		}
	}

	@Override
	public void deleteAnimeComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		animeMainNagatakeRepository.deleteComp(ids);
	}
}