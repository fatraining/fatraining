package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyAreaIto;
import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyMainIto;
import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyParkIto;
import jp.co.futureantiques.webapptraining.model.form.disneyIto.DisneyItoInputForm;
import jp.co.futureantiques.webapptraining.model.form.disneyIto.DisneyItoSearchForm;

/**
 * DisneyItoのサービスインターフェース
 *
 * @author Ayaka Ito
 */

public interface DisneyItoService {

	/**
	 * パークエンティティのリストを取得する
	 *
	 * @return ParkItoEntityのリスト
	 */
	List<DisneyParkIto> getListDisneyParkIto();

	/**
	 * エリアエンティティのリストを取得する
	 *
	 * @return AreaSecontItoEntityのリスト
	 */
	List<DisneyAreaIto> getListDisneyAreaIto();

	/**
	 * 検索条件を元にDisneyMainItoのレコードのリストを取得する(Paging)
	 *
	 * @param DisneyItoSearchForm form
	 * @param Pageable pageable
	 * @return DisneyMainItoのリスト
	 */
	Page<DisneyMainIto> getPageDisney(final DisneyItoSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にDisneyMainItoのレコードのリストを取得する
	 *
	 * @param DisneyItoSearchForm form
	 * @return DisneyMainItoのリスト
	 */
	List<DisneyMainIto> getListDisney(final DisneyItoSearchForm form);

	/**
	 * IDをキーにDisneyMainItoのレコードを取得する
	 *
	 * @param long id
	 * @return DisneyMainItoのレコード
	 */
	DisneyMainIto getDisney(final long id);

	/** DisneyMainItoにレコードを新規登録する
	 * @param DisneyInputForm form
	 */
	DisneyMainIto insertDisney(final DisneyItoInputForm form);

	/**
	 * DisneyMainItoのレコードを更新する
	 * @param DisneyInputForm form
	 * @return DisneyMainIto
	 */
	DisneyMainIto updateDisney(final DisneyItoInputForm form);

	/**
	 * DisneyMainItoのレコードを論理削除する
	 * @param long id
	 * @return DisneyMainIto
	 */
	void deleteDisneyById(final long id);

	/**
	 * DisneyMainItoのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 *  @return DisneyMainIto
	 */
	void deleteDisneyComp(final ArrayList<Long> ids);
}
