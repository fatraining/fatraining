package jp.co.futureantiques.webapptraining.model.form.musickichise;

import jp.co.futureantiques.webapptraining.model.musickichise.MusicKichiseMain;
import lombok.Data;

/**
 * 検索画面のFormクラス
 * @author future
 */
@Data
public class MusicKichiseSearchForm {

	/** ID */
	private Integer id;

	/** 楽曲名 */
	private String musicTitle;

	/** アーティストID */
	private Integer artistId;

	/** ジャンルID */
	private Integer janruId;

	/** 削除フラグON */
	private int isDelete;

	/**
	 * 各フィールドへの値の設定
	 * @param musicKichiseMain
	 */
	public void setValue(MusicKichiseMain musicKichiseMain) {
		this.setId((int) musicKichiseMain.getId());
		this.setMusicTitle(musicKichiseMain.getMusicTitle());
		this.setArtistId(musicKichiseMain.getArtistId());
		this.setJanruId(musicKichiseMain.getJanruId());
	}

}
