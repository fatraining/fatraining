package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.musicKaji.MusicKajiInputForm;
import jp.co.futureantiques.webapptraining.model.form.musicKaji.MusicKajiSearchForm;
import jp.co.futureantiques.webapptraining.model.musicKaji.ComposerKaji;
import jp.co.futureantiques.webapptraining.model.musicKaji.MusicMainKaji;
import jp.co.futureantiques.webapptraining.model.musicKaji.UnitKaji;
import jp.co.futureantiques.webapptraining.repository.musicKaji.ComposerKajiRepository;
import jp.co.futureantiques.webapptraining.repository.musicKaji.MusicMainKajiRepository;
import jp.co.futureantiques.webapptraining.repository.musicKaji.UnitKajiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.MusicKajiSpecification;
import jp.co.futureantiques.webapptraining.service.MusicKajiService;

/**
 * MusicKajiのサービス実装クラス
 * @author futute
 *
 */
@Service
public class MusicKajiServiceImpl implements MusicKajiService{

	/** MusicMainKajiリポジトリ */
	private final MusicMainKajiRepository musicMainKajiRepository;

	/** UnitKajiリポジトリ */
	private final UnitKajiRepository unitKajiRepository;

	/** ComposerKajiリポジトリ */
	private final ComposerKajiRepository composerKajiRepository;

	/**
	 * コントラクタ
	 *
	 * @param MusicMainKajiRepository musicMainKajiRepository
	 * @param UnitKajiRepository unitKajiRepository
	 * @param ComposerKajiRepository composerKajiRepository
	 */
	@Autowired
	public MusicKajiServiceImpl(MusicMainKajiRepository musicMainKajiRepository,
			UnitKajiRepository unitKajiRepository,
			ComposerKajiRepository composerKajiRepository) {
		this.musicMainKajiRepository = musicMainKajiRepository;
		this.unitKajiRepository = unitKajiRepository;
		this.composerKajiRepository = composerKajiRepository;
	}

	@Override
	public List<UnitKaji> getListUnitKaji(){

		//UnitKajiテーブルのレコードをID順に取得する
		return unitKajiRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public List<ComposerKaji> getListComposerKaji(){

		//ComposerKajiテーブルのレコードをID順に取得する
		return composerKajiRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public Page<MusicMainKaji> getPageMusicMainKaji(final MusicKajiSearchForm form, final Pageable pageable){

		//検索条件を生成しMusicMainKajiテーブルを取得する
		return musicMainKajiRepository.findAll(MusicKajiSpecification.generateMusicKajiSpecification(form), pageable);
	}

	@Override
	public List<MusicMainKaji> getListMusicMainKaji(final MusicKajiSearchForm form){

		//検索条件を生成しMusicMainKajiテーブルのレコードを取得する
		return musicMainKajiRepository.findAll(MusicKajiSpecification.generateMusicKajiSpecification(form));
	}

	@Override
	public MusicMainKaji getMusic(final long id) {

		//MusicMainKajiテーブルの主キー検索する
		return musicMainKajiRepository.findOne(id);
	}

	@Override
	public MusicMainKaji insertMusic(MusicKajiInputForm form) {

		//MusicMainKajiテーブルに新規でデータを登録する
		final MusicMainKaji musicMainKaji = form.convertToMusicMainKajiForInsert();
		return musicMainKajiRepository.save(musicMainKaji);
	}

	@Override
	public MusicMainKaji updateMusic(MusicKajiInputForm form) {

		//更新対象のレコードを取得する
		MusicMainKaji musicMainKaji = musicMainKajiRepository.findOne((long) form.getId());
		if(musicMainKaji != null) {

			//更新対象のレコードが存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(musicMainKaji.getUpdateDate()))) {

				// チェックOKの場合、更新
				musicMainKaji = form.convertToMusicMainKajiForUpdate(musicMainKaji);
				return musicMainKajiRepository.saveAndFlush(musicMainKaji);
			}
		}
		return null;
	}

	@Override
	public void deleteMusicById(final long id) {

		//更新対象のレコードを取得する
		MusicMainKaji musicMainKaji = musicMainKajiRepository.findOne(id);
		if(musicMainKaji != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			musicMainKajiRepository.delete(id);
		}
	}

	@Override
	public void deleteMusicComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		musicMainKajiRepository.deleteComp(ids);
	}

}
