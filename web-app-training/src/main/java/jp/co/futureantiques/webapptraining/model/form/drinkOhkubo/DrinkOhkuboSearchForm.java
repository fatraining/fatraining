package jp.co.futureantiques.webapptraining.model.form.drinkOhkubo;

import jp.co.futureantiques.webapptraining.model.drinkOhkubo.DrinkMainOhkubo;
import lombok.Data;
/**
 * 飲み物検索画面のFormクラス
 *
 * @author future
 */

@Data
public class DrinkOhkuboSearchForm {
	//ID
	private Integer id;

	//製品名
	private String drinkName;

	//メーカーID
	private Integer makerId;

	//種類ID
	private Integer typeId;

	//容器ID
	private Integer containerId;

	//削除フラグON用
	private int isDelete;


	/**
	 * 各フィールドに値を設定する
	 *
	 * @param drinkMainOhkubo
	 */

	public void setValues(DrinkMainOhkubo drinkMainOhkubo) {
		this.setId((int) drinkMainOhkubo.getId());
		this.setDrinkName(drinkMainOhkubo.getDrinkName());
		this.setTypeId(drinkMainOhkubo.getTypeId());
		this.setContainerId(drinkMainOhkubo.getContainerId());
	}
}
