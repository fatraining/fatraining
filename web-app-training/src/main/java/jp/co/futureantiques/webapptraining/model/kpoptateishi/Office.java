package jp.co.futureantiques.webapptraining.model.kpoptateishi;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Ofiiceテーブルと対応するEntity
 *
 * @author future
 */
@Data
@Entity
public class Office {

	/** 所属事務所ID */
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/** 所属事務所 */
	@Column(name = "office")
	@Size(max = 255)
	private String office;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：俳優ID */
	@Transient
	@OneToMany(targetEntity = KpopMain.class, mappedBy = "office")
	@JoinColumn(name = "id", referencedColumnName = "office_id")
	private List<KpopMain> kpopMainList;
}