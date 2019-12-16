package jp.co.futureantiques.webapptraining.model.form.filmAkata;

import jp.co.futureantiques.webapptraining.model.filmAkata.FilmMainAkata;
import lombok.Data;

/*
 * フィルモグラフィー検索画面のFormクラス
 *
 * @author future
 */
@Data
public class FilmAkataSearchForm {
	/** ID */
	private Integer id;

	/** タイトル */
	private String filmTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 主演ID */
	private Integer actorId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param filmMainAkata
	 */
	public void setValues(FilmMainAkata filmMainAkata) {
		this.setId((int) filmMainAkata.getId());
		this.setFilmTitle(filmMainAkata.getFilmTitle());
		this.setGenreId(filmMainAkata.getGenreId());
		this.setActorId(filmMainAkata.getActorId());

	}
}
