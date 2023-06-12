package jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * レジェンド削除画面のFormクラス
 *
 * @author future
 */
@Data
public class LegendRestorationForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
