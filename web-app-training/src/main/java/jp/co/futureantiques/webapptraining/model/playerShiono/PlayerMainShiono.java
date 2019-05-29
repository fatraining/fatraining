package jp.co.futureantiques.webapptraining.model.playerShiono;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * PlayerMainShionoテーブルと対応するEntity
 *
 * @author Shiono
 */
@Data
@Entity
public class PlayerMainShiono {


		/** 選手ID */
		@Id
		@GenericGenerator(name = "gen", strategy = "increment")
		@GeneratedValue(generator = "gen")
		private long id;

		/** 選手名 */
		@Column(name = "player_name")
		private String playerName;

		/** 国籍ID */
		@Column(name = "national_id")
		private Integer nationalId;

		/** チームID */
		@Column(name = "team_id")
		private Integer teamId;

		/** 生年月日 */
		@Column(name = "birth_day")
		private String birthDay;

		/** ポジション */
		@Column(name = "position_name")
		private String positionName;

		/** 削除フラグ */
		@Column(name = "del_flg")
		private String delFlg;

		/** 登録日時 */
		@Column(name = "create_date")
		private Timestamp createDate;

		/** 更新日時 */
		@Column(name = "update_date")
		private Timestamp updateDate;

		/** 外部キー設定：国籍 */
		@ManyToOne(targetEntity = NationalShiono.class)
		@JoinColumn(name = "national_id", referencedColumnName = "id", insertable = false, updatable = false)
		private NationalShiono nationalShiono;

		/** 外部キー設定：チーム */
		@ManyToOne(targetEntity = TeamShiono.class)
		@JoinColumn(name = "team_id", referencedColumnName = "id", insertable = false, updatable = false)
		private TeamShiono teamShiono;
	}
