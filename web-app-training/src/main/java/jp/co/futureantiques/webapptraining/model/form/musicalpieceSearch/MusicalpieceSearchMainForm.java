package jp.co.futureantiques.webapptraining.model.form.musicalpieceSearch;

import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ArianaMainRuike;
import lombok.Data;

/**
* 楽曲検索のFormクラス
*
* @author future
*/
@Data

public class MusicalpieceSearchMainForm {

	/**ID*/
	private Integer singleId;

	/** シングルタイトル */
	private String singleTitle;

	/** アルバムID */
	private Integer albumId;

	/** コラボアーティストID */
	private Integer colaboId;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param movieMain
	 */
	public void setValues(ArianaMainRuike arianaMainRuike) {
		this.setSingleId((int) arianaMainRuike.getSingleId());
		this.setSingleTitle(arianaMainRuike.getSingleTitle());
		this.setAlbumId(arianaMainRuike.getAlbumId());
		this.setColaboId(arianaMainRuike.getColaboId());

	}
}
