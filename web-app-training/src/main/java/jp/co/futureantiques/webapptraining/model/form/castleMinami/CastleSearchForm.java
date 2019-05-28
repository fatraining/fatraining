package jp.co.futureantiques.webapptraining.model.form.castleMinami;

import jp.co.futureantiques.webapptraining.model.castleMinami.CastleMainMinami;
import lombok.Data;

/**
 * お城検索画面のFormクラス
 *
 * @author Minami
 *
 */
@Data
public class CastleSearchForm {

	/** ID */
	private Integer id;

	/** お城名前 */
	private String castleName;

	/** 城主 */
	private String cashuName;

	/** 所在地ID */
	private Integer prefectureId;

	/** 築城年 */
	private Integer castleYear;

	/** 天守ID */
	private Integer tenshuId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設置する
	 *
	 * @param CastleMainMinami
	 */
	public void setValues(CastleMainMinami castleMainMinami) {
		this.setId((int) castleMainMinami.getId());
		this.setCastleName(castleMainMinami.getCastleName());
		this.setCashuName(castleMainMinami.getCashuName());
		this.setPrefectureId(castleMainMinami.getPrefectureId());
		this.setCastleYear(castleMainMinami.getCastleYear());
		this.setTenshuId(castleMainMinami.getTenshuId());
	}
}
