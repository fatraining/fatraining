package jp.co.futureantiques.webapptraining.model.jojoShirasaka;

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

/** jojo_main_shirasakaテーブルと対応するEntity */

@Data
@Entity
public class JojoMainShirasaka {

	/** スタンドID */
	@Id
	@Column(name = "stand_id")
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** スタンド名 */
	@Column(name = "stand_name")
	private String standName;

	/** スタンド能力者 */
	@Column(name = "stand_user_name")
	private String standUserName;

	/** 性別ID */
	@Column(name = "sex_id")
	private Integer sexId;

	/** 能力 */
	@Column(name = "ability")
	private String ability;

	/** 登場部ID */
	@Column(name = "appearance_id")
	private int appearanceId;

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

	/** 外部キー設定：性別 */
	@ManyToOne(targetEntity = JojoSexShirasaka.class)
	@JoinColumn(name = "sex_id", referencedColumnName = "sex_id", insertable = false, updatable = false)
	private JojoSexShirasaka jojoSexShirasaka;

	/** 外部キー設定：登場部 */
	@ManyToOne(targetEntity = JojoAppearanceShirasaka.class)
	@JoinColumn(name = "appearance_id", referencedColumnName = "appearance_id", insertable = false, updatable = false)
	private JojoAppearanceShirasaka jojoAppearanceShirasaka;
}