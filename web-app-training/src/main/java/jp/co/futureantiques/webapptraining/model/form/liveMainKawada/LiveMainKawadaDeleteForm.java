package jp.co.futureantiques.webapptraining.model.form.liveMainKawada;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ライブ定番曲削除画面のFormクラス
 * @author future
 *
 */
@Data
public class LiveMainKawadaDeleteForm {

	//削除ID
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> Ids;

}
