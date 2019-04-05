package jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

//映画削除画面のFormクラス

@Data
public class HamsterKobayashiDeleteForm {

	@Size(min = 1, message = "commmon.text.error.require.check")
	private ArrayList<Long> deleteIds;

}
