package jp.co.futureantiques.webapptraining.model.form.doramasample;

import jp.co.futureantiques.webapptraining.model.moviesample.MovieMain;
import lombok.Data;

/**
 * ドラマ検索画面のFormクラス
 *
 * @author hiraoka
 */
@Data
public class DoramaSampleSearchForm {

	/** ID */
	private Integer id;

	/** ドラマタイトル */
	private String doramaTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 放送局ID */
	private Integer tvStationId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param doramaMain
	 */
	public void setValues(MovieMain movieMain) {
		this.setId((int) movieMain.getId());
		this.setDoramaTitle(movieMain.getMovieTitle());
		this.setGenreId(movieMain.getGenreId());
		this.setTvStationId(movieMain.getActorId());
	}
}
