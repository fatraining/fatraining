package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.eggsekine.EggMain;

public interface EggSekineService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreEntityのリスト
	 */
	List<Genre> getListGenre();

	/**
	 * 映画俳優エンティティのリストを取得する
	 *
	 * @return eggActorEntityのリスト
	 */
	List<EggActor> getListeggActor();

	/**
	 * 検索条件を元にeggMainのレコードのリストを取得する(Paging)
	 *
	 * @param eggSearchForm form
	 * @param Pageable pageable
	 * @return eggMainのリスト
	 */
	Page<EggMain> getPageegg(final eggSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にeggMainのレコードのリストを取得する
	 *
	 * @param eggSearchForm form
	 * @return eggMainのリスト
	 */
	List<EggMain> getListegg(final eggSearchForm form);

	/**
	 * IDをキーにeggMainのレコードを取得する
	 *
	 * @param long id
	 * @return eggMainのレコード
	 */
	EggMain getegg(final long id);

	/**
	 * eggMainにレコードを新規登録する
	 *
	 * @param eggInputForm form
	 * @return eggMain
	 */
	EggMain insertegg(final eggInputForm form);

	/**
	 * eggMainのレコードを更新する
	 *
	 * @param eggInputForm form
	 * @return eggMain
	 */
	EggMain updateegg(final eggInputForm form);

	/**
	 * eggMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteeggById(final long id);

	/**
	 * eggMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteeggComp(final ArrayList<Long> ids);

}
