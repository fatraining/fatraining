package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.residentsUriu.ResidentsUriuInputForm;
import jp.co.futureantiques.webapptraining.model.form.residentsUriu.ResidentsUriuSearchForm;
import jp.co.futureantiques.webapptraining.model.residentsUriu.AnimalUriu;
import jp.co.futureantiques.webapptraining.model.residentsUriu.ResidentsMainUriu;
import jp.co.futureantiques.webapptraining.model.residentsUriu.TypeUriu;
import jp.co.futureantiques.webapptraining.repository.residentsUriu.AnimalUriuRepository;
import jp.co.futureantiques.webapptraining.repository.residentsUriu.ResidentsMainUriuRepository;
import jp.co.futureantiques.webapptraining.repository.residentsUriu.TypeUriuRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ResidentsUriuSpecification;
import jp.co.futureantiques.webapptraining.service.ResidentsUriuService;

/**
 * ResidentsUriuのサービス実装クラス
 *
 */

@Service
public class ResidentsUriuServiceImpl implements ResidentsUriuService {

	/** ResidentsMainUriuリポジトリ */
	private final ResidentsMainUriuRepository residentsMainUriuRepository;

	/** TypeUriuリポジトリ */
	private final TypeUriuRepository typeUriuRepository;

	/** AnimalUriuリポジトリ */
	private final AnimalUriuRepository animalUriuRepository;

	/**
	 * コンストラクタ
	 *
	 * @param ResidentsMainUriuRepository residentsMainUriuRepository
	 * @param TypeUriuRepository typeUriuRepository
	 * @param AnimalUriuRepository animalUriuRepository
	 */
	@Autowired
	public ResidentsUriuServiceImpl(ResidentsMainUriuRepository residentsMainUriuRepository,TypeUriuRepository typeUriuRepository,AnimalUriuRepository animalUriuRepository) {
		this.residentsMainUriuRepository = residentsMainUriuRepository;
		this.typeUriuRepository = typeUriuRepository;
		this.animalUriuRepository = animalUriuRepository;
	}

	@Override
	public List<TypeUriu> getListTypeUriu() {
		// type_uriuテーブルのレコードをID順に取得する
		return typeUriuRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public List<AnimalUriu> getListAnimalUriu() {
		// animal_uriuテーブルのレコードをID順に取得する
		return animalUriuRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public Page<ResidentsMainUriu> getPageResidentsUriu(final ResidentsUriuSearchForm form,final Pageable pageable){
		// 検索条件を生成しresidents_main_uriuテーブルのレコードを取得する
		return residentsMainUriuRepository.findAll(ResidentsUriuSpecification.generateResidentsUriuSpecification(form),pageable);
	}

	@Override
	public List<ResidentsMainUriu> getListResidentsUriu(final ResidentsUriuSearchForm form){
		// 検索条件を生成しresidents_main_uriuテーブルのレコードを取得する
		return residentsMainUriuRepository.findAll(ResidentsUriuSpecification.generateResidentsUriuSpecification(form));
	}

	@Override
	public ResidentsMainUriu getResidentsUriu(final long id) {
		// residens_main_uriuテーブルを主キー検索する
		return residentsMainUriuRepository.findOne(id);
	}

	@Override
	public ResidentsMainUriu insertResidentsUriu(final ResidentsUriuInputForm form) {
		// residents_main_uriuテーブルに新規でデータを登録する
		final ResidentsMainUriu residentsMainUriu = form.convertToResidentsMainUriuForInsert();
		return residentsMainUriuRepository.save(residentsMainUriu);
	}

	@Override
	public ResidentsMainUriu updateResidentsUriu(final ResidentsUriuInputForm form) {
		// 更新対象のレコードを取得する
		ResidentsMainUriu residentsMainUriu = residentsMainUriuRepository.findOne((long)form.getId());
		if(residentsMainUriu!=null) {
			// 更新対象のレコードを存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(residentsMainUriu.getUpdateDate()))) {
				// チェックOKの場合、更新
				residentsMainUriu = form.convertToResidentsMainUriuForUpdate(residentsMainUriu);
				return residentsMainUriuRepository.saveAndFlush(residentsMainUriu);
			}
		}
		return null;
	}

	@Override
	public void deleteResidentsUriuById(final long id) {
		// 更新対象のレコードを取得する
		ResidentsMainUriu residentsMainUriu = residentsMainUriuRepository.findOne(id);
		if(residentsMainUriu != null) {
			// 更新対象のレコードが存在する場合、削除フラグを1にする
			residentsMainUriuRepository.delete(id);
		}
	}
	@Override
	public void deleteResidentsUriuComp(final ArrayList<Long> ids) {
		// 対象のレコードを削除する
		residentsMainUriuRepository.deleteComp(ids);
	}

}
