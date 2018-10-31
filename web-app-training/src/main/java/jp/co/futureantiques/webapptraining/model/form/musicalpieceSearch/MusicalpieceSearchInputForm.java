package jp.co.futureantiques.webapptraining.model.form.musicalpieceSearch;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ArianaMainRuike;
import lombok.Data;

/**
 * 音楽更新用のフォームクラス
 *
 * @author future
 *
 */

@Data
public class MusicalpieceSearchInputForm {

	/**  シングルID*/
	private int singleId;

	/** シングル名*/
	@NotBlank(message = "commn.text.error.require")
	@Size(max = 255)
	private String singleTitle;

	/** アルバムID*/
	private Integer albumId;

	/** コラボアーティストID */
	private Integer colaboId;

	/** 発売年 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** 再生時間 */
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String playTimeStr;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param movieMain
	 */
	public void initWithArianaMainRuike(ArianaMainRuike arianaMainRuike) {
		this.setSingleId((int) arianaMainRuike.getSingleId());
		this.setSingleTitle(arianaMainRuike.getSingleTitle());
		this.setAlbumId(arianaMainRuike.getAlbumId());
		this.setColaboId(arianaMainRuike.getColaboId());
		this.setReleaseYearStr(String.valueOf(arianaMainRuike.getReleaseYear()));
		if (arianaMainRuike.getPlayTime() != null) {
			this.setPlayTimeStr(String.valueOf(arianaMainRuike.getPlayTime()));
		}
		this.setUpdateDate(String.valueOf(arianaMainRuike.getUpdateDate()));
	}

	/**
	 * ArianaMainRuikeエンティティに更新値を入れる
	 *
	 * @param arianaMainRuike arianaMainRuike
	 * @return ArianaRuikeMain
	 */
	public ArianaMainRuike convertToArianaMainRuikeForUpdate(ArianaMainRuike arianaMainRuike) {
		arianaMainRuike = convertToArianaMainRuike(arianaMainRuike);
		arianaMainRuike.setUpdateDate(new Timestamp(new Date().getTime()));
		return arianaMainRuike;
	}

	/**
	 * ArianaMainRuikeエンティティに入力値を入れる
	 *
	 * @param ArianaMainRuike arianaMainRuike
	 * @return ArianaMainRuike
	 */
	private ArianaMainRuike convertToArianaMainRuike(ArianaMainRuike arianaMainRuike) {
		arianaMainRuike.setSingleTitle(this.singleTitle);
		arianaMainRuike.setAlbumId(this.albumId);
		arianaMainRuike.setColaboId(this.colaboId);
		arianaMainRuike.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		if (!this.playTimeStr.isEmpty()) {

			// 再生時間が入力されていた場合
			arianaMainRuike.setPlayTime(Integer.parseInt(this.playTimeStr));
		} else {

			// 上映時間が入力されていなかった場合
			arianaMainRuike.setPlayTime(null);
		}
		return arianaMainRuike;
	}
}
