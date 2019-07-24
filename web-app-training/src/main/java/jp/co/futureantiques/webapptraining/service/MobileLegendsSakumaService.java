package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.mobileLegendsSakuma.MobileLegendsSakumaInputForm;
import jp.co.futureantiques.webapptraining.model.form.mobileLegendsSakuma.MobileLegendsSakumaSearchForm;
import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.FeatureSakuma;
import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.MobileLegendsMainSakuma;
import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.TypeSakuma;

/**
 * MobileLegendsSakumaのサービスインターフェース
 * @author Sakuma
 *
 */

public interface MobileLegendsSakumaService {

	/**
	 *タイプエンティティのリストを取得
	 *@return TypeSakumaEntityのリスト
	 */
	List<TypeSakuma> getListTypeSakuma();

	/**
	 * 特徴エンティティのリストを取得
	 * @return FeatureSakumaEntityのリスト
	 */
	List<FeatureSakuma> getListFeatureSakuma();

	/**
	 * 検索条件をもとにMobileLegendsMainSakumaのレコードリストを取得(paging)
	 *
	 * @param MobileLegendsSakumaSearchForm form
	 * @param Pageble pageble
	 * @return MobileLegendsMainSakumaのリスト
	 */
	Page<MobileLegendsMainSakuma> getPageMobileLegendsSakuma(final MobileLegendsSakumaSearchForm form, final Pageable pageble);

	/**
	 * 検索条件をもとにMobileLegendsMainSakumaのレコードのリストを取得する
	 *
	 * @param mobileLegendsSakumaSearchForm form
	 * @return MobileLegendsMainのリスト
	 */
	List<MobileLegendsMainSakuma> getListMobileLegendsSakuma(final MobileLegendsSakumaSearchForm form);

	/**
	 * IDをキーにMobileLegendsMainSakumaのレコードを取得する
	 *
	 * @param long id
	 * @return MobileLegendsMainSakumaのレコード
	 */
	MobileLegendsMainSakuma getMobileLegendsSakuma(final long id);

	/**
	 * MobileLegendsMainSakumaにレコードを新規登録する
	 *
	 * @param MobileLegendsSakumaInputForm form
	 * @return MobileLegendsMainSakuma
	 */
	MobileLegendsMainSakuma insertMobileLegendsSakuma(final MobileLegendsSakumaInputForm form);

	/**
	 * MobileLegendsMainSakumaのレコードを更新する
	 *
	 * @param MobileLegendsSakumaInputForm form
	 * @return MobileLegendsMainSakuma
	 */
	<MoblieLegendsInputForm> MobileLegendsMainSakuma updateMobileLegendsSakuma(final MobileLegendsSakumaInputForm form);

	/**
	 * MobileLegendsMainSakumaのレコードを論理削除する
	 *
	 * @parabym long id
	 */
	void deleteMobileLegendsSakumaById(final long id);

	/**
	 * MobileLegendsMainSakumaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteMobileLegendsSakumaComp(final ArrayList<Long> ids);


}
