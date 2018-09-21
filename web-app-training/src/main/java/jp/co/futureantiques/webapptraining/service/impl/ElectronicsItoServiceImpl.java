package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.Electronics.BrandIto;
import jp.co.futureantiques.webapptraining.model.Electronics.CategoryIto;
import jp.co.futureantiques.webapptraining.model.Electronics.ElectronicsMainIto;
import jp.co.futureantiques.webapptraining.model.form.electronicsIto.ElectronicsInputForm;
import jp.co.futureantiques.webapptraining.model.form.electronicsIto.ElectronicsSearchForm;
import jp.co.futureantiques.webapptraining.repository.electronicsito.BrandItoRepository;
import jp.co.futureantiques.webapptraining.repository.electronicsito.CategoryItoRepository;
import jp.co.futureantiques.webapptraining.repository.electronicsito.ElectronicsMainItoRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ElectronicsItoSpecification;
import jp.co.futureantiques.webapptraining.service.ElectronicsItoService;

/**
 * Electronicのサービス実装クラス
 *
 * @author AIRI ITO
 *
 */
@Service
public class ElectronicsItoServiceImpl implements ElectronicsItoService{

	/** ElectiricMainリポジトリ */
	private final ElectronicsMainItoRepository electronicsMainItoRepository;

	/**Categoryレポジトリ */
	private final CategoryItoRepository categoryItoReposiory;

	/** Brandレポジトリ */
	private final BrandItoRepository brandItoRepository;

	/**
	 * コンストラクタ
	 *
	 * @param ElectronicsMainRepository electoryMainReopository
	 * @param CategoryRepository categoryRepository
	 * @param BrandItoRepository brandRepository
	 */

	@Autowired
	public ElectronicsItoServiceImpl(ElectronicsMainItoRepository electronicsMainItoRepository,
			CategoryItoRepository categoryItoRepository, BrandItoRepository brandItoRepository) {
		this.electronicsMainItoRepository = electronicsMainItoRepository;
		this.categoryItoReposiory = categoryItoRepository;
		this.brandItoRepository = brandItoRepository;
	}

	@Override
	public List<CategoryIto> getListCategory(){

		//CategoryテーブルのレコードをID順に取得する
		return categoryItoReposiory.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<BrandIto> getListBrand(){

		//BrandテーブルのレコードをID順に取得する
		return brandItoRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<ElectronicsMainIto> getPageProduct(final ElectronicsSearchForm form, final Pageable pageable) {

		//検索条件を生成しElectronicsMainテーブルのレコードを取得する
		return electronicsMainItoRepository.findAll(ElectronicsItoSpecification.generateElectronicsSpecification(form), pageable);
	}

	@Override
	public List<ElectronicsMainIto> getListProduct(final ElectronicsSearchForm form) {

		//検索条件を生成しElectronicsMainテーブルのレコードを取得する
		return electronicsMainItoRepository.findAll(ElectronicsItoSpecification.generateElectronicsSpecification(form));
	}

	@Override
	public ElectronicsMainIto getProduct(final long id) {

		//ElectronicsMainテーブルを主キー検索する
		return electronicsMainItoRepository.findOne(id);
	}

	@Override
	public ElectronicsMainIto insertProduct(final ElectronicsInputForm form) {

		//ElectronicsMainテーブルに新規でデータを登録する
		final ElectronicsMainIto electronicsMainIto = form.convertToElectronicsMainForInsert();
		return electronicsMainItoRepository.save(electronicsMainIto);
	}

	@Override
	public ElectronicsMainIto updateProduct(final ElectronicsInputForm form) {

		//更新対象のレコードを取得する
		ElectronicsMainIto electronicsMainIto = electronicsMainItoRepository.findOne((long) form.getId());
		if (electronicsMainIto != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(electronicsMainIto.getUpdateDate()))) {

				//チェックOKの場合、更新
				electronicsMainIto = form.convertToElectronicsMainForUpdate(electronicsMainIto);
				return electronicsMainItoRepository.saveAndFlush(electronicsMainIto);
			}
		}
		return null;
	}

	@Override
	public void deleteProductById(final long id) {

		//更新対象のレコードを取得する
		ElectronicsMainIto electronicsMainIto = electronicsMainItoRepository.findOne(id);
		if (electronicsMainIto != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			electronicsMainItoRepository.delete(id);
		}
	}

	@Override
	public void deleteProductComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		electronicsMainItoRepository.deleteComp(ids);
	}

}
