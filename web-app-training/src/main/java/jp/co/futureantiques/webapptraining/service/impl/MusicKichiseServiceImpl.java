package jp.co.futureantiques.webapptraining.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.musickichise.MusicKichiseSearchForm;
import jp.co.futureantiques.webapptraining.model.musickichise.Artist;
import jp.co.futureantiques.webapptraining.model.musickichise.Janru;
import jp.co.futureantiques.webapptraining.model.musickichise.MusicKichiseMain;
import jp.co.futureantiques.webapptraining.repository.musickichise.ArtistRepository;
import jp.co.futureantiques.webapptraining.repository.musickichise.JanruRepository;
import jp.co.futureantiques.webapptraining.repository.musickichise.MusicKichiseMainRepository;
import jp.co.futureantiques.webapptraining.repository.specification.MusicKichiseSpecification;
import jp.co.futureantiques.webapptraining.service.MusicKichiseService;

/**
 * MusicKichiseServiceの実装クラス
 * @author future
 *
 */
@Service
public class MusicKichiseServiceImpl implements MusicKichiseService {

	/** MusicKichiseMainリポジトリ */
	private final MusicKichiseMainRepository musicKichiseMainRepository;
	/** Artistリポジトリ */
	private final ArtistRepository artistRepository;
	/** Janruリポジトリ */
	private final JanruRepository janruRepository;

	/**
	 * Repositoryのコンストラクタ
	 * @param musicKichiseMainRepository
	 * @param janruRepository
	 * @param artistRepository
	 */
	@Autowired
	public MusicKichiseServiceImpl(MusicKichiseMainRepository musicKichiseMainRepository,
			JanruRepository janruRepository, ArtistRepository artistRepository) {
		this.musicKichiseMainRepository = musicKichiseMainRepository;
		this.janruRepository = janruRepository;
		this.artistRepository = artistRepository;
	}

	//ArtistテーブルのレコードをID順に取得する
	@Override
	public List<Artist> getListArtist() {
		return artistRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//JanruテーブルのレコードをID順に取得する
	@Override
	public List<Janru> getListJanru() {
		return janruRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	//検索条件を生成し、MusicKichiseMainテーブルのレコードを取得する
	@Override
	public Page<MusicKichiseMain> getPageMusic(final MusicKichiseSearchForm form, final Pageable pageable) {
		return musicKichiseMainRepository.findAll(MusicKichiseSpecification.generateMusicSpecification(form), pageable);
	}

	//検索条件を生成しMusicKichiseMainテーブルのレコードを取得する
	@Override
	public List<MusicKichiseMain> getListMusic(final MusicKichiseSearchForm form) {
		return musicKichiseMainRepository.findAll(MusicKichiseSpecification.generateMusicSpecification(form));
	}

	//MusicKichiseMainテーブルを主キー検索する
	@Override
	public MusicKichiseMain getMusic(final long id) {
		return musicKichiseMainRepository.findOne(id);
	}
}
