package jp.co.futureantiques.webapptraining.model.form.riderSaito;

import jp.co.futureantiques.webapptraining.model.riderSaito.RiderMainSaito;
import lombok.Data;

@Data
public class RiderSaitoSearchForm {

		/** 仮面ライダーID */
		private Integer riderId;

		/** 仮面ライダー名 */
		private String riderName;

		/** 年代ID */
		private Integer ageId;

		/** 俳優 */
		private String actor;

		/** 削除フラグON用 */
		private int isDelete;

		/**
		 * 各フィールドに値を設定する
		 *
		 * @param RiderMianSaito
		 * */
		public void setValues(RiderMainSaito riderMainSaito) {
			this.setRiderId((int)riderMainSaito.getRiderId());
			this.setRiderName(riderMainSaito.getRiderName());
			this.setAgeId(riderMainSaito.getAgeId());
			this.setActor(riderMainSaito.getActor());

		}
	}