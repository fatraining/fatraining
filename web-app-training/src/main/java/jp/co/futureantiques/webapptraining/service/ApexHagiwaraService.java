package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.AmmoHagiwara;
import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.ApexMainHagiwara;
import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.WeaponKindHagiwara;
import jp.co.futureantiques.webapptraining.model.form.apexWeaponHagiwara.ApexInputForm;
import jp.co.futureantiques.webapptraining.model.form.apexWeaponHagiwara.ApexSearchForm;

/**
 * ApexWeaponHagiwaraのサービスインターフェース
 *
 * @author Hagiwara
 */
public interface ApexHagiwaraService {

	/**
	 * 武器種エンティティのリストを取得する
	 *
	 * @return WeaponKindHagiwaraEntityのリスト
	 */
	List<WeaponKindHagiwara> getListWeaponKindHagiwara();

	/**
	 * 使用アモエンティティのリストを取得する
	 *
	 * @return AmmoHagiwaraEntityのリスト
	 */
	List<AmmoHagiwara> getListAmmoHagiwara();

	/**
	 * 検索条件を元にApexMainのレコードのリストを取得する(Paging)
	 *
	 * @param apexSearchForm form
	 * @param Pageable pageable
	 * @return ApexMainHagiwaraのリスト
	 */
	Page<ApexMainHagiwara> getPageApex(final ApexSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にApexMainHagiwaraのレコードのリストを取得する
	 *
	 * @param ApexSearchForm form
	 * @return ApexMainHagiwaraのリスト
	 */
	List<ApexMainHagiwara> getListApex(final ApexSearchForm form);

	/**
	 * IDをキーにApexMainHagiwaraのレコードを取得する
	 *
	 * @param long id
	 * @return ApexMainHagiwaraのレコード
	 */
	ApexMainHagiwara getApex(final long id);

	/**
	 * ApexMainHagiwaraにレコードを新規登録する
	 *
	 * @param ApexInputForm form
	 * @return MovieMain
	 */
	ApexMainHagiwara insertApex(final ApexInputForm form);

	/**
	 * ApexMainHagiwaraのレコードを更新する
	 *
	 * @param ApexInputForm form
	 * @return ApexMainHagiwara
	 */
	ApexMainHagiwara updateApex(final ApexInputForm form);

	/**
	 * ApexMainHagiwaraのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteApexById(final long id);

	/**
	 * ApexMainHagiwaraのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteApexComp(final ArrayList<Long> ids);
}