package jp.co.futureantiques.webapptraining.model.form.guiterFujimoto;

import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.GuiterMainFujimoto;
import lombok.Data;

/**
 * 検索画面のFormクラス
 * @author FUJIMOTO　YOSIHISA
 */
@Data
public class GuiterSearchForm {

	/**ID*/
	private Integer id;

	/**名前*/
	private String name;

	/**会社ID*/
	private Integer companyId;

	/**木材ID*/
	private Integer woodId;

	/** 削除フラグON用*/
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param guiterMainFujimoto
	 */
	public void setValues(GuiterMainFujimoto guiterMainFujimoto){
		this.setId((int)guiterMainFujimoto.getId());
		this.setName(guiterMainFujimoto.getAconame());
		this.setCompanyId(guiterMainFujimoto.getCompanyId());
		this.setWoodId(guiterMainFujimoto.getWoodId());
	}
}