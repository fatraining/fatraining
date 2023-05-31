package jp.co.futureantiques.webapptraining.model.form.monsterShirase;

import jp.co.futureantiques.webapptraining.model.monsterShirase.MonsterMainShirase;
import lombok.Data;

/**
 * モンスター検索画面用のFormクラス
 * @author Shirase
 */

@Data
public class MonsterShiraseSearchForm {

	/** モンスター名 */
	private String name;

	/** ジャンルID */
	private Integer genreId;

	/** 素材名 */
	private String material;

	/** 初登場作品ID */
	private Integer titleId;

	/** モンスターID */
	private Integer id;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 * @param monsterMainShirase
	 */

	public void setValues(MonsterMainShirase monsterMainShirase) {
		this.setName(monsterMainShirase.getName());
		this.setGenreId(monsterMainShirase.getGenreId());
		this.setMaterial(monsterMainShirase.getMaterial());
		this.setTitleId(monsterMainShirase.getTitleId());
		this.setId((int) monsterMainShirase.getId());
	}

}
