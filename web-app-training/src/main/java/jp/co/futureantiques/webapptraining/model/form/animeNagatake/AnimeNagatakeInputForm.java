package jp.co.futureantiques.webapptraining.model.form.animeNagatake;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.animeNagatake.AnimeMainNagatake;
import lombok.Data;

/**
 * アニメ登録、更新画面用のFormクラス
 *
 * @author future
 * */
@Data
public class AnimeNagatakeInputForm {

	/** ID */
	private int id;

	/** アニメタイトル */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255)
	private String animeTitle;

	/** ジャンルID */
	private Integer genreId;

	/** スタジオID */
	private Integer studioId;

	/** 公開年 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** 声優ID */
	private Integer voiceactorId;

	/** 出典ID */
	private Integer sourceId;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/** 更新日時 */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param AnimeMainNagatake
	 * */
	public void initWithAnimeMainNagatake(AnimeMainNagatake animeMainNagatake) {
		this.setId((int) animeMainNagatake.getId());
		this.setAnimeTitle(animeMainNagatake.getAnimeTitle());
		this.setGenreId(animeMainNagatake.getGenreId());
		this.setStudioId(animeMainNagatake.getStudioId());
		this.setReleaseYearStr(String.valueOf(animeMainNagatake.getReleaseYear()));
		this.setVoiceactorId(animeMainNagatake.getVoiceactorId());
		this.setSourceId(animeMainNagatake.getSourceId());
		this.setComment(animeMainNagatake.getComment());
		this.setUpdateDate(String.valueOf(animeMainNagatake.getUpdateDate()));
	}

	/**
	 * AnimeMainNagatakeエンティティに登録値を入れる。
	 *
	 * @return AnimeMainNagatake
	 * */
	public AnimeMainNagatake convertToAnimeMainNagatakeForInsert() {
		AnimeMainNagatake animeMainNagatake = new AnimeMainNagatake();
		animeMainNagatake = convertToAnimeMainNagatake(animeMainNagatake);
		animeMainNagatake.setCreateDate(new Timestamp(new Date().getTime()));
		animeMainNagatake.setUpdateDate(animeMainNagatake.getCreateDate());
		return animeMainNagatake;
	}

	/**
	 * AnimeMainNagatakeエンティティに更新値を入れる。
	 *
	 * @param AnimeMainNagatake animeMainNagatake
	 * @return AnimeMainNagatake
	 * */
	public AnimeMainNagatake convertToAnimeMainNagatakeForUpdate(AnimeMainNagatake animeMainNagatake) {
		animeMainNagatake = convertToAnimeMainNagatake(animeMainNagatake);
		animeMainNagatake.setUpdateDate(new Timestamp(new Date().getTime()));
		return animeMainNagatake;
	}

	/**
	 * AnimeMainNagatakeエンティティに入力値を入れる。
	 *
	 * @param AnimeMainNagatake animeMainNagatake
	 * @return AnimeMainNagatake
	 * */
	private AnimeMainNagatake convertToAnimeMainNagatake(AnimeMainNagatake animeMainNagatake) {
		animeMainNagatake.setAnimeTitle(this.animeTitle);
		if(this.genreId == CommonConst.NOT_ENTERD) {

			//ジャンルが入力されていなかった場合
			animeMainNagatake.setGenreId(null);
		}else {

			//ジャンルが入力されている場合
			animeMainNagatake.setGenreId(this.genreId);
		}

		if(this.studioId == CommonConst.NOT_ENTERD) {

			//スタジオが入力されていなかった場合
			animeMainNagatake.setStudioId(null);
		}else {

			//スタジオが入力されていた場合
			animeMainNagatake.setStudioId(this.studioId);
		}


		animeMainNagatake.setReleaseYear(Integer.parseInt(this.releaseYearStr));

		if(this.voiceactorId == CommonConst.NOT_ENTERD) {

			//声優が入力されていなかった場合
			animeMainNagatake.setVoiceactorId(null);
		}else {

			//声優が入力されていた場合
			animeMainNagatake.setVoiceactorId(this.voiceactorId);
		}

		if(this.sourceId == CommonConst.NOT_ENTERD) {

			//出典が入力されていなかった場合
			animeMainNagatake.setSourceId(null);
		}else {

			//出典が入力されていた場合
			animeMainNagatake.setSourceId(this.sourceId);
		}

		animeMainNagatake.setComment(this.comment);
		animeMainNagatake.setDelFlg("0");
		return animeMainNagatake;
	}

}