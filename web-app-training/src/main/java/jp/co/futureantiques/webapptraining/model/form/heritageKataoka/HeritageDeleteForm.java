package jp.co.futureantiques.webapptraining.model.form.heritageKataoka;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 世界遺産削除画面のFormクラス
 * @author MIKI KATAOKA
 */

@Data
public class HeritageDeleteForm {
	/**削除ID*/
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;

}
