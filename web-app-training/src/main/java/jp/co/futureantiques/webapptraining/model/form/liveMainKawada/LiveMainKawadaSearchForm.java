package jp.co.futureantiques.webapptraining.model.form.liveMainKawada;

import jp.co.futureantiques.webapptraining.model.liveMainKawada.LiveMainKawada;
import lombok.Data;

/**
 * ライブ定番曲検索画面のFormクラス
 * @author future
 *
 */
@Data
public class LiveMainKawadaSearchForm {

	//曲名ID
	private Integer id;

	//収録アルバム
	private Integer albumId;

	//曲名
	private String songTitle;

	//ライブスタイル
	private Integer styleId;

	//削除フラグON用
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 * @param liveMainKawda
	 */
	public void setValues(LiveMainKawada liveMainKawada) {
		this.setId((int) liveMainKawada.getId());
		this.setAlbumId(liveMainKawada.getAlbumId());
		this.setSongTitle(liveMainKawada.getSongTitle());
		this.setStyleId(liveMainKawada.getStyleId());
	}

}
