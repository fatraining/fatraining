package jp.co.futureantiques.webapptraining.model.kpoptateishi;

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
 * KpopMainテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class KpopMain {

	/** 楽曲ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 楽曲名 */
	@Column(name = "music_title")
	private String musicTitle;

	/** アイドルID */
	@Column(name = "idol_id")
	private Integer idolId;

	/** 所属事務所ID */
	@Column(name = "office_id")
	private Integer officeId;

	/** 公開年 */
	@Column(name = "release_year")
	private int releaseYear;

	/** 楽曲時間 */
	@Column(name = "music_time")
	private Integer musicTime;

	/** MVのURL */
	@Column(name = "mv_url")
	@Size(max = 255)
	private String mvUrl;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：アイドル */
	@ManyToOne(targetEntity = Idol.class)
	@JoinColumn(name = "idol_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Idol idol;

	/** 外部キー設定：所属事務所 */
	@ManyToOne(targetEntity = Office.class)
	@JoinColumn(name = "office_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Office office;
}