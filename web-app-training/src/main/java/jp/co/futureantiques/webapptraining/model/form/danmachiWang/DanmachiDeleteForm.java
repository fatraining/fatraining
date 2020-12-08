package jp.co.futureantiques.webapptraining.model.form.danmachiWang;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ダンまち削除画面のFormクラス
 *
 * @author Wang
 */

@Data
public class DanmachiDeleteForm {
	/**削除ID*/
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}