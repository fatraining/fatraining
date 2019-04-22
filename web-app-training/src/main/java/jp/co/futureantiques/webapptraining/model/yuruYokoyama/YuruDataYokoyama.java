package jp.co.futureantiques.webapptraining.model.yuruYokoyama;


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
	 * MovieMainテーブルと対応するEntity
	 *
	 * @author future
	 */
	@Data
	@Entity
	public class YuruDataYokoyama {

		/** ゆるキャラID */
		@Id
		@GenericGenerator(name = "gen", strategy = "increment")
		@GeneratedValue(generator = "gen")
		private long id;

		/** 名前 */
		@Column(name = "name")
		private String name;

		/** 出身ID */
		@Column(name = "from_id")
		private Integer fromId;

		/** 所属ID */
		@Column(name = "belong_id")
		private Integer belongId;

		/** 特徴 */
		@Column(name = "point")
		@Size(max = 255)
		private String point;

		/** 画像 */
		@Column(name = "run_time")
		private Integer runTime;

		/** 削除フラグ */
		@Column(name = "del_flg")
		private String delFlg;

		/** 登録日時 */
		@Column(name = "create_date")
		private Timestamp createDate;

		/** 更新日時 */
		@Column(name = "update_date")
		private Timestamp updateDate;

		/** 外部キー設定：ジャンル */
		@ManyToOne(targetEntity = YuruBelongYokoyama.class)
		@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
		private YuruBelongYokoyama yuruBelong;

		/** 外部キー設定：出身 */
		@ManyToOne(targetEntity = YuruFromYokoyama.class)
		@JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false)
		private YuruFromYokoyama yuruFrom;
}
