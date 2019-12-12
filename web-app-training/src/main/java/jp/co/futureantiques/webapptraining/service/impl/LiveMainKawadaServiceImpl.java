package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.liveMainKawada.LiveMainKawadaInputForm;
import jp.co.futureantiques.webapptraining.model.form.liveMainKawada.LiveMainKawadaSearchForm;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.AlbumKawada;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.LiveMainKawada;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.StyleKawada;
import jp.co.futureantiques.webapptraining.repository.liveMainKawada.AlbumKawadaRepository;
import jp.co.futureantiques.webapptraining.repository.liveMainKawada.LiveMainKawadaRepository;
import jp.co.futureantiques.webapptraining.repository.liveMainKawada.StyleKawadaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.LiveMainKawadaSpecification;
import jp.co.futureantiques.webapptraining.service.LiveMainKawadaService;

/**
 * LiveMainKawadaのサービス実装クラス
 * @author future
 *
 */
@Service
public class LiveMainKawadaServiceImpl implements LiveMainKawadaService {

	//LiveMainKawadaリポジトリ
	private final LiveMainKawadaRepository liveMainKawadaRepository;

	//AlbumKawadaリポジトリ
	private final AlbumKawadaRepository albumKawadaRepository;

	//StyleKawadaリポジトリ
	private final StyleKawadaRepository styleKawadaRepository;

	/** コンストラクタ
	 * @param LiveMainKawadaRepository liveMainKawadaRepository
	 * @param AlbumKawadaRepository albumMainKawadaRepository
	 * @param StyleKawadaRepository styleMainKawadaRepository
	 */
	@Autowired
	public LiveMainKawadaServiceImpl(LiveMainKawadaRepository liveMainKawadaRepository,
			AlbumKawadaRepository albumKawadaRepository, StyleKawadaRepository styleKawadaRepository) {
		this.liveMainKawadaRepository =  liveMainKawadaRepository;
		this.albumKawadaRepository = albumKawadaRepository;
		this.styleKawadaRepository = styleKawadaRepository;
	}

	@Override
	public List<AlbumKawada> getListAlbumKawada() {

		//アルバムテーブルのレコードをID順に取得する
		return albumKawadaRepository.findAll(new Sort(Sort.Direction.ASC, "albumId"));
	}

	@Override
	public List<StyleKawada> getListStyleKawada() {

		//StyleKawadaテーブルのレコードをID順に取得する
		return styleKawadaRepository.findAll(new Sort(Sort.Direction.ASC, "styleId"));
	}

	@Override
	public Page<LiveMainKawada> getPageLive(final LiveMainKawadaSearchForm form, final Pageable pageable) {

		//検索条件を生成しLiveMainKawadaテーブルのレコードを取得する
		return liveMainKawadaRepository.findAll(LiveMainKawadaSpecification.generateLiveSpecification(form), pageable);
	}

	@Override
	public List<LiveMainKawada> getListLive(final LiveMainKawadaSearchForm form) {

		//検索条件を生成し、LiveMainKawadaテーブルのレコードを取得する
		return liveMainKawadaRepository.findAll(LiveMainKawadaSpecification.generateLiveSpecification(form));
	}

	@Override
	public LiveMainKawada getLive(final long id) {

		//LiveMainKawadaテーブルを主キー検索する
		return liveMainKawadaRepository.findOne(id);
	}

	@Override
	public LiveMainKawada insertLive(final LiveMainKawadaInputForm form) {

		//LiveMainKawadaテーブルに新規でデータを登録する
		final LiveMainKawada liveMainKawada = form.convertToLiveMainKawadaForInsert();
		return liveMainKawadaRepository.save(liveMainKawada);
	}

	@Override
	public LiveMainKawada updateLive(final LiveMainKawadaInputForm form) {

		//更新対象のレコードを取得する
		LiveMainKawada liveMainKawada = liveMainKawadaRepository.findOne((long) form.getId());
		if(liveMainKawada != null) {

			//更新対象のレコードが存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(liveMainKawada.getUpdateDate()))) {

				//チェックOKの場合は更新
				liveMainKawada = form .convertToLiveMainKawadaForUpdate(liveMainKawada);
				return liveMainKawadaRepository.saveAndFlush(liveMainKawada);
			}
		}
		return null;
	}

	@Override
	public void deleteLiveMainKawadaById(final long id) {

		//更新対象のレコードを取得する
		LiveMainKawada liveMainKawada = liveMainKawadaRepository.findOne(id);
		if(liveMainKawada != null ) {

			//更新対象のレコードが存在する場合は削除フラグを１にする
			liveMainKawadaRepository.delete(id);
		}

	}

	@Override
	public void deleteLiveMainKawadaComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		liveMainKawadaRepository.deleteComp(ids);
	}

}