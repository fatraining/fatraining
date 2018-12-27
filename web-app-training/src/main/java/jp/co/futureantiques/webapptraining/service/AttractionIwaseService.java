package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.attractioniwase.AttractionMainIwase;
import jp.co.futureantiques.webapptraining.model.attractioniwase.ThemeparkIwase;
import jp.co.futureantiques.webapptraining.model.form.attractioniwase.AttractionIwaseInputForm;
import jp.co.futureantiques.webapptraining.model.form.attractioniwase.AttractionIwaseSearchForm;

/**
 * AtrractionIwaseのサービスインターフェース
 *
 * @author iwase
 */
public interface AttractionIwaseService {

	/**
	 * テーマパークエンティティのリストを取得する
	 *
	 * @return ThemeparkEntityのリスト
	 */
	List<ThemeparkIwase> getListThemepark();

	/**
	 * 検索条件を元にAttractionMainIwaseのレコードのリストを取得する(Paging)
	 *
	 * @param AttractionIwaseSearchForm form
	 * @param Pageable pageable
	 *
	 * @return AttractionMainIwaseのリスト
	 */
	Page<AttractionMainIwase> getPageAttraction(final AttractionIwaseSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にAttractionMainIwaseのレコードのリストを取得する
	 *
	 * @param AttractionIwaseSearchForm form
	 * @return AttractionMainIwaseのリスト
	 */
	 List<AttractionMainIwase> getListAttraction(final AttractionIwaseSearchForm form) ;

	/**
	 * IDをキーにAttractionMainのレコードを取得する
	 *
	 * @param long id
	 * @return AttractionMainIwaseのレコード
	 */
	AttractionMainIwase getAttraction(final long id);

	/**
	 * AttractionMainにレコードを新規登録する
	 *
	 * @param AttractionIwaseInputForm form
	 * @return AttractionMainIwase
	 */
	AttractionMainIwase insertAttraction(final AttractionIwaseInputForm form);

	/**
	 * AttractionMainのレコードを更新する
	 *
	 * @param AttractionIwaseInputForm form
	 * @return AttractionMainIwase
	 */
	AttractionMainIwase updateAttraction(final AttractionIwaseInputForm form);

	/**
	 * AttractionMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteAttractionById(final long id);

	/**
	 * AttractionMainIwaseのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	 void deleteAttractionComp(final ArrayList<Long> ids);
}