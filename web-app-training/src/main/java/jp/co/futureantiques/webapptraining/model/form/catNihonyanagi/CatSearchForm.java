package jp.co.futureantiques.webapptraining.model.form.catNihonyanagi;

import jp.co.futureantiques.webapptraining.model.catNihonyanagi.CatMainNihonyanagi;
import lombok.Data;

/**
 * ネコ検索画面のFormクラス
 * @author Nihonyanagi
 *
 */
@Data
public class CatSearchForm {

	/** ID */
	private Integer id;

	/** ネコ名前 */
	private String catName;

	/** 被毛ID */
	private Integer hairId;

	/** 大きさID */
	private Integer sizeId;

	/** 性格ID */
	private Integer characterId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 	各フィールドに値を設定する
	 *
	 * 	@param CatMainNihonyanagi
	 */
	public void setValues(CatMainNihonyanagi catMainNihonyanagi) {
		this.setId((int) catMainNihonyanagi.getId());
		this.setCatName(catMainNihonyanagi.getCatName());
		this.setHairId(catMainNihonyanagi.getHairId());
		this.setSizeId(catMainNihonyanagi.getSizeId());
		this.setCharacterId(catMainNihonyanagi.getCharacterId());
	}

}
