package jp.co.futureantiques.webapptraining.model.form.disneyOkiyoshi;

import jp.co.futureantiques.webapptraining.model.disneyOkiyoshi.DisneyMainOkiyoshi;
import lombok.Data;

/**
 *検索画面のFormクラス
 *
 * @author future
 */
@Data
public class DisneyOkiyoshiSearchForm {

	/** 店舗ID */
	private Integer id;

	/** 店舗名 */
	private String restaurantName;

	/** エリアID */
	private Integer ereaId;

	/** ジャンルID */
	private Integer genreId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param disneyOkiyoshiMain
	 */
	public void setValues(DisneyMainOkiyoshi disneyMainOkiyoshi) {
		this.setId((int) disneyMainOkiyoshi.getId());
		this.setRestaurantName(disneyMainOkiyoshi.getRestaurantName());
		this.setEreaId(disneyMainOkiyoshi.getEreaId());
		this.setGenreId(disneyMainOkiyoshi.getGenreId());
		}
}
