/**
 *
 */
package jp.co.futureantiques.webapptraining.model.form.bandIto;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * バンド削除画面のFormクラス
 *
 * @author future
 */
@Data
public class BandItoDeleteForm {
	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
