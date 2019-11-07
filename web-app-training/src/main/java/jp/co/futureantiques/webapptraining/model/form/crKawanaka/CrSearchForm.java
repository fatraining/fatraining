package jp.co.futureantiques.webapptraining.model.form.crKawanaka;

import jp.co.futureantiques.webapptraining.model.crKawanaka.CrMainKawanaka;
import lombok.Data;

/**
 * 日本の近絶滅検索画面のFormクラス
 * @author Misato Kawanaka
 * */
@Data
public class CrSearchForm {

	/**CRID*/
	private Integer id;

	/**名前*/
	private String name;

	/**カテゴリーID*/
	private Integer categoryId;

	/**分布ID*/
	private Integer distributionId;

	/**削除フラグON用*/
	private int isDelete;

	/**各フィールドに値を設定する
	 *@param CrMainKawanaka crMainKawanaka*/
	public void setValues(CrMainKawanaka crMainKawanaka) {
		this.setId((int) crMainKawanaka.getId());
		this.setName(crMainKawanaka.getName());
		this.setCategoryId(crMainKawanaka.getCategoryId());
		this.setDistributionId(crMainKawanaka.getDistributionId());
	}
}
