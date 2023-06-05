package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.musicKaji.MusicKajiInputForm;
import jp.co.futureantiques.webapptraining.model.form.musicKaji.MusicKajiSearchForm;
import jp.co.futureantiques.webapptraining.model.musicKaji.ComposerKaji;
import jp.co.futureantiques.webapptraining.model.musicKaji.MusicMainKaji;
import jp.co.futureantiques.webapptraining.model.musicKaji.UnitKaji;

/**
 * MusicKajiのサービスインターフェース
 * @author futute
 *
 */
public interface MusicKajiService {

	/**
	 * ユニットエンティティのリストを取得する
	 *
	 * @return UnitKajiEntityのリスト
	 */
	List<UnitKaji> getListUnitKaji();

	/**
	 * 作曲者エンティティのリストを取得する
	 *
	 * @return ComposerKajiEntityのリスト
	 */
	List<ComposerKaji> getListComposerKaji();

	/**
	 * 検索条件を元にMusicMainKajiのレコードのリストを取得する(Paging)
	 *
	 * @param MusicKajiSearchForm form
	 * @param Pageable pageable
	 * @return MusicMainKajiのリスト
	 */
	Page<MusicMainKaji> getPageMusicMainKaji(final MusicKajiSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にMusicMainKajiのレコードのリストを取得する
	 *
	 * @param MusicKajiSearchForm form
	 * @return MusicMainKajiのリスト
	 */
	List<MusicMainKaji> getListMusicMainKaji(final MusicKajiSearchForm form);

	/**
	 * IDをキーにMusicMainKajiのレコードを取得する
	 *
	 * @param long id
	 * @return MusicMainKajiのレコード
	 */
	MusicMainKaji getMusic(final long id);

	/**
	 * MusicMainKajiにレコードを新規登録する
	 *
	 * @param MusicKajiInputForm form
	 * @return MusicMainKaji
	 */
	MusicMainKaji insertMusic(final MusicKajiInputForm form);

	/**
	 * MusicMainKajiのレコードを更新する
	 *
	 * @param MusicKajiInputForm form
	 * @return MusicMainKaji
	 */
	MusicMainKaji updateMusic(final MusicKajiInputForm form);

	/**
	 * MusicMainKajiのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteMusicById(final long id);

	/**
	 * MusicMainKajiのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteMusicComp(final ArrayList<Long> ids);

}
