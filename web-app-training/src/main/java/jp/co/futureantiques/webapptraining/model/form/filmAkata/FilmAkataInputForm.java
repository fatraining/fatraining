package jp.co.futureantiques.webapptraining.model.form.filmAkata;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.filmAkata.FilmMainAkata;
import lombok.Data;

/**
 * フィルモグラフィー登録・更新画面用のFormクラス
 *
 * @author future
 */
@Data
public class FilmAkataInputForm {

	/** ID */
	private int id;

	/** タイトル */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 100)
	private String filmTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 主演ID */
	private Integer actorId;

	/** 公開年 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String releaseYearStr;

	/** 上映時間　*/
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String runTimeStr;

	/** おすすめ度 */
	@Size(max = 10)
	private String recommend;

	/** 更新日時 （排他制御用）*/
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param filmMainAkata
	 */
	public void initWithFilmMainAkata(FilmMainAkata filmMainAkata) {
		this.setId((int) filmMainAkata.getId());
		this.setFilmTitle(filmMainAkata.getFilmTitle());
		this.setGenreId(filmMainAkata.getGenreId());
		this.setActorId(filmMainAkata.getActorId());
		this.setReleaseYearStr(String.valueOf(filmMainAkata.getReleaseYear()));
		if (filmMainAkata.getRunTime() != null) {
			this.setRunTimeStr(String.valueOf(filmMainAkata.getRunTime()));
		}
		this.setRecommend(filmMainAkata.getRecommend());
		this.setUpdateDate(String.valueOf(filmMainAkata.getUpdateDate()));
	}

	/**
	 * FilmMainAkataエンティティに登録値を入れる
	 *
	 * @return FilmMainAkata
	 */
	public FilmMainAkata convertToFilmMainAkataForInsert() {
		FilmMainAkata filmMainAkata = new FilmMainAkata();
		filmMainAkata = convertToFilmMainAkata(filmMainAkata);
		filmMainAkata.setCreateDate(new Timestamp(new Date().getTime()));
		filmMainAkata.setUpdateDate(filmMainAkata.getCreateDate());
		return filmMainAkata;
	}

	/**
	 * FilmMainAkataエンティティに更新値を入れる
	 *
	 * @param FilmMainAkata filmMainAkata
	 * @return FilmMainAkata
	 */
	public FilmMainAkata convertToFilmMainAkataForUpdate(FilmMainAkata filmMainAkata) {
		filmMainAkata = convertToFilmMainAkata(filmMainAkata);
		filmMainAkata.setUpdateDate(new Timestamp(new Date().getTime()));
		return filmMainAkata;
	}

	/**
	 * FilmMainAkataエンティティに入力値を入れる
	 *
	 * @param FilmMainAkata filmMainAkata
	 * @return FilmMainAkata
	 */
	private FilmMainAkata convertToFilmMainAkata(FilmMainAkata filmMainAkata) {
		filmMainAkata.setFilmTitle(this.filmTitle);
		if (this.genreId == CommonConst.NOT_ENTERD) {

			//ジャンルが入力されていなかった場合
			filmMainAkata.setGenreId(null);
		} else {

			//ジャンルが入力されていた場合
			filmMainAkata.setGenreId(this.genreId);
		}
		if (this.actorId == CommonConst.NOT_ENTERD) {

			//主演が入力されていなかった場合
			filmMainAkata.setActorId(null);
		} else {

			//主演が入力されていた場合
			filmMainAkata.setActorId(this.actorId);
		}
		filmMainAkata.setReleaseYear(Integer.parseInt(this.releaseYearStr));
		if (!this.runTimeStr.isEmpty()) {

			//上映時間が入力されていた場合
			filmMainAkata.setRunTime(Integer.parseInt(this.runTimeStr));
		} else {

			//上映時間が入力されていなかった場合
			filmMainAkata.setRunTime(null);
		}
		filmMainAkata.setRecommend(this.recommend);
		filmMainAkata.setDelFlg("0");
		return filmMainAkata;

	}

}