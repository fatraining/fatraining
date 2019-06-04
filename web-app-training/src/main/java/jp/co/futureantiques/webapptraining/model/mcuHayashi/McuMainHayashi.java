package jp.co.futureantiques.webapptraining.model.mcuHayashi;

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
 * McuMainHayashiテーブルと対応するEntity
 *
 * @author 林 重樹
 */
@Data
@Entity
public class McuMainHayashi {

	/** キャラクターID */
	@Id
	@Column (name= "id")
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** キャラクター名 */
	@Column(name = "character_name")
	private String characterName;

	/** 人種ID */
	@Column(name = "type_id")
	private Integer typeId;

	/** 性別ID */
	@Column(name = "sex_id")
	private Integer sexId;

	/** 初登場年 */
	@Column(name = "appearance_year")
	private int appearanceYear;

	/** 登場回数 */
	@Column(name = "appearance_time")
	private Integer appearanceTime;

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

	/** 外部キー設定：人種 */
	@ManyToOne(targetEntity = TypeHayashi.class)
	@JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
	private TypeHayashi type;

	/** 外部キー設定：性別 */
	@ManyToOne(targetEntity = SexHayashi.class)
	@JoinColumn(name = "sex_id", referencedColumnName = "id", insertable = false, updatable = false)
	private SexHayashi sex;
}
