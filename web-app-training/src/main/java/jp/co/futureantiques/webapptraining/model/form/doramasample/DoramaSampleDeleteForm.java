package jp.co.futureantiques.webapptraining.model.form.doramasample;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ドラマ削除画面のFormクラス
 *
 * @author hiraoka
 */
@Data
public class DoramaSampleDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}