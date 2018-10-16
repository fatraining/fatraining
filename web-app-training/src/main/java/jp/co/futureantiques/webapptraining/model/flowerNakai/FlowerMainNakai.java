package jp.co.futureantiques.webapptraining.model.flowerNakai;

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
 * SQL flower_main_nakaiテーブルと
 * 対応しているエンティティ
 * @author Rieko Nakai
 */
@Data
@Entity
public class FlowerMainNakai {

	/** 花ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 花の画像 */
	@Column(name = "flower_image")
	private String flowerImage;

	/** 花の名前 */
	@Column(name = "flower_name")
	private String flowerName;

	/** 月ID */
	@Column(name = "month_id")
	private Integer monthId;

	/** 色ID */
	@Column(name = "color_id")
	private Integer colorId;

	/** 原産国 */
	@Column(name = "country")
	private String country;

	/** 花言葉 */
	@Column(name = "word")
	private String word;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：月 */
	@ManyToOne(targetEntity = MonthNakai.class)
	@JoinColumn(name = "month_id", referencedColumnName = "month_id", insertable = false, updatable = false)
	private MonthNakai monthNakai;

	/** 外部キー設定：色 */
	@ManyToOne(targetEntity = ColorNakai.class)
	@JoinColumn(name = "color_id", referencedColumnName = "color_id", insertable = false, updatable = false)
	private ColorNakai colorNakai;
}
