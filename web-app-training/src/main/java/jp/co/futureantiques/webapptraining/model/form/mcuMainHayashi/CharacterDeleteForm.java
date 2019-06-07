package jp.co.futureantiques.webapptraining.model.form.mcuMainHayashi;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * キャラクター削除画面のFormクラス
 *
 * @author 林 重樹
 */
@Data
public class CharacterDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
