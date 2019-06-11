package jp.co.futureantiques.webapptraining.model.form.championTiba;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * チャンピオン削除画面のFormクラス
 *
 * @author future
 */
@Data
public class ChampionTibaDeleteForm {

	/** 削除ID */
	@Size(min=1, message="common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
