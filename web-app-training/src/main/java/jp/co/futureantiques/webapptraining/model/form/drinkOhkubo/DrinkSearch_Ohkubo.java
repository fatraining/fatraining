package jp.co.futureantiques.webapptraining.model.form.drinkOhkubo;

import jp.co.futureantiques.webapptraining.model.drinkOhkubo.DrinkMain_Ohkubo;
import lombok.Data;
/**
 * 飲み物検索画面のFormクラス
 *
 * @author future
 */

@Data
public class DrinkSearch_Ohkubo {
	//ID
	private Integer id;

	//製品名
	private String drink_name;

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
	 * @param DrinkMain_Ohkubo
	 */

	public void setValues(DrinkMain_Ohkubo drinkMain) {
		this.setId((int) drinkMain.getId());
		this.setDrink_name(drinkMain.getDrinkName());
		this.setTypeId(drinkMain.getTypeId());
		this.setContainerId(drinkMain.getContainerId());
	}
}
