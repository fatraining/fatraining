package jp.co.futureantiques.webapptraining.model.voiceActorKoba;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.Data;



/**
 * office_kobaテーブルと対応するEntity
 */

@Data
@Entity
@Table(name = "office_koba")
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

	/** 外部キー設定：事務所ID */
	@Transient
	@OneToMany(targetEntity=VoiceActorMainKoba.class,mappedBy="office_Koba")
	@JoinColumn(name="office_id",referencedColumnName="office_id")
	private List<VoiceActorMainKoba> voiceActorMainKobaList;

}
