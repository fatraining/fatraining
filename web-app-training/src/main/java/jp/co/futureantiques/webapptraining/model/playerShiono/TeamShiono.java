package jp.co.futureantiques.webapptraining.model.playerShiono;

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
	 * TeamShionoテーブルと対応するEntity
	 *
	 * @author Shiono
	 */
	@Data
	@Entity
	public class TeamShiono {

		/** チームID */
		@Id
		@GeneratedValue
		@Column(name = "id")
		private int id;

		/** チーム */
		@Column(name = "team")
		@Size(max = 30)
		private String team;

		/** 削除フラグ */
		@Column(name = "del_flg")
		private String delFlg;

		/** 登録日時 */
		@Column(name = "create_date")
		private String createDate;

		/** 更新日時 */
		@Column(name = "update_date")
		private String updateDate;

		/** 外部キー設定：チームID */
		@Transient
		@OneToMany(targetEntity = TeamShiono.class, mappedBy = "team")
		@JoinColumn(name = "id", referencedColumnName = "team_id")
		private List<PlayerMainShiono> playerMainList;
	}
