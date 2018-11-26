package jp.co.futureantiques.webapptraining.model.from.musicalcomposition.takei;

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


	public void setValues(MusicalCompositionMainTakei musicalCompositionSearchMain) {
		this.setId((int) musicalCompositionSearchMain.getId());
		this.setTitle(musicalCompositionSearchMain.getTitle());
		this.setGenreId(musicalCompositionSearchMain.getGenreId());
		this.setAlbumId(musicalCompositionSearchMain.getAlbumId());

	}

}
