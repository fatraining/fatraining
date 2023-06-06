package jp.co.futureantiques.webapptraining.model.form.apexWeaponHagiwara;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.ApexMainHagiwara;
import lombok.Data;

/**
 * 武器追加・更新画面用のフォームクラス
 *
 * @author Hagiwara
 */

@Data
public class ApexInputForm {

	/** 武器ID */
	private int id;

	/** 武器名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255,message = "magazine.text.error.invalid.name")
	private String name;

	/** 武器種ID */
	private Integer kindId;

	/** 使用アモID */
	private Integer ammoId;

	/** 胴ダメージ */
	@NotBlank(message = "common.text.error.require")
	@Size(min = 0, max = 5, message = "common.text.error.size.max.five")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String damageStr;

	/** DPS */
	@NotBlank(message = "common.text.error.require")
	@Size(min = 0, max = 5, message = "common.text.error.size.max.five")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String dpsStr;

	/** 更新日時(排他制御用) */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param apexMainHagiwara
	 */
	public void initWithApexMainHagiwara(ApexMainHagiwara apexMainHagiwara) {
		this.setId((int) apexMainHagiwara.getId());
		this.setName(apexMainHagiwara.getName());
		this.setKindId(apexMainHagiwara.getKindId());
		this.setAmmoId(apexMainHagiwara.getAmmoId());
		this.setDamageStr(String.valueOf(apexMainHagiwara.getDamage()));
		this.setDpsStr(String.valueOf(apexMainHagiwara.getDps()));

		this.setUpdateDate(String.valueOf(apexMainHagiwara.getUpdateDate()));
	}

	/**
	 * ApexMainHagiwaraエンティティに登録値を入れる
	 *
	 * @return ApexMainHagiwara
	 */
	public ApexMainHagiwara convertToApexMainHagiwaraForInsert() {
		ApexMainHagiwara apexMainHagiwara = new ApexMainHagiwara();
		apexMainHagiwara = convertToApexMainHagiwara(apexMainHagiwara);
		apexMainHagiwara.setCreateDate(new Timestamp(new Date().getTime()));
		apexMainHagiwara.setUpdateDate(apexMainHagiwara.getCreateDate());
		return apexMainHagiwara;
	}

	/**
	 * ApexMainHagiwaraエンティティに更新値を入れる
	 *
	 * @param ApexMainHagiwara
	 * @return ApexMainHagiwara
	 */
	public ApexMainHagiwara convertToApexMainHagiwaraForUpdate(ApexMainHagiwara apexMainHagiwara) {
		apexMainHagiwara = convertToApexMainHagiwara(apexMainHagiwara);
		apexMainHagiwara.setUpdateDate(new Timestamp(new Date().getTime()));
		return apexMainHagiwara;
	}

	/**
	 * ApexMainHagiwaraエンティティに入力値を入れる
	 *
	 * @param ApexMainHagiwara apexMainHagiwara
	 * @return ApexMainHagiwara
	 */
	private ApexMainHagiwara convertToApexMainHagiwara(ApexMainHagiwara apexMainHagiwara) {
		apexMainHagiwara.setName(this.name);

		if (this.kindId == CommonConst.NOT_ENTERD) {

			// 武器種が入力されていなかった場合
			apexMainHagiwara.setKindId(null);
		} else {

			// 武器種が入力されていた場合
			apexMainHagiwara.setKindId(this.kindId);
		}

		if (this.ammoId == CommonConst.NOT_ENTERD) {

			// 使用アモが入力されていなかった場合
			apexMainHagiwara.setAmmoId(null);
		} else {

			// 使用アモが入力されていた場合
			apexMainHagiwara.setAmmoId(this.ammoId);
		}
		apexMainHagiwara.setDamage(Integer.parseInt(this.damageStr));
		apexMainHagiwara.setDps(Integer.parseInt(this.dpsStr));
		apexMainHagiwara.setDelFlg(0);
		return apexMainHagiwara;
	}
}