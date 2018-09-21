package jp.co.futureantiques.webapptraining.model.form.electronicsIto;

import jp.co.futureantiques.webapptraining.model.Electronics.ElectronicsMainIto;
import lombok.Data;

/**
 * 製品検索画面のFormクラス
 *
 * @author AIRI ITO
 *
 */
@Data
public class ElectronicsSearchForm {

	/** 製品ID */
	private Integer id;

	/** 製品名 */
	private String productName;

	/** カテゴリーID */
	private Integer categoryId;

	/** ブランドID */
	private Integer brandId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param electronicsMainIto
	 */

	public void setValues(ElectronicsMainIto electronicsMainIto) {
		this.setId((int) electronicsMainIto.getId());
		this.setProductName(electronicsMainIto.getProductName());
		this.setCategoryId(electronicsMainIto.getCategoryId());
		this.setBrandId(electronicsMainIto.getBrandId());
	}

}
