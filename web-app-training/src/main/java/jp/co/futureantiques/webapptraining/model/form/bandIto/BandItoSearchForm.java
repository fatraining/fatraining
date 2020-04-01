package jp.co.futureantiques.webapptraining.model.form.bandIto;

import jp.co.futureantiques.webapptraining.model.bandIto.BandMainIto;
import lombok.Data;

/**
 * 映画検索画面のFormクラス
 *
 * @author future
 */
@Data
public class BandItoSearchForm {

	/** ID */
	private Integer id;

	/** バンド名 */
	private String bandName;

	/** ボーカル性別ID */
	private Integer sexId;

	/** 出身地ID */
	private Integer areaId;

	/** 削除フラグON用 */
	private int isDelete;

	/**
	 * 各フィールドに値を設定する
	 *
	 * @param bandMainIto
	 */
	public void setValues(BandMainIto bandMainIto) {
		this.setId((int) bandMainIto.getId());
		this.setBandName(bandMainIto.getBandName());
		this.setSexId(bandMainIto.getSexId());
		this.setAreaId(bandMainIto.getAreaId());

	}
}
