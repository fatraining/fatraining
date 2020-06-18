package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.okashiotani.OkashiOtaniInputForm;
import jp.co.futureantiques.webapptraining.model.form.okashiotani.OkashiOtaniSearchForm;
import jp.co.futureantiques.webapptraining.model.okashiotani.MakerOtani;
import jp.co.futureantiques.webapptraining.model.okashiotani.OkashiMainOtani;
import jp.co.futureantiques.webapptraining.model.okashiotani.TypeOtani;

/**
 * OkashiOtaniのサービスインターフェイス
 * @author anzai
 *
 */
public interface OkashiOtaniService {

	/**
	 * 種類エンティティのリストを取得する
	 *
	 * @return TypeOtaniEntityのリスト
	 */
	List<TypeOtani> getListTypeOtani();

	/**
	 * メーカーエンティティのリストを取得する
	 *
	 * @return MakerOtaniEntityのリスト
	 */
	List<MakerOtani> getListMakerOtani();

	/**
	 * 検索条件を元にOkashiMainOtaniのレコードのリストを取得する
	 *
	 * @param OkashiOtaniSearchForm form
	 * @param Pageable pageable
	 * @return OkashiMainOtaniのリスト
	 */
	Page<OkashiMainOtani> getPageOkashiOtani(final OkashiOtaniSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にOkashiMainOtaniのレコードのリストを取得する
	 *
	 * @param OkashiOtaniSearchForm form
	 * @return OkashiMainOtaniのリスト
	 */
	List<OkashiMainOtani> getListOkashiOtani(final OkashiOtaniSearchForm form);

	/**
	 * IDをキーにOkashiMainOtaniのレコードを取得する
	 *
	 * @param long id
	 * @return OkashiMainOtaniのレコード
	 */
	OkashiMainOtani getOkashiOtani(final long id);

	/**
	 * OkashiMainOtaniにレコードを新規登録する
	 *
	 * @param OkashiOtaniInputForm form
	 * @return OkashiMainOtani
	 */
	OkashiMainOtani insertOkashiOtani(final OkashiOtaniInputForm form);

	/**
	 * OkashiMainOtaniのレコードを更新する
	 *
	 * @param OkashiOtaniInputForm form
	 * @return OkashiMainOtani
	 */
	OkashiMainOtani updateOkashiOtani(final OkashiOtaniInputForm form);

	/**
	 * OkashiMainOtaniのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteOkashiOtaniById(final long id);

	/**
	 * OkashiMainOtaniのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteOkashiOtaniComp(final ArrayList<Long> ids);
}
