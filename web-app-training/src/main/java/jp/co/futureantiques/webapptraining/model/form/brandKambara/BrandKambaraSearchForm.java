package jp.co.futureantiques.webapptraining.model.form.brandKambara;

import jp.co.futureantiques.webapptraining.model.brandkambara.BrandMainKambara;
import lombok.Data;

/**
 *ブランド検索画面のFormクラス
 *htmlで入力した値を格納
 * @author Yuki Kambara
 *
 */
@Data
public class BrandKambaraSearchForm {


	/** ブランドID */
	private Integer id;

	/** ブランド名 */
	private String brandName;

	/** ジャンルID */
	private Integer genreId;

	/** 生産国ID */
	private Integer countryId;

	/** 削除フラグON用 nullがNGの時、int*/
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param BrandMainKambara
	 */
	public void setValues(BrandMainKambara brandMainKambara) {
		this.setId((int)brandMainKambara.getId());
		this.setBrandName(brandMainKambara.getBrandName());
		this.setGenreId(brandMainKambara.getGenreId());
		this.setCountryId(brandMainKambara.getCountryId());
	}

}
