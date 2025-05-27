package com.example.demo.model.form.vegetabletahara;

import com.example.demo.model.vegetabletahara.VegetableMainTahara;

import lombok.Data;

/**
 * 野菜検索画面のFormクラス
 *
 * @author future
 */
@Data
public class VegetableTaharaSearchForm {
	
	/** ID */
	private Integer id;

	/** 野菜の名前 */
	private String vegetableName;

	/** カテゴリーID */
	private Integer categoryId;

	/** 国内最大生産地ID */
	private Integer areaId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param vegetableMainTahara
	 */
	public void setValues(VegetableMainTahara vegetableMainTahara) {
		this.setId((int) vegetableMainTahara.getId());
		this.setVegetableName(vegetableMainTahara.getVegetableName());
		this.setCategoryId(vegetableMainTahara.getCategoryId());
		this.setAreaId(vegetableMainTahara.getAreaId());
	}

}
