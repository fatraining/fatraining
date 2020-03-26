package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaOperateForm;
import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaSearchForm;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.AnimeKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.CharacterKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.FromKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.OfficeKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceActorMainKoba;

public interface VoiceActorKobaService {

	List<FromKoba> listFromKoba();

	List<OfficeKoba> listOfficeKoba();

	List<AnimeKoba> listAnimeKoba();

	List<CharacterKoba> listCharacterKoba();

	List<VoiceActorMainKoba> listVoiceActorMainKoba(VoiceActorKobaSearchForm form);

	void deleteVoiceActorKobaById(Long id);

	VoiceActorMainKoba updateVoiceActorKoba(VoiceActorKobaOperateForm form);

	VoiceActorMainKoba insertVoiceActorKoba(VoiceActorKobaOperateForm form);

	VoiceActorMainKoba getVoiceActorMainKoba(Long id);

	VoiceActorMainKoba updateVoiceActorMainKoba(VoiceActorKobaOperateForm form);

	List<CharacterKoba> listCharacterKoba(VoiceActorKobaSearchForm form);

	List<AnimeKoba> listAnimeKoba(VoiceActorKobaSearchForm form);

	VoiceActorMainKoba getAnimeKoba(Integer animeId);

}
