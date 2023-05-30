package jp.co.futureantiques.webapptraining.model.form.apexWeaponHagiwara;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 武器削除画面のFormクラス
 *
 * @author Hagiwara
 */
@Data
public class ApexDeleteForm {

	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;
}
