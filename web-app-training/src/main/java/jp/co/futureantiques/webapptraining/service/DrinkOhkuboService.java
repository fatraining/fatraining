package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.drinkOhkubo.ContainerOhkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.DrinkMainOhkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.MakerOhkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.TypeOhkubo;
import jp.co.futureantiques.webapptraining.model.form.drinkOhkubo.DrinkOhkuboInputForm;
import jp.co.futureantiques.webapptraining.model.form.drinkOhkubo.DrinkOhkuboSearchForm;



/**
 * Drinkのサービスインターフェース
 *
 * @author future
 */
public interface DrinkOhkuboService {
	/**
	 * メーカーエンティティのリストを取得する
	 *
	 * @return MakerEntityのリスト
	 */
	List<MakerOhkubo> getListMaker();

	/**
	 * 種類エンティティのリストを取得する
	 *
	 * @return TypeEntityのリスト
	 */
	List<TypeOhkubo> getListType();

	/**
	 * 容器エンティティのリストを取得する
	 *
	 * @return ContainerEntityのリスト
	 */
	List<ContainerOhkubo> getListContainer();

	/**
	 * 検索条件を元にDrinkMain_Ohkuboのレコードのリストを取得する(Paging)
	 *
	 * @param DrinkOhkuboSearchForm form
	 * @param Pageable pageable
	 * @return DrinkMainのリスト
	 */

	Page<DrinkMainOhkubo> getPageDrink(final DrinkOhkuboSearchForm form,final Pageable pageable);

	/**
	 * 検索条件を元にDrinkMainOhkuboのレコードのリストを取得する
	 *
	 * @param DrinkOhkuboSearchForm form
	 * @return DrinkMainのリスト
	 */
	List<DrinkMainOhkubo> getListDrink(final DrinkOhkuboSearchForm form);


	/**
	 * IDをキーにDrinkMain_Ohkuboのレコードを取得する
	 *
	 * @param long id
	 * @return DrinkMainOhkuboのレコード
	 */
	DrinkMainOhkubo getDrink(final long id);

	/**
	 * DrinkMainOhkuboにレコードを新規登録する
	 *
	 * @param DrinkOhkuboInputForm form
	 * @return DrinkMainOhkubo
	 */
	DrinkMainOhkubo insertDrink(final DrinkOhkuboInputForm form);

	/**
	 * DrinkMainOhkuboのレコードを更新する
	 *
	 * @param DrinkOhkuboInputForm form
	 * @return DrinkMainOhkubo
	 */
	DrinkMainOhkubo updateDrink(final DrinkOhkuboInputForm form);

	/**
	 * DrinkMainOhkuboのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteDrinkById(final long id);

	/**
	 * DrinkMain_Ohkuboのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */

	void deleteDrinkComp(final ArrayList<Long> ids);


}

