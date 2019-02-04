package jp.co.futureantiques.webapptraining.model.tennisTominaga;

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
 * PlayerMainテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class PlayerMainTominaga {

	/** 選手ID */
	@Id //主キーを設定するアノテーション
	@Column(name = "id") //カラムの名前を指定するアノテーション
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen") //自動で番号を増やしてるアノテーション？
	private long id;

	/** 選手名 */
	@Column(name = "player_name")
	private String playerName;

	/** 国籍ID */
	@Column(name = "nationality_id")
	private Integer nationalityId;

	/** 生年 */
	@Column(name = "birth_year")
	private Integer birthYear;

	/** 世界最高ランク */
	@Column(name = "rank")
	private Integer rank;

	/** 利き手 */
	@Column(name = "handedness")
	private String handedness;

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

	/** 外部キー設定：国籍 */
	@ManyToOne(targetEntity = NationalityTominaga.class)
	@JoinColumn(name = "nationality_id", referencedColumnName = "nationality_id", insertable = false, updatable = false)
	private NationalityTominaga nationalityTominaga;


}