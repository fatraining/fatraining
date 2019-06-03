package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.spaOkabe.SpaOkabeInputForm;
import jp.co.futureantiques.webapptraining.model.form.spaOkabe.SpaOkabeSearchForm;
import jp.co.futureantiques.webapptraining.model.spaOkabe.AreaOkabe;
import jp.co.futureantiques.webapptraining.model.spaOkabe.QualityOkabe;
import jp.co.futureantiques.webapptraining.model.spaOkabe.SpaMainOkabe;

/**
 *SpaOkabeのサービスインターフェース
 *
 * @author SEIYA OKABE
 */

public interface SpaOkabeService {

	/**
	 * 都道府県エンティティのリストを取得する
	 *
	 * @return AreaOkabeEntityのリスト
	 */
	List<AreaOkabe> getListAreaOkabe();

	/**
	 * 泉質エンティティのリストを取得する
	 *
	 * @return QualityOkabeEntityのリスト
	 */
	List<QualityOkabe> getListQualityOkabe();

	/**
	 * 検索条件を元にSpaMainのレコードのリストを取得する(Paging)
	 *
	 * @param SpaOkabeSearchForm form
	 * @param Pageable pageable
	 * @return SpaMainOkabeのリスト
	 */
	Page<SpaMainOkabe> getPageSpa(final SpaOkabeSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にSpaMainOkabeのレコードのリストを取得する
	 *
	 * @param SpaOkabeSearchForm form
	 * @return SpaMainOkabeのリスト
	 */
	List<SpaMainOkabe> getListSpaMainOkabe(final SpaOkabeSearchForm form);

	/**
	 * IDをキーにSpaMainOkabeのレコードを取得する
	 *
	 * @param long id
	 * @return SpaMainOkabeのレコード
	 */
	SpaMainOkabe getSpaMainOkabe(final long id);

	/**
	 * SpaMainOkabeにレコードを新規登録する
	 *
	 * @param SpaOkabeInputForm form
	 * @return SpaMainOkabe
	 */
	SpaMainOkabe insertSpa(final SpaOkabeInputForm form);

	/**
	 * SpaMainのレコードを更新する
	 *
	 * @param SpaOkabeInputForm form
	 * @return SpaMainOkabe
	 */
	SpaMainOkabe updateSpa(final SpaOkabeInputForm form);

	/**
	 * SpaMainOkabeのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteSpaById(final long id);

	/**
	 * MovieMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteSpaComp(final ArrayList<Long> ids);

}
