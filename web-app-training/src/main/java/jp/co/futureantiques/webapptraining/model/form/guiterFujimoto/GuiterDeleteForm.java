package jp.co.futureantiques.webapptraining.model.form.guiterFujimoto;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ギター削除画面のFormクラス
 *
 * @author Fujimoto
 */
@Data
public class GuiterDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}