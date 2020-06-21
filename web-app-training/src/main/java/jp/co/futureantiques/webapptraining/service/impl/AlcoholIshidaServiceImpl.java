package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.alcoholishida.AlcoholMainIshida;
import jp.co.futureantiques.webapptraining.model.alcoholishida.IngredientIshida;
import jp.co.futureantiques.webapptraining.model.alcoholishida.LiqueurIshida;
import jp.co.futureantiques.webapptraining.model.form.alcoholishida.AlcoholIshidaInputForm;
import jp.co.futureantiques.webapptraining.model.form.alcoholishida.AlcoholIshidaSearchForm;
import jp.co.futureantiques.webapptraining.repository.alcoholishida.AlcoholMainIshidaRepository;
import jp.co.futureantiques.webapptraining.repository.alcoholishida.IngredientIshidaRepository;
import jp.co.futureantiques.webapptraining.repository.alcoholishida.LiqueurIshidaRepository;
import jp.co.futureantiques.webapptraining.repository.specification.AlcoholIshidaSpecification;
import jp.co.futureantiques.webapptraining.service.AlcoholIshidaService;

/**
 *AlcoholIshidaのサービス実装クラス
 *
 * @author t.ishida
 */
@Service
public class AlcoholIshidaServiceImpl implements AlcoholIshidaService {

	/**AlcoholMainIshidaリポジトリ*/
	private final AlcoholMainIshidaRepository alcoholMainIshidaRepository;

	/**Ingredientリポジトリ*/
	private final IngredientIshidaRepository ingredientIshidaRepository;

	/**Liqueurリポジトリ*/
	private final LiqueurIshidaRepository liqueurIshidaRepository;

		/**
		 * コンストラクタ
		 *
		 * @param AlcoholMainIshidaRepository alcoholMainIshidaRepository
		 * @param IngredientIshidaMainRepository ingredientIshidaMainRepository
		 * @param LiqueurIshidaMainRepository liqueurIshidaMainRepository
		 */
	@Autowired
	public AlcoholIshidaServiceImpl(AlcoholMainIshidaRepository alcoholMainIshidaRepository,
			IngredientIshidaRepository ingredientIshidaRepository, LiqueurIshidaRepository liqueurIshidaRepository) {
		this.alcoholMainIshidaRepository = alcoholMainIshidaRepository;
		this.ingredientIshidaRepository = ingredientIshidaRepository;
		this.liqueurIshidaRepository = liqueurIshidaRepository;
	}

	@Override
	public List<IngredientIshida> getListIngredient() {

		//IngredientテーブルをID順に取得する
		return ingredientIshidaRepository.findAll(new Sort(Sort.Direction.ASC, "ingredientId"));
	}

	@Override
	public List<LiqueurIshida> getListLiqueur() {

		//LiqueurテーブルをID順に取得する
		return liqueurIshidaRepository.findAll(new Sort(Sort.Direction.ASC, "liqueurId"));
	}

	@Override
	public Page<AlcoholMainIshida> getPageAlcohol(final AlcoholIshidaSearchForm form, Pageable pageable) {

		//検索条件を生成しAlcoholIsikawaMainテーブルのレコードを取得する
		return alcoholMainIshidaRepository.findAll(AlcoholIshidaSpecification.generateAlcoholIshiawaSpecification(form),
				pageable);
	}

	@Override
	public List<AlcoholMainIshida> getListAlcohol(final AlcoholIshidaSearchForm form) {

		//検索条件を生成しAlcoholIsikawaMainテーブルのレコードを取得する
		return alcoholMainIshidaRepository
				.findAll(AlcoholIshidaSpecification.generateAlcoholIshiawaSpecification(form));
	}

	@Override
	public AlcoholMainIshida getAlcohol(final long id) {

		//AlcoholMainIshidaテーブルを主キー検索する
		return alcoholMainIshidaRepository.findOne(id);
	}

	@Override
	public AlcoholMainIshida insertAlcohol(final AlcoholIshidaInputForm form) {

		//AlcoholIshidaテーブルに新規でデータを登録する
		final AlcoholMainIshida alcoholMainIshida = form.convertToAlcoholMainIshidaForInsert();
		return alcoholMainIshidaRepository.save(alcoholMainIshida);
	}

	@Override
	public AlcoholMainIshida updateAlcohol(final AlcoholIshidaInputForm form) {

		//更新対象のレコードを取得する
		AlcoholMainIshida alcoholMainIshida = alcoholMainIshidaRepository.findOne((long) form.getId());
		if (alcoholMainIshida != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(alcoholMainIshida.getUpdateDate()))) {

				//チェックOKの場合、更新
				alcoholMainIshida = form.convertToAlcoholMainIshidaForUpdate(alcoholMainIshida);
				return alcoholMainIshidaRepository.saveAndFlush(alcoholMainIshida);
			}
		}
		return null;
	}

	@Override
	public void deleteAlcoholById(final long id) {

		//更新対象のレコードを取得する
		AlcoholMainIshida alcoholMainIshida = alcoholMainIshidaRepository.findOne(id);
		if (alcoholMainIshida != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			alcoholMainIshidaRepository.delete(id);
		}
	}

	@Override
	public void deleteAlcoholComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		alcoholMainIshidaRepository.deleteComp(ids);
	}
}