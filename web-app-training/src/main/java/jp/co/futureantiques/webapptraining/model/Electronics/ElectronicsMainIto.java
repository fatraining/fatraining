package jp.co.futureantiques.webapptraining.model.Electronics;

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
 * ElectricsMainテーブルと対応するエンティティ
 * @author user AIRI ITO
 *
 */
@Data
@Entity
public class ElectronicsMainIto {

	/** 製品ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 製品名 */
	@Column(name = "product_name")
	private String productName;

	/** カテゴリーID */
	@Column(name = "category_id")
	private Integer categoryId;

	/** ブランドID */
	@Column(name = "brand_id")
	private Integer brandId;

	/** 発売年 */
	@Column(name = "release_year")
	private int releaseYear;

	/** 価格 */
	@Column(name = "price")
	private Integer price;

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
	@Column(name ="update_date")
	private Timestamp updateDate;

	/** 外部キー設定：カテゴリー */
	@ManyToOne(targetEntity = CategoryIto.class)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
	private CategoryIto categoryIto;

	/** 外部キー設定：ブランド */
	@ManyToOne(targetEntity = BrandIto.class)
	@JoinColumn(name = "brand_id", referencedColumnName = "brand_id", insertable = false, updatable = false)
	private BrandIto brandIto;

}
