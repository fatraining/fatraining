package jp.co.futureantiques.webapptraining.model.form.radioKashima;

import jp.co.futureantiques.webapptraining.model.radioKashima.RadioMainKashima;
import lombok.Data;

/**
 * Radio検索画面のFormクラス
 * @author  kashima
 */
@Data
public class RadioKashimaSearchForm {

	/**ID**/
	private Integer id;

	/**ラジオ番組名**/
	private String programName;

	/**パーソナリティ**/
	private String personality;

	/**放送局ID**/
	private Integer keystationId;

	/**削除フラグON用**/
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param radioMainKashima
	 */
	public void setValues(RadioMainKashima radioMainKashima) {
		this.setId((int) radioMainKashima.getId());
		this.setProgramName(radioMainKashima.getProgramName());
		this.setPersonality(radioMainKashima.getPersonality());
		this.setKeystationId(radioMainKashima.getKeystationId());

	}

}
