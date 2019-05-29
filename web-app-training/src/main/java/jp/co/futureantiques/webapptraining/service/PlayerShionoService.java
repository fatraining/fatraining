package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.PlayerShiono.PlayerShionoSearchForm;
import jp.co.futureantiques.webapptraining.model.playerShiono.NationalShiono;
import jp.co.futureantiques.webapptraining.model.playerShiono.PlayerMainShiono;
import jp.co.futureantiques.webapptraining.model.playerShiono.TeamShiono;

/**
 * PlayerShionoのサービスインターフェース
 *
 * @author Shiono
 */
public interface PlayerShionoService {

	/**
	 * 国籍エンティティのリストを取得する
	 *
	 * @return NationalShionoEntityのリスト
	 */
	List<NationalShiono> getListNationalShiono();

	/**
	 * チームエンティティのリストを取得する
	 *
	 * @return TeamShionoEntityのリスト
	 */
	List<TeamShiono> getListTeamShiono();

	/**
	 * 検索条件を元にPlayerMainShionoのレコードのリストを取得する(Paging)
	 *
	 * @param PlayerShionoSearchForm form
	 * @param Pageable pageable
	 * @return PlayerMainShionoのリスト
	 */
	Page<PlayerMainShiono> getPagePlayerShiono(final PlayerShionoSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にPlayerMainShionoのレコードのリストを取得する
	 *
	 * @param PlayerShionoSearchForm form
	 * @return PlayerMainShionoのリスト
	 */
	List<PlayerMainShiono> getListPlayerShiono(final PlayerShionoSearchForm form);

	/**
	 * IDをキーにPlayerMainShionoのレコードを取得する
	 *
	 * @param long id
	 * @return PlayerMainShionoのレコード
	 */
	PlayerMainShiono getPlayerShiono(final long id);

	/**
	 * PlayerMainShionoにレコードを新規登録する
	 *
	 * @param PlayerShionoInputForm form
	 * @return PlayerMainShiono

	PlayerMainShiono insertPlayerShiono(final PlayerShionoInputForm form);

	/**
	 * PlayerMainShionoのレコードを更新する
	 *
	 * @param PlayerShionoInputForm form
	 * @return PlayerMainshiono

	PlayerMainShiono updatePlayerShiono(final PlayerShionoInputForm form);
	*/

	/**
	 * PlayerMainShionoのレコードを論理削除する
	 *
	 * @param long id

	void deletePlayerShionoById(final long id);

	/**
	 * PlayerMainShionoのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids

	void deletePlayerShionoComp(final ArrayList<Long> ids);
	*/
}
