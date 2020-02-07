package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.riderSaito.RiderSaitoInputForm;
import jp.co.futureantiques.webapptraining.model.form.riderSaito.RiderSaitoSearchForm;
import jp.co.futureantiques.webapptraining.model.riderSaito.AgeSaito;
import jp.co.futureantiques.webapptraining.model.riderSaito.RiderMainSaito;
import jp.co.futureantiques.webapptraining.repository.riderSaito.AgeSaitoRepository;
import jp.co.futureantiques.webapptraining.repository.riderSaito.RiderMainSaitoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.RiderSaitoSpecification;
import jp.co.futureantiques.webapptraining.service.RiderSaitoService;

/**
 * RiderSaitoのサービス実装クラス
 *
 * @author future
 * */

@Service
public class RiderSaitoServiceImpl implements RiderSaitoService {

	/** RiderMainsaitoのリポジトリ */
	private final RiderMainSaitoRepository riderMainSaitoRepository;

	/** AgeSaitoのリポジトリ */
	private final AgeSaitoRepository ageSaitoRepository;

	/**
	 * コンストラクタ
	 *
	 * @param RiderMianSaitoRepository riderMainSaitoRepository
	 * @param AgeRepository ageRepository
	 *
	 * */
	@Autowired
	public RiderSaitoServiceImpl(
			RiderMainSaitoRepository riderMainSaitoRepository,
			AgeSaitoRepository ageSaitoRepository) {

		this.riderMainSaitoRepository = riderMainSaitoRepository;
		this.ageSaitoRepository = ageSaitoRepository;
	}

	@Override
	public List<AgeSaito> getListAge() {

		//AgeテーブルのレコードをID順に取得する
		return ageSaitoRepository.findAll(new Sort(Sort.Direction.ASC, "ageId"));
	}

	public Page<RiderMainSaito> getPageRider(final RiderSaitoSearchForm form, final Pageable pageable) {

		//検索条件を生成しRiderMainSaitoテーブルを取得する
		return riderMainSaitoRepository.findAll(RiderSaitoSpecification.generateRiderSpecification(form), pageable);
	}

	public List<RiderMainSaito> getListRider(final RiderSaitoSearchForm form) {

		//検索条件を生成しRiderMainSaitoテーブルを取得する
		return riderMainSaitoRepository.findAll(RiderSaitoSpecification.generateRiderSpecification(form));
	}

	@Override
	public RiderMainSaito getRider(final long id) {

		//RiderMainSitoテーブルを主キー検索する
		return riderMainSaitoRepository.findOne(id);
	}

	public RiderMainSaito insertRider(final RiderSaitoInputForm form) {

		//RiderMainSaitoテーブルに新規でデータを登録する
		final RiderMainSaito riderMainSaito = form.convertToRiderMainSaitoForInsert();
		return riderMainSaitoRepository.save(riderMainSaito);
	}

	public RiderMainSaito updateRider(final RiderSaitoInputForm form) {

		//更新対象のレコードを取得する
		RiderMainSaito riderMainSaito = riderMainSaitoRepository.findOne((long) form.getRiderId());
		if (riderMainSaito != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(riderMainSaito.getUpdateDate()))) {

				//チェックOKの場合更新
				riderMainSaito = form.convertToRiderMainSaitoForUpdate(riderMainSaito);
				return riderMainSaitoRepository.saveAndFlush(riderMainSaito);
			}
		}
		return null;
	}

	public void deleteRiderByRiderId(final long riderId) {

		//更新対象のレコードを取得する
		RiderMainSaito riderMainSaito = riderMainSaitoRepository.findOne(riderId);
		if (riderMainSaito != null) {

			//更新対象のレコードが存在する場合削除フラグを1にする
			riderMainSaitoRepository.delete(riderId);
		}
	}

	@Override
	public void deleteRiderComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		riderMainSaitoRepository.deleteComp(ids);
	}


}