package jp.co.futureantiques.webapptraining.model.form.mlbUezu;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

//未作成↓
/**
 * MLB球団削除画面のFormクラス
 *
 * @author future
 */
@Data
public class MLBTeamDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
//未作成↑