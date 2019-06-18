package jp.co.futureantiques.webapptraining.model.form.idolShintaku;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * アイドル削除画面のFormクラス
 * @author shintaku
 */
@Data
public class IdolShintakuDeleteForm {

	//削除ID
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
