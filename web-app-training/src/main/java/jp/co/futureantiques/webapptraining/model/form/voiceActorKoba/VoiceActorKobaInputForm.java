package jp.co.futureantiques.webapptraining.model.form.voiceActorKoba;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceMainKoba;
import lombok.Data;

/**
 * 男性声優データ登録・更新画面用のFormクラス
 *
 */

@Data
public class VoiceActorKobaInputForm {

	/** ID */
	private int id;

	/** 声優名 */
	@NotBlank(message="common.text.error.require")
	@Size(max=256)
	private String actorName;

	/** 写真 */
	@Size(max=256)
	private String image;

	/** 誕生日 */
	@Size(max=5, message = "common.text.error.size.max")
	@Pattern(regexp = "^()|([1-9]|1[0-2])/([1-9]|[1-2][0-9]|3[0-1])?$", message = "common.text.error.numeric")
	private String birthday;

	/** 出身地ID */
	private Integer fromId;

	/** 事務所ID */
	private Integer officeId;

	/** アニメタイトル */
	@NotBlank(message="common.text.error.require")
	@Size(max=256)
	private String animeName;

	/** 上記タイトルで担当していたキャラクター名
	@NotBlank(message="common.text.error.require")
	@Size(max=256)
	private String characterName; */

	/** コメント */
	@Size(max=155)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param VoiceMainKoba
	 */
	public void initWithVoiceMainKoba(VoiceMainKoba voiceMainKoba) {
		this.setId((int) voiceMainKoba.getId());
		this.setActorName(voiceMainKoba.getActorName());
		this.setImage(voiceMainKoba.getImage());
		if (voiceMainKoba.getBirthday() != null) {
			this.setBirthday(voiceMainKoba.getBirthday());
		}
		this.setFromId(voiceMainKoba.getFromId());
		this.setOfficeId(voiceMainKoba.getOfficeId());
		this.setAnimeName(voiceMainKoba.getAnimeName());
		/* this.setCharacterName(voiceMainKoba.getCharacterName()); */
		this.setComment(voiceMainKoba.getComment());
		this.setUpdateDate(String.valueOf(voiceMainKoba.getUpdateDate()));
	}

	/**
	 * VoiceMainKobaエンティティに登録値を入れる
	 *
	 * @return VoiceMainKoba
	 */
	public VoiceMainKoba convertToVoiceMainKobaForInsert() {
		VoiceMainKoba voiceMainKoba = new VoiceMainKoba();
		voiceMainKoba = convertToVoiceMainKoba(voiceMainKoba);
		voiceMainKoba.setCreateDate(new Timestamp(new Date().getTime()));
		voiceMainKoba.setUpdateDate(voiceMainKoba.getCreateDate());
		return voiceMainKoba;
	}

	/**
	 * VoiceMainKobaエンティティに更新値を入れる
	 *
	 * @param VoiceMainKoba voiceMainKoba
	 * @return VoiceMainKoba
	 */
	public VoiceMainKoba convertToVoiceMainKobaForUpdate(VoiceMainKoba voiceMainKoba) {
		voiceMainKoba = convertToVoiceMainKoba(voiceMainKoba);
		voiceMainKoba.setUpdateDate(new Timestamp(new Date().getTime()));
		return voiceMainKoba;
	}

	/**
	 * VoiceMainKobaエンティティに入力値を入れる
	 *
	 * @param VoiceMainKoba voiceMainKoba
	 * @return VoiceMainKoba
	 */
	private VoiceMainKoba convertToVoiceMainKoba(VoiceMainKoba voiceMainKoba) {
		voiceMainKoba.setActorName(this.actorName);
		if (!this.image.isEmpty()) {
			// 写真が入力されていた場合
			voiceMainKoba.setImage(this.image);
		} else {
			//入力されていない場合
			voiceMainKoba.setImage(null);
		}
		if (!this.birthday.isEmpty()) {
			// 誕生日が入力されていた場合
			voiceMainKoba.setBirthday(this.birthday);
		} else {
			//入力されていない場合
			voiceMainKoba.setBirthday(null);
		}
		if(this.fromId == CommonConst.NOT_ENTERD) {
			// 出身地が入力されていなかった場合
			voiceMainKoba.setFromId(null);
		}else {
			// 出身地が入力されていた場合
			voiceMainKoba.setFromId(this.fromId);
		}
		if(this.officeId == CommonConst.NOT_ENTERD) {
			// 事務所が入力されていなかった場合
			voiceMainKoba.setOfficeId(null);
		}else {
			// 事務所が入力されていた場合
			voiceMainKoba.setOfficeId(this.officeId);
		}
		voiceMainKoba.setAnimeName(this.animeName);
		/* voiceMainKoba.setCharacter_name(this.characterName); */
		if (!this.comment.isEmpty()) {
			// コメントが入力されていた場合
			voiceMainKoba.setComment(this.comment);
		} else {
			//入力されていない場合
			voiceMainKoba.setComment(null);
		}
		voiceMainKoba.setDelFlg("0");
		return voiceMainKoba;

	}

}
