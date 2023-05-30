package jp.co.futureantiques.webapptraining.model.form.apexWeaponHagiwara;

import jp.co.futureantiques.webapptraining.model.apexweaponHagiwara.ApexMainHagiwara;
import lombok.Data;

/**
 * 武器検索画面のFormクラス
 *
 * @author  Hagiwara
 */
@Data
public class ApexSearchForm {

	/** 武器ID */
	private Integer id;

	/** 武器名 */
	private String name;

	/** 武器種ID */
	private Integer kindId;

	/** 使用アモID */
	private Integer ammoId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param apexMainHagiwara
	 */
	public void setValues(ApexMainHagiwara apexMainHagiwara) {
		this.setId((int) apexMainHagiwara.getId());
		this.setName(apexMainHagiwara.getName());
		this.setKindId(apexMainHagiwara.getKindId());
		this.setAmmoId(apexMainHagiwara.getAmmoId());
	}

}