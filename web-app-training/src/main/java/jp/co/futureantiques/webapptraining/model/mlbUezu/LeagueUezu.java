package jp.co.futureantiques.webapptraining.model.mlbUezu;

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

/** LeagueUezuテーブルと対応するEntityクラス */

@Data
@Entity
public class LeagueUezu {

	/** リーグID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** リーグ */
	@Column(name = "league")
	@Size(max = 256)
	private String league;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：リーグID */
	@Transient
	@OneToMany(targetEntity = MlbMainUezu.class, mappedBy = "league")
	@JoinColumn(name = "id", referencedColumnName = "league_id")
	private List<MlbMainUezu> MLBMainUezu;
}