package jp.co.futureantiques.webapptraining.model.form.danmachiWang;

import jp.co.futureantiques.webapptraining.model.danmachi.Danmachi;
import lombok.Data;

/**
 *お酒検索画面のFormクラス
 * @author Wang
 *
 */

@Data
public class DanmachiSearchForm {

	private Integer id;

	private String name;

	private Integer famiID;

	private Integer raceID;

	/**削除フラグ*/
	private int isDelete;

	/**
	 *
	 * 各フィールドに値を設定する
	 *
	 * @param Danmachi
	 */

	public void setValue(Danmachi d) {
		this.setId((int)d.getId());
		this.setName(d.getName());
		this.setFamiID(d.getFamiID());
		this.setRaceID(d.getRaceID());
	}

}
