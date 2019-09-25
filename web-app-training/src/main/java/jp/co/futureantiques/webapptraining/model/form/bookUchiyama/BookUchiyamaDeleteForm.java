package jp.co.futureantiques.webapptraining.model.form.bookUchiyama;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 本削除画面のFormクラス
 * @author FutureAntiques
 */
@Data
public class BookUchiyamaDeleteForm {
	@Size(min = 1, message = "common.text.error.require.check")
	/** 削除IDList */
	private ArrayList<Long> deleteIds;
}
