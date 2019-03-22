package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.catNihonyanagi.CatMainNihonyanagi;
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.CharacterNihonyanagi;
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.HairNihonyanagi;
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.SizeNihonyanagi;
import jp.co.futureantiques.webapptraining.model.form.catNihonyanagi.CatInputForm;
import jp.co.futureantiques.webapptraining.model.form.catNihonyanagi.CatSearchForm;

/**
 * Catのサービスインターフェース
 * @author Nihonyanagi
 *
 */
public interface CatNihonyanagiService {

	/**
	 * 被毛エンティティのリストを取得する
	 *
	 * @return HairEntityのリスト
	 */
	List<HairNihonyanagi> getListHairNihonyanagi();

	/**
	 * 大きさエンティティのリストを取得する
	 * @return SizeEntityのリスト
	 */
	List<SizeNihonyanagi> getListSizeNihonyanagi();

	/**
	 * 性格エンティティのリストを取得する
	 * @return CharacterEntityのリスト
	 */
	List<CharacterNihonyanagi> getListCharacterNihonyanagi();

	/**
	 * 検索条件を元にCatMainNihonyanagiのレコードのリストを取得する(Paging)
	 *
	 * @param CatNihonyanagiSearchForm form
	 * @param Pageable pageable
	 * @return CatMainNihonyanagiのリスト
	 */
	Page<CatMainNihonyanagi> getPageCat(final CatSearchForm  form, final Pageable pageable);

	/**
	 * 検索条件を元にCatMainNihonyanagiのレコードのリストを取得する
	 *
	 * @param CatSearchForm form
	 * @return CatMainNihonyanagiのリスト
	 */
	List<CatMainNihonyanagi> getListCat(final CatSearchForm form);

	/**
	 * IDをキーにCatMainNihonyanagiのレコードを取得する
	 *
	 * @param long id
	 * @return CatMainNihonyanagiのレコード
	 */
	CatMainNihonyanagi getCat(final long id);

	/**
	 * CatMainNihonyanagiにレコードを新規登録する
	 * @param CatInputForm form
	 * @return CatMain
	 */
	CatMainNihonyanagi insertCat(final CatInputForm form);

	/**
	 * CatMainNihonyanaのレコードを更新する
	 * @param CatInputForm form
	 * @return CatMainNihonyanagi
	 */
	CatMainNihonyanagi updateCat(final CatInputForm form);

	/**
	 * CatMainNihonyanagiのレコードを論理削除する
	 * @param long id
	 */
	void deleteCatById(final long id);

	/**
	 * CatMainNihonyanagiのレコードを物理削除する
	 * @param ArrayList<Long> ids
	 */
	void deleteCatComp(final ArrayList<Long> ids);

}
