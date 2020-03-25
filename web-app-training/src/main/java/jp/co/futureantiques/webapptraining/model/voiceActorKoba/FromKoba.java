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
 * from_kobaテーブルと対応するEntity
 */

@Data
@Entity
@Table(name = "from_koba")
public class FromKoba {

	/** 出身地ID */
	@Id
    @GeneratedValue
	@Column(name="from_id")
	private Integer fromId;

	/** 出身地 */
	@Column(name="from_name")
	@Size(max = 20)
	private String fromName;

	/** 外部キー設定：出身地ID */
	@Transient
	@OneToMany(targetEntity=VoiceActorMainKoba.class,mappedBy = "from_Koba")
	@JoinColumn(name="from_id", referencedColumnName="from_id")
	private List<VoiceActorMainKoba> voiceActorMainKobaList;

}
