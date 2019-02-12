package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.tennisTominaga.PlayerMainSearchForm;
import jp.co.futureantiques.webapptraining.model.tennisTominaga.NationalityTominaga;
import jp.co.futureantiques.webapptraining.model.tennisTominaga.PlayerMainTominaga;

/**
 * TennisTominagaのサービスインターフェース コントローラーが呼び出すのはこれ
 *
 * @author future
 */
public interface TennisTominagaService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return NationalityEntityのリスト
	 */
	List<NationalityTominaga> getListNationality();


	/**
	 * 検索条件を元にPlayerMainのレコードのリストを取得する(Paging)
	 *
	 * @param PlayerMainSearchForm form
	 * @param Pageable pageable
	 * @return PlayerMainのリスト
	 */
	Page<PlayerMainTominaga> getPagePlayer(final PlayerMainSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にPlayerMainのレコードのリストを取得する
	 *
	 * @param PlayerMainSearchForm form
	 * @return PlayerMainのリスト
	 */

	List<PlayerMainTominaga> getListPlayer(final PlayerMainSearchForm form);

	/**
	 * IDをキーにPlayerMainのレコードを取得する
	 *
	 * @param long id
	 * @return PlayerMainのレコード
	 */
	PlayerMainTominaga getPlayer(final long id);


	/**
	 * PlayerMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deletePlayerById(final long id);

	/**
	 * PlayerMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deletePlayerComp(final ArrayList<Long> ids);
}