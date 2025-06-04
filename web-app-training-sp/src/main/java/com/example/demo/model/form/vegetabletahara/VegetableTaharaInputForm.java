package com.example.demo.model.form.vegetabletahara;

import java.sql.Timestamp;
import java.util.Date;

import com.example.demo.model.vegetabletahara.VegetableMainTahara;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
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
	@Size(max = 20, message = "vegetable.text.error.string(20).require")
	private String vegetableName;

	/** カテゴリーID */
	@Positive(message = "common.text.error.require")
	private Integer categoryId;

	/** 原産地 */
	@Size(max = 20, message = "vegetable.text.error.string(20).require")
	private String originPlace;

	/** 国内生産量(R2)
	 * @Pattern：「https://www.javadrive.jp/regex-basic/」とサンプルを参考に入力された場合の値が数字か否かを判定
	 * */
	@Size(min = 0, max = 10,  message = "vegetable.text.error.int.require")
	@Pattern(regexp = "^(0|[1-9][0-9]*$)?", message = "vegetable.text.error.NotInt.require")
	private String productionVolume;
	
	/** 国内最大生産地ID */
	@Positive(message = "common.text.error.require")
	private Integer areaId;

	/** おすすめの食べ方 */
	@Size(max = 100, message = "vegetable.text.error.String(100).require")
	private String recommend;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/*カテゴリーIDと国内最大生産地IDにある「＠Positive」は、正の数か否かを判定するもの。
	 * →＠NotNullや＠NotBlankでは、Nullや空か否かを判定するので、0は素通りされてしまう
	 * 　よって、＠Positiveを使うことで、0をエラーとして処理できる*/
	
	
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
		//画面に「null」と表示されないように、国内生産量がある場合だけ中身を入れるようにする	
		if(vegetablMainTahara.getProductionVolume() != null) {
			this.setProductionVolume(String.valueOf(vegetablMainTahara.getProductionVolume()));
		}
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
		vegetableMainTahara.setCategoryId(this.categoryId);
		vegetableMainTahara.setOriginPlace(this.originPlace);
		if(this.productionVolume == "") {
			//国内生産量が入力されていない場合
			vegetableMainTahara.setProductionVolume(null);
		}else {
			//国内生産量が入力されていた場合
			vegetableMainTahara.setProductionVolume(Integer.parseInt(this.productionVolume));
		}
		vegetableMainTahara.setAreaId(this.areaId);
		vegetableMainTahara.setRecommend(this.recommend);
		vegetableMainTahara.setDelFlg(0);
		return vegetableMainTahara;
	}
}