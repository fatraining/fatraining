package jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei;

import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.MusicalCompositionMainTakei;
import lombok.Data;

/**
 * 楽曲検索画面のFormクラス
 *
 * @author takei
 */
@Data
public class MusicalCompositionSearchMainForm {

	/**ID*/
	private Integer id;

	/**曲名*/
	private String title;

	/**ジャンルID*/
	private Integer genreId;

	/**アルバムID*/
	private Integer albumId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param MusicalCompositionMainTakei
	 */
	public void setValues(MusicalCompositionMainTakei musicalCompositionMainTakei) {
		this.setId((int) musicalCompositionMainTakei.getId());
		this.setTitle(musicalCompositionMainTakei.getTitle());
		this.setGenreId(musicalCompositionMainTakei.getGenreId());
		this.setAlbumId(musicalCompositionMainTakei.getAlbumId());
	}
}
