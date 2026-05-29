package com.example.demo.model.form.zelda;

import com.example.demo.model.zeldaikeda.ZeldaMainIkeda;

import lombok.Data;

/**
 * ゼルダ検索画面のFormクラス
 */
@Data
public class ZeldaSearchForm {

	/** ゼルダID */
	private Integer zeldaId;

	/** ゼルダタイトル */
	private String zeldaTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 時系列ID */
	private Integer timeSeriesId;

	/** 対応機種ID */
	private Integer compatibleModelId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 * @param zeldaMain
	 */
	public void setValues(ZeldaMainIkeda zeldaMain) {
		this.setZeldaId((int) zeldaMain.getZeldaId());
		this.setZeldaTitle(zeldaMain.getZeldaTitle());
		this.setGenreId(zeldaMain.getGenreId());
		this.setTimeSeriesId(zeldaMain.getTimeSeriesId());
		this.setCompatibleModelId(zeldaMain.getCompatibleModelId());
	}
}
