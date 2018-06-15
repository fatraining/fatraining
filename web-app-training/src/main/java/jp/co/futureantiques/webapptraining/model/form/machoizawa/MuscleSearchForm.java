package jp.co.futureantiques.webapptraining.model.form.machoizawa;

import jp.co.futureantiques.webapptraining.model.machoizawa.MuscleIzawa;
import lombok.Data;

/**
 * 筋トレ検索画面のFormクラス
 *
 * @author future
 */
@Data
public class MuscleSearchForm {

	/** ID */
	private Integer id;

	/** メニュー名 */
	private String menu;

	/** 部位ID */
	private Integer body;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param movieMain
	 */
	public void setValues(MuscleIzawa muscleIzawa) {
		this.setId((int) muscleIzawa.getId());
		this.setMenu(muscleIzawa.getMenu());
		this.setBody(muscleIzawa.getBody());

	}
}
