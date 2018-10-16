package jp.co.futureantiques.webapptraining.model.form.flowerNakai;

import jp.co.futureantiques.webapptraining.model.flowerNakai.FlowerMainNakai;
import lombok.Data;

/**
 * 花検索画面のFormクラス
 * @author Rieko Nakai
 */
@Data
public class FlowerSearchForm {
	/* ID */
	private Integer id;

	/* 花の名前 */
	private String flowerName;

	/* 月ID */
	private Integer monthId;

	/* 色ID */
	private Integer colorId;

	/* 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 * @param FlowerMainNakai flowerMainNakai
	 */
	public void setValues(FlowerMainNakai flowerMainNakai) {
		this.setId((int) flowerMainNakai.getId());
		this.setFlowerName(flowerMainNakai.getFlowerName());
		this.setMonthId(flowerMainNakai.getMonthId());
		this.setColorId(flowerMainNakai.getColorId());
	}

}
