package jp.co.futureantiques.webapptraining.model.form.yuruYokoyama;

import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruDataYokoyama;
import lombok.Data;

/**
 * 映画検索画面のFormクラス
 *
 * @author future
 */
@Data
public class YuruSearchFrom {

	/** ID */
	private Integer id;

	/** 名前 */
	private String name;

	/** 出身ID */
	private Integer fromId;

	/** 所属ID */
	private Integer belongId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param yuruData
	 */
	public void setValues(YuruDataYokoyama yuruData) {
		this.setId((int) yuruData.getId());
		this.setName(yuruData.getName());
		this.setFromId(yuruData.getFromId());
		this.setBelongId(yuruData.getBelongId());
	}
}
