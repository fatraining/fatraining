package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.drinkOhkubo.ContainerOhkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.DrinkMainOhkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.MakerOhkubo;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.TypeOhkubo;
import jp.co.futureantiques.webapptraining.model.form.drinkOhkubo.DrinkOhkuboInputForm;
import jp.co.futureantiques.webapptraining.model.form.drinkOhkubo.DrinkOhkuboSearchForm;
import jp.co.futureantiques.webapptraining.repository.drinkOhkubo.ContainerOhkuboRepository;
import jp.co.futureantiques.webapptraining.repository.drinkOhkubo.DrinkMainOhkuboRepository;
import jp.co.futureantiques.webapptraining.repository.drinkOhkubo.MakerOhkuboRepository;
import jp.co.futureantiques.webapptraining.repository.drinkOhkubo.TypeOhkuboRepository;
import jp.co.futureantiques.webapptraining.repository.specification.DrinkOhkuboSpecification;
import jp.co.futureantiques.webapptraining.service.DrinkOhkuboService;

/**
 * MovieSampleのサービス実装クラス
 *
 * @author future
 */
@Service
public class DrinkOhkuboServiceImpl implements DrinkOhkuboService{

	/** DrinkMainリポジトリ */
	private final DrinkMainOhkuboRepository drinkMainOhkuboRepository;

	/** Makerリポジトリ */
	private final MakerOhkuboRepository makerOhkuboRepository;

	/** Typeリポジトリ */
	private final TypeOhkuboRepository typeOhkuboReposiory;

	/** Containerリポジトリ */
	private final ContainerOhkuboRepository containerOhkuboRepository;

	/**
	 * コンストラクタ
	 *
	 * @param DrinkMainOhkuboRepository drinkMainOhkuboRepository;
	 * @param MakerOhkuboRepository makerOhkuboRepository;
	 * @param TypeOhkuboRepository typeOhkuboReposiory;
	 * @param
	 */
	@Autowired
	public DrinkOhkuboServiceImpl(DrinkMainOhkuboRepository drinkMainOhkuboRepository,
			MakerOhkuboRepository makerOhkuboRepository,
			TypeOhkuboRepository typeOhkuboReposiory,
			ContainerOhkuboRepository containerOhkuboRepository){
		this.drinkMainOhkuboRepository=drinkMainOhkuboRepository;
		this.makerOhkuboRepository=makerOhkuboRepository;
		this.typeOhkuboReposiory=typeOhkuboReposiory;
		this.containerOhkuboRepository=containerOhkuboRepository;

	}

	@Override
	public List<MakerOhkubo> getListMaker() {

		// MakerテーブルのレコードをID順に取得する
		return makerOhkuboRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<TypeOhkubo> getListType() {

		// TypeテーブルのレコードをID順に取得する
		return typeOhkuboReposiory.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<ContainerOhkubo> getListContainer() {

		// ContainerテーブルのレコードをID順に取得する
		return containerOhkuboRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<DrinkMainOhkubo> getPageDrink(final DrinkOhkuboSearchForm form, final Pageable pageable) {

		// 検索条件を生成しDrinkMainテーブルのレコードを取得する
		return drinkMainOhkuboRepository.findAll(DrinkOhkuboSpecification.generateDrinkSpecification(form),pageable);
	}

	@Override
	public List<DrinkMainOhkubo> getListDrink(final DrinkOhkuboSearchForm form){

		//検索条件を生成しDrinkMainテーブルのレコードを取得する
		return drinkMainOhkuboRepository.findAll(DrinkOhkuboSpecification.generateDrinkSpecification(form));
	}

	@Override
	public DrinkMainOhkubo getDrink(final long id) {

		//DrinkMainテーブルを主キー検索する
		return drinkMainOhkuboRepository.findOne(id);
	}

	@Override
	public DrinkMainOhkubo insertDrink(final DrinkOhkuboInputForm form) {

		//DrinkMainテーブルに新規でデータを登録する
		final DrinkMainOhkubo drinkMainOhkubo=form.convertToDrinkMainOhkuboForInsert();
		return drinkMainOhkuboRepository.save(drinkMainOhkubo);
	}

	@Override
	public DrinkMainOhkubo updateDrink(final DrinkOhkuboInputForm form) {

		//更新対象のレコードを取得する
		DrinkMainOhkubo drinkMainOhkubo=drinkMainOhkuboRepository.findOne((long) form.getId());
		if(drinkMainOhkubo!=null) {

			//更新対象のレコードが存在する場合排他チェック
			if(form.getUpdateDate().equals(String.valueOf(drinkMainOhkubo.getUpdateDate()))) {

				//チェックOKの場合、更新
				drinkMainOhkubo=form.convertToDrinkMainOhkuboForUpdate(drinkMainOhkubo);
				return drinkMainOhkuboRepository.saveAndFlush(drinkMainOhkubo);
			}
		}
		return null;
	}

	@Override
	public void deleteDrinkById(final long id) {

		//更新対象のレコードを取得する
		DrinkMainOhkubo drinkMainOhkubo=drinkMainOhkuboRepository.findOne(id);
		if(drinkMainOhkubo!=null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			drinkMainOhkuboRepository.delete(id);
		}
	}

	@Override
	public void deleteDrinkComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		drinkMainOhkuboRepository.deleteComp(ids);
	}

}

