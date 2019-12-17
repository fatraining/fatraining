package jp.co.futureantiques.webapptraining.model.form.boowyWaki;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * BOØWYの曲削除画面のFormクラス
 *
 * @author WAKI
 * */
@Data
public class BoowyWakiDeleteForm {
	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
