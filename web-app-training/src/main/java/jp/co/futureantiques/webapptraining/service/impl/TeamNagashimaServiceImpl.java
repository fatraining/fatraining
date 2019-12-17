package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.teamNagashima.TeamNagashimaInputForm;
import jp.co.futureantiques.webapptraining.model.form.teamNagashima.TeamNagashimaSearchForm;
import jp.co.futureantiques.webapptraining.model.teamNagashima.CoachNagashima;
import jp.co.futureantiques.webapptraining.model.teamNagashima.RegionNagashima;
import jp.co.futureantiques.webapptraining.model.teamNagashima.TeamMainNagashima;
import jp.co.futureantiques.webapptraining.repository.specification.TeamNagashimaSpecification;
import jp.co.futureantiques.webapptraining.repository.teamNagashima.CoachNagashimaRepository;
import jp.co.futureantiques.webapptraining.repository.teamNagashima.RegionNagashimaRepository;
import jp.co.futureantiques.webapptraining.repository.teamNagashima.TeamMainNagashimaRepository;
import jp.co.futureantiques.webapptraining.service.TeamNagashimaService;

/**
 * teamNagashimaのサービス実装クラス
 * @author future
 *
 */
@Service
public class TeamNagashimaServiceImpl implements TeamNagashimaService {

	/**TeamMainリポジトリ*/
	private final TeamMainNagashimaRepository teamMainNagashimaRepository;

	/**RegionNagashimaリポジトリ*/
	private final RegionNagashimaRepository regionNagashimaRepository;

	/**CoachNagashimaリポジトリ*/
	private final CoachNagashimaRepository coachNagashimaRepository;

	/**
	 * コンストラクタ
	 * @param teamMainNagashimaRepository
	 * @param regionNagashimaRepository
	 * @param coachNagashimaRepository
	 */
	@Autowired
	public TeamNagashimaServiceImpl(TeamMainNagashimaRepository teamMainNagashimaRepository,
			RegionNagashimaRepository regionNagashimaRepository,
			CoachNagashimaRepository coachNagashimaRepository) {
		this.teamMainNagashimaRepository = teamMainNagashimaRepository;
		this.regionNagashimaRepository = regionNagashimaRepository;
		this.coachNagashimaRepository = coachNagashimaRepository;
	}
	@Override
	public List<RegionNagashima> getListRegionNagashima() {

		// RegionNagashimaテーブルのレコードをID順に取得する
		return regionNagashimaRepository.findAll(new Sort(Sort.Direction.ASC, "regionId"));
	}
	@Override
	public List<CoachNagashima> getListCoachNagashima() {

		// CoachNagashimaテーブルのレコードをID順に取得する
		return coachNagashimaRepository.findAll(new Sort(Sort.Direction.ASC, "coachId"));
	}
	@Override
	public Page<TeamMainNagashima> getPageTeamNagashima
	(final TeamNagashimaSearchForm form, final Pageable pageable) {

		// 検索条件を生成しTeamMainNagashimaテーブルのレコードを取得する
		return teamMainNagashimaRepository.findAll(TeamNagashimaSpecification.generateTeamNagashmaSpecification(form),
				pageable);
	}
	@Override
	public List<TeamMainNagashima> getListTeamNagashima(final TeamNagashimaSearchForm form) {

		// 検索条件を生成しTeamMainNagashimaテーブルのレコードを取得する
		return teamMainNagashimaRepository.findAll(TeamNagashimaSpecification.generateTeamNagashmaSpecification(form));
	}

	@Override
	public TeamMainNagashima getTeamNagashima(final long id) {

		// TeamMainNagashimaテーブルを主キー検索する
		return teamMainNagashimaRepository.findOne(id);
	}
	@Override
	public TeamMainNagashima insertTeamNagashima(final TeamNagashimaInputForm form) {

		// TeamMainNagashimaテーブルに新規データを登録する
		final TeamMainNagashima teamMainNagashima = form.convertToTeamMainNagashimaForInsert();
		return teamMainNagashimaRepository.save(teamMainNagashima);
	}
	@Override
	public TeamMainNagashima updateTeamNagashima(final TeamNagashimaInputForm form) {

		// 更新対象のレコードを取得する
		TeamMainNagashima teamMainNagashima = teamMainNagashimaRepository.findOne((long) form.getId());
		if (teamMainNagashima != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(teamMainNagashima.getUpdateDate()))) {

				//チェックOKの場合、更新
				teamMainNagashima = form.convertToTeamMainNagashimaForUpdate(teamMainNagashima);
				return teamMainNagashimaRepository.saveAndFlush(teamMainNagashima);
			}
		}
		return null;
	}
	@Override
	public void deleteTeamNagashimaById(final long id) {

		// 更新対象のレコードを取得する
		TeamMainNagashima teamMainNagashima = teamMainNagashimaRepository.findOne(id);
		if (teamMainNagashima != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			teamMainNagashimaRepository.delete(id);
		}
	}
	@Override
	public void deleteTeamNagashimaComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		teamMainNagashimaRepository.deleteComp(ids);
	}
}
