package jp.co.futureantiques.webapptraining.model.form.ringoTakizawa;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.ringoTakizawa.RingoMainTakizawa;
import lombok.Data;

/**
 * 椎名林檎の曲（プレイリスト）登録・更新画面用のFormクラス
 *
 * @author Mai Takizawa
 */
@Data
public class RingoTakizawaInputForm {

	/** ID */
	private int id;

	/** 曲名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String songTitle;

	/** CD名ID */
	private Integer cdTitleId;

	/** リリース年 */

	@Size(max = 4, message = "common.text.error.size.equal.four")
	@Pattern(regexp = "^([+-]?0|[1-9][0-9][0-9][0-9])?$", message = "common.text.error.size.equal.four")
	private String releaseYearStr;

	/** 聞きたい気分ID */
	private Integer songImageId;



	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param spaMainOkabe
	 */
	public void initWithRingoMainTakizawa(RingoMainTakizawa ringoMainTakizawa) {
		this.setId((int) ringoMainTakizawa.getId());
		this.setSongTitle(ringoMainTakizawa.getSongTitle());
		this.setCdTitleId(ringoMainTakizawa.getCdTitleId());

		//this.setReleaseYearStr(String.valueOf(ringoMainTakizawa.getReleaseYear()));

		if (ringoMainTakizawa.getReleaseYear() != null) {
			this.setReleaseYearStr(String.valueOf(ringoMainTakizawa.getReleaseYear()));
		}


		this.setSongImageId(ringoMainTakizawa.getSongImageId());
		this.setUpdateDate(String.valueOf(ringoMainTakizawa.getUpdateDate()));
	}

	/**
	 * RingoMainTakizawaエンティティに登録値を入れる
	 *
	 * @return RingoMainTakizawa
	 */
	public RingoMainTakizawa convertToRingoMainTakizawaForInsert() {
		RingoMainTakizawa ringoMainTakizawa = new RingoMainTakizawa();
		ringoMainTakizawa = convertToRingoMainTakizawa(ringoMainTakizawa);
		ringoMainTakizawa.setCreateDate(new Timestamp(new Date().getTime()));
		ringoMainTakizawa.setUpdateDate(ringoMainTakizawa.getCreateDate());
		return ringoMainTakizawa;
	}

	/**
	 * RingoMainTakizawaエンティティに更新値を入れる
	 *
	 * @param RingoMainTakizawa ringoMainTakizawa
	 * @return RingoMainTakizawa
	 */
	public RingoMainTakizawa convertToRingoMainTakizawaForUpdate(RingoMainTakizawa ringoMainTakizawa) {
		ringoMainTakizawa = convertToRingoMainTakizawa(ringoMainTakizawa);
		ringoMainTakizawa.setUpdateDate(new Timestamp(new Date().getTime()));
		return ringoMainTakizawa;
	}

	/**
	 * RingoMainTakizawaエンティティに入力値を入れる
	 *
	 * @param RingoMainTakizawa ringoMainTakizawa
	 * @return RingoMainTakizawa
	 */
	private RingoMainTakizawa convertToRingoMainTakizawa(RingoMainTakizawa ringoMainTakizawa) {
		ringoMainTakizawa.setSongTitle(this.songTitle);
		ringoMainTakizawa.setCdTitleId(this.cdTitleId);

		//ringoMainTakizawa.setReleaseYear(Integer.parseInt(this.releaseYearStr));

		if (!this.releaseYearStr.isEmpty()) {

			//リリース年が入力されていた場合
			ringoMainTakizawa.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		} else {

			//入力されていない場合
			ringoMainTakizawa.setReleaseYear(null);
		}
		//ringoMainTakizawa.setReleaseYear(this.releaseYear);
		ringoMainTakizawa.setSongImageId(this.songImageId);
		ringoMainTakizawa.setDelFlg("0");
		return ringoMainTakizawa;
	}

}
