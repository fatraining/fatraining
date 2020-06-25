package jp.co.futureantiques.webapptraining.model.form.disneyIto;

import javax.validation.constraints.Size;

import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyMainIto;
import lombok.Data;

/**
 * ディズニーアトラクション検索画面のFormクラス
 *
 * @author Ayaka Ito
 */
@Data
public class DisneyItoSearchForm {

	/** ID */
	private Integer id;

	/** アトラクション名 */
	@Size(max = 256, message = "disney.text.error.countover")
	private String attractionName;

	/** パークID */
	private Integer parkId;

	/** エリアID */
	private Integer areaId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param DisneyMainIto disneyMainIto
	 */
	public void setValues(DisneyMainIto disneyMainIto) {
		this.setId((int) disneyMainIto.getId());
		this.setAttractionName(disneyMainIto.getAttractionName());
		this.setParkId(disneyMainIto.getParkId());
		this.setAreaId(disneyMainIto.getAreaId());
	}
}
