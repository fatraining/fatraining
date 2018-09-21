package jp.co.futureantiques.webapptraining.model.form.electronicsIto;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 製品削除画面のFormクラス
 *
 * @author AIRI ITO
 */
@Data
public class ElectronicsDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;

}
