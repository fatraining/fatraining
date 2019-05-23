package jp.co.futureantiques.webapptraining.model.form.novelmiyamoto;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 本削除画面のFormクラス
 */
@Data
public class NovelDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}