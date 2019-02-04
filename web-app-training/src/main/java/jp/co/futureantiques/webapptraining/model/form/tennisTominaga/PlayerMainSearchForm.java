package jp.co.futureantiques.webapptraining.model.form.tennisTominaga;

import jp.co.futureantiques.webapptraining.model.tennisTominaga.PlayerMainTominaga;
import lombok.Data;

/**
 * 選手検索画面のFormクラス
 *
 * @author future
 */
//このアノテーションでパラメータに対して、setter getter等が使えるようになる。inputと対応している https://blog.y-yuki.net/entry/2016/09/29/000000

@Data
public class PlayerMainSearchForm {

	/** ID */
	private Integer id;

	/** 選手名 */
	private String playerName;

	/** 国籍ID */
	private Integer nationalityId;

	/** 削除フラグON用 */
	private int isDelete;



	/**
	 * 各フィールドに値を設定する↓
	 *
	 * @param playerMainTominaga
	 */


	public void setValues(PlayerMainTominaga playerMainTominaga) {
		this.setId((int) playerMainTominaga.getId());
		this.setPlayerName(playerMainTominaga.getPlayerName());
		this.setNationalityId(playerMainTominaga.getNationalityId());
	}
}
