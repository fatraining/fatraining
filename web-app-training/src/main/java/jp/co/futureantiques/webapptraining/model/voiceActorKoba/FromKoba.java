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
 * from_kobaテーブルと対応するEntity
 *
 */

@Data
@Entity
public class FromKoba {

	/** 出身地ID */
	@Id
	@GeneratedValue
	@Column(name="from_id")
	private Integer fromId;

	/** 出身地 */
	@Column(name="from_name")
	@Size(max = 6)
	private String fromName;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name="update_date")
	private Timestamp updateDate;

	/** 外部キー設定：出身地ID */
	@Transient
	@OneToMany(targetEntity=VoiceMainKoba.class,mappedBy="fromKoba")
	@JoinColumn(name="from_id",referencedColumnName="from_id")
	private List<VoiceMainKoba> voiceMainKobaList;

}
