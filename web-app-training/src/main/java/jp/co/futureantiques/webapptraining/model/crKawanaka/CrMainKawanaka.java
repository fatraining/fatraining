package jp.co.futureantiques.webapptraining.model.crKawanaka;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/*
 * SQL cr_main_kawanakaテーブルと対応しているエンティティ
 * @author Misato Kawanaka
 */
@Data
@Entity
public class CrMainKawanaka {

	/*CRID*/
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/*画像*/
	@Column(name = "image")
	private String Image;

	/*名前*/
	@Column(name = "name")
	private String name;

	/*カテゴリーID*/
	@Column(name = "category_id")
	private Integer categoryId;

	/*分布ID*/

	@Column(name = "distribution_id")
	private Integer distributionId;

	/*原因*/
	@Column(name = "cause")
	private String cause;

	/*削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/*外部キー設定:カテゴリー*/
	@ManyToOne(targetEntity = CategoryKawanaka.class)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
	private CategoryKawanaka categoryKawanaka;

	/*外部キー設定：分布*/
	@ManyToOne(targetEntity = DistributionKawanaka.class)
	@JoinColumn(name = "distribution_id", referencedColumnName = "distribution_id", insertable = false, updatable = false)
	private DistributionKawanaka distributionKawanaka;

}
