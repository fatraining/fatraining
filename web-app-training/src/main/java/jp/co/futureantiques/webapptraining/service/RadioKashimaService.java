package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.radioKashima.RadioKashimaInputForm;
import jp.co.futureantiques.webapptraining.model.form.radioKashima.RadioKashimaSearchForm;
import jp.co.futureantiques.webapptraining.model.radioKashima.KeystationKashima;
import jp.co.futureantiques.webapptraining.model.radioKashima.RadioMainKashima;


/**
 * RadioKashimaのサービスインターフェイス
 * @author kashima
 *
 */
public interface RadioKashimaService {

	/**
	 * 放送局エンティティのリストを取得する
	 *
	 * @return KeystationKashimaEntityのリスト
	 */
	List<KeystationKashima> getListKeystationKashima();


	/**
	 * 検索条件を元にRadioMainKashimaのレコードのリストを取得する
	 *
	 * @param RadioSerchForm form
	 * @param Pageble pageble
	 * @return RadioMainKashimaのリスト
	 */
	Page<RadioMainKashima> getPageRadioKashima(final RadioKashimaSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にRadioMainKashimaのレコードを取得する
	 *
	 * @param RadioKashimaSearchForm form
	 * @return  RadioMainKashimaのリスト
	 */
	List<RadioMainKashima> getListRadioKashima(final RadioKashimaSearchForm form);

	/**
	 * IDをキーにRadioMainKashimaのレコードを取得する
	 *
	 * @param ling id
	 * @return RadioMainKashima
	 */
	RadioMainKashima getRadioKashima(final long id);

	/**
	 * RadioMainKashimaにレコードを新規作成する
	 *
	 * @param RadioKashimaInputForm form
	 * @return RadioMainKashima
	 */
	RadioMainKashima insertRadioKashima(final RadioKashimaInputForm form);

	/**
	 * RadioMainKashimaのレコードを更新する
	 * @param RadioKashimaInputForm form
	 * @return RadioKashima
	 */
	RadioMainKashima updateRadioKashima(final RadioKashimaInputForm form);

	/**
	 * RadioMainのレコードを論理削除する
	 *
	 * @param long
	 */
	void deleteRadioKashimaById(final long id);

	/**
	 * RadioMainKashimaのレコードを物理削除する
	 * @param ArrayList<Long> ids
	 */
	void deleteRadioKashimaComp(final ArrayList<Long> ids);

}
