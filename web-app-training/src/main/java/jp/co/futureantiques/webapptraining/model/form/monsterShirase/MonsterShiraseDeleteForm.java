package jp.co.futureantiques.webapptraining.model.form.monsterShirase;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * モンスター削除画面のFormクラス
 *
 * @author Shirase
 */
@Data
public class MonsterShiraseDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
