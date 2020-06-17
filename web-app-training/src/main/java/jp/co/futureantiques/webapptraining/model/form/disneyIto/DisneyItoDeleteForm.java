package jp.co.futureantiques.webapptraining.model.form.disneyIto;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ディズニーアトラクション削除画面のFormクラス
 *
 * @author Ayaka Ito
 */
@Data
public class DisneyItoDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
