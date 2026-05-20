package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.form.municipalityPopulationIkebe.MunicipalityPopulationInputForm;
import com.example.demo.model.form.municipalityPopulationIkebe.MunicipalityPopulationSearchForm;
import com.example.demo.model.municipalityPopulationIkebe.MunicipalityIkebe;
import com.example.demo.model.municipalityPopulationIkebe.MunicipalityPopulationIkebeMain;
import com.example.demo.model.municipalityPopulationIkebe.PopulationIkebe;

/**
 * MunicipalityPopulationIkebeのサービスインターフェース
 */
public interface MunicipalityPopulationService {

	/**
	 * 市区町村エンティティのリストを取得する
	 * 
	 * @return MunicipalityEntityのリスト
	 */
	List<MunicipalityIkebe> getListMunicipality();

	/**
	 * 人口エンティティのリストを取得する
	 * 
	 * @return PopulationEntityのリスト
	 */
	List<PopulationIkebe> getListPopulation();

	/**
	 * 検索条件をもとにMunicipalityPopulationIkebeMainのレコードのリストを取得する(Paging)
	 * 
	 * @param MunicipalityPopulationSearchForm form
	 * @param Pageable pageable
	 * @return MunicipalityPopulationIkebeMainのリスト
	 */
	Page<MunicipalityPopulationIkebeMain> getPageMunicipalityPopulation(
			final MunicipalityPopulationSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にMunicipalityPopulationIkebeMainのレコードのリストを取得する
	 *
	 * @param MunicipalityPopulationIkebeSearchForm form
	 * @return MunicipalityPopulationIkebeMainのリスト
	 */
	List<MunicipalityPopulationIkebeMain> getListMunicipalityPopulationIkebeMain(final MunicipalityPopulationSearchForm form);

	/**
	 * IDをキーにMunicipalityPopulationIkebeMainのレコードを取得する
	 *
	 * @param long id
	 * @return MunicipalityPopulationIkebeMainのレコード
	 */
	MunicipalityPopulationIkebeMain getMunicipalityIkebe(final long id);
	
	/**
	 * MunicipalityPopulationIkebeMainにレコードを新規登録する
	 * 
	 * @Param MunicipalityPopulationInputForm Form
	 * @return MunicipalityPopulationIkebeMain
	 */
	MunicipalityPopulationIkebeMain insertMunicipalityPopulation(final MunicipalityPopulationInputForm form);
	
	/**
	 * MunicipalityPopulationIkebeMainのレコードを更新する
	 *
	 * @param MunicipalityPopulationInputForm form
	 * @return MunicipalityPopulationIkebeMain
	 */
	MunicipalityPopulationIkebeMain updateMunicipalityPopulation(final MunicipalityPopulationInputForm form);


	/**
	 * MunicipalityPopulationIkebeMainのレコードを論理削除する
	 *
	 * @param long id
	 */
	void deleteMunicipalityPopulationIkebeById(final long id);

	/**
	 * MunicipalityPopulationIkebeMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids
	 */
	void deleteMunicipaalityPopulationIkebeComp(final ArrayList<Long> ids);

}
