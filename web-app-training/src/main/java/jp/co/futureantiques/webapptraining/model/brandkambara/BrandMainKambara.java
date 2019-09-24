package jp.co.futureantiques.webapptraining.model.brandkambara;

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
	 * BrandMainKambaraテーブルと対応するEntity
	 *
	 * @author Yuki Kambara
	 */
	@Data
	@Entity
	public class BrandMainKambara {

		/**ブランドID */
		//主キーの指定
		@Id
		@GenericGenerator(name = "gen", strategy = "increment")
		//自動採番
		@GeneratedValue(generator = "gen")
		private long id;

		/** ブランド名 */
		//カラム名
		@Column(name = "brand_name")
		@Size(max = 256)
		private String brandName;

		/** ジャンルID */
		@Column(name = "genre_id")
		private Integer genreId;

		/** デザイナー */
		@Column(name = "designer")
		@Size(max = 256)
		private String designer;

		/** 創業年 */
		@Column(name = "release_year")
		private Integer releaseYear;

		/** 生産国ID */
		@Column(name = "country_id")
		private Integer countryId;

		/** コメント */
		@Column(name = "comment")
		@Size(max = 256)
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

		/** 外部キー設定：ジャンル */
		//多対一関連定義
		// （メインのレコードはジャンル の複数のレコードと関連する可能性があるが、ジャンルのレコードは メインのレコードと最大一件のみ関連する）
		@ManyToOne(targetEntity = GenreKambara.class)
		@JoinColumn(name = "genre_id", referencedColumnName = "genre_id", insertable = false, updatable = false)
		private GenreKambara genreKambara;


		/** 外部キー設定：生産国 */
		@ManyToOne(targetEntity = MadeCountryKambara.class)
		@JoinColumn(name = "country_id", referencedColumnName = "country_id", insertable = false, updatable = false)
		private  MadeCountryKambara madeCountryKambara;


	}




