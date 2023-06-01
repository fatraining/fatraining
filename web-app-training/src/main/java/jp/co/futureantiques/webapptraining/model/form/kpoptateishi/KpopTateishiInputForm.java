package jp.co.futureantiques.webapptraining.model.form.kpoptateishi;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.kpoptateishi.KpopMain;
import lombok.Data;

/**
 * 楽曲登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data
public class KpopTateishiInputForm {

	/** ID */
	private int id;

	/** 楽曲名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String musicTitle;

	/** アイドルID */
	private Integer idolId;

	/** 所属事務所ID */
	private Integer officeId;

	/** 公開年 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** 楽曲時間 */
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String musicTimeStr;

	/** MVのURL */
	@Size(max = 255)
	private String mvUrl;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param kpopMain
	 */
	public void initWithKpopMain(KpopMain kpopMain) {
		this.setId((int) kpopMain.getId());
		this.setMusicTitle(kpopMain.getMusicTitle());
		this.setIdolId(kpopMain.getIdolId());
		this.setOfficeId(kpopMain.getOfficeId());
		this.setReleaseYearStr(String.valueOf(kpopMain.getReleaseYear()));
		if (kpopMain.getMusicTime() != null) {
			this.setMusicTimeStr(String.valueOf(kpopMain.getMusicTime()));
		}
		this.setMvUrl(kpopMain.getMvUrl());
		this.setUpdateDate(String.valueOf(kpopMain.getUpdateDate()));
	}

	/**
	 * KpopMainエンティティに登録値を入れる
	 *
	 * @return kpopMain
	 */
	public KpopMain convertToKpopMainForInsert() {
		KpopMain kpopMain = new KpopMain();
		kpopMain = convertToKpopMain(kpopMain);
		kpopMain.setCreateDate(new Timestamp(new Date().getTime()));
		kpopMain.setUpdateDate(kpopMain.getCreateDate());
		return kpopMain;
	}

	/**
	 * KpopMainエンティティに更新値を入れる
	 *
	 * @param KpopMain kpopMain
	 * @return KpopMain
	 */
	public KpopMain convertToKpopMainForUpdate(KpopMain kpopMain) {
		kpopMain = convertToKpopMain(kpopMain);
		kpopMain.setUpdateDate(new Timestamp(new Date().getTime()));
		return kpopMain;
	}

	/**
	 * KpopMainエンティティに入力値を入れる
	 *
	 * @param KpopMain kpopMain
	 * @return KpopMain
	 */
	private KpopMain convertToKpopMain(KpopMain kpopMain) {
		kpopMain.setMusicTitle(this.musicTitle);
		if(this.idolId == CommonConst.NOT_ENTERD) {

			// アイドルが入力されていなかった場合
			kpopMain.setIdolId(null);
		}else {

			// アイドルが入力されていた場合
			kpopMain.setIdolId(this.idolId);
		}
		if(this.officeId == CommonConst.NOT_ENTERD) {

			// 所属事務所が入力されていなかった場合
			kpopMain.setOfficeId(null);
		}else {

			// 所属事務所が入力されていた場合
			kpopMain.setOfficeId(this.officeId);
		}
		kpopMain.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		if (!this.musicTimeStr.isEmpty()) {

			// 楽曲時間が入力されていた場合
			kpopMain.setMusicTime(Integer.parseInt(this.musicTimeStr));
		} else {

			// 楽曲時間が入力されていなかった場合
			kpopMain.setMusicTime(null);
		}
		kpopMain.setMvUrl(this.mvUrl);
		kpopMain.setDelFlg("0");
		return kpopMain;
	}
}