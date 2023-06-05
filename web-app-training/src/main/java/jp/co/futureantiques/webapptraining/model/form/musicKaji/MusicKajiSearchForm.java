package jp.co.futureantiques.webapptraining.model.form.musicKaji;

import jp.co.futureantiques.webapptraining.model.musicKaji.MusicMainKaji;
import lombok.Data;

/**
 * 楽曲検索画面のFormクラス
 * 
 * @author futute
 *
 */
@Data
public class MusicKajiSearchForm {

	/** ID **/
	private Integer id;

	/** 楽曲名 **/
	private String musicTitle;

	/** ユニットID **/
	private Integer unitId;

	/** 作曲者ID **/
	private Integer composerId;

	/** 削除フラグON用 **/
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param musicMainKaji
	 */
	public void setValues(MusicMainKaji musicMainKaji) {
		this.setId((int)musicMainKaji.getId());
		this.setMusicTitle(musicMainKaji.getMusicTitle());
		this.setUnitId(musicMainKaji.getUnitId());
		this.setComposerId(musicMainKaji.getComposerId());
	}
}
