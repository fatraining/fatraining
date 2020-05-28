package jp.co.futureantiques.webapptraining.model.drinkOhkubo;

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
 * DrinkMain_Ohkuboテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class DrinkMain_Ohkubo {
	/**飲み物ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 製品名 */
	@Column(name = "drink_name")
	private String drinkName;

	/** メーカーID */
	@Column(name = "maker_id")
	private Integer makerId;

	/** 種類ID */
	@Column(name = "type_id")
	private Integer typeId;

	/** 内容量 */
	@Column(name = "ml")
	private Integer ml;

	/** 容器ID */
	@Column(name = "container_id")
	private Integer containerId;

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
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：メーカー */
	@ManyToOne(targetEntity = Maker_Ohkubo.class)
	@JoinColumn(name = "maker_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Maker_Ohkubo maker;

	/** 外部キー設定：種類 */
	@ManyToOne(targetEntity = Type_Ohkubo.class)
	@JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Type_Ohkubo type;

	/** 外部キー設定：容器 */
	@ManyToOne(targetEntity = Container_Ohkubo.class)
	@JoinColumn(name = "container_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Container_Ohkubo container;

}
