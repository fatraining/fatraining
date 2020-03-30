package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.soccerteamMatsuda.TeamMatsudaInputForm;
import jp.co.futureantiques.webapptraining.model.form.soccerteamMatsuda.TeamMatsudaSearchForm;
import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.HometownMatsuda;
import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.TeamColorMatsuda;
import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.TeamMainMatsuda;

/**
 * SoccerTeamMatsudaのサービスインターフェース
 *
 * @author future
 */
public interface SoccerTeamMatsudaService {

	/**
	 * ホームタウンエンティティのリストを取得する
	 *
	 * @return HometownMatsudaEntityのリスト
	 */
	List<HometownMatsuda> getListHometownMatsuda();

	/**
	 * チームカラーエンティティのリストを取得する
	 *
	 * @return TeamColorMatsudaEntityのリスト
	 */
	List<TeamColorMatsuda> getListTeamColorMatsuda();

	/**
	 * 検索条件を元にTeamMainMatsudaのレコードのリストを取得する(Paging)
	 *
	 * @param SoccerTeamSearchForm form
	 * @param Pageable pageable
	 * @return TeamMainMatsudaのリスト
	 */
	Page<TeamMainMatsuda> getPageTeamMainMatsuda(final TeamMatsudaSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にTeamMainMatsudaのレコードのリストを取得する
	 *
	 * @param SoccerTeamSearchForm form
	 * @return TeamMainMatsudaのリスト
	 */
	List<TeamMainMatsuda> getListTeamMainMatsuda(final TeamMatsudaSearchForm form);

	/**
	 * IDをキーにTeamMainMatsudaのレコードを取得する
	 *
	 * @param long id
	 * @return TeamMainMatsudaのレコード
	 */
	TeamMainMatsuda getTeam(final long id);

	/**
	 * TeamMainMatsudaにレコードを新規登録する
	 *
	 * @param TeamMatsudaInputForm form
	 * @return TeamMainMatsuda
	 */
	TeamMainMatsuda insertTeam(final TeamMatsudaInputForm form);

	/**
	 * TeamMainMatsudaのレコードを更新する
	 *
	 * @param TeamMatsudaInputForm form
	 * @return TeamMainMatsuda
	 */
	TeamMainMatsuda updateTeam(final TeamMatsudaInputForm form);

	/**
	 * TeamMainMatsudaのレコードを論理削除する
	 *
	 * @param long id
	 * @return TeamMainMatsuda
	 */
	void deleteTeamById(final long id);

	/**
	 * TeamMainMatsudaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 * @return TeamMainMatsuda
	 */
	void deleteTeamComp(final ArrayList<Long> ids);
}