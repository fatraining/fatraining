package jp.co.futureantiques.webapptraining.service.impl;

import java.util.List;

/**
 * import org.springframework.data.domain.Page;
 * import org.springframework.data.domain.Pageable; */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaOperateForm;
import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaSearchForm;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.AnimeKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.CharacterKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.FromKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.OfficeKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceActorMainKoba;
import jp.co.futureantiques.webapptraining.repository.specification.VoiceActorKobaSpecification;
import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.AnimeKobaRepository;
import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.CharacterKobaRepository;
import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.FromKobaRepository;
import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.OfficeKobaRepository;
import jp.co.futureantiques.webapptraining.repository.voiceActorKoba.VoiceActorMainKobaRepository;
import jp.co.futureantiques.webapptraining.service.VoiceActorKobaService;

/**
 * VoiceActorKobaのサービス実装クラス
 *
 */

@Service
public class VoiceActorKobaServiceImpl implements VoiceActorKobaService {

	/** VoiceMainKobaリポジトリ */
	private final VoiceActorMainKobaRepository voiceActorMainKobaRepository;

	/** FromKobaリポジトリ */
	private final FromKobaRepository fromKobaRepository;

	/** OfficeKobaリポジトリ */
	private final OfficeKobaRepository officeKobaRepository;

	/** AnimeKobaリポジトリ */
	private final AnimeKobaRepository animeKobaRepository;

	/** CharacterKobaリポジトリ */
	private final CharacterKobaRepository characterKobaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param VoiceMainKobaRepository voiceMainKobaRepository
	 * @param FromKobaRepository fromKobaRepository
	 * @param OfficeKobaRepository officeKobaRepository
	 * @param AnimeKobaRepository animeKobaRepository
	 * @param CharacterKobaRepository characterKobaRepository
	 * @param CharacterKobaPKRepository characterKobaPKRepository
	*/
	@Autowired
	public VoiceActorKobaServiceImpl(
			VoiceActorMainKobaRepository voiceActorMainKobaRepository,
			FromKobaRepository fromKobaRepository,
			OfficeKobaRepository officeKobaRepository,
			AnimeKobaRepository animeKobaRepository,
			CharacterKobaRepository characterKobaRepository) {

		this.voiceActorMainKobaRepository = voiceActorMainKobaRepository;
		this.fromKobaRepository = fromKobaRepository;
		this.officeKobaRepository = officeKobaRepository;
		this.animeKobaRepository = animeKobaRepository;
		this.characterKobaRepository = characterKobaRepository;
	}

	@Override
	public VoiceActorMainKoba insertVoiceActorKoba(VoiceActorKobaOperateForm form) {
		final VoiceActorMainKoba voiceActorMainKoba = form.convertToVoiceActorMainKoba();
		return voiceActorMainKobaRepository.save(voiceActorMainKoba);
	}

	@Override
	public List<FromKoba> listFromKoba() {
		// fromテーブルのレコードをID順に取得する
		return fromKobaRepository.findAll(new Sort(Sort.Direction.ASC,"fromId"));
	}

	@Override
	public List<OfficeKoba> listOfficeKoba() {
		// officeテーブルのレコードをID順に取得する
		return officeKobaRepository.findAll(new Sort(Sort.Direction.ASC,"officeId"));
	}

	@Override
	public List<AnimeKoba> listAnimeKoba() {
		// animeテーブルのレコードをID順に取得する
		return animeKobaRepository.findAll(new Sort(Sort.Direction.ASC,"animeId"));
	}

	@Override
	public VoiceActorMainKoba getAnimeKoba(Integer animeId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<CharacterKoba> listCharacterKoba() {
		// character_kobaテーブルのレコードをID順に取得する
		return characterKobaRepository.findAll(new Sort(Sort.Direction.ASC,"id","animeId"));
	}

	@Override
	public List<VoiceActorMainKoba> listVoiceActorMainKoba(VoiceActorKobaSearchForm form){
		// 検索条件を生成しVoiceMainKobaテーブルのレコードを取得する
		return voiceActorMainKobaRepository.findAll(VoiceActorKobaSpecification.generateVoiceActorKobaSpecification(form));
	}

	@Override
	public List<CharacterKoba> listCharacterKoba(VoiceActorKobaSearchForm form){
		// 検索条件を生成しVoiceMainKobaテーブルのレコードを取得する
		return characterKobaRepository.findAll();
	}

	@Override
	public List<AnimeKoba> listAnimeKoba(VoiceActorKobaSearchForm form){
		// 検索条件を生成しVoiceMainKobaテーブルのレコードを取得する
		return animeKobaRepository.findAll();
	}

	@Override
	public VoiceActorMainKoba getVoiceActorMainKoba(Long id) {
		// VoiceActorMainKobaテーブルを主キー検索する
		return voiceActorMainKobaRepository.findOne(id);
	}

	@Override
	public VoiceActorMainKoba updateVoiceActorMainKoba(VoiceActorKobaOperateForm form) {
		// 更新対象のレコードを取得する
		VoiceActorMainKoba voiceActorMainKoba = voiceActorMainKobaRepository.findOne(form.getId());
		if(voiceActorMainKoba != null) {
			// 更新対象のレコードを存在する場合排他チェック
			updateVoiceActorMainKoba(form, voiceActorMainKoba);
		}
		return null;
	}

    private void updateVoiceActorMainKoba(VoiceActorKobaOperateForm form, VoiceActorMainKoba voiceActorMainKoba) {
        voiceActorMainKoba.setActorName(form.getActorName());
        voiceActorMainKoba.setImage(form.getImage());
        voiceActorMainKoba.setBirthday(form.getBirthday());
        voiceActorMainKoba.setFromId(form.getFromId());
        voiceActorMainKoba.setOfficeId(form.getOfficeId());
        // voiceActorMainKoba.setAnimeTitle(form.getAnimeTitle());
        voiceActorMainKoba.setAnimeId(form.getAnimeId());
        // voiceActorMainKoba.setCharacterId(form.getCharacterId());
        voiceActorMainKoba.setCharacterName(form.getCharacterName());
        voiceActorMainKoba.setComment(form.getComment());
    }

	@Override
	public void deleteVoiceActorKobaById(Long id) {
		// 更新対象のレコードが存在する場合、削除フラグを1にする
		voiceActorMainKobaRepository.delete(id);
	}

	@Override
	public VoiceActorMainKoba updateVoiceActorKoba(VoiceActorKobaOperateForm form) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
