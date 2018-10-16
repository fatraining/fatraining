package jp.co.futureantiques.webapptraining.model.flowerNakai;

import java.sql.Timestamp;
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
 * color_nakaiテーブルと対応するEntity
 *@author Rieko Nakai
 */
@Data
@Entity
public class MonthNakai {

	/** 月ID */
	@Id
	@GeneratedValue
	@Column(name = "month_id")
	private int monthId;

	/** 月 */
	@Column(name = "month")
	@Size(max = 256)
	private String month;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：月ID */
	@Transient
	@OneToMany(targetEntity = FlowerMainNakai.class, mappedBy = "monthNakai")
	@JoinColumn(name = "month_id", referencedColumnName = "month_id")
	private List<FlowerMainNakai> flowerMainNakai;
}
