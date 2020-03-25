package jp.co.futureantiques.webapptraining.model.voiceActorKoba;

// import java.sql.Timestamp;
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
 * anime_kobaテーブルと対応するEntity
 */

@Data
@Entity
@Table(name = "anime_koba")
public class AnimeKoba {

	/** アニメID */
    @Id
    @GeneratedValue
	@Column(name="anime_id")
	private Integer anime_id;

	/** アニメタイトル */
	@Column(name="anime_title")
	@Size(max = 256)
	private String animeTitle;

	/** 外部キー設定：アニメID */
	@Transient
	@OneToMany(targetEntity=CharacterKoba.class,mappedBy="anime_Koba")
	@JoinColumn(name="anime_id",referencedColumnName="anime_id")
	private List<CharacterKoba> characterKobaList;
}

