package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaInputForm;
import jp.co.futureantiques.webapptraining.model.form.voiceActorKoba.VoiceActorKobaSearchForm;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.AnimeKoba;
/* import jp.co.futureantiques.webapptraining.model.voiceActorKoba.CharacterKoba; */
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.FromKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.OfficeKoba;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceMainKoba;

/**
 * VoiceActorKobaのサービスインターフェース
 *
 * @author future
 */

public interface VoiceActorKobaService {

	/**
	 * 出身地エンティティのリストを取得する
	 *
	 * @return FromEntityのリスト
	 */
	List<FromKoba> getListFrom();

	/**
	 * 事務所エンティティのリストを取得する
	 *
	 * @return OfficeEntityのリスト
	 */
	List<OfficeKoba> getListOffice();

	/**
	 * アニメエンティティのリストを取得する
	 *
	 * @return AnimeEntityのリスト
	 */
	List<AnimeKoba> getListAnime();

	/**
	 * キャラクターエンティティのリストを取得する
	 *
	 * @return CharacterEntityのリスト
	 */
	/* List<CharacterKoba> getListCharacter(); */

	/**
	 * 検索条件をもとにVoiceMainKobaのレコードリストを取得（paging）
	 *
	 * @param VoiceActorKobaSearchForm form
	 * @param pageable pageable
	 * @return VoiceMainKobのリスト
	 */
	Page<VoiceMainKoba> getPageVoiceActor(final VoiceActorKobaSearchForm form, final Pageable pageable);

	/**
	 * 検索条件をもとにVoiceMainKobaのレコードのリストを取得する
	 *
	 * @param VoiceActorKobaSerchForm
	 * @return VoiceMainKoba
	 */
	List<VoiceMainKoba> getListVoiceActor(final VoiceActorKobaSearchForm form);

	/**
	 * IDをキーにVoiceMainKobaのレコードを取得する
	 *
	 * @param long id
	 * @return VoiceMainKobaのレコード
	 */
	VoiceMainKoba getVoiceActor(final long id);

	/**
	 * VoiceMainKobaにレコードを新規登録する
	 *
	 * @param VoiceActorKobaInputForm
	 * @return VoiceMainKoba
	 */
	VoiceMainKoba insertVoiceActor(final VoiceActorKobaInputForm form);

	/**
	 * VoiceMainKobaのレコードを更新する
	 *
	 * @param VoiceActorKobaInputForm form
	 * @return VoiceMainKoba
	 */
	VoiceMainKoba updateVoiceActor(final VoiceActorKobaInputForm form);

	/**
	 * VoiceMainKobaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteVoiceActorById(final long id);

	/**
	 * VoiceMainKobaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteVoiceActorComp(final ArrayList<Long> ids);
}
