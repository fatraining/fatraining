package jp.co.futureantiques.webapptraining.model.form.magazineKawamae;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 雑誌削除画面のFormクラス
 *
 * @author wataru kawamae
 */
@Data
public class MagazineKawamaeDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}