package jp.co.futureantiques.webapptraining.model.form.mlbUezu;

import jp.co.futureantiques.webapptraining.model.mlbUezu.MlbMainUezu;
import lombok.Data;

/** MLB球団検索画面のFormクラス */

@Data
public class MLBTeamSearchForm {

	/** ID */
	private Integer id;

	/** 球団名 */
	private String teamName;

	/** リーグID */
	private Integer leagueId;

	/** 地区ID */
	private Integer districtId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param mlbMainUezu
	 */
	public void setValues(MlbMainUezu mlbMainUezu) {
		this.setId((int) mlbMainUezu.getId());
		this.setTeamName(mlbMainUezu.getTeamName());
		this.setLeagueId(mlbMainUezu.getLeagueId());
		this.setDistrictId(mlbMainUezu.getDistrictId());
	}
}
