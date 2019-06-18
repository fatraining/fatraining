package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.idolShintaku.IdolShintakuInputForm;
import jp.co.futureantiques.webapptraining.model.form.idolShintaku.IdolShintakuSearchForm;
import jp.co.futureantiques.webapptraining.model.idolShintaku.IdolMainShintaku;
import jp.co.futureantiques.webapptraining.model.idolShintaku.TypeShintaku;
import jp.co.futureantiques.webapptraining.model.idolShintaku.UnitShintaku;
import jp.co.futureantiques.webapptraining.repository.idolShintaku.IdolMainShintakuRepository;
import jp.co.futureantiques.webapptraining.repository.idolShintaku.TypeShintakuRepository;
import jp.co.futureantiques.webapptraining.repository.idolShintaku.UnitShintakuRepository;
import jp.co.futureantiques.webapptraining.repository.specification.IdolShintakuSpecification;
import jp.co.futureantiques.webapptraining.service.IdolShintakuService;

/**
 * IdolShintakuのサービス実装クラス
 *
 * @author shintaku
 */
@Service
public class IdolShintakuServiceImpl implements IdolShintakuService {

	//IdolMainShintakuリポジトリ
	private final IdolMainShintakuRepository idolMainShintakuRepository;

	//TypeShintakuリポジトリ
	private final TypeShintakuRepository typeShintakuRepository;

	//UnitShintakuリポジトリ
	private final UnitShintakuRepository unitShintakuRepository;

	/**
	 * コンストラクタ
	 *
	 * @param IdolMainShintakuRepository idolMainShintakuRepository
	 * @param TypeShintakuRepository typeShintakuRepository
	 * @param UnitShintakuRepository unitShintakuRepository
	 */
	@Autowired
	public IdolShintakuServiceImpl(IdolMainShintakuRepository idolMainShintakuRepository,TypeShintakuRepository typeShintakuRepository,
			UnitShintakuRepository unitShintakuRepository) {
		this.idolMainShintakuRepository = idolMainShintakuRepository;
		this.typeShintakuRepository = typeShintakuRepository;
		this.unitShintakuRepository = unitShintakuRepository;
	}

	@Override
	public List<TypeShintaku> getListType() {

		//type_shinatkuテーブルのレコードをID順に取得する
		return typeShintakuRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public List<UnitShintaku> getListUnit() {

		//unit_shintakuテーブルのレコードをID順に取得する
		return unitShintakuRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
	}

	@Override
	public Page<IdolMainShintaku> getPageIdol(final IdolShintakuSearchForm form,final Pageable pageable) {

		// 検索条件を生成しidol_main_shintakuテーブルのレコードを取得する
		return idolMainShintakuRepository.findAll(IdolShintakuSpecification.generateIdolSpecification(form), pageable);
	}

	@Override
	public List<IdolMainShintaku> getListIdol(final IdolShintakuSearchForm form) {

		// 検索条件を生成しidol_main_shintakuテーブルのレコードを取得する
		return idolMainShintakuRepository.findAll(IdolShintakuSpecification.generateIdolSpecification(form));
	}

	@Override
	public IdolMainShintaku getIdol(final long id) {

		// idol_main_shinatkuテーブルを主キー検索する
		return idolMainShintakuRepository.findOne(id);
	}

	@Override
	public IdolMainShintaku insertIdol(IdolShintakuInputForm form) {

		//idol_main_shintakuテーブルに新規でデータを登録する
		final IdolMainShintaku idolMainShintaku = form.convertToIdolMainShintakuForInsert();
		return idolMainShintakuRepository.save(idolMainShintaku);
	}

	@Override
	public IdolMainShintaku updateIdol(final IdolShintakuInputForm form) {

		//更新対象のレコードを取得する
		IdolMainShintaku idolMainShintaku = idolMainShintakuRepository.findOne((long) form.getId());
		if(idolMainShintaku != null) {

			//更新対象のレコードが存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(idolMainShintaku.getUpdateDate()))) {

				//チェックOKの場合、更新
				idolMainShintaku = form.convertToIdolMainShintakuForUpdate(idolMainShintaku);
				return idolMainShintakuRepository.saveAndFlush(idolMainShintaku);
			}
		}
		return null;
	}

	@Override
	public void deleteIdolById(final long id) {

		//更新対象のレコードを取得する
		IdolMainShintaku idolMainShintaku = idolMainShintakuRepository.findOne(id);
		if(idolMainShintaku != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			idolMainShintakuRepository.delete(id);
		}
	}

	@Override
	public void deleteIdolComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		idolMainShintakuRepository.deleteComp(ids);
	}
}
