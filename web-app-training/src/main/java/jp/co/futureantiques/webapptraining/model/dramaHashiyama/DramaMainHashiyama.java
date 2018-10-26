package jp.co.futureantiques.webapptraining.model.dramaHashiyama;


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
 * DramaMainHashiyamaテーブルと対応するEntity
 *
 * @author hashiyama
 */

@Data
@Entity
public class DramaMainHashiyama {
	/** ドラマID 主キーとなるので＠の表記が違う */
	@Id
	@Column(name = "id")
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private long id;

	/** ドラマ名 */
	@Column(name = "drama_title")
	@Size(max = 300)
	private String dramaTitle;

	/**主演ID */
	@Column(name = "actor_id")
	private Integer actorId;

	/**  テレビ局ID */
	@Column(name = "channel_id")
	private Integer channelId;

	/**  放送年 */
	@Column(name = "release_year")
	private int releaseYear;

	/** 放送時間 */
	@Column(name = "run_time")
	private Integer runTime;

	/**  コメント */
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

	/** 外部キー設定：主演俳優 */
	@ManyToOne(targetEntity = DramaActorHashiyama.class)
	@JoinColumn(name = "actor_id", referencedColumnName = "id", insertable = false, updatable = false)
	private DramaActorHashiyama dramaActorHashiyama;

	/** 外部キー設定：テレビ局 */
	@ManyToOne(targetEntity = ChannelHashiyama.class)
	@JoinColumn(name = "channel_id", referencedColumnName = "id", insertable = false, updatable = false)
	private ChannelHashiyama channelHashiyama;

}