package eggsekine;

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
 * eggMainテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class EggMain {

	/** 映画ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** 映画名 */
	@Column(name = "name")
	private String name;

	/** ジャンルID */
	@Column(name = "genre_id")
	private Integer genreId;

	/** 俳優ID */
	@Column(name = "cook_id")
	private Integer cookId;

	/** 公開年→カロリー */
	@Column(name = "calorie")
	private int calorie;

	/** 上映時間
	@Column(name = "run_time")
	private Integer runTime;*/

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

	/** 外部キー設定：ジャンル */
	@ManyToOne(targetEntity = Genre.class)
	@JoinColumn(name = "genre_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Genre genre;

	/** 外部キー設定：俳優 →調理法*/
	@ManyToOne(targetEntity = Cook.class)
	@JoinColumn(name = "cook_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Cook cook;
}
