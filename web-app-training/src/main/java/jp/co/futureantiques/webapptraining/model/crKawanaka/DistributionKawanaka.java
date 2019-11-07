package jp.co.futureantiques.webapptraining.model.crKawanaka;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Data;

/*
 * SQL distribution_kawanakaテーブルと対応しているエンティティ
 * @author Misato Kawanaka
 */

@Data
@Entity
public class DistributionKawanaka {
	/*分布ID*/
	@Id
	@GeneratedValue
	@Column(name = "distribution_id")
	private int distributionId;

	/*分布*/
	@Column(name = "distribution")
	private String distribution;

	/*削除フラグ*/
	@Column(name = "del_flg")
	private String delFlg;

	/*登録日時*/
	@Column(name = "create_date")
	private Timestamp createDate;

	/*更新日時*/
	@Column(name = "update_date")
	private Timestamp updateDate;

	/*外部キー設定：分布ID*/
	@Transient
	@OneToMany(targetEntity = CrMainKawanaka.class, mappedBy = "distributionKawanaka")
	@JoinColumn(name = "distribution_id", referencedColumnName = "distribution_id")
	private DistributionKawanaka distributionKawanaka;

}
