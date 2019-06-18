package jp.co.futureantiques.webapptraining.model.idolShintaku;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * idol_main_shintakuテーブルと対応するEntity
 *
 * @author shintaku
 */
@Data
@Entity
public class IdolMainShintaku {

	/** アイドルID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** アイドル名 */
	@Column(name = "name")
	private String name;

	/** 年齢 */
	@Column(name = "age")
	@Max(value = 99)
	private Integer age;

	/** 属性ID */
	@Column(name = "type_id")
	private Integer typeId;

	/** ユニットID */
	@Column(name = "unit_id")
	private Integer unitId;

	/** ソロ曲 */
	@Column(name = "song")
	private String song;

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

	/** 外部キー設定：属性 */
	@ManyToOne(targetEntity = TypeShintaku.class)
	@JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
	private TypeShintaku typeShintaku;

	/** 外部キー設定：ユニット */
	@ManyToOne(targetEntity = UnitShintaku.class)
	@JoinColumn(name = "unit_id", referencedColumnName = "id", insertable = false, updatable = false)
	private UnitShintaku unitShintaku;
}
