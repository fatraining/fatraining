package com.example.demo.model.form.drama;

import java.sql.Timestamp;
import java.util.Date;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.drama.DramaMainNakaniwa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ドラマ登録・更新画面用のFormクラス
 *
 */
@Data
public class DramaInputForm {

	/** ID*/
	private int id;

	/** ドラマ名*/
	//必須チェックのためのアノテーション
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String dramaTitle;

	/** ジャンルID*/
	private Integer genreId;

	/** 製作国ID*/
	private Integer countryId;

	/** 公開年*/
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	//正規表現チェックのアノテーション
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** シーズン*/
	@Size(min = 0, max = 2, message = "common.text.error.size.max.two")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String seasonStr;

	/** あらすじ*/
	@Size(max = 255)
	private String summary;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param dramaMainNakaniwa
	 */
	public void initWithDramaMainNakaniwa(DramaMainNakaniwa dramaMainNakaniwa) {
		this.setId((int) dramaMainNakaniwa.getId());
		this.setDramaTitle(dramaMainNakaniwa.getDramaTitle());
		this.setGenreId(dramaMainNakaniwa.getGenreId());
		this.setCountryId(dramaMainNakaniwa.getCountryId());
		this.setReleaseYearStr(String.valueOf(dramaMainNakaniwa.getReleaseYear()));
		if (dramaMainNakaniwa.getSeason() != null) {
			this.setSeasonStr(String.valueOf(dramaMainNakaniwa.getSeason()));
		}
		this.setSummary(dramaMainNakaniwa.getSummary());
		this.setUpdateDate(String.valueOf(dramaMainNakaniwa.getUpdateDate()));
	}

	/**
	 * DramaMainNakaniwaエンティティに登録値を入れる
	 *
	 * @return DramaMainNakaniwa
	 */
	public DramaMainNakaniwa convertToDramaMainNakaniwaForInsert() {
		DramaMainNakaniwa dramaMainNakaniwa = new DramaMainNakaniwa();
		dramaMainNakaniwa = convertToDramaMainNakaniwa(dramaMainNakaniwa);
		dramaMainNakaniwa.setCreateDate(new Timestamp(new Date().getTime()));
		dramaMainNakaniwa.setUpdateDate(dramaMainNakaniwa.getCreateDate());
		return dramaMainNakaniwa;

	}

	/**
	 * DramaMainNakaniwaエンティティに更新値を入れる
	 *
	 * @param DramaMainNakaniwa dramaMainNakaniwa
	 * @return DramaMainNakaniwa
	 */
	public DramaMainNakaniwa convertToDramaMainNakaniwaForUpdate(DramaMainNakaniwa dramaMainNakaniwa) {
		dramaMainNakaniwa = convertToDramaMainNakaniwa(dramaMainNakaniwa);
		dramaMainNakaniwa.setUpdateDate(new Timestamp(new Date().getTime()));
		return dramaMainNakaniwa;
	}

	/**
	 * DramaMainNakaniwaエンティティに入力値を入れる
	 *
	 * @param DramaMainNakaniwa dramaMainNakaniwa
	 * @return DramaMainNakaniwa
	 */
	private DramaMainNakaniwa convertToDramaMainNakaniwa(DramaMainNakaniwa dramaMainNakaniwa) {
		dramaMainNakaniwa.setDramaTitle(this.dramaTitle);
		if (this.genreId == CommonConst.NOT_ENTERD) {

			// ジャンルが入力されていなかった場合
			dramaMainNakaniwa.setGenreId(null);
		} else {

			// ジャンルが入力されていた場合
			dramaMainNakaniwa.setGenreId(this.genreId);

		}
		if (this.countryId == CommonConst.NOT_ENTERD) {

			// 製作国が入力されていなかった場合
			dramaMainNakaniwa.setCountryId(null);
		} else {

			// 製作国が入力されていた場合
			dramaMainNakaniwa.setCountryId(this.countryId);
		}
		dramaMainNakaniwa.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		if (!this.seasonStr.isEmpty()) {

			// シーズンが入力されていた場合
			dramaMainNakaniwa.setSeason(Integer.parseInt(this.seasonStr));
		} else {

			// シーズンが入力されていなかった場合
			dramaMainNakaniwa.setSeason(null);
		}
		dramaMainNakaniwa.setSummary(this.summary);
		dramaMainNakaniwa.setDelFlg("0");
		return dramaMainNakaniwa;
	}

}
