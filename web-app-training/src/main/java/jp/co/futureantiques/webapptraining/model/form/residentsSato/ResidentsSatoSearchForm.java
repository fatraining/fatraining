package jp.co.futureantiques.webapptraining.model.form.residentsSato;

import jp.co.futureantiques.webapptraining.model.residentsSato.ResidentsMainSato;
import lombok.Data;

/**
 * 住民検索画面のFormクラス
 * @author future
 */
@Data
public class ResidentsSatoSearchForm {

	/** ID */
	private Integer id;

	/** 住民名 */
	private String residentsName;

	/** 動物ID */
	private Integer animalId;

	/** 性別ID */
	private Integer sexId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param residentsMainSato
	 */
	public void setValues(ResidentsMainSato residentsMainSato) {
		this.setId((int) residentsMainSato.getId());
		this.setResidentsName(residentsMainSato.getResidentsName());
		this.setAnimalId(residentsMainSato.getAnimalId());
		this.setSexId(residentsMainSato.getSexId());
	}
}
