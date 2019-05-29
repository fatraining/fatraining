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
	 * NationalShionoテーブルと対応するEntityクラス
	 *
	 * @author Shiono
	 */
	@Data
	@Entity
	public class NationalShiono {

		/** 国籍ID */
		@Id
		@GeneratedValue
		@Column(name = "id")
		private int id;

		/** 国籍 */
		@Column(name = "national")
		@Size(max = 30)
		private String national;

		/** 削除フラグ */
		@Column(name = "del_flg")
		private String delFlg;

		/** 登録日時 */
		@Column(name = "create_date")
		private String createDate;

		/** 更新日時 */
		@Column(name = "update_date")
		private String updateDate;

		/** 外部キー設定：国籍ID */
		@Transient
		@OneToMany(targetEntity = PlayerMainShiono.class, mappedBy = "national")
		@JoinColumn(name = "id", referencedColumnName = "national_id")
		private List<PlayerMainShiono> playerMainList;
	}
