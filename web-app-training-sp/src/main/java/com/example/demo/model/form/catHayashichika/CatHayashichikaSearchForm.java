package com.example.demo.model.form.catHayashichika;

import com.example.demo.model.catHayashichika.CatMainHayashichika;

import lombok.Data;

/**
 * 猫検索画面のFormクラス
 * 
 * @author future
 */
@Data
public class CatHayashichikaSearchForm {
	/**ID*/
	private Integer id;

	/**猫種名*/
	private String catName;

	/**毛種ID*/
	private Integer typeId;

	/**体型ID*/
	private Integer sizeId;

	/**原産国ID*/
	private Integer fromId;

	/**削除フラグON用*/
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 * @param catMain
	 */
	public void setValues(CatMainHayashichika catMain) {
		this.setId((int) catMain.getId());
		this.setCatName(catMain.getCatName());
		this.setTypeId(catMain.getTypeId());
		this.setSizeId(catMain.getSizeId());
		this.setFromId(catMain.getFromId());

	}

}
