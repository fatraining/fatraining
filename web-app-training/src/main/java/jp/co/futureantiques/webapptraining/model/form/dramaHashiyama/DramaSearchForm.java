package jp.co.futureantiques.webapptraining.model.form.dramaHashiyama;


import jp.co.futureantiques.webapptraining.model.dramaHashiyama.DramaMainHashiyama;
import lombok.Data;

/**
 * 検索画面のFormクラス
 *
 * @author hashiyama
 */
@Data
	public class DramaSearchForm {

	/** ID */
	private Integer id;

	/** ドラマ名*/
	private String dramaTitle;

	/**主演ID */
	private Integer actorId;

	/** テレビ局ID */
	private Integer channelId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param dramaMainHashiyama
	 */
	public void setValues(DramaMainHashiyama dramaMainHashiyama) {
		this.setId((int) dramaMainHashiyama.getId());
		this.setDramaTitle(dramaMainHashiyama.getDramaTitle());
		this.setActorId(dramaMainHashiyama.getActorId());
		this.setChannelId(dramaMainHashiyama.getChannelId());

	}
}

