package jp.co.futureantiques.webapptraining.model.soccerteamMatsuda;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * team_main_matsudaテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class TeamMainMatsuda {

	/** チームID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** チーム名 */
	@Column(name = "team_name")
	@Size(max = 256)
	private String teamName;

	/** ホームタウンID */
	@Column(name = "hometown_id")
	private Integer hometownId;

	/** チームカラーID */
	@Column(name = "team_color_id")
	private Integer teamColorId;

	/** 注目選手 */
	@Column(name = "starplayer")
	@Size(max = 256)
	private String starPlayer;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 256)
	private String comment;

	/** 削除フラグ */
	@Column(name = "del_flag")
	private String delFlag;

	/** 登録日時 */
	@Column(name = "create_flag")
	private Timestamp createFlag;

	/** 更新日時 */
	@Column(name = "update_flag")
	private Timestamp updateFlag;

	/** 外部キー設定：ジャンル */
	@ManyToOne(targetEntity = HometownMatsuda.class)
	@JoinColumn(name = "hometown_id", referencedColumnName = "hometown_id", insertable = false, updatable = false)
	private HometownMatsuda hometown;

	/** 外部キー設定：俳優 */
	@ManyToOne(targetEntity = TeamColorMatsuda.class)
	@JoinColumn(name = "team_color_id", referencedColumnName = "team_color_id", insertable = false, updatable = false)
	private TeamColorMatsuda teamColor;
}