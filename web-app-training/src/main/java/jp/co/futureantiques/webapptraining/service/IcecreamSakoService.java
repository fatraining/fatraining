package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.IcecreamSako.GenreSako;
import jp.co.futureantiques.webapptraining.model.IcecreamSako.IcecreamMainSako;
import jp.co.futureantiques.webapptraining.model.IcecreamSako.MakerSako;
import jp.co.futureantiques.webapptraining.model.form.icecreamSako.IcecreamInputForm;
import jp.co.futureantiques.webapptraining.model.form.icecreamSako.IcecreamSearchForm;


/**
 * IcecreamSakoのサービスインターフェース
 *
 * @author MINAMI SAKO
 */

public interface IcecreamSakoService {

	/**
	 * ジャンルエンティティのリストを取得する
	 *
	 * @return GenreSakoEntityのリスト
	 */
	List<GenreSako> getListGenreSako();

	/**
	 * メーカーのリストを取得する
	 *
	 * @return MakerSakoEntityのリスト
	 */
	List<MakerSako> getListMakerSako();

	/**
	 * 検索条件を元にIcecreamMainSakoのレコードのリストを取得する(Paging)
	 *
	 * @param icecreamSearchForm form
	 * @param Pageable pageable
	 * @return IcecreamMainSakoのリスト
	 */
	Page<IcecreamMainSako> getPageIcecream(final IcecreamSearchForm form, final java.awt.print.Pageable pageable);

	/**
	 * 検索条件を元にIcecreamMainSakoのレコードのリストを取得する
	 *
	 * @param IcecreamSearchForm form
	 * @return IcecreamMainSakoのリスト
	 */
	List<IcecreamMainSako> getListIcecream(final IcecreamSearchForm form);


	/**
	 * IDをキーにIcecreamMainSakoのレコードを取得する
	 *
	 * @param long id
	 * @return IcecreamMainSakoのレコード
	 */
	IcecreamMainSako getIcecream(final long id);

	/**
	 * IcecreamMainSakoにレコードを新規登録する
	 *
	 * @param IcecreamInputForm form
	 * @return IcecreamMainSako
	 */
	IcecreamMainSako insertIcecream(final IcecreamInputForm form);

	/**
	 * IcecreamMainSakoのレコードを更新する
	 *
	 * @param IcecreamInputForm form
	 * @return IcecreamMainSako
	 *
	 */
	IcecreamMainSako updateIcecream(final IcecreamInputForm form);

	/**
	 * IcecreamMainSakoのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteIcecreamById(final long id);

	/**
	 * IcecreamMainSakoのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteIcecreamComp(final ArrayList<Long> ids);

	Page<IcecreamMainSako> getPageIcecream(IcecreamSearchForm form, Pageable pageable);

}
