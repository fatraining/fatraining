package jp.co.futureantiques.webapptraining.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.PlayerShiono.PlayerShionoSearchForm;
import jp.co.futureantiques.webapptraining.model.playerShiono.NationalShiono;
import jp.co.futureantiques.webapptraining.model.playerShiono.PlayerMainShiono;
import jp.co.futureantiques.webapptraining.model.playerShiono.TeamShiono;
import jp.co.futureantiques.webapptraining.repository.playerShiono.NationalShionoRepository;
import jp.co.futureantiques.webapptraining.repository.playerShiono.PlayerMainShionoRepository;
import jp.co.futureantiques.webapptraining.repository.playerShiono.TeamShionoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.PlayerShionoSpecification;
import jp.co.futureantiques.webapptraining.service.PlayerShionoService;

/**
 * PlayerShionoのサービス実装クラス
 *
 * @author Shiono
 */
@Service
public class PlayerShionoServiceImpl implements PlayerShionoService {

	/** PlayerMainShionoリポジトリ */
	private final PlayerMainShionoRepository playerMainShionoRepository;

	/** NationalShionoリポジトリ */
	private final NationalShionoRepository nationalShionoRepository;

	/** TeamShionoリポジトリ */
	private final TeamShionoRepository teamShionoRepository;

	/**
	 * コンストラクタ
	 *
	 * @param PlayerMainShionoRepository playerMainShionoRepository
	 * @param NationalShionoRepository nationalShionoRepository
	 * @param TeamShionoRepository teamShionoRepository
	 */
	@Autowired
	public PlayerShionoServiceImpl(PlayerMainShionoRepository playerMainShionoRepository, NationalShionoRepository nationalShionoRepository,
			TeamShionoRepository teamShionoRepository) {
		this.playerMainShionoRepository = playerMainShionoRepository;
		this.nationalShionoRepository = nationalShionoRepository;
		this.teamShionoRepository = teamShionoRepository;
	}

	@Override
	public List<NationalShiono> getListNationalShiono() {

		// NationalShionoテーブルのレコードをID順に取得する
		return nationalShionoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<TeamShiono> getListTeamShiono() {

		// teamShionoテーブルのレコードをID順に取得する
		return teamShionoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<PlayerMainShiono> getPagePlayerShiono(final PlayerShionoSearchForm form, final Pageable pageable) {

		// 検索条件を生成しPlayerMainShionoテーブルのレコードを取得する
		return playerMainShionoRepository.findAll(PlayerShionoSpecification.generatePlayerShionoSpecification(form), pageable);
	}

	@Override
	public List<PlayerMainShiono> getListPlayerShiono(final PlayerShionoSearchForm form) {

		// 検索条件を生成しPlayerMainShionoテーブルのレコードを取得する
		return playerMainShionoRepository.findAll(PlayerShionoSpecification.generatePlayerShionoSpecification(form));
	}

	@Override
	public PlayerMainShiono getPlayerShiono(final long id) {

		// PlayerMainShionoテーブルを主キー検索する
		return playerMainShionoRepository.findOne(id);
	}
	/*
	@Override
	public void deletePlayerShionoById(final long id) {

		// 更新対象のレコードを取得する
		PlayerMainShiono playerMainShiono = playerMainShionoRepository.findOne(id);
		if (playerMainShiono != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			playerMainShionoRepository.delete(id);
		}
	}

	@Override
	public void deletePlayerShionoComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		playerMainShionoRepository.deleteComp(ids);
	}
	*/
}
