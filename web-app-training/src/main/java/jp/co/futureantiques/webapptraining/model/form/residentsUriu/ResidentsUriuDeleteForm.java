package jp.co.futureantiques.webapptraining.model.form.residentsUriu;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 住人データ削除画面のFormクラス
 *
 */

@Data
public class ResidentsUriuDeleteForm {

	/** 削除ID */
	@Size(min=1,message="common.text.error.require.check")
	private ArrayList<Long> deleteIds;

}
