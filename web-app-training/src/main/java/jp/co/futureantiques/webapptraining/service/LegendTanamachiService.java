package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.ClassTanamachi;
import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.FromTanamachi;
import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.LegendMainTanamachi;
import jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi.LegendInputForm;
import jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi.LegendSearchForm;

/**
 * LegendTanamachiサービスのインターフェース
 *
 * @author future
 */
public interface LegendTanamachiService {

	/**
	 * 出身地のエンティティのリストを取得する
	 *
	 * @return FromTanamachiEntityのリスト
	 */
	List<FromTanamachi> getListFromTanamachi();

	/**
	 * クラスのエンティティのリストを取得する
	 *
	 * @return ClassTanamachiEntityのリスト
	 */
	List<ClassTanamachi> getListClassTanamachi();

	/**
	 * 検索条件をもとにLegendMainTanamachiのレコードのリストを取得する（Paging）
	 * @param LegendSearchForm form
	 * @param Pageable pageable
	 * @return LegendMainTanamachiのリスト
	 */
	Page<LegendMainTanamachi> getPageLegend(LegendSearchForm form, Pageable pageable);

	/**
	 * 検索条件を元にLegendMainTanamachiのレコードのリストを取得する
	 *
	 * @param LegendSearchForm form
	 * @return LegendMainTanamachiのリスト
	 */
	List<LegendMainTanamachi> getListLegend(final LegendSearchForm form);

	/**
	 * IDをキーにLegendMainTanamachiのレコードを取得する
	 * @param long legendId
	 * @return LegendMainTanamachiのレコード
	 */
	LegendMainTanamachi getLegend(final long id);

	/**
	 * LegendMainTanamachiにレコードを新規登録する
	 *
	 * @param LegendInputForm form
	 * @return LegendMainTanamachi
	 */
	LegendMainTanamachi insertLegend(LegendInputForm form);

	/**
	 * LegendMainTanamachiのレコードを更新する
	 *
	 * @param LegendInputForm form
	 * @return LegendMainTanamachi
	 */
	LegendMainTanamachi updateLegend(final LegendInputForm form);

	/**
	 * LegendMainTanamachiのレコードを論理削除する
	 *
	 * @param long legendId
	 */
	void deleteLegendById(final long legendId);

	/**
	 * LegendMainTanamachiのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteLegendComp(ArrayList<Long> ids);

}
