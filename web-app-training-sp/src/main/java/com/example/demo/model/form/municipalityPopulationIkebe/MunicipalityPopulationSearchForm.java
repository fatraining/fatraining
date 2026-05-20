package com.example.demo.model.form.municipalityPopulationIkebe;

import com.example.demo.model.municipalityPopulationIkebe.MunicipalityPopulationIkebeMain;

import lombok.Data;

/**
 * 市区町村検索画面のFormクラス
 * 
 * @author FUTURE2024
 */
@Data
public class MunicipalityPopulationSearchForm {
	
	/** 市区町村別人口ID */
	private Integer id;
	
	/** 市区町村名 */
	private String municipality;
	
	/** 市区町村ID */
	private Integer municipalityId;
	
	/** 総人口ID */
	private Integer PopulationId;
	
	/** 削除フラグON用 */
	private int isDelete;
	
	/**
	 * 各フィールドに値を設定する
	 * 
	 * @param MunicipalityPopulationIkebeMain
	 */
	public void setValues(MunicipalityPopulationIkebeMain municipalityPopulationIkebeMain) {
		this.setId((int) municipalityPopulationIkebeMain.getId());
		this.setMunicipality(municipalityPopulationIkebeMain.getMunicipality());
		this.setMunicipalityId(municipalityPopulationIkebeMain.getMunicipalityId());
		this.setPopulationId(municipalityPopulationIkebeMain.getPopulationId());
	}

}
