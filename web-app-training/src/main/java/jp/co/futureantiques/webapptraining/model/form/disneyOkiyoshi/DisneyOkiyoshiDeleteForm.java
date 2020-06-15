package jp.co.futureantiques.webapptraining.model.form.disneyOkiyoshi;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 削除画面のFormクラス
 *
 * @author future
 */
@Data
	public class DisneyOkiyoshiDeleteForm {
	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}