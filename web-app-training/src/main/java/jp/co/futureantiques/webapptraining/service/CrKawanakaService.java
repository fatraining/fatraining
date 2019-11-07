package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.crKawanaka.CategoryKawanaka;
import jp.co.futureantiques.webapptraining.model.crKawanaka.CrMainKawanaka;
import jp.co.futureantiques.webapptraining.model.crKawanaka.DistributionKawanaka;
import jp.co.futureantiques.webapptraining.model.form.crKawanaka.CrInputForm;
import jp.co.futureantiques.webapptraining.model.form.crKawanaka.CrSearchForm;

/**
 * CrKawanakaサービスのインターフェース
 * @author Misato Kawanaka
 */

public interface CrKawanakaService {

	/*
	 * Categoryエンティティのリストを取得する
	 * @return CategoryKawanakaのエンティティのリスト
	 */
	List<CategoryKawanaka> getListCategoryKawanaka();

	/*
	 * Distributionエンティティのリストを取得する
	 * @return CategoryKawanakaのエンティティのリスト
	 */
	List<DistributionKawanaka> getListDistributionKawanaka();

	/*
	 * 検索結果をもとにCrMainKawanakaのレコードのリストを取得する（Paging）
	 * @param CrSearchForm form
	 * @param Pageable pageable
	 * @return CrMainKawanakaのリスト
	 */
	Page<CrMainKawanaka> getPageCr(final CrSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を基にCrMainKawanakaiのレコードのリストを取得する
	 * @param CrSearchForm form
	 * @return CrMainKawanakaのリスト
	 */
	List<CrMainKawanaka> getListCr(final CrSearchForm form);

	/**
	 * IDをキーにCrMainkawanakaのレコードを取得する
	 *
	 * @param long id
	 * @return CrMainKawanakaのレコード
	 */
	CrMainKawanaka getCr(final long id);

	/**
	 * CrMainKawanakaにレコードを新規登録する
	 * @param CrInputForm form
	 */
	CrMainKawanaka insertCr(final CrInputForm form);

	/**
	 * CrMainKawanakaのレコードを更新する
	 * @param CrInputForm form
	 * @return CrMainKawanaka
	 */
	CrMainKawanaka updateCr(final CrInputForm form);

	/**
	 * CrMainKawanakaのレコードを論理削除する
	 * @param long id
	 * @return CrMainKawanaka
	 */
	void deleteCrById(final long id);

	/**
	 * CrMainKawanakaのレコードを物理削除する
	 * @param ArrayList<Long> ids
	 * @return CrMainKawanaka
	 */
	void deleteCrComp(final ArrayList<Long> ids);
}
