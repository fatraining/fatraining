package jp.co.futureantiques.webapptraining.model.form.mangaKawada;

import jp.co.futureantiques.webapptraining.model.mangaKawada.MangaMainKawada;
import lombok.Data;

/**
 * 漫画検索画面のFormクラス
 *
 * @author kawada
 */
@Data
public class MangaKawadaSearchForm {

	/** 漫画ID */
	private Integer id;

	/** 漫画タイトル */
	private String mangaTitle;

	/** ジャンルID */
	private Integer genreId;

	/** アニメ化ID */
	private Integer animeId;

	/** 連載状況ID */
	private Integer situationId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param mangaMainKawada
	 */
	public void setValues(MangaMainKawada mangaMainKawada) {
		this.setId((int) mangaMainKawada.getId());
		this.setMangaTitle(mangaMainKawada.getMangaTitle());
		this.setGenreId(mangaMainKawada.getGenreId());
		this.setAnimeId(mangaMainKawada.getAnimeId());
		this.setSituationId(mangaMainKawada.getSituationId());
	}
}