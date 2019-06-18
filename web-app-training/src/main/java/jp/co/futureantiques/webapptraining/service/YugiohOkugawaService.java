package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa.YugiohOkugawaInputForm;
import jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa.YugiohOkugawaSearchForm;
import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.DeckOkugawa;
import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.SeriesOkugawa;
import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.YugiohMainOkugawa;

/**
 * YugiohOkugawaのサービスインターフェース
 * @author Okugawa
 *
 */
public interface YugiohOkugawaService {

	/**
	 * 作品エンティティのリストを取得
	 * @return SeriesOkugawaEntityのリスト
	 */
	List<SeriesOkugawa> getListSeriesOkugawa();

	/**
	 * デッキのエンティティのリストを取得
	 * @return DeckOkugawa
	 */
	List<DeckOkugawa> getListDeckOkugawa();

	/**
	 * 検索条件をもとにYugiohMainOkugawaのレコードリストを取得(paging)
	 *
	 * @param YugiohOkugawaSearchForm form
	 * @param Pageble pageble
	 * @return YugiohMainOkugawaのリスト
	 */
	Page<YugiohMainOkugawa> getPageYugiohOkugawa(final YugiohOkugawaSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にYugiohMainOkugawaのレコードのリストを取得する
	 *
	 * @param long id
	 * @return YugiohMainのレコード
	 */
	List<YugiohMainOkugawa> getListYugiohOkugawa(final YugiohOkugawaSearchForm form);

	/**
	 * IDをキーにYugiohMainOkugawaのレコードを取得する
	 *
	 * @param long id
	 * @return YugiohMainOkugawaのレコード
	 */
	YugiohMainOkugawa getYugiohOkugawa(final long id);

	/**
	 * YugiohMainOkugawaにレコードを新規登録する
	 *
	 * @param YugiohOkugawaInputForm form
	 * @return YugiohMainOkugawa
	 */
	YugiohMainOkugawa insertYugiohOkugawa(final YugiohOkugawaInputForm form);

	/**
	 * yugiohMainOkugawaのレコードを更新する
	 *
	 * @param YugiohOkugawaInputForm form
	 * @return YugiohMainOkugawa
	 */
	YugiohMainOkugawa updateYugiohOkugawa(final YugiohOkugawaInputForm form);

	/**
	 *YugiohMainOkugawaのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteYugiohOkugawaById(final long id);

	/**
	 * YugiohMainOkugawaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteYugiohOkugawaComp(final ArrayList<Long> ids);

}

