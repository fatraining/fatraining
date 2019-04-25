package jp.co.futureantiques.webapptraining.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.yuruYokoyama.YuruInputForm;
import jp.co.futureantiques.webapptraining.model.form.yuruYokoyama.YuruSearchForm;
import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruBelongYokoyama;
import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruDataYokoyama;
import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruFromYokoyama;

/**
 * YuruDataeのサービスインターフェース
 *
 * @author future
 */
public interface YuruYokoyamaService {

	/**
	 * 所属エンティティのリストを取得する
	 *
	 * @return YuruBelongEntityのリスト
	 */
	List<YuruBelongYokoyama> getListYuruBelongYokoyama();

	/**
	 * 出身エンティティのリストを取得する
	 *
	 * @return YuruFromEntityのリスト
	 */
	List<YuruFromYokoyama> getListYuruFromYokoyama();

	/**
	 * 検索条件を元にYuruDataのレコードのリストを取得する(Paging)
	 *
	 * @param YuruSearchForm form
	 * @param Pageable pageable
	 * @return YuruDataのリスト
	 */
	Page<YuruDataYokoyama> getPageYuru(final YuruSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にYuruDataのレコードのリストを取得する
	 *
	 * @param YuruSearchForm form
	 * @return YuruDataのリスト
	 */
	List<YuruDataYokoyama> getListYuruDataYokoyama(final YuruSearchForm form);

	/**
	 * IDをキーにYuruDataのレコードを取得する
	 *
	 * @param long id
	 * @return YuruDataのレコード
	 */
	YuruDataYokoyama getYuruDataYokoyama(final long id);

	/**
	 * YuruDataにレコードを新規登録する
	 *
	 * @param YuruSearchForm form
	 * @return YuruData
	 */
	YuruDataYokoyama insertYuru(final YuruInputForm form);

	/**
	 * YuruDataのレコードを更新する
	 *
	 * @param YuruSearchForm form
	 * @return YuruData
	 */
	YuruDataYokoyama updateYuru(final YuruInputForm form);

	/**
	 * YuruDataのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteYuruById(final long id);

	/**
	 * YuruDataのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteYuruComp(final ArrayList<Long> ids);
}
