package com.example.demo.model.form.analogNoguchi;

import com.example.demo.model.analogNoguchi.AnalogMainNoguchi;

import lombok.Data;

/**
 *アナログゲーム検索画面のFormクラス
 * 
 * @author future
 */
@Data
public class AnalogNoguchiSearchForm {

	/** ゲームID */
	private Integer id;

	/** ゲーム名 */
	private String analogTitle;

	/** 種類ID */
	private Integer typeId;

	/** 対象年齢 */
	private Integer targetYears;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 * 
	 * @param analogMainNoguchi
	 */
	public void setValues(AnalogMainNoguchi analogMainNoguchi) {
		this.setId((int) analogMainNoguchi.getId());
		this.setAnalogTitle(analogMainNoguchi.getAnalogTitle());
		this.setTypeId(analogMainNoguchi.getTypeId());
		this.setTargetYears(analogMainNoguchi.getTargetYears());
	}
}
