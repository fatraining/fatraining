package jp.co.futureantiques.webapptraining.model.form.musicKaji;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 楽曲削除画面のFormクラス
 *
 * @author futute
 */
@Data
public class MusicKajiDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.errorr.require.check")
	private ArrayList<Long> deleteIds;
}
