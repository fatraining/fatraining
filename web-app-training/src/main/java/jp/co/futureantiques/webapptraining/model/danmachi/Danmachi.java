package jp.co.futureantiques.webapptraining.model.danmachi;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


/**
 * Danmachiテーブルと対応するEntity
 *
 */
@Data
@Entity
@Table(name = "danmachi_main")
public class Danmachi {
	/** ID */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/** キャラ名 */
	@Column(name = "name")
	private String name;

	/** ファミリアID */
	@Column(name = "fami_id")
	private int famiID ;

	/** 種族ID */
	@Column(name = "race_id")
	private int raceID;

	/** 二つ名 */
	@Column(name = "title")
	private String title;

	/** 声優 */
	@Column(name = "cast")
	private String cast;


	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：ファミリア */
	@ManyToOne(targetEntity = Fami.class)
	@JoinColumn(name = "fami_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Fami fami;

	/** 外部キー設定：種族 */
	@ManyToOne(targetEntity = Race.class)
	@JoinColumn(name = "race_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Race race;
}
