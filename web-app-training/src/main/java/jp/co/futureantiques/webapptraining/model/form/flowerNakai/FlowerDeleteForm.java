package jp.co.futureantiques.webapptraining.model.form.flowerNakai;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 花削除画面用のFormクラス
 * @author Rieko Nakai
 */
@Data
public class FlowerDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
