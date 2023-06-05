package jp.co.futureantiques.webapptraining.model.form.musicKaji;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.musicKaji.MusicMainKaji;
import lombok.Data;

/**
 * 楽曲登録・更新画面用のFormクラス
 *
 * @author futute
 */
@Data
public class MusicKajiInputForm {

	/** ID **/
	private int id;

	/** 楽曲名 **/
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256, message = "music.text.error.countover")
	private String musicTitle;

	/** ユニットID **/
	private Integer unitId;

	/** 作曲者ID **/
	private Integer composerId;

	/** 公開年 **/
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** 時間 **/
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	private String musicTimeStr;

	/** コメント **/
	@Size(max = 256)
	private String comment;

	/** 更新日時 (排他制御用)**/
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param musicMainKaji
	 */
	public void initWithMusicMainKaji(MusicMainKaji musicMainKaji) {
		this.setId((int) musicMainKaji.getId());
		this.setMusicTitle(musicMainKaji.getMusicTitle());
		this.setUnitId(musicMainKaji.getUnitId());
		this.setComposerId(musicMainKaji.getComposerId());
		this.setReleaseYearStr(String.valueOf(musicMainKaji.getReleaseYear()));
		this.setMusicTimeStr(musicMainKaji.getMusicTime());
		this.setComment(musicMainKaji.getComment());
		this.setUpdateDate(String.valueOf(musicMainKaji.getUpdateDate()));
	}

	/**
	 * MusicMainKajiエンティティに登録値を入れる
	 *
	 * @return MusicMainKaji
	 */
	public MusicMainKaji convertToMusicMainKajiForInsert() {
		MusicMainKaji musicMainKaji = new MusicMainKaji();
		musicMainKaji = convertToMusicMainKaji(musicMainKaji);
		musicMainKaji.setCreateDate(new Timestamp(new Date().getTime()));
		musicMainKaji.setUpdateDate(musicMainKaji.getCreateDate());
		return musicMainKaji;
	}

	/**
	 * MusicMainKajiエンティティに更新値を入れる
	 *
	 * @param MusicMainKaji musicMainKaji
	 * @return MusicMainKaji
	 */
	public MusicMainKaji convertToMusicMainKajiForUpdate(MusicMainKaji musicMainKaji) {
		musicMainKaji = convertToMusicMainKaji(musicMainKaji);
		musicMainKaji.setUpdateDate(new Timestamp(new Date().getTime()));
		return musicMainKaji;
	}

	/** MusicMainKajiエンティティに入力値を入れる
	 *
	 * @param MusicMainKaji musicMainKaji
	 * @return MusicMainKaji
	 */
	private MusicMainKaji convertToMusicMainKaji(MusicMainKaji musicMainKaji) {
		musicMainKaji.setMusicTitle(this.musicTitle);
		if (this.unitId == CommonConst.NOT_ENTERD) {

			// ユニットが入力されていなかった場合
			musicMainKaji.setUnitId(null);
		} else {

			// ユニットが入力されていた場合
			musicMainKaji.setUnitId(this.unitId);
		}
		if (this.composerId == CommonConst.NOT_ENTERD) {

			// 作曲者が入力されていなかった場合
			musicMainKaji.setComposerId(null);
		} else {

			//作曲者が入力されていた場合
			musicMainKaji.setComposerId(this.composerId);
		}
		musicMainKaji.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		if (!this.musicTimeStr.isEmpty()) {

			//時間が入力されていた場合
			musicMainKaji.setMusicTime(this.musicTimeStr);
		} else {

			//時間が入力されていなかった場合
			musicMainKaji.setMusicTime(null);
		}
		musicMainKaji.setComment(this.comment);
		musicMainKaji.setDelFlg("0");
		return musicMainKaji;
	}
}
