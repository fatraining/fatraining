package jp.co.futureantiques.webapptraining.model.form.PlayerShiono;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.playerShiono.PlayerMainShiono;
import lombok.Data;

/**
 * 選手登録・更新画面用のFormクラス
 *
 * @author future
 *
 */
@Data
public class PlayerShionoInputForm {

	/** ID */
	private int id;

	/** 選手名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 30)
	private String playerName;

	/** 国籍ID */
	private Integer nationalId;

	/** チームID */
	private Integer teamId;

	/** 生年月日 */
	private String birthDay;

	/** ポジション */
	private String positionName;

	/** 更新日時(排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param playerMainShiono
	 */
	public void initWithPlayerMainShiono(PlayerMainShiono playerMainShiono) {
		this.setId((int) playerMainShiono.getId());
		this.setPlayerName(playerMainShiono.getPlayerName());
		this.setNationalId(playerMainShiono.getNationalId());
		this.setTeamId(playerMainShiono.getTeamId());
		this.setBirthDay(playerMainShiono.getBirthDay());
		this.setPositionName(playerMainShiono.getPositionName());
		this.setUpdateDate(String.valueOf(playerMainShiono.getUpdateDate()));
	}

	/**
	 * PlayerMainShionoエンティティに登録値を入れる
	 * @return
	 */
	public PlayerMainShiono convertToPlayerMainShionoForInsert() {
		PlayerMainShiono playerMainShiono = new PlayerMainShiono();
		playerMainShiono = convertToPlayerMainShiono(playerMainShiono);
		playerMainShiono.setCreateDate(new Timestamp(new Date().getTime()));
		playerMainShiono.setUpdateDate(playerMainShiono.getCreateDate());
		return playerMainShiono;
	}

	/**
	 * PlayerMainShionoエンティティに更新値を入れる
	 *
	 * @param PlayerMainShiono playerMainShiono
	 * @return PlayerMainShiono
	 */
	public PlayerMainShiono convertToPlayerMainShionoForUpdate(PlayerMainShiono playerMainShiono) {
		playerMainShiono = convertToPlayerMainShiono(playerMainShiono);
		playerMainShiono.setUpdateDate(new Timestamp(new Date().getTime()));
		return playerMainShiono;
	}

	/**
	 * PlayerMainShionoエンティティに入力値を入れる
	 *
	 * @param PlayerMainShiono playerMainShiono
	 * @return PlayerMainShiono
	 */
	private PlayerMainShiono convertToPlayerMainShiono(PlayerMainShiono playerMainShiono) {
		playerMainShiono.setPlayerName(this.playerName);
		playerMainShiono.setNationalId(this.nationalId);
		playerMainShiono.setTeamId(this.teamId);
		playerMainShiono.setBirthDay(this.birthDay);
		playerMainShiono.setPositionName(this.positionName);
		playerMainShiono.setDelFlg("0");
		return playerMainShiono;
	}
}
