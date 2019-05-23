package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.RuinsKurihara.AreaKurihara;
import jp.co.futureantiques.webapptraining.model.RuinsKurihara.GenreKurihara;
import jp.co.futureantiques.webapptraining.model.RuinsKurihara.RuinsMainKurihara;
import jp.co.futureantiques.webapptraining.model.form.RuinsKurihara.RuinsKuriharaInputForm;
import jp.co.futureantiques.webapptraining.model.form.RuinsKurihara.RuinsKuriharaSearchForm;

/**
 * RuinsKuriharaのサービスインターフェース
 *
 * @author m.Kurihara
 */
public interface RuinsKuriharaService {

	/**
	 * 種別エンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	List<GenreKurihara> getListGenre();

	/**
	 * 地域エンティティのリストを取得する
	 *
	 * @return AreaEntityのリスト
	 */
	List<AreaKurihara> getListArea();

	/**
	 * 検索条件を元にRuinsMainKuriharaのレコードのリストを取得する(Paging)
	 *
	 * @param RuinsKuriharaSearchForm form
	 * @param Pageable pageable
	 * @return RuinsMainのリスト
	 */
	Page<RuinsMainKurihara> getPageRuins(final RuinsKuriharaSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にRuinsMainKuriharaのレコードのリストを取得する
	 *
	 * @param RuinsKuriharaSearchForm form
	 * @return RuinsMainKuriharaのリスト
	 */
	List<RuinsMainKurihara> getListRuins(final RuinsKuriharaSearchForm form);

	/**
	 * IDをキーにRuinsMainKuriharaのレコードを取得する
	 *
	 * @param long id
	 * @return RuinsMainKuriharaのレコード
	 */
	RuinsMainKurihara getRuins(final long id);

	/**
	 * RuinsMainKuriharaにレコードを新規登録する
	 *
	 * @param RuinsKuriharaInputForm form
	 * @return RuinsMain
	 */
	RuinsMainKurihara insertRuins(final RuinsKuriharaInputForm form);

	/**
	 * RuinsMainKuriharaのレコードを更新する
	 *
	 * @param RuinsKuriharaInputForm form
	 * @return RuinsMain
	 */
	RuinsMainKurihara updateRuins(final RuinsKuriharaInputForm form);

	/**
	 * RuinsMainKuriharaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteRuinsById(final long id);

	/**
	 * RuinsMainKuriharaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteRuinsComp(final ArrayList<Long> ids);
}