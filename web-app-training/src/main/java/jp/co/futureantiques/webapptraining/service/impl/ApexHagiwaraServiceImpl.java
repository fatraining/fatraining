package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.AmmoHagiwara;
import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.ApexMainHagiwara;
import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.WeaponKindHagiwara;
import jp.co.futureantiques.webapptraining.model.form.apexWeaponHagiwara.ApexInputForm;
import jp.co.futureantiques.webapptraining.model.form.apexWeaponHagiwara.ApexSearchForm;
import jp.co.futureantiques.webapptraining.repository.apexWeaponHagiwara.AmmoHagiwaraRepository;
import jp.co.futureantiques.webapptraining.repository.apexWeaponHagiwara.ApexMainHagiwaraRepository;
import jp.co.futureantiques.webapptraining.repository.apexWeaponHagiwara.WeaponKindHagiwaraRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ApexHagiwaraSpecification;
import jp.co.futureantiques.webapptraining.service.ApexHagiwaraService;

/**
 * ApexweaponHagiwaraのサービス実装クラス
 *
 * @author Hagiwara
 */
@Service
public class ApexHagiwaraServiceImpl implements ApexHagiwaraService {

	/** MovieMainリポジトリ */
	private final ApexMainHagiwaraRepository apexMainHagiwaraRepository;

	/** Genreリポジトリ */
	private final WeaponKindHagiwaraRepository weaponKindHagiwaraRepository;

	/** MovieActorリポジトリ */
	private final AmmoHagiwaraRepository ammoHagiwaraRepository;

	/**
	 * コンストラクタ
	 *
	 * @param ApexMainHagiwaraRepository apexMainHagiwaraRepository
	 * @param WeaponKindHagiwaraRepository weaponKindHagiwaraRepository
	 * @param AmmoHagiwaraRepository ammoHagiwaraRepository
	 */
	@Autowired
	public ApexHagiwaraServiceImpl(ApexMainHagiwaraRepository apexMainHagiwaraRepository,
			WeaponKindHagiwaraRepository weaponKindHagiwaraRepository,
			AmmoHagiwaraRepository ammoHagiwaraRepository) {
		this.apexMainHagiwaraRepository = apexMainHagiwaraRepository;
		this.weaponKindHagiwaraRepository = weaponKindHagiwaraRepository;
		this.ammoHagiwaraRepository = ammoHagiwaraRepository;
	}

	@Override
	public List<WeaponKindHagiwara> getListWeaponKindHagiwara() {

		// weaponKindHagiwaraテーブルのレコードをID順に取得する
		return weaponKindHagiwaraRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<AmmoHagiwara> getListAmmoHagiwara() {

		// AmmoHagiwaraテーブルのレコードをID順に取得する
		return ammoHagiwaraRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<ApexMainHagiwara> getPageApex(final ApexSearchForm form, final Pageable pageable) {

		// 検索条件を生成しApexMainHagiwaraテーブルのレコードを取得する
		return apexMainHagiwaraRepository.findAll(ApexHagiwaraSpecification.generateApexSpecification(form), pageable);
	}

	@Override
	public List<ApexMainHagiwara> getListApex(final ApexSearchForm form) {

		// 検索条件を生成しApexMainHagiwaraテーブルのレコードを取得する
		return apexMainHagiwaraRepository.findAll(ApexHagiwaraSpecification.generateApexSpecification(form));
	}

	@Override
	public ApexMainHagiwara getApex(final long id) {

		// ApexMainHagiwaraテーブルを主キー検索する
		return apexMainHagiwaraRepository.findOne(id);
	}

	@Override
	public ApexMainHagiwara insertApex(final ApexInputForm form) {

		// ApexMainHagiwaraテーブルに新規でデータを登録する
		final ApexMainHagiwara apexMainHagiwara = form.convertToApexMainHagiwaraForInsert();
		return apexMainHagiwaraRepository.save(apexMainHagiwara);
	}

	@Override
	public ApexMainHagiwara updateApex(final ApexInputForm form) {

		// 更新対象のレコードを取得する
		ApexMainHagiwara apexMainHagiwara = apexMainHagiwaraRepository.findOne((long) form.getId());
		if (apexMainHagiwara != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(apexMainHagiwara.getUpdateDate()))) {

				// チェックOKの場合、更新
				apexMainHagiwara = form.convertToApexMainHagiwaraForUpdate(apexMainHagiwara);
				return apexMainHagiwaraRepository.saveAndFlush(apexMainHagiwara);
			}
		}
		return null;
	}

	@Override
	public void deleteApexById(final long id) {

		// 更新対象のレコードを取得する
		ApexMainHagiwara movieMain = apexMainHagiwaraRepository.findOne(id);
		if (movieMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			apexMainHagiwaraRepository.delete(id);
		}
	}

	@Override
	public void deleteApexComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		apexMainHagiwaraRepository.deleteComp(ids);
	}
}