package jp.co.futureantiques.webapptraining.model.form.riderSaito;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.riderSaito.RiderMainSaito;
import lombok.Data;

/**
 * 仮面ライダー登録、更新画面用のFormクラス
 *
 * @author future
 * */
@Data
public class RiderSaitoInputForm {

	/** 仮面ライダーID */
	private int riderId;

	/** 仮面ライダー名 */
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String riderName;

	/** 年代ID */
	private Integer ageId;

	/** 俳優 */
	@Size(max = 256)
	private String actor;

	/** セリフ */
	@Size(max = 256)
	private String serif;

	/** 更新日時 */
	private String updateDate;

	/**
	 * フィールドにエンティティの中身を入れる
	 *
	 * @param RiderMianSaito
	 * */
	public void initWithRiderMainSaito(RiderMainSaito riderMainSaito) {
		this.setRiderId((int) riderMainSaito.getRiderId());
		this.setRiderName(riderMainSaito.getRiderName());
		this.setAgeId(riderMainSaito.getAgeId());
		this.setActor(riderMainSaito.getActor());
		this.setSerif(riderMainSaito.getSerif());
		this.setUpdateDate(String.valueOf(riderMainSaito.getUpdateDate()));
	}

	/**
	 * RiderMainSaitoエンティティに登録値を入れる。
	 *
	 * @return RiderMainSaito
	 * */
	public RiderMainSaito convertToRiderMainSaitoForInsert() {
		RiderMainSaito riderMainSaito = new RiderMainSaito();
		riderMainSaito = convertToRiderMainSaito(riderMainSaito);
		riderMainSaito.setCreateDate(new Timestamp(new Date().getTime()));
		riderMainSaito.setUpdateDate(riderMainSaito.getCreateDate());
		return riderMainSaito;
	}

	/**
	 * RiderMainSaitoエンティティに更新値を入れる。
	 *
	 * @param RiderMianSaito riderMainSaito
	 * @return RiderMainSaito
	 * */
	public RiderMainSaito convertToRiderMainSaitoForUpdate(RiderMainSaito riderMainSaito) {
		riderMainSaito = convertToRiderMainSaito(riderMainSaito);
		riderMainSaito.setUpdateDate(new Timestamp(new Date().getTime()));
		return riderMainSaito;
	}

	/**
	 * RiderMainSaitoエンティティに入力値を入れる。
	 *
	 * @param RiderMianSaito riderMainSaito
	 * @return RiderMainSaito
	 * */
	private RiderMainSaito convertToRiderMainSaito(RiderMainSaito riderMainSaito) {
		riderMainSaito.setRiderName(this.riderName);
		if(this.ageId == CommonConst.NOT_ENTERD) {

			//年代が入力されていなかった場合
			riderMainSaito.setAgeId(null);
		}else {

			//年代が入力されている場合
			riderMainSaito.setAgeId(this.ageId);
		}
		riderMainSaito.setActor(this.actor);
		riderMainSaito.setSerif(this.serif);
		riderMainSaito.setDelFlg("0");
		return riderMainSaito;
	}

}