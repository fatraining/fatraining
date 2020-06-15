package jp.co.futureantiques.webapptraining.model.okashiotani;

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
 * OkashiMainOtaniテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class OkashiMainOtani {
	/** お菓子ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** お菓子名 */
	@Column(name = "okashi_name")
	private String okashiName;

	/** 種類ID */
	@Column(name = "type_id")
	private Integer typeId;

	/** メーカーID */
	@Column(name = "maker_id")
	private Integer makerId;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：種類 */
	@ManyToOne(targetEntity = TypeOtani.class)
	@JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
	private TypeOtani typeOtani;

	/** 外部キー設定：メーカー */
	@ManyToOne(targetEntity = MakerOtani.class)
	@JoinColumn(name = "maker_id", referencedColumnName = "id", insertable = false, updatable = false)
	private MakerOtani makerOtani;

}
