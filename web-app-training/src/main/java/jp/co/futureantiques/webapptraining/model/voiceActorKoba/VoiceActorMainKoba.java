package jp.co.futureantiques.webapptraining.model.voiceActorKoba;

/** import java.sql.Timestamp; */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * VoiceActorMainkobaテーブルと対応するEntity
 *
 * @author future
 */

@Data
@Entity
@Table(name = "voiceActorMainKoba")
public class VoiceActorMainKoba {

	/** 声優ID */
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="id")
	private long id;

	/** 声優名 */
    @Column(nullable = false)
	@Size(max = 20)
	private String actorName;

	/** 写真 */
	@Size(max = 256)
	private String image;

	/** 誕生日(MM/dd) */
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

	/** キャラクター */
	@Column(name = "character_Name")
	private String characterName;


	/** コメント */
	@Size(max = 155)
	private String comment;

	/** 外部キー設定：出身地 */
	@ManyToOne(targetEntity = FromKoba.class)
	@JoinColumn(name = "from_id", referencedColumnName = "from_id", insertable = false, updatable = false)
	private FromKoba fromKoba;

	/** 外部キー設定：事務所 */
	@ManyToOne(targetEntity = OfficeKoba.class)
	@JoinColumn(name = "office_id", referencedColumnName = "office_id", insertable = false, updatable = false)
	private OfficeKoba officeKoba;

	/** 外部キー設定：アニメタイトル */
	@ManyToOne(targetEntity = AnimeKoba.class)
	@JoinColumn(name = "anime_id", referencedColumnName = "anime_id", insertable = false, updatable = false)
	private AnimeKoba animeKoba;

	/** 外部キー設定：キャラクター名
	@ManyToOne(targetEntity = CharacterKoba.class)
	@JoinColumns({
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false),
	@JoinColumn(name = "anime_id", referencedColumnName = "anime_id", insertable = false, updatable = false)
	})
	private CharacterKoba characterKoba; */
}
