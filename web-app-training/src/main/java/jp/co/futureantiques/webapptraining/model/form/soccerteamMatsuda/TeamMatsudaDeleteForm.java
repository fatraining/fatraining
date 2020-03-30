package jp.co.futureantiques.webapptraining.model.form.soccerteamMatsuda;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 登録チーム画面のFormクラス
 *
 * @author future
 */
@Data
public class TeamMatsudaDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}