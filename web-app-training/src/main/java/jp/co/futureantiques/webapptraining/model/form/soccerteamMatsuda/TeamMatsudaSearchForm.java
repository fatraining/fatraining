package jp.co.futureantiques.webapptraining.model.form.soccerteamMatsuda;

import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.TeamMainMatsuda;
import lombok.Data;

/**
 * サッカーチーム検索画面のFormクラス
 *
 * @author future
 */
@Data
public class TeamMatsudaSearchForm {

	/** ID */
	private Integer id;

	/** チーム名 */
	private String teamName;

	/** ホームタウンID */
	private Integer hometownId;

	/** チームカラーID */
	private Integer teamColorId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param teamMainMatsuda
	 */
	public void setValues(TeamMainMatsuda teamMain) {
		this.setId((int) teamMain.getId());
		this.setTeamName(teamMain.getTeamName());
		this.setHometownId(teamMain.getHometownId());
		this.setTeamColorId(teamMain.getTeamColorId());
	}
}
