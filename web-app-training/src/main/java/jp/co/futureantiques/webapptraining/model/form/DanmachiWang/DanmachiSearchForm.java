package jp.co.futureantiques.webapptraining.model.form.DanmachiWang;

import jp.co.futureantiques.webapptraining.model.DanmachiWang.DanmachiMain;
import lombok.Data;

/**
 *お酒検索画面のFormクラス
 * @author Wang
 *
 */

@Data

public class DanmachiSearchForm {

	private Long id;

	private String name;

	private Long famiId;

	private Long raceId;

	/**削除フラグ*/
	private int isDelete;

	/**
	 *
	 * 各フィールドに値を設定する
	 *
	 * @param Danmachi
	 */

	public void setValue(DanmachiMain d) {
		this.setId((long)d.getId());
		this.setName(d.getName());
		this.setFamiId(d.getFamiId());
		this.setRaceId(d.getRaceId());
	}

}
