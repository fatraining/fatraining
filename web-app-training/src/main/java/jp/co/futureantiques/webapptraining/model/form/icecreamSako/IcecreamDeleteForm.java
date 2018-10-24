package jp.co.futureantiques.webapptraining.model.form.icecreamSako;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * アイスクリーム削除画面のFormクラス
 *
 * @author MINAMI SAKO
 */
@Data
public class IcecreamDeleteForm {

	/**削除ID*/
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}