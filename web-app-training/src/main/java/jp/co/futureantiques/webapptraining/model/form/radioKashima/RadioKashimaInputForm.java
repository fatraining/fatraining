package jp.co.futureantiques.webapptraining.model.form.radioKashima;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.radioKashima.RadioMainKashima;
import lombok.Data;

/**
 * Radio追加画面のFormクラス
* @author  kashima
*/
@Data
public class RadioKashimaInputForm {

	/**ID**/
	private int id;

	/**ラジオ番組名**/
	@NotNull(message = "common.text.error.require")
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255, message="radio.text.error.size.max")
	private String programName;

	/**パーソナリティ**/
	@NotNull(message = "common.text.error.require")
	@NotBlank(message = "common.text.error.require")
	@Size( max = 255, message = "common.text.error.size.max")
	private String personality;

	/** 放送期間**/
	@Size(max = 255, message="radio.text.error.size.max")
	private String broadcastPeriod;

	/**放送局ID**/
	private Integer keystationId;

	/** コメント**/
	@Size(max = 255, message="radio.text.error.size.max")
	private String comment;

	/**更新日時**/
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 * @param radioMainKashima
	 * **/
	public void iniWithradioMainKashima(RadioMainKashima radioMainKashima) {
		this.setId((int) radioMainKashima.getId());
		this.setProgramName(radioMainKashima.getProgramName());
		this.setPersonality(radioMainKashima.getPersonality());
		this.setBroadcastPeriod(radioMainKashima.getBroadcastPeriod());
		this.setKeystationId(radioMainKashima.getKeystationId());
		this.setComment(radioMainKashima.getComment());

		this.setUpdateDate(String.valueOf(radioMainKashima.getUpdateDate()));
	}

	/**
	 * RadioMainエンティティに登録値を入れる
	 *
	 * @return RadioMainKashima
	 */
	public RadioMainKashima convertToRadioMainForInsert() {
		RadioMainKashima radioMainKashima = new RadioMainKashima();
		radioMainKashima = convertToRadioMain(radioMainKashima);
		radioMainKashima.setCreateDate(new Timestamp(new Date().getTime()));
		radioMainKashima.setUpdateDate(radioMainKashima.getCreateDate());
		return radioMainKashima;
	}

	/**
	 * RadioMainエンティティに更新値を入れる
	 * @param RadioMainKashima radioMainKashima
	 * @return RadioMainKashima
	 */
	public RadioMainKashima convertToRadioMainForUpdate(RadioMainKashima radioMainKashima) {
		radioMainKashima = convertToRadioMain(radioMainKashima);
		radioMainKashima.setUpdateDate(new Timestamp(new Date().getTime()));
		return radioMainKashima;
	}

	/**
	 * RadioMainエンティティに入力値を入れる
	 * @param RadioMainKashima radioMainKashima
	 * @return RadioMainKashima
	 */
	private RadioMainKashima convertToRadioMain(RadioMainKashima radioMainKashima) {
		radioMainKashima.setProgramName(this.programName);
		radioMainKashima.setPersonality(this.personality);
		radioMainKashima.setBroadcastPeriod(this.broadcastPeriod);

		if (this.keystationId == CommonConst.NOT_ENTERD) {
			radioMainKashima.setKeystationId(null);
		} else {
			radioMainKashima.setKeystationId(keystationId);
		}

		radioMainKashima.setComment(this.comment);
		radioMainKashima.setDelFlg("0");

		return radioMainKashima;
	}

}
