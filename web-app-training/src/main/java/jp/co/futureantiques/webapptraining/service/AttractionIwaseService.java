package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.attractioniwase.AttractionMain;
import jp.co.futureantiques.webapptraining.model.attractioniwase.Themeparkiwase;
import jp.co.futureantiques.webapptraining.model.form.attractioniwase.AttractionIwaseInputForm;
import jp.co.futureantiques.webapptraining.model.form.attractioniwase.AttractionIwaseSearchForm;

/**
 * AtrractionIwaseのサービスインターフェース
 *
 * @author future
 */
public interface AttractionIwaseService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return ThemeparkEntityのリスト
	 */
	List<Themeparkiwase> getListThemepark();

	/**
	 * 検索条件を元にAttractionMainのレコードのリストを取得する(Paging)
	 *
	 * @param AttractionIwaseSearchForm form
	 * @param Pageable pageable
	 * @return AttractionMainのリスト
	 */
	Page<AttractionMain> getPageAttraction(final AttractionIwaseSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にAttractionMainのレコードのリストを取得する
	 *
	 * @param AttractionIwaseSearchForm form
	 * @return AttractionMainのリスト
	 */
	 List<AttractionMain> getListAttraction(final AttractionIwaseSearchForm form) ;

	/**
	 * IDをキーにAttractionMainのレコードを取得する
	 *
	 * @param long id
	 * @return AttractionMainのレコード
	 */
	AttractionMain getAttraction(final long id);

	/**
	 * AttractionMainにレコードを新規登録する
	 *
	 * @param AttractionIwaseInputForm form
	 * @return AttractionMain
	 */
	AttractionMain insertAttraction(final AttractionIwaseInputForm form);

	/**
	 * AttractionMainのレコードを更新する
	 *
	 * @param AttractionIwaseInputForm form
	 * @return AttractionMain
	 */
	AttractionMain updateAttraction(final AttractionIwaseInputForm form);

	/**
	 * AttractionMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteAttractionById(final long id);

	/**
	 * AttractionMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	 void deleteAttractionComp(final ArrayList<Long> ids);
}