package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.soccerteamMatsuda.TeamMatsudaInputForm;
import jp.co.futureantiques.webapptraining.model.form.soccerteamMatsuda.TeamMatsudaSearchForm;
import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.HometownMatsuda;
import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.TeamColorMatsuda;
import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.TeamMainMatsuda;
import jp.co.futureantiques.webapptraining.repository.soccerteamMatsuda.HometownMatsudaRepository;
import jp.co.futureantiques.webapptraining.repository.soccerteamMatsuda.TeamColorMatsudaRepository;
import jp.co.futureantiques.webapptraining.repository.soccerteamMatsuda.TeamMainMatsudaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.SoccerTeamMatsudaSpecification;
import jp.co.futureantiques.webapptraining.service.SoccerTeamMatsudaService;

/**
 * SoccerTeamMatsudaのサービス実装クラス
 *
 * @author future
 */
@Service
public class SoccerTeamMatsudaServiceImpl implements SoccerTeamMatsudaService {

	/** TeamMainMatsudaリポジトリ */
	private final TeamMainMatsudaRepository teamMainMatsudaRepository;

	/** Hometownリポジトリ */
	private final HometownMatsudaRepository hometownMatsudaRepository;

	/** TeamColorリポジトリ */
	private final TeamColorMatsudaRepository teamColorMatsudaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param TeamMainMatsudaRepository teamMainMatsudaRepository
	 * @param HometownMatsudaRepository hometownMatsudaRepository
	 * @param TeamColorMatsudaRepository teamColorMatsudaRepository
	 */
	@Autowired
	public SoccerTeamMatsudaServiceImpl(TeamMainMatsudaRepository teamMainMatsudaRepository, HometownMatsudaRepository hometownMatsudaRepository,
			TeamColorMatsudaRepository teamColorMatsudaRepository) {
		this.teamMainMatsudaRepository = teamMainMatsudaRepository;
		this.hometownMatsudaRepository = hometownMatsudaRepository;
		this.teamColorMatsudaRepository = teamColorMatsudaRepository;
	}

	@Override
	public List<HometownMatsuda> getListHometownMatsuda() {

		// ホームタウンテーブルのレコードをID順に取得する
		return hometownMatsudaRepository.findAll(new Sort(Sort.Direction.ASC, "hometownId"));
	}

	@Override
	public List<TeamColorMatsuda> getListTeamColorMatsuda() {

		// チームカラーテーブルのレコードをID順に取得する
		return teamColorMatsudaRepository.findAll(new Sort(Sort.Direction.ASC, "teamColorId"));
	}

	@Override
	public Page<TeamMainMatsuda> getPageTeamMainMatsuda(final TeamMatsudaSearchForm form, final Pageable pageable) {

		// 検索条件を生成しTeamMainMatsudaテーブルのレコードを取得する
		return teamMainMatsudaRepository.findAll(SoccerTeamMatsudaSpecification.generateSoccerTeamMatsudaSpecification(form), pageable);
	}

	@Override
	public List<TeamMainMatsuda> getListTeamMainMatsuda(final TeamMatsudaSearchForm form) {

		// 検索条件を生成しMovieMainテーブルのレコードを取得する
		return teamMainMatsudaRepository.findAll(SoccerTeamMatsudaSpecification.generateSoccerTeamMatsudaSpecification(form));
	}

	@Override
	public TeamMainMatsuda getTeam(final long id) {

		// チームテーブルを主キー検索する
		return teamMainMatsudaRepository.findOne(id);
	}

	@Override
	public TeamMainMatsuda insertTeam(final TeamMatsudaInputForm form) {

		// MovieMainテーブルに新規でデータを登録する
		final TeamMainMatsuda teamMainMatsuda = form.convertToTeamMainMatsudaForInsert();

/*		//ファイルをアップロードする
		uploadFile(teamMainMatsuda, form.getImage());*/

		return teamMainMatsudaRepository.save(teamMainMatsuda);
	}

	@Override
	public TeamMainMatsuda updateTeam(final TeamMatsudaInputForm form) {

		// 更新対象のレコードを取得する
		TeamMainMatsuda teamMainMatsuda = teamMainMatsudaRepository.findOne((long) form.getId());
		if (teamMainMatsuda != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateFlag().equals(String.valueOf(teamMainMatsuda.getUpdateFlag()))) {

				// チェックOKの場合、更新
				teamMainMatsuda = form.convertToTeamMainMatsudaForUpdate(teamMainMatsuda);
				return teamMainMatsudaRepository.saveAndFlush(teamMainMatsuda);
			}
		}
		return null;
	}

	@Override
	public void deleteTeamById(final long id) {

		// 更新対象のレコードを取得する
		TeamMainMatsuda teamMainMatsuda = teamMainMatsudaRepository.findOne(id);
		if (teamMainMatsuda != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			 teamMainMatsudaRepository.delete(id);
		}
	}

	@Override
	public void deleteTeamComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		 teamMainMatsudaRepository.deleteComp(ids);
	}
}