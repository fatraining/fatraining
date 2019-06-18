package jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * キャラクター削除画面のFormクラス
 *
 * @author Okugawa
 */
@Data
public class YugiohOkugawaDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
