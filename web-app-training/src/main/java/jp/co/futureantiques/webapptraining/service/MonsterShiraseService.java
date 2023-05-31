package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.monsterShirase.MonsterShiraseInputForm;
import jp.co.futureantiques.webapptraining.model.form.monsterShirase.MonsterShiraseSearchForm;
import jp.co.futureantiques.webapptraining.model.monsterShirase.ElementShirase;
import jp.co.futureantiques.webapptraining.model.monsterShirase.GenreShirase;
import jp.co.futureantiques.webapptraining.model.monsterShirase.MonsterMainShirase;
import jp.co.futureantiques.webapptraining.model.monsterShirase.TitleShirase;

/**
 * MonsterShiraseのサービスインターフェース
 * @author Shirase
 */

public interface MonsterShiraseService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreShiraseEntityのリスト
	 */
	List<GenreShirase> getListGenreShirase();

	/**
	 * 弱点属性エンティティのリストを取得する
	 *
	 *@return ElementShiraseEntityのリスト
	 */
	List<ElementShirase> getListElementShirase();

	/**
	 * 初登場作品エンティティのリストを取得する
	 *
	 *@return TitleShiraseEntityのリスト
	 */
	List<TitleShirase> getListTitleShirase();

	/**
	 * 検索条件を元にMonsterMainShiraseのレコードのリストを取得する(Paging)
	 *
	 * @param MonsterSerchForm form
	 * @param Pageble pageble
	 * @return MonsterMainShiraseのリスト
	 */
	Page<MonsterMainShirase> getPageMonsterShirase(final MonsterShiraseSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にMonsterMainShiraseのレコードを取得する
	 *
	 * @param MonsterShiraseSearchForm form
	 * @return  MonsterMainShiraseのリスト
	 */
	List<MonsterMainShirase> getListMonsterShirase(final MonsterShiraseSearchForm form);

	/** IDをキーにMonsterMainShiraseのレコードを取得する
	 *
	 * @param long id
	 * @return MonsterMainShiraseのレコード
	 */
	MonsterMainShirase getMonster(final long id);

	/**
	 * MonsterMainShiraseにレコードを新規作成する
	 *
	 * @param MonsterShiraseInputForm monsterShiraseInputForm
	 * @return MonsterMainShirase
	 */
	MonsterMainShirase insertMonster(final MonsterShiraseInputForm monsterShiraseInputForm);

	/**
	 * MonsterMainShiraseのレコードを更新する
	 *
	 * @param MonsterInputForm monsterShiraseInputForm
	 * @return MonsterShirase
	 */
	MonsterMainShirase updateMonster(final MonsterShiraseInputForm monsterShiraseInputForm);

	/**
	 * MonsterMainShiraseのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteMonsterById(final long id);

	/**
	 * MonsterMainShiraseのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteMonsterComp(final ArrayList<Long> ids);
}

