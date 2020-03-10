package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaInputForm;
import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaSearchForm;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.AnimeKoba;
/* import jp.co.futureantiques.webapptraining.model.voiceActorKoba.CharacterKoba; */
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.FromKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.OfficeKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceMainKoba;
import jp.co.futureantiques.webapptraining.repository.specification.VoiceActorKobaSpecification;
import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.AnimeKobaRepository;
/* import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.CharacterKobaRepository; */
import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.FromKobaRepository;
import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.OfficeKobaRepository;
import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.VoiceMainKobaRepository;
import jp.co.futureantiques.webapptraining.service.VoiceActorKobaService;

/**
 * VoiceActorKobaのサービス実装クラス
 *
 */

@Service
public class VoiceActorKobaServiceImpl implements VoiceActorKobaService {

	/** VoiceMainKobaリポジトリ */
	private final VoiceMainKobaRepository voiceMainKobaRepository;

	/** FromKobaリポジトリ */
	private final FromKobaRepository fromKobaRepository;

	/** OfficeKobaリポジトリ */
	private final OfficeKobaRepository officeKobaRepository;

	/** AnimeKobaリポジトリ */
	private final AnimeKobaRepository animeKobaRepository;

	/** CharacterKobaリポジトリ */
	/* private final CharacterKobaRepository characterKobaRepository; */

	/**
	 * コンストラクタ
	 *
	 * @param VoiceMainKobaRepository voiceMainKobaRepository
	 * @param FromKobaRepository fromKobaRepository
	 * @param OfficeKobaRepository officeKobaRepository
	 * @param AnimeKobaRepository animeKobaRepository
	 * @param CharacterKobaRepository characterKobaRepository
	*/
	@Autowired
	public VoiceActorKobaServiceImpl(
			VoiceMainKobaRepository voiceMainKobaRepository,
			FromKobaRepository fromKobaRepository,
			OfficeKobaRepository officeKobaRepository,
			AnimeKobaRepository animeKobaRepository
			/* CharacterKobaRepository characterKobaRepository */ ) {

		this.voiceMainKobaRepository = voiceMainKobaRepository;
		this.fromKobaRepository = fromKobaRepository;
		this.officeKobaRepository = officeKobaRepository;
		this.animeKobaRepository = animeKobaRepository;
		/* this.characterKobaRepository = characterKobaRepository; */
	}

	@Override
	public List<FromKoba> getListFrom() {
		// fromテーブルのレコードをID順に取得する
		return fromKobaRepository.findAll(new Sort(Sort.Direction.ASC,"fromId"));
	}

	@Override
	public List<OfficeKoba> getListOffice() {
		// officeテーブルのレコードをID順に取得する
		return officeKobaRepository.findAll(new Sort(Sort.Direction.ASC,"officeId"));
	}

	@Override
	public List<AnimeKoba> getListAnime() {
		// animeテーブルのレコードをID順に取得する
		return animeKobaRepository.findAll(new Sort(Sort.Direction.ASC,"animeId"));
	}

	/** @Override
	public List<CharacterKoba> getListCharacter() {
		// character_kobaテーブルのレコードをID順に取得する
		return characterKobaRepository.findAll(new Sort(Sort.Direction.ASC,"characterId"));
	} */

	@Override
	public Page<VoiceMainKoba> getPageVoiceActor(final VoiceActorKobaSearchForm form,final Pageable pageable){
		// 検索条件を生成しVoiceMainKobaテーブルのレコードを取得する
		return voiceMainKobaRepository.findAll(VoiceActorKobaSpecification.generateVoiceActorSpecification(form),pageable);
	}

	@Override
	public List<VoiceMainKoba> getListVoiceActor(final VoiceActorKobaSearchForm form){
		// 検索条件を生成しVoiceMainKobaテーブルのレコードを取得する
		return voiceMainKobaRepository.findAll(VoiceActorKobaSpecification.generateVoiceActorSpecification(form));
	}

	@Override
	public VoiceMainKoba getVoiceActor(final long id) {
		// VoiceMainKobaテーブルを主キー検索する
		return voiceMainKobaRepository.findOne(id);
	}

	@Override
	public VoiceMainKoba insertVoiceActor(final VoiceActorKobaInputForm form) {
		// VoiceMainKobaテーブルに新規でデータを登録する
		final VoiceMainKoba voiceMainKoba = form.convertToVoiceMainKobaForInsert();
		return voiceMainKobaRepository.save(voiceMainKoba);
	}

	@Override
	public VoiceMainKoba updateVoiceActor(final VoiceActorKobaInputForm form) {

		// 更新対象のレコードを取得する
		VoiceMainKoba voiceMainKoba = voiceMainKobaRepository.findOne((long)form.getId());
		if(voiceMainKoba != null) {

			// 更新対象のレコードを存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(voiceMainKoba.getUpdateDate()))) {

				// チェックOKの場合、更新
				voiceMainKoba = form.convertToVoiceMainKobaForUpdate(voiceMainKoba);
				return voiceMainKobaRepository.saveAndFlush(voiceMainKoba);
			}
		}
		return null;
	}

	@Override
	public void deleteVoiceActorById(final long id) {

		// 更新対象のレコードを取得する
		VoiceMainKoba voiceMainKoba = voiceMainKobaRepository.findOne(id);
		if(voiceMainKoba != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			voiceMainKobaRepository.delete(id);
		}
	}
	@Override
	public void deleteVoiceActorComp(final ArrayList<Long> ids) {
		// 対象のレコードを削除する
		voiceMainKobaRepository.deleteComp(ids);
	}

}
