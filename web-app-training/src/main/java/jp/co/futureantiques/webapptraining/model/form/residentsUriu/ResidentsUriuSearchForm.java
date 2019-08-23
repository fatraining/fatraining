package jp.co.futureantiques.webapptraining.model.form.residentsUriu;

import jp.co.futureantiques.webapptraining.model.residentsUriu.ResidentsMainUriu;
import lombok.Data;

/**
 * 住人データ検索画面のformクラス
 *
 */

@Data
public class ResidentsUriuSearchForm {

	/** ID */
	private Integer id;

	/** なまえ */
	private String name;

	/** 性格ID */
	private Integer typeId;


	/** どうぶつID */
	private Integer animalId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param residentsMainUriu
	 */
	public void setValues(ResidentsMainUriu residentsMainUriu) {
		this.setId((int)residentsMainUriu.getId());
		this.setName(residentsMainUriu.getName());
		this.setTypeId(residentsMainUriu.getTypeId());
		this.setAnimalId(residentsMainUriu.getAnimalId());
	}

}
