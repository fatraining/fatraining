package jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi;

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
 * from_tanamachiテーブルと対応するEntityクラス
 *
 * @author future
 */
@Data
@Entity
public class FromTanamachi {

	/** 出身地ID */
	@Id
	@GeneratedValue
	@Column(name = "from_id")
	private int id;

	/** 出身地 */
	@Column(name = "from")
	@Size(max = 256)
	private String from;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private Integer delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：出身地ID */
	@Transient
	@OneToMany(targetEntity = LegendMainTanamachi.class, mappedBy = "fromtanamachi")
	@JoinColumn(name = "from_id", referencedColumnName = "from_id")
	private List<LegendMainTanamachi> legendMainList;
}
