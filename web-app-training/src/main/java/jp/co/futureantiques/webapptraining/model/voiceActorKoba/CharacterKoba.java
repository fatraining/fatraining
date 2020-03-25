package jp.co.futureantiques.webapptraining.model.voiceActorKoba;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * character_kobaテーブルと対応するEntity
 */

@Data
@Entity
@Table(name = "character_koba")
@IdClass(CharacterKobaPK.class)
public class CharacterKoba {

	/** 声優ID */
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="id")
	private long id;

	/** アニメID */
    @Id
    @GeneratedValue
	@Column(name="anime_id")
	private Integer animeId;

	/** キャラクター名 */
	@Column(name="character_name")
	@Size(max = 256)
	private String characterName;

	/** 外部キー設定：声優ID */
	@ManyToOne(targetEntity=VoiceActorMainKoba.class)
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	private VoiceActorMainKoba voiceActorMainKoba;

	/** 外部キー設定：アニメID */
	@ManyToOne(targetEntity=AnimeKoba.class)
	@JoinColumn(name = "anime_id", referencedColumnName = "anime_id", insertable = false, updatable = false)
	private AnimeKoba animeKoba;

	// setter,getter CharacterPK用
	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return animeId
	 */
	public Integer getAnimeId() {
		return animeId;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @param animeId セットする animeId
	 */
	public void setAnimeId(Integer animeId) {
		this.animeId = animeId;
	}
}
