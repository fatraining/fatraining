package jp.co.futureantiques.webapptraining.model.monsterShirase;

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
 * MonsterMainShiraseテーブルと対応するEntity
 * @author Shirase
 */

@Data
@Entity
public class MonsterMainShirase {

	/** モンスターID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** モンスター名 */
	@Column(name = "name")
	private String name;

	/** モンスター名(英語) */
	@Column(name = "name_en")
	private String nameEn;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 素材名 */
	@Column(name = "material")
	private String material;

	/** 弱点属性ID */
	@Column(name = "element_id")
	private Integer elementId;

	/** 初登場作品ID */
	@Column(name = "title_id")
	private Integer titleId;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private Integer delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定: ジャンル */
	@ManyToOne(targetEntity = GenreShirase.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private GenreShirase genreShirase;

	/** 外部キー設定: 弱点属性 */
	@ManyToOne(targetEntity = ElementShirase.class)
	@JoinColumn(name = "element_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ElementShirase elementShirase;

	/** 外部キー設定: 初登場作品 */
	@ManyToOne(targetEntity = TitleShirase.class)
	@JoinColumn(name = "title_id", referencedColumnName = "id", insertable = false, updatable = false)
	private TitleShirase titleShirase;

}
