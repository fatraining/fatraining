package jp.co.futureantiques.webapptraining.model.soccerteamMatsuda;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * team_color_matsudaテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class TeamColorMatsuda {

	/** チームカラーID */
	@Id
	@GeneratedValue
	@Column(name = "team_color_id")
	private int teamColorId;

	/** チームカラー */
	@Column(name = "team_color")
	@Size(max = 256)
	private String teamColor;

	/** 削除フラグ */
	@Column(name = "del_flag")
	private String delFlag;

	/** 登録日時 */
	@Column(name = "create_flag")
	private String createFlag;

	/** 更新日時 */
	@Column(name = "update_flag")
	private String updateFlag;

	/** 外部キー設定：俳優ID */
	@Transient
	@OneToMany(targetEntity = TeamMainMatsuda.class, mappedBy = "team_color_matsuda")
	@JoinColumn(name = "team_color_id", referencedColumnName = "team_color_id")
	private List<TeamMainMatsuda> TeamMainMatsudaList;
}