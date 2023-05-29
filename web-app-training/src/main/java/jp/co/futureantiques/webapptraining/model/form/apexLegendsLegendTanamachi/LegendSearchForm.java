package jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi;

import javax.validation.constraints.Size;

import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.LegendMainTanamachi;
import lombok.Data;

/**
 * レジェンド検索のFormクラス
 *
 * @author future
 */
@Data
public class LegendSearchForm {

	/** レジェンドID */
	private Integer legendId;

	/** レジェンド名 */
	@Size(max = 256 , message = "legend.text.error.invalid.name")
	private String legendName;

	/** 出身地ID */
	private Integer fromId;

	/** クラスID */
	private Integer classId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param legendMainTanamachi
	 */
	public void setValues(LegendMainTanamachi legendMainTanamachi) {
		this.setLegendId((int) legendMainTanamachi.getId());
		this.setLegendName(legendMainTanamachi.getLegendName());
		this.setFromId(legendMainTanamachi.getFromId());
		this.setClassId(legendMainTanamachi.getClassId());
	}


}
