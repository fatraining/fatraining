package jp.co.futureantiques.webapptraining.model.form.bandTaneichi;

import jp.co.futureantiques.webapptraining.model.bandTaneichi.BandMainTaneichi;
import lombok.Data;

/**
 * バンド検索画面のFormクラス
 *
 */
@Data

public class BandTaneichiSearchForm {

	/** ID*/
	private Integer id;

	/** バンド名*/
	private String bandName;

	private Integer bandSex;

	/** ジャンルID*/
	private Integer genreId;

	/** 削除フラグON用*/
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param bandMain
	 */
	public void setValues(BandMainTaneichi bandMainTaneichi) {
		this.setId((int) bandMainTaneichi.getId());
		this.setBandName(bandMainTaneichi.getBandName());
		this.setBandSex(bandMainTaneichi.getBandSex());
		this.setGenreId(bandMainTaneichi.getGenreId());
	}

}
