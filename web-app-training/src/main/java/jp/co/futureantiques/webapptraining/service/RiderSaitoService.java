package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.riderSaito.RiderSaitoInputForm;
import jp.co.futureantiques.webapptraining.model.form.riderSaito.RiderSaitoSearchForm;
import jp.co.futureantiques.webapptraining.model.riderSaito.AgeSaito;
import jp.co.futureantiques.webapptraining.model.riderSaito.RiderMainSaito;

/**
 * RiderSaitoのサービスインターフェース
 *
 * @author future
 *
 * */
public interface RiderSaitoService {

	/**
	 * 年代エンティティのリストを取得する
	 *
	 * @return AgeEntityのリスト
	 * */
	List<AgeSaito> getListAge();

	/**
	 * 検索条件を元にRiderMainSaitoのレコードのリスト取得する(paging)
	 *
	 * @param RiderSaitoSerchForm
	 * @param Pageable pageable
	 * @return RiderMainSaitoのリスト
	 * */
	Page<RiderMainSaito> getPageRider(final RiderSaitoSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にRiderMainSaitoのレコードのリストを取得する
	 *
	 * @param RiderSaitoSerchForm
	 * @param RiderMianSaito
	 * */
	List<RiderMainSaito> getListRider(final RiderSaitoSearchForm form);

	/** IDをキーにRiderMainSaitoのレコードを取得する
	 *
	 *  @param long id
	 *	@return RiderMainSaitoのレコード
	 **/
	RiderMainSaito getRider(final long riderId);

	/** RiderMainSaitoにレコードを新規追加する
	 *
	 *@param RiderSaitoInputForm
	 *@return RiderMainSaito
	 * */
	RiderMainSaito insertRider(final RiderSaitoInputForm form);

	/**
	 * RiderMainSaitoをレコードに更新する
	 *
	 * @param RiderSaitoInputForm form
	 * @return RiderMainSaito
	 * */
	RiderMainSaito updateRider(final RiderSaitoInputForm form);

	/**
	 * RiderMainSaitoのレコードを論理削除する
	 *
	 * @param long id
	 * */
	void deleteRiderByRiderId(final long riderId);

	/**
	 * RiderMainSaitoのレコードを物理削除する
	 *
	 * @param ArrayList<Long>riderIds
	 * */
	void deleteRiderComp(final ArrayList<Long> riderIds);
}