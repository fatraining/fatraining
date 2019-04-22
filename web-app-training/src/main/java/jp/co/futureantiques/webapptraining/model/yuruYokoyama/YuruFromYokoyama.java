package jp.co.futureantiques.webapptraining.model.yuruYokoyama;

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
	 * MovieActorテーブルと対応するEntity
	 *
	 * @author future
	 */
	@Data
	@Entity
	public class YuruFromYokoyama {

		/** 出身ID */
		@Id
		@GeneratedValue
		@Column(name = "id")
		private int id;

		/** 都道府県 */
		@Column(name = "place")
		@Size(max = 255)
		private String place;

		/** 削除フラグ */
		@Column(name = "del_flg")
		private String delFlg;

		/** 登録日時 */
		@Column(name = "create_date")
		private String createDate;

		/** 更新日時 */
		@Column(name = "update_date")
		private String updateDate;

		/** 外部キー設定：俳優ID */
		@Transient
		@OneToMany(targetEntity = YuruDataYokoyama.class, mappedBy = "from")
		@JoinColumn(name = "id", referencedColumnName = "from_id")
		private List<YuruDataYokoyama> yuruDataList;
	}
