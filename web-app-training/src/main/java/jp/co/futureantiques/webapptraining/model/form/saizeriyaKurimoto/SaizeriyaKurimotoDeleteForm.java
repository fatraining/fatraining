package jp.co.futureantiques.webapptraining.model.form.saizeriyaKurimoto;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

//メニュー削除画面のFormクラス
//@author Kurimoto

@Data
public class SaizeriyaKurimotoDeleteForm {

	//削除ID
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}