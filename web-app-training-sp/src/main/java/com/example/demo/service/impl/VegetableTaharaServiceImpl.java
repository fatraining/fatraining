package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.model.form.vegetabletahara.VegetableTaharaInputForm;
import com.example.demo.model.form.vegetabletahara.VegetableTaharaSearchForm;
import com.example.demo.model.vegetabletahara.AreaTahara;
import com.example.demo.model.vegetabletahara.CategoryTahara;
import com.example.demo.model.vegetabletahara.VegetableMainTahara;
import com.example.demo.repository.specification.VegetableTaharaSpecification;
import com.example.demo.repository.vegetabletahara.AreaRepository;
import com.example.demo.repository.vegetabletahara.CategoryRepository;
import com.example.demo.repository.vegetabletahara.VegetableMainRepository;
import com.example.demo.service.VegetableTaharaService;

/**
 * VegetableTaharaのサービス実装クラス
 *
 * @author future
 */
@Service
public class VegetableTaharaServiceImpl implements VegetableTaharaService{

	/** VegetableMainTaharaリポジトリ */
	private final VegetableMainRepository vegetableMainRepository;

	/** Categoryリポジトリ */
	private final CategoryRepository categoryRepository;

	/** Areaリポジトリ */
	private final AreaRepository areaRepository;

	/**
	 * コンストラクタ
	 *
	 * @param VegetableMainRepository vegetableMainRepository
	 * @param CategoryRepository categoryRepository
	 * @param AreaRepository areaRepository
	 */
	public VegetableTaharaServiceImpl(VegetableMainRepository vegetableMainRepository, 
			CategoryRepository categoryRepository, AreaRepository areaRepository) {
		this.vegetableMainRepository = vegetableMainRepository;
		this.categoryRepository = categoryRepository;
		this.areaRepository = areaRepository;
	}
	
	@Override
	public List<CategoryTahara> getListCategory() {

		// CategoryテーブルのレコードをID順に取得する TO:DO
		return categoryRepository.findAll();
	}

	@Override
	public List<AreaTahara> getListArea() {

		// AreaテーブルのレコードをID順に取得するTO:DO
		return areaRepository.findAll();
	}
	
//以下、検索機能
	@Override
	public Page<VegetableMainTahara> getPageVegetable(final VegetableTaharaSearchForm form, final Pageable pageable) {

		// 検索条件を生成しVegetableMainTaharaテーブルのレコードを取得する
		return vegetableMainRepository.findAll(VegetableTaharaSpecification.generateVegetableSpecification(form), pageable);
	}

	@Override
	public List<VegetableMainTahara> getListVegetable(final VegetableTaharaSearchForm form) {

		// 検索条件を生成しVegetableMainTaharaテーブルのレコードを取得する
		return vegetableMainRepository.findAll(VegetableTaharaSpecification.generateVegetableSpecification(form));
	}

	@Override
	public VegetableMainTahara getVegetable(final long id) {

		// VegetableMainTaharaテーブルを主キー検索する
		VegetableMainTahara vegetableMainTahara = vegetableMainRepository.findById(id).get();
		return vegetableMainTahara;
	}
	
//以下、追加機能
	@Override
	public VegetableMainTahara insertVegetable(final VegetableTaharaInputForm form) {
		
		//VegetableMainTaharaに新規でデータを登録
		final VegetableMainTahara vegetableMainTahara = form.convertToVegetableMainTaharaForInsert();
		return vegetableMainRepository.saveAndFlush(vegetableMainTahara);
	}
	
//以下、更新機能
	@Override
	public VegetableMainTahara updateVegetable(final VegetableTaharaInputForm form) {
		
		//更新対象のレコードを取得
		Optional<VegetableMainTahara> vegetableMainTaharaOp = vegetableMainRepository.findById((long) form.getId());
		
		VegetableMainTahara vegetableMainTahara = vegetableMainTaharaOp.get();
		if(vegetableMainTahara != null) {
			
			//更新対象データが存在する場合、排他チェック
			if(form.getUpdateDate().equals(String.valueOf(vegetableMainTahara.getUpdateDate()))) {
				
				//チェックOKの場合、更新
				vegetableMainTahara = form.convertToVegetableMainTaharaForUpdate(vegetableMainTahara);
				return vegetableMainRepository.saveAndFlush(vegetableMainTahara);
			}
		}
		return null;
	}
	
//以下、削除機能
	@Override
	public void deleteVegetableTaharaById(final long id) {

		// 更新対象のレコードを取得する
		Optional<VegetableMainTahara> VegetableMainOp = vegetableMainRepository.findById(id);
		VegetableMainTahara vegetableMain = VegetableMainOp.get();
		if (vegetableMain != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			vegetableMainRepository.delete(id);
		}
	}

	@Override
	public void deleteVegetableTaharaComp(final ArrayList<Long> ids) {

		// 対象のレコードを削除する
		vegetableMainRepository.deleteComp(ids);
	}
}
