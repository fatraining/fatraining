package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.IdolKataoka.ColorKataoka;
import jp.co.futureantiques.webapptraining.model.IdolKataoka.GroupKataoka;
import jp.co.futureantiques.webapptraining.model.IdolKataoka.IdolMainKataoka;
import jp.co.futureantiques.webapptraining.model.form.IdolKataoka.IdolInputForm;
import jp.co.futureantiques.webapptraining.model.form.IdolKataoka.IdolSearchForm;


/**
 * IdolKataokaのサービスインターフェース
 *
 * @author skataoka
 */

public interface IdolKataokaService {

	/**
	 * メンバーカラーエンティティのリストを取得する
	 *
	 * @return ColorKataokaEntityのリスト
	 */
	List<ColorKataoka> getListColorKataoka();

	/**
	 * 所属グループエンティティのリストを取得する
	 *
	 * @return GroupKataokaEntityのリスト
	 */
	List<GroupKataoka> getListGroupKataoka();

	/**
	 * 検索条件を元にIdolMainKataokaのレコードのリストを取得する(Paging)
	 *
	 * @param idolSearchForm form
	 * @param Pageable pageable
	 * @return IdolMainkataokaのリスト
	 */
	Page<IdolMainKataoka> getPageIdol(final IdolSearchForm form, final java.awt.print.Pageable pageable);

	/**
	 * 検索条件を元にIdolMainKataokaのレコードのリストを取得する
	 *
	 * @param IdolSearchForm form
	 * @return IdolMainKataokaのリスト
	 */
	List<IdolMainKataoka> getListIdol(final IdolSearchForm form);


	/**
	 * IDをキーにIdolMainKataokaのレコードを取得する
	 *
	 * @param long idol_id
	 * @return IdolMainKataokaのレコード
	 */
	IdolMainKataoka getIdol(final long idol_id);

	/**
	 * IdolMainKataokaにレコードを新規登録する
	 *
	 * @param IdolInputForm form
	 * @return IdolMainKataoka
	 */
	IdolMainKataoka insertIdol(final IdolInputForm form);

	/**
	 * IdolMainKataokaのレコードを更新する
	 *
	 * @param IdolInputForm form
	 * @return IdolMainKataoka
	 */
	IdolMainKataoka updateIdol(final IdolInputForm form);

	/**
	 * IdolMainKataokaのレコードを論理削除する
	 *
	 * @param long idol_id
	 */
	void deleteIdolById(final long idol_id);

	/**
	 * IdolMainKataokaのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteIdolComp(final ArrayList<Long> ids);

	Page<IdolMainKataoka> getPageIdol(IdolSearchForm form, Pageable pageable);

}






