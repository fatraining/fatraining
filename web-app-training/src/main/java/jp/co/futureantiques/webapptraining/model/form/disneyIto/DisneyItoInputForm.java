package jp.co.futureantiques.webapptraining.model.form.disneyIto;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.disneyIto.DisneyMainIto;
import lombok.Data;

/**
 * ディズニーアトラクション登録・更新画面用のFormクラス
 *
 * @author Ayaka Ito
 */
@Data
public class DisneyItoInputForm {

	/** ID */
	private int id;

	/** アトラクション名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String attractionName;

	/** パークID */
	private Integer parkId;

	/** エリアID */
	private Integer areaId;

	/** 乗車時間 */
	@Size(min = 0, max = 4, message = "common.text.error.size.max.four")
	@Pattern(regexp = "^([+-]?0|[+-]?[1-9][0-9]*)?$", message = "common.text.error.numeric")
	private String timeStr;

	/** コメント */
	@Size(max = 256)
	private String comment;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param DisneyMainIto
	 */
	public void initWithDisneyMainIto(DisneyMainIto disneyMainIto) {
		this.setId((int) disneyMainIto.getId());
		this.setAttractionName(disneyMainIto.getAttractionName());
		this.setParkId(disneyMainIto.getParkId());
		this.setAreaId(disneyMainIto.getAreaId());
		this.setTimeStr(String.valueOf(disneyMainIto.getTime()));
		this.setComment(disneyMainIto.getComment());
		this.setUpdateDate(String.valueOf(disneyMainIto.getUpdateDate()));
	}

	/**
	 * DisneyMainItoエンティティに登録値を入れる
	 * @return DisneyMainIto
	 */
	public DisneyMainIto converToDisneyMainItoForInsert() {
		DisneyMainIto disneyMainIto = new DisneyMainIto();
		disneyMainIto = convertToDisneyMainIto(disneyMainIto);
		disneyMainIto.setCreateDate(new Timestamp(new Date().getTime()));
		disneyMainIto.setUpdateDate(disneyMainIto.getCreateDate());
		return disneyMainIto;
	}

	/**
	 * DisneyMainItoエンティティに更新値を入れる
	 * @param DisneyMainIto disneyMainIto
	 * @return DisneyMainIto
	 */
	public DisneyMainIto convertToDisneyMainItoForUpdate(DisneyMainIto disneyMainIto) {
		disneyMainIto = convertToDisneyMainIto(disneyMainIto);
		disneyMainIto.setUpdateDate(new Timestamp(new Date().getTime()));
		return disneyMainIto;
	}

	/**
	 * disneyMainItoエンティティに入力値を入れる
	 *
	 * @param DisneyMainIto disneyMainIto
	 * @return DisneyMainIto
	 */
	private DisneyMainIto convertToDisneyMainIto(DisneyMainIto disneyMainIto) {
		disneyMainIto.setAttractionName(this.attractionName);
		if (this.parkId == CommonConst.NOT_ENTERD) {

			// パークが入力されていなかった場合
			disneyMainIto.setParkId(null);
		} else {

			// パークが入力されていた場合
			disneyMainIto.setParkId(this.parkId);
		}
		if (this.areaId == CommonConst.NOT_ENTERD) {

			// エリアが入力されていなかった場合
			disneyMainIto.setAreaId(null);
		} else {

			// エリアが入力されていた場合
			disneyMainIto.setAreaId(this.areaId);
		}
		if (!this.timeStr.isEmpty()) {

			//乗車時間が入力されていなかった場合
			disneyMainIto.setTime(Integer.parseInt(this.timeStr));
		} else {

			//乗車時間が入力されていた場合
			disneyMainIto.setTime(null);
		}
		disneyMainIto.setComment(this.comment);
		disneyMainIto.setDelFlg("0");
		return disneyMainIto;
	}
}
