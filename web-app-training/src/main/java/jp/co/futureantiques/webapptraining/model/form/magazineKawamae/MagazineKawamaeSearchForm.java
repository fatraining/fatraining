package jp.co.futureantiques.webapptraining.model.form.magazineKawamae;

import javax.validation.constraints.DecimalMin;

import jp.co.futureantiques.webapptraining.model.magazinekawamae.MagazineMainKawamae;
import lombok.Data;

/**
 * 雑誌検索画面のFormクラス
 *
 * @author wataru kawamae
 */
@Data
public class MagazineKawamaeSearchForm {

	/** ID */
	private Integer id;

	/** 映画名 */
	private String magazineName;

	/** ジャンルID */
	private Integer genreId;

	/** 売り上げ部数 */
	@DecimalMin(value = "0", message = "magazine.number.error.invalid.salednumber")
	private Integer saledNumber;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param magazineMainKawamae
	 */
	public void setValues(MagazineMainKawamae magazineMainKawamae) {
		this.setId((int) magazineMainKawamae.getId());
		this.setMagazineName(magazineMainKawamae.getMagazineName());
		this.setGenreId(magazineMainKawamae.getGenreId());
		this.setSaledNumber(magazineMainKawamae.getSaledNumber());
	}
}
