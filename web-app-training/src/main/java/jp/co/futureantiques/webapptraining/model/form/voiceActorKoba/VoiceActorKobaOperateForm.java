package jp.co.futureantiques.webapptraining.model.form.voiceActorKoba;

import javax.validation.constraints.NotNull;

// import java.sql.Timestamp;
// import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceActorMainKoba;
import lombok.Data;

@Data
public class VoiceActorKobaOperateForm {

	// 新規追加
	/** id */
	private Long id;

	/** 声優名 */
	@NotBlank(message = "voiceActorKoba.text.error.NotBlank.actorName")
	@Size(max=256)
	private String actorName;

	/** 写真 */
	@Size(max=256)
	private String image;

	/** 誕生日 */
	@Size(max=5, message = "common.text.error.size.max")
	@Pattern(regexp = "^()|([1-9]|1[0-2])/([1-9]|[1-2][0-9]|3[0-1])?$", message = "common.text.error.numeric")
	private String birthday;

	/** 出身地 */
	@Size(max=20)
	private Integer fromId;

	/** 事務所 */
	@Size(max=20)
	private Integer officeId;

	/** アニメタイトル */
	@NotNull
	@Size(max=256)
	// private String animeTitle;
	private Integer animeId;

	/** 上記入力したアニメで担当していたキャラクター名 */
	@NotNull
	@Size(max=256)
	private String characterName;
	// private Integer characterId;

	/** コメント */
	@Size(max=155)
	private String comment;

	private boolean insert;


	public void initWithVoiceActorKoba(VoiceActorMainKoba voiceActorKoba)  {
		this.setId(voiceActorKoba.getId());
		this.setActorName(voiceActorKoba.getActorName());
		this.setImage(voiceActorKoba.getImage());
		this.setBirthday(voiceActorKoba.getBirthday());
		this.setFromId(voiceActorKoba.getFromId());
		this.setOfficeId(voiceActorKoba.getOfficeId());
		this.setAnimeId(voiceActorKoba.getAnimeId());
		this.setCharacterName(voiceActorKoba.getCharacterName());
		// this.setCharacterId(voiceActorKoba.getCharacterId());
		this.setComment(voiceActorKoba.getComment());
	}

	public VoiceActorMainKoba convertToVoiceActorMainKoba() {
		VoiceActorMainKoba voiceActorMainKoba = new VoiceActorMainKoba();
		voiceActorMainKoba.setActorName(this.getActorName());
		voiceActorMainKoba.setImage(this.getImage());
		voiceActorMainKoba.setBirthday(this.getBirthday());
		voiceActorMainKoba.setFromId(this.getFromId());
		voiceActorMainKoba.setOfficeId(this.getOfficeId());
		voiceActorMainKoba.setAnimeId(this.getAnimeId());
		voiceActorMainKoba.setCharacterName(this.getCharacterName());
		// voiceActorMainKoba.setCharacterId(this.getCharacterId());
		voiceActorMainKoba.setComment(this.getComment());
		return voiceActorMainKoba;
	}

	public void setInsert(boolean b) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
