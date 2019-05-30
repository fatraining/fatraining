package jp.co.futureantiques.webapptraining.model.mlbUezu;

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

/** MLBMainUezuテーブルと対応するEntity */

@Data
@Entity
public class MlbMainUezu {

	/** 球団ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 映画名 */
	@Column(name = "team_name")
	private String teamName;

	/** 創設年 */
	@Column(name = "founding_year")
	private Integer foundingYear;

	/** 加盟年 */
	@Column(name = "membership_year")
	@Size(max = 256)
	private Integer membershipYear;

	/** 本拠地 */
	@Column(name = "headquarters")
	private String headquarters;

	/** リーグID */
	@Column(name = "league_id")
	private Integer leagueId;

	/** 地区ID */
	@Column(name = "district_id")
	private Integer districtId;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：リーグ */
	@ManyToOne(targetEntity = LeagueUezu.class)
	@JoinColumn(name = "league_id", referencedColumnName = "id", insertable = false, updatable = false)
	private LeagueUezu league;

	/** 外部キー設定：地区 */
	@ManyToOne(targetEntity = DistrictUezu.class)
	@JoinColumn(name = "district_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DistrictUezu district;
}