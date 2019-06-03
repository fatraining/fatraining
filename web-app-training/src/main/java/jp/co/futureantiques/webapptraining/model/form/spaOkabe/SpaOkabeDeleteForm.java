package jp.co.futureantiques.webapptraining.model.form.spaOkabe;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 温泉地削除画面のFormクラス
 *
 * @author SEIYA OKABE
 */
@Data
public class SpaOkabeDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}