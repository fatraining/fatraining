package jp.co.futureantiques.webapptraining.model.form.okashiotani;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * お菓子削除画面のFormクラス
 *
 * @author future
 */
@Data
public class OkashiOtaniDeleteForm {
	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}


