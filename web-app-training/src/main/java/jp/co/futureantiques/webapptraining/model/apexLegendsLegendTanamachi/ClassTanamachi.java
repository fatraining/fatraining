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
 * class_tanamachiテーブルと対応するEntityクラス
 *
 * @author future
 */
@Data
@Entity
public class ClassTanamachi {

	/** クラスID */
	@Id
	@GeneratedValue
	@Column(name = "class_id")
	private int id;

	/** クラス */
	@Column(name = "class")
	@Size(max = 256)
	private String class_of_legend;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private Integer delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定:クラスID */
	@Transient
	@OneToMany(targetEntity = LegendMainTanamachi.class, mappedBy = "classtanamachi")
	@JoinColumn(name = "class_id", referencedColumnName = "class_id")
	private List<LegendMainTanamachi> legendMainList;
}
