package jp.co.futureantiques.webapptraining.model.form.eggSekine;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.eggsekine.EggMain;
import lombok.Data;

/**
 * 映画登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data
public class EggInputForm {

	/** ID */
	private int id;

	/** 映画名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String eggTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 俳優ID */
	private Integer actorId;

	/** 公開年 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** 上映時間 */
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String runTimeStr;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param eggMain
	 */
	public void initWitheggMain(eggMain eggMain) {
		this.setId((int) eggMain.getId());
		this.seteggTitle(eggMain.geteggTitle());
		this.setGenreId(eggMain.getGenreId());
		this.setActorId(eggMain.getCookId());
		this.setReleaseYearStr(String.valueOf(eggMain.getCalorie()));
		if (eggMain.getRunTime() != null) {
			this.setRunTimeStr(String.valueOf(eggMain.getRunTime()));
		}
		this.setComment(eggMain.getComment());
		this.setUpdateDate(String.valueOf(eggMain.getUpdateDate()));
	}

	/**
	 * eggMainエンティティに登録値を入れる
	 *
	 * @return eggMain
	 */
	public eggMain convertToeggMainForInsert() {
		EggMain eggMain = new eggMain();
		eggMain = convertToEggMain(eggMain);
		eggMain.setCreateDate(new Timestamp(new Date().getTime()));
		eggMain.setUpdateDate(eggMain.getCreateDate());
		return eggMain;
	}

	/**
	 * eggMainエンティティに更新値を入れる
	 *
	 * @param eggMain eggMain
	 * @return eggMain
	 */
	public eggMain convertToeggMainForUpdate(eggMain eggMain) {
		eggMain = convertToeggMain(eggMain);
		eggMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return eggMain;
	}

	/**
	 * eggMainエンティティに入力値を入れる
	 *
	 * @param eggMain eggMain
	 * @return eggMain
	 */
	private eggMain convertToeggMain(eggMain eggMain) {
		eggMain.seteggTitle(this.eggTitle);
		eggMain.setGenreId(this.genreId);
		eggMain.setCookId(this.actorId);
		eggMain.setCalorie(Integer.parseInt(this.CalorieStr));
		if (!this.runTimeStr.isEmpty()) {

			// 上映時間が入力されていた場合
			eggMain.setRunTime(Integer.parseInt(this.runTimeStr));
		} else {

			// 上映時間が入力されていなかった場合
			eggMain.setRunTime(null);
		}
		eggMain.setComment(this.comment);
		eggMain.setDelFlg("0");
		return eggMain;
	}
}
