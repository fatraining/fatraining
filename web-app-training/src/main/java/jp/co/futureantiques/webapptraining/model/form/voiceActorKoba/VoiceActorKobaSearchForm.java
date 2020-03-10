package jp.co.futureantiques.webapptraining.model.form.voiceActorKoba;

import jp.co.futureantiques.webapptraining.model.voiceActorKoba.VoiceMainKoba;
import lombok.Data;

/**
 * 男性声優データ検索画面のformクラス
 *
 */

@Data
public class VoiceActorKobaSearchForm {

	/** ID */
	private Integer id;

	/** 声優名 */
	private String actorName;

	/** 事務所ID */
	private Integer officeId;

	/** アニメタイトル */
	private String animeName;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param voiceMainKoba
	 */
	public void setValues(VoiceMainKoba voiceMainKoba) {
		this.setId((int)voiceMainKoba.getId());
		this.setActorName(voiceMainKoba.getActorName());
		this.setOfficeId(voiceMainKoba.getOfficeId());
		this.setAnimeName(voiceMainKoba.getAnimeName());
	}

}
