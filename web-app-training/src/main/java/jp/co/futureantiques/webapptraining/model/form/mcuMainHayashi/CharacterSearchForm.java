package jp.co.futureantiques.webapptraining.model.form.mcuMainHayashi;

import jp.co.futureantiques.webapptraining.model.mcuHayashi.McuMainHayashi;
import lombok.Data;

/**
 * キャラクター検索画面のFormクラス
 *
 * @author 林 重樹
 */
@Data
public class CharacterSearchForm {

	/** ID */
	private Integer id;

	/** キャラクター名 */
	private String characterName;

	/** 人種ID */
	private Integer typeId;

	/** 性別ID */
	private Integer sexId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param mcuMainHayashi
	 */
	public void setValues(McuMainHayashi McuMainHayashi) {
		this.setId((int) McuMainHayashi.getId());
		this.setCharacterName(McuMainHayashi.getCharacterName());
		this.setTypeId(McuMainHayashi.getTypeId());
		this.setSexId(McuMainHayashi.getSexId());
	}
}
