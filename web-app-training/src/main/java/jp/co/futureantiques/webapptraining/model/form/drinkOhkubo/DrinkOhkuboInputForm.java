package jp.co.futureantiques.webapptraining.model.form.drinkOhkubo;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.drinkOhkubo.DrinkMainOhkubo;
import lombok.Data;

/**
 * 飲み物登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data
public class DrinkOhkuboInputForm {

	/** ID */
	private int id;

	/** 製品名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String drinkName;

	/** メーカーID */
	private Integer makerId;

	/** 種類ID */
	private Integer typeId;

	/** 内容量 **/
	private Integer ml;

	/** 容器ID */
	private Integer containerId;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param drinkMainOhkubo
	 */
	public void initWithDrinkMainOhkubo(DrinkMainOhkubo drinkMainOhkubo) {
		this.setId((int) drinkMainOhkubo.getId());
		this.setDrinkName(drinkMainOhkubo.getDrinkName());
		this.setMakerId(drinkMainOhkubo.getMakerId());
		this.setTypeId(drinkMainOhkubo.getTypeId());
		//if(drinkMain.get)
		this.setContainerId(drinkMainOhkubo.getContainerId());
		this.setComment(drinkMainOhkubo.getComment());
		this.setUpdateDate(String.valueOf(drinkMainOhkubo.getUpdateDate()));
	}

	/**
	 * DrinkMainOhkuboエンティティに登録値を入れる
	 *
	 * @return DrinkMainOhkubo
	 */
	public DrinkMainOhkubo convertToDrinkMainOhkuboForInsert() {
		DrinkMainOhkubo drinkMainOhkubo = new DrinkMainOhkubo();
		drinkMainOhkubo = convertToDrinkMainOhkubo(drinkMainOhkubo);
		drinkMainOhkubo.setCreateDate(new Timestamp(new Date().getTime()));
		drinkMainOhkubo.setUpdateDate(drinkMainOhkubo.getCreateDate());
		return drinkMainOhkubo;
	}

	/**
	 * DrinkMainOhkuboエンティティに更新値を入れる
	 *
	 * @param DrinkMainOhkubo drinkMainOhkubo
	 * @return DrinkMainOhkubo
	 */
	public DrinkMainOhkubo convertToDrinkMainOhkuboForUpdate(DrinkMainOhkubo drinkMainOhkubo) {
		drinkMainOhkubo = convertToDrinkMainOhkubo(drinkMainOhkubo);
		drinkMainOhkubo.setUpdateDate(new Timestamp(new Date().getTime()));
		return drinkMainOhkubo;
	}

	/**
	 * DrinkMainOhkuboエンティティに入力値を入れる
	 *
	 * @param DrinkMainOhkubo drinkMainOhkubo
	 * @return DrinkMain
	 */
	private DrinkMainOhkubo convertToDrinkMainOhkubo(DrinkMainOhkubo drinkMainOhkubo) {
		drinkMainOhkubo.setDrinkName(this.drinkName);
		
		if(this.makerId == CommonConst.NOT_ENTERD) {

			// メーカー名が入力されていなかった場合
			drinkMainOhkubo.setMakerId(null);
		}else {

			// メーカー名が入力されていた場合
			drinkMainOhkubo.setMakerId(this.makerId);
		}

		if(this.typeId == CommonConst.NOT_ENTERD) {

			// 種類が入力されていなかった場合
			drinkMainOhkubo.setTypeId(null);
		}else {

			// 種類が入力されていた場合
			drinkMainOhkubo.setTypeId(this.typeId);
		}

		if(this.containerId == CommonConst.NOT_ENTERD) {

			// 容器が入力されていなかった場合
			drinkMainOhkubo.setContainerId(null);
		}else {

			// 容器が入力されていた場合
			drinkMainOhkubo.setContainerId(this.typeId);
		}
		
		drinkMainOhkubo.setComment(this.comment);
		drinkMainOhkubo.setDelFlg("0");
		return drinkMainOhkubo;
	}
}
