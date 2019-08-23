package jp.co.futureantiques.webapptraining.model.form.saizeriyaKurimoto;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.SaizeriyaMenuMainKurimoto;
import lombok.Data;

/**メニュー登録・更新画面用のFormクラス
*@author Kurimoto*/
@Data
public class SaizeriyaKurimotoInputForm {

	/**ID*/
	private int id;

	/**メニュー名*/
	@NotBlank(message = "common.text.error.require")
	@Size(max = 256)
	private String menuName;

	/**カテゴリID*/
	private Integer categoryId;

	/**価格帯ID*/
	private Integer priceId;

	/**定価*/
	private Integer teika;

	/**カロリー*/
	private Integer calories;

	/**塩分*/
	private Double sodium;

	/**更新日時（排他制御用*/
	private String updateDate;

	/**フィールドにエンティティの中身を入れる
	*@param saizeriyaMenuMainKurimoto*/

	public void initWithSaizeriyaMenuMainKurimoto(SaizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto) {
		this.setId((int) saizeriyaMenuMainKurimoto.getId());
		this.setMenuName(saizeriyaMenuMainKurimoto.getMenuName());
		this.setCategoryId(saizeriyaMenuMainKurimoto.getCategoryId());
		this.setPriceId(saizeriyaMenuMainKurimoto.getPriceId());

//		if (saizeriyaMenuMainKurimoto.getTeika() != null) {
//			this.setTeika(saizeriyaMenuMainKurimoto.getTeika());
//		}
//		if (saizeriyaMenuMainKurimoto.getCalories() != null) {
//			this.setCalories(saizeriyaMenuMainKurimoto.getCalories());
//		}
//		if (saizeriyaMenuMainKurimoto.getSodium() != null) {
//			this.setSodium(saizeriyaMenuMainKurimoto.getSodium());
//		}
		this.setTeika(saizeriyaMenuMainKurimoto.getTeika());
		this.setCalories(saizeriyaMenuMainKurimoto.getCalories());
		this.setSodium(saizeriyaMenuMainKurimoto.getSodium());
		this.setUpdateDate(String.valueOf(saizeriyaMenuMainKurimoto.getUpdateDate()));
	}

	/**saizeriyaMenuMainKurimotoエンティティに登録値を入れる
	*@return saizeriyaMenuMainKurimoto*/

	public SaizeriyaMenuMainKurimoto convertToSaizeriyaMenuMainKurimotoForInsert() {
		SaizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto = new SaizeriyaMenuMainKurimoto();
		saizeriyaMenuMainKurimoto = convertToSaizeriyaMenuMainKurimoto(saizeriyaMenuMainKurimoto);
		saizeriyaMenuMainKurimoto.setCreateDate(new Timestamp(new Date().getTime()));
		saizeriyaMenuMainKurimoto.setUpdateDate(saizeriyaMenuMainKurimoto.getCreateDate());
		return saizeriyaMenuMainKurimoto;
	}

	/**saizeriyaMenuMainKurimotoエンティティに更新値を入れる
	*@param saizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto
	*@return saizeriyaMenuMainKurimoto*/

	public SaizeriyaMenuMainKurimoto convertToSaizeriyaMenuMainKurimotoForUpdate(SaizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto) {
		saizeriyaMenuMainKurimoto = convertToSaizeriyaMenuMainKurimoto(saizeriyaMenuMainKurimoto);
		saizeriyaMenuMainKurimoto.setUpdateDate(new Timestamp(new Date().getTime()));
		return saizeriyaMenuMainKurimoto;
	}

	/**saizeriyaMenuMainKurimotoエンティティに入力値を入れる
	*@param saizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto
	*@return saizeriyaMenuMainKurimoto*/

	private SaizeriyaMenuMainKurimoto convertToSaizeriyaMenuMainKurimoto(SaizeriyaMenuMainKurimoto saizeriyaMenuMainKurimoto) {

		/**必須：メニュー名*/
		saizeriyaMenuMainKurimoto.setMenuName(this.menuName);


		/**カテゴリ*/
		if(this.categoryId !=0) {
			saizeriyaMenuMainKurimoto.setCategoryId(this.categoryId);
		}else {
			saizeriyaMenuMainKurimoto.setCategoryId(null);
		}

		/**価格帯*/
		if(this.priceId !=0) {
			saizeriyaMenuMainKurimoto.setPriceId(this.priceId);
		}else {
			saizeriyaMenuMainKurimoto.setPriceId(null);
		}

		/**定価*/
		if(this.teika != null) {
			saizeriyaMenuMainKurimoto.setTeika(this.teika);
		}else {
			saizeriyaMenuMainKurimoto.setTeika(null);
		}

		/**カロリー*/
		if(this.calories != null ) {
			saizeriyaMenuMainKurimoto.setCalories(this.calories);
		}else {
			saizeriyaMenuMainKurimoto.setCalories(null);
		}

		/**塩分*/
			if(this.sodium !=null) {
			saizeriyaMenuMainKurimoto.setSodium(this.sodium);
		}else {
			saizeriyaMenuMainKurimoto.setSodium(null);
		}

		/**削除フラグ*/
		saizeriyaMenuMainKurimoto.setDelFlg("0");
		return saizeriyaMenuMainKurimoto;
	}
}
