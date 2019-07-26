package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.dffTatebe.DffMainTatebe;
import jp.co.futureantiques.webapptraining.model.dffTatebe.DffTitleTatebe;
import jp.co.futureantiques.webapptraining.model.dffTatebe.DffTypeTatebe;
import jp.co.futureantiques.webapptraining.model.form.dffTatebe.DffTatebeInputForm;
import jp.co.futureantiques.webapptraining.model.form.dffTatebe.DffTatebeSearchForm;

/**
 * DffTatebeのサービスインターフェース
 * @author Tatebe
 *
 */
public interface DffTatebeService {

	/**
	 * 作品名エンティティのリストを取得
	 * @return TitleTatebeEntityのリスト
	 */
	List<DffTitleTatebe> getListTitleTatebe();

	/**
	 * タイプのエンティティのリストを取得
	 * @return TypeTatebe
	 */
	List<DffTypeTatebe> getListTypeTatebe();

	/**
	 * 検索条件をもとにDffMainTatebeのレコードリストを取得(paging)
	 *
	 * @param DffTatebeSearchForm form
	 * @param Pageble pageble
	 * @return DffMainTatebeのリスト
	 */
	Page<DffMainTatebe> getPageDffTatebe(final DffTatebeSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にDffMainTatebeのレコードのリストを取得する
	 *
	 * @param long id
	 * @return DffMainのレコード
	 */
	List<DffMainTatebe> getListDffTatebe(final DffTatebeSearchForm form);

	/**
	 * IDをキーにDffMainTatebeのレコードを取得する
	 *
	 * @param long id
	 * @return DffMainTatebeのレコード
	 */
	DffMainTatebe getDffTatebe(final long id);

	/**
	 * DffMainTatebeにレコードを新規登録する
	 *
	 * @param DffTatebeInputForm form
	 * @return DffMainTatebe
	 */
	DffMainTatebe insertDffTatebe(final DffTatebeInputForm form);

	/**
	 * dffMainTatebeのレコードを更新する
	 *
	 * @param DffTatebeInputForm form
	 * @return DffMainTatebe
	 */
	DffMainTatebe updateDffTatebe(final DffTatebeInputForm form);

	/**
	 *DffTatebeのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteDffTatebeById(final long id);

	/**
	 * DffMainTatebeのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteDffTatebeComp(final ArrayList<Long> ids);

}
