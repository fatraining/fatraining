package jp.co.futureantiques.webapptraining.model.residentsUriu;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * residents_main_uriuテーブルと対応するEntity
 *
 */

@Data
@Entity
public class ResidentsMainUriu {

	/** 住人ID */
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name = "id")
	private long id;

	/** なまえ */
	@Column(name = "name")
	private String name;

	/** 性格ID */
	@Column(name = "type_id")
	private Integer typeId;

	/** どうぶつID */
	@Column(name = "animal_id")
	private Integer animalId;

	/** 口癖 */
	@Column(name = "phrase")
	private String phrase;

	/** 座右の銘 */
	@Column(name = "motto")
	private String motto;

	/** 誕生日(MM/dd) */
	@Column(name = "birthday")
	private String birthday;

	/** 画像 */
	@Column(name = "image")
	private String image;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：性格タイプ */
	@ManyToOne(targetEntity=TypeUriu.class)
	@JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
	private TypeUriu typeUriu;

	/** 外部キー設定：どうぶつ */
	@ManyToOne(targetEntity=AnimalUriu.class)
	@JoinColumn(name = "animal_id", referencedColumnName = "id", insertable = false, updatable = false)
	private AnimalUriu animalUriu;
}
