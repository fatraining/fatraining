package jp.co.futureantiques.webapptraining.model.dffTatebe;

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
 * DffMainTatebeテーブルと対応するEntity
 *
 * @author Tatebe
 *
 */
@Data
@Entity
public class DffMainTatebe {
	/** キャラクター名ID */
	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** キャラクター名 */
	@Column(name = "dff_name")
	private String dffName;

	/** 作品名ID */
	@Column(name = "title_id")
	private Integer titleId;

	/** タイプID */
	@Column(name = "type_id")
	private Integer typeId;

	/** コメント */
	@Column(name = "comment")
	@Size(max = 300)
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

	/** 外部キー設定:作品名 */
	@ManyToOne(targetEntity = DffTitleTatebe.class)
	@JoinColumn(name = "title_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DffTitleTatebe titleTatebe;

	/** 外部キー設定:タイプ */
	@ManyToOne(targetEntity = DffTypeTatebe.class)
	@JoinColumn(name = "type_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DffTypeTatebe typeTatebe;

}
