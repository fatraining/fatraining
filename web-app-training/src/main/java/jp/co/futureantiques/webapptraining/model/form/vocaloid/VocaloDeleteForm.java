package jp.co.futureantiques.webapptraining.model.form.vocaloid;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 映画削除画面のFormクラス
 *
 * @author tsuru
 */
@Data
public class VocaloDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
