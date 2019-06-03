package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.spaOkabe.SpaOkabeInputForm;
import jp.co.futureantiques.webapptraining.model.form.spaOkabe.SpaOkabeSearchForm;
import jp.co.futureantiques.webapptraining.model.spaOkabe.AreaOkabe;
import jp.co.futureantiques.webapptraining.model.spaOkabe.QualityOkabe;
import jp.co.futureantiques.webapptraining.model.spaOkabe.SpaMainOkabe;
import jp.co.futureantiques.webapptraining.repository.spaOkabe.AreaOkabeRepository;
import jp.co.futureantiques.webapptraining.repository.spaOkabe.QualityOkabeRepository;
import jp.co.futureantiques.webapptraining.repository.spaOkabe.SpaMainOkabeRepository;
import jp.co.futureantiques.webapptraining.repository.specification.SpaOkabeSpecification;
import jp.co.futureantiques.webapptraining.service.SpaOkabeService;

/**
 * SpaOkabeのサービス実装クラス
 *
 * @author SEIYA OKABE
 */
@Service

public class SpaOkabeServiceImpl implements SpaOkabeService {

	/** SpaMainOkabeリポジトリ */
	private final SpaMainOkabeRepository spaMainOkabeRepository;

	/** AreaOkabeリポジトリ */
	private final AreaOkabeRepository areaOkabeRepository;

	/** QualityOkabeリポジトリ */
	private final QualityOkabeRepository qualityOkabeRepository;

	/**
	 * コンストラクタ
	 *
	 * @param SpaMainOkabeRepository spaMainOkabeRepository
	 * @param AreaOkabeRepository areaOkabeRepository
	 * @param QualityOkabeRepository qualityOkabeRepository
	 */
	@Autowired
	public SpaOkabeServiceImpl(SpaMainOkabeRepository spaMainOkabeRepository, AreaOkabeRepository areaOkabeRepository,
			QualityOkabeRepository qualityOkabeRepository) {
		this.spaMainOkabeRepository = spaMainOkabeRepository;
		this.areaOkabeRepository = areaOkabeRepository;
		this.qualityOkabeRepository = qualityOkabeRepository;
	}

	@Override
	public List<AreaOkabe> getListAreaOkabe() {

		// AreaOkabeテーブルのレコードをID順に取得する
		return areaOkabeRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<QualityOkabe> getListQualityOkabe() {

		// QualityOkabeテーブルのレコードをID順に取得する
		return qualityOkabeRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<SpaMainOkabe> getPageSpa(final SpaOkabeSearchForm form, final Pageable pageable) {

		// 検索条件を生成しSpaMainOkabeテーブルのレコードを取得する
		return spaMainOkabeRepository.findAll(SpaOkabeSpecification.generateSpaSpecification(form), pageable);
	}

	@Override
	public List<SpaMainOkabe> getListSpaMainOkabe(final SpaOkabeSearchForm form) {

		// 検索条件を生成しSpaMainOkabeテーブルのレコードを取得する
		return spaMainOkabeRepository.findAll(SpaOkabeSpecification.generateSpaSpecification(form));
	}

	@Override
	public SpaMainOkabe getSpaMainOkabe(final long id) {

		// SpaMainOkabeテーブルを主キー検索する
		return spaMainOkabeRepository.findOne(id);
	}

	@Override
	public SpaMainOkabe insertSpa(final SpaOkabeInputForm form) {

		// MovieMainテーブルに新規でデータを登録する
		final SpaMainOkabe spaMainOkabe = form.convertToSpaMainOkabeForInsert();
		return spaMainOkabeRepository.save(spaMainOkabe);
	}

	@Override
	public SpaMainOkabe updateSpa(final SpaOkabeInputForm form) {

		// 更新対象のレコードを取得する
		SpaMainOkabe spaMainOkabe = spaMainOkabeRepository.findOne((long) form.getId());
		if (spaMainOkabe != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(spaMainOkabe.getUpdateDate()))) {

				// チェックOKの場合、更新
				spaMainOkabe = form.convertToSpaMainOkabeForUpdate(spaMainOkabe);
				return spaMainOkabeRepository.saveAndFlush(spaMainOkabe);
			}
		}
		return null;
	}

	@Override
	public void deleteSpaById(final long id) {

		// 更新対象のレコードを取得する
		SpaMainOkabe spaMainOkabe = spaMainOkabeRepository.findOne(id);
		if (spaMainOkabe != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			spaMainOkabeRepository.delete(id);
		}
	}

	@Override
	public void deleteSpaComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		spaMainOkabeRepository.deleteComp(ids);
	}

}
