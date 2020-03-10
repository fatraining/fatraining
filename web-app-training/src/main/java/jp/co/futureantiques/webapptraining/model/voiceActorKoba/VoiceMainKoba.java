package jp.co.futureantiques.webapptraining.model.voiceActorKoba;

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
 * VoiceActorkobaテーブルと対応するEntity
 *
 * @author future
 */

@Data
@Entity
public class VoiceMainKoba {

	/** 声優ID */
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	private long id;

	/** 声優名 */
	@Column(name = "actor_name")
	@Size(max = 256)
	private String actorName;

	/** 写真 */
	@Column(name = "image")
	@Size(max = 256)
	private String image;

	/** 誕生日(MM/dd) */
	@Column(name = "birthday")
	@Size(max = 5)
	private String birthday;

	/** 出身地ID */
	@Column(name = "from_id")
	private Integer fromId;

	/** 事務所ID */
	@Column(name = "office_id")
	private Integer officeId;

	/** アニメID */
	@Column(name = "anime_id")
	private Integer animeId;

	/** アニメタイトル */
	@Column(name = "anime_name")
	@Size(max = 256)
	private String animeName;

	/** キャラクターID
	@Column(name = "character_name")
	@Size(max = 256)
	private String characterName; */

	/** コメント */
	@Column(name = "comment")
	@Size(max = 155)
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

	/** 外部キー設定：出身地 */
	@ManyToOne(targetEntity=FromKoba.class)
	@JoinColumn(name = "from_id", referencedColumnName = "from_id", insertable = false, updatable = false)
	private FromKoba fromKoba;

	/** 外部キー設定：事務所 */
	@ManyToOne(targetEntity=OfficeKoba.class)
	@JoinColumn(name = "office_id", referencedColumnName = "office_id", insertable = false, updatable = false)
	private OfficeKoba officeKoba;

	/** 外部キー設定：アニメタイトル */
	@ManyToOne(targetEntity=AnimeKoba.class)
	@JoinColumn(name = "anime_id", referencedColumnName = "anime_id", insertable = false, updatable = false)
	private AnimeKoba animeKoba;

	/** 外部キー設定：キャラクター
	@ManyToOne(targetEntity=CharacterKoba.class)
	@JoinColumn(name = "character_id", referencedColumnName = "character_id")
	private CharacterKoba characterKoba; */

}
