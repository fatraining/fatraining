package jp.co.futureantiques.webapptraining.model.form.PlayerShiono;

import jp.co.futureantiques.webapptraining.model.playerShiono.PlayerMainShiono;
import lombok.Data;

/**
 * 選手検索画面のFormクラス
 *
 * @author Shiono
 */
@Data
public class PlayerShionoSearchForm {

	/** ID */
	private Integer id;

	/** 選手名 */
	private String playerName;

	/** 国籍ID */
	private Integer nationalId;

	/** チームID */
	private Integer teamId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param playerMainShiono
	 */
	public void setValues(PlayerMainShiono playerMainShiono) {
		this.setId((int) playerMainShiono.getId());
		this.setPlayerName(playerMainShiono.getPlayerName());
		this.setNationalId(playerMainShiono.getNationalId());
		this.setTeamId(playerMainShiono.getTeamId());
	}
}
