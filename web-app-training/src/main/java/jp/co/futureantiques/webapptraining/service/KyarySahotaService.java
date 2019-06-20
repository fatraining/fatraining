package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.kyarySahota.KyarySahotaInputForm;
import jp.co.futureantiques.webapptraining.model.form.kyarySahota.KyarySahotaSearchForm;
import jp.co.futureantiques.webapptraining.model.kyarySahota.CdNameSahota;
import jp.co.futureantiques.webapptraining.model.kyarySahota.CdTypeSahota;
import jp.co.futureantiques.webapptraining.model.kyarySahota.KyaryMainSahota;

/**
 * KyarySahotaのサービスインターフェース
 *
 * @author futureantiques
 */
public interface KyarySahotaService {

	/**
	 * CD名エンティティのリストを取得する
	 *
	 * @return CdNameSahotaEntityのリスト
	 */
	List<CdNameSahota> getListCdNameSahota();

	/**
	 * CD形態エンティティのリストを取得する
	 *
	 * @return CdTypeEntityのリスト
	 */
	List<CdTypeSahota> getListCdTypeSahota();

	/**
	 * 検索条件を元にKyaryMainSahotaのレコードのリストを所得する(Paging)
	 *
	 * @param KyarySahotaSearchForm form
	 * @param Pageable pageable
	 * @return KyaryMainSahotaのリスト
	 */
	Page<KyaryMainSahota> getPageKyarySahota(final KyarySahotaSearchForm form,final Pageable pageable);

	/**
	 * 検索条件を元にKyaryMainSahotaのレコードリストを取得する
	 *
	 * @param KyarySahotaSearchForm form
	 * @return KyaryMainSahotaのリスト
	 */
	List<KyaryMainSahota> getListKyarySahota(final KyarySahotaSearchForm form);

	/**
	 * IDをキーにKyaryMainのレコードを取得する
	 *
	 *@param long id
	 *@return KyaryMainSahotaのレコード
	 */
	KyaryMainSahota getKyarySahota(final long id);

	/**
	 * KyaryMainSahotaにレコードを新規登録する
	 *
	 * @param KyarySahotaInputForm form
	 * @return KyaryMainSahota
	 */
	KyaryMainSahota insertKyarySahota(final KyarySahotaInputForm form);

	/**
	 * KyaryMainのレコードを更新する
	 *
	 * @param KyarySahotaInputForm form
	 * @return KyaryMainSahota
	 */
	KyaryMainSahota updateKyarySahota(final KyarySahotaInputForm form);

	/**
	 * KyaryMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteKyarySahotaById(final long id);

	/**
	 * KyaryMainSahotaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteKyarySahotaComp(final ArrayList<Long> ids);
}
