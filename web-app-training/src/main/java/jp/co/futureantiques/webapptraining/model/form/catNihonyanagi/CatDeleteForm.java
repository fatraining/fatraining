package jp.co.futureantiques.webapptraining.model.form.catNihonyanagi;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ネコ削除画面のFormクラス
 *
 * @author Nihonyanagi
 *
 */
@Data
public class CatDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;

}
