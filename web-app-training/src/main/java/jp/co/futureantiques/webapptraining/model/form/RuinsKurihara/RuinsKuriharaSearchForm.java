package jp.co.futureantiques.webapptraining.model.form.RuinsKurihara;

import jp.co.futureantiques.webapptraining.model.RuinsKurihara.RuinsMainKurihara;
import lombok.Data;

/**
 * 廃墟検索画面のFormクラス
 *
 * @author m.kurihara
 */
@Data
public class RuinsKuriharaSearchForm {

	/** ID */
	private Integer id;

	/** 廃墟名 */
	private String ruinsName;

	/** 種別ID */
	private Integer genreId;

	/** 地域ID */
	private Integer areaId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param ruinsMainKurihara
	 */
	public void setValues(RuinsMainKurihara ruinsMain) {
		this.setId((int) ruinsMain.getId());
		this.setRuinsName(ruinsMain.getRuinsName());
		this.setGenreId(ruinsMain.getGenreId());
		this.setAreaId(ruinsMain.getAreaId());
	}
}
