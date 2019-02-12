package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.tennisTominaga.PlayerMainSearchForm;
import jp.co.futureantiques.webapptraining.model.tennisTominaga.NationalityTominaga;
import jp.co.futureantiques.webapptraining.model.tennisTominaga.PlayerMainTominaga;
import jp.co.futureantiques.webapptraining.repository.specification.TennisTominagaSpecification;
import jp.co.futureantiques.webapptraining.repository.tennisTominaga.NationalityTominagaRepository;
import jp.co.futureantiques.webapptraining.repository.tennisTominaga.PlayerMainTominagaRepository;
import jp.co.futureantiques.webapptraining.service.TennisTominagaService;

/**
 * TennisTominagaのサービス実装クラス
 *
 * @author future
 */
@Service
public class TennisTominagaServiceImpl implements TennisTominagaService {

	/** PlayerMainリポジトリ */
	private final PlayerMainTominagaRepository playerMainTominagaRepository;

	/** Nationalityリポジトリ */
	private final NationalityTominagaRepository nationalityTominagaRepository;


	/**
	 * コンストラクタ
	 *
	 * @param PlayerMainTominagaRepository playerMainTominagaRepository
	 * @param NationalityTominagaRepository nationalityTominagaRepository
	 */
	@Autowired
	public TennisTominagaServiceImpl(PlayerMainTominagaRepository playerMainTominagaRepository, NationalityTominagaRepository nationalityTominagaRepository
			) {
		this.playerMainTominagaRepository = playerMainTominagaRepository;
		this.nationalityTominagaRepository = nationalityTominagaRepository;

	}

	@Override //
	public List<NationalityTominaga> getListNationality() {

		// NationalityテーブルのレコードをID順に取得する
		//TODO ここをぬるにしてた
		//TODO 
//		return nationalityTominagaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
		return nationalityTominagaRepository.findAll(new Sort(Sort.Direction.ASC, "nationalityId"));

	}


	@Override
	public Page<PlayerMainTominaga> getPagePlayer(final PlayerMainSearchForm form, final Pageable pageable) {
		//サーチに飛んだらここが呼び出される。検索条件からの結果を返すために、
		//リポジトリのfindAllメソッドに受け取った
		// 検索条件を生成しPlayerMainTominagaテーブルのレコードを取得する
		return playerMainTominagaRepository.findAll(TennisTominagaSpecification.generatePlayerSpecification(form), pageable);
	}

	@Override
	public List<PlayerMainTominaga> getListPlayer(final PlayerMainSearchForm form) {

		// 検索条件を生成しPlayerMainテーブルのレコードを取得する
		return playerMainTominagaRepository.findAll(TennisTominagaSpecification.generatePlayerSpecification(form));
	}

	@Override
	public PlayerMainTominaga getPlayer(final long id) {

		// PlayerMainテーブルを主キー検索する
		return playerMainTominagaRepository.findOne(id);
	}


	@Override
	public void deletePlayerById(final long id) {

		// 更新対象のレコードを取得する
		PlayerMainTominaga playerMain = playerMainTominagaRepository.findOne(id);
		if (playerMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			playerMainTominagaRepository.delete(id);
		}
	}

	@Override
	public void deletePlayerComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		playerMainTominagaRepository.deleteComp(ids);
	}
}