package jp.co.futureantiques.webapptraining.model.form.alcoholishida;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import jp.co.futureantiques.webapptraining.model.alcoholishida.AlcoholMainIshida;
import lombok.Data;

/**
 * お酒登録・更新画面用のFormクラス
 *
 * @author t.ishida
 */
@Data
public class AlcoholIshidaInputForm {

	/**お酒ID*/
	private int id;

	/**お酒名*/
	@NotBlank(message = "common.text.error.require")
	@Size(max = 255,message = "alcohol.text.error.countover")
	private String alcoholName;

	/**リキュールID*/
	@NotNull(message = "common.text.error.require")
	private Integer liqueurId;

	/**材料ID1*/
	@NotNull(message = "common.text.error.require")
	private Integer ingredientId1;

	/**材料ID2*/
	private Integer ingredientId2;

	/**材料ID3*/
	private Integer ingredientId3;

	/** コメント */
	@Size(max = 255)
	private String comment;

	/**更新日時(排他制御用)*/
	private String updateDate;

	/**
	 *フィールドにエンティティの中身を入れる
	 *
	 * @param alcoholMainIshida
	 */
	public void initWithAlcoholMainIshida(AlcoholMainIshida alcoholMainIshida) {
		this.setId((int) alcoholMainIshida.getId());
		this.setAlcoholName(alcoholMainIshida.getAlcoholName());
		this.setLiqueurId(alcoholMainIshida.getLiqueurId());
		this.setIngredientId1(alcoholMainIshida.getIngredientId1());
		this.setIngredientId2(alcoholMainIshida.getIngredientId2());
		this.setIngredientId3(alcoholMainIshida.getIngredientId3());
		this.setComment(alcoholMainIshida.getComment());
		this.setUpdateDate(String.valueOf(alcoholMainIshida.getUpdateDate()));
	}

	/**
	 * AlcoholMainエンティティに登録値を入れる
	 *
	 * @param AlcoholMainIshida alcoholIshida
	 * @return alcoholIshida
	 */
	public AlcoholMainIshida convertToAlcoholMainIshidaForInsert() {
		AlcoholMainIshida alcoholMainIshida = new AlcoholMainIshida();
		alcoholMainIshida = convertToAlcoholMainIshida(alcoholMainIshida);
		alcoholMainIshida.setCreateDate(new Timestamp(new Date().getTime()));
		alcoholMainIshida.setUpdateDate(alcoholMainIshida.getCreateDate());
		return alcoholMainIshida;
	}

	/**
	 *AlcoholMainIshidaエンティティに更新値を入れる
	 *
	 * @param AlcoholMainIshida alcoholMainIshida
	 * @return AlcoholMainIshida
	 */
	public AlcoholMainIshida convertToAlcoholMainIshidaForUpdate(AlcoholMainIshida alcoholMainIshida) {
		alcoholMainIshida = convertToAlcoholMainIshida(alcoholMainIshida);
		alcoholMainIshida.setUpdateDate(new Timestamp(new Date().getTime()));
		return alcoholMainIshida;
	}

	/**
	 *AlcoholMainIshidaエンティティに入力値を入れる
	 *
	 *@param AlcoholMainIshida alcoholMainIshida
	 *@param AlcoholMainIshida
	 */
	private AlcoholMainIshida convertToAlcoholMainIshida(AlcoholMainIshida alcoholMainIshida) {
		alcoholMainIshida.setAlcoholName(this.alcoholName);
		alcoholMainIshida.setLiqueurId(this.liqueurId);
		alcoholMainIshida.setIngredientId1(this.ingredientId1);
		alcoholMainIshida.setIngredientId2(this.ingredientId2);
		alcoholMainIshida.setIngredientId3(this.ingredientId3);
		alcoholMainIshida.setComment(this.comment);
		alcoholMainIshida.setDelFlg("0");
		return alcoholMainIshida;
	}
}