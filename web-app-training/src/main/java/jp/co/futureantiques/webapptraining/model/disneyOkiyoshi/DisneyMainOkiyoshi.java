package jp.co.futureantiques.webapptraining.model.disneyOkiyoshi;

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
	 * DisneyMainテーブルと対応するEntity
	 *
	 * @author future
	 */
	@Data
	@Entity
	public class DisneyMainOkiyoshi {

		/** 店舗ID */
		@Id
		@GenericGenerator(name = "gen", strategy = "increment")
		@GeneratedValue(generator = "gen")
		private long id;

		/** 店舗名 */
		@Column(name = "restaurant_name")
		@Size( max = 255)
		private String restaurantName;

		/** エリアID */
		@Column(name = "erea_id")
		private Integer ereaId;

		/** ジャンルID */
		@Column(name = "genre_id")
		private Integer genreId;

		/** コメント */
		@Column(name = "comment")
		@Size(max = 255)
		private String comment;

		/** 削除フラグ */
		@Column(name = "del_flg")
		private String delFlg;

		/** 登録日時 */
		@Column(name = "create_date")
		private Timestamp createDate;

		/** 更新日時 */
		@Column(name = "update_date")
		private Timestamp updateDate;

		/** 外部キー設定：エリア*/
		@ManyToOne(targetEntity = EreaOkiyoshi.class)
		@JoinColumn(name = "erea_id", referencedColumnName = "id", insertable = false, updatable = false)
		private EreaOkiyoshi ereaOkiyoshi;

		/** 外部キー設定：ジャンル */
		@ManyToOne(targetEntity = GenreOkiyoshi.class)
		@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
		private GenreOkiyoshi genreOkiyoshi;


	}
