package jp.co.futureantiques.webapptraining.model.form.novelOkudaira;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 小説削除画面のFormクラス
 *
 * @author future
 */
@Data
public class NovelOkudairaDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}