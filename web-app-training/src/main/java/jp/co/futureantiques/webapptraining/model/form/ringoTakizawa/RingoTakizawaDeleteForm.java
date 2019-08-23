package jp.co.futureantiques.webapptraining.model.form.ringoTakizawa;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 椎名林檎の曲（プレイリスト）削除画面のFormクラス
 *
 * @author Mai Takizawa
 */
@Data
public class RingoTakizawaDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}