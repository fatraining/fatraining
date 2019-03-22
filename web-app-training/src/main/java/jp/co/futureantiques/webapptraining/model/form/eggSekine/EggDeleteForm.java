package jp.co.futureantiques.webapptraining.model.form.eggSekine;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 映画削除画面のFormクラス
 *
 * @author future
 */
@Data
public class EggDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
