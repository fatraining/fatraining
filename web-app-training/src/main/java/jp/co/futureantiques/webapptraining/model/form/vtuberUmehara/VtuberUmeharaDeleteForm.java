package jp.co.futureantiques.webapptraining.model.form.vtuberUmehara;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Vtuber削除画面のFormクラス
 *
 * @author future
 */
@Data
public class VtuberUmeharaDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
