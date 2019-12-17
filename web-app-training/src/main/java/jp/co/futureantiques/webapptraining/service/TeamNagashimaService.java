package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.teamNagashima.TeamNagashimaInputForm;
import jp.co.futureantiques.webapptraining.model.form.teamNagashima.TeamNagashimaSearchForm;
import jp.co.futureantiques.webapptraining.model.teamNagashima.CoachNagashima;
import jp.co.futureantiques.webapptraining.model.teamNagashima.RegionNagashima;
import jp.co.futureantiques.webapptraining.model.teamNagashima.TeamMainNagashima;

/**
 * TeamNagashimaのサービスインターフェース
 * @author future
 *
 */
public interface TeamNagashimaService {

	/**
	 * Regionエンティティのリストを取得する
	 *
	 * @return　RegionEntityのリスト
	 */
	List<RegionNagashima> getListRegionNagashima();

	/**
	 * Coachエンティティのリストを取得する
	 *
	 * @return　CoachEntityのリスト
	 */
	List<CoachNagashima> getListCoachNagashima();

	/**
	 * 検索条件を元にTeamMainNagashimaのレコードのリストを取得
	 * @param TeamNagashimaSearchForm form
	 * @param Pageble pageble
	 * @return　TeamMainNagashimaのリスト
	 */
	Page<TeamMainNagashima> getPageTeamNagashima(final TeamNagashimaSearchForm form, final Pageable pageable);

	/**
	 *  検索条件を元にMovieMainのレコードのリストを取得する
	 * @param TeamNagashimaSearchForm　form
	 * @return　TeamMainNagashimaのリスト
	 */
	List<TeamMainNagashima> getListTeamNagashima(final TeamNagashimaSearchForm form);

	/**
	 * IDをキーにTeamMainNagashimaのレコードを取得する
	 *
	 * @param long id
	 * @return TeamMainNagashimaのレコード
	 */
	TeamMainNagashima getTeamNagashima(final long id);

	/**
	 * TeamMainNagashimaにレコードを新規登録する
	 *
	 * @param TeamNagashimaInputForm form
	 * @return TeamMainNagashima
	 */
	TeamMainNagashima insertTeamNagashima(final TeamNagashimaInputForm form);

	/**
	 * TeamMainNagashimaのレコードを更新する
	 *
	 * @param TeamNagashimaInputForm form
	 * @return TeamMainNagashima
	 */
	TeamMainNagashima updateTeamNagashima(final TeamNagashimaInputForm form);

	/**
	 * TeamMainNagashimaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteTeamNagashimaById(final long id);

	/**
	 * TeamMainNagashimaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteTeamNagashimaComp(final ArrayList<Long> ids);
}