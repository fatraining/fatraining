package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.brandkambara.BrandMainKambara;
import jp.co.futureantiques.webapptraining.model.brandkambara.GenreKambara;
import jp.co.futureantiques.webapptraining.model.brandkambara.MadeCountryKambara;
import jp.co.futureantiques.webapptraining.model.form.brandKambara.BrandKambaraInputForm;
import jp.co.futureantiques.webapptraining.model.form.brandKambara.BrandKambaraSearchForm;

/**
 *BrandKambara(Specification)のサービスインターフェース
 *
 * @author Yuki Kambara
 */

public interface BrandKambaraService {

	/**
	 * ブランド名エンティティのリストを取得する
	 *
	 * @return BrandNameKambaraEntityのリスト
	 */
	List<BrandMainKambara> getBrandNameKambara();

	/**
	 * ジャンルのリストを取得する
	 *
	 * @return GenreKambaraEntityのリスト
	 */
	List<GenreKambara> getGenreKambara();

	/**
	 *
	 * @param BrandKamaraSearchForm form
	 * @param Pageable pageable
	 * @return BrandMainKambaraのリスト
	 */



	Page<BrandMainKambara> getPageBrand(final BrandKambaraSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にBrandMainKambaraのレコードのリストを取得する
	 *
	 * @param BrandKambaraSearchForm form
	 * @return BrandMainKambaraのリスト
	 */
	List<BrandMainKambara> getListBrandMainKambara(final BrandKambaraSearchForm form);

	/**
	 * IDをキーにBrandMainKambaraのレコードを取得する
	 *
	 * @param long id
	 * @return BrandMainKambaraのレコード
	 */
	BrandMainKambara getBrandMainKambara(final long id);

	/**
	 * BrandMainKambaraにレコードを新規登録する
	 *
	 * @param BrandKambaraInput form
	 * @return BrandMainKambara
	 */
	BrandMainKambara insertBrand(final BrandKambaraInputForm form);

	/**
	 * BrandMainKambaraのレコードを更新する
	 *
	 * @param BrandKambaraInput form
	 * @return BrandMainKambara
	 */
	BrandMainKambara updateBrand(final BrandKambaraInputForm form);

	/**
	 *BrandMainKambaraのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteBrandById(final long id);

	/**
	 *BrandMainKambaraのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteBrandComp(final ArrayList<Long> ids);




	//以下、追加部分
	List<GenreKambara> getListGenreKambara();

	List<MadeCountryKambara> getListMadeCountryKambara();





}
