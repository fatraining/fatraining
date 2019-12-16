package jp.co.futureantiques.webapptraining.model.form.teamNagashima;


import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.teamNagashima.TeamMainNagashima;
import lombok.Data;
@Data
public class TeamNagashimaInputForm {

	/**ID*/
private int id;

/**チーム名*/
@NotBlank(message="common.text.error.require")
@Size(max=50)
private String name;

/**地域ID*/
private Integer regionId;

/**監督国籍ID*/
private Integer coachId;

/**設立年*/
@Size(max=4,message="common.text.error.require")
private Integer foundedYear;

/**タイトル数*/
@Size(max=2,message="common.text.error.require")
private Integer titles;

/**今注目の選手*/
@Size(max=50)
private String player;

/**更新日時（排他制御用）*/
private String updateDate;

/**
 * フィールドにエンティティの中身を入れる
 * @param teamMainNagashima
 */

public void initWithTeamMainNagashima(TeamMainNagashima teamMainNagashima) {
	this.setId((int)teamMainNagashima.getId());
	this.setName(teamMainNagashima.getName());
	this.setRegionId(teamMainNagashima.getRegionId());
	this.setCoachId(teamMainNagashima.getCoachId());
	this.setFoundedYear(teamMainNagashima.getFoundedYear());
	this.setTitles(teamMainNagashima.getTitles());
	this.setPlayer(teamMainNagashima.getPlayer());
	this.setUpdateDate(String.valueOf(teamMainNagashima.getUpdateDate()));

}
/**
 * TeamMainNagashimaエンティティに登録値を入れる
 * @return TeamMainNagashima
 */
public TeamMainNagashima convertToTeamMainNagashimaForInsert() {
	TeamMainNagashima teamMainNagashima=new TeamMainNagashima();
	teamMainNagashima=convertToTeamMainNagashima(teamMainNagashima);
	teamMainNagashima.setCreateDate(new Timestamp(new Date().getTime()));
	teamMainNagashima.setUpdateDate(teamMainNagashima.getCreateDate());
	return teamMainNagashima;


}
/**
 * TeamMainNagashimaエンティティに更新値を入れる
 *@param TeamMainNagashima teamMainNagashima
 * @return TeamMainNagashima
 */
public TeamMainNagashima convertToTeamMainNagashimaForUpdate(TeamMainNagashima teamMainNagashima) {
	teamMainNagashima=convertToTeamMainNagashima(teamMainNagashima);
	teamMainNagashima.setUpdateDate(new Timestamp(new Date().getTime()));
	return teamMainNagashima;
}
/**
 * TeamMainNagashimaエンティティに入力値を入れる
 *@param TeamMainNagashima teamMainNagashima
 * @return TeamMainNagashima
 */

public TeamMainNagashima convertToTeamMainNagashima(TeamMainNagashima teamMainNagashima) {
	teamMainNagashima.setName(this.name);
	if(this.regionId==CommonConst.NOT_ENTERD) {
		teamMainNagashima.setRegionId(null);

	}else {
		teamMainNagashima.setRegionId(this.regionId);
	}
	if(this.coachId==CommonConst.NOT_ENTERD) {
		teamMainNagashima.setCoachId(null);
	}else {
		teamMainNagashima.setCoachId(this.coachId);

	}
	teamMainNagashima.setFoundedYear(this.foundedYear);
	teamMainNagashima.setTitles(this.titles);
	teamMainNagashima.setPlayer(this.player);
	teamMainNagashima.setDelFlg("0");

	return teamMainNagashima;
}
}
