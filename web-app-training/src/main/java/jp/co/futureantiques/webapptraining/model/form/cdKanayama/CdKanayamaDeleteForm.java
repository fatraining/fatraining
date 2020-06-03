package jp.co.futureantiques.webapptraining.model.form.cdKanayama;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * CD削除画面のFormクラス
 *
 * @author future
 */
@Data

public class CdKanayamaDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;

}
