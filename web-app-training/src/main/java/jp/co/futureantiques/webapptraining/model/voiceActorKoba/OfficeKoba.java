package jp.co.futureantiques.webapptraining.model.voiceActorKoba;

import java.sql.Timestamp;
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
 * office_kobaテーブルと対応するEntity
 *
 */

@Data
@Entity
public class OfficeKoba {

	/** 事務所ID */
	@Id
	@GeneratedValue
	@Column(name="office_id")
	private Integer officeId;

	/** 事務所名 */
	@Column(name="office_name")
	@Size(max = 20)
	private String officeName;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name = "update_date")
	private Timestamp updateDate;

	/** 外部キー設定：事務所ID */
	@Transient
	@OneToMany(targetEntity=VoiceMainKoba.class,mappedBy="officeKoba")
	@JoinColumn(name="office_id",referencedColumnName="office_id")
	private List<VoiceMainKoba> voiceMainKobaList;

}
