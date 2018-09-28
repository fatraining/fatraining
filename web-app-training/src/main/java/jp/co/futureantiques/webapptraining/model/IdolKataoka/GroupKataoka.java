package jp.co.futureantiques.webapptraining.model.IdolKataoka;

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
 * GroupKataokaテーブルと対応するEntity
 *
 *
 */
@Data
@Entity

public class GroupKataoka {
	/** 所属グループID */
	@Id
	@GeneratedValue
	@Column(name = "group_id")
	private int groupId;

	/** 所属グループ */
	@Column(name = "group_name")
	@Size(max = 256)
	private String groupName;

	/** 削除フラグ */
	@Column(name = "del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name = "create_date")
	private String createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private String updateDate;

	/** 外部キー設定：所属グループID */
	@Transient
	@OneToMany(targetEntity = IdolMainKataoka.class, mappedBy = "groupId")
	@JoinColumn(name = "groupId", referencedColumnName = "groupId")
	private List<IdolMainKataoka> IdolMainKataokaList;
}
