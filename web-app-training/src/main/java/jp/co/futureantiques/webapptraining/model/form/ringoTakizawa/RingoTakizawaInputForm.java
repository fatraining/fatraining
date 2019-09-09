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
 * htmlで入力した値を格納
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
	//正規表現で「4桁の数字（千の位は1-9の数字指定）」という制限をしている
	@Pattern(regexp = "^([1-9][0-9][0-9][0-9])?$", message = "common.text.error.size.equal.four")
	//入力欄はStringの形で入れる形式（input type="text"）のため、String型にしている（後に検索かける際にinteger型にする）
	private String releaseYearStr;

	/** 聞きたい気分ID */
	private Integer songImageId;

	/** 更新日時（排他制御用） */
	private String updateDate;






	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param ringoMainTakizawa
	 */
	public void initWithRingoMainTakizawa(RingoMainTakizawa ringoMainTakizawa) {
		//CdTitleIdとSongImageIdは入力欄空白の時にはID=0が入るため、nullになることがない。
		//→ifを使わない
		this.setId((int) ringoMainTakizawa.getId());
		this.setSongTitle(ringoMainTakizawa.getSongTitle());
		this.setCdTitleId(ringoMainTakizawa.getCdTitleId());

		//nullがOKのため、入力があるときだけ、setReleaseYearStrする
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


		if (!this.releaseYearStr.isEmpty()) {

			//リリース年が入力されていた場合
			ringoMainTakizawa.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		} else {

			//入力されていない場合
			ringoMainTakizawa.setReleaseYear(null);
		}

		ringoMainTakizawa.setSongImageId(this.songImageId);
		ringoMainTakizawa.setDelFlg("0");
		return ringoMainTakizawa;
	}

}
