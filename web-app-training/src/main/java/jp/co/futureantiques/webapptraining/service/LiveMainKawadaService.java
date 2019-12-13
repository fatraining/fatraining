package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.liveMainKawada.LiveMainKawadaInputForm;
import jp.co.futureantiques.webapptraining.model.form.liveMainKawada.LiveMainKawadaSearchForm;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.AlbumKawada;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.LiveMainKawada;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.StyleKawada;

/**
 * LiveMainKawadaのサービスインターフェース
 * @author future
 *
 */
public interface LiveMainKawadaService {

	/**
	 * アルバムエンティティのリストを取得する
	 *
	 * @return AlbumEntityのリスト
	 */
	List<AlbumKawada> getListAlbumKawada();

	/**
	 * スタイルエンティティのリストを取得する
	 *
	 * @return StyleEntityのリスト
	 */
	List<StyleKawada> getListStyleKawada();

	/**
	 * 検索条件を元にLiveMainKawadaのレコードのリストを取得する（paging)
	 *
	 * @param LiveMainKawadaSearchForm form
	 * @parm Pageable pageable
	 * @return LiveMainKawadaのリスト
	 */
	Page<LiveMainKawada> getPageLive(final LiveMainKawadaSearchForm form,final Pageable pageable);

	/**
	 * 検索条件を元にLiveMainKawadaのレコードのリストを取得する
	 *
	 * @param LiveMainKawadaSearchForm form
	 * @return LiveMainKawadaのリスト
	 */
	List<LiveMainKawada> getListLive(final LiveMainKawadaSearchForm form);

	/**
	 * IDをキーにLiveMainKawadaのレコードを取得する
	 *
	 * @param long id
	 * @return LiveMainKawadaのレコード
	 */
	LiveMainKawada getLive(final long id);

	/**
	 * LiveMainKawadaにレコードを新規登録する
	 *
	 * @param LiveMainKawadaInputForm form
	 * @return LiveMainKawada
	 */
	LiveMainKawada insertLive(final LiveMainKawadaInputForm form);

	/**
	 * LiveMainKawadaのレコードを更新する
	 *
	 * @param LiveMainKawadaInputForm form
	 * @return LiveMainKawada
	 */
	LiveMainKawada updateLive(final LiveMainKawadaInputForm form);

	/**
	 * LiveMainKawadaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteLiveMainKawadaById(final long id);

	/**
	 * LiveMainKawadaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteLiveMainKawadaComp(final ArrayList<Long>ids);
}
