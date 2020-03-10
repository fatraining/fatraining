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
 * anime_kobaテーブルと対応するEntity
 *
 */

@Data
@Entity
public class AnimeKoba {

	/** アニメID */
    @Id
    @GeneratedValue
	@Column(name="anime_id")
	private Integer anime_id;

	/** アニメタイトル */
	@Column(name="anime_name")
	@Size(max = 256)
	private String animeName;

	/** 削除フラグ */
	@Column(name="del_flg")
	private String delFlg;

	/** 登録日時 */
	@Column(name="create_date")
	private Timestamp createDate;

	/** 更新日時 */
	@Column(name="update_date")
	private Timestamp updateDate;

	/** 外部キー設定：アニメID */
	@Transient
	@OneToMany(targetEntity=VoiceMainKoba.class,mappedBy="animeKoba")
	@JoinColumn(name="anime_id",referencedColumnName="anime_id")
	private List<VoiceMainKoba> voiceMainKobaList;
}
