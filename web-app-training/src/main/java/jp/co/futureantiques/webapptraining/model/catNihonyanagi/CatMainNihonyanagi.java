package jp.co.futureantiques.webapptraining.model.catNihonyanagi;

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
 *
 * cat_main_nihonyanagiテーブルと対応するEntity
 *@author Nihonyanagi
 */
@Data
@Entity
public class CatMainNihonyanagi {

	/**ネコID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** ネコ名前 */
	@Column(name = "cat_name")
	private String catName;

	/** 被毛ID */
	@Column(name = "hair_id")
	private Integer hairId;

	/** 大きさID */
	@Column(name = "size_id")
	private Integer sizeId;

	/** 性格ID */
	@Column(name = "character_id")
	private Integer characterId;

	/** コメント */
	@Column(name = "comment")
	private String comment;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時  */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：被毛 */
	@ManyToOne(targetEntity = HairNihonyanagi.class)
	@JoinColumn(name = "hair_id", referencedColumnName = "id", insertable = false, updatable = false)
	private HairNihonyanagi hair;

	/** 外部キー設定：大きさ */
	@ManyToOne(targetEntity = SizeNihonyanagi.class)
	@JoinColumn(name = "size_id",referencedColumnName = "id",insertable = false,updatable = false)
	private SizeNihonyanagi size;

	/** 外部キー設定：性格 */
	@ManyToOne(targetEntity = CharacterNihonyanagi.class)
	@JoinColumn(name = "character_id",referencedColumnName = "id",insertable = false,updatable = false)
	private CharacterNihonyanagi character;

}
