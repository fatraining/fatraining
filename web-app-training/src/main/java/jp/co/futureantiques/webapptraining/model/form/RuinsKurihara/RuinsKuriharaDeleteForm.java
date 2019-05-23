package jp.co.futureantiques.webapptraining.model.form.RuinsKurihara;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 廃墟削除画面のFormクラス
 *
 * @author m.kurihara
 */
@Data
public class RuinsKuriharaDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}