package com.example.demo.model.form.municipalityPopulationIkebe;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.municipalityPopulationIkebe.MunicipalityPopulationIkebeMain;

import lombok.Data;

/**
 * 市区町村登録・更新画面用のFormクラス
 * 
 * @author FUTURE2024
 */
@Data
public class MunicipalityPopulationInputForm {

	/** 市区町村ID */
	private int id;

	/** 市区町村名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 10)
	private String municipality;

	/** 市区町村区分 */
	private Integer municipalityId;

	/** 範囲指定(人口) */
	private Integer populationId;

	/** 総人口 */
	@Size(max = 9)
	private Integer population;

	/** 老年人口 */
	@Size(max = 7)
	private Integer elderlyPopulation;

	/** 高齢化率(%) */
	@Size(max = 6)
	private Integer aginglate;

	/** 人口密度(1㎢) */
	@Size(max = 10)
	private Integer populationDensity;

	/** 更新日時(排他制御用) */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param movieMain
	 */
	public void initWithMunicipalityPopulation(MunicipalityPopulationIkebeMain municipalityPopulationIkebeMain) {
		this.setId((int) municipalityPopulationIkebeMain.getId());
		this.setMunicipality(municipalityPopulationIkebeMain.getMunicipality());
		this.setMunicipalityId(municipalityPopulationIkebeMain.getMunicipalityId());
		this.setPopulationId(municipalityPopulationIkebeMain.getPopulationId());
		this.setPopulation(municipalityPopulationIkebeMain.getPopulation());
		this.setElderlyPopulation(municipalityPopulationIkebeMain.getElderlyPopulation());
		this.setAginglate(municipalityPopulationIkebeMain.getAginglate());
		this.setPopulationDensity(municipalityPopulationIkebeMain.getPopulationDensity());
		this.setUpdateDate(String.valueOf(municipalityPopulationIkebeMain.getUpdateDate()));
	}

	/**
	 * MunicipalityPopulationIkebeMainエンティティに登録値を入れる
	 *
	 * @return MunicipalityPopulationIkebeMain
	 */
	public MunicipalityPopulationIkebeMain convertToMunicipalityPopulationIkebeMainForInsert() {
		MunicipalityPopulationIkebeMain municipalityPopulationIkebeMain = new MunicipalityPopulationIkebeMain();
		municipalityPopulationIkebeMain = convertToMunicipalityPopulationIkebeMain(municipalityPopulationIkebeMain);
		municipalityPopulationIkebeMain.setCreateDate(new Timestamp(new Date().getTime()));
		municipalityPopulationIkebeMain.setUpdateDate(municipalityPopulationIkebeMain.getCreateDate());
		return municipalityPopulationIkebeMain;
	}

	/**
	 * MunicipalityPopulationIkebeMainエンティティに更新値を入れる
	 *
	 * @param MunicipalityPopulationIkebeMain municipalityPopulationIkebeMain
	 * @return MunicipalityPopulationIkebeMain
	 */
	public MunicipalityPopulationIkebeMain convertToMunicipalityPopulationIkebeMainForUpdate(
			MunicipalityPopulationIkebeMain municipalityPopulationIkebeMain) {
		municipalityPopulationIkebeMain = convertToMunicipalityPopulationIkebeMain(municipalityPopulationIkebeMain);
		municipalityPopulationIkebeMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return municipalityPopulationIkebeMain;
	}

	/**
	 * MunicipalityPopulationIkebeMainエンティティに入力値を入れる
	 *
	 * @param MunicipalityPopulationIkebeMain municipalityPopulationIkebeMain
	 * @return MunicipalityPopulationIkebeMain
	 */
	private MunicipalityPopulationIkebeMain convertToMunicipalityPopulationIkebeMain(
			MunicipalityPopulationIkebeMain municipalityPopulationIkebeMain) {
		municipalityPopulationIkebeMain.setMunicipality(this.municipality);
		if (this.municipalityId == CommonConst.NOT_ENTERD) {

			// Municipalityが入力されていなかった場合
			municipalityPopulationIkebeMain.setMunicipalityId(null);
		} else {

			// Municipalityが入力されていた場合
			municipalityPopulationIkebeMain.setMunicipalityId(this.municipalityId);
		}
		if (this.populationId == CommonConst.NOT_ENTERD) {

			// Populationが入力されていなかった場合
			municipalityPopulationIkebeMain.setPopulationId(null);
		} else {

			// Populationが入力されていた場合
			municipalityPopulationIkebeMain.setPopulationId(this.populationId);
		}
		municipalityPopulationIkebeMain.setPopulation(this.population);
		municipalityPopulationIkebeMain.setElderlyPopulation(this.elderlyPopulation);
		municipalityPopulationIkebeMain.setAginglate(this.aginglate);
		municipalityPopulationIkebeMain.setPopulationDensity(this.populationDensity);
		municipalityPopulationIkebeMain.setDelFlg("0");
		return municipalityPopulationIkebeMain;
	}

}
