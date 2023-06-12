package jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Range;

import lombok.Data;

/**
 * legend_main_tanamachiテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class LegendMainTanamachi {

	/** レジェンドID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** レジェンド名 */
	@Column(name = "legend_name")
	@Size(max = 256)
	private String legendName;

	/** 本名 */
	@Column(name = "real_name")
	@Size(max = 256)
	private String realName;

	/** 年齢 */
	@Column(name = "age")
	@Range(min = 0, max = 999)
	private Integer age;

	/** 出身地ID */
	@Column(name = "from_id")
	private int fromId;

	/** クラスID */
	@Column(name = "class_id")
	private int classId;

	/** アルティメットアビリティ */
	@Column(name = "ultimate_ability")
	@Size(max = 256)
	private String ultimateAbility;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private Integer delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定:出身地 */
	@ManyToOne(targetEntity = FromTanamachi.class)
	@JoinColumn(name = "from_id" , referencedColumnName = "from_id" , insertable = false, updatable = false)
	private FromTanamachi fromTanamachi;

	/** 外部キー設定:クラス */
	@ManyToOne(targetEntity = ClassTanamachi.class)
	@JoinColumn(name = "class_id" , referencedColumnName = "class_id", insertable = false, updatable = false)
	private ClassTanamachi classTanamachi;
}
