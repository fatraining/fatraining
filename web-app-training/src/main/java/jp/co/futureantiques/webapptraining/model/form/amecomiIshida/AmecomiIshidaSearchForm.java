package jp.co.futureantiques.webapptraining.model.form.amecomiIshida;

import jp.co.futureantiques.webapptraining.model.amecomiishida.AmecomiCharIshida;
import lombok.Data;

/**
 * アメコミキャラ検索画面のFormクラス。
 * 画面のパラメータを格納する。
 * @author ishida
 */
@Data
public class AmecomiIshidaSearchForm {

	/** キャラネーム */
	private String charName;

	/** 印刷会社ID */
	private Integer companyId;

	/** サイドID */
	private Integer sideId;

	/** ID */
	private Integer id;


	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * Entityの各フィールドに値を設定する。
	 * @param AmecomiCharIshida amecomiCharIshida
	 */
	public void setValues(AmecomiCharIshida amecomiCharIshida) {
		this.setCharName(amecomiCharIshida.getCharName());
		this.setCompanyId(amecomiCharIshida.getCompanyId());
		this.setSideId(amecomiCharIshida.getSideId());
		this.setId((int) amecomiCharIshida.getId());


	}

}