package jp.co.futureantiques.webapptraining.model.form.alcoholishida;

import jp.co.futureantiques.webapptraining.model.alcoholishida.AlcoholMainIshida;
import lombok.Data;

/**
 *お酒検索画面のFormクラス
 * @author t.ishida
 *
 */

@Data
public class AlcoholIshidaSearchForm {

	/**ID*/
	private Integer id;

	/**お酒名*/
	private String alcoholName;

	/**リキュールID*/
	private Integer liqueurId;

	/**材料ID1*/
	private Integer ingredientId1;

	/**材料ID2*/
	private Integer ingredientId2;

	/**材料ID3*/
	private Integer ingredientId3;

	/**削除フラグ*/
	private int isDelete;

	/**
	 *
	 * 各フィールドに値を設定する
	 *
	 * @param alcoholMainIshida
	 */
	public void setValues(AlcoholMainIshida alcoholMainIshida) {
		this.setId((int) alcoholMainIshida.getId());
		this.setAlcoholName(alcoholMainIshida.getAlcoholName());
		this.setLiqueurId(alcoholMainIshida.getLiqueurId());
		this.setIngredientId1(alcoholMainIshida.getIngredientId1());
		this.setIngredientId2(alcoholMainIshida.getIngredientId2());
		this.setIngredientId3(alcoholMainIshida.getIngredientId3());
	}
}
