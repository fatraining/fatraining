package jp.co.futureantiques.webapptraining.model.form.novelOkudaira;

import jp.co.futureantiques.webapptraining.model.novelOkudaira.NovelMainOkudaira;
import lombok.Data;

/**
 * 小説検索画面のFormクラス
 *
 * @author future
 */
@Data
public class NovelOkudairaSearchForm {

	/** ID */
	private Integer id;

	/** 作品名 */
	private String novelTitle;

	/** ジャンルID */
	private Integer genreId;

	/** 作者ID */
	private Integer writerId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param novelMainOkudaira
	 */
	public void setValues(NovelMainOkudaira novelMainOkudaira) {
		this.setId((int) novelMainOkudaira.getId());
		this.setNovelTitle(novelMainOkudaira.getNovelTitle());
		this.setGenreId(novelMainOkudaira.getGenreId());
		this.setWriterId(novelMainOkudaira.getWriterId());
	}
}
