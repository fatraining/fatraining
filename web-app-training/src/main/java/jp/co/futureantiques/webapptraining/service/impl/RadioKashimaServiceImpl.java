package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.radioKashima.RadioKashimaInputForm;
import jp.co.futureantiques.webapptraining.model.form.radioKashima.RadioKashimaSearchForm;
import jp.co.futureantiques.webapptraining.model.radioKashima.KeystationKashima;
import jp.co.futureantiques.webapptraining.model.radioKashima.RadioMainKashima;
import jp.co.futureantiques.webapptraining.repository.radioKashima.KeystationKashimaRepository;
import jp.co.futureantiques.webapptraining.repository.radioKashima.RadioMainKashimaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.RadioKashimaSpecification;
import jp.co.futureantiques.webapptraining.service.RadioKashimaService;

/**
 * RadioKashimaのサービス実装クラス
 * @author Kashima
 *
 */
@Service
public class RadioKashimaServiceImpl implements RadioKashimaService {

	/**RadioMainリポジトリ**/
	private final RadioMainKashimaRepository radioMainKashimaRepository;

	/**Keystationリポジトリ**/
	private final KeystationKashimaRepository keystationKashimaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param RadioMainKashimaRepository radioMainKashimaRepository
	 * @param KeystationKashimaRepository keystationKashimaRepository
	 *
	 */
	@Autowired
	public RadioKashimaServiceImpl(RadioMainKashimaRepository radioMainKashimaRepository,
			KeystationKashimaRepository keystationKashimaRepository) {
		this.radioMainKashimaRepository = radioMainKashimaRepository;
		this.keystationKashimaRepository = keystationKashimaRepository;

	}

	@Override
	public List<KeystationKashima> getListKeystationKashima() {

		//KeystationテーブルのレコードをID順に取得する
		return keystationKashimaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}


	@Override
	public Page<RadioMainKashima> getPageRadioKashima(final RadioKashimaSearchForm form, final Pageable pageable) {

		//検索条件を生成しRadioMainテーブルのレコードを取得する
		return radioMainKashimaRepository.findAll(RadioKashimaSpecification.generateRadioKashimaSpecification(form),
				pageable);
	}

	@Override
	public List<RadioMainKashima> getListRadioKashima(final RadioKashimaSearchForm form) {

		//検索条件を生成しRadioMainテーブルのレコードを取得する
		return radioMainKashimaRepository.findAll(RadioKashimaSpecification.generateRadioKashimaSpecification(form));
	}

	@Override
	public RadioMainKashima getRadioKashima(final long id) {

		//RadioMainテーブルを主キー検索する
		return radioMainKashimaRepository.findOne(id);
	}

	@Override
	public RadioMainKashima insertRadioKashima(final RadioKashimaInputForm form) {

		//RadioMainテーブルに新規でデータを登録する
		final RadioMainKashima radioMainKashima = form.convertToRadioMainForInsert();
		return radioMainKashimaRepository.save(radioMainKashima);
	}

	@Override
	public RadioMainKashima updateRadioKashima(final RadioKashimaInputForm form) {

		//更新対象のレコードを取得する
		RadioMainKashima radioMainKashima = radioMainKashimaRepository.findOne((long) form.getId());
		if (radioMainKashima != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(radioMainKashima.getUpdateDate()))) {

				//チェックOKの場合、更新
				radioMainKashima = form.convertToRadioMainForUpdate(radioMainKashima);
				return radioMainKashimaRepository.saveAndFlush(radioMainKashima);
			}
		}
		return null;
	}

	@Override
	public void deleteRadioKashimaById(final long id ) {

		//更新対象レコードを取得する
		RadioMainKashima radioMainKashima = radioMainKashimaRepository.findOne(id);
		if (radioMainKashima != null) {

			//更新対象のレコードが存在する場所、削除フラグを1にする。
			radioMainKashimaRepository.delete(id);
		}
	}

	@Override
	public void deleteRadioKashimaComp(final ArrayList<Long> ids) {

		//対象のレコードを削除
		radioMainKashimaRepository.deleteComp(ids);
	}



}
