package com.example.demo.model.form.zelda;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.example.demo.model.zeldaikeda.ZeldaMainIkeda;

import lombok.Data;

/**
 * ゼルダタイトル登録・更新用のFormクラス
 */
@Data
public class ZeldaInputForm {

	/** ゼルダID */
	private int zeldaId;

	/** ゼルダタイトル */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String zeldaTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 時系列ID */
	private Integer timeSeriesId;

	/** 対応機種ID */
	private Integer compatibleModelId;

	/** 発売年 */
	@NotBlank(message = "common.text.error.require")
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYear;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用）*/
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 * @param zeldaMain
	 */
	public void initWithZeldaMain(ZeldaMainIkeda zeldaMain) {
		this.setZeldaId((int) zeldaMain.getZeldaId());
		this.setZeldaTitle(zeldaMain.getZeldaTitle());
		this.setGenreId(zeldaMain.getGenreId());
		this.setTimeSeriesId(zeldaMain.getTimeSeriesId());
		this.setCompatibleModelId(zeldaMain.getCompatibleModelId());
		this.setReleaseYear(String.valueOf(zeldaMain.getReleaseYear()));
		this.setComment(zeldaMain.getComment());
		this.setUpdateDate(String.valueOf(zeldaMain.getUpdateDate()));
	}

	/**
	 * ZeldaMainエンティティに登録値を入れる
	 * @return ZeldaMainIkeda
	 */
	public ZeldaMainIkeda convertToZeldaMainIkedaForInsert() {
		ZeldaMainIkeda zeldaMain = new ZeldaMainIkeda();
		zeldaMain = convertToZeldaMain(zeldaMain);
		zeldaMain.setCreateDate(new Timestamp(new Date().getTime()));
		zeldaMain.setUpdateDate(zeldaMain.getCreateDate());
		return zeldaMain;
	}

	/** ZeldaMainエンティティに更新値を入れる
	 *  @param ZeldaMainIkeda zeldaMain
	 *  @return ZeldaMainIkeda
	 */
	public ZeldaMainIkeda convertToZeldaMainIkedaForUpdate(ZeldaMainIkeda zeldaMain) {
		zeldaMain = convertToZeldaMain(zeldaMain);
		zeldaMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return zeldaMain;
	}

	/**
	 * ZeldaMainエンティティに入力値を入れる
	 * @param ZeldaMainIkeda zeldaMain
	 * @return ZeldaMainIkeda
	 */
	private ZeldaMainIkeda convertToZeldaMain(ZeldaMainIkeda zeldaMain) {
		zeldaMain.setZeldaTitle(this.zeldaTitle);
		if (this.genreId != null) {

			// ジャンルが入力されていた場合
			zeldaMain.setGenreId(this.genreId);
		} else {

			// ジャンルが入力されていなかった場合
			zeldaMain.setGenreId(null);
		}
		if (this.timeSeriesId != null) {

			// 時系列が入力されていた場合
			zeldaMain.setTimeSeriesId(this.timeSeriesId);
		} else {

			// 時系列が入力されていなかった場合
			zeldaMain.setTimeSeriesId(null);
		}

		if (this.compatibleModelId != null) {

			// 対応機種が入力されていた場合
			zeldaMain.setCompatibleModelId(this.compatibleModelId);
		} else {

			// 対応機種が入力されていなかった場合
			zeldaMain.setCompatibleModelId(null);

		}if (this.releaseYear != null) {

			// 発売年が入力されていた場合
			zeldaMain.setReleaseYear(Integer.parseInt(this.releaseYear));
		} else {

			// 発売年が入力されていなかった場合
			zeldaMain.setReleaseYear(null);
		}
		zeldaMain.setComment(this.comment);
		zeldaMain.setDelFlg("0");
		return zeldaMain;
	}
}
