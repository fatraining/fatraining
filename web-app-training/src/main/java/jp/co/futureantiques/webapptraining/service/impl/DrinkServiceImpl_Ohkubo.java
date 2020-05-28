package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.drinkOhkubo.Container_Ohkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.DrinkMain_Ohkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.Maker_Ohkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.Type_Ohkubo;
import jp.co.futureantiques.webapptraining.model.form.drinkOhkubo.DrinkSearch_Ohkubo;
import jp.co.futureantiques.webapptraining.repository.drinkOhkubo.ContainerRepository_Ohkubo;
import jp.co.futureantiques.webapptraining.repository.drinkOhkubo.DrinkMainRepository_Ohkubo;
import jp.co.futureantiques.webapptraining.repository.drinkOhkubo.MakerRepository_Ohkubo;
import jp.co.futureantiques.webapptraining.repository.drinkOhkubo.TypeRepository_Ohkubo;
import jp.co.futureantiques.webapptraining.repository.specification.DrinkSpecification_Ohkubo;
import jp.co.futureantiques.webapptraining.service.DrinkService_Ohkubo;


/**
 * MovieSampleのサービス実装クラス
 *
 * @author future
 */
@Service
public class DrinkServiceImpl_Ohkubo implements DrinkService_Ohkubo{
	/** DrinkMainリポジトリ */
	private final DrinkMainRepository_Ohkubo drinkMainRepository_Ohkubo;

	/** Makerリポジトリ */
	private final MakerRepository_Ohkubo makerRepository_Ohkubo;

	/** Typeリポジトリ */
	private final TypeRepository_Ohkubo typeRepository_Ohkubo;

	/** Containerリポジトリ */
	private final ContainerRepository_Ohkubo containerRepository_Ohkubo;


	/**
	 * コンストラクタ
	 *
	 * @param DrinkMainRepository_Ohkubo drinkMainRepository_Ohkubo;
	 * @param MakerRepository_Ohkubo makerRepository_Ohkubo;
	 * @param TypeRepository_Ohkubo typeRepository_Ohkubo;
	 * @param
	 */
	@Autowired
	public DrinkServiceImpl_Ohkubo(DrinkMainRepository_Ohkubo drinkMainRepository_Ohkubo,
			MakerRepository_Ohkubo makerRepository_Ohkubo,
			TypeRepository_Ohkubo typeRepository_Ohkubo,
			ContainerRepository_Ohkubo containerRepository_Ohkubo){
		this.drinkMainRepository_Ohkubo=drinkMainRepository_Ohkubo;
		this.makerRepository_Ohkubo=makerRepository_Ohkubo;
		this.typeRepository_Ohkubo=typeRepository_Ohkubo;
		this.containerRepository_Ohkubo=containerRepository_Ohkubo;

	}

	@Override
	public List<Maker_Ohkubo> getListMaker() {

		// MakerテーブルのレコードをID順に取得する
		return makerRepository_Ohkubo.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<Type_Ohkubo> getListType() {

		// TypeテーブルのレコードをID順に取得する
		return typeRepository_Ohkubo.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<Container_Ohkubo> getListContainer() {

		// ContainerテーブルのレコードをID順に取得する
		return containerRepository_Ohkubo.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<DrinkMain_Ohkubo> getPageDrink(final DrinkSearch_Ohkubo form, final Pageable pageable) {

		// 検索条件を生成しDrinkMainテーブルのレコードを取得する
		return drinkMainRepository_Ohkubo.findAll(DrinkSpecification_Ohkubo.generateDrinkSpecification(form),pageable);
	}

	@Override
	public List<DrinkMain_Ohkubo> getListDrink(final DrinkSearch_Ohkubo form){

		//検索条件を生成しDrinkMainテーブルのレコードを取得する
		return drinkMainRepository_Ohkubo.findAll(DrinkSpecification_Ohkubo.generateDrinkSpecification(form));
	}

	@Override
	public DrinkMain_Ohkubo getDrink(final long id) {

		//DrinkMainテーブルを主きー検索する
		return drinkMainRepository_Ohkubo.findOne(id);
	}

/*	@Override
	public DrinkMain_Ohkubo insertDrink(final DrinkInput_Ohkubo form) {

		DrinkMainテーブルに新規でデータを登録する
		final DrinkMain_Ohkubo drinkMain=form.converToDrinkMainForInsert();
		return drinkMainRepository_Ohkubo.save(drinkMain);
	}*/

/*	@Override
	public DrinkMain_Ohkubo updateDrink(final DrinkInput_Ohkubo form) {

		//更新対象のレコードを取得する
		DrinkMain_Ohkubo drinkMain_Ohkubo=drinkMainRepository_Ohkubo.findOne((long) form.getId));
		if(drinkMain_Ohkubo!=null) {

			//更新対象のレコードが存在する場合排他チェック
			if(form.getUpddateDate().equals(String.valueOf(drinkMain_Ohkubo.getUpdateDate())));

			//チェックOKの場合、更新
			drinkMain_Ohkubo=for.convertToDrinkMainForUpdate(drinkMain_Ohkubo);
			return drinkMainRepository_Ohkubo.saveAndFlush(drinkMain_Ohkubo);
		}
	}*/

	@Override
	public void deleteDrinkById(final long id) {

		//更新対象のレコードを取得する
		DrinkMain_Ohkubo drinkMain_Ohkubo=drinkMainRepository_Ohkubo.findOne(id);
		if(drinkMain_Ohkubo!=null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			drinkMainRepository_Ohkubo.delete(id);
		}
	}

	@Override
	public void deleteDrinkComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		drinkMainRepository_Ohkubo.deleteComp(ids);
	}

}

