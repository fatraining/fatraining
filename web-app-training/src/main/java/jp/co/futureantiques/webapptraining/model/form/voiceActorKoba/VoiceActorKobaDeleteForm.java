package jp.co.futureantiques.webapptraining.model.form.voiceActorKoba;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 男性声優データ削除画面のFormクラス
 *
 */

@Data
public class VoiceActorKobaDeleteForm {

	/** 削除ID */
	@Size(min=1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;

}

