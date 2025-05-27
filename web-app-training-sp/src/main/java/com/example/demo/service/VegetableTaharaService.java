package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.form.vegetabletahara.VegetableTaharaInputForm;
import com.example.demo.model.form.vegetabletahara.VegetableTaharaSearchForm;
import com.example.demo.model.vegetabletahara.AreaTahara;
import com.example.demo.model.vegetabletahara.CategoryTahara;
import com.example.demo.model.vegetabletahara.VegetableMainTahara;

/*
 * vegetabletaharaのサービスインターフェース
 * 
 * @author future
 * */
public interface VegetableTaharaService {
	
	/*
	 * 国内最大生産地エンティティのリストを取得する
	 * 
	 * @return AreaEntityのリスト
	 * */
	public List<AreaTahara> getListArea();

	/*
	 * カテゴリーエンティティのリストを取得する
	 * 
	 * @return CategoryEntityのリスト
	 * */
	public List<CategoryTahara> getListCategory();
	
	
//以下、検索機能
	/**
	 * 検索条件を元にVegetableMainTaharaのレコードのリストを取得する(Paging)
	 *
	 * @param VegetableMainTaharaSearchForm form
	 * @param Pageable pageable
	 * @return VegetableMainTaharaのリスト
	 */
	Page<VegetableMainTahara> getPageVegetable(final VegetableTaharaSearchForm form, final Pageable pageable);
	
	/**
	 * 検索条件を元にVegetableMainTaharaのレコードのリストを取得する
	 *
	 * @param VegetableMainTaharaSearchForm form
	 * @return VegetableMainTaharaのリスト
	 */
	List<VegetableMainTahara> getListVegetable(final VegetableTaharaSearchForm form);

	
//以下、追加機能
	/**
	 * IDをキーにVegetableMainTaharaのレコードを取得する
	 *
	 * @param long id
	 * @return VegetableMainTaharaのレコード
	 */
	VegetableMainTahara getVegetable(final long id);

	
	/**
	 * VegetableMainTaharaにレコードを新規登録する
	 *
	 * @param VegetableTaharaInputForm form
	 * @return VegetableMainTahara
	 */
	VegetableMainTahara insertVegetable(final VegetableTaharaInputForm form);

	
//以下、更新機能	
	/**
	 * VegetableMainTaharaのレコードを更新する
	 *
	 * @param VegetableTaharaleInputForm form
	 * @return VegetableMainTahara
	 */
	VegetableMainTahara updateVegetable(final VegetableTaharaInputForm form);

	
//以下、削除機能
	/**
	 * MovieMainのレコードを論理削除(ユーザーからは削除したように見える消し方)する
	 *
	 * @param long id
	 */
	void deleteVegetableTaharaById(final long id);

	/**
	 * MovieMainのレコードを物理削除(DBから完全に削除)する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteVegetableTaharaComp(final ArrayList<Long> ids);


}
