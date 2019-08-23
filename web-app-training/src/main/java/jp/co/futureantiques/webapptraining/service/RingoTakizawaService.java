package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.ringoTakizawa.RingoTakizawaInputForm;
import jp.co.futureantiques.webapptraining.model.form.ringoTakizawa.RingoTakizawaSearchForm;
import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoCdTitleTakizawa;
import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoMainTakizawa;
import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoSongImageTakizawa;


/**
 *RingoTakizawa(Specification)のサービスインターフェース
 *
 * @author Mai Takizawa
 */

public interface RingoTakizawaService {

	/**
	 * CD名エンティティのリストを取得する
	 *
	 * @return RingoCdTitleTakizawaEntityのリスト
	 */
	List<RingoCdTitleTakizawa> getRingoCdTitleTakizawa();

	/**
	 * 聞きたい気分のリストを取得する
	 *
	 * @return RingoSongImageTakizawaEntityのリスト
	 */
	List<RingoSongImageTakizawa> getRingoSongImageTakizawa();

	/**
	 * 検索条件を元にRingoMainTakizawaのレコードのリストを取得する(Paging)
	 *
	 * @param RingoTakizawaSearchForm form
	 * @param Pageable pageable
	 * @return RingoMainTakizawaのリスト
	 */
	Page<RingoMainTakizawa> getPageRingo(final RingoTakizawaSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にRingoMainTakizawaのレコードのリストを取得する
	 *
	 * @param RingoTakizawaSearchForm form
	 * @return RingoMainTakizawaのリスト
	 */
	List<RingoMainTakizawa> getListRingoMainTakizawa(final RingoTakizawaSearchForm form);

	/**
	 * IDをキーにRingoMainTakizawaのレコードを取得する
	 *
	 * @param long id
	 * @return RingoMainTakizawaのレコード
	 */
	RingoMainTakizawa getRingoMainTakizawa(final long id);

	/**
	 * RingoMainTakizawaにレコードを新規登録する
	 *
	 * @param RingoTakizawaInput form
	 * @return RingoMainTakizawa
	 */
	RingoMainTakizawa insertRingo(final RingoTakizawaInputForm form);

	/**
	 * RingoMainTakizawaのレコードを更新する
	 *
	 * @param RingoTakizawaInput form
	 * @return RingoMainTakizawa
	 */
	RingoMainTakizawa updateRingo(final RingoTakizawaInputForm form);

	/**
	 * RingoMainTakizawaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteRingoById(final long id);

	/**
	 * RingoMainTakizawaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteRingoComp(final ArrayList<Long> ids);




	//以下、追加部分
	List<RingoCdTitleTakizawa> getListRingoCdTitleTakizawa();

	List<RingoSongImageTakizawa> getListRingoSongImageTakizawa();



}
