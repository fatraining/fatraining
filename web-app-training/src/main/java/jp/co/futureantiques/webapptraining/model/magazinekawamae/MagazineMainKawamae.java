package jp.co.futureantiques.webapptraining.model.magazinekawamae;

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
 * MagazineMainKawamaeテーブルと対応するEntity
 *
 * @author wataru kawamae
 */
@Data
@Entity
public class MagazineMainKawamae {

	/** 雑誌ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 雑誌名 */
	@Column(name = "magazine_name")
	private String magazineName;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 売り上げ部数 */
	@Column(name = "saled_number")
	private int saledNumber;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：ジャンル */
	@ManyToOne(targetEntity = MagazineGenreKawamae.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)

	/** HTML参照用 */
	private MagazineGenreKawamae mgazineGenreKawamae;

}