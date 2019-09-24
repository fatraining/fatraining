package jp.co.futureantiques.webapptraining.model.form.brandKambara;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ブランド削除画面のFormクラス
 *
 * @author Yuki Kambara
 */
@Data
public class BrandKambaraDeleteForm {
	/** 削除ID */
	@Size(min = 1, message = "common.text.error.require.check")
	private ArrayList<Long> deleteIds;

}
