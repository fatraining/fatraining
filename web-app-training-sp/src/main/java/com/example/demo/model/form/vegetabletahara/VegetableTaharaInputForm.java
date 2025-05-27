package com.example.demo.model.form.vegetabletahara;

import java.sql.Timestamp;
import java.util.Date;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.vegetabletahara.VegetableMainTahara;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 野菜登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data
public class VegetableTaharaInputForm {

	/** ID */
	private int id;

	/** 野菜の名前 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String vegetableName;

	/** カテゴリーID */
	private Integer categoryId;

	/** 原産地 */
	@Size(max = 255)
	private String originPlace;

	/** 国内生産量(R2) */
	private Integer productionVolume;
	
	/** 国内最大生産地ID */
	private Integer areaId;

	/** おすすめの食べ方 */
	@Size(max = 255)
	private String recommend;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param vegetableMainTahara
	 */
	public void initWithVegetableMainTahara(VegetableMainTahara vegetablMainTahara) {
		this.setId((int) vegetablMainTahara.getId());
		this.setVegetableName(vegetablMainTahara.getVegetableName());
		this.setCategoryId(vegetablMainTahara.getCategoryId());
		this.setOriginPlace(vegetablMainTahara.getOriginPlace());
		this.setProductionVolume(vegetablMainTahara.getProductionVolume());
		this.setAreaId(vegetablMainTahara.getAreaId());
		this.setRecommend(vegetablMainTahara.getRecommend());
		this.setUpdateDate(String.valueOf(vegetablMainTahara.getUpdateDate()));
	}

	/**
	 * VegetableMainTaharaエンティティに登録値を入れる
	 *
	 * @return VegetableMainTahara
	 */
	public VegetableMainTahara convertToVegetableMainTaharaForInsert() {
		VegetableMainTahara vegetableMainTahara = new VegetableMainTahara();
		vegetableMainTahara = convertToVegetableMainTahara(vegetableMainTahara);
		vegetableMainTahara.setCreateDate(String.valueOf(new Timestamp(new Date().getTime())));
		vegetableMainTahara.setUpdateDate(vegetableMainTahara.getCreateDate());
		return vegetableMainTahara;
	}

	/**
	 * VegetableMainTaharaエンティティに更新値を入れる
	 *
	 * @param VegetableMainTahara vegetableMainTahara
	 * @return VegetableMainTahara
	 */
	public VegetableMainTahara convertToVegetableMainTaharaForUpdate(VegetableMainTahara vegetableMainTahara) {
		vegetableMainTahara = convertToVegetableMainTahara(vegetableMainTahara);
		vegetableMainTahara.setUpdateDate(String.valueOf(new Timestamp(new Date().getTime())));
		return vegetableMainTahara;
	}

	/**
	 * VegetableMainTaharaエンティティに入力値を入れる
	 *
	 * @param VegetableMainTahara vegetableMainTahara
	 * @return VegetableMainTahara
	 */
	private VegetableMainTahara convertToVegetableMainTahara(VegetableMainTahara vegetableMainTahara) {
		vegetableMainTahara.setVegetableName(this.vegetableName);
		
		if(this.categoryId == CommonConst.NOT_ENTERD) {
			// カテゴリーが入力されていなかった場合
			vegetableMainTahara.setCategoryId(null);
		}else {
			// カテゴリーが入力されていた場合
			vegetableMainTahara.setCategoryId(this.categoryId);
		}
		
		vegetableMainTahara.setOriginPlace(this.originPlace);
	
		vegetableMainTahara.setProductionVolume(this.productionVolume);
		
		if(this.areaId == CommonConst.NOT_ENTERD) {
			// 国内最大生産地が入力されていなかった場合
			vegetableMainTahara.setAreaId(null);
		}else {
			// 国内最大生産地が入力されていた場合
			vegetableMainTahara.setAreaId(this.areaId);
		}
		
		vegetableMainTahara.setRecommend(this.recommend);
		
		vegetableMainTahara.setDelFlg(0);
		
		return vegetableMainTahara;
	}
}