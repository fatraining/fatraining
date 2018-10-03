package jp.co.futureantiques.webapptraining.model.form.heritageKataoka;

import jp.co.futureantiques.webapptraining.model.heritagekataoka.HeritageMainKataoka;
import lombok.Data;

/**
 * 世界遺産検索画面のFormクラス
 *
 */
@Data
public class HeritageSearchForm {

	/** 世界遺産ID */
	private Integer id;

	/** 登録名 */
	private String heritageName;

	/**ジャンル */
	private Integer genreId;

	/** 所在地 */
	private Integer locationId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param heritageMainKataoka
	 */

	public void setValues(HeritageMainKataoka heritageMainKataoka) {
		// TO:DO 所在地１であってる？
		this.setId((int) heritageMainKataoka.getId());//クラス名。そこで設定したカラム
		this.setHeritageName(heritageMainKataoka.getHeritageName());
		this.setGenreId(heritageMainKataoka.getGenreId());
		this.setLocationId(heritageMainKataoka.getLocationId1());
		this.setLocationId(heritageMainKataoka.getLocationId2());
		this.setLocationId(heritageMainKataoka.getLocationId3());
		this.setLocationId(heritageMainKataoka.getLocationId4());
		this.setLocationId(heritageMainKataoka.getLocationId5());
		this.setLocationId(heritageMainKataoka.getLocationId6());
		this.setLocationId(heritageMainKataoka.getLocationId7());
		this.setLocationId(heritageMainKataoka.getLocationId8());


	}
}



