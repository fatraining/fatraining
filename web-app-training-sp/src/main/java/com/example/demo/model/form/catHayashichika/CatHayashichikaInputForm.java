package com.example.demo.model.form.catHayashichika;

import java.sql.Timestamp;
import java.util.Date;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.catHayashichika.CatMainHayashichika;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 *猫登録・更新用のFormクラス
 *@author future 
 */
@Data
public class CatHayashichikaInputForm {

	/**ID*/
	private int id;

	/**猫種名*/
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String catName;

	/**毛種ID*/
	private Integer typeId;

	/**体型ID*/
	private Integer sizeId;

	/**原産国ID*/
	private Integer fromId;

	/**特徴*/
	@Size(max = 255)
	private String point;

	/**更新日時（排他制御用）*/
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 * @param catMain
	 * 
	 */
	public void initWithCatMain(CatMainHayashichika catMain) {
		this.setId((int) catMain.getId());
		this.setCatName(catMain.getCatName());
		this.setTypeId(catMain.getTypeId());
		this.setSizeId(catMain.getSizeId());
		this.setFromId(catMain.getFromId());
		this.setPoint(catMain.getPoint());
		this.setUpdateDate(String.valueOf(catMain.getUpdateDate()));

	}

	/**
	 * CatMainエンティティに登録値を入れる
	 * @return CatMainHayashichika
	 */
	public CatMainHayashichika convertToCatMainForInsert() {
		CatMainHayashichika catMain = new CatMainHayashichika();
		catMain = convertToCatMain(catMain);
		catMain.setCreateDate(new Timestamp(new Date().getTime()));
		catMain.setUpdateDate(catMain.getCreateDate());
		return catMain;

	}

	/**CatMainエンティティに更新値を入れる
	 * @param CatMainHayashichika catMain
	 * @return CatMainHayashichika
	 */
	public CatMainHayashichika convertToCatMainForUpdate(CatMainHayashichika catMain) {
		catMain = convertToCatMain(catMain);
		catMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return catMain;

	}

	/**
	 * CatMainエンティティに入力値を入れる
	 * @param CatMainHayashichika catMain
	 * @return CatMainHayashichika
	 */
	private CatMainHayashichika convertToCatMain(CatMainHayashichika catMain) {
		catMain.setCatName(this.catName);
		if (this.typeId == CommonConst.NOT_ENTERD) {
			//毛種が入力されていなかった場合
			catMain.setTypeId(null);
		} else {
			//毛種が入力されていた場合
			catMain.setTypeId(this.typeId);
		}

		if (this.sizeId == CommonConst.NOT_ENTERD) {
			//体型が入力されていなかった場合
			catMain.setSizeId(null);
		} else {
			//体型が入力されていた場合
			catMain.setSizeId(this.sizeId);
		}

		if (this.fromId == CommonConst.NOT_ENTERD) {
			//原産国が入力されていなかった場合
			catMain.setFromId(null);
		} else {
			//原産国が入力されていた場合
			catMain.setFromId(this.fromId);
		}
		catMain.setPoint(this.point);
		catMain.setDelFlag("0");
		return catMain;
	}
	

}
