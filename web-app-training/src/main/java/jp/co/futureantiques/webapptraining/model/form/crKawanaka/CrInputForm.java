package jp.co.futureantiques.webapptraining.model.form.crKawanaka;


import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import jp.co.futureantiques.webapptraining.model.crKawanaka.CrMainKawanaka;
import lombok.Data;

/*
 * 日本の近絶滅種登録、更新画面用のForm クラス
 * @author Misa toKawanaka
 * */
@Data
public class CrInputForm {

	/*CRID*/
	private int id;

	/*名前*/
	@NotBlank(message="comm.text.error.require")
	@Size(max=256)
	private String name;

	/*画像*/
	private MultipartFile image;

	/*カテゴリーID*/
	private Integer categoryId;

	/*分布ID*/
	private Integer distributionId;

	/*原因*/
	@Size(max=256)
	private String cause;

	/*更新日時(排他制御)*/
	private String updateDate;


	/*
	 * フィールドに中身を入れる
	 * @param CrMainKawanaka crMainKawanaka
	 */
	public void initWithCrMainKawanaka(CrMainKawanaka crMainKawanaka) {
		this.setId((int) crMainKawanaka.getId());
		this.setName(crMainKawanaka.getName());

		this.setCategoryId((int) crMainKawanaka.getCategoryId());
		this.setDistributionId((int) crMainKawanaka.getDistributionId());
		this.setCause(crMainKawanaka.getCause());
		this.setUpdateDate(String.valueOf(crMainKawanaka.getUpdateDate()));
	}

	/*CrMainKawanakaエンティティに登録値を入れる
	 * @return CrMainKawanaka
	 */
	public CrMainKawanaka convertToCrMainKawanakaForInsert() {
		CrMainKawanaka crMainKawanaka=new CrMainKawanaka();
		crMainKawanaka = convertToCrMainKawanaka(crMainKawanaka);
		crMainKawanaka.setCreateDate(new Timestamp(new Date().getTime()));
		crMainKawanaka.setUpdateDate(crMainKawanaka.getCreateDate());
		return crMainKawanaka;
	}

		/*
		 * CrMainKawanakaエンティティい更新値を入れる
		 *@return crMainKawanaka
		 *@param CrMainKawanaka crMainKawanaka
		 */

		public CrMainKawanaka convertToCrMainKawanakaForUpdate(CrMainKawanaka crMainKawanaka) {
			crMainKawanaka = convertToCrMainKawanaka(crMainKawanaka);
			crMainKawanaka.setUpdateDate(crMainKawanaka.getUpdateDate());
			return crMainKawanaka;
		}


	/*
	 * CrMainKawanakaエンティティに入力値を入れる
	 *@return CrMianKawanaka
	 *@param CrMainKawanaka crMainKawanaka
	 */
	public CrMainKawanaka convertToCrMainKawanaka(CrMainKawanaka crMainKawanaka) {
		crMainKawanaka.setName(this.name);
		crMainKawanaka.setCategoryId(this.categoryId);
		crMainKawanaka.setDistributionId(this.distributionId);
		crMainKawanaka.setCause(this.cause);
		crMainKawanaka.setDelFlg("0");
		return crMainKawanaka;
	}

}
