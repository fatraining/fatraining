package jp.co.futureantiques.webapptraining.model.form.soccerteamMatsuda;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.soccerteamMatsuda.TeamMainMatsuda;
import lombok.Data;

/**
 * チーム登録・更新用のFormクラス
 *
 * @author future
 */
@Data
public class TeamMatsudaInputForm {

	/** ID */
	private int id;

	/** チーム名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String teamName;

	/** ホームタウンID */
	private Integer hometownId;

	/** チームカラーID */
	private Integer teamColorId;

	/** 注目選手 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String starPlayer;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateFlag;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param TeamMainMatsuda
	 */
	public void initWithTeamMainMatsuda(TeamMainMatsuda teamMain) {
		this.setId((int) teamMain.getId());
		this.setTeamName(teamMain.getTeamName());
		this.setHometownId(teamMain.getHometownId());
		this.setTeamColorId(teamMain.getTeamColorId());
		this.setStarPlayer(String.valueOf(teamMain.getStarPlayer()));
		this.setComment(teamMain.getComment());
		this.setUpdateFlag(String.valueOf(teamMain.getUpdateFlag()));
	}

	/**
	 * TeamMainMatsudaエンティティに登録値を入れる
	 *
	 * @return TeamMainMatsuda
	 */
	public TeamMainMatsuda convertToTeamMainMatsudaForInsert() {
		TeamMainMatsuda teamMain = new TeamMainMatsuda();
		teamMain = convertToTeamMainMatsuda(teamMain);
		teamMain.setCreateFlag(new Timestamp(new Date().getTime()));
		teamMain.setUpdateFlag(teamMain.getCreateFlag());
		return teamMain;
	}

	/**
	 * TeamMainMatsudaエンティティに更新値を入れる
	 *
	 * @param TeamMainMatsuda teamMain
	 * 	@return TeamMainMatsuda
	 */
	public TeamMainMatsuda convertToTeamMainMatsudaForUpdate(TeamMainMatsuda teamMain) {
		teamMain = convertToTeamMainMatsuda(teamMain);
		teamMain.setUpdateFlag(new Timestamp(new Date().getTime()));
		return teamMain;
	}

	/**
	 * TeamMainMatsudaエンティティに入力値を入れる
	 *
	 * @param TeamMainMatsuda teamMain
	 * @return TeamMainMatsuda
	 */
	private TeamMainMatsuda convertToTeamMainMatsuda(TeamMainMatsuda teamMainMatsuda) {
		teamMainMatsuda.setTeamName(this.teamName);
		teamMainMatsuda.setHometownId(this.hometownId);
		teamMainMatsuda.setTeamColorId(this.teamColorId);
		teamMainMatsuda.setStarPlayer(this.starPlayer);
		teamMainMatsuda.setDelFlag("0");
		return teamMainMatsuda;
	}
}