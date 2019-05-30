package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.mlbUezu.MLBTeamSearchForm;
import jp.co.futureantiques.webapptraining.model.mlbUezu.DistrictUezu;
import jp.co.futureantiques.webapptraining.model.mlbUezu.LeagueUezu;
import jp.co.futureantiques.webapptraining.model.mlbUezu.MlbMainUezu;

/** MLBUezuのサービスインターフェース */

public interface MLBUezuService {

	/**
	 * リーグエンティティのリストを取得する
	 *
	 * @return LeagueEntityのリスト
	 */
	List<LeagueUezu> getListLeague();

	/**
	 * 地区エンティティのリストを取得する
	 *
	 * @return DistrictEntityのリスト
	 */
	List<DistrictUezu> getListDistrict();

	/**
	 * 検索条件を元にMLBMainUezuのレコードのリストを取得する(Paging)
	 *
	 * @param MLBTeamSearchForm form
	 * @param Pageable pageable
	 * @return MLBMainUezuのリスト
	 */
	Page<MlbMainUezu> getPageMLB(final MLBTeamSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にMLBMainUezuのレコードのリストを取得する
	 *
	 * @param MLBTeamSearchForm form
	 * @return MLBMainUezuのリスト
	 */
	List<MlbMainUezu> getListMLB(final MLBTeamSearchForm form);

	/**
	 * IDをキーにMLBMainUezuのレコードを取得する
	 *
	 * @param long id
	 * @return MLBMainUezuのレコード
	 */
	MlbMainUezu getMLBMain(final long id);

	//未作成↓(論理削除部分のみ作成済み)
	/**
	 * MovieMainにレコードを新規登録する
	 *
	 * @param MLBTeamInputForm form
	 * @return MovieMain
	 *
	MovieMain insertMovie(final MovieSampleInputForm form);

	/**
	 * MovieMainのレコードを更新する
	 *
	 * @param MLBTeamInputForm form
	 * @return MovieMain
	 *
	MovieMain updateMovie(final MovieSampleInputForm form);
	*/

	//論理削除
	/**
	 * MovieMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteMlbById(final long id);

	//未作成↓
	/**
	 * MovieMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 *
	void deleteMovieComp(final ArrayList<Long> ids);

	*/
}