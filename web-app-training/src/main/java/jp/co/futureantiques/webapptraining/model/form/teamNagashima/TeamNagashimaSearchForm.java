package jp.co.futureantiques.webapptraining.model.form.teamNagashima;

import jp.co.futureantiques.webapptraining.model.teamNagashima.TeamMainNagashima;
import lombok.Data;
/**
 * チーム検索画面のFormクラス
 * @author future
 *
 */
 @Data
public class TeamNagashimaSearchForm{
	 /**ID*/
	private Integer id;

	/**チーム名*/
	private String name;

	/**地域ID*/
	private Integer regionId;

	/**監督国籍ID*/
	private Integer coachId;

	/**タイトル数*/
	private Integer titles;

	/**削除フラグON用*/
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 * @param teamMainNagashima
	 */


	public void setValues(TeamMainNagashima teamMainNagashima) {
		this.setId((int)teamMainNagashima.getId());
		this.setName(teamMainNagashima.getName());
		this.setRegionId(teamMainNagashima.getRegionId());
		this.setCoachId(teamMainNagashima.getCoachId());
		this.setTitles(teamMainNagashima.getTitles());


	}
}
