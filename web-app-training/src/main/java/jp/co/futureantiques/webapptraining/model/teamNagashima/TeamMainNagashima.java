package jp.co.futureantiques.webapptraining.model.teamNagashima;

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
 * TeamMainNagashimaテーブルと対応するEntity
 * @author future
 *
 */
@Data
@Entity
public class TeamMainNagashima {

	/**チームID*/
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/**チーム名*/
	@Column(name = "name")
	@Size(max=50)
	private String name;

	/**地域ID*/
	@Column(name = "region_id")
	private Integer regionId;

	/**監督国籍ID*/
	@Column(name = "coach_id")
	private Integer coachId;

	/**設立年*/
	@Column(name = "founded_year")
	private Integer foundedYear;

	/**タイトル数*/
	@Column(name = "titles")
	private Integer titles;

	/**今注目の選手*/
	@Column(name = "player")
	@Size(max=50)
	private String player;

	/**削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/**登録日時*/
	@Column(name = "create_date")
	private Timestamp createDate;

	/**更新日時*/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/**外部キー設定：地域*/
	@ManyToOne(targetEntity = RegionNagashima.class)
	@JoinColumn(name = "region_id", referencedColumnName = "region_id", insertable = false, updatable = false)
	private RegionNagashima regionNagashima;

	/**外部キー設定：監督国籍*/
	@ManyToOne(targetEntity = CoachNagashima.class)
	@JoinColumn(name = "coach_id", referencedColumnName = "coach_id", insertable = false, updatable = false)
	private CoachNagashima coachNagashima;
}
