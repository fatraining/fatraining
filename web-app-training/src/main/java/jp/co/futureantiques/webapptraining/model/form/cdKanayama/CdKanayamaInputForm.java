package jp.co.futureantiques.webapptraining.model.form.cdKanayama;


import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.cdKanayama.CdMainKanayama;
import lombok.Data;

/**
 * 映画登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data

public class CdKanayamaInputForm {

	/** ID */
	private int id;

	/** CDタイトル */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String cdTitle;

	/** ジャンルID */
	private Integer genreId;

	/** アーティスト名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String artistName;

	/** リリース年 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** 再生時間 */
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String playTimeStr;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;


	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param cdMain
	 */
	public void initWithCdMain(CdMainKanayama cdMain) {
		this.setId((int) cdMain.getId());
		this.setCdTitle(cdMain.getCdTitle());
		this.setGenreId(cdMain.getGenreId());
		this.setArtistName(cdMain.getArtistName());
		this.setReleaseYearStr(String.valueOf(cdMain.getReleaseYear()));
		if (cdMain.getPlayTime() != null) {
			this.setPlayTimeStr(String.valueOf(cdMain.getPlayTime()));
		}
		this.setComment(cdMain.getComment());
		this.setUpdateDate(String.valueOf(cdMain.getUpdateDate()));
	}

	/**
	 * CdMainエンティティに登録値を入れる
	 *
	 * @return CdMain
	 */
	public CdMainKanayama convertToCdMainKanayamaForInsert() {
		CdMainKanayama cdMain = new CdMainKanayama();
		cdMain = convertToCdMain(cdMain);
		cdMain.setCreateDate(new Timestamp(new Date().getTime()));
		cdMain.setUpdateDate(cdMain.getCreateDate());
		return cdMain;
	}


	/**
	 * CdMainエンティティに更新値を入れる
	 *
	 * @param CdMain cdMain
	 * @return CdMain
	 */
	public CdMainKanayama convertToCdMainForUpdate(CdMainKanayama cdMain) {
		cdMain = convertToCdMain(cdMain);
		cdMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return cdMain;
	}
	/**
	 * CdMainエンティティに入力値を入れる
	 *
	 * @param CdMain cdMain
	 * @return CdMain
	 */
	private CdMainKanayama convertToCdMain(CdMainKanayama cdMain) {
		cdMain.setCdTitle(this.cdTitle);
		if(this.genreId == CommonConst.NOT_ENTERD) {

			// ジャンルが入力されていなかった場合
			cdMain.setGenreId(null);
		}else {

			// ジャンルが入力されていた場合
			cdMain.setGenreId(this.genreId);
		}

		cdMain.setArtistName(this.artistName);


		cdMain.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		if (!this.playTimeStr.isEmpty()) {

			// 再生時間が入力されていた場合
			cdMain.setPlayTime(Integer.parseInt(this.playTimeStr));
		} else {

			// 再生時間が入力されていなかった場合
			cdMain.setPlayTime(null);
		}
		cdMain.setComment(this.comment);
		cdMain.setDelFlg("0");
		return cdMain;
	}

}
