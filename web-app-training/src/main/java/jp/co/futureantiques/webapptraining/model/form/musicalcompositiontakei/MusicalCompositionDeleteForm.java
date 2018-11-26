package jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 楽曲削除画面のFormクラス
 *
 * @author takei
 */
@Data
public class MusicalCompositionDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
