package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.danmachi.Danmachi;
import jp.co.futureantiques.webapptraining.model.danmachi.Fami;
import jp.co.futureantiques.webapptraining.model.danmachi.Race;
import jp.co.futureantiques.webapptraining.model.form.danmachiWang.DanmachiInputForm;
import jp.co.futureantiques.webapptraining.model.form.danmachiWang.DanmachiSearchForm;
/**
 * Danmachiのサービスインターフェース
 *
 * @author Wang
 */
public interface DanmachiService {
	/**
	 *ファミリアエンティティのリストを取得する
	 *
	 *@return Famiエンティティのリスト
	 */
	List<Fami> getListFami();
	/**
	 *種族エンティティのリストを取得する
	 *
	 *@return Raceエンティティのリスト
	 */
	List<Race> getListRace();

	/**
	 *検索結果を元にDanmachiのレコードリストを取得する(paging)
	 *
	 *@param DanmachiSearchForm form
	 *@param Pageable pageable
	 *@return Danmachiのリスト
	 */
	Page<Danmachi> getPageDanmachi(final DanmachiSearchForm form, final Pageable pageable);

	/**
	 *検索結果を元にDanmachiのレコードリストを取得する
	 *
	 *@param DanmachiSearchForm form
	 *@return Danmachiのリスト
	 *
	 */
	List<Danmachi> getListDanmachi(final DanmachiSearchForm form);

	/**
	 *IDをキーにDanmachiのレコードを取得する
	 *
	 *@param long  id
	 *@return Danmachiのレコード
	 */
	Danmachi getDanmachi(final long id);

	/**
	 *Danmachiにレコードを新規登録する
	 *
	 *@param DanmachiInputForm form
	 *@return Danmachi
	 */
	Danmachi insertDanmachi(final DanmachiInputForm form);

	/**
	 *Danmachiのレコードを更新する
	 *
	 * @param  DanmachiInputForm form
	 * @rerurn Danmachi
	 */
	Danmachi updateDanmachi(final DanmachiInputForm form);

	/**
	 * Danmachiのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteDanmachiById(final long id);

	/**
	 *Danmachiのレコードを物理削除する
	 *
	 * @param ArrayList<Long>ids
	 */
	void deleteDanmachiComp(final ArrayList<Long> ids);
}
