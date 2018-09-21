package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.Electronics.BrandIto;
import jp.co.futureantiques.webapptraining.model.Electronics.CategoryIto;
import jp.co.futureantiques.webapptraining.model.Electronics.ElectronicsMainIto;
import jp.co.futureantiques.webapptraining.model.form.electronicsIto.ElectronicsInputForm;
import jp.co.futureantiques.webapptraining.model.form.electronicsIto.ElectronicsSearchForm;

/**
 * electricsMainのサービスインターフェース
 *
 * @author AIRI ITO
 *
 */
@Service
public interface ElectronicsItoService {

	/**
	 * カテゴリーエンティティのリストを取得する
	 *
	 * @return Categoryエンティティのリスト
	 */
	List<CategoryIto> getListCategory();


	/**
	 * ブランドエンティティのリストを取得する
	 *
	 * @return Brandエンティティのリスト
	 */
	List<BrandIto> getListBrand();


	/**
	 * 検索条件を元にelectricsMainのレコードリストを取得する(Paging)
	 *
	 * @param electricsSearchForm form
	 * @param Pageable pageable
	 * @return ElectricsMainのリスト
	 */
	Page<ElectronicsMainIto> getPageProduct(final ElectronicsSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にelectricsMainのレコードのリストを取得する
	 *
	 *@param ElectricsSearchForm form
	 *@return ElectricsMainのレコード
	 */

	List<ElectronicsMainIto> getListProduct(final ElectronicsSearchForm form);

	/**
	 * IDをキーにElectronicsMainのレコードを取得する
	 * @param id
	 * @return
	 */
	ElectronicsMainIto getProduct(final long id);

	/**
	 * electricsMainにレコードを新規登録する
	 *
	 * @param ElectricsInputForm form
	 * @return ElectricsMain
	 */
	ElectronicsMainIto insertProduct(final ElectronicsInputForm form);

	/**
	 * ElectricsMainのレコードを更新する
	 *
	 * @param ElectricInputForm form
	 * @return ElectricsMain
	 */
	ElectronicsMainIto updateProduct(final ElectronicsInputForm form);

	/**
	 * MovieMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteProductById(final long id);

	/**
	 * ElectricsMainのレコードを物理削除する
	 *
	 * @param ArrayList<long> ids
	 */
	void deleteProductComp(final ArrayList<Long> ids);

}
