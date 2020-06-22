package jp.co.futureantiques.webapptraining.model.form.proteinUeno;

import javax.validation.constraints.Size;

import jp.co.futureantiques.webapptraining.model.proteinUeno.ProteinMainUeno;
import lombok.Data;

	@Data
	public class ProteinUenoSearchForm {

		/**ID**/
		private Integer id;

		/**フレーバー**/
		@Size(min = 0, max = 256, message = "protein.text.error.size.max")
		private String flavor;

		/**種類ID**/
		private Integer kindId;

		/**メーカーID**/
		private Integer makerId;

		/** 評価 */
		@Size(min = 0, max = 11, message = "protein.text.error.size.max")
		private Integer review;

		/**削除フラグON用**/
		private int isDelete;

		/**
		 * 各フィールドに値を設定する
		 *
		 * @param proteinMainUeno
		 */
		public void setValues(ProteinMainUeno proteinMain ){
			this.setId((int) proteinMain.getId());
			this.setFlavor(proteinMain.getFlavor());
			this.setKindId(proteinMain.getKindId());
			this.setMakerId(proteinMain.getMakerId());
			this.setReview(proteinMain.getReview());
		}
}
