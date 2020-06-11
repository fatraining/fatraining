package jp.co.futureantiques.webapptraining.model.form.proteinUeno;


import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 削除画面のFormクラス
 * @author  ueno
 */
@Data
public class ProteinUenoDeleteForm {

	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
