package jp.co.futureantiques.webapptraining.model.heritagekataoka;

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
 * HeritageMainテーブルと対応するエンティティ
 * @author user MIKI KATAOKA
 *
 */

@Data
@Entity
public class HeritageMainKataoka {

	/** 世界遺産ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/**  ジャンルID */
	@Column(name = "genre_id")
	private int genreId;

	/**  画像 */
	@Column(name = "image")
	private String image;

	/** 登録名 */
	@Column(name = "heritage_name")
	private String heritageName;

	/** 所在地_1 */
	@Column(name = "location_id1")
	private Integer locationId1;

	/** 所在地_2 */
	@Column(name = "location_id2")
	private Integer locationId2;

	/** 所在地_3 */
	@Column(name = "location_id3")
	private Integer locationId3;

	/** 所在地_4 */
	@Column(name = "location_id4")
	private Integer locationId4;

	/** 所在地_5 */
	@Column(name = "location_id5")
	private Integer locationId5;

	/** 所在地_6 */
	@Column(name = "location_id6")
	private Integer locationId6;

	/** 所在地_7 */
	@Column(name = "location_id7")
	private Integer locationId7;

	/** 所在地_8 */
	@Column(name = "location_id8")
	private Integer locationId8;

	/** 登録年 */
	@Column(name = "registration_year")
	private Integer registrationYear;

	/** 備考 */
	@Column(name = "remarks")
	@Size(max = 200)
	private String remarks;

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
	@ManyToOne(targetEntity = GenreKataoka.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreKataoka genreKataoka;

	/** 外部キー設定：所在地1 */
	@ManyToOne(targetEntity = LocationKataoka.class)
	@JoinColumn(name = "location_id1", referencedColumnName = "id", insertable = false, updatable = false)
	private LocationKataoka locationKataoka1;

	/** 外部キー設定：所在地2 */
	@ManyToOne(targetEntity = LocationKataoka.class)
	@JoinColumn(name = "location_id2", referencedColumnName = "id", insertable = false, updatable = false)
	private LocationKataoka locationKataoka2;

	/** 外部キー設定：所在地3 */
	@ManyToOne(targetEntity = LocationKataoka.class)
	@JoinColumn(name = "location_id3", referencedColumnName = "id", insertable = false, updatable = false)
	private LocationKataoka locationKataoka3;

	/** 外部キー設定：所在地4 */
	@ManyToOne(targetEntity = LocationKataoka.class)
	@JoinColumn(name = "location_id4", referencedColumnName = "id", insertable = false, updatable = false)
	private LocationKataoka locationKataoka4;

	/** 外部キー設定：所在地5 */
	@ManyToOne(targetEntity = LocationKataoka.class)
	@JoinColumn(name = "location_id5", referencedColumnName = "id", insertable = false, updatable = false)
	private LocationKataoka locationKataoka5;

	/** 外部キー設定：所在地6 */
	@ManyToOne(targetEntity = LocationKataoka.class)
	@JoinColumn(name = "location_id6", referencedColumnName = "id", insertable = false, updatable = false)
	private LocationKataoka locationKataoka6;

	/** 外部キー設定：所在地7 */
	@ManyToOne(targetEntity = LocationKataoka.class)
	@JoinColumn(name = "location_id7", referencedColumnName = "id", insertable = false, updatable = false)
	private LocationKataoka locationKataoka7;

	/** 外部キー設定：所在地8 */
	@ManyToOne(targetEntity = LocationKataoka.class)
	@JoinColumn(name = "location_id8", referencedColumnName = "id", insertable = false, updatable = false)
	private LocationKataoka locationKataoka8;

}
