package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.residentsSato.ResidentsSatoInputForm;
import jp.co.futureantiques.webapptraining.model.form.residentsSato.ResidentsSatoSearchForm;
import jp.co.futureantiques.webapptraining.model.residentsSato.AnimalSato;
import jp.co.futureantiques.webapptraining.model.residentsSato.ResidentsMainSato;
import jp.co.futureantiques.webapptraining.model.residentsSato.SexSato;
import jp.co.futureantiques.webapptraining.repository.residentsSato.AnimalSatoRepository;
import jp.co.futureantiques.webapptraining.repository.residentsSato.ResidentsMainSatoRepository;
import jp.co.futureantiques.webapptraining.repository.residentsSato.SexSatoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ResidentsSatoSpecification;
import jp.co.futureantiques.webapptraining.service.ResidentsSatoService;

/**
 * ResidentsSatoのサービス実装クラス
 * @author future
 */
@Service
public class ResidentsSatoServiceImpl implements ResidentsSatoService{

	/**ResidentsMainリポジトリ */
	private final ResidentsMainSatoRepository residentsMainSatoRepository;

	/** Animalリポジトリ */
	private final AnimalSatoRepository animalSatoRepository;

	/** Sexリポジトリ */
	private final SexSatoRepository sexSatoRepository;

	/**
	 * コンストラクタ
	 *
	 * @param ResidentsMainSatoRepository residentsMainSatoRepository
	 * @param AnimalSatoRepository genreRepository
	 * @param SexSatoRepository movieActorRepository
	 */
	@Autowired
	public ResidentsSatoServiceImpl(ResidentsMainSatoRepository residentsMainSatoRepository, AnimalSatoRepository animalSatoRepository,
			SexSatoRepository sexSatoRepository) {
		this.residentsMainSatoRepository = residentsMainSatoRepository;
		this.animalSatoRepository = animalSatoRepository;
		this.sexSatoRepository = sexSatoRepository;
	}

	@Override
	public List<AnimalSato> getListAnimalSato() {

		// AnimalテーブルのレコードをID順に取得する
		return animalSatoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<SexSato> getListSexSato() {

		// SexテーブルのレコードをID順に取得する
		return sexSatoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<ResidentsMainSato> getPageResidentsSato(final ResidentsSatoSearchForm form, final Pageable pageable) {

		// 検索条件を生成しResidentsMainテーブルのレコードを取得する
		return residentsMainSatoRepository.findAll(ResidentsSatoSpecification.generateResidentsSatoSpecification(form), pageable);
	}

	@Override
	public List<ResidentsMainSato> getListResidentsSato(final ResidentsSatoSearchForm form) {

		// 検索条件を生成しResidentsMainテーブルのレコードを取得する
		return residentsMainSatoRepository.findAll(ResidentsSatoSpecification.generateResidentsSatoSpecification(form));
	}

	@Override
	public ResidentsMainSato getResidentsSato(final long id) {

		// ResidentsMainテーブルを主キー検索する
		return residentsMainSatoRepository.findOne(id);
	}

	@Override
	public ResidentsMainSato insertResidentsSato(final ResidentsSatoInputForm form) {

		// ResidentsMainテーブルに新規でデータを登録する
		final ResidentsMainSato residentsMainSato = form.convertToResidentsMainForInsert();
		return residentsMainSatoRepository.save(residentsMainSato);
	}

	@Override
	public ResidentsMainSato updateResidentsSato(final ResidentsSatoInputForm form) {

		// 更新対象のレコードを取得する
		ResidentsMainSato residentsMainSato = residentsMainSatoRepository.findOne((long) form.getId());
		if (residentsMainSato != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(residentsMainSato.getUpdateDate()))) {

				// チェックOKの場合、更新
				residentsMainSato = form.convertToResidentsMainSatoForUpdate(residentsMainSato);
				return residentsMainSatoRepository.saveAndFlush(residentsMainSato);
			}
		}
		return null;
	}

	@Override
	public void deleteResidentsSatoById(final long id) {

		// 更新対象のレコードを取得する
		ResidentsMainSato residentsMainSato = residentsMainSatoRepository.findOne(id);
		if (residentsMainSato != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			residentsMainSatoRepository.delete(id);
		}
	}

	@Override
	public void deleteResidentsSatoComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		residentsMainSatoRepository.deleteComp(ids);
	}

}