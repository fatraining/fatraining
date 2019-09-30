package jp.co.futureantiques.webapptraining.model.animeNagatake;

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
 *VoiceactorNagatakeテーブルの対応Entity
 *
 * @author future
 * */

@Data
@Entity
	public class VoiceactorNagatake {

	/** 声優ID */
	    @Id
	    @GeneratedValue
		@Column(name = "voiceactor_id")
		private Integer voiceactorId;

	    /** 名前 */
		@Column(name = "name")
		@Size(max = 256)
		private String name;

		/** 削除フラグ */
		@Column(name = "del_flg")
		private String delFlg;

		/** 登録日時 */
		@Column(name = "create_date")
		private Timestamp createDate;

		/** 更新日時 */
		@Column(name = "update_date")
		private Timestamp updateDate;

		/** 外部キー設定 :声優ID */
		@Transient
		@OneToMany(targetEntity=AnimeMainNagatake.class, mappedBy="voiceactorNagatake")
		@JoinColumn(name="voiceactor_id", referencedColumnName="voiceactor_id")
		private List<AnimeMainNagatake> animeMainNagatakeList;
	}

