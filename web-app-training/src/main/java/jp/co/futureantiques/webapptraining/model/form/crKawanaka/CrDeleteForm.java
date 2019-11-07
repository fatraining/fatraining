package jp.co.futureantiques.webapptraining.model.form.crKawanaka;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 日本の近絶滅種削除画面用のFormクラス
 * @author Misato Kawanaka
 */
@Data
public class CrDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;

}
