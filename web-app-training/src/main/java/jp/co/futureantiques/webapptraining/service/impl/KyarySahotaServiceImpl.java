package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.kyarySahota.KyarySahotaInputForm;
import jp.co.futureantiques.webapptraining.model.form.kyarySahota.KyarySahotaSearchForm;
import jp.co.futureantiques.webapptraining.model.kyarySahota.CdNameSahota;
import jp.co.futureantiques.webapptraining.model.kyarySahota.CdTypeSahota;
import jp.co.futureantiques.webapptraining.model.kyarySahota.KyaryMainSahota;
import jp.co.futureantiques.webapptraining.repository.kyarySahota.CdNameSahotaRepository;
import jp.co.futureantiques.webapptraining.repository.kyarySahota.CdTypeSahotaRepository;
import jp.co.futureantiques.webapptraining.repository.kyarySahota.KyaryMainSahotaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.KyarySahotaSpecification;
import jp.co.futureantiques.webapptraining.service.KyarySahotaService;

/**
 * KyarySahotaのサービス実装クラス
 *
 * @author futureantiques
 */
@Service
public class KyarySahotaServiceImpl implements KyarySahotaService {

	/** KyaryMainリポジトリ */
	private final KyaryMainSahotaRepository kyaryMainSahotaRepository;

	/** CdNameリポジトリ */
	private final CdNameSahotaRepository cdNameSahotaRepository;

	/** CdTypeリポジトリ */
	private final CdTypeSahotaRepository cdTypeSahotaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param KyaryMainShotaRepository kyaryMainSahotaRepository
	 * @param CdNameSahotaRepository cdNameSahotaRepository
	 * @param CdTypeSahotaRepository cdTypeSahotaRepository
	 */
	@Autowired
	public KyarySahotaServiceImpl(KyaryMainSahotaRepository kyaryMainSahotaRepository,CdNameSahotaRepository cdNameSahotaRepository,
			CdTypeSahotaRepository cdTypeSahotaRepository) {
		this.kyaryMainSahotaRepository = kyaryMainSahotaRepository;
		this.cdNameSahotaRepository = cdNameSahotaRepository;
		this.cdTypeSahotaRepository = cdTypeSahotaRepository;
	}

	@Override
	public List<CdNameSahota> getListCdNameSahota(){

		//CdNameSahotaテーブルのレコードをID順に取得する
		return cdNameSahotaRepository.findAll(new Sort(Sort.Direction.ASC,"nameId"));
	}

	@Override
	public List<CdTypeSahota> getListCdTypeSahota(){

		//CdTypeShotaテーブルのレコードをID順に取得する
		return cdTypeSahotaRepository.findAll(new Sort(Sort.Direction.ASC,"typeId"));
	}

	@Override
	public Page<KyaryMainSahota> getPageKyarySahota(final KyarySahotaSearchForm form,final Pageable pageable){

		//検索画面を生成しKyaryMainSahotaテーブルのレコードを取得する
		return kyaryMainSahotaRepository.findAll(KyarySahotaSpecification.generateKyarySahotaSpecification(form),pageable);
	}

	@Override
	public List<KyaryMainSahota> getListKyarySahota(final KyarySahotaSearchForm form){

		//検索条件を生成しKyaryMainSahotaテーブルのレコードを取得する
		return kyaryMainSahotaRepository.findAll(KyarySahotaSpecification.generateKyarySahotaSpecification(form));
	}

	@Override
	public KyaryMainSahota getKyarySahota(final long id) {

		//KyaryMainSahotaテーブルを主キー検索する
		return kyaryMainSahotaRepository.findOne(id);
	}

	@Override
	public KyaryMainSahota insertKyarySahota(final KyarySahotaInputForm form) {

		//KyaryMainSahotaテーブルに新規でデータを登録する
		final KyaryMainSahota kyaryMainSahota = form.convertToKyaryMainSahotaForInsert();
		return kyaryMainSahotaRepository.save(kyaryMainSahota);
	}

	@Override
	public KyaryMainSahota updateKyarySahota(final KyarySahotaInputForm form) {

		//更新対象のレコードを取得する
		KyaryMainSahota kyaryMainSahota = kyaryMainSahotaRepository.findOne((long) form.getId());
		if(kyaryMainSahota != null) {

			//更新対象のレコードが存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(kyaryMainSahota.getUpdateDate()))) {

				//チェックOKの場合、更新
				kyaryMainSahota = form.convertToKyaryMainSahotaForUpdate(kyaryMainSahota);
				return kyaryMainSahotaRepository.saveAndFlush(kyaryMainSahota);
			}
		}
		return null;
	}

	@Override
	public void deleteKyarySahotaById(final long id) {

		//更新対象のレコードを取得する
		KyaryMainSahota kyaryMainSahota = kyaryMainSahotaRepository.findOne(id);
		if(kyaryMainSahota != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			kyaryMainSahotaRepository.delete(id);
		}
	}

	@Override
	public void deleteKyarySahotaComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		kyaryMainSahotaRepository.deleteComp(ids);
	}
}
