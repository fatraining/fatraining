package jp.co.futureantiques.webapptraining.model.form.jojoShirasaka;

import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoMainShirasaka;
import lombok.Data;

/**
 * スタンド検索画面のFormクラス
 *
 */
@Data
public class JojoStandSearchForm {

	/** ID */
	private Integer standId;

	/** スタンド名 */
	private String standName;

	/** スタンド能力者 */
	private String standUserName;

	/** 性別ID */
	private Integer sexId;

	/** 能力 */
	private String ability;

	/** 登場部ID */
	private Integer appearanceId;

	/** 削除フラグON用 */
	private int isDelete;

	/** 各フィールドに値を設定する */
	public void setValues(JojoMainShirasaka jojoMainShirasaka) {
		this.setStandId((int) jojoMainShirasaka.getId());
		this.setStandName((String)jojoMainShirasaka.getStandName());
		this.setSexId((int)jojoMainShirasaka.getSexId());
		this.setAppearanceId((int)jojoMainShirasaka.getAppearanceId());
	}

}
