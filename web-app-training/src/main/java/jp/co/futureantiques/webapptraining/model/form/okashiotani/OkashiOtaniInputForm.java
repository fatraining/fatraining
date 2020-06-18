package jp.co.futureantiques.webapptraining.model.form.okashiotani;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.okashiotani.OkashiMainOtani;
import lombok.Data;

/**
* お菓子追加画面のFormクラス
*
* @author future
*/
@Data
public class OkashiOtaniInputForm {

	/** ID */
	private int id;

	/** お菓子名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256, message="okashi.text.error.size.max")
	private String okashiName;

	/** 種類ID */
	private Integer typeId;

	/** メーカーID */
	private Integer makerId;

	/** 更新日時（排他制御用） */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param okashiMainOtani
	 */
	public void initWithOkashiMain(OkashiMainOtani okashiMainOtani) {
		this.setId((int) okashiMainOtani.getId());
		this.setOkashiName(okashiMainOtani.getOkashiName());
		this.setTypeId(okashiMainOtani.getTypeId());
		this.setMakerId(okashiMainOtani.getMakerId());
		this.setUpdateDate(String.valueOf(okashiMainOtani.getUpdateDate()));
	}

	/**
	 * OkashiMainエンティティに登録値を入れる
	 *
	 * @return OkashiMain
	 */
	public OkashiMainOtani convertToOkashiMainForInsert() {
		OkashiMainOtani okashiMainOtani = new OkashiMainOtani();
		okashiMainOtani = convertToOkashiMain(okashiMainOtani);
		okashiMainOtani.setCreateDate(new Timestamp(new Date().getTime()));
		okashiMainOtani.setUpdateDate(okashiMainOtani.getCreateDate());
		return okashiMainOtani;
	}

	/**
	 * OkashiMainエンティティに更新値を入れる
	 *
	 * @param OkashiMainOtani okashiMainOtani
	 * @return OkashiMainOtani
	 */
	public OkashiMainOtani convertToOkashiMainForUpdate(OkashiMainOtani okashiMainOtani) {
		okashiMainOtani = convertToOkashiMain(okashiMainOtani);
		okashiMainOtani.setUpdateDate(new Timestamp(new Date().getTime()));
		return okashiMainOtani;
	}

	/**
	 * OkashiMainエンティティに入力値を入れる
	 *
	 * @param OkashiMainOtani okashiMainOtani
	 * @return OkashiMainOtani
	 */
	private OkashiMainOtani convertToOkashiMain(OkashiMainOtani okashiMainOtani) {
		okashiMainOtani.setOkashiName(this.okashiName);
		if(this.typeId == CommonConst.NOT_ENTERD) {

			// 種類が入力されていなかった場合
			okashiMainOtani.setTypeId(null);
		}else {

			// 種類が入力されていた場合
			okashiMainOtani.setTypeId(this.typeId);
		}
		if(this.makerId == CommonConst.NOT_ENTERD) {

			// メーカーが入力されていなかった場合
			okashiMainOtani.setMakerId(null);
		}else {

			// メーカーが入力されていた場合
			okashiMainOtani.setMakerId(this.makerId);
		}
		okashiMainOtani.setDelFlg("0");
		return okashiMainOtani;
	}
}
