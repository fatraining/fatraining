package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.CompanyFujimoto;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.GuiterMainFujimoto;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.WoodFujimoto;
import jp.co.futureantiques.webapptraining.model.form.guiterFujimoto.GuiterInputForm;
import jp.co.futureantiques.webapptraining.model.form.guiterFujimoto.GuiterSearchForm;

/*import jp.co.futureantiques.webapptraining.model.IcecreamSako.GenreSako;
import jp.co.futureantiques.webapptraining.model.IcecreamSako.IcecreamMainSako;
import jp.co.futureantiques.webapptraining.model.IcecreamSako.MakerSako;
import jp.co.futureantiques.webapptraining.model.form.icecreamSako.IcecreamSearchForm;*/

/**
 * IcecreamSakoのサービスインターフェース
 *
 * @author FUJIMOTO
 */
@Service
public interface GuiterFujimotoService {

	/**
	 * 会社エンティティのリストを取得する
	 *
	 * @return CompanyFujimotoEntityのリスト
	 */
	List<CompanyFujimoto> getListCompanyFujimoto();

	/**
	 * 木材のリストを取得する
	 *
	 * @return WoodFujimotoEntityのリスト
	 */
	List<WoodFujimoto> getListWoodFujimoto();

	/**
	 * 検索条件を元にGuiterMainFujimotoのレコードのリストを取得する(Paging)
	 *
	 * @param guiterSearchForm form
	 * @param Pageable pageable
	 * @return IcecreamMainSakoのリスト
	 */
	Page<GuiterMainFujimoto> getPageGuiter(final GuiterSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にGuiterMainFujimotoのレコードのリストを取得する
	 *
	 * @param GuiterSearchForm form
	 * @return GuiterMainFujimotoのリスト
	 */
	List<GuiterMainFujimoto> getListGuiter(final GuiterSearchForm form);

	/**
	 * IDをキーにGuiterMainFujimotoのレコードを取得する
	 *
	 * @param long id
	 * @return GuiterMainFujimotoのレコード
	 */
	GuiterMainFujimoto getGuiter(final long id);

	GuiterMainFujimoto insertGuiter(final GuiterInputForm form);

	/**
	 * GuiterMainFujimotoのレコードを更新する
	 *
	 * @param GuiterInputForm form
	 * @return GuiterMainFujimoto
	 */
	GuiterMainFujimoto updateGuiter(final GuiterInputForm form);

	/**
	 * GuiterMainFujimotoのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteGuiterById(final long id);

	/**
	 * GuiterMainFujimotoのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteGuiterComp(final ArrayList<Long> ids);
}

