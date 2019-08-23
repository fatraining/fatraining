package jp.co.futureantiques.webapptraining.model.form.saizeriyaKurimoto;

import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.SaizeriyaMenuMainKurimoto;
import lombok.Data;

/**映画検索画面のFormクラス
*@author future*/
@Data
public class SaizeriyaKurimotoSearchForm {

	/**ID*/
	private Integer id;

	/**メニュー名*/
	private String menuName;

	/**カテゴリID*/
	private Integer categoryId;

	/**価格帯ID*/
	private Integer priceId;

	/**削除フラグON用*/
	private int isDelete;

	/**各フィールドに値を設定する
	*@param saizeriyaMenuMainKurimoto*/

	public void setValues(SaizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto) {
		this.setId((int) saizeriyaMenuMainKurimoto.getId());
		this.setMenuName(saizeriyaMenuMainKurimoto.getMenuName());
		this.setCategoryId(saizeriyaMenuMainKurimoto.getCategoryId());
		this.setPriceId(saizeriyaMenuMainKurimoto.getPriceId());
	}
}
