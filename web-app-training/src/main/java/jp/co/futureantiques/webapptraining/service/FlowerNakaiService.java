package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.flowerNakai.ColorNakai;
import jp.co.futureantiques.webapptraining.model.flowerNakai.FlowerMainNakai;
import jp.co.futureantiques.webapptraining.model.flowerNakai.MonthNakai;
import jp.co.futureantiques.webapptraining.model.form.flowerNakai.FlowerInputForm;
import jp.co.futureantiques.webapptraining.model.form.flowerNakai.FlowerSearchForm;

/**
 * FlowerNakaiサービスのインターフェース
 * @author Rieko Nakai
 */

public interface FlowerNakaiService {

	/**
	 * MonthNakaiエンティティのリストを取得する
	 * @return MonthNakaiエンティティのリスト
	 */

	List<MonthNakai> getListMonthNakai();

	/**
	 * ColorNakaiエンティティのリストを取得する
	 * @return ColorNakaiエンティティのリスト
	 */

	List<ColorNakai> getListColorNakai();

	/**
	 * 検索条件を基にFlowerMainNakaiのレコードのリストを取得する（Paging)
	 *
	 * @param FlowerSearchForm form
	 * @param Pageable pageable
	 * @return FlowerMainNakaiのリスト
	 */

	Page<FlowerMainNakai> getPageFlower(final FlowerSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を基にFlowerMainNakaiのレコードのリストを取得する
	 * @param FlowerSearchForm form
	 * @return FlowerMainNakaiのリスト
	 */

	List<FlowerMainNakai> getListFlower(final FlowerSearchForm form);

	/**
	 * IDをキーにFlowerMainNakaiのレコードを取得する
	 *
	 * @param long id
	 * @return FlowerMainNakaiのレコード
	 */

	FlowerMainNakai getFlower(final long id);

	/**
	 * FlowerMainNakaiにレコードを新規登録する
	 *
	 * @param FlowerInputForm form
	 * @return FlowerMainNakai
	 */

	FlowerMainNakai insertFlower(final FlowerInputForm form);

	/**
	 * FlowerMainNakaiのレコードを更新する
	 * @param FlowerInputForm form
	 * @return FlowerMainNakai
	 */

	FlowerMainNakai updateFlower(final FlowerInputForm form);

	/**
	 * FlowerMainNakaiのレコードを論理削除する
	 * @param long id
	 * @return FlowerMainNakai
	 */

	void deleteFlowerById(final long id);

	/**
	 * FlowerMainNakaiのレコードを物理削除する
	 * @param ArrayList<Long> ids
	 * @return FlowerMainNakai
	 */

	void deleteFlowerComp(final ArrayList<Long> ids);
}
