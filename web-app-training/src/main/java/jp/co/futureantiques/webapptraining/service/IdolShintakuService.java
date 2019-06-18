package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.form.idolShintaku.IdolShintakuInputForm;
import jp.co.futureantiques.webapptraining.model.form.idolShintaku.IdolShintakuSearchForm;
import jp.co.futureantiques.webapptraining.model.idolShintaku.IdolMainShintaku;
import jp.co.futureantiques.webapptraining.model.idolShintaku.TypeShintaku;
import jp.co.futureantiques.webapptraining.model.idolShintaku.UnitShintaku;


/**
 * IdolShintakuのインターフェイス
 *
 * @author shintaku
 */
@Service
public interface IdolShintakuService {

	/**
	 * 属性エンティティのリストを取得する
	 *
	 * @return TypeShintakuEntityのリスト
	 */
	List<TypeShintaku> getListType();

	/**
	 * ユニットエンティティのリストを取得する
	 *
	 * @return UnitShintakuEntityのリスト
	 */
	List<UnitShintaku> getListUnit();

	/**
	 * 検索条件を元にIdolMAinShintakuのレコードのリストを取得する(Paging)
	 *
	 * @param IdolShintakuSearchForm form
	 * @param Pageble pageable
	 * @return IdolMainShintakuのリスト
	 */
	Page<IdolMainShintaku> getPageIdol(final IdolShintakuSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にIdolMainShinatkuのレコードのリストを取得する
	 *
	 * @param IdolShintakuSearchForm form
	 * @return IdolMainShintakuのリスト
	 */
	List<IdolMainShintaku> getListIdol(final IdolShintakuSearchForm form);

	/**
	 * IDをキーにIdolMainShintakuのレコードを取得する
	 *
	 * @param long id
	 * @return IdolMainShintakuのレコード
	 */
	IdolMainShintaku getIdol(final long id);

	/**
	 * IdolMainShintakuにレコードを新規登録する
	 *
	 * @param IdolShintakuInputForm form
	 * @return IdolMainShintaku
	 */
	IdolMainShintaku insertIdol(final IdolShintakuInputForm form);

	/**
	 * IdolMainShintakuのレコードを更新する
	 *
	 * @param IdolShintakuInputForm form
	 * @return IdolMainShintaku
	 */
	IdolMainShintaku updateIdol(final IdolShintakuInputForm form);

	/**
	 * IdolMainShintakuのレコードを論理削除する
	 *
	 * @param IdolShintakuSearchForm form
	 * @return IdolMainShintaku
	 */
	void deleteIdolById(final long id);

	/**
	 * IdolMainShintakuのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteIdolComp(final ArrayList<Long> ids);
}
