package jp.co.futureantiques.webapptraining.model.form.alcoholishida;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * お酒削除画面のFormクラス
 *
 * @author t.ishida
 */

@Data
public class AlcoholIshidaDeleteForm {

	/**削除ID*/
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
