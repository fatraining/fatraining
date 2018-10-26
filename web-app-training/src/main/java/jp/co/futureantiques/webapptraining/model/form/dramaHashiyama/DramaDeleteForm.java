package jp.co.futureantiques.webapptraining.model.form.dramaHashiyama;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ドラマ削除画面のFormクラス
 *
 * @author hashiyama
 */
@Data
public class DramaDeleteForm {
	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}