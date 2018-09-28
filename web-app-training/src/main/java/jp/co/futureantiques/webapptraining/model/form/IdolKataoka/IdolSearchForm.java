package jp.co.futureantiques.webapptraining.model.form.IdolKataoka;

import jp.co.futureantiques.webapptraining.model.IdolKataoka.IdolMainKataoka;
import lombok.Data;

/**
 * 検索画面のFormクラス
 *
 * @author skataoka
 */
@Data
	public class IdolSearchForm {




	/** アイドルID */
	private Integer idolId;

	/** アイドルの名前 */
	private String idolName;

	/**メンバーカラーID */
	private Integer colorId;

	/** 所属グループID */
	private Integer groupId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param idolMainKataoka
	 */
	public void setValues(IdolMainKataoka idolMainKataoka) {
		this.setIdolId((int) idolMainKataoka.getIdolId());
		this.setIdolName(idolMainKataoka.getIdolName());
		this.setColorId(idolMainKataoka.getColorId());
		this.setGroupId(idolMainKataoka.getGroupId());
	}
}
