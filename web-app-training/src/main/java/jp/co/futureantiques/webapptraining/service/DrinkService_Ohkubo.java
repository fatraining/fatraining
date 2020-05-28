package jp.co.futureantiques.webapptraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.drinkOhkubo.Container_Ohkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.DrinkMain_Ohkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.Maker_Ohkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.Type_Ohkubo;
import jp.co.futureantiques.webapptraining.model.form.drinkOhkubo.DrinkSearch_Ohkubo;



/**
 * Drinkのサービスインターフェース
 *
 * @author future
 */
public interface DrinkService_Ohkubo {
	/**
	 * メーカーエンティティのリストを取得する
	 *
	 * @return MakerEntityのリスト
	 */
	List<Maker_Ohkubo> getListMaker();

	/**
	 * 種類エンティティのリストを取得する
	 *
	 * @return TypeEntityのリスト
	 */
	List<Type_Ohkubo> getListType();

	/**
	 * 容器エンティティのリストを取得する
	 *
	 * @return ContainerEntityのリスト
	 */
	List<Container_Ohkubo> getListContainer();

	/**
	 * 検索条件を元にDrinkMain_Ohkuboのレコードのリストを取得する(Paging)
	 *
	 * @param DrinkSearch_Ohkubo form
	 * @param Pageable pageable
	 * @return DrinkMainのリスト
	 */

	Page<DrinkMain_Ohkubo> getPageDrink(final DrinkSearch_Ohkubo form,final Pageable pageable);

	/**
	 * 検索条件を元にDrinkMain_Ohkuboのレコードのリストを取得する
	 *
	 * @param DrinkSearch_Ohkubo form
	 * @return DrinkMainのリスト
	 */
	List<DrinkMain_Ohkubo> getListDrink(final DrinkSearch_Ohkubo form);


	/**
	 * IDをキーにDrinkMain_Ohkuboのレコードを取得する
	 *
	 * @param long id
	 * @return DrinkMain_Ohkuboのレコード
	 */
	DrinkMain_Ohkubo getDrink(final long id);

	/**
	 * DrinkMain_Ohkuboにレコードを新規登録する
	 *
	 * @param DrinkInput_Ohkubo form
	 * @return DrinkMain_Ohkubo
	 */
	//DrinkMain_Ohkubo insertDrink(final DrinkInput_Ohkubo form);

	/**
	 * DrinkMain_Ohkuboのレコードを論理削除する
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

