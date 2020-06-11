package jp.co.futureantiques.webapptraining.model.proteinUeno;

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
 * proteinMainテーブルと対応するEntity
 *
 * @author ueno
 */

@Entity
@Data
public class ProteinMainUeno {

	/** プロテインID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** フレーバー */
	@Column(name = "flavor")
	private String flavor;

	/** 種類ID */
	@Column(name = "kind_id")
	private Integer kindId;

	/** メーカーID */
	@Column(name = "maker_id")
	private Integer makerId;

	/** 評価 */
	@Column(name = "review")
	private int review;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 256)
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

	/** 外部キー設定：種類 */
	@ManyToOne(targetEntity = KindsUeno.class)
	@JoinColumn(name = "kind_id", referencedColumnName = "id", insertable = false, updatable = false)
	private KindsUeno kind;

	/** 外部キー設定：メーカー */
	@ManyToOne(targetEntity = MakerUeno.class)
	@JoinColumn(name = "maker_id", referencedColumnName = "id", insertable = false, updatable = false)
	private MakerUeno maker;

}
